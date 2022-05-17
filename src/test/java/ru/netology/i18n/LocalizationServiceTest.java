package ru.netology.i18n;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class LocalizationServiceTest {

    static final LocalizationService service = new LocalizationServiceImpl();

    @Test
    void localTestIfCountryIsRussia() {
        assertEquals("Добро пожаловать", service.locale(Country.RUSSIA));
    }

    @Test
    void localTestIfCountryIsAnother() {
        assertEquals("Welcome", service.locale(Country.USA));
        assertEquals("Welcome", service.locale(Country.BRAZIL));
        assertEquals("Welcome", service.locale(Country.GERMANY));
    }
}
