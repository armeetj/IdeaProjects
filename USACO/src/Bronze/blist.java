package Bronze;
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

public class blist
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

        int bucketcount =0;

        //loop for all the segments

        for(Segment segment: segments)
        {
            bucketcount += checkandaddBucket(segment, segments);
//            System.out.println( bucketcount);
        }
        printWriter.println(bucketcount);
        printWriter.close();


    }

    public static int checkandaddBucket (Segment startSegment, Segment[] segments) {

        //check if any bucket is available

        int requiredBuckets = startSegment.bucket;
        for(Segment second: segments) {
            if (canUseSegment(startSegment, second)) {
                if (second.bucket > requiredBuckets)
                {
                    requiredBuckets = 0;
                }else
                {
                    requiredBuckets -= second.bucket;
                }
            }
        }
        return requiredBuckets;
    }

    public static boolean canUseSegment(Segment startSegment, Segment otherSegment)
    {
        if(startSegment.start>=otherSegment.end)
        {
            return true;
        }
        return false;
    }

    private static class Segment implements Comparable<Segment> {
        int start, end, bucket, bucketsAvailable;
        ArrayList<Integer> bucketsUsing = new ArrayList<>();
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
    }

}



