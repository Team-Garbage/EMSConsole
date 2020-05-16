package com.cognixia.teamgarbage.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CrudRunner {

    private static final String EMPFILE = "data/employee.txt";
    private static final String DEPTFILE = "data/department.txt";
    private static final String EMPDEPTFILE = "data/employee_department.txt";

    public static void doWork(int crudType, int empOrDept) {
        File dataFile;
        HashMap map;
        ArrayList<String[]> data;
        if (empOrDept == ConfigSetup.DEPT) {
            switch (crudType) {
                case ConfigSetup.CREATE:
                    map = convertDepartmentData(readData(DEPTFILE));
                    Department dept = DataHandler.createDepartmentData(map);
                    DataHandler.insertData(dept, DEPTFILE);
                    break;
                case ConfigSetup.READ:
                    data = readData(DEPTFILE);
                    DataHandler.printData(data, empOrDept);
                    break;
                case ConfigSetup.UPDATE:
                    data = readData(DEPTFILE);
                    DataHandler.printData(data, empOrDept);
                    map = convertDepartmentData(readData(DEPTFILE));
                    map = PromptMaker.getPm().getDeptToUpdate(map);
                    DataHandler.updateData(map, DEPTFILE, ConfigSetup.DEPT);
                    break;
                case ConfigSetup.DELETE:
                    System.out.println("No");
                    break;
                default:
                    System.out.println("Lit");
                    break;
            }
        } else if (empOrDept == ConfigSetup.EMP) {
            switch (crudType) {
                case ConfigSetup.CREATE:
                    map = convertDepartmentData(readData(DEPTFILE));
                    Department dept = DataHandler.createDepartmentData(map);
                    DataHandler.insertData(dept, EMPFILE);
                    break;
                case ConfigSetup.READ:
                    data = readData(DEPTFILE);
                    DataHandler.printData(data, empOrDept);
                    break;
                case ConfigSetup.UPDATE:
                    System.out.println("Yes");
                    break;
                case ConfigSetup.DELETE:
                    System.out.println("No");
                    break;
                default:
                    System.out.println("Lit");
                    break;
            }
        }

    }

    /*
    private static HashMap createDataFromFile(String filepath) {
        ArrayList<String[]> data = readData(filepath);
        HashMap map ;


    }*/

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

    private static HashMap convertEmployeeData(ArrayList<String[]> data) {
        HashMap<Integer, Employee> emp = new HashMap<Integer, Employee>();
        for (String[] rawData: data) {
            emp.put(Integer.parseInt(rawData[0]), new Employee(Integer.parseInt(rawData[0]), rawData[1],
                    rawData[2], Integer.parseInt(rawData[3])));
        }
        return emp;
    }

    private static HashMap convertDepartmentData(ArrayList<String[]> data) {
        HashMap<Integer, Department> depts = new HashMap<Integer, Department>();
        for (String[] rawData: data) {
            depts.put(Integer.parseInt(rawData[0]), new Department(Integer.parseInt(rawData[0]), rawData[1], Double.parseDouble(rawData[2])));
        }

        return depts;
    }
}
