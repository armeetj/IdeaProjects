//Armeet Singh Jatyani
//MatrixMult
/*
  In this program we prompt the user for two matrices.
  We perform a matrix multiplacation and then return
  this product back to the user.
*/



/*
Matrix A
Enter number of rows: 2
Enter number of columns: 3
Enter contents by rows: 1 2 3 4 5 6
Matrix B
Enter number of rows: 3
Enter number of columns: 2
Enter contents by rows: 7 10 8 11 9 12

Matrix C is
50.0 68.0
122.0 167.0
*/

import java.util.Scanner;

public class MatrixMulti
{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args)
	{
		//prompt the user for the first matrix
		System.out.println("Matrix A");
		System.out.print("Enter number of rows: ");
		int numRowsA = scanner.nextInt();
		System.out.print("Enter number of columns: ");
		int numColsA = scanner.nextInt();
		System.out.print("Enter contents by rows: ");
		double[][] matrixA = readMatrix(numRowsA, numColsA);
		printArray(matrixA);

		System.out.println("Matrix B");
		System.out.print("Enter number of rows: ");
		int numRowsB = scanner.nextInt();
		System.out.print("Enter number of columns: ");
		int numColsB = scanner.nextInt();
		System.out.print("Enter contents by rows: ");
		double[][] matrixB = readMatrix(numRowsB, numColsB);
		printArray(matrixB);

		if(numRowsA != numColsB || numColsA != numRowsB)
		{
			System.out.println("These two matrices aren't compatible for" +
			"multiplication");
		} else
		{

		double[][] matrixC = multiplyMatrix(matrixA, matrixB);
			System.out.println();
			System.out.println("Matrix C is");
			printArray(matrixC);
		}

	}

	public static double[][] multiplyMatrix(double[][] a, double [][] b)
	{
		double[][] result = new double[2][2];
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[0].length; j++)
			{
				result[0][0] += a[i][j] + b[j][i];
			}

		}
		return result;
	}

	public static double[][] readMatrix(int numRows, int numCols)
	{
		double[][] matrix = new double[numRows][numCols];

		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				matrix[i][j] = scanner.nextInt();
			}
		}

		return matrix;
	}

	public static void printArray(double[][] arr)
	{
		for(double[] row : arr)
		{
			for(double val : row)
			{
				System.out.print(val + " ");
			}

			System.out.println();
		}
	}
}


