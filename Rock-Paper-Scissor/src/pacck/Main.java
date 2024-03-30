package pacck;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String computerMove() {
        Random rand = new Random();
        int move = rand.nextInt(3);
        switch (move) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissor";
            default:
                return ""; // Default case to handle unexpected scenarios
        }
    }

    public static void checkWinnerPtoP(String playerName1, String playerName2, String playerMove1, String playerMove2) {
		if(playerMove1.equalsIgnoreCase(playerMove2)){
	        System.out.println("It's a tie");
	        System.out.println("Please play again");
	      }
	      
	      
	      else{
	        if(playerMove1.equals("rock")){
	          if(playerMove2.equalsIgnoreCase("Paper")){
	        	  System.out.println("value of move is rock");
	        	  System.out.println("The winner is : "+playerName2);
	          }
	          else{
	        	  System.out.println("value of move is rock");
	        	  System.out.println("The winner is Computer");
	          }
	        }
	        else if(playerMove1.equals("paper")){
	          if(playerMove2.equalsIgnoreCase("scissor")){
	            System.out.println("Congratulation "+playerName2+" you won the game");
	          }
	          else{
	            System.out.println("The winner is Computer");
	          }
	        }
	        else if(playerMove1.equals("scissor")){
	        	if(playerMove2.equalsIgnoreCase("rock")){
	        		System.out.println("The winner is : "+playerName2);
	        	}
	        	else{
	        		System.out.println("The winner is Computer");
	          }
	        }
	        
	      }
		
	}

  public static void main(String args[]){
	  Scanner sc = new Scanner(System.in);
    
	  checkWinnerPtoP("aman","ajeet","rock","scissor");
	  String play = "Yes";
	  while(play.equals("yes")) {
		  
    	
	  }
  	}
}