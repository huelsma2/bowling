package cs361_bowling_lab;

/** Scoresheet interface for a bowling game
 * 
 * @author Andrew H, Steven M
 *
 */

public class ScoreSheet2 {
	
	private static final int MAXPINS = 10;
	private static final int FRAMES = 10;

	private String[] _frames;
	private int _currentFrame;
	private	boolean _secondThrow;
	private int _pins;
	
	public ScoreSheet2() {
		_frames = new String[FRAMES];
		_currentFrame = 0;
		_secondThrow = false;
		_pins = MAXPINS;
	}
	
	/** Gets the composite (plus other frame(s) on strike/spare) score of a single frame
	 * 
	 * @param The frame to get the composite score from (Actual frame, not index from 0)
	 * @return The composite score of the frame
	 */
	
	public int getScore(int frame) {
		--frame; //convert frame to index
		if(frame >= FRAMES || frame < 0) return 0;
		if(_frames[frame] == null) return 0;
		if(_frames[frame].equals("strike"))
			return MAXPINS + rawScore(frame+1) + rawScore(frame+2);
		if(_frames[frame].equals("spare"))
			return MAXPINS + rawScore(frame+1);
		try {
			int i = Integer.parseInt(_frames[frame]);
			return i;
		}
		catch(NumberFormatException e) {return 0;}
	}
	
	/** Gets the absolute (no addition of other frames) score of a single frame
	 * 
	 * This method takes the index value instead of the frame value because it is a private method
	 * 
	 * @param frame The frame to get the absolute score from (index from 0)
	 * @return The absolute score of the frame
	 */
	
	private int rawScore(int frame) {
		if(frame >= FRAMES || frame < 0) return 0;
		if(_frames[frame] == null) return 0;
		if(_frames[frame].equals("strike"))
			return MAXPINS;
		if(_frames[frame].equals("spare"))
			return MAXPINS;
		try {
			int i = Integer.parseInt(_frames[frame]);
			return i;
		}
		catch(NumberFormatException e) {return 0;}
	}
	
	/** Gets the frame the next score will be recorded on
	 * 
	 * @return The current frame
	 */
	
	public int getCurrentFrame() {
			return _currentFrame;
	}	
	
	/** Gets the total game score
	 * 
	 * @return The total score of all frames
	 */
	
	public int getFinalScore() {
		int total = 0;
		for (int i = 0; i < FRAMES; i++)
			total += getScore(i + 1);
		return total;
	}
	
	/** Takes a value for number of pins downed, validates it
	 * 
	 * @param pinsHit Number of pins downed on the current throw
	 * @return True on valid recorded number, false otherwise
	 */
	
	public boolean doThrow(int pinsHit) {
		if(_currentFrame >= FRAMES || _currentFrame < 0)
			return false;
		if(pinsHit > _pins || pinsHit < 0)
			return false;
		_pins -= pinsHit;
		if(pinsHit == MAXPINS) {
			nextFrame("strike");
			return true;
		}
		else if(_pins==0) {
			nextFrame("spare");
			return true;
		}
		String ret = "" + pinsHit;
		if(_secondThrow) {
			nextFrame("" + (MAXPINS - _pins));
		}
		else {
			_frames[_currentFrame] = ret;
			_secondThrow = true;
		}
		return true;
	}
	
	/** Moves the game to the next frame
	 * 
	 * @param score The score of the current frame to be recorded
	 * before moving on to the next
	 */
	
	private void nextFrame(String score) {
		_frames[_currentFrame] = score;
		_secondThrow = false;
		++_currentFrame;
		setPins();
	}
	
	/** Returns the pin value to MAXPINS
	 * to reset them for the next frame
	 */
	
	private void setPins() {
		_pins = MAXPINS;
	}
}
