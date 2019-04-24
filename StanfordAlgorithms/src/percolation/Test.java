package percolation;

public class Test
{
    public static void main(String[] args)
    {
        // test client (optional)
        Percolation test = new Percolation(3);
        System.out.println("Opening: 0 0 ");
        test.open(0, 0);
        System.out.println("percolates: " + test.percolates());

        System.out.println("Opening: 1 0 ");
        test.open(0, 0);
        System.out.println("percolates: " + test.percolates());

        System.out.println("Opening: 2 0 ");
        test.open(0, 0);
        System.out.println("percolates: " + test.percolates());

        //        System.out.println("Opening: 3 0 ");
        //        test.open(0, 0);
        //        System.out.println("percolates: " + test.percolates());

    }
}