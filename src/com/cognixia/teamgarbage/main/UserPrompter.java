package com.cognixia.teamgarbage.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserPrompter {

    public static int selectCRUD() {
        Scanner promptReader = null;
        Scanner userIn = new Scanner(System.in);
        int selection = -1;

        try {
            promptReader = new Scanner(new File("prompt/initprompt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(promptReader.hasNextLine()) {
            System.out.println(promptReader.nextLine());
        }

        selection = userIn.nextInt();

        while(selection < 0 || selection > 4) {
            System.out.println("Invalid selection: '" + selection + "'. Please enter a valid option");
            selection = userIn.nextInt();
        }

        promptReader.close();

        userIn.close();
        return selection;
    }

    public static int selectEmpOrDept() {
        Scanner userIn = new Scanner(System.in);
        int option;

        System.out.println("Please specify if you are choosing an Employee or Department");
        option = userIn.nextInt();

        while (option != 0 || option != 1) {
            System.out.println("Invalid option: '" + option + "'. Please enter a valid response");
            option = userIn.nextInt();
        }

        userIn.close();
        return option;
    }
}
