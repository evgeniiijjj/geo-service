package ru.netology.geo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

public class GeoServiceTest {

    public static final String LOCALHOST = "127.0.0.1";
    public static final String MOSCOW_IP = "172.0.32.11";
    public static final String NEW_YORK_IP = "96.44.183.149";
    static final GeoService service = new GeoServiceImpl();

    @Test
    void localizationServiceByIpTestIfIpIsLocalhost() {
        Location location = service.byIp(LOCALHOST);
        assertNull(location.getCity());
        assertNull(location.getCountry());
        assertNull(location.getStreet());
        assertEquals(0, location.getBuiling());
    }

    @Test
    void localizationServiceByIpTestIfIpIsMoscowIp() {
        Location location = service.byIp(MOSCOW_IP);
        assertEquals("Moscow", location.getCity());
        assertEquals(Country.RUSSIA, location.getCountry());
        assertEquals("Lenina", location.getStreet());
        assertEquals(15, location.getBuiling());
    }

    @Test
    void localizationServiceByIpTestIfIpIsNewYorkIp() {
        Location location = service.byIp(NEW_YORK_IP);
        assertEquals("New York", location.getCity());
        assertEquals(Country.USA, location.getCountry());
        assertEquals(" 10th Avenue", location.getStreet());
        assertEquals(32, location.getBuiling());
    }

    @Test
    void localizationServiceByIpTestIfIpStartWith172() {
        Location location = service.byIp("172.156.134.21");
        assertEquals("Moscow", location.getCity());
        assertEquals(Country.RUSSIA, location.getCountry());
        assertNull(location.getStreet());
        assertEquals(0, location.getBuiling());
    }

    @Test
    void localizationServiceByIpTestIfIpStartWith96() {
        Location location = service.byIp("96.156.134.21");
        assertEquals("New York", location.getCity());
        assertEquals(Country.USA, location.getCountry());
        assertNull(location.getStreet());
        assertEquals(0, location.getBuiling());
    }
}
