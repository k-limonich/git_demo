package epamTraining;

import java.util.*;

public class Solution {
	static Random rand = new Random();

	public static int[][] createSquareMatrixOfRandomNumbers(final int SIZE) {
		int[][] matrix = new int[SIZE][SIZE];
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = rand.nextInt(200) - 100;			//random numbers from -100 to 100
			}
		}
		return matrix;
	}

	public static void displayMatrix(int[][] matrix) {
		System.out.println("\nMatrix:");
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				System.out.print(matrix[row][column] + "\t");
			}
			System.out.println();
		}
	}

	public static void sortMatrixRowsInAscendingOrderOfElementsInParticularColumn(int[][] matrix,
																				  final int COLUMN) {
		if (COLUMN >= matrix.length) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				if (matrix[j][COLUMN] < matrix[i][COLUMN]) {
					int[] temp = matrix[i];
					matrix[i] = matrix[j];
					matrix[j] = temp;
				}
			}
		}
		displayMatrix(matrix);
	}

	private static int[] transformSquareMatrixIntoOneDimensionalArray(int[][] matrix) {
		int[] array = new int[matrix.length * matrix.length];

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				int index = row * matrix[row].length + column;
				array[index] = matrix[row][column];
			}
		}
		return array;
	}

	public static void displayLongestSequenceOfAscendingMatrixElements(int[][] matrix) {
		int[] matrixElements = transformSquareMatrixIntoOneDimensionalArray(matrix);
		ArrayList<Integer> maxSequence = new ArrayList<>();
		ArrayList<Integer> currentSequence = new ArrayList<>();

		for (int index = 1; index < matrixElements.length; index++) {
			if (currentSequence.isEmpty()) {
				currentSequence.add(matrixElements[index - 1]);
			}

			if (matrixElements[index] > matrixElements[index - 1]) {
				currentSequence.add(matrixElements[index]);
			} else {

				if (currentSequence.size() > maxSequence.size()) {
					maxSequence = (ArrayList<Integer>) currentSequence.clone();
				}
				currentSequence.clear();
			}
		}

		for (var element : maxSequence) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static void findSumOfMatrixElementsBetweenFirstTwoPositiveElements(int[][] matrix) {
		int sum = 0;
		boolean firstBoundIsFound = false;
		boolean secondBoundIsFound = false;

		outerLoop:
			for (int row = 0; row < matrix.length; row++) {
				for (int column = 0; column < matrix[row].length; column++) {
					if (firstBoundIsFound && secondBoundIsFound) {
						break outerLoop;
					} else if ((!firstBoundIsFound) && (matrix[row][column] > 0)) {
						firstBoundIsFound = true;
					} else if (firstBoundIsFound && (matrix[row][column] > 0)) {
						secondBoundIsFound = true;
					} else if ((firstBoundIsFound) && (!secondBoundIsFound)){
						sum += matrix[row][column];
					} else {
						continue;
					}
				}
			}
		if (firstBoundIsFound && secondBoundIsFound) {
			System.out.println("Sum: " + sum);
		} else {
			System.out.println("Not enough positive numbers in matrix");
		}
	}

	public static void deleteRowAndColumnWhichContainMaxElementInMatrix(int[][] matrix) {
		int maxElement = Integer.MIN_VALUE;
		int maxElementRow = 0;
		int maxElementColumn = 0;
		int[] initialMatrixElements = transformSquareMatrixIntoOneDimensionalArray(matrix);
		int newMatrixSize = matrix.length - 1;
		ArrayList<Integer> newMatrix = new ArrayList<>();

		for (int element : initialMatrixElements) {        							//
			newMatrix.add(element);                           						/*copy elements*/
		}                                                                           //

		for (int row = 0; row < matrix.length; row++) {								/*find max*/
			for (int column = 0; column < matrix[row].length; column++) {			//
				if (matrix[row][column] > maxElement) {								//
					maxElement = matrix[row][column];								//
					maxElementRow = row;											//
					maxElementColumn = column;										//
				}
			}
		}
		System.out.println("\nMax element is: " + maxElement);

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				int index = row * matrix[row].length + column;
				if ((row == maxElementRow) || (column == maxElementColumn)) {
					newMatrix.set(index, null);
				}
			}
		}
		newMatrix.removeIf(Objects::isNull);
		for (int row = 0; row < newMatrixSize; row++) {
			for (int column = 0; column < newMatrixSize; column++) {
				int index = row * newMatrixSize + column;
				System.out.print(newMatrix.get(index) + "\t");
			}
			System.out.println();
		}
	}
}
