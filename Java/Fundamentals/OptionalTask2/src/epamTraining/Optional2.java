package epamTraining;

import java.util.Scanner;

public class Optional2 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the order of square matrix: ");
		int matrixOrder = scanner.nextInt();
		Solution solution = new Solution(new int[matrixOrder][matrixOrder]);
		System.out.print("Enter the bound of random matrix elements: ");
		int bound = scanner.nextInt();
		solution.setMatrixWithRandomValues(bound);
		solution.displayMatrix();
		switch (menu()) {
			case 1:
				System.out.print("Enter column index: ");
				int sortingColumn = scanner.nextInt();
				solution.sortMatrixRowsInAscendingOrderOfElementsInParticularColumn(sortingColumn);
				break;

			case 2:
				solution.displayLongestSequenceOfAscendingMatrixElements();
				break;

			case 3:
				solution.findSumOfMatrixElementsBetweenFirstTwoPositiveElements();
				break;

			case 4:
				solution.deleteRowAndColumnWhichContainMaxElementInMatrix();
				break;

			default:
				throw new IllegalArgumentException("Invalid option");
		}
	}

	static int menu() {
		System.out.println("\nChoose an option:");
		System.out.println("1 - Sort matrix rows in ascending order of elements" +
				" in particular column");
		System.out.println("2 - Find the longest sequence of ascending matrix elements");
		System.out.println("3 - Find sum of matrix elements between first two positive elements");
		System.out.println("4 - Delete row and column which contain max element in matrix");
		System.out.print("?");
		return scanner.nextInt();
	}
}
