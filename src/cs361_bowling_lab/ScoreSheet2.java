package cs361_bowling_lab;

import java.util.Random;

public class ScoreSheet2 {
	
	private static final int MAXPINS = 10;
	private static final int MAXTURNS = 21;

	private String[] _frames = new String[10];
	private int _currentFrame = 0;
	private int _pins = 10;
	private int[] _score = new int[MAXTURNS];
	
	
	/**
	 * Throws "numFrames" frames of a bowling game
	 * @param numThrows the number of frames to run
	 */
	public ScoreSheet2(int numFrames)
	{
		
	}
	
	/**
	 * Throws the scores from [startFrame, endFrame], both inclusive. Set startFrame = endFrame to throw just one frame
	 * @param startFrame frame of which to start on (inclusive)
	 * @param endFrame frame of which to end on (inclusive)
	 */
	
	
	public int getScore(int _currentFrame) {
		return _score[_currentFrame];
	}
	
	public int getCurrentFrame() {
			return _currentFrame;
	}	
	
	public int getFinalScore() {
		int total = 0;
		for (int i = 0; i < 10; i++) {
			total += _score[i];
		}
		return total;
	}
	

	/**
	 * Throws a bowling ball, and returns the type (strike, spare,
	 * or number value) of the score
	 * @return a string of the frame's score (strike, spare, number value)
	 */

	private void setPins()
	{
		_pins=10;
	}
	
	/**
	 * Hit a random amount of pins from the pins left standing
	 * @return number of pins knocked down
	 */

	
}
