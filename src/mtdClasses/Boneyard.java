package mtdClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boneyard
{

	private List<Domino>boneYardList;
	
	public Boneyard(int maxVal) throws Exception
	{
		if(maxVal>=6&maxVal<=12)
		{
			
			Domino first=new Domino(0,0);
			boneYardList.add(first);
			for(int i=0;i<=maxVal;i++)
			{
				for(int j=0;j<=maxVal;j++)
				{
					boolean flag=false;
					Domino d=new Domino(i,j);
					Domino d2=new Domino(j,i);
					for(Domino dCheck:boneYardList)
					{
						if(d.equals(dCheck)|d2.equals(dCheck))
						{
							flag=false;
						}
						else 
							flag=true;
					}
					if(flag==true)
					{
						boneYardList.add(d);
					}
				}
			}
			
		}
		else
			throw new Exception("Tha is not a valid value for a domino.");
	}
	
	public Domino getIndexOf(int index)
	{
		return boneYardList.get(index);
	}
	public void setIndexOf(int index,Domino d)
	{
		boneYardList.add(index, d);
	}
	public void shuffle()
	{
		  Domino temp;
	        int count=boneYardList.size()-1;
	        Random rand = new Random();
	        for(int j=0;j<count;j++)
	        {
	        	temp=boneYardList.get(j);
	        	boneYardList.remove(j);
	        	int n=rand.nextInt(count)+1;
	        	boneYardList.add(n, temp);	        			        	
	        }
	        for(int i=0;i<200;i++)
	        {
	            int n=rand.nextInt(count)+1;
	            temp=boneYardList.get(n);
	            boneYardList.remove(n);
	            boneYardList.add(temp);
	        }	                		        
	}
	public Boolean isEmpty()
	{
		if(boneYardList.size()==0)
		{
			return true;
		}
		else 
			return false;
	}
	public String toString()
	{
		String myString="";
		for(Domino d:boneYardList)
		{
			myString+=d.toString()+"\n";
		}
		return myString;
	}
	public Domino draw()
	{
		Domino d=boneYardList.get(0);
		boneYardList.remove(d);
		return d;
	}
	public int dominoRemaining()
	{
		return boneYardList.size();
	}
}
