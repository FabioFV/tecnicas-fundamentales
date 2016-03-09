/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366]
 */
package proyecto_medio_termino;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        System.out.println("-----Menu----");
        System.out.println("1) Register Match");
        System.out.println("2) Resimulate old match");
        System.out.println("3) Exit.");

        Scanner in = new Scanner(System.in);

        int option;

        option = in.nextInt();
       // in.close();
        
        switch (option) {

            case 1:
                newMatch();
                break;
            case 2:
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("Please enter a valid option");
                break;
        }



    }

    private static void newMatch (){

        String player1Name, player1LastName, player1Handed;
        String player2Name, player2LastName, player2Handed;
        String tieBreakGame;
        boolean tieBreakConfirm;

        String numberOfSets;
        int serverPlayer, numSets;

        Scanner inRm = new Scanner(System.in);

        System.out.println("Insert the name for player 1:");
        player1Name = inRm.nextLine();
        System.out.println("Insert the last name for player 1:");
        player1LastName = inRm.nextLine();
        System.out.println("Is " + player1Name + " " + player1LastName + " Right Handed or Left Handed?");
        player1Handed = inRm.nextLine();

        System.out.println("Insert the name for player 2:");
        player2Name = inRm.nextLine();
        System.out.println("Insert the last name for player 2:");
        player2LastName = inRm.nextLine();
        System.out.println("Is " + player2Name + " " + player2LastName + " Right Handed or Left Handed?");
        player2Handed = inRm.nextLine();

        System.out.println("Choose the number of Sets for this game:");
        System.out.println("3 or 5?");
        numberOfSets = inRm.nextLine();

        if(numberOfSets == "3") numSets = 3;
        else numSets = 5;

        System.out.println("Will this match allow tie breaks?");
        System.out.println("Yes or No?");
        tieBreakGame = inRm.nextLine();

        if( tieBreakGame == "yes" || tieBreakGame == "Yes") tieBreakConfirm = true;
        else tieBreakConfirm = false;

        System.out.println("Choose which player will Serve first?");
        System.out.println("1)" + player1Name + " " + player1LastName);
        System.out.println("2)" + player2Name + " " + player2LastName);
        serverPlayer = inRm.nextInt();

        //inRm.close();

        Player Player1 = new Player(player1Name, player1LastName, player1Handed);
        Player Player2 = new Player(player2Name, player2LastName, player2Handed);
        Player choosedServerPlayer;

        if(serverPlayer == 1)  choosedServerPlayer = Player1;
        else choosedServerPlayer = Player2;

        ////TODO Finish New Match Logic, REMEMBER: TO FIX the Line 94 in the Print of the Winner so it says the name of the winner.
        Match newMatch = new Match(Player1, Player2, choosedServerPlayer, numSets, tieBreakConfirm);
        Player matchWinner = newMatch.getWinner();

        System.out.println("The Match winner is " + matchWinner);
    }

    private static void findMatch(){
        ////TODO: LOGIC of findMatch

    }

    private static void exit(){

        System.out.println("Goodbye.");

    }

}
