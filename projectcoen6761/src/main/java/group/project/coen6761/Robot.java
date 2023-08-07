package group.project.coen6761;

public class Robot {
	int x;
	int y;
	boolean pen;
	public enum Direction{
		North,East,South,West
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction direction;
	
	
	public Robot() {
		this.x=0;
		this.y=0;
		this.pen=false;
		this.direction=Direction.North;
	}
	
	public short print(){
		String p="";
		if(pen) {
			p="Down";
		}else {
			p="Up";
		}
		System.out.println("Position:"+x+","+y+" - "+"Pen:"+p+" - "+"Facing:"+direction);
		return 0;
	}
	public void setPenUp() {
		this.pen=false;
	}
	public void setPenDown() {
		this.pen=true;
	}
	public void turnRight() {
		int currentIndex = this.direction.ordinal();
	    int nextIndex = (currentIndex + 1) % Direction.values().length;
	    this.direction = Direction.values()[nextIndex];
	}
	public void turnLeft() {
		int currentIndex = this.direction.ordinal();
	    int nextIndex = (currentIndex - 1+ Direction.values().length) % Direction.values().length;
	    this.direction = Direction.values()[nextIndex];
	}
	public void setXY(int x, int y) { 
		this.x=x;
		this.y=y;
	}
}
