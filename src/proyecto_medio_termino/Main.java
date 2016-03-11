/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366]
 */
package proyecto_medio_termino;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        //Main menu for the program.
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
                ////TODO IMPLEMENT THE findMatch method to resimulate an old match
                findMatch();
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("Please enter a valid option");
                break;
        }



    }

    //Method to create a new match based on the data recollected from the input of the user.
    private static void newMatch (){

        String player1Name, player1LastName, player1Handed;
        String player2Name, player2LastName, player2Handed;
        String tieBreakGame;
        boolean tieBreakConfirm;

        String numberOfSets;
        String serverPlayer;
        int numSets;

        //Creating the Scanner for collecting the input of this method.
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
        System.out.println("2 or 3?");
        numberOfSets = inRm.nextLine();

        if(numberOfSets.equals("2")) numSets = 2;

        //Adding a hidden number of sets for testing purposes so we can do a match of only one set.
        else if(numberOfSets.equals("1")) numSets = 1;
        else numSets = 3;

        System.out.println("Will this match allow tie breaks?");
        System.out.println("Yes or No?");
        tieBreakGame = inRm.nextLine();

        if( tieBreakGame.equals("yes") || tieBreakGame.equals("Yes")) tieBreakConfirm = true;
        else tieBreakConfirm = false;

        System.out.println("Choose which player will Serve first?");
        System.out.println("1)" + player1Name + " " + player1LastName);
        System.out.println("2)" + player2Name + " " + player2LastName);
        serverPlayer = inRm.nextLine();


        Player Player1 = new Player(player1Name, player1LastName, player1Handed);
        Player Player2 = new Player(player2Name, player2LastName, player2Handed);
        Player choosedServerPlayer;

        if(serverPlayer.equals("1"))  choosedServerPlayer = Player1;
        else choosedServerPlayer = Player2;

        //Creating the new Match with all the data collected from the user.
        Match newMatch = new Match(Player1, Player2, choosedServerPlayer, numSets, tieBreakConfirm);

        boolean matchStatus = false;

        while(matchStatus == false){

            Player choosedPlayer = null;
            System.out.println("Which player scored the point?");
            System.out.println("1) " + Player1.getName() + " " + Player1.getLastName());
            System.out.println("2) " + Player2.getName() + " " + Player2.getLastName());


            String option;
            option = inRm.nextLine();

            if (option.equals("1")) choosedPlayer = Player1;
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
            //Creating the new Point with the chosen player and the type of shot he made to score the point.
            Point newPoint = new Point(choosedPlayer,newShot);

            matchStatus = newMatch.addPoint(newPoint);
            System.out.println(matchStatus);
        }

        //Creating the new Match JSON Object
        JSONObject matchObject = new JSONObject();
            matchObject.put("Match", newMatch.getJSONObject());
            System.out.println(matchObject.toJSONString());
        Player matchWinner = newMatch.getWinner();


        if(!new File("MatchesRecord.json").exists())
        {
            FileWriter writer = null;
            try {
                writer = new FileWriter("MatchesRecord.json");
                writer.append(matchObject.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
            }
        }else{
            try {
                BufferedReader reader = new BufferedReader(new FileReader("MatchesRecord.json"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

                ////TODO FIX the match is not giving us the winner its giving us actually the loser.
        System.out.println("The Match winner is " + matchWinner.getName() + " " + matchWinner.getLastName() + "!!!!");
    }

    private static void findMatch(){
        ////TODO: LOGIC of findMatch
        File file = new File("MatchesRecord.json");
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder jsonIn = new StringBuilder();
        while(in.hasNextLine()){
            jsonIn.append(in.nextLine());
        }
        //System.out.println(jsonIn.toString());



        try {

            JSONParser parser = new JSONParser();
            JSONObject ObjRoot = (JSONObject) parser.parse(jsonIn.toString());
            JSONObject objMatch = (JSONObject) ObjRoot.get("Match");

            System.out.println(ObjRoot.toJSONString());
            JSONArray sets = (JSONArray) objMatch.get("set");

            //System.out.println(sets.size());

            for(int i = 0; i < sets.size(); i++){

                JSONObject setsContent = (JSONObject) sets.get(i);
                System.out.println("-----Set " + (i+1) + "-----");
                JSONArray games = (JSONArray) setsContent.get("game");

                for(int j = 0; j < games.size(); j++){

                    JSONObject gamesContent = (JSONObject) games.get(j);
                    String winner = (String) gamesContent.get("winner");
                    boolean tieBreak = (boolean) gamesContent.get("tiebreak");
                    String tieBreakString;

                    if(tieBreak){
                        tieBreakString = "Yes";
                    }else{
                        tieBreakString = "No";
                    }

                    System.out.println("[Game " + (j+1) + "]");
                    System.out.println(" Winner: " + winner);
                    System.out.println(" This Game has Tie Break? " + tieBreakString);
                    JSONArray points = (JSONArray) gamesContent.get("point");

                    for(int q = 0; q < points.size(); q++){

                        JSONObject pointContent = (JSONObject) points.get(q);
                        String scoringPlayer = (String) pointContent.get("player");
                        String shotMade = (String) pointContent.get("shot");

                        System.out.println("  [Point " + (q+1) + "]");
                        System.out.println("   Scoring Player: " + scoringPlayer.toString());
                        System.out.println("   Shot: " + shotMade.toString());
                    }

                }
            }


        } catch (ParseException e) {
            System.out.println("There are no match records available");
        }




    }

    private static void exit(){

        System.out.println("Goodbye.");

    }

    private Boolean registerPoint(Player scoringPlayer){



        return false;
    }

}
