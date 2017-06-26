package snake;
/**
 * 贪吃蛇前进的方向
 * @author dzx
 *
 */
public enum Direction {
	UP(0),
	RIGHT(1),
	LEFT(3),
	DOWN(2);
	
	private int directionCode;
	
	public int getDirectionCode(){
		return this.directionCode;
	}
	
	private Direction(int directionCode){
		this.directionCode=directionCode;
	}
}
