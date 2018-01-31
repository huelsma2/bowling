package cs361_bowling_lab;


public class ScoreSheet2 {
	
	private static final int MAXPINS = 10;
	private static final int MAXTURNS = 21;

	private String[] _frames;
	private int _currentFrame;
	private	int _throw;
	private int _pins;
	private int[] _score;
	
	
	/**
	 * Throws "numFrames" frames of a bowling game
	 * @param numThrows the number of frames to run
	 */
	public ScoreSheet2(int numFrames)
	{
		String[] _frames = new String[10];
		_currentFrame = 0;
		_throw = 0;
		_pins = 10;
		int[] _score = new int[MAXTURNS];
		
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
	private boolean doThrow(int pinsHit)
	{
		if(pinsHit>_pins)
			return false;
		_pins-=pinsHit;
		if(pinsHit==MAXPINS)
			{
			nextFrame("strike");
			return true;
			}
		else if(_pins==0)
			{
			nextFrame("spare");
			return true;
			}
		String ret = ""+(10-_pins);
		if(_throw==1)
		{
			nextFrame(""+Integer.parseInt(_frames[_currentFrame]) + Integer.parseInt(ret));
		}
		else
			{
			_frames[_currentFrame] = ret;
			++_throw;
			}
		return true;
	}
	
	private void nextFrame(String score)
	{
		_frames[_currentFrame] = score;
		_throw=0;
		++_currentFrame;
		setPins();
	}

	private void setPins()
	{
		_pins=10;
	}
	
	/**
	 * Hit a random amount of pins from the pins left standing
	 * @return number of pins knocked down
	 */

	
}
