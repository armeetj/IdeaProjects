    /*
    LANG: JAVA
    TASK: combo
     */
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileWriter;
    import java.io.PrintWriter;
    import java.util.HashSet;
    import java.util.Scanner;
    import java.util.Set;

    public class combo
    {
        static int n;

        public static void main(String[] args) throws Exception
        {
            Scanner scanner = new Scanner(new File("combo.in"));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

            //read all input
            n = scanner.nextInt();
            int[] farmerCode = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
            int[] masterCode = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};

            //holds all possibleCombos
            Set<int[]> possibleCombos = new HashSet<>();

            //generate all possible combos
            for(int l1 = 1; l1 <= n; l1++)
            {
                for(int l2 = 1; l2 <= n; l2++)
                {
                    for(int l3 = 1; l3 <= n; l3++)
                    {
                        int[] combo = {l1, l2, l3};
                        if (!possibleCombos.contains(combo))
                        {
                            possibleCombos.add(combo);
                        }
                    }
                }
            }

            //go through each combo and check if it is valid
            int count = 0;
            for(int[] possibleCombo : possibleCombos)
            {
                if (isValid(possibleCombo, farmerCode, masterCode))
                {
                    count++;
                }
            }

            printWriter.println(count);
            printWriter.close();
        }

        public static boolean isValid(int[] combo, int[] farmerCode, int[] masterCode)
        {
            boolean ans1 = true;
            boolean ans2 = true;
            //check if each part of the combo is close (by 2) to either the farmer's code or the master code
            for (int i = 0; i < 3; i++)
            {
                if (!isClose(combo[i], farmerCode[i]))
                {
                    ans1 = false;
                }
            }

            for (int i = 0; i < 3; i++)
            {
                if (!isClose(combo[i], masterCode[i]))
                {
                    ans2 = false;
                }
            }

            return ans1||ans2;
        }
        public static int twoLess(int x)
        {
            if(x == 1)
            {
                return n-1;
            }else if (x == 2)
            {
                return n;
            }else
            {
                return x-2;
            }
        }

        public static int twoMore(int x)
        {
            if(x == n-1)
            {
                return 1;
            }else if (x == n)
            {
                return 2;
            }else
            {
                return x+2;
            }
        }

        public static int oneMore(int x)
        {
            if(x == n)
            {
                return 1;
            }
            return x + 1;
        }

        public static int oneLess(int x)
        {
            if(x == 1)
            {
                return n;
            }
            return x-1;
        }

        public static boolean isClose(int x, int y)
        {
            if (x==y || oneMore(x) == y || oneLess(x) == y || twoLess(x) == y || twoMore(x) == y)
            {
                return true;
            }
            return false;
        }

        public static boolean valsEqual(int[] x, int[] y)
        {
            for(int i = 0; i < x.length; i++)
            {
                if(x[i]!=y[i])
                {
                    return false;
                }
            }
            return true;
        }

    }
