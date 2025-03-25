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
      
      //Constants
      final int ROWS = 6;
      final int COLUMNS = 7;
      
      //Variables
      int[] board = new int[ROWS * COLUMNS]; //1 = x, 2 = o, 0 = n/a // 1 = player, 2 = player 2, 0 = n/a
      char choice;
      String gameplay;
      
      String username;
      String username2;
      drawBoard(board, ROWS, COLUMNS);
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
      
      plays(board, username, username2, ROWS, COLUMNS);
   }
   
   /* 
   * 
   * Draws the board with the adjusted positions
   *
   */
   public static void drawBoard(int[] board, int ROWS, int COLUMNS) {
      for(int i = 0; i < board.length; i++) {
         if(i%(board.length/ROWS) == 0) {
            System.out.print("\n|");
            for(int e = 0; e < board.length/ROWS; e++) {
               System.out.print("---|");
            }
            System.out.print("\n|");
         }
            
         if(board[i] == 1) {
            System.out.print(" X |");
         } else if(board[i] == 2) {
            System.out.print(" O |");
         } else if (board[i] == 0) {
            System.out.print("   |");
         }
      }
      
      System.out.print("\n\n");
   }
   
   /* 
   * 
   * Players play turn
   *
   */
   public static void plays(int[] board, String username, String username2, int ROWS, int COLUMNS) {
      Scanner input = new Scanner(System.in);
      int turn = 2;
      int column;
      int position = (board.length - 1) - ROWS;
      
      drawBoard(board, ROWS, COLUMNS);
      
      do {
         position = (board.length - 1) - ROWS;   
         
         System.out.println("");
         if(turn%2 == 0) {
            System.out.println("\nIts " + username + " turn!");
         } else {
            System.out.println("\nIts " + username2 + " turn!");
         }
         
         System.out.println("What column do you want to place your piece (1 - 7)?");
         column = input.nextInt() - 1;
         
         do{
            if(!(column >= 0 && column <= 6) || board[column] != 0) {
               System.out.println("Column full or invalid, try a different column.");
               System.out.println("What column do you want to place your piece (1 - 7)?");
               column = input.nextInt() - 1;
            }
         }while(!(column >= 0 && column <= 6) || board[column] != 0);
                  
         do{
            if(board[position + column] != 0) {
               position -= COLUMNS;
            } else {
               break;
            }
         }while(board[position + column] != 0);
         
         if(turn%2 == 0) {
            board[position + column] = 1;
            turn++;
         } else {
            board[position + column] = 2;
            turn++;
         }
         
         drawBoard(board, ROWS, COLUMNS);
      }while(winCondition(board, ROWS, COLUMNS, username, username2));
   }
   
   
   /*
   *
   * The condtion to win the connect 4 game
   *
   */
   public static boolean winCondition(int[] board, int ROWS, int COLUMNS, String player1, String player2) {
      int position = (board.length - 1) - ROWS;
      int previousPlayer = 0;
      int currentPlayer = 0;
      int inARow = 0;
      
      //Column Checker
      
      int column = 0;
      do{
         if(column >= COLUMNS) {
            break;
         }
      
         if(board[position + column] != 0) {
            if(board[position + column] == 1) {
               previousPlayer = currentPlayer;
               currentPlayer = 1;
            } else {
               previousPlayer = currentPlayer;
               currentPlayer = 2;
            }
                  
            if(previousPlayer == currentPlayer && currentPlayer == board[position + column]) {
               inARow++;
            } else {
               inARow = 0;
            }
            
            position -= COLUMNS;
            
            if(inARow >= 3) {
               if(currentPlayer == 1) {
                  System.out.print(player1 + " wins!");
               } else {
                  System.out.print(player2 + " wins!");
               }
               return false;
            }
         } else {
            position = (board.length - 1) - ROWS;
            inARow = 0;
            column++;
         }
      }while(true);
      
      //Row Checker
      
      int currentPosition = 0;
      inARow = 0;
      do{
         if(position + currentPosition > board.length - 1) {
            break;
         }
         
         if(board[position + currentPosition] == 1) {
               previousPlayer = currentPlayer;
               currentPlayer = 1;
            } else {
               previousPlayer = currentPlayer;
               currentPlayer = 2;
            }
                  
            if(previousPlayer == currentPlayer && currentPlayer == board[position + currentPosition]) {
               inARow++;
            } else {
               inARow = 0;
            }
            
            currentPosition++;
            
            if(inARow >= 3) {
               if(currentPlayer == 1) {
                  System.out.print(player1 + " wins!");
               } else {
                  System.out.print(player2 + " wins!");
               }
               return false;
            }
            
      }while(true);
      
      
      return true; //whatever the win or fail part
   }
}