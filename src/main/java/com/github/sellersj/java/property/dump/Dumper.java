package com.github.sellersj.java.property.dump;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class Dumper {

    public static void main(String[] args) {
        dumpAll();
    }

    public static String dumpAll() {
        StringBuilder b = new StringBuilder();

        // the system properties
        Properties properties = System.getProperties();

        LinkedHashMap<String, String> collect = properties.entrySet().stream()
            .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue())).entrySet().stream()
            .sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        collect.forEach((k, v) -> b.append(k + ":" + v));

        return b.toString();
    }

}
