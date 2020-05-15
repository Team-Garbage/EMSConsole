package com.cognixia.teamgarbage.main;

import java.util.Scanner;

public class MainDriver {

    private final String dataFiles = "dept/";
    private final int DEPT = 0;
    private final int EMP = 1;

    public static void main(String args[]) {
        int selection;
        Scanner userIn = new Scanner(System.in);
        selection = UserPrompter.selectCRUD();
        selection = UserPrompter.selectEmpOrDept();
    }
}
