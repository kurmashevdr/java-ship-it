package ru.yandex.practicum.delivery;

public class PerishableParcel  extends Parcel {
    private final int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAdress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAdress, sendDay, 3);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return currentDay > timeToLive + sendDay;
    }
}
