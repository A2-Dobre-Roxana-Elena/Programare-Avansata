/**
 * Laboratorul 1, Homework, Programare Avansata
 * @author Dobre Roxana-Elena
 * grupa 3A2
 */

import static java.lang.System.currentTimeMillis;

public class Main {
    public static void main(String[] args) {
        Integer n, i, j;

        try {
            n = Integer.parseInt(args[0]);      //Testing if args[0] is integer, if the test fail, throws an exception


            if (n <= 30000)
            {
                //Creating and printing the Latin Square n x n
                Integer[][] LatinSquare = new Integer[n][n];
                for(i=0;i<n;i++)
                {
                    LatinSquare[0][i] = i+1;
                    System.out.print(LatinSquare[0][i]+" ");
                }
                System.out.println();
                for(i=1;i<n;i++)
                {
                    LatinSquare[i][n-1] = LatinSquare[i-1][0];
                    for(j=0;j<n-1;j++)
                    {
                        LatinSquare[i][j]= LatinSquare[i-1][j+1];
                        System.out.print(LatinSquare[i][j]+" ");
                    }
                    System.out.println(LatinSquare[i][n-1]+" ");
                }

                //For each line create and display String objects representing the concatenation of the symbols
                String myString;
                for(i=0; i<n;i++)
                {
                    myString= new String("");
                    for(j=0;j<n;j++)
                    {
                        myString+=String.valueOf(LatinSquare[i][j]);

                    }
                    System.out.println("Line "+i+": " +myString);
                }

                //For each column create and display String objects representing the concatenation of the symbols
                for(j=0; j<n;j++)
                {
                    myString= new String("");
                    for(i=0;i<n;i++)
                    {
                        myString+=String.valueOf(LatinSquare[i][j]);

                    }
                    System.out.println("Column "+j+": " +myString);
                }
            }
            else{
                //Creating the Latin Suare n x n
                Integer[][] LatinSquare = new Integer[n][n];
                for(i=0;i<n;i++)
                {
                    LatinSquare[0][i] = i+1;
                }
                for(i=1;i<n;i++)
                {
                    LatinSquare[i][n-1] = LatinSquare[i-1][0];
                    for(j=0;j<n-1;j++)
                    {
                        LatinSquare[i][j]= LatinSquare[i-1][j+1];
                    }
                }

                //Measuring the running time
                long start = currentTimeMillis();
                String myString;
                //For each line create a String objects representing the concatenation of the symbols
                for(i=0; i<n;i++)
                {
                    myString= new String("");
                    for(j=0;j<n;j++) {
                        myString +=
                                String.valueOf(LatinSquare[i][j]);

                    }
                }

                //For each column create a String objects representing the concatenation of the symbols
                for(j=0; j<n;j++) {
                    myString = new String("");
                    for (i = 0; i < n; i++) {
                        myString += String.valueOf(LatinSquare[i][j]);
                    }
                }
                long stop = currentTimeMillis();
                long runningTime = stop-start;
                System.out.println("The running time of the application in milliseconds is "+runningTime);
            }


        }
        catch (Exception e)
        {
            System.out.println("The argument is not an integer!");
        }


    }
}