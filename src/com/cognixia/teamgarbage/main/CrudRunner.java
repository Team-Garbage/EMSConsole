package com.cognixia.teamgarbage.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrudRunner {

    private static final String EMPFILE = "data/employee.txt";
    private static final String DEPTFILE = "data/department.txt";
    private static final String EMPDEPTFILE = "data/employee_department.txt";

    public static void doWork(int crudType, int empOrDept) {
        File dataFile;

        if (empOrDept == ConfigSetup.DEPT) {
            switch (crudType) {
                case ConfigSetup.CREATE:
                    createData(EMPFILE);
                    break;
                case ConfigSetup.READ:
                    ArrayList<String[]> data = readData(DEPTFILE);
                    DataHandler.printData(data, empOrDept);
                    break;
                case ConfigSetup.UPDATE:
                    System.out.println("Yes");
                    break;
                case ConfigSetup.DEPT:
                    System.out.println("No");
                    break;
                default:
                    System.out.println("Lit");
                    break;
            }
        }

    }

    private static void createData(String empfile) {
    }

    private static ArrayList<String[]> readData(String fileName) {
        Scanner reader = null;
        ArrayList<String[]> data = new ArrayList<String[]>();

        try {
            reader = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (reader.hasNextLine()) {
            data.add(reader.nextLine().split(","));
        }

        return data;
    }
}
