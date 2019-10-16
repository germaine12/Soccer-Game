
/*
This Project has:
-three data types variables:integer, string, and double
-four loops
-one two dimensional array
-reads two data files from external files 
-three conditions

 */
package germaineuwimpuhwefinalproject;

import java.io.*;// this is the import for reading file and display
import java.util.Random;// this is import for randomizing
import java.util.Scanner;// this is import for keyboard 

/**
 *
 * @author germaineuwimpuhwe
 */
public class SoccerGame {

    public static void main(String[] args) throws IOException {

        // try statement to catch the exceptions 
        try {
            // Reading desciption file from desktop 
            File descFile = new File("/Users/germaineuwimpuhwe/Desktop/Description.txt");
            Scanner descInputFile = new Scanner(descFile);

            // Reading team file from desktop
            File myFile = new File("/Users/germaineuwimpuhwe/Desktop/teams.txt");
            Scanner inputFile = new Scanner(myFile);
            // a while loop for displaying what has been read from desciption file
            while (descInputFile.hasNext()) {
                String uwimpuhweFile = descInputFile.nextLine();
                System.out.println(uwimpuhweFile);
            }
            descInputFile.close();// closing desciption file

            int[][] soccer;// declaring two dimmension array

            Scanner keyboard = new Scanner(System.in);// turning on the keyboard.
            Random rand = new Random();//turning on the randominzing.

            // asking user to input the number of innings
            System.out.println("");
            System.out.println("How many innings or sections would you like to play? Please enter a positive number: ");
            int number = keyboard.nextInt();// creating a variable called number to take the user's input.
            // a while loop for displaying what has been read from team file
            while (inputFile.hasNext()) {
                // reading
                String germaineFile = inputFile.nextLine();

                // displaying
                System.out.println(germaineFile);

            }
            inputFile.close();

            // creating array for Brazil team and France team
            soccer = new int[2][number];

            // For loop for randomizing the number of scores for each team in each inning and store it in an array.
            for (int inning = 0; inning < number; inning++) {
                // rand.nextInt(n):returns a random integer number between 0 and n. In our case returns an int number between  0 and 20.
                //Assume that no team can score more than 20 scores in one game.
                soccer[0][inning] = rand.nextInt(20);
                soccer[1][inning] = rand.nextInt(20);
            }

            // declaring the total variable for each team
            int homeTotal = 0;
            int visitorTotal = 0;
            // declaring average variables for each team
            Double averageGoalHome = 0.0;
            Double averageGoalVisitor = 0.0;
            //initializing and declaration of a while loop and starting of the while loop
            int inning = 0;
            while (inning < number) {

                System.out.println("  " + soccer[0][inning] + "\t\t" + soccer[1][inning]);//Printing recorded scores for both teams.
                //Keep tracking of total variable for each team.
                homeTotal += soccer[0][inning];
                visitorTotal += soccer[1][inning];
                //updating the counter
                inning++;
            }
            averageGoalHome = (double) homeTotal / number;// calculating the average goal of home 
            averageGoalVisitor = (double) visitorTotal / number;// calculating the average goal of France

            System.out.println("  " + "==\t\t==");// Printing signs to separate the scores and total.

            System.out.println("  " + homeTotal + "\t\t" + visitorTotal);// Printing the total number of scores for each team.
            // Nested if statement that will tell us the winner.
            System.out.println("");// Printing empty space
            if (number > 0) {
                if (homeTotal > visitorTotal) {
                    System.out.println("Brazil Team won! Congratulation!!!");
                } else if (homeTotal == visitorTotal) {
                    System.out.println("It is a tie ");
                } else {
                    System.out.println("France Team won! Congratulation!!!");
                }

            } else {
                System.out.println("The number of innings or sections you entered was invalid. You need to enter at least 1 inning");
            }
            // printing the average goals for each team
            System.out.println("Average goals scored by France: " + String.format("%.2f", averageGoalVisitor) + " vs. Average goals scored by Brazil: " + String.format("%.2f", averageGoalHome));
            System.out.println("");// empt space

        } catch (FileNotFoundException e)// this is FileNotFound exception that occcurs when the program wasn't able to find the input file. 
        {
            System.out.println("oops!!! the inputFile not found! file :" + e.getMessage());
        }

    }
}
