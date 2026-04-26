package com.example.util;

import com.example.Main;
import com.example.util.ClassScanner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;

public class ClassScannerTest {

    @Test
    public void test1(){
        ClassScanner classScanner = new ClassScanner();
        classScanner.doScan(Main.class.getPackage().getName());
        System.out.println(classScanner);;
    }
}
