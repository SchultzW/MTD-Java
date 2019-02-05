package mtdTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mtdClasses.Domino;

class DominoTest {

	Domino d;
	Domino d1;
	Domino d3;
	@BeforeEach
	void setUp() throws Exception 
	{
		d=new Domino(1,1);
		d1=new Domino(2,2);
		d3=new Domino(1,2);
	}

	@Test
	void side1GetSet() throws Exception 
	{
		assertEquals(d3.getSide1(),1);
		d3.setSide1(5);
		assertEquals(d3.getSide1(),5);
	}
	@Test
	void side2GetSet() throws Exception
	{
		assertEquals(d3.getSide2(),2);
		d3.setSide2(5);
		assertEquals(d3.getSide2(),5);
	}
	@Test
	void testScore()
	{
		assertEquals(d.getScore(),2);
	}
	@Test
	void testConstructor()
	{
		Domino test=new Domino(1,1);
		assertEquals(test.getSide1(),1);
		assertEquals(test.getSide2(),1);
	}
	@Test
	void testEquals()
	{
		Domino nD=new Domino(1,1);
		assertFalse(d.equals(d1));
		assertTrue(d.equals(nD));
	}
	@Test
	void testFlip() throws Exception
	{
		d3.flip();
		assertEquals(2,d3.getSide1());
		assertEquals(1,d3.getSide2());
	}
	@Test
	void isDouble()
	{
		assertTrue(d.isDouble());
	}
	@Test
	void toStringTest()
	{
		String message=d.toString();
		assertEquals(message,"Side 1: 1  Side 2: 1");
	}

}
