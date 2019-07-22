//Armeet Singh Jatyani
//MatrixMult
/*
  In this program we prompt the user for two matrices.
  We perform a matrix multiplacation and then return
  this product back to the user. If the matrices aren't
  compatible,
*/

//import statements
import java.util.Scanner;

public class MatrixMulti
{
	//initialize scanner to read input
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.println("Matrix A");
		//prompt user and read matrix A
		double[][] matrixA = readMatrix();
		//print MatrixA
		printArray(matrixA);

		System.out.println("Matrix A");
		//prompt user and read matrix A
		double[][] matrixB = readMatrix();
		//print MatrixA
		printArray(matrixB);

		if(matrixA[0].length != matrixB.length)
		{
			System.out.println("These two matrices aren't compatible for" +
			" multiplication");
		} else
		{
			//run the multiplyMatrix function, pass matrixA, matrixB, and store the
			// result in matrixC
		  double[][] matrixC = multiplyMatrix(matrixA, matrixB);

		  //print out matrix C
			System.out.println();
			System.out.println("Matrix C is");
			printArray(matrixC);
		}

	}

	public static double[][] multiplyMatrix(double[][] a, double [][] b)
	{
		double[][] result = new double[a.length][b[0].length];

		//first two loops are for the indexes in the final result array(row, col)
		for (int resultRow = 0; resultRow < result.length; resultRow++)
		{
			for (int resultCol = 0; resultCol < result[0].length; resultCol++)
			{
				//the pointer is an extra pointer used to access the elements in the matrices
				for (int pointer = 0; pointer < b.length; pointer++)
				{
					//increment the result
					result[resultRow][resultCol] += a[resultRow][pointer] * b[pointer][resultCol];
				}
			}
		}

		return result;
	}

	public static double[][] readMatrix()
	{
		//prompt the user for the matrix
		System.out.print("Enter number of rows: ");
		int numRows = scanner.nextInt();
		System.out.print("Enter number of columns: ");
		int numCols = scanner.nextInt();
		System.out.print("Enter contents by rows: ");

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
		//for each row in the arra
		for(double[] row : arr)
		{
			for(double val : row)
			{
				//for every value in the row
				//print the value out with a space
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}