package mtdTests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mtdClasses.Domino;
import mtdClasses.Hand;
import mtdClasses.MexicanTrain;
import mtdClasses.PlayerTrain;
import mtdClasses.Train;

class TrainTest {

	PlayerTrain pt;
	MexicanTrain mt;
	Hand h;
	Domino d;
	Domino d1;
	@BeforeEach
	void setUp() throws Exception 
	{
		h=new Hand();
		pt=new PlayerTrain(h,0);
		mt=new MexicanTrain(0);
		d=new Domino(0,0);
		d1=new Domino(0,1);
	}
	@Test
	void testConstructor()
	{
		PlayerTrain pTrain=new PlayerTrain(h,12);
		MexicanTrain mTrain=new MexicanTrain(12);
		assertEquals(pTrain.getEngVal(),12);
		assertEquals(mTrain.getEngVal(),12);
	}
	@Test
	void setGetEngValTest() 
	{
		pt.setEngVal(6);
		mt.setEngVal(8);
		assertEquals(pt.getEngVal(),6);
		assertEquals(mt.getEngVal(),8);
	}
	@Test
	void testIsEmoty() 
	{
		assertTrue(pt.isEmpty());
		
	}
	@Test
	void testCount() 
	{
		assertEquals(mt.count(),0);
		mt.add(d);
		assertEquals(mt.count(),1);
		
		
	}
	@Test
	void testLastD() 
	{
		
		mt.add(d);
		assertEquals(mt.lastDomino(),d);
		mt.add(d1);
		assertEquals(mt.lastDomino(),d1);
	}
	@Test
	void testPlayableVal() 
	{
		pt.add(d1);
		assertEquals(pt.playableVal(),1);
	}
	@Test
	void testAdd() 
	{
		pt.add(d1);
		Domino dTest=pt.lastDomino();
		assertEquals(d1,dTest);
	}
	@Test
	void testClear() 
	{
		mt.add(d);
		mt.add(d1);
		mt.clear();
		assertEquals(0,mt.count());
	}
	@Test
	void testIsPLayable() 
	{
		mt.add(d);
		assertTrue(mt.isPlayable(d));
		Domino falseD=new Domino(5,5);
		assertFalse(mt.isPlayable(falseD));
	}
	@Test
	void testMustFlip() 
	{
		mt.add(d);
		assertFalse(mt.mustFlip(d));
		assertTrue(mt.mustFlip(d1));
	}
	@Test
	void testPlay() throws Exception 
	{
		h.add(d);
		mt.play(h, d);
		assertEquals(mt.lastDomino(),d);
	}
	//player tests
	@Test
	void testOpenClose() 
	{
		pt.open();
		assertTrue(pt.getIsOpen());
		pt.close();
		assertFalse(pt.getIsOpen());
	}
	
	

}
