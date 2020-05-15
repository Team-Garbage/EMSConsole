package com.cognixia.teamgarbage.main;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

    public static Department createDepartmentData(HashMap map) {

        Scanner scan = PromptMaker.getPm().getUserIn();
        System.out.println("Please enter the Department ID");
        int deptId = scan.nextInt();
        if (!map.containsKey(deptId)) {
            System.out.println("Department ID '" + deptId + "' does not exist");
            createDepartmentData(map);
        }

        System.out.println("Enter Department Name");
        String deptName = scan.nextLine();

        System.out.println("Enter Budget");
        Double budget = scan.nextDouble();

        Department dept = new Department(deptId, deptName, budget);
        return dept;

    }

    public static <T> void insertData(T item, String empfile) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(empfile, true));
            if (item instanceof Department) {
                Department dept = (Department) item;
                bw.write(dept.formattedData());
            } else if (item instanceof Employee) {
                Employee emp = (Employee) item;
                bw.write(emp.formattedData());
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
