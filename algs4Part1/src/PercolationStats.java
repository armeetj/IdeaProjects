import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats
{
    static Percolation percolation;
    static int n;
    static int trials;
    static double mean;
    static double stddev;
    static double[] data;
    public PercolationStats(Integer n, int trials)
    {
        // perform T independent experiments on an n-by-n grid
        //create n by n grid
        percolation = new Percolation(n);
        this.n = n;
        this.trials = trials;

        mean = mean();
        stddev = stddev();
        System.out.println("mean                    = " + mean);
        System.out.println("stddev                  = " + stddev);
        System.out.println("95% confidence interval = ["+confidenceLo()+", "+confidenceHi()+"]");

    }

    public static void putNextIndex(double[] array, double value)
    {
        for(int i = 0; i < array.length; i++)
        {
            if (array[i] != 0.0d)
            {
                array[i] = value;
                return;
            }
        }
    }

    public double mean()
    {
        double answer = 0;
        // sample mean of percolation threshold
        for(int i = 0; i < trials; i++)
        {
            //open a random site
            percolation.open(Integer.parseInt(Double.toString(Math.random() * (n))), Integer.parseInt(Double.toString(Math.random() * (n))));
            //perform T trials
            answer = (percolation.numberOfOpenSites()) / (n * n);
            putNextIndex(data, answer);
            if (percolation.percolates())
            {
                return answer;
            }
        }
        return answer;
    }
    public double stddev()
    {
        // sample standard deviation of percolation threshold
        StdStats.stddev(data, 0, n);
    }

    public double confidenceLo()
    {
        // low  endpoint of 95% confidence interval
        return 2;
    }

    public double confidenceHi()
    {
        // high endpoint of 95% confidence interval
        return 3;
    }

    public static void main(String[] args)
    {
        //test client
        /*
        include a main() method that takes two command-line arguments n and T,
        performs T independent computational experiments (discussed above) on an n-by-n grid,
        and prints the sample mean, sample standard deviation, and the 95% confidence interval for the percolation threshold.
        Use StdRandom to generate random numbers; use StdStats to compute the sample mean and sample standard deviation.
         */
        PercolationStats test = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

    }


}