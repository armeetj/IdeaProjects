import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class reduce
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(new File("reduce.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("reduce.out"))));
        //n is the number of cows
        int n = scanner.nextInt();
        //store the x values in an array
        //store the y values in another array
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        ArrayList<Integer> xCopy = new ArrayList<>();
        ArrayList<Integer> yCopy = new ArrayList<>();


        //x1 and x2 are the least and second least x values
        //x3 and x4 are the second greatest and greatest x values
        int x1, x2, x3, x4;

        //y1 and y2 are the least and second least y values
        //y3 and y4 are the second greatest and greatest y values
        int y1, y2, y3, y4;

        for (int i = 0; i < n; i++)
        {
            x.add(scanner.nextInt());
            xCopy.add(x.get(i));
            y.add(scanner.nextInt());
            yCopy.add(y.get(i));
        }

        Collections.sort(xCopy);
        Collections.sort(yCopy);

        x1 = xCopy.get(0);
        x2 = xCopy.get(1);
        x3 = xCopy.get(n - 2);
        x4 = xCopy.get(n - 1);

        y1 = yCopy.get(0);
        y2 = yCopy.get(1);
        y3 = yCopy.get(n - 2);
        y4 = yCopy.get(n - 1);

        //remove the cows sitting on the extremes of the fence: x1, x4, y1, y4
        ArrayList<Integer> areas = new ArrayList<>();
        //area 1, removing cow on x1
        int area1 = (x4 - x2) * (y4 - y1);
        //area 2, removing cow on x4
        int area2 = (x3 - x1) * (y4 - y1);
        //area 3, removing cow on y1
        int area3 = (x4 - x1) * (y4 - y2);
        //area 4, removing cow on y4
        int area4 = (x4 - x1) * (y3 - y1);

        areas.add(area1);
        areas.add(area2);
        areas.add(area3);
        areas.add(area4);

        //removing any cows on the corners
        //bottom left corner: area 5
        if (y.get(x.indexOf(x1)) == y1 && x.get(y.indexOf(y1)) == x1)
        {
            int area5 = (x4 - x2) * (y4 - y2);
            areas.add(area5);
        }
        //bottom right corner: area 6
        if (y.get(x.indexOf(x4)) == y1 && x.get(y.indexOf(y1)) == x4)
        {
            int area6 = (x3 - x1) * (y4 - y2);
            areas.add(area6);
        }
        //top left corner: area 7
        if(y.get(x.indexOf(x1))==y4 && x.get(y.indexOf(y4)) == x1)
        {
            int area7 = (x4 - x2) * (y3 - y1);
            areas.add(area7);
        }
        //top right corner corner: area 8
        if(y.get(x.indexOf(x4))==y4 && x.get(y.indexOf(y4)) == x4)
        {
            int area8 = (x3 - x1) * (y3 - y1);
            areas.add(area8);
        }

        Collections.sort(areas);
        int answer = areas.get(0);
        printWriter.println(answer);
        printWriter.close();
    }

}