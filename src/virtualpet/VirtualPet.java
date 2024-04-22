/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.*;
/**
 *
 * @author michael.roy-diclemen
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner n = new Scanner(System.in);
        Random r = new Random();
        boolean running = true; 
        int coins = 0;
        
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
        System.out.println("\n                   placeholder name");
        for(int i = 0; i<3; i++){
        System.out.print("\nEnter your username: "
                + "");
        String username = n.nextLine();
        System.out.print("Enter your password: ");
        String password = n.nextLine();
        if (username.equals("snoopy") && password.equals("toto")){
              System.out.println("\nMENU: \n1. Start \n2. Instructions \n3. Exit");
              break;
        } else if(i == 2){
            System.out.println("Too many incorrect attempts. Goodbye");   
            System.exit(0);
        } else{
            System.out.println("Incorrect. You have " + (2-i) + " tries left.");
        }
        }
        System.out.print("Enter one of the above inputs to start your journey!: ");
        String menuInput = n.nextLine().toLowerCase();
        
        if (menuInput.equals("start") || menuInput.equals("1")){
            System.out.println("Pets:\n1. Dog\n2. Lizard\n3. Armadillo");
            System.out.print("Enter the corresponding number to choose your pet: ");
            String petSelect = n.nextLine().toLowerCase();
            String petType = "";
            switch (petSelect){
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
                    System.out.println("\nPlease try again and enter a valid input. ");
                    System.exit(0);
                    
                    
            }           
                System.out.println("\nYou chose a " + petType + "!");
                System.out.println("1. Choose your pets name");
                System.out.println("2. Generate a random name");
                System.out.print("Enter the corresponding number to decide your " + petType + "'s name: ");
                int choice = n.nextInt();
                
                n.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter your pets name: ");
                        String petName = n.nextLine();
                        
                        System.out.println("Your pet, named " + petName + " has been born!");
                        int randomPoints = 20;
                            int healthPoints = 0 + r.nextInt(randomPoints);
                            randomPoints -= healthPoints;
                            int energyPoints = 0 + r.nextInt(randomPoints);
                            randomPoints -= energyPoints;
                            int foodPoints = randomPoints;
                            System.out.print("Your " + petType + "," + petName + " has been assigned the following stats: \nHealth points: " + healthPoints + "\nEnergy points: " + energyPoints +"\nMax food: " + foodPoints);                       
                            break;
                    case 2:
                        petName = Helper.randomPetName();
                        if (petName.equals("Invalid input, please try again.")){
                            System.out.println(petName);
                            System.exit(0);
                            
                        }else{
                            System.out.println("Your pet, named " + petName +" has been born!");
                            randomPoints = 20;
                            healthPoints = 0 + r.nextInt(randomPoints);
                            randomPoints -= healthPoints;
                            energyPoints = 0 + r.nextInt(randomPoints);
                            randomPoints -= energyPoints;
                            foodPoints = randomPoints;
                            System.out.println("Your " + petType + ", " + petName + " has been assigned the following stats: \nHealth points: " + healthPoints + "\nEnergy points: " + energyPoints +"\nMax food: " + foodPoints);
                        }
                        break;
                    default: 
                        System.out.println("Please enter a valid input.");
                        System.exit(0);
                }
                
                while (running == true){
                    System.out.println("\nPET MENU: \n1. Play/Interact \n2. Coin Balance \n3. Exit");
                    System.out.print("Enter the correspoinding number to choose an option: ");
                    int petMenuChoice = n.nextInt();
                    if (petMenuChoice == 1){
                        System.out.print("\nGAME MENU: \n1. Number Guessing Game \n2. Placeholder Game\nEnter your choice: ");
                        int gameMenuChoice = n.nextInt();
                        if (gameMenuChoice == 1){
                            coins += Helper.guessingGame();
                        } else if (gameMenuChoice == 2){
                            
                        }
                    } else if (petMenuChoice == 2){
                        System.out.println("You have " + coins + " coins!");
                    } else if (petMenuChoice == 3){
                        System.out.println("Goodbye! See you soon!");
                        System.exit(0);
                    } else{
                        System.out.println("Please enter a valid input");
                    }
                    
                }
         
             
        } else if (menuInput.equals("instructions") || menuInput.equals("2")){
            System.out.println("Insert instructions here");
        } else if (menuInput.equals("exit") || menuInput.equals("3")){
            System.out.println("Goodbye!");
            System.exit(0);
        } else{
            System.out.println("Invalid input.");
            System.exit(0);
        }
        
        
    
               
      
            
         
        
}
    
    
    
}
