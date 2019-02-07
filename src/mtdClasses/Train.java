package mtdClasses;

import java.util.ArrayList;
import java.util.List;



public  abstract class Train 
{

	//List<Card>deckList=new ArrayList<Card>();
	private List<Domino>dominos;
	private int engineVal;
	
	public Train()
	{
		
		dominos=new ArrayList<Domino>();
		this.engineVal=12;
	}
	public Train(int val)//place holder
	{
		
		dominos=new ArrayList<Domino>();
		this.engineVal=val;
	}
	public void setEngVal(int i)
	{
		this.engineVal=i;
		
	}
	public int getEngVal()
	{
		return this.engineVal;
	}
	public Boolean isEmpty()
	{
		if(this.count()==0)
			return true;
		else
			return false;
	}
	public int count()
	{
		return dominos.size();
	}
	public Domino lastDomino()
	{
		try
		{
			Domino d;
			int last=dominos.size()-1;
			d=dominos.get(last);
			return d;
		}
		catch(Exception e)
		{
			int val=this.getEngVal();
			Domino d=new Domino(val,val);
			return d;
		}
		
		
	}
	public int playableVal()
	{
		//returns last dominos.side2
		
		int last=this.lastDomino().getSide2();
		
		
		return last;
	}
	public void add(Domino d)
	{
		dominos.add(d);
	}
	public void clear()
	{
		dominos.clear();
		
	}
	public boolean isPlayable(Domino d)
	{
		
		if(d.getSide1()==this.playableVal())
		{
			return true;
		}
		
		
		return false;
	}
	
	public boolean mustFlip(Domino d)
	{
		if(d.getSide2()==this.playableVal())
			return false;
		else 
			return true;
	}
	public void play(Hand h, Domino d) throws Exception
	{
		Boolean flipFlag=mustFlip(d);
		Boolean playFlag=isPlayable(d);
		if(playFlag==true&flipFlag==false)
		{
			dominos.add(d);
			h.remove(d);
		}
		else if(playFlag=true&flipFlag==true)
		{
			d.flip();
			dominos.add(d);
			h.remove(d);
		}
		else
			throw new Exception("This domino cannot be played.");
	}
	 
   
	public void removeAt(int index)
	{
		dominos.remove(index);
	}
	
	
}
