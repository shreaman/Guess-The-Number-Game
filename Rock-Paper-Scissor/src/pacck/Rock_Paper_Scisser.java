package pacck;
import java.util.Scanner;
import java.util.Random;

public class Rock_Paper_Scisser {
	
	//Method to check against invalid input.
	private static String invalidInput(Scanner sc) {
        if (sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a string.");
            sc.next(); 
            return invalidInput(sc); 
        } else {
            return sc.next();
        }
    }
	
	//method to generate computer's move.
	private static String computerMove() {
		Random rand = new Random();
		int move = rand.nextInt(3);
		String computerMove;
		
		if(move==0) {
			computerMove = "rock";	
		}
		else if(move==1) {
			computerMove = "paper";
		}
		else {
			computerMove = "scissor";
		}
		return computerMove;
	}
	
	//checking the winner for player vs player
	public static void checkWinnerPtoP(String playerName1, String playerName2, String playerMove1, String playerMove2) {
		if(playerMove1.equalsIgnoreCase(playerMove2)){
	        System.out.println("It's a tie");
	        System.out.println("Please play again");
	      }
	      
	      
	      else{
	        if(playerMove1.equals("rock")){
	          if(playerMove2.equalsIgnoreCase("Paper")){
	        	  System.out.println("The winner is : "+playerName2);
	          }
	          else{
	        	  System.out.println("The winner is "+playerName1);
	          }
	        }
	        else if(playerMove1.equals("paper")){
	          if(playerMove2.equalsIgnoreCase("scissor")){
	            System.out.println("Congratulation "+playerName2+" you won the game");
	          }
	          else{
	        	  System.out.println("The winner is "+playerName1);
	          }
	        }
	        else if(playerMove1.equals("scissor")){
	        	if(playerMove2.equalsIgnoreCase("rock")){
	        		System.out.println("The winner is : "+playerName2);
	        	}
	        	else{
	        		System.out.println("The winner is "+playerName1);
	          }
	        }
	        
	      }
		
	}
	
	//Checking who the winner for player vs computer
	public static void checkWinner(String playerMove, String playerName) {
	      String move = computerMove();
	      
	      
	      if(playerMove.equalsIgnoreCase(move)){
	        System.out.println("It's a tie");
	        System.out.println("Please play again");
	      }
	      
	      
	      else{
	        if(move.equals("rock")){
	          if(playerMove.equalsIgnoreCase("Paper")){
	        	  System.out.println("The winner is : "+playerName);
	          }
	          else{
	        	  System.out.println("The winner is Computer");
	          }
	        }
	        else if(move.equals("paper")){
	          if(playerMove.equalsIgnoreCase("scissor")){
	            System.out.println("Congratulation "+playerName+" you won the game");
	          }
	          else{
	            System.out.println("The winner is Computer");
	          }
	        }
	        else if(move.equals("scissor")){
	        	if(playerMove.equalsIgnoreCase("rock")){
	        		System.out.println("The winner is : "+playerName);
	        	}
	        	else{
	        		System.out.println("The winner is Computer");
	          }
	        }
	        
	      }
	    }

	
	public static boolean validatePlayerInput(String input) {
		String playerMove = input.toLowerCase();
		return playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors");
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("main method executing");
		Scanner sc = new Scanner(System.in);
		
		
		boolean startGame = true;
		while(startGame) {
			System.out.println("\nPlease enter your choice \n P2P for player to player \n C2P for Computer vs player");
			String choice = invalidInput(sc);
			//if the player's choice is p2p
			if(choice.equalsIgnoreCase("p2p")) {
				System.out.println("Enter player1 name :");
				String player1 = invalidInput(sc);
				System.out.println("Enter player2 name :");
				String player2 = invalidInput(sc);
				
				//Taking the player's move
				System.out.println(player1+" enter your move  :");
				String movePlayer1 = invalidInput(sc);
				
				//checking if player1 has taken the right move
				if(!validatePlayerInput(movePlayer1)) {
					System.out.println("Invalid move for :"+player1);
					while(!validatePlayerInput(movePlayer1)) {
						System.out.println("\nInvalid input please enter one of the given \n'Rock' \n'Papaer' \n'Sicssor'");
						System.out.println("Please re-enter");
						movePlayer1 = invalidInput(sc);
					}
				}
				//checking if player2 has taken the right move
				System.out.println(player2+" enter your move  :");
				String movePlayer2 = invalidInput(sc);
				if(!validatePlayerInput(movePlayer2)) {
					System.out.println("Invalid move for :"+player2);
					while(!validatePlayerInput(movePlayer2)) {
						System.out.println("\nInvalid input please enter one of the given \n'Rock' \n'Papaer' \n'Sicssor'");
						System.out.println("Please re-enter");
						movePlayer2 = invalidInput(sc);
					}
				}
				
				//check if the user have taken the right move
				
				checkWinnerPtoP(player1,player2,movePlayer1,movePlayer2);
				
				
			}
			
			//if the player's choice is c2p
			else if(choice.equalsIgnoreCase("c2p")) {
				
				System.out.println("Please enter your name : ");
				String name = invalidInput(sc);
				
				System.out.println("\n"+name+" please enter your move");
				String playerMove = invalidInput(sc);
				
				
				//check if the user have taken the right move
				if(validatePlayerInput(playerMove)) {
					checkWinner(playerMove,name);
				}
				else {
					while(!validatePlayerInput(playerMove)) {
						System.out.println("\nInvalid input please enter one of the given \n'Rock' \n'Papaer' \n'Sicssor'");
						System.out.println(name+" please enter your move");
						playerMove = invalidInput(sc);
						checkWinner(playerMove,name);
					}
				}
				
				
			}
			else {
				System.out.println("Invalid input");
			}
			
			System.out.println("\nTo play again enter 'yes' otherwise any keyword");
			String playAgain = invalidInput(sc);
			if(!playAgain.equalsIgnoreCase("yes")) {
				startGame = false;
			}
			
		}		
		System.out.println("Thank for playing");
		sc.close();
	}
}

