package cs361_bowling_lab;
import static org.junit.Assert.*;

import org.junit.Test;


public class BowlingTest2 {
	ScoreSheet2 scoreSheet1 = new ScoreSheet2(0);
	ScoreSheet2 scoreSheet2 = new ScoreSheet2(0);
	ScoreSheet2 scoreSheet3 = new ScoreSheet2(0);
	ScoreSheet2 scoreSheet4 = new ScoreSheet2(0);
	ScoreSheet2 scoreSheet5 = new ScoreSheet2(0);
	
	
	/**
	 *Checks that score is initially zero
	 *Throws a spare in the first frame, checks score
	 *Completes another frame and checks the score
	 */
	
	@Test
	public void testSpareCountsNextFrameScore() {
		assertEquals(0, scoreSheet1.getScore(1));
		assertEquals(0, scoreSheet1.getFinalScore());
		
		assertTrue(scoreSheet1.doThrow(5));
		assertEquals(5,scoreSheet1.getScore(1));
		assertEquals(5, scoreSheet1.getFinalScore());
		
		assertTrue(scoreSheet1.doThrow(5));
		assertEquals(10,scoreSheet1.getScore(1));
		assertEquals(10, scoreSheet1.getFinalScore());
		
		assertTrue(scoreSheet1.doThrow(4));
		assertEquals(4, scoreSheet1.getScore(2));
		assertEquals(14, scoreSheet1.getFinalScore());
		
		assertTrue(scoreSheet1.doThrow(5));
		assertEquals(9, scoreSheet1.getScore(2));
		assertEquals(19, scoreSheet1.getFinalScore());
		
	}
	
	
	/**
	 *Checks that score is initially zero
	 *Scores a strike in the first frame
	 *Completes another frame and checks the score
	 */
	
	@Test
	public void testStrikeMovesToNextFrame() {
		assertEquals(0, scoreSheet2.getScore(1));
		assertEquals(0, scoreSheet2.getFinalScore());
		
		assertTrue(scoreSheet2.doThrow(10));
		assertEquals(10, scoreSheet2.getScore(1));
		assertEquals(10, scoreSheet2.getFinalScore());
		
		assertTrue(scoreSheet2.doThrow(5));
		assertEquals(5, scoreSheet2.getScore(2));
		assertEquals(15, scoreSheet2.getFinalScore());
		
		assertTrue(scoreSheet2.doThrow(3));
		assertEquals(8, scoreSheet2.getScore(2));
		assertEquals(18, scoreSheet2.getFinalScore());
		
	}
	
	
	/**
	 *Checks that score is initially zero
	 *Throws 3 frames of strikes
	 *Checks score of frames and final score
	 */
	
	@Test
	public void testStrikeCountsNextFrameScores() {
		assertEquals(0, scoreSheet3.getScore(1));
		assertEquals(0, scoreSheet3.getFinalScore());
		assertTrue(scoreSheet3.doThrow(10));
		assertEquals(10, scoreSheet3.getScore(1));
		assertEquals(10, scoreSheet3.getFinalScore());
		assertTrue(scoreSheet3.doThrow(10));
		assertEquals(10, scoreSheet3.getScore(2));
		assertEquals(20, scoreSheet3.getFinalScore());
		assertTrue(scoreSheet3.doThrow(10));
		assertEquals(10, scoreSheet3.getScore(3));
		assertEquals(30, scoreSheet3.getFinalScore());
		
	}
	
	
	/**
	 *Checks that score is initially zero
	 *Throws irrelevant frames, then throws spare on 10th frame
	 *Checks frame scores and final score
	 */
	
	@Test
	public void testSpareOnLastFrame() {
		assertEquals(0, scoreSheet4.getScore(1));
		assertEquals(0, scoreSheet4.getFinalScore());
		assertTrue(scoreSheet4.doThrow(10));
		assertTrue(scoreSheet4.doThrow(10));
		assertTrue(scoreSheet4.doThrow(5));
		assertTrue(scoreSheet4.doThrow(4));
		assertTrue(scoreSheet4.doThrow(10));
		assertTrue(scoreSheet4.doThrow(10));
		assertTrue(scoreSheet4.doThrow(10));
		assertTrue(scoreSheet4.doThrow(10));
		assertTrue(scoreSheet4.doThrow(10));
		assertTrue(scoreSheet4.doThrow(10));
		assertTrue(scoreSheet4.doThrow(5));
		assertTrue(scoreSheet4.doThrow(5));
		assertEquals(10, scoreSheet4.getScore(10));
		assertEquals(99, scoreSheet4.getFinalScore());
		
	}
	
	
	/**
	 *Checks that score is initially zero
	 *Throws irrelevant frames, then throws strikes on 8, 9, and 10th frame
	 *Checks scores of relevant frames and final score
	 */
	
	@Test
	public void testStrikeOnLastFrames() {
		assertEquals(0, scoreSheet5.getScore(1));
		assertEquals(0, scoreSheet5.getFinalScore());
		assertTrue(scoreSheet5.doThrow(10));
		assertTrue(scoreSheet5.doThrow(5));
		assertTrue(scoreSheet5.doThrow(4));
		assertTrue(scoreSheet5.doThrow(10));
		assertTrue(scoreSheet5.doThrow(10));
		assertTrue(scoreSheet5.doThrow(10));
		assertTrue(scoreSheet5.doThrow(5));
		assertTrue(scoreSheet5.doThrow(5));
		assertTrue(scoreSheet5.doThrow(10));
		assertTrue(scoreSheet5.doThrow(10));
		assertTrue(scoreSheet5.doThrow(10));
		assertTrue(scoreSheet5.doThrow(10));
		assertEquals(10, scoreSheet5.getScore(8));
		assertEquals(10, scoreSheet5.getScore(9));
		assertEquals(10, scoreSheet5.getScore(10));
		assertEquals(99, scoreSheet5.getFinalScore());
		
	}

}
