package demo;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateAPIApplication {
    public static void main(String args[]) {
        // Clock
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);
        // Time zone
        System.out.println(ZoneId.getAvailableZoneIds()); // all available timezone ids

        ZoneId nyc = ZoneId.of("America/New_York");
        System.out.println(nyc.getRules());
        ZoneId la = ZoneId.of("America/Los_Angeles");
        System.out.println(la.getRules());
        
        // LocalTime
        LocalTime t_nyc = LocalTime.now(nyc);
        LocalTime t_la = LocalTime.now(la);
        LocalTime t_boston = LocalTime.now();
        System.out.println("Boston " + t_boston);
        System.out.println("NYC " + t_nyc);
    }
}