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
      drawBoard(board);
      System.out.println("What is your name?");
      username = input.nextLine();
      
      System.out.println("Hello " + username + "!");
      System.out.println("Would you like to play with a computer? (Y/N)");
      choice = input.nextLine().toLowerCase().charAt(0);
      
      if(choice == 'n') {
         System.out.println("Would you like to play with 2 players? (Y/N)");
         choice = input.nextLine().toLowerCase().charAt(0);
         gameplay = "2 Player";
      } else {
         gameplay = "Computer";
      }
   }
   
   /* 
   * 
   * Draws the board with the adjusted positions
   *
   */
   public static void drawBoard(int[] board) {
      for(int i = 0; i < 42; i++) {
         if(i%7 == 0) {
            System.out.println("\n|---|---|---|---|---|---|");
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
   * AIs play turn
   *
   */
   public static void playAI() {
      
   }

}