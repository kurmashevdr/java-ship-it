package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    public StandardParcel(String description, int weight, String deliveryAdress, int sendDay) {
        super(description, weight, deliveryAdress, sendDay, 2);
    }
}
