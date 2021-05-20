package pl.coderslab;

import java.util.Scanner;

public class TaskManager {
    static String[][] tasks;

    public static void main(String[] args) {


        menu();
    }

    public static String menu() {

        Scanner skaner = new Scanner(System.in);

        System.out.println(ConsoleColors.BLUE + "Please select an option:");
        System.out.println(ConsoleColors.WHITE + "add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("exit");

        String option = skaner.nextLine();
        while(!option.equals("add") && !option.equals("remove") && !option.equals("list") && !option.equals("exit") ){
            System.out.println("Zły wybór");
            option = skaner.nextLine();
        }

        skaner.close();
        return option;
    }

}
