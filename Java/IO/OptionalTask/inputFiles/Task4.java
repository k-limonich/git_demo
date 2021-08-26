class Task4 {

	private Object id;
	private int sum;

	Account(Object id, int sum) {
		this.id = id;
		this.sum = sum;
	}

	public Object getId() {
		return id;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}