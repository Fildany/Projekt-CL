package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;


public class TaskManager {

    static String[][] tasks;

    public static void main(String[] args) {
        tasks = loadTasks();
        while (true) {
            String opcja = menu();

            switch (opcja) {
                case "add":
                    addTask();
                    break;
                case "remove":
                    removeTask();
                    break;
                case "list":
                    listTasks();
                    break;
                case "exit":
                    System.out.println(ConsoleColors.RED + "Pa pa");
                    return;
                default:
                    System.out.println("Please select a correct option.");
            }
        }
    }

    private static void listTasks() {
        for (int i = 0; i < tasks.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tasks[i].length; j++) {
                System.out.print(tasks[i][j] + " ");
            }
            System.out.println();
//            System.out.println(Arrays.toString(tasks[i]));
        }
    }

    private static void removeTask() {

        Scanner skaner = new Scanner(System.in);
        System.out.println("Co chcesz usunąć?");
        int zamianka = -1;
        while (zamianka < 0) {
            String usuwanko = skaner.nextLine();
            try {
                zamianka = Integer.parseInt(usuwanko);
                if (zamianka >= 0) {
                    tasks = ArrayUtils.remove(tasks, zamianka);
                    System.out.println("Usuwanko zakończone");
                } else {
                    System.out.println("To nie jest o co nam chodzi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("To nie jest o co nam chodzi.");
            }
        }
    }

    private static void addTask() {

        Scanner skanerAdd = new Scanner(System.in);
        System.out.println("Proszę wpisać opis zadania:");
        String zbieraczAdd1 = skanerAdd.nextLine();
        System.out.println("Datę rozpoczęcia zadania:");
        String zbieraczAdd2 = skanerAdd.nextLine();
        System.out.println("Czy zadanie jest trudne?");
        String zbieraczAdd3 = skanerAdd.nextLine();

        String[] kolumny = new String[]{zbieraczAdd1, zbieraczAdd2, zbieraczAdd3};
        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = kolumny;

    }


    private static String[][] loadTasks() {
        Path tasksPath = Paths.get("tasks.csv");
        String[][] tablica = null;

        try {
            Scanner nowySkaner = new Scanner(tasksPath.toFile());
            int iloscWierszy = 0;
            while (nowySkaner.hasNextLine()) {
                iloscWierszy++;
                nowySkaner.nextLine();
            }
            tablica = new String[iloscWierszy][];
            Scanner skaner = new Scanner(tasksPath.toFile());
            int i = 0;
            while (skaner.hasNextLine()) {
                String zbieracz = skaner.nextLine();
                String[] kolumny = zbieracz.split(", ");
                tablica[i] = kolumny;
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(ConsoleColors.RED + "File not found: " + tasksPath.toAbsolutePath());
        }

        return tablica;
    }

    public static String menu() {

        Scanner skaner = new Scanner(System.in);

        System.out.println(ConsoleColors.BLUE + "Please select an option:");
        System.out.println(ConsoleColors.WHITE_BRIGHT + "add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("exit");

        String option = skaner.nextLine();
        while (!option.equals("add") && !option.equals("remove") && !option.equals("list") && !option.equals("exit")) {
            System.out.println("Zły wybór");
            option = skaner.nextLine();
        }
        return option;
    }
}
