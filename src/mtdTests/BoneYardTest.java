package mtdTests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import mtdClasses.Boneyard;
import mtdClasses.Domino;

class BoneYardTest {

	Boneyard by;
	@BeforeEach
	void setUp() throws Exception 
	{
		by=new Boneyard(6);
	}

	@Test
	void testConstructor() throws Exception 
	{
		Boneyard by1=new Boneyard(12);
	}
	@Test
	void testGetIndexOf()
	{
		Domino d=by.getIndexOf(0);
		assertEquals(d.getSide1(),0);
	}
	@Test
	void testSetIndexOf()
	{
		Domino d=new Domino(1,1);
		by.setIndexOf(20, d);
		Domino d1=by.getIndexOf(20);
		assertEquals(d,d1);
	}
	@Test
	void testShuffle() throws Exception
	{
		Boneyard by1=new Boneyard(6);
		by1.shuffle();
		assertNotEquals(by1,by);
	}
	@Test
	void testIsEmpty()
	{
		int count=by.dominoRemaining();
		for(int i=0;i<count;i++)
		{
			by.draw();
		}
		assertEquals(0,by.dominoRemaining());
		assertTrue(by.isEmpty());
	}
	@Test
	void testToString()
	{
		System.out.println(by.toString());
	}
	@Test
	void testDraw()
	{
		//int count=by.count();
		Domino d=by.draw();
		//assertNotEquals(count,by.count());
		assertEquals(d.getSide1(),0);
	}
	@Test
	void testDominoRemaining()
	{
		assertEquals(28,by.dominoRemaining());
	}

}
