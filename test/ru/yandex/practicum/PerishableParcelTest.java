package ru.yandex.practicum;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class PerishableParcelTest {

    private static PerishableParcel perishableParcel;

    @BeforeAll
    public static void beforeAll() {
        perishableParcel = new PerishableParcel("abv", 15, "adress", 5, 10);
    }
    @Test
    public void shouldBeExpiredWhenCurrentDay16() {
        assertTrue(perishableParcel.isExpired(16));
    }
    @Test
    public void shouldNotBeExpiredWhenCurrentDay15() {
        assertFalse(perishableParcel.isExpired(15));
    }
    @Test
    public void shouldNotBeExpiredWhenCurrentDay14() {
        assertFalse(perishableParcel.isExpired(14));
    }
}
