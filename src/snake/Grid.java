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
	/**
	 * 进行一次移动
	 * @return 返回游戏是否结束,继续返回false，否则返回true
	 */
	public boolean nextRound(){
		boolean isGameOver=false;
		Node originalTail=snake.move(direction);
		//System.out.println(snake.getBody().size());
		if(isHeadRight()){
			changeStatus();          //status要随着蛇的移动进行更改
			//System.out.println(isFood());
			if(isFood()){
				snake.addTail(originalTail);
				createFood();
			}
			return isGameOver;
		}else
			return !isGameOver; 
		
	}
	//判断头部是否有效,无效情况：碰到边界，吃到自己
	private boolean isHeadRight(){
		Node head=snake.getHead();
		if(head.getX()<0||head.getY()<0)
			return false;
		else if(head.getX()>=WEIGHT||head.getY()>=HEIGHT)
			return false;
		else if(status[head.getX()][head.getY()])
			return false;
		else
			return true;
	}
	//判断头部是否是食物
	private boolean isFood(){
		Node head=snake.getHead();
		return head.equals(food);
	}
	/**
	 * 此方法用来初始化蛇，body为4，头部在地图中心或附近
	 */
	public void initSnake(){
		snake=new Snake();
		//设置蛇的body
		snake.addTail(new Node(WEIGHT/2,HEIGHT/2));
		snake.addTail(new Node(WEIGHT/2+1,HEIGHT/2));
		snake.addTail(new Node(WEIGHT/2+2,HEIGHT/2));
		snake.addTail(new Node(WEIGHT/2+3,HEIGHT/2));
		//更新棋盘覆盖
		status[WEIGHT/2][HEIGHT/2]=true;
		status[WEIGHT/2+1][HEIGHT/2]=true;
		status[WEIGHT/2+2][HEIGHT/2]=true;
		status[WEIGHT/2+3][HEIGHT/2]=true;
	}
	/**
	 * 随机创建食物,排除出现在蛇身上。
	 */
	public void createFood(){
		int x,y;
		do{
			x=(int)(Math.random()*WEIGHT);
			y=(int)(Math.random()*HEIGHT);
		}while(status[x][y]);
		food=new Node(x,y);
	}
	public Snake getSnake() {
		return snake;
	}

	public Node getFood() {
		return food;
	}
	public void changeDirection(Direction d){
		this.direction=d;
	}
	/**
	 * 当蛇进行移动时，蛇尾的status要立马变更，否则可能导致经过蛇尾时判读游戏结束
	 */
	public void changeStatusBySnakeTail(){
		Node tail=snake.getBody().getLast();
		status[tail.getX()][tail.getY()]=false;
	}
    public void changeStatus(){
    	for(int i=0;i<status.length;i++)
    		for(int j=0;j<status[i].length;j++)
    			status[i][j]=false;
    	for(Node i:snake.getBody()){
    		status[i.getX()][i.getY()]=true;
    	}
    }
}
