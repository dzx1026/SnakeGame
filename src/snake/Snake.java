package snake;

import java.util.LinkedList;
public class Snake {
	private LinkedList<Node> body=new LinkedList<Node>();
	/**
	 * 如果食物和头部相邻，则将food这个node加入到body中。为什么相邻就加入？
	 * 什么时候调用？
	 * @param food
	 * @return 返回food的node
	 */
	public Node eat(Node food){
		if(isNeighbor(body.getFirst(),food)){
			body.addFirst(food);
			return food;
		}else
			return null;
	}
	private boolean isNeighbor(Node a,Node b){
		return Math.abs(a.getX()-b.getX())+Math.abs(a.getY()-b.getY())==1;
	}
	/**
	 * 跟据前进的方向更新贪吃蛇的body
	 * @param direction
	 * @return  返回移动之前的尾部。
	 */
	public Node move(Direction direction){
		Node first=body.getFirst();
		switch(direction){
			case UP:
				body.addFirst(new Node(first.getX(),first.getY()-1));
				break;
			case DOWN:
				body.addFirst(new Node(first.getX(),first.getY()+1));
				break;
			case RIGHT:
				body.addFirst(new Node(first.getX()+1,first.getY()));
				break;
			case LEFT:
				body.addFirst(new Node(first.getX()-1,first.getY()));
				break;
		}
		return body.removeLast();
	}
	public Node getHead(){
		return body.getFirst();
	}
	public Node addTail(Node tail){
		this.body.addLast(tail);
		return tail;
	}
	public LinkedList<Node> getBody(){
		return body;
	}
}
