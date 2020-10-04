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
    requires com.google.common;

    exports edu.forty.bits.functional;
    exports edu.forty.bits.process to jdk.internal.ed;
}