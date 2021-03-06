package cs361_bowling_lab;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;


/** First Tests of ScoreSheet2 
 * 
 * @author Michael D
 *
 */

public class BowlingTest1 {
	ScoreSheet2 testSuite1 = new ScoreSheet2();
	ScoreSheet2 testSuite2 = new ScoreSheet2();
	ScoreSheet2 testSuite3 = new ScoreSheet2();
	ScoreSheet2 testSuite4 = new ScoreSheet2();
	
	
	
	/**
	 * check after first throws score
	 * check the final score is equal to the first throw
	 */
	@Test
	public void testOneThrow() {
		assertTrue(testSuite1.doThrow(3));
		assertEquals(3, testSuite1.getScore(1));
		assertEquals(3, testSuite1.getFinalScore()); 
		assertEquals(0, testSuite1.getCurrentFrame()); //changed 1 to 0, because the throw shuold not finish the first frame - AH
		
	}
	
	/**
	 * check after first throws score
	 * check after second throws score
	 * check the final score is equal to the addition of first two throws
	 * check the current frame is still 1
	 */
	@Test
	public void testTwoThrows() {
		assertTrue(testSuite2.doThrow(1));
		assertEquals(1, testSuite2.getScore(1));
		
		assertTrue(testSuite2.doThrow(2));
		assertEquals(3, testSuite2.getScore(1)); 
		
		assertEquals(3, testSuite2.getFinalScore()); 	
		assertEquals(1, testSuite2.getCurrentFrame());  
		
		
	}
	
	/**
	 * check after first throws score
	 * check after second throws score
	 * check after third throws score
	 * recheck the scores in the two frames
	 * check the final score is equal to the addition of first three throws
	 * check the current frame is still 2
	 */
	@Test
	public void testThreeThrows() {
		assertTrue(testSuite3.doThrow(1));
		assertEquals(1, testSuite3.getScore(1));
		
		assertTrue(testSuite3.doThrow(2));
		assertEquals(3, testSuite3.getScore(1));
		
		assertTrue(testSuite3.doThrow(7));
		assertEquals(7, testSuite3.getScore(2));
		
		assertEquals(3, testSuite3.getScore(1));
		assertEquals(7, testSuite3.getScore(2));
	
		assertEquals(3, testSuite3.getScore(1)); 	
		assertEquals(7, testSuite3.getScore(2));
		
		assertEquals(10, testSuite3.getFinalScore()); 	
		assertEquals(1, testSuite3.getCurrentFrame()); //changed 2 to 1, because the third throw should not finish the second frame - AH
		
	}
	
	/**
	 * advance to the last frame by throwing all strikes
	 * check that the 11th throw will fail
	 * check final score is 270
	 */
	
	@Test
	public void testThrowOn11thFrame() {
		assertTrue(testSuite4.doThrow(10));
		assertTrue(testSuite4.doThrow(10));
		assertTrue(testSuite4.doThrow(10));
		assertTrue(testSuite4.doThrow(10));
		assertTrue(testSuite4.doThrow(10));
		assertTrue(testSuite4.doThrow(10));
		assertTrue(testSuite4.doThrow(10));
		assertTrue(testSuite4.doThrow(10));
		assertTrue(testSuite4.doThrow(10));
		assertTrue(testSuite4.doThrow(10));
		assertFalse(testSuite4.doThrow(10)); //11th frame should fail!
		
		assertEquals(270, testSuite4.getFinalScore());
		
		
	
		
	}

	

}
