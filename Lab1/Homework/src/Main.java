import static java.lang.System.currentTimeMillis;

public class Main {
    public static void main(String[] args) {
        Integer n = -1, i, j;

        try {

            n = Integer.parseInt(args[0]); /// aici se lanseaza o eroare daca nu e bine, soo, eu validez
            if (n == -1)
                System.out.println("Nu ati introdus un numar ca si parametru");

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


            if (n <= 30000)
            {
                String myString;
                for(i=0; i<n;i++)
                {
                    myString= new String("");
                    for(j=0;j<n;j++)
                    {
                        myString+=String.valueOf(LatinSquare[i][j]);

                    }
                    System.out.println("Linia "+i+": " +myString);
                }

                for(j=0; j<n;j++)
                {
                    myString= new String("");
                    for(i=0;i<n;i++)
                    {
                        myString+=String.valueOf(LatinSquare[i][j]);

                    }
                    System.out.println("Coloana "+j+": " +myString);
                }
            }
            else{

                long start = currentTimeMillis();
                String myString;
                for(i=0; i<n;i++)
                {
                    myString= new String("");
                    for(j=0;j<n;j++) {
                        myString += String.valueOf(LatinSquare[i][j]);

                    }
                }

                for(j=0; j<n;j++) {
                    myString = new String("");
                    for (i = 0; i < n; i++) {
                        myString += String.valueOf(LatinSquare[i][j]);
                    }
                }
                long stop = currentTimeMillis();
                long runningTime = stop-start;
                System.out.println("Timpul rularii in milisecunde este egal cu "+runningTime);
            }


        }
        catch (Exception e)
        {
            System.out.println("Nu ati introdus un numar!");
        }


    }
}