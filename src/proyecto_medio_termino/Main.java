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
        String serverPlayer;
        int numSets;

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
        else if(numberOfSets == "1") numSets = 1;
        else numSets = 5;

        System.out.println("Will this match allow tie breaks?");
        System.out.println("Yes or No?");
        tieBreakGame = inRm.nextLine();

        if( tieBreakGame == "yes" || tieBreakGame == "Yes") tieBreakConfirm = true;
        else tieBreakConfirm = false;

        System.out.println("Choose which player will Serve first?");
        System.out.println("1)" + player1Name + " " + player1LastName);
        System.out.println("2)" + player2Name + " " + player2LastName);
        serverPlayer = inRm.nextLine();

        //inRm.close();

        Player Player1 = new Player(player1Name, player1LastName, player1Handed);
        Player Player2 = new Player(player2Name, player2LastName, player2Handed);
        Player choosedServerPlayer;

        if(serverPlayer == "1")  choosedServerPlayer = Player1;
        else choosedServerPlayer = Player2;

        ////TODO Finish New Match Logic, REMEMBER: TO FIX the Line 94 in the Print of the Winner so it says the name of the winner.
        Match newMatch = new Match(Player1, Player2, choosedServerPlayer, numSets, tieBreakConfirm);

        boolean matchStatus = false;

        while(matchStatus == false){

            Player choosedPlayer = null;
            System.out.println("Which player scored the point?");
            System.out.println("1) " + Player1.getName() + " " + Player1.getLastName());
            System.out.println("2) " + Player2.getName() + " " + Player2.getLastName());


            String option;
            option = inRm.nextLine();

            if (option == "1") choosedPlayer = Player1;
            else choosedPlayer = Player2;


            System.out.println("What type of Shot was is?");
            System.out.println("1)Serve");
            System.out.println("2)Forehand");
            System.out.println("3)Backhand");
            System.out.println("4)Volley");
            System.out.println("5)Lob");
            System.out.println("6)Dropshot");
            System.out.println("7)Smash");
            System.out.println("8)Tweener");
            System.out.println("9)Slice");

            option = inRm.nextLine();
            Shots newShot;
            switch(option){

                case "1":
                    newShot = Shots.SERVE;
                    break;
                case "2":
                    newShot = Shots.FOREHAND;
                    break;
                case "3":
                    newShot = Shots.BACKHAND;
                    break;
                case "4":
                    newShot = Shots.VOLLEY;
                    break;
                case "5":
                    newShot = Shots.LOB;
                    break;
                case "6":
                    newShot = Shots.DROPSHOT;
                    break;
                case "7":
                    newShot = Shots.SMASH;
                    break;
                case "8":
                    newShot = Shots.TWEENER;
                    break;
                case "9":
                    newShot = Shots.SLICE;
                    break;
                default:
                    newShot = Shots.FOREHAND;
                    break;

            }
            System.out.println(newShot.toString());
            ////TODO FINISH IMPLEMENTING & VERIFYING THE NEW POINT SECTION
            Point newPoint = new Point(choosedPlayer,newShot);

            matchStatus = newMatch.addPoint(newPoint);
            System.out.println(matchStatus);
        }

        Player matchWinner = newMatch.getWinner();

        System.out.println("The Match winner is " + matchWinner.getName() + " " + matchWinner.getLastName() + "!!!!");
    }

    private static void findMatch(){
        ////TODO: LOGIC of findMatch

    }

    private static void exit(){

        System.out.println("Goodbye.");

    }

    private Boolean registerPoint(Player scoringPlayer){



        return false;
    }

}
