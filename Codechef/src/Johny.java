import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Johny
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++)
        {
            long n = scanner.nextInt();
            ArrayList<Long> songs = new ArrayList<>();
            for (int j = 0; j < n; j++)
            {
                songs.add(scanner.nextLong());
            }
            long val = songs.get(scanner.nextInt()-1);

            Collections.sort(songs);
            int index = songs.indexOf(val)+1;
            System.out.println(index);
        }
    }
}
