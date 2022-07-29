//Karo Ksachikyan | Comp 482 | Project 3 | Prof. Lord
import java.util.Scanner;
public class Project3{

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("How many light bulbs?");//gets user's input from scanner
        String userIn = sc.nextLine();
        int userBulbs = Integer.parseInt(userIn);//sets value of userBulbs to user's input after parsing int from string

        System.out.println("How many windows?");
        userIn = sc.nextLine();
        int userWindows = Integer.parseInt(userIn);//sets value of userWindows to user's input after parsing int from string

        System.out.println("The answer is " + eggDrop(userBulbs, userWindows) + ".");//calls function and prints returned output

    }
    public static int eggDrop(int bulbs, int windows){
        int [][] numDrops = new int [bulbs+1][windows+1];
        //2d array corresponding to simulated table of values of windows and bulbs,
        //number of drops to find "critical point" where bulbs break.

        for(int i = 0; i < windows+1; i++)
            numDrops[0][i] = 0;
        //populates part of 2d array w/ 0's based on corresponding entries in table
        //(when number of bulbs is 0)

        for(int i = 0; i < windows+1; i++)
            numDrops[1][i] = i;
        //populates part of 2d array w/ value of i when num bulbs is 1, where i is num floors

        for(int i = 0; i < bulbs+1; i++)
            numDrops[i][0] = 0;
        //populates part of 2d array w/ value of 0 when number of windows is 0

        for(int i = 2; i < bulbs+1; i++){
            for(int j = 1; j < windows+1; j++){
                int minimum = Integer.MAX_VALUE;
                //set initial minimum to MAX_VALUE so that anything we compare to it is the new minimum

                for(int k = 1; k < j+1; k++){
                    minimum = min(minimum, (1 + max(numDrops[i][j-k], numDrops[i-1][k-1])));
                }
                numDrops[i][j] = minimum;   //since we set value of minimum in previous loop, we adjust value of corresponding indices
                //in 2d array/table of values. This completes the job of the function
            }
        }
        return numDrops[bulbs][windows];//returns value at index that corresponds to numbers that were given by user input
    }
    public static int min(int numOne, int numTwo){//finds minimum of two values
        return (numOne < numTwo) ? numOne : numTwo;
    }
    public static int max(int numOne, int numTwo){//finds maximum of two values
        return (numOne > numTwo) ? numOne : numTwo;
    }
}