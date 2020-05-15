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
        PromptMaker pm = PromptMaker.getPm();
        pm.setUserIn(userIn);

        while(true) {
            selectCrud = pm.selectCRUD();

            if (selectCrud == 0) break;

            selectEmpDept = pm.selectEmpOrDept();
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
