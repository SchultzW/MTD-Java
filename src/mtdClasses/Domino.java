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
		if(val<=12)
		{
			this.side1=val;
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
		if(val<=12)
		{
			this.side2=val;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + side1;
		result = prime * result + side2;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Domino other = (Domino) obj;
		if (side1 != other.side1)
			return false;
		if (side2 != other.side2)
			return false;
		return true;
	}
	public void flip() throws Exception
	{
		//d1=1 d2=2
		int side1=this.getSide1();
		int side2=this.getSide2();
		this.setSide2(side1);
		this.setSide1(side2);
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
		return String.format("Side 1: "+this.getSide1()+"  Side 2: "+this.getSide2());
	}
	
}
