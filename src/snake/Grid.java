package snake;
/**
 * 棋盘
 * @author dzx
 *
 */
public class Grid {
	private final int WEIGHT;
	private final int HEIGHT;
	private Snake snake;            //在棋盘中有一条蛇
	private Node food;              //在棋盘中有食物
	private Direction direction=Direction.LEFT;    //初始是往左移动
	private boolean[][] status;     //数组的值用来查看是否蛇与node重合，重合为true
	
	public Grid(int weight,int height){
		this.WEIGHT=weight;
		this.HEIGHT=height;
		
		status=new boolean[weight][height];
		initSnake();
		createFood();
	}
	
	public void initSnake(){
		
	}
	public void createFood(){
		
	}
}
