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
	/**
	 * 这个地方要用判断下Object的类型，后面补上。
	 */
	@Override
	public boolean equals(Object other){
		Node m=(Node)other;             
		return x==m.getX()&&y==m.getY();
	}
}
