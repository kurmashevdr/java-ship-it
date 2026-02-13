package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private int currentWeight;
    private final List<T> allParcels;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.allParcels = new ArrayList<>();
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() <= maxWeight) {
            allParcels.add(parcel);
            currentWeight += parcel.getWeight();
        } else  {
            System.out.println("Невозможно добавить посылку: Превышение допустимого веса коробки");
        }
    }

    public List<T> getAllParcels() {
        return allParcels;
    }

    public int getSize() {
        return allParcels.size();
    }
}
