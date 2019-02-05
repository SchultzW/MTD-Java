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
	void testConstructor() 
	{
		fail("Not yet implemented");
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
	}
	@Test
	void testIsEmpty()
	{
		
	}
	@Test
	void testToString()
	{
		
	}
	@Test
	void testDraw()
	{
		
	}
	@Test
	void testDominoRemaining()
	{
		
	}

}
