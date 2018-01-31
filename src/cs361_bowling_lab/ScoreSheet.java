package cs361_bowling_lab;

import java.util.Random;

public class ScoreSheet {

	private String[] _frames = new String[10];
	private int _currentFrame = 0;
	private int _pins = 10;
	private static final int MAXPINS = 10;
	
	/**
	 * Throws "numFrames" frames of a bowling game
	 * @param numThrows the number of frames to run
	 */
	public ScoreSheet(int numFrames)
	{
		this(0,numFrames);
	}
	
	/**
	 * Throws the scores from [startFrame, endFrame], both inclusive. Set startFrame = endFrame to throw just one frame
	 * @param startFrame frame of which to start on (inclusive)
	 * @param endFrame frame of which to end on (inclusive)
	 */
	public ScoreSheet(int startFrame, int endFrame)
	{
		if(startFrame <0 || startFrame >9) 
			throw new IllegalArgumentException("Cannot start outside of the frame bounds: [0,9]");
		if(endFrame <0 || endFrame >9) 
			throw new IllegalArgumentException("Cannot end outside of the frame bounds: [0,9]");
		if(startFrame > endFrame)
			throw new IllegalArgumentException("Cannot end on an earlier frame than start");
		
		_currentFrame=startFrame;
		for(int i = startFrame; i <= endFrame; ++i)
		{
			setPins();
			_frames[_currentFrame] = doThrow();
			_frames[_currentFrame++] = doThrow();
		}
	}
	
	
	
	private int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	/**
	 * Throws a bowling ball, and returns the type (strike, spare,
	 * or number value) of the score
	 * @return a string of the frame's score (strike, spare, number value)
	 */
	private String doThrow()
	{
		if(hitPins()==MAXPINS)
			return "strike";
		else if(_pins==0)
			return "spare";
		return ""+(10-_pins);
	}
	
	/**
	 * Resets the pins
	 */
	private void setPins()
	{
		_pins=10;
	}
	
	/**
	 * Hit a random amount of pins from the pins left standing
	 * @return number of pins knocked down
	 */
	private int hitPins()
	{
		int hits = new Random().nextInt(_pins+1);
		_pins-=hits;
		
		return hits;
	}
	
	
}
