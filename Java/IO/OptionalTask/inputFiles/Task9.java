public class Task9 {

	/**
	* This is a main method
	 **/
	public static void main(String[] args) {

		ArrayList<String> people = new ArrayList<String>();
		// adding some people
		people.add("Tom");	//add Tom
		people.add("Alice");	//add Alice
		people.add("Kate");	/*add Kate*/
		people.add("Sam");	//add Sam
		System.out.println(people.get(1));		// get Alice
		people.remove(0);	/* remove Tom */
	}
}