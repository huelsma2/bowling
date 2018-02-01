package cs361_bowling_lab;


public class ScoreSheet2 {
	
	private static final int MAXPINS = 10;
	private static final int MAXTURNS = 21;

	private String[] _frames;
	private int _currentFrame;
	private	int _throw;
	private int _pins;
	
	
	/**
	 * Throws "numFrames" frames of a bowling game
	 * @param numThrows the number of frames to run
	 */
	public ScoreSheet2(int numFrames)
	{
		_frames = new String[10];
		_currentFrame = 0;
		_throw = 0;
		_pins = 10;
		
	}
	
	/**
	 * Throws the scores from [startFrame, endFrame], both inclusive. Set startFrame = endFrame to throw just one frame
	 * @param startFrame frame of which to start on (inclusive)
	 * @param endFrame frame of which to end on (inclusive)
	 */
	
	
	public int getScore(int frame) {
		if(frame > 9 || frame<0) return 0;
		if(_frames[frame]==null) return 0;
		if(_frames[frame].equals("strike"))
			return 10+rawScore(frame+1) + rawScore(frame+2);
		if(_frames[frame].equals("spare"))
			return 10+rawScore(frame+1);
		try{
			int i = Integer.parseInt(_frames[frame]);
			return i;
			}
		catch(NumberFormatException e) {return 0;}
	}
	
	private int rawScore(int frame)
	{
		if(frame > 9 || frame<0) return 0;
		if(_frames[frame]==null) return 0;
		if(_frames[frame].equals("strike"))
			return 10;
		if(_frames[frame].equals("spare"))
			return 10;
		try{
			int i = Integer.parseInt(_frames[frame]);
			return i;
			}
		catch(NumberFormatException e) {return 0;}
	}
	
	public int getCurrentFrame() {
			return _currentFrame;
	}	
	
	public int getFinalScore() {
		int total = 0;
		for (int i = 0; i < 10; i++) {
			total += getScore(i);
		}
		return total;
	}
	

	/**
	 * Throws a bowling ball, and sets the frame's score according to the pins hit.
	 * @return returns true if the throw was successful, false, if not.
	 */
	public boolean doThrow(int pinsHit)
	{
		if(_currentFrame > 9 || _currentFrame<0)
			return false;
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
		String ret = ""+pinsHit;
		if(_throw==1)
		{
			nextFrame(""+(rawScore(_currentFrame) + pinsHit));
		}
		else
			{
			_frames[_currentFrame] = ret;
			++_throw;
			}
		return true;
	}
	
	public void nextFrame(String score)
	{
		_frames[_currentFrame] = score;
		_throw=0;
		++_currentFrame;
		setPins();
	}

	public void setPins()
	{
		_pins=10;
	}

	
}
