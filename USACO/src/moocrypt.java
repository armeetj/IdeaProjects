import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class moocrypt
{
    public static void main(String[] args) throws Exception
    {
        //input/output
        Scanner scanner = new Scanner(new File("moocrypt.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("moocrypt.out")));

        //r: number of rows
        int r = scanner.nextInt();
        //c: number of columns
        int c = scanner.nextInt();

        //create an grid with the appropriate dimensions
        String[][] grid = new String[r][c];

        //read input
        for (int i = 0; i < r; i++)
        {
            String temp = scanner.next();
            for (int j = 0; j < c; j++)
            {
                grid[i][j] = Character.toString(temp.charAt(j));
            }
        }

        //start from the top left, keep going down, find all the possible M's
        LinkedList<String> M = new LinkedList<>();
        LinkedList<String> O = new LinkedList<>();
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (isM(grid, i, j)&& !M.contains(grid[i][j]) && !grid[i][j].equals("M"))
                {
                    M.add(grid[i][j]);
                }
            }
        }
        //start from the top left, keep going down, find all the possible M's
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (isO(grid, i, j) && !O.contains(grid[i][j]) && !grid[i][j].equals("O"))
                {
                    O.add(grid[i][j]);
                }
            }
        }
        //now we have found all the possible m's and all the possible o's
        //for each combination, find the number of moo's, if this is greater than the answer, make the answer this value
        int answer = 0;
        for (int m = 0; m < M.size(); m++)
        {
            for (int o = 0; o < O.size(); o++)
            {
                if (!M.get(m).equals(O.get(o)))
                {
                    int temp = count(grid, M.get(m), O.get(o));
                    if (temp > answer)
                    {
                        answer = temp;
                    }
                }
            }
        }

        printWriter.println(answer);
        printWriter.close();
    }

    public static boolean isM(String[][] grid, int i, int j)
    {
        //check all directions:
        //up
        if (i - 2 >= 0)
        {
            if (grid[i - 1][j].equals(grid[i-2][j]))
            {
                return true;
            }
        }
        //down
        if (i + 2 < grid.length)
        {
            if(grid[i+1][j].equals(grid[i+2][j]))
            {
                return true;
            }
        }
        //left
        if (j-2 >= 0)
        {
            if(grid[i][j-2].equals(grid[i][j-1]))
            {
                return true;
            }
        }
        //right
        if (j+2 < grid[0].length)
        {
            if(grid[i][j+2].equals(grid[i][j+1]))
            {
                return true;
            }
        }
        //diagonal (top left, bottom right)
        if (i+2 < grid.length && j+2 < grid[0].length)
        {
            if(grid[i+1][j+1].equals(grid[i+2][j+2]))
            {
                return true;
            }
        }
        //diagonal (bottom right, top left)
        if (i-2 >= 0 && j-2 >= 0)
        {
            if(grid[i-1][j-1].equals(grid[i-2][j-2]))
            {
                return true;
            }
        }
        //diagonal (top right, bottom left)
        if (i+2 < grid.length && j-2 >= 0)
        {
            if(grid[i+1][j-1].equals(grid[i+2][j-2]))
            {
                return true;
            }
        }
        //diagonal (bottom left, top right)
        if (i-2 >= 0 && j+2 < grid[0].length)
        {
            if(grid[i-1][j+1].equals(grid[i-2][j+2]))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isO(String[][] grid, int i, int j)
    {
        //check all directions:
        //up
        if (i - 1 >= 0)
        {
            if (grid[i - 1][j].equals(grid[i][j]))
            {
                return true;
            }
        }
        //down
        if (i + 1 < grid.length)
        {
            if(grid[i+1][j].equals(grid[i][j]))
            {
                return true;
            }
        }
        //left
        if (j-1 >= 0)
        {
            if(grid[i][j-1].equals(grid[i][j]))
            {
                return true;
            }
        }
        //right
        if (j+1 < grid[0].length)
        {
            if(grid[i][j+1].equals(grid[i][j]))
            {
                return true;
            }
        }
        //diagonal (top left, bottom right)
        if (i + 1 < grid.length && j + 1 < grid[0].length)
        {
            if (grid[i + 1][j + 1].equals(grid[i][j]))
            {
                return true;
            }
        }
        //diagonal (bottom right, top left)
        if (i-1 >= 0 && j-1 >= 0)
        {
            if(grid[i-1][j-1].equals(grid[i][j]))
            {
                return true;
            }
        }
        //diagonal (top right, bottom left)
        if (i+1 < grid.length && j-1 >= 0)
        {
            if(grid[i+1][j-1].equals(grid[i][j]))
            {
                return true;
            }
        }
        //diagonal (bottom left, top right)
        if (i-1 >=0 && j+1 < grid[0].length)
        {
            if(grid[i-1][j+1].equals(grid[i][j]))
            {
                return true;
            }
        }
        return false;
    }

    public static int count(String[][] grid, String m, String o)
    {
        int count = 0;
        //start from top left corner and find the m
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j].equals(m))
                {
                    //if it is the m, check for the 2 o's around it:
                    //up
                    if (i - 2 >= 0)
                    {
                        if (grid[i - 1][j].equals(grid[i-2][j]) && grid[i - 1][j].equals(o))
                        {
                            count++;
                        }
                    }
                    //down
                    if (i + 2 < grid.length)
                    {
                        if(grid[i+1][j].equals(grid[i+2][j]) && grid[i + 1][j].equals(o))
                        {
                            count++;
                        }
                    }
                    //left
                    if (j-2 >= 0)
                    {
                        if(grid[i][j-2].equals(grid[i][j-1]) && grid[i][j-2].equals(o))
                        {
                            count++;
                        }
                    }
                    //right
                    if (j+2 < grid[0].length)
                    {
                        if(grid[i][j+2].equals(grid[i][j+1])&& grid[i][j+2].equals(o))
                        {
                            count++;
                        }
                    }
                    //diagonal (top left, bottom right)
                    if (i+2 < grid.length && j+2 < grid[0].length)
                    {
                        if(grid[i+1][j+1].equals(grid[i+2][j+2])&& grid[i+1][j+1].equals(o))
                        {
                            count++;
                        }
                    }
                    //diagonal (bottom right, top left)
                    if (i-2 >= 0 && j-2 >= 0)
                    {
                        if(grid[i-1][j-1].equals(grid[i-2][j-2])&& grid[i-1][j-1].equals(o))
                        {
                            count++;
                        }
                    }
                    //diagonal (top right, bottom left)
                    if (i+2 < grid.length && j-2 >= 0)
                    {
                        if(grid[i+1][j-1].equals(grid[i+2][j-2])&& grid[i+1][j-1].equals(o))
                        {
                            count++;
                        }
                    }
                    //diagonal (bottom left, top right)
                    if (i-2 >= 0 && j+2 < grid[0].length)
                    {
                        if(grid[i-1][j+1].equals(grid[i-2][j+2])&& grid[i-1][j+1].equals(o))
                        {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}