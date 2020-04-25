package edu.forty.bits.utilities;

import lombok.Getter;
//import org.springframework.web.client.RestTemplate;

public class GetSample {
    private static final String URL = "https://stackoverflow.com/";

    public static void main(String[] args) {
//        RestTemplate restTemplate = new RestTemplate();
//        TimezonePage response = restTemplate.getForObject(URL, TimezonePage.class);
//        System.out.println("PDT".equals(response.getAbbreviation()));
//        System.out.println(response.isDst());
//
//        TimeZoneRec responseRec = restTemplate.getForObject(URL, TimeZoneRec.class);
//        System.out.println("PDT".equals(responseRec.abbreviation()));
//        System.out.println(responseRec.dst());
    }

    @Getter
    class TimezonePage {
        String abbreviation;
        boolean dst;
    }

    record TimeZoneRec(String abbreviation, boolean dst) {
    }
}