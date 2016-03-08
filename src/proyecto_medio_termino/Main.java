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

        switch (option) {

            case 1:
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
        ////TODO: LOGIC OF newMatch

    }

    private static void findMatch(){
        ////TODO: LOGIC of findMatch

    }

    private static void exit(){

        System.out.println("Goodbye.");

    }

}
