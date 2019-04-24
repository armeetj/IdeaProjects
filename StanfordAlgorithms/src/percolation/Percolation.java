package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation
{

    static WeightedQuickUnionUF sites;
    static boolean[] opened;
    public Percolation(int n)
    {
        //constructor creates n-by-n grid, with all sites blocked
        //all sites are their own roots
        //there will be n squared plus 2 sites
        //the source and sink are the extra two sites
        //site 0 will be the first site, and it will the source
        //site 0 will connect to all the next n sites
        //site n+1 is the sink: will connect to all the previous n sites
        sites = new WeightedQuickUnionUF((n * n) + 2);
        opened = new boolean[(n*n) +2];
        opened[0] = true;
        opened[(n * n) + 1] = true;

    }

    public void open(int row, int col)
    {
        // open site (row, col) if it is not open already
        //we must union this site with all of the site

        //convert row, col to index
        int index = index(row, col, sites.count());
        //open this site
        opened[index] = true;

        //if it is in the top row, we must connect it to the source
        if (index <= sites.count())
        {
            //connect to the source
            sites.union(0, index);
        }
        //if it is in the bottom row, we must connect it to the sink
        else if (index > ((sites.count() - 1) * sites.count()))
        {
            sites.union(index, ((sites.count()*sites.count())+1));
        }
        //connect all open sites around the current one: up, down, left, and right
        if(opened[up(row, col)]==true)
        {
            //make a union
            sites.union(index, up(row, col));
        }
        if (opened[down(row, col)] == true)
        {
            //make a union
            sites.union(index, down(row, col));
        }
        if (opened[right(row, col)] == true)
        {
            //make a union
            sites.union(index, right(row, col));
        }
        if (opened[left(row, col)] == true)
        {
            //make a union
            sites.union(index, left(row, col));
        }

    }

    public boolean isOpen(int row, int col)
    {
        // is site (row, col) open?
        return opened[index(row, col, sites.count())];
    }

    public boolean isFull(int row, int col)
    {
        // is site (row, col) full?
        //check if the sites is connected to the top
        return sites.connected(index(row, col, sites.count()), 0);
    }

    public int numberOfOpenSites()
    {
        // number of open sites
        return numberOfOpenSites();
    }

    // does the system percolate?
    public boolean percolates()
    {
        //the system percolates if the source is connected to the sink
        if(sites.connected(0, ((sites.count()*sites.count())+1)))
        {
            return true;
        }
        return false;
    }

    //return the index that the object will have in the QuickUnion object
    //convert row,col to index
    public int index(int row, int col, int n)
    {
        if ((((row * n) + col) + 1) < 0 || (((row * n) + col) + 1) > n + 1)
        {
            return -1;
        }
        return ((row * n) + col) + 1;
    }

    //return the index of the site that is above the given site
    public int up(int row, int col)
    {
        int upIndex = index(row + 1, col, sites.count());
        if (upIndex == -1)
        {
            return -1;
        }
        return upIndex;
    }
    //return the index of the site that is above the given site
    public int down(int row, int col)
    {
        int downIndex = index(row - 1, col, sites.count());
        if (downIndex == -1)
        {
            return -1;
        }
        return downIndex;
    }
    //return the index of the site that is above the given site
    public int left(int row, int col)
    {
        int leftIndex = index(row, col - 1, sites.count());
        if (leftIndex == -1)
        {
            return -1;
        }
        return leftIndex;
    }
    //return the index of the site that is above the given site
    public int right(int row, int col)
    {
        int rightIndex = index(row, col - 1, sites.count());
        if (rightIndex == -1)
        {
            return -1;
        }
        return rightIndex;
    }


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