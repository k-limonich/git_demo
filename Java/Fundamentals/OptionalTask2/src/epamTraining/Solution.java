package epamTraining;

import java.util.*;

public class Solution {
	private int[][] matrix;

	public Solution(int[][] matrix) {
		this.matrix = matrix;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void setMatrixWithRandomValues(int bound) {
		Random random = new Random();
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = random.nextInt(bound * 2) - bound;
			}
		}
	}

	public void displayMatrix() {
		System.out.println("\nMatrix:");
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				System.out.print(matrix[row][column] + "\t");
			}
			System.out.println();
		}
	}

	public void sortMatrixRowsInAscendingOrderOfElementsInParticularColumn(final int COLUMN) {
		if (COLUMN >= matrix.length || COLUMN < 0) {
			throw new IllegalArgumentException("Index " + COLUMN + "is out of bounds");
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
		displayMatrix();
	}

	public void displayLongestSequenceOfAscendingMatrixElements() {
		Deque<Integer> sequence = new ArrayDeque<>();
		Queue<Integer> maxSequence = new ArrayDeque<>();

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (sequence.isEmpty()) {
					sequence.addLast(matrix[row][column]);
				} else if (matrix[row][column] > sequence.peekLast()){
					sequence.addLast(matrix[row][column]);
				} else {
					if (sequence.size() > maxSequence.size()) {
						maxSequence.clear();
						maxSequence.addAll(sequence);
					}
					sequence.clear();
					sequence.addLast(matrix[row][column]);
				}
			}
		}
		if (sequence.size() > maxSequence.size()) {
			maxSequence.clear();
			maxSequence.addAll(sequence);
		}
		System.out.print("\nMax sequence: ");
		for (int element : maxSequence) {
			System.out.print(element + " ");
		}
	}

	public void findSumOfMatrixElementsBetweenFirstTwoPositiveElements() {
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
					} else if (firstBoundIsFound){
						sum += matrix[row][column];
					}
				}
			}
		if (firstBoundIsFound && secondBoundIsFound) {
			System.out.println("Sum: " + sum);
		} else {
			System.out.println("Not enough positive numbers in matrix");
		}
	}

	private int[][] convertListIntoSquareMatrix(List<Integer> list, int matrixOrder) {
		int[][] matrix = new int[matrixOrder][matrixOrder];

		list.removeIf(Objects::isNull);
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = list.remove(0);
			}
		}
		return matrix;
	}

	public void deleteRowAndColumnWhichContainMaxElementInMatrix() {
		int maxElement = matrix[0][0];
		int maxElementRow = 0;
		int maxElementColumn = 0;
		int newMatrixOrder = matrix.length - 1;
		ArrayList<Integer> newMatrix = new ArrayList<>();

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 1; column < matrix[row].length; column++) {
				if (matrix[row][column] > maxElement) {
					maxElement = matrix[row][column];
					maxElementRow = row;
					maxElementColumn = column;
				}
			}
		}
		System.out.println("\nMax element is: " + maxElement);
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if ((row != maxElementRow) && (column != maxElementColumn)) {
					newMatrix.add(matrix[row][column]);
				} else {
					newMatrix.add(null);
				}
			}
		}
		matrix = convertListIntoSquareMatrix(newMatrix, newMatrixOrder);
		displayMatrix();
	}
}
