package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private int maxWeight;
    private int currentWeight;
    private final ArrayList<T> allParcels = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() <= maxWeight) {
            allParcels.add(parcel);
            currentWeight += parcel.getWeight();
        } else  {
            System.out.println("Невозможно добавить посылку: Превышение допустимого веса коробки");
        }
    }

    public void getAllParcels() {
        for (T parcel : allParcels) {
            System.out.println(parcel.getDescription());
        }
    }

    public int getSize() {
        return allParcels.size();
    }
}
