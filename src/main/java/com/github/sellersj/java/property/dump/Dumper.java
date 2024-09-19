package com.github.sellersj.java.property.dump;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class Dumper {

    public static void main(String[] args) {
        // the system properties
        System.out.println("# System Properties");
        Properties properties = System.getProperties();

        LinkedHashMap<String, String> collect = properties.entrySet().stream()
            .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue())).entrySet().stream()
            .sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        collect.forEach((k, v) -> System.out.println(k + ": " + v + "\n"));

        // security stuff
        System.out.println("# Security settings");
        System.out.println("Does use a security manager? : " + (null != System.getSecurityManager()));

        List<String> securityProperties = Arrays.asList("networkaddress.cache.ttl",
            "networkaddress.cache.negative.ttl");

        for (String key : securityProperties) {
            System.out.println(key + ": " + java.security.Security.getProperty(key));
        }
    }

}
