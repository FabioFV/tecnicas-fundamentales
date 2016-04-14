package proyecto_final;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Loammi on 13/4/2016.
 */
public class Main {

    public static void main(String args[])
    {
        System.out.println("-----Menu----");
        System.out.println("1) Register Match");
        System.out.println("2) Resimulate old match");
        System.out.println("3) Exit.");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        switch(option){
            case 1:
                newMatch();
                break;
            case 2:
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

    private static void newMatch()
    {
        Match newMatch = new Match();
        String player1Name, player1LastName, player1Handed;
        String player2Name, player2LastName, player2Handed;
        String tieBreakGame;
        boolean tieBreakConfirm;

        String numberOfSets;
        String serverPlayer;
        int numSets;

        Scanner in = new Scanner(System.in);

        System.out.println("Insert the name for player 1:");
        player1Name = in.nextLine();
        System.out.println("Insert the last name for player 1:");
        player1LastName = in.nextLine();
        System.out.println("Is " + player1Name + " " + player1LastName + " Right Handed or Left Handed?");
        player1Handed = in.nextLine();

        System.out.println("Insert the name for player 2:");
        player2Name = in.nextLine();
        System.out.println("Insert the last name for player 2:");
        player2LastName = in.nextLine();
        System.out.println("Is " + player2Name + " " + player2LastName + " Right Handed or Left Handed?");
        player2Handed = in.nextLine();

        System.out.println("Choose the number of Sets for this game: 2 or 3? ");
        numberOfSets = in.nextLine();

        System.out.println("Will this match allow tie breaks?");
        System.out.println("Yes or No?");
        tieBreakGame = in.nextLine();

        System.out.println("Choose which player will Serve first?");
        System.out.println("1)" + player1Name + " " + player1LastName);
        System.out.println("2)" + player2Name + " " + player2LastName);
        serverPlayer = in.nextLine();

            System.out.println("Please confirm the information is ok!");
            System.out.println("Player 1: " + player1Name + " " + player1LastName + " " + player1Handed);
            System.out.println("Player 2: " + player2Name + " " + player2LastName + " " + player2Handed);
            System.out.println("Number of Sets: " + numberOfSets);
            System.out.println("Tie Break Allowed: " + tieBreakGame);
            System.out.println("Server Player: " + serverPlayer);
            System.out.println("Ok      No");

            String ans = in.nextLine();

            if (ans.equals("No")) {
                System.out.println("Which field would you like to modify? (Introduce the number that corresponds to your choice)");
                System.out.println("1) Player 1 information \n2)Player 2 infomation\n3)Number of sets");
                System.out.println("4) Tie Break Alloed \n5) Server Player");
                int op = in.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Insert the name for player 1:");
                        player1Name = in.nextLine();
                        System.out.println("Insert the last name for player 1:");
                        player1LastName = in.nextLine();
                        System.out.println("Is " + player1Name + " " + player1LastName + " Right Handed or Left Handed?");
                        player1Handed = in.nextLine();
                        break;
                    case 2:
                        System.out.println("Insert the name for player 2:");
                        player2Name = in.nextLine();
                        System.out.println("Insert the last name for player 2:");
                        player2LastName = in.nextLine();
                        System.out.println("Is " + player2Name + " " + player2LastName + " Right Handed or Left Handed?");
                        player2Handed = in.nextLine();
                        break;
                    case 3:
                        System.out.println("Choose the number of Sets for this game: 2 or 3? ");
                        numberOfSets = in.nextLine();
                        break;
                    case 4:
                        System.out.println("Will this match allow tie breaks?");
                        System.out.println("Yes or No?");
                        tieBreakGame = in.nextLine();
                        break;
                    case 5:
                        System.out.println("Choose which player will Serve first?");
                        System.out.println("1)" + player1Name + " " + player1LastName);
                        System.out.println("2)" + player2Name + " " + player2LastName);
                        serverPlayer = in.nextLine();
                        break;
                    default:
                        System.out.println("Please introduce a valid option");
                        break;
                }
            }

        Player player1 = new Player(player1Name, player1LastName, player1Handed);
        Player player2 = new Player(player2Name, player2LastName, player2Handed);

        if(numberOfSets.equals("2")) numSets = 2;
        else numSets = 3;

        if( tieBreakGame.equals("yes") || tieBreakGame.equals("Yes")) tieBreakConfirm = true;
        else tieBreakConfirm = false;

        Player choosedServerPlayer;
        if(serverPlayer.equals("1"))  choosedServerPlayer = player1;
        else choosedServerPlayer = player2;

        newMatch.init(player1, player2, choosedServerPlayer, numSets, tieBreakConfirm);

        boolean matchStatus = false;
        Point lastScored = null;

        while(matchStatus == false) {

            Player choosedPlayer = null;
            System.out.println("Options: \n 1) Register scored point \n 2)Change last scored point \n");
            String opt = in.nextLine();
            if(opt.equals("1")){
                System.out.println("Which player scored the point?");
            System.out.println("1) " + player1.getName() + " " + player1.getLastName());
            System.out.println("2) " + player2.getName() + " " + player2.getLastName());

            String option;
            option = in.nextLine();

            if (option.equals("1")) choosedPlayer = player1;
            else choosedPlayer = player2;

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

            option = in.nextLine();
            Shots newShot;
            switch (option) {

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
            Point newPoint = new Point(choosedPlayer, newShot);
            lastScored = newPoint;
        }else
            {
                System.out.println("Which player scored the point?");
                System.out.println("1) " + player1.getName() + " " + player1.getLastName());
                System.out.println("2) " + player2.getName() + " " + player2.getLastName());
                String option;
                option = in.nextLine();
                if (option.equals("1")) choosedPlayer = player1;
                else choosedPlayer = player2;
                lastScored.setPlayer(choosedPlayer);
                
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

                option = in.nextLine();
                Shots nShot;
                switch (option) {

                    case "1":
                        nShot = Shots.SERVE;
                        break;
                    case "2":
                        nShot = Shots.FOREHAND;
                        break;
                    case "3":
                        nShot = Shots.BACKHAND;
                        break;
                    case "4":
                        nShot = Shots.VOLLEY;
                        break;
                    case "5":
                        nShot = Shots.LOB;
                        break;
                    case "6":
                        nShot = Shots.DROPSHOT;
                        break;
                    case "7":
                        nShot = Shots.SMASH;
                        break;
                    case "8":
                        nShot = Shots.TWEENER;
                        break;
                    case "9":
                        nShot = Shots.SLICE;
                        break;
                    default:
                        nShot = Shots.FOREHAND;
                        break;
                }

                lastScored.setShot(nShot);
            }
            if(lastScored != null)
            matchStatus = newMatch.addPoint(lastScored);
            //print it to make the user sure the change was done
            System.out.println(lastScored.getPlayer().getName() +" "+ lastScored.getPlayer().getLastName());
            System.out.println(lastScored.getShot().toString());
        }

        JSONObject matchObject = new JSONObject();
        try {
            matchObject.put("Match", newMatch.getJSONObject());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter("MatchesRecord.json");
            writer.append(matchObject.toString());
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

        Player matchWinner = newMatch.getWinner();
        //Print out the Winner to the user
        System.out.println("The Match winner is " + matchWinner.getName() + " " + matchWinner.getLastName() + "!!!!");
    }
    private static void findMatch()
    {
        ////TODO: LOGIC of findMatch
        File file = new File("MatchesRecord.json");
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("There are no match records available");
            return;
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

            //System.out.println(ObjRoot.toJSONString());
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
                        String score = (String) pointContent.get("score");

                        System.out.println("  [Point " + (q+1) + "]");
                        System.out.println("   Scoring Player: " + scoringPlayer.toString());
                        System.out.println("   Shot: " + shotMade.toString());
                        System.out.println("   Score: " + score.toString());
                    }

                }
            }


        } catch (ParseException e) {
            System.out.println("There are no match records available");
        }
    }


    private static void exit()
    {
        System.out.println("Thanks for using. Goodbye");
    }
}
