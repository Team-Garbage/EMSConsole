package com.cognixia.teamgarbage.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PromptMaker {

    private Scanner userIn;
    private static PromptMaker pm;

    private PromptMaker() {
        this.userIn = userIn;
    }

    public static PromptMaker getPm() {
        if (pm == null) {
             pm = new PromptMaker();
        }

        return pm;
    }

    public Scanner getUserIn() {
        return this.userIn;
    }
    public void setUserIn(Scanner userIn) {
        this.userIn = userIn;
    }

    public int selectCRUD() {
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

    public int selectEmpOrDept() {
        int option;

        System.out.println("Please specify if you are selecting and Employee or Department:\nDepartment(0)\nEmployee(1)");
        option = this.userIn.nextInt();

        while (option < 0 || option > 1) {
            System.out.println("Invalid option: '" + option + "'. Please enter a valid response");
            option = userIn.nextInt();
        }

        return option;
    }

}
