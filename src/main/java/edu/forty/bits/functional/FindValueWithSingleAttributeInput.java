package edu.forty.bits.functional;

import java.util.*;

public class FindValueWithSingleAttributeInput {

    public static void main(String[] args) {
        List<Topic> topics = Arrays.asList(
                new Topic(1, "Java", "Java 1.8"),
                new Topic(2, "Angular", " 1.8"),
                new Topic(3, "Webservices", "REST"),
                new Topic(4, "J2EE", "Web"),
                new Topic(5, "Gwt", "Frontend")
        );

        int id = 4;
        Topic result = topics.stream().filter(t -> t.getKey() == id).findFirst().orElse(new Topic());
    }

    private static class Topic {
        int key;
        String lang;
        String detail;

        public Topic() {
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public Topic(int key, String lang, String detail) {
            this.key = key;
            this.lang = lang;
            this.detail = detail;
        }
    }
}