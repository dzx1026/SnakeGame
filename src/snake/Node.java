package snake;
/**
 * 节点：贪吃蛇身体的组成部分，每一个节点有坐标信息。
 * @author dzx
 *
 */
public class Node {
	private final int x;
	private final int y;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Node(int x,int y){
		this.x=x;
		this.y=y;
	}
}
