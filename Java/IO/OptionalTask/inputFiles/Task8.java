public class ExtraSpaces  {

	public static void main( String[] args ) {

		Person kate    =    new Person("Kate");
		System.out.println ( kate.getName() );
		changeName	( kate);
		System.out.println (kate.getName() );
	}
	static   void  changeName (  Person p		){
		p.setName("Alice");
	}
}
class Person	{

	private String   name	;

	Person ( String name  )  {
			this.name = name;
	}

	public  void       setName  (String name){
		this.name =  name;
	}
	public String getName ()		{
		return    this.name;
	}
}