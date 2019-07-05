package Bronze;/*
ID: xarmeetx
LANG: JAVA
TASK: lostcow
*/

import java.io.*;
import java.util.Scanner;

public class lostcow
{
    public static void main(String[] args) throws IOException
    {
        //USACO 2017 US Open Contest Bronze Level Problem 1: The Lost Cow

        //to read the input file
        Scanner in = new Scanner(new File("lostcow.in"));
        //to write to the output file
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        //farmerPos is an integer on a  number line
        int farmerPos = in.nextInt();
        //cowPos is an integer on a number line as well
        int cowPos = in.nextInt();
        //moveDistance is the recorded steps(distance) that farmer John has traveled to find his cow
        int moveDistance = 0;

        //is farmer john to the left or right of cow bessie? , T: left, F: right
        boolean isToLeft = farmerPos<cowPos;
        if(isToLeft) { System.out.println("farmer is to the left of the cow"); } else{ System.out.println("farmer is to the right of the cow"); }

        //in the first step, the farmer goes to the right one
        farmerPos+=1;
        //he has traveled one
        moveDistance+=1;

        //if he has reached the cow, just write "1" out to the output file
        if (farmerPos == cowPos) {
            out.write(Integer.toString(moveDistance));
            out.close();
            System.out.println("farmer moved " + moveDistance);
        }
        else
        {
            //now he moves -3, then he will move 6, then -12, then 24
            for (int move = -3; true; move*=-2)
            {
                //move the farmer
                farmerPos+=move;
                //add the distance the farmer moved to moveDistance
                moveDistance += Math.abs(move);
                //if you reach the cow, write out the moveDistance to the output file
                if (farmerPos == cowPos)
                {
                    out.write(Integer.toString(moveDistance));
                    out.close();
                    System.out.println("farmer moved " + moveDistance);
                    break;
                }

                if (isToLeft)
                {
                    if (farmerPos > cowPos)
                    {
                        int difference = farmerPos - cowPos;
                        moveDistance -= difference;
                        out.write(Integer.toString(moveDistance));
                        out.close();
                        System.out.println("farmer moved " + moveDistance);
                        break;
                    }
                } else if (farmerPos < cowPos)
                {
                    int difference = cowPos - farmerPos;
                    moveDistance -= difference;
                    out.write(Integer.toString(moveDistance));
                    out.close();
                    System.out.println("farmer moved " + moveDistance);
                    break;
                }

            }
        }
    }
}
