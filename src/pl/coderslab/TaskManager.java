package pl.coderslab;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class TaskManager {

    static String[][] tasks;

    public static void main(String[] args) {
        tasks = loadTasks();
        menu();
    }

    private static String[][] loadTasks() {
        Path tasksPath = Paths.get("tasks.csv");

        try {
            Scanner scanner = new Scanner(tasksPath.toFile());
        } catch (FileNotFoundException e) {
            System.out.println(ConsoleColors.RED + "File not found: " + tasksPath.toAbsolutePath());
        }

        return new String[0][];
    }

    public static String menu() {

        Scanner skaner = new Scanner(System.in);

        System.out.println(ConsoleColors.BLUE + "Please select an option:");
        System.out.println(ConsoleColors.WHITE + "add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("exit");

        String option = skaner.nextLine();
        while (!option.equals("add") && !option.equals("remove") && !option.equals("list") && !option.equals("exit")) {
            System.out.println("Zły wybór");
            option = skaner.nextLine();
        }

        skaner.close();
        return option;
    }

}
