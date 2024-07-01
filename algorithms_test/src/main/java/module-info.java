module Stream {
    requires java.net.http;
    requires java.logging;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires spring.context;
    requires spring.web;
    exports com.example.basic;
    exports com.example.basic.lesson17.example.module;
    opens com.example.basic.lesson17.example.module;
    exports com.example.basic.lesson17.example.api;
    uses com.example.basic.lesson17.example.api.PlayerProvider;
    provides com.example.basic.lesson17.example.api.PlayerProvider with com.example.basic.lesson17.example.api.impl.ConsolePlayerProvider;
}
