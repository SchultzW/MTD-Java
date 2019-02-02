package mtdClasses;

public class PlayerTrain extends Train 
{
	private Hand hand;
	private Boolean isOpen;
	
	public boolean getIsOpen()
	{
		return isOpen;
	}
	public void close()
	{
		isOpen=false;
	}
	public void isPlayable()
	{
		
	}
	public void open()
	{
		isOpen=true;
	}
	public PlayerTrain(Hand h)
	{
		super();
		this.hand=h;
		this.setEngVal(12);
		
	}
	public PlayerTrain(Hand h,int engVal)
	{
		super();
		this.hand=h;
		this.setEngVal(getEngVal());
	}
}
