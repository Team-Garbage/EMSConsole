package com.cognixia.teamgarbage.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PromptMaker {

    public static int selectCRUD(Scanner userIn) {
        Scanner promptReader = null;
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
        return selection;
    }

    public static int selectEmpOrDept(Scanner userIn) {
        int option;

        System.out.println("Please specify if you are selecting and Employee or Department:\nDepartment(0)\nEmployee(1)");
        option = userIn.nextInt();

        while (option < 0 || option > 1) {
            System.out.println("Invalid option: '" + option + "'. Please enter a valid response");
            option = userIn.nextInt();
        }

        return option;
    }

}
