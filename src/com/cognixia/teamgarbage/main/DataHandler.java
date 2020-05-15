package com.cognixia.teamgarbage.main;

import java.util.ArrayList;

public class DataHandler {

    public static void printData(ArrayList<String[]> data, int empOrDept) {

        if (empOrDept == ConfigSetup.DEPT) {
            System.out.println("--------------------------------");
            for (String[] attr: data) {
                Department dp = new Department(Integer.parseInt(attr[0]), attr[1], Double.parseDouble(attr[2]));
                System.out.println(dp);
            }
            System.out.println("--------------------------------");
        } else if (empOrDept == ConfigSetup.EMP) {
            String format = "%s  | %s  |  %s  |  %s";
            System.out.println("--------------------------------");
            System.out.println("EMP_ID  |  FIRST_NAME  |  LAST_NAME  |  EMP_TYPE");
            for (String[] rawData: data) {
                System.out.printf(format, rawData[0], rawData[1], rawData[2], rawData[3]);
            }
            System.out.println("--------------------------------");
        }
    }
}
