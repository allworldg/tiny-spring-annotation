package com.example.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassScanner {
    private final List<String> list = new ArrayList<>();

    public List<String> doScan(String packageName) {
        String packagePath = packageName.replace(".", "/");
        ;
        File file = new File(this.getClass().getClassLoader().getResource(packagePath).getFile());
        if (file.isDirectory()) {
            for (File e : file.listFiles()) {
                if (e.isDirectory()) {
                    doScan(packageName + "." + e.getName());
                } else if (e.getName().endsWith(".class")) {
                    String className = packageName + "." + e.getName().replace(".class", "");
                    list.add(className);
                }
            }
        }
        return list;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        String result = "";
        for (String e : this.list) {
            System.out.println(e);
        }
        return result;
    }
}
