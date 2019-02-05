package mtdClasses;

import java.util.ArrayList;
import java.util.List;


public class Hand
{
	private List<Domino>handOfDomino=new ArrayList<Domino>();
	
	public int getCount()
	{
		return handOfDomino.size();
	}
	public Boolean getIsEmpty()
	{
		if(handOfDomino.size()==0)
			return true;
		else 
			return false;
	}
	public int score()
	{
		int score=0;
		for(Domino d:handOfDomino)
		{
			score=+d.getScore();
		}
		return score;
	}
	public void add(Domino d)
	{
		handOfDomino.add(d);
	}
	public void clear()
	{
		handOfDomino.clear();
	}
	public Domino getDomino(int i)
	{
		Domino d;
		int index=indexOfD(i);
		d=handOfDomino.get(index);
		handOfDomino.remove(d);
		return d;
	
	}
	public Domino getDoubleD(int i)
	{
		Domino d;
		int index=indexOfDoubleD(i);
		d=handOfDomino.get(index);
		handOfDomino.remove(d);
		return d;
	}
	public Hand()
	{
		handOfDomino=new ArrayList<Domino>();
	}
	public Hand(Boneyard by,int playCount)
	{
		//Up to 4 players take 15 dominoes each, 5 or 6 take 12 each, 7 or 8 take 10 each. 
		if(playCount==4)
		{
			for(int i=0;i<=15;i++)
			{
				handOfDomino.add(by.draw());
			}
		}
		else if(playCount==5|playCount==6)
		{
			for(int i=0;i<=12;i++)
			{
				handOfDomino.add(by.draw());
			}
		}
		else if(playCount==7|playCount==8)
		{
			for(int i=0;i<=10;i++)
			{
				handOfDomino.add(by.draw());
			}
		}
	}
	public Boolean HasDomino(int val)
	{
		boolean flag=false;
		for(Domino d:handOfDomino)
		{
			if(d.getSide1()==val|d.getSide2()==val)
			{
				flag=true;
				break;
			}
			else 
				flag=false;
		}
		return flag;
	}
	public Boolean HasDoubleD(int val)
	{
		boolean flag=false;
		for(Domino d:handOfDomino)
		{
			if(d.getSide1()==val&d.getSide2()==val)
			{
				flag=true;
				break;
			}
			else 
				flag=false;
		}
		return flag;
	}
	public int indexOfD(int val)
	{
		int index=-1;
		for(Domino d:handOfDomino)
		{
			if(d.getSide1()==val|d.getSide2()==val)
			{
				index=handOfDomino.indexOf(d);
			}
		}
		
		return index; 
	}
	public int indexOfDoubleD(int val)
	{
		int index=-1;
		for(Domino d:handOfDomino)
		{
			if(d.getSide1()==val&d.getSide2()==val)
			{
				index=handOfDomino.indexOf(d);
			}
		}
		
		return index; 
	}
	public int indexOfHighestD()
	{
		int index=-1;
		for(int i=12;i>=1;i--)
		{
			for(Domino d:handOfDomino)
			{
				if(d.getSide1()==i&d.getSide2()==i)
				{
					index=handOfDomino.indexOf(d);
					break;
				}
			}
		}
		return index;
	}
	/// <summary>
    /// Plays the domino at the index on the train.
    /// Flips the domino if necessary before playing.
    /// Removes the domino from the hand.
    /// Throws an exception if the domino at the index
    /// is not playable.
    /// use IsPLayable from train class.
    /// </summary>
	public void play(int index,Train t,Hand h) throws Exception
	{
		Domino d=handOfDomino.get(index);
		handOfDomino.remove(d);
		
		if(t.isPlayable(d)==true& t.mustFlip(d)==true)
		{
			d.flip();
			t.play(h, d);
		}
		else if(t.isPlayable(d)==true& t.mustFlip(d)==false)
		{
			t.play(h, d);
		}
		else
			throw new Exception("This Domino can not be played");
	}
	  /// Plays the domino from the hand on the train.
    /// Flips the domino if necessary before playing.
    /// Removes the domino from the hand.
    /// Throws an exception if the domino is not in the hand
    /// or is not playable.
    /// </summary>
	public void play(Domino d, Train t, Hand h) throws Exception
	{
		handOfDomino.remove(d);
		
		if(t.isPlayable(d)==true& t.mustFlip(d)==true)
		{
			d.flip();
			t.play(h,d);
		}
		else if(t.isPlayable(d)==true& t.mustFlip(d)==false)
		{
			t.play(h,d);
		}
		else
			throw new Exception("This Domino can not be played");
	}
	public void removeAt(int i)
	{
		handOfDomino.remove(i);
	}
	public void remove(Domino d)
	{
		// TODO Auto-generated method stub
		handOfDomino.remove(d);
	}
	
	
}
