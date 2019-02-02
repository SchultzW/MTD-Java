package mtdClasses;

public class Domino 
{

	private int side1;
	private int side2;
	
	public int getSide1()
	{
		return side1;
	}
	public void setSide1(int val) throws Exception
	{
		if(val<12)
		{
			side1=val;
		}
		else
			throw new Exception("That is not a valid value");
	}
	public int getSide2()
	{
		return side2;
	}
	public void setSide2(int val) throws Exception
	{
		if(val<12)
		{
			side1=val;
		}
		else
			throw new Exception("That is not a valid value");
	}
	public int getScore()
	{
		return side1+side2;
	}
	public Domino(int s1,int s2)
	{
		side1=s1;
		side2=s2;
	}
	public Boolean compareTo()
	{
		return false;
	}
	@Override
	public boolean equals(Object o)
	{
		Domino d=(Domino) o;
		if(this.side1==d.side1&this.side2==d.side2)
		{
			return true;
		}
		else
			return false;
		
		
	}
	public void flip()
	{
		int temp=this.side1;
		this.side2=this.side1;
		side2=temp;
	}
	public void GetHash()
	{
		
	}
	public Boolean isDouble()
	{
		if(this.side1==this.side2)
			return true;
		else
			return false;
		
	}
	@Override
	public String toString()
	{
		//return this.side1+"|"+this.side2;
		return String.format("Side 1: {0}  Side 2: {1}", side1, side2);
	}
	
}
