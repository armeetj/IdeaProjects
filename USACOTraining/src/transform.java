
/*
ID: xarmeet1
LANG: JAVA
TASK: transform
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * author: Armeet Singh Jatyani
 * 1-3-19
 * Section 1_3: transform
 */
public class transform
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("transform.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        //dimensions of the grid
        int n = scanner.nextInt();

        int[][] before = new int[n][n];
        int[][] after = new int[n][n];
        //read the input
        for(int i = 0; i < n; i++)
        {
            String line = scanner.next();
            for(int j = 0; j < n; j++)
            {
                before[i][j] = line.charAt(j);
            }
        }
        for(int i = 0; i < n; i++)
        {
            String line = scanner.next();
            for(int j = 0; j < n; j++)
            {
                after[i][j] = line.charAt(j);
            }
        }

        //1: 90 clockwise
        //2: 180
        //3: 270 clockwise or 90 counter clockwise
        //4: reflect horizontally over the middle
        //5: #4 and then #1, 2, or 3
        //6: nothings changes
        //7: invalid

        //start at case 1, keep checking if it matches if it does, return the case number
        //because we want the smallest case number
        if (match(after, rotateNinetyCW(before)))
        {
            printWriter.println(1);
            printWriter.close();
        } else if (match(after, rotateHundredEighty(before)))
        {
            printWriter.println(2);
            printWriter.close();
        } else if (match(after, rotateTwoSeventy(before)))
        {
            printWriter.println(3);
            printWriter.close();
        } else if (match(after, horizontalFlip(before)))
        {
            printWriter.println(4);
            printWriter.close();
        } else if (match(after, combination(before, 1))||(match(after, combination(before, 2))||(match(after, combination(before, 3)))))
        {
            printWriter.println(5);
            printWriter.close();
        } else if (match(before, after))
        {
            printWriter.println(6);
            printWriter.close();
        } else
        {
            printWriter.println(7);
            printWriter.close();
        }
    }

    //case 1
    public static int[][] rotateNinetyCW(int[][] before)
    {
        int n = before.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                result[i][j] = before[n-j-1][i];
            }
        }

        return result;
    }


    //case 2
    public static int[][] rotateHundredEighty(int[][] before)
    {
        int n = before.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                result[i][j] = before[n-i-1][n-j-1];
            }
        }

        return result;
    }

    //case 3
    public static int[][] rotateTwoSeventy(int[][] before)
    {
        int n = before.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                result[i][j] = before[j][n-i-1];
            }
        }

        return result;
    }

    //case 4
    public static int[][] horizontalFlip(int[][] before)
    {
        int n = before.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                result[i][j] = before[i][n-j-1];
            }
        }

        return result;
    }

    //case 5
    public static int[][] combination(int[][] before, int x)
    {
        //x represents which previous step to use, after the horizontal flip
        //x holds values from 1 to 3 inclusive
        int n = before.length;
        int[][] result = new int[n][n];

        //horizontal flip
        result = horizontalFlip(before);

        //either step 1, 2, or 3
        if (x == 1)
        {
            result = rotateNinetyCW(result);
        } else if (x == 2)
        {
            result = rotateHundredEighty(result);
        }else
        {
            result = rotateTwoSeventy(result);
        }

        return result;
    }


    //match to check if two arrays of the same dimensions hold the same entry values
    public static boolean match(int[][] array1, int[][] array2)
    {
        for(int i = 0; i < array1.length; i++)
        {
            for(int j = 0; j < array1.length; j++)
            {
                if (array1[i][j] != array2[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

}