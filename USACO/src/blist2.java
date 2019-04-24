
/*
ID: xarmeetx
LANG: JAVA
TASK: blist
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class blist2
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(new File("blist.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("blist.out"))));

        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for(int i = 0; i < n; i++)
        {
            segments[i] = new Segment(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(segments);

        //now that times are sorted...
        int count = 0;
        int bucketNumber = 1;
        for (int i = 0; i < n; i++)
        {
            //for each time interval
            Segment currentSegment = segments[i];
            if (i == 0)
            {
                count += currentSegment.bucket;
                segments[i].bucketsUsing.add(bucketNumber);
                segments[i].bucketsUsing.add(bucketNumber);
                continue;
            }

            //check with all the segments before it
            for (int j = i; j >= 0; j--)
            {

            }


        }
    }


    private static class Segment implements Comparable<Segment> {
        int start, end, bucket;
        ArrayList<Integer> bucketsUsing = new ArrayList<>();
        Segment() {
        }
        Segment(int start, int end, int bucket) {
            this.start = start;
            this.end = end;
            this.bucket = bucket;
        }
        public int compareTo(Segment otherSegment) {
            int result = 0;
            if (start != otherSegment.start) {
                result = start < otherSegment.start ? -1 : 1;
            }
            return result;
        }
        public String toString() {
            return "Segment [start=" + start + ", end=" + end + ", bucket= "+ bucket+"]";
        }
    }

}



