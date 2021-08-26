public class Task2 {

	private String text;
	public int circleRradius;
	public final double PI = 3.14;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Task2(String text, int number) {
		this.text = text;
		this.number = number;
	}

	public void displayTextInReverse() {
		for (int i = text.length() - 1; i >= 0; i--) {
			System.out.print(text.charAt(i));
		}
	}

	protected void getAreaOfACircle() {
		return PI * circleRradius * circleRradius;
	}
}