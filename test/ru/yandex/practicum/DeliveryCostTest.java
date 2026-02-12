package ru.yandex.practicum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

import java.util.ArrayList;
import java.util.List;

public class DeliveryCostTest {
    private static List<Parcel> allParcels;
    private static StandardParcel standardParcel;
    private static PerishableParcel perishableParcel;
    private static FragileParcel fragileParcel;

    @BeforeAll
    public static void beforeAll() {
        standardParcel = new StandardParcel("asd", 19, "adress", 5);
        fragileParcel = new FragileParcel("asd", 19, "adress", 5);
        perishableParcel = new PerishableParcel("asd", 19, "adress", 5, 5);
    }

    @BeforeEach
    public void beforeEach() {
        allParcels = new ArrayList<>();
    }

    @Test
    public void shouldBe38WhenAddStandardParcel() {
        allParcels.add(standardParcel);
        assertEquals(38, calculateCosts());
    }

    @Test
    public void shouldBe114WhenAddStandardParcelAndFragileParcel() {
        allParcels.add(standardParcel);
        allParcels.add(fragileParcel);
        assertEquals(114, calculateCosts());
    }

    @Test
    public void shouldBe133WhenAddFragileParcelAndPerishableParcel() {
        allParcels.add(fragileParcel);
        allParcels.add(perishableParcel);
        assertEquals(133, calculateCosts());
    }

    private int calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        return totalCost;
    }
}
