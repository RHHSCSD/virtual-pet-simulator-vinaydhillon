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
        System.out.print("\nEnter your username: ");
        String username = n.next();
        System.out.print("Enter your password: ");
        String password = n.next();
        if (username.equals("snoopy") && password.equals("toto")){
              System.out.println("\nMENU: \n1. Start \n2. Instructions \n3. Exit");
        System.out.print("Enter one of the above inputs to start your journey!: ");
        String menuInput = n.next().toLowerCase();
        
        if (menuInput.equals("start") || menuInput.equals("1")){
            System.out.println("Pets:\n1. Dog\n2. Paul");
            String petSelect = n.next();
            if (petSelect.equals("Dog")||petSelect.equals("1")){
                
            }else if(petSelect.equals("Paul")||petSelect.equals("2")){
                
            }
             
        } else if (menuInput.equals("instructions") || menuInput.equals("2")){
            
        } else if (menuInput.equals("exit") || menuInput.equals("3")){
            System.out.println("Goodbye!");
            System.exit(0);
        } else{
            System.out.println("Invalid input.");
            System.exit(0);
        }
        
        
        } else{
            System.out.println("Invalid username or password.");
            System.exit(0);
        }
            
               
      
            
         
        
        
    }
    
}
