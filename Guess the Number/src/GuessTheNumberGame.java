import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String startGame="yes";
        while(startGame.equals("yes")){
            System.out.println("Welcome! To The Guess The Number Game");
  
            //Generate a random no for the givern range
            System.out.println("Please choose the start range");
            int start = getUserInput(sc);
            System.out.println("Please choose the end range");
            int end = getUserInput(sc);
            System.out.println("Your start range is "+start+" and end range is "+end );
            Random rand = new Random();   
            int randomNumber = rand.nextInt(end-start)+start;

            
            //check of the guessed number is correct
            int guess = -1;
            int attempt=0;
            while(guess != randomNumber){
               System.out.println("\nPlease guess a number between "+start+" and "+end+"\n");
               guess = getUserInput(sc);
                            
               if(guess > start && guess < end){
            	   attempt++;
                   if(randomNumber == guess){
                   System.out.println("Congratulations! You've guessed the correct number");
                   System.out.println("You took "+attempt+" attempt to guess the number");   
               }
               //if the number is higher
               else if(randomNumber > guess){
                   System.out.println("Sorry! The number is greater then "+guess);
                   System.out.println("Please enter a higher number");
               }
               //if the nuber is lower
               else if(randomNumber < guess){
                   System.out.println("Sorry! The number is less then "+guess);
                   System.out.println("Please enter a lower number");
               }
               }
               else{
                   System.out.println("Out of range, the number should be greater then "+start+" and less then "+end);
               }
            }
            System.out.println("Please enter yes if You want to play again");

            startGame = sc.next().toLowerCase();
        }
        System.out.println("Thanks! you have played well");
        sc.close();
    }
    
    //method to check for invelid input
    private static int getUserInput(Scanner sc) {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                input = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // Clear the scanner buffer
            }
        }
        return input;
    }
    
}