/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package virtualpet;

/**
 *
 * @author vinaydhillon
*/
import java.util.*;
public class Helper {
    
    public static String randomPetName(){
        Random r = new Random();
        Scanner n = new Scanner(System.in);
        String petNamePlaceholder = "";
        String vowels = "aieou";
        String consonants = "bcdfghjklmnpqrstvwxyz";
        System.out.print("How many letters would you like the name to be? Enter a number from 4-8: ");
        int petNameLength = n.nextInt();
        if (petNameLength >= 4 && petNameLength <= 8){
            for (int i = 1; i<=petNameLength; i++ ){
                int doubleChance = 1 + r.nextInt(100);
                if(i%2 == 0){
                    char vowelAdd = vowels.charAt(0 + r.nextInt(4));
                    petNamePlaceholder += vowelAdd;
                    if (doubleChance <= 20){
                        petNamePlaceholder += vowelAdd;
                        petNameLength -= 1;
                    }
                } else if (i % 2 != 0){
                    char consAdd = consonants.charAt(0 + r.nextInt(21));
                    petNamePlaceholder += consAdd;
                    if (doubleChance <= 20){
                        petNamePlaceholder += consAdd;
                        petNameLength -= 1;
                               }
                           }
            petNamePlaceholder = petNamePlaceholder.substring(0,1).toUpperCase() + petNamePlaceholder.substring(1);
                    }
        }else{
            petNamePlaceholder = "Invalid input, please try again.";
        }
        
        
    return petNamePlaceholder;
    
}
    public static int guessingGame(){
        Random r = new Random();
        Scanner n = new Scanner(System.in);
        int coins = 100;
        System.out.print("\nWelcome to guess the number! Please select your difficulty \n1. Easy \n2. Hard \nEnter your choice: ");
        int menuChoice = n.nextInt();
        if(menuChoice == 1){
            System.out.println("Welcome to the EASY mode. You have 10 guesses to get the number for coins! \nEnter your first guess from 1-100: ");
            int randomNum = 0 + r.nextInt(100);
            for(int i = 10; i>0; i--){            
                int randomGuess = n.nextInt();
                if (randomGuess < randomNum){
                    System.out.println("Too low! You have " + (i-1) + " guesses left.");
                    coins -= 10;
                } else if (randomGuess > randomNum){
                    System.out.println("Too high! You have " + (i - 1) + " guesses left.");
                    coins -= 10;
                } else if (randomGuess == randomNum){
                    System.out.println("You guessed the number!");
                    break;
                } if ((i-1) == 0){
                    System.out.println("You used all your guesses! Better luck next time!");
                    coins = 0;
                    break;
                }
            }
        }else if (menuChoice == 2){
            System.out.println("Welcome to the HARD mode. You have 5 guesses to get the number for coins! \nEnter your first guess from 1-100: ");
            int randomNum = 0 + r.nextInt(100);
            for(int i = 5; i>0; i--){            
                int randomGuess = n.nextInt();
                if (randomGuess < randomNum){
                    System.out.println("Too low! You have " + (i-1) + " guesses left.");
                    coins -=5;
                } else if (randomGuess > randomNum){
                    System.out.println("Too high! You have " + (i-1) + " guesses left.");
                    coins -= 5;
                } else if (randomGuess == randomNum){
                    System.out.println("You guessed the number!");
                    break;
                } if ((i-1) == 0){
                    System.out.println("You used all your guesses! Better luck next time!");
                    coins = 0;
                    break;
                }
                
            }
        }
        return coins;
    }
    public static int matchingGame(){
        Random r = new Random();
        Scanner n = new Scanner(System.in);
        System.out.println("Select to the matching game! Please select your difficulty \n1. Easy \n2. Hard \nEnter your choice: ");
        int matchingDiff = n.nextInt();
        String matchString = "";
        String letters = "ABC";
        if (matchingDiff == 1){
            for(int i = 0;i<6;i++){
               int randLetter = 0 + r.nextInt(2);
               matchString += letters.charAt(randLetter);
               
            }
                
        } else if (matchingDiff == 2){
        
    }
return 0;} 
}