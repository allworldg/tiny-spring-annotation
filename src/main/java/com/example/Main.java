package com.example;

import com.example.util.ClassScanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ClassScanner classScanner = new ClassScanner();
        classScanner.doScan(Main.class.getPackage().getName());
        System.out.println(classScanner);
    }


}

