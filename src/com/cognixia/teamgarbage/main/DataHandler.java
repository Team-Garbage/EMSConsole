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
        while (map.containsKey(deptId)) {
            System.out.println("Department ID '" + deptId + "' already exists. Please enter a different ID");
            deptId = scan.nextInt();
        }

        System.out.println("Enter Department Name");
        scan.nextLine();
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
                bw.newLine();
                bw.write(emp.formattedData());
                bw.newLine();
            }
            bw.close();
            System.out.println(item.toString() + " has been entered!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void updateData(HashMap map, String fileNm, int mode) {
        try {

            File temp = new File("data/temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            if (mode == ConfigSetup.DEPT) {
                HashMap<Integer, Department> map2 = (HashMap<Integer, Department>) map;
                map.forEach((id, dept) -> {
                   Department dp = (Department) map2.get(id);
                    try {
                        bw.write(dp.formattedData() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                File del = new File(fileNm);
                del.delete();
                temp.renameTo(new File(fileNm));
                bw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
