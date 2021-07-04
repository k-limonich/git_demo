package epamTraining;

import java.util.Scanner;

public class Optional2 {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the order of square matrix: ");
		int matrixOrder = in.nextInt();
		int[][] matrix = Solution.createSquareMatrixOfRandomNumbers(matrixOrder);
		Solution.displayMatrix(matrix);
		int choice = menu();
		switch (choice) {
			case 1:
				System.out.print("Enter column index: ");
				int sortingColumn = in.nextInt();
				Solution.sortMatrixRowsInAscendingOrderOfElementsInParticularColumn(matrix,
																					sortingColumn);
				break;

			case 2:
				Solution.displayLongestSequenceOfAscendingMatrixElements(matrix);
				break;

			case 3:
				Solution.findSumOfMatrixElementsBetweenFirstTwoPositiveElements(matrix);
				break;

			case 4:
				Solution.deleteRowAndColumnWhichContainMaxElementInMatrix(matrix);
				break;

			default:
				throw new IllegalArgumentException("Unexpected value " + choice);
		}
	}

	static int menu() {
		System.out.println("\nOptional Task 2");
		System.out.println("Choose an option:");
		System.out.println("1 - Sort matrix rows in ascending order of elements" +
				" in particular column");
		System.out.println("2 - Find the longest sequence of ascending matrix elements");
		System.out.println("3 - Find sum of matrix elements between first two positive elements");
		System.out.println("4 - Delete row and column which contain max element in matrix");
		System.out.print("?");
		return in.nextInt();
	}
}
