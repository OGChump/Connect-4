import java.util.Scanner;

/**

Connect 4

@authors Denali Miao, Joseph Rosemond

*/
public class Connect_4 {

   /* 
   * 
   * Starts the program
   * @param arg command line arguments
   *
   */
   public static void main(String[] arg) {
   
      Scanner input = new Scanner(System.in);
      
      //Variables
      int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //1 = x, 2 = o, 0 = n/a
      int[] playerMoves; //1 = player, 2 = computer, 0 = n/a
      char choice;
      String gameplay;
      
      String username;
      String username2;
      
      System.out.println("What is your name?");
      username = input.nextLine();
      
      System.out.println("Hello " + username + "!");
      System.out.println("Would you like to play with a computer? (Y/N)");
      choice = input.nextLine().toLowerCase().charAt(0);
      
      if(choice == 'n') {
         System.out.println("You have choose to play the 2 player mode");
         System.out.println("Mode: 2 player");
         gameplay = "2 Player";
      } else {
         System.out.println("Playing the computer was never a fucking option, you only need one friend find one.");
         System.out.println("Mode: 2 player");
         gameplay = "2 player";
      }
      
      System.out.println("What is your friends name?");
      username2 = input.nextLine();
      
      plays(board, username, username2);
   }
   
   /* 
   * 
   * Draws the board with the adjusted positions
   *
   */
   public static void drawBoard(int[] board) {
      for(int i = 0; i < 42; i++) {
         if(i%7 == 0) {
            System.out.println("\n|---|---|---|---|---|---|---|");
            System.out.print("|");
         } else {
            if(board[i] == 1) {
               System.out.print(" X |");
            } else if(board[i] == 2) {
               System.out.print(" O |");
            } else if (board[i] == 0) {
               System.out.print("   |");
            }
            
            if(i%7 == 0) {
               System.out.println();
            }
         }  
      }
   }
   
   /* 
   * 
   * Players play turn
   *
   */
   public static void plays(int[] board, String username, String username2) {
      Scanner input = new Scanner(System.in);
      int turn = 2;
      int column;
      int position = 6;
      
      do {
         drawBoard(board);
         System.out.println("");
         if(turn%2 == 0) {
            System.out.println("\nIts " + username + " turn!");
         } else {
            System.out.println("\nIts " + username2 + " turn!");
         }
         
         System.out.println("What column do you want to place your piece?");
         column = input.nextInt();
                  
         do{
            if(board[position * column] != 0) {
               position--;
            } else {
               break;
            }
         }while(board[position * column] != 0);
         
         if(turn%2 == 0) {
            board[position * column] = 1;
            turn++;
         } else {
            board[position * column] = 2;
         }
      }while(true); //Win condition needs to be here
   }

}