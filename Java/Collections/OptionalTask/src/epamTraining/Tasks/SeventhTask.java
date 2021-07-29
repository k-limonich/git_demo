package epamTraining.Tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SeventhTask {
	private String bracketsString;
	private Stack<Character> bracketsStack = new Stack<>();
	private final List<Character> openingBrackets = Arrays.asList('{', '[', '(');
	private final List<Character> closingBrackets = Arrays.asList('}', ']', ')');

	public SeventhTask(String bracketsString) {
		this.bracketsString = bracketsString;
	}

	public String getBracketsString() {
		return bracketsString;
	}

	public void setBracketsString(String bracketsString) {
		this.bracketsString = bracketsString;
	}

	public boolean bracketsAreBalanced() {
		for (int i = 0; i < bracketsString.length(); i++) {
			if (openingBrackets.contains(bracketsString.charAt(i))) {
				bracketsStack.push(bracketsString.charAt(i));
			} else if (!(closingBrackets.contains(bracketsString.charAt(i)))
					|| bracketsAreMatching(bracketsString.charAt(i))) {
				continue;
			} else {
				return false;
			}
		}
		return bracketsStack.isEmpty();
	}

	private boolean bracketsAreMatching(char closingBracket) {
		if (bracketsStack.isEmpty()) { return false; }
		char openingBracket = bracketsStack.pop();
		return (openingBracket == openingBrackets.get(0) && closingBracket == closingBrackets.get(0))
				|| (openingBracket == openingBrackets.get(1) && closingBracket == closingBrackets.get(1))
				|| (openingBracket == openingBrackets.get(2) && closingBracket == closingBrackets.get(2));
	}
}
