package mtdClasses;

public class main 
{

	public static void main(String args[]) throws Exception
	{
		//System.out.println("");
		//in.nextLine()
		Boneyard by=new Boneyard(6);
		Hand h=new Hand(by, 2);
		by.toString();
		by.draw();
	}
}
