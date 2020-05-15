package com.cognixia.teamgarbage.main;

import java.util.Scanner;

public class MainDriver {

    private final String dataFiles = "dept/";
    private final int DEPT = 0;
    private final int EMP = 1;

    public static void main(String args[]) {
        int selectCrud;
        int selectEmpDept;
        Scanner userIn = new Scanner(System.in);

        while(true) {
            selectCrud = PromptMaker.selectCRUD(userIn);

            if (selectCrud == 0) break;

            selectEmpDept = PromptMaker.selectEmpOrDept(userIn);
            CrudRunner.doWork(selectCrud, selectEmpDept);
            System.out.println("Would you like to continue with additional changes?\nYes(1)\nNo(0)");

            int selectAgain = userIn.nextInt();

            while (selectAgain < 0 || selectAgain > 1) {
                System.out.println(selectAgain + " is not a valid option. Please enter a valid option.");
                selectAgain = userIn.nextInt();
            }
            if (selectAgain == 0) break;
        }

        System.out.println("Thank you for using the Employee Management System");
        userIn.close();
    }
}
