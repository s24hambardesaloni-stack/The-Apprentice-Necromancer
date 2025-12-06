package game;

import java.util.Scanner;

public class Game {

    static Task[] tasks = new Task[5];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===== The Apprentice Necromancer =====");
        System.out.print("Enter your name, student of the dead: ");
        String name = sc.nextLine();
        Player p = new Player(name);

        // initialize task array
        tasks[0] = new Task("Practice Summoning", 5, 10, 10);
        tasks[1] = new Task("Harvest Mandora", 10, 15, 10);
        tasks[2] = new Task("Clean Haunted Classroom", 8, 12, 10);
        tasks[3] = new Task("Study Bone Runes", 0, 5, 10);
        tasks[4] = new Task("Tame Angry Skeleton", 12, 20, 12);

        int choice;

        do {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Perform a Task");
            System.out.println("2. View Stats");
            System.out.println("0. Exit Academy");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
            case 1:
                doTask(p);
                break;
            case 2:
                p.printStats();
                break;
            case 0:
                System.out.println("Farewell, apprentice " + p.getName() + "...");
                break;
            default:
                System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public static void doTask(Player p) {
        System.out.println("\n=== Available Tasks ===");

        for (int i = 0; i < tasks.length; i++) {
            System.out.println((i+1) + ". " + tasks[i].getName() 
                    + " (HP-" + tasks[i].getHpCost() 
                    + ", NP-" + tasks[i].getNpCost() 
                    + ", XP+" + tasks[i].getXpReward() + ")");
        }

        System.out.print("Choose task: ");
        int t = sc.nextInt() - 1;

        if (t < 0 || t >= tasks.length) {
            System.out.println("Invalid task.");
            return;
        }

        Task chosen = tasks[t];

        if (p.getHP() < chosen.getHpCost() || p.getNP() < chosen.getNpCost()) {
            System.out.println("You are too weak to perform this task!");
            return;
        }

        p.subtractHP(chosen.getHpCost());
        p.subtractNP(chosen.getNpCost());
        p.addXP(chosen.getXpReward());

        System.out.println("Task completed: " + chosen.getName());
        System.out.println("+ XP " + chosen.getXpReward());
    }
}
