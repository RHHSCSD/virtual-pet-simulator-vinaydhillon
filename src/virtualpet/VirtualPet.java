/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;

import java.io.*;
import java.util.*;

public class VirtualPet {

    // Scanner for user input and Random for random number generation
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // Variables for game state
    static int coins = 0;
    static boolean running = true;

    // Arrays for storing max and current stats: 0: Health, 1: Energy, 2: Food
    static int[] maxStats = new int[3];
    static int[] currentStats = new int[3];

    // Arrays for tracking actions and their counts
    static String[] actions = {"Fed", "Played", "Groomed"};
    static int[] actionCount = new int[3];

    // Variables for pet and user details
    static String petType = "";
    static String petName = "";
    static String username = "";
    static String password = "";

    public static void main(String[] args) {
        displaySplashScreen();
        if (!login()) {
            return;
        }
        loadUserData();
        displayMainMenu();
    }

    // Display the splash screen with the game title
    public static void displaySplashScreen() {
        System.out.println("                    _,,......_\n" +
                "                 ,-'          `'--.\n" +
                "              ,-'  _              '-.\n" +
                "     (`.    ,'   ,  `-.              `.\n" +
                "      \\ \\  -    / )    \\               \\\n" +
                "       `\\`-^^^, )/      |     /         :\n" +
                "         )^ ^ ^V/            /          '.\n" +
                "         |      )            |           `.\n" +
                "         9   9 /,--,\\    |._:`         .._`.\n" +
                "         |    /   /  `.  \\    `.      (   `.`.\n" +
                "         |   / \\  \\    \\  \\     `--\\   )    `.`.___\n" +
                "     .;;./  '   )   '   )       ///'       `-\"'\n" +
                "        `--'   7//\\    ///\\ ");
        System.out.println("\n                   Pet Simulator");
    }

