package group.project.coen6761;

public class Room {
	public int[][] room;
	public Room(int size) {
		room=new int[size][size];
	}
	public void print() {
        // Printing the array values
        for (int i = 0; i < this.room.length; i++) {
            for (int j = 0; j <this.room[i].length; j++) {
                System.out.print(this.room[i][j] + " ");
            }
            System.out.println();
        }
	}
}
