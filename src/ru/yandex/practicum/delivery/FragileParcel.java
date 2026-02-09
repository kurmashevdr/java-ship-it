package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel {
    public FragileParcel(String description, int weight, String deliveryAdress, int sendDay) {
        super(description, weight, deliveryAdress, sendDay, 4);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        super.packageItem();
    }
}