    // Login function to authenticate or register a new user
    public static boolean login() {
        System.out.print("Enter your username: ");
        username = scanner.nextLine();
        File userFile = new File(username + ".txt");

        if (userFile.exists()) {
            // If user exists, prompt for password
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
                if (checkPassword(userFile, password)) {
                    return true;
                } else {
                    System.out.println("Incorrect password. You have " + (2 - i) + " tries left.");
                }
            }
            System.out.println("Too many incorrect attempts. Goodbye");
            return false;
        } else {
            // If new user, prompt for new password
            System.out.print("Enter a new password: ");
            password = scanner.nextLine();
            return true;
        }
    }

    // Check if the entered password matches the stored password
    public static boolean checkPassword(File userFile, String password) {
        try (Scanner fileScanner = new Scanner(userFile)) {
            String storedUsername = fileScanner.nextLine();
            String storedPassword = fileScanner.nextLine();
            return storedPassword.equals(password);
        } catch (FileNotFoundException e) {
            System.out.println("User data not found.");
            return false;
        }
    }

    // Display the main menu and handle user choices
    public static void displayMainMenu() {
        while (true) {
            System.out.println("\nMENU: \n1. Start \n2. Instructions \n3. Exit");
            System.out.print("Enter one of the above inputs to start your journey!: ");
            String menuInput = scanner.nextLine().toLowerCase();
            switch (menuInput) {
                case "1":
                case "start":
                    startGame();
                    break;
                case "2":
                case "instructions":
                    System.out.println("Insert instructions here");
                    break;
                case "3":
                case "exit":
                    displayActionSummary();
                    saveUserData();
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    // Start the game, initializing new pet if necessary
    public static void startGame() {
        if (!new File(username + ".txt").exists()) {
            selectPet();
            namePet();
            assignRandomStats();
        }

        while (running) {
            displayPetMenu();
        }
    }

    // Allow user to select a pet type
    public static void selectPet() {
        System.out.println("Pets:\n1. Dog\n2. Lizard\n3. Armadillo");
        System.out.print("Enter the corresponding number to choose your pet: ");
        String petSelect = scanner.nextLine().toLowerCase();
        switch (petSelect) {
            case "1":
            case "dog":
                petType = "dog";
                break;
            case "2":
            case "lizard":
                petType = "lizard";
                break;
            case "3":
            case "armadillo":
                petType = "armadillo";
                break;
            default:
                System.out.println("\nPlease try again and enter a valid input.");
                System.exit(0);
        }
        System.out.println("\nYou chose a " + petType + "!");
    }

    // Allow user to name their pet
    public static void namePet() {
        System.out.println("1. Choose your pet's name");
        System.out.println("2. Generate a random name");
        System.out.print("Enter the corresponding number to decide your " + petType + "'s name: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                System.out.print("Enter your pet's name: ");
                petName = scanner.nextLine();
                System.out.println("Your pet, named " + petName + " has been born!");
                break;
            case 2:
                petName = Helper.randomPetName();
                System.out.println("Your pet, named " + petName + " has been born!");
                break;
            default:
                System.out.println("Please enter a valid input.");
                System.exit(0);
        }
    }

    // Assign random stats to the pet
    public static void assignRandomStats() {
        int randomPoints = 20;
        maxStats[0] = random.nextInt(randomPoints);
        randomPoints -= maxStats[0];
        maxStats[1] = random.nextInt(randomPoints);
        randomPoints -= maxStats[1];
        maxStats[2] = randomPoints;

        // Initialize current stats to max stats
        System.arraycopy(maxStats, 0, currentStats, 0, maxStats.length);

        System.out.println("Your " + petType + ", " + petName + " has been assigned the following stats: ");
        System.out.println("Health points: " + maxStats[0]);
        System.out.println("Energy points: " + maxStats[1]);
        System.out.println("Food points: " + maxStats[2]);
    }

    // Display the pet menu and handle user choices
    public static void displayPetMenu() {
        System.out.println("\nPET MENU: \n1. Play/Interact \n2. Coin Balance \n3. Exit");
        System.out.print("Enter the corresponding number to choose an option: ");
        int petMenuChoice = scanner.nextInt();
        switch (petMenuChoice) {
            case 1:
                displayGameMenu();
                break;
            case 2:
                System.out.println("You have " + coins + " coins!");
                break;
            case 3:
                displayActionSummary();
                saveUserData();
                System.out.println("Goodbye! See you soon!");
                System.exit(0);
            default:
                System.out.println("Please enter a valid input");
        }
    }

    // Display the game menu and handle user choices
    public static void displayGameMenu() {
        System.out.print("\nGAME MENU: \n1. Number Guessing Game \n2. Matching Game\n3. Play with Pet\n4. Feed Pet\n5. Groom Pet\nEnter your choice: ");
        int gameMenuChoice = scanner.nextInt();
        switch (gameMenuChoice) {
            case 1:
                coins += Helper.guessingGame();
                break;
            case 2:
                coins += Helper.matchingGame();
                break;
            case 3:
                playWithPet();
                break;
            case 4:
                feedPet();
                break;
            case 5:
                groomPet();
                break;
            default:
                System.out.println("Invalid choice. Returning to pet menu.");
        }
    }

    // Handle playing with the pet, increasing energy
    public static void playWithPet() {
        if (coins >= 5) {
            System.out.println("You play with " + petName + ". Energy increased.");
            currentStats[1] = Math.min(currentStats[1] + 5, maxStats[1]);
            coins -= 5;
            actionCount[1]++;
        } else {
            System.out.println("Not enough coins to play with your pet.");
        }
    }

    // Handle feeding the pet, increasing food
    public static void feedPet() {
        if (coins >= 5) {
            System.out.println("You feed " + petName + ". Food increased.");
            currentStats[2] = Math.min(currentStats[2] + 5, maxStats[2]);
            coins -= 5;
            actionCount[0]++;
        } else {
            System.out.println("Not enough coins to feed your pet.");
        }
    }

    // Handle grooming the pet, increasing health
    public static void groomPet() {
        if (coins >= 5) {
            System.out.println("You groom " + petName + ". Health increased.");
            currentStats[0] = Math.min(currentStats[0] + 5, maxStats[0]);
            coins -= 5;
            actionCount[2]++;
        } else {
            System.out.println("Not enough coins to groom your pet.");
        }
    }

    // Display the action summary at the end of the game session
    public static void displayActionSummary() {
        System.out.println("\nToday You have:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(actions[i] + " your pet " + actionCount[i] + " times");
        }
        if (actionCount[0] >= 20) {
            System.out.println("Congratulations you have earned Avid Eater!!");
        }
        if (actionCount[1] >= 20) {
            System.out.println("Congratulations you have earned Play Master!!");
        }
        if (actionCount[2] >= 20) {
            System.out.println("Congratulations you have earned Grooming Expert!!");
        }
    }

    // Save user data to a file
    public static void saveUserData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(username + ".txt"))) {
            writer.println(username);
            writer.println(password);
            writer.println(petName);
            writer.println(petType);
            for (int stat : maxStats) {
                writer.println(stat);
            }
            for (int stat : currentStats) {
                writer.println(stat);
            }
            writer.println(coins);
            for (int count : actionCount) {
                writer.println(count);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving user data.");
        }
    }

    // Load user data from a file
    public static void loadUserData() {
        File file = new File(username + ".txt");
        if (!file.exists()) {
            System.out.println("No existing user data found. Starting a new game.");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            username = fileScanner.nextLine();
            password = fileScanner.nextLine();
            petName = fileScanner.nextLine();
            petType = fileScanner.nextLine();
            for (int i = 0; i < maxStats.length; i++) {
                maxStats[i] = fileScanner.nextInt();
            }
            for (int i = 0; i < currentStats.length; i++) {
                currentStats[i] = fileScanner.nextInt();
            }
            coins = fileScanner.nextInt();
            for (int i = 0; i < actionCount.length; i++) {
                actionCount[i] = fileScanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("User data not found. Starting a new game.");
        } catch (Exception e) {
            System.out.println("An error occurred while loading user data.");
        }
    }
}