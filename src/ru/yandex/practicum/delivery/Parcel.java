package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected final String description;
    protected final int weight;
    protected final String deliveryAdress;
    protected final int sendDay;
    protected final int baseRate;

    protected Parcel(String description, int weight, String deliveryAdress, int sendDay, int baseRate) {
        this.description = description;
        this.weight = weight;
        this.deliveryAdress = deliveryAdress;
        this.sendDay = sendDay;
        this.baseRate = baseRate;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAdress);
    }

    public int calculateDeliveryCost() {
        return baseRate * weight;
    }
}
