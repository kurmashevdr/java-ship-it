package ru.yandex.practicum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

public class ParcelBoxTest {
    private ParcelBox<StandardParcel> parcelBox;
    @BeforeEach
    public void beforeEach() {
        parcelBox = new ParcelBox<>(20);
    }

    @Test
    public void shouldBeAddedWhenWeightIs19() {
        StandardParcel standardParcel = new StandardParcel("asd", 19, "adress", 5);
        parcelBox.addParcel(standardParcel);
        assertEquals(1, parcelBox.getSize());
    }

    @Test
    public void shouldBeAddedWhenWeightIs20() {
        StandardParcel standardParcel = new StandardParcel("asd", 20, "adress", 5);
        parcelBox.addParcel(standardParcel);
        assertEquals(1, parcelBox.getSize());
    }

    @Test
    public void shouldNotBeAddedWhenWeightIs21() {
        StandardParcel standardParcel = new StandardParcel("asd", 21, "adress", 5);
        parcelBox.addParcel(standardParcel);
        assertEquals(0, parcelBox.getSize());
    }
}
