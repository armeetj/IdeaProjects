/*
ID: xarmeetx
LANG: JAVA
TASK: photo
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class photo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("photo.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("photo.out"))));

        int numCows = scanner.nextInt();
        int cowseq[] = new int[numCows + 1];
        BitSet cows = new BitSet(numCows);
        int[] numbers = new int[numCows - 1];
        //always start with the first position
        int currentPos = 1;
        cowseq[currentPos] = currentPos;
        cows.flip(currentPos);
        for (int i = 0; i < numCows - 1; i++) {
            numbers[i] = scanner.nextInt();
            // try to make the first number
            int numberToMake = numbers[i];
            int sequenceToFill = (numberToMake - cowseq[currentPos]);
            if (!cows.get(sequenceToFill)) {
                cowseq[++currentPos] = sequenceToFill;
                cows.flip(sequenceToFill);
            } else {
                //swap the numbers for first position
                if (currentPos == 2) {
                    int temp = cowseq[currentPos];
                    cowseq[currentPos] = cowseq[currentPos - 1];
                    cowseq[currentPos - 1] = temp;
                    sequenceToFill = (numberToMake - cowseq[currentPos]);
                    cowseq[++currentPos] = sequenceToFill;
                    cows.flip(sequenceToFill);
                }
            }
        }

        for (int k = 1; k < numCows; k++) {
            printWriter.print(cowseq[k] + " ");
        }
        printWriter.print(cowseq[numCows]);
        printWriter.close();
    }
}
