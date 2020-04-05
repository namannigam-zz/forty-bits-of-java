module forty.bits.of.java {
    requires java.net.http;
    requires java.logging;
    requires java.desktop;
    requires java.sql;

    requires jdk.unsupported;
    requires jdk.jshell;
    requires jdk.management;
    requires jdk.jlink;

    requires lombok;

    requires jol.core;

    exports edu.forty.bits.functional;
    exports edu.forty.bits.process to jdk.internal.ed;
//    requires org.apache.commons.lang3;
//    requires com.fasterxml.jackson.core;
//    requires com.fasterxml.jackson.databind;
//    requires com.google.common;
//    requires com.google.guice;
//    requires jsr305;
//    requires json.simple;
//    requires org.json;
//    requires mongo.java.driver;
}