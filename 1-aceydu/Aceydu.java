
public class Aceydu {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Aceydu Game\nEnter \"y\" to start the game and \"n\" to exit the game."); 
    String userinp_raw = scanner.nextLine();
    char userinp = userinp_raw.charAt(0);
    switch (userinp) {
      case 'y' -> game();
      case 'n' -> {
        System.out.println("You chose to exit the program.");
        System.exit(0);
      }
      default -> {
        while (true) {
        System.out.println("Invalid input, please enter a valid value (y/n): ");
        userinp_raw = scanner.nextLine(); 
        userinp = userinp_raw.charAt(0);
        if (userinp == 'y' || userinp == 'n') {
          if (userinp == 'y'){ game(); }
          else{ System.exit(0);}
          break;
        }
        else {
          continue;
          }
        }
      }
  
    }
  }


  public static void game() { 
    Scanner scanner = new Scanner(System.in);
    int user_money = 100;
    int bet = 0;
    while (user_money >= 2) {  
      int face_card1 = ThreadLocalRandom.current().nextInt(2, 15);
      int face_card2 = ThreadLocalRandom.current().nextInt(2, 15);
      int[] Cards = {face_card1, face_card2};
      System.out.println("\nThese are the two cards that came up: \n");
      printCards(Cards);
      while(true){
      try{  
        System.out.printf("If you want to bet this time, select your bet amount or enter 0 to skip and Ctrl+c to exit.\nYour Current Balance is: $%d.\n\nEnter your bet: ", user_money);
        bet = Integer.parseInt(scanner.nextLine());
        if (bet >= user_money) {
          System.out.println("\nYou cannot bet more or equal to the amount you have left.\n");
          continue;
        }
        else{
          break;
        }
      } catch (Exception e) {
        System.out.print("Error: Enter a valid number as a bet: ");
      }}
      int third_card = ThreadLocalRandom.current().nextInt(2, 15);
      if (third_card > face_card1 && third_card < face_card2 || third_card < face_card1 && third_card > face_card2) {
      try{  
        clearConsole();
        System.out.println("The card was: "+third_card);
      } catch (Exception e) {
        System.out.println("Error cleaning the console: "+e.getMessage());
      }
        if (bet == 0) {
          System.out.println("\nDamn, just like that you missed the chance");
        }
        else{
        System.out.println("You win the bet.");
        user_money += bet;
        System.out.println("\nYou now have: $"+user_money);
        }
      }
      else{
      try{  
        clearConsole();
        System.out.println("The card was: "+third_card);
      } catch (Exception e) {
        System.out.println("Error cleaning the console: "+e.getMessage());
      }
        if (bet == 0) {
          System.out.println("\nGood Save Mate!");
        }
        else{
        System.out.println("You lost the bet.");
        user_money -= bet;
        System.out.println("\nYou now have: $"+user_money);
        }
      }
  }
    System.out.println("\nYou don't have enough money to bet. Please restart the program.\n");
    System.exit(0);
}


// should've implemented switch case. 
  public static void printCards(int[] Cards){
     for (int card :Cards) {
        if (card == 14) {
          System.out.println("Ace\n");
        }
        else if (card == 13) {
          System.out.println("King\n");
        }
        else if (card == 12) {
          System.out.println("Queen\n");
          
        }
        else if (card == 11) {
          System.out.println("Jack\n");
        }
        else {
        System.out.println(card+"\n");
      } 
     } 

  }
  

  public static void clearConsole() throws IOException, InterruptedException{
    try {
      final String os = System.getProperty("os.name");
      
      if (os.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }
      else {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
