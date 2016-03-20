import java.awt.event.KeyEvent;

public class GameMap {
	private static int[][] valMap;
	private int n;
	private int max_length;
	private Snake snake;

	public GameMap(int n){
		this.n=n;
		valMap=new int[n][n];
		max_length=n*n/2;
		snake=new Snake(valMap,max_length);
		this.creatFood();
	}
	
	public void creatFood(){
		int x=this.getRandom();
		int y=this.getRandom();
		while(valMap[x][y]!=0){
			x=this.getRandom();
			y=this.getRandom();
		}
		valMap[x][y]=2;
	}
	
	public void changeDire(int i){
		switch (i) {
		case KeyEvent.VK_UP:
			snake.setDire(Direction.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.setDire(Direction.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.setDire(Direction.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.setDire(Direction.RIGHT);
			break;
		default:
			break;
		}		
	}
	
	public boolean move(){
		this.valMap=snake.move();
		
		if(null==valMap){
			return false;
		}
		
		if(snake.isEat()){
			this.creatFood();
			snake.setEat(false);
		}
		return true;
	}
	
	private int getRandom(){
		return (int)(Math.random()*n);
	}

	public static int[][] getValMap() {
		return valMap;
	}

	public static void setValMap(int[][] valMap) {
		GameMap.valMap = valMap;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getMax_length() {
		return max_length;
	}

	public void setMax_length(int max_length) {
		this.max_length = max_length;
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return snake.getNum();
	}
	
}
