import java.util.LinkedList;


public class Snake {
	private Direction dire;
	private LinkedList<Point> body;
	private int[][] valMap;
	private int max_length;
	private boolean isEat=false;
	private int num=0;

	// private Point food;

	public Snake(int[][] valMap, int max_length) {
		dire = Direction.RIGHT;
		body = new LinkedList<>();
		this.valMap = valMap;
		// body.add(new Point(0, 0));
		this.addPoint(new Point(0, 0));
		this.addPoint(new Point(1, 0));
		this.addPoint(new Point(2, 0));
		this.addPoint(new Point(3, 0));
		this.addPoint(new Point(4, 0));
		this.max_length = max_length;
	}

	public int[][] move() {
		int x = body.getFirst().getX();
		int y = body.getFirst().getY();
		Point add;
		switch (dire) {
		case UP:
			add = new Point(x, y - 1);
			break;
		case DOWN:
			add = new Point(x, y + 1);
			break;
		case RIGHT:
			add = new Point(x + 1, y);
			break;
		case LEFT:
			add = new Point(x - 1, y);
			break;
		default:
			add = null;
			break;
		}

		int tmp = isVal(add);
		if (tmp != -1) {
			// body.addFirst(add);
			this.addPoint(add);
			if (tmp == 0) {
				this.removePoint();
			}

			return valMap;
		}

		return null;
	}

	private void addPoint(Point p) {
		body.addFirst(p);
		valMap[p.getX()][p.getY()] = 1;
	}

	private void removePoint() {
		Point p = body.getLast();
		body.removeLast();
		valMap[p.getX()][p.getY()] = 0;
	}

	private int isVal(Point add) {
		if (null == add) {
			return -1;
		}
		int x = add.getX();
		int y = add.getY();
		int n = valMap.length;
		
		boolean val=x >= 0 && x < n && y >= 0 && y < n;
		
		if(!val||valMap[x][y] == 1){
			return -1;// 不合法移动
		}
		
		if (valMap[x][y] == 2 ) {
			isEat=true;// 吃到食物
			num++;
			
			if(body.size() < max_length){
				return 1;//增长
			}
		}
		
		return 0;//不增长
	}

	public Direction getDire() {
		return dire;
	}

	public void setDire(Direction dire) {
		Direction opp = null;
		switch (this.dire) {
		case UP:
			opp = Direction.DOWN;
			break;
		case DOWN:
			opp = Direction.UP;
			break;
		case RIGHT:
			opp = Direction.LEFT;
			break;
		case LEFT:
			opp = Direction.RIGHT;
			break;
		default:
			break;
		}

		if (dire != opp) {
			this.dire = dire;
		}

	}

	public boolean isEat() {
		return isEat;
	}

	public void setEat(boolean isEat) {
		this.isEat = isEat;
	}

	public LinkedList<Point> getBody() {
		return body;
	}

	public void setBody(LinkedList<Point> body) {
		this.body = body;
	}

	public int getNum() {
		// TODO Auto-generated method stub
		return num;
	}

}
