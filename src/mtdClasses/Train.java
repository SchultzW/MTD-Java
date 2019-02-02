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
		this.engineVal=12;
		dominos=new ArrayList<Domino>();
	}
	public Train(int val)//place holder
	{
		this.engineVal=val;
		dominos=new ArrayList<Domino>();
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
		Domino d;
		int last=dominos.size();
		d=dominos.get(last);
		return d;
	}
	public int playableVal()
	{
		//returns last dominos.side2
		Domino d;
		int last=dominos.size();
		d=dominos.get(last);
		
		return d.getSide2();
	}
	public void add(Domino d)
	{
		dominos.add(d);
	}
	public void clear()
	{
		for(Domino d:dominos)
		{
			dominos.remove(d);
		}
	}
	public boolean isPlayable(Hand h, Domino d)
	{
		
		if(d.getSide1()==playableVal())
		{
			return true;
		}
		
		
		return false;
	}
	public boolean mustFlip(Domino d)
	{
		if(d.getSide2()==playableVal())
			return true;
		else 
			return false;
	}
	public void play(Hand h, Domino d) throws Exception
	{
		Boolean flipFlag=mustFlip(d);
		Boolean playFlag=isPlayable(h,d);
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
