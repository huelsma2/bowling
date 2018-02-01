package cs361_bowling_lab;
import static org.junit.Assert.*;

import org.junit.Test;


public class BowlingTest2 {
	ScoreSheet2 scoreSheet1 = new ScoreSheet2();
	ScoreSheet2 scoreSheet2 = new ScoreSheet2();
	ScoreSheet2 scoreSheet3 = new ScoreSheet2();
	ScoreSheet2 scoreSheet4 = new ScoreSheet2();
	ScoreSheet2 scoreSheet5 = new ScoreSheet2();
	ScoreSheet2 scoreSheet6 = new ScoreSheet2();
	
	
	/**
	 *Tests several bad values passed to the ScoreSheet
	 *and its ability to continue taking good values afterwards
	 *
	 */
	@Test
	public void testBadValues() {
		// Bad values on the first frame
		assertFalse(scoreSheet6.doThrow(-1));
		assertEquals(0, scoreSheet6.getScore(1));
		assertFalse(scoreSheet6.doThrow(11));
		assertEquals(0, scoreSheet6.getScore(1));
		assertTrue(scoreSheet6.doThrow(6));
		assertEquals(6, scoreSheet6.getScore(1));
		assertFalse(scoreSheet6.doThrow(6));
		assertEquals(6, scoreSheet6.getScore(1));
		assertTrue(scoreSheet6.doThrow(4));
		assertEquals(10, scoreSheet6.getScore(1));
		
		//fill the frames
		assertTrue(scoreSheet6.doThrow(10));
		assertTrue(scoreSheet6.doThrow(10));
		assertTrue(scoreSheet6.doThrow(10));
		assertTrue(scoreSheet6.doThrow(10));
		assertTrue(scoreSheet6.doThrow(10));
		assertTrue(scoreSheet6.doThrow(10));
		assertTrue(scoreSheet6.doThrow(10));
		assertTrue(scoreSheet6.doThrow(10));
		
		//Throw a spare on the last frame
		assertTrue(scoreSheet6.doThrow(5));
		assertFalse(scoreSheet6.doThrow(6));
		assertTrue(scoreSheet6.doThrow(5));
		assertEquals(10, scoreSheet6.getScore(10));
		
		//throw after game is over
		assertFalse(scoreSheet6.doThrow(10));
		assertFalse(scoreSheet6.doThrow(-10));
		assertFalse(scoreSheet6.doThrow(1));
		assertFalse(scoreSheet6.doThrow(11));
		
		//ask for bad frames
		assertEquals(0, scoreSheet6.getScore(-1));
		assertEquals(0, scoreSheet6.getScore(0));
		assertEquals(0, scoreSheet6.getScore(11));
	}
	
	
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
		assertEquals(18, scoreSheet1.getFinalScore());
		//changed 14 to 18, as a spare frame's score should include the next frame's score - AH
		
		assertTrue(scoreSheet1.doThrow(5));
		assertEquals(9, scoreSheet1.getScore(2));
		assertEquals(28, scoreSheet1.getFinalScore());
		//changed 19 to 28, as a spare frame's score should include the next frame's score - AH
		
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
		assertEquals(20, scoreSheet2.getFinalScore()); 
		//changed 15 to 20, as a strike frame's score should include the next 2 frame's scores - AH
		
		assertTrue(scoreSheet2.doThrow(3));
		assertEquals(8, scoreSheet2.getScore(2));
		assertEquals(26, scoreSheet2.getFinalScore());
		//changed 18 to 26, as a strike frame's score should include the next 2 frame's scores - AH
		
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
		assertEquals(30, scoreSheet3.getFinalScore());
		//changed 20 to 30, as a strike frame's score should include the next 2 frame's scores - AH
		assertTrue(scoreSheet3.doThrow(10));
		assertEquals(10, scoreSheet3.getScore(3));
		assertEquals(60, scoreSheet3.getFinalScore());
		//changed 30 to 60, as a strike frame's score should include the next 2 frame's scores - AH
		
	}
	
	
	/**
	 *Checks that score is initially zero
	 *Throws irrelevant frames, then throws spare on 10th frame
	 *Checks frame scores and final score
	 */
	
	@Test
	public void testSpareOnLastFrame() {
		assertEquals(0, scoreSheet4.getScore(2));
		assertEquals(0, scoreSheet4.getFinalScore());
		assertTrue(scoreSheet4.doThrow(10)); //10+10+9
		assertTrue(scoreSheet4.doThrow(10)); //10+9+10
		assertTrue(scoreSheet4.doThrow(5));  //9
		assertTrue(scoreSheet4.doThrow(4));
		assertTrue(scoreSheet4.doThrow(10)); //10+10+10
		assertTrue(scoreSheet4.doThrow(10)); //10+10+10
		assertTrue(scoreSheet4.doThrow(10)); //10+10+10
		assertTrue(scoreSheet4.doThrow(10)); //10+10+10
		assertTrue(scoreSheet4.doThrow(10)); //10+10+10
		assertTrue(scoreSheet4.doThrow(10)); //10+10
		assertTrue(scoreSheet4.doThrow(5));  //10
		assertTrue(scoreSheet4.doThrow(5));
		assertEquals(10, scoreSheet4.getScore(10)); 
		assertEquals(247, scoreSheet4.getFinalScore());
		//changed 99 to 247, as a strike frame's score should include the next 2 frame's scores - AH
		
	}
	
	
	/**
	 *Checks that score is initially zero
	 *Throws irrelevant frames, then throws strikes on 8, 9, and 10th frame
	 *Checks scores of relevant frames and final score
	 */
	
	@Test
	public void testStrikeOnLastFrames() {
		assertEquals(0, scoreSheet5.getScore(2));
		assertEquals(0, scoreSheet5.getFinalScore());
		assertTrue(scoreSheet5.doThrow(10)); //score for this frame would be 29
		assertTrue(scoreSheet5.doThrow(5));  //score for this frame would be 9
		assertTrue(scoreSheet5.doThrow(4));
		assertTrue(scoreSheet5.doThrow(10)); //score for this frame would be 30
		assertTrue(scoreSheet5.doThrow(10)); //score for this frame would be 30
		assertTrue(scoreSheet5.doThrow(10)); //score for this frame would be 30
		assertTrue(scoreSheet5.doThrow(5));  //score for this frame would be 20
		assertTrue(scoreSheet5.doThrow(5));
		assertTrue(scoreSheet5.doThrow(10)); //score for this frame would be 30
		assertTrue(scoreSheet5.doThrow(10)); //score for this frame would be 30
		assertTrue(scoreSheet5.doThrow(10)); //score for this frame would be 20
		assertTrue(scoreSheet5.doThrow(10)); //score for this frame would be 10
		
		assertEquals(30, scoreSheet5.getScore(8));
		assertEquals(20, scoreSheet5.getScore(9));
		assertEquals(10, scoreSheet5.getScore(10));
		assertEquals(238, scoreSheet5.getFinalScore());
		
	}

}
