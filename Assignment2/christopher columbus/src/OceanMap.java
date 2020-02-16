

import java.awt.Point;

public class OceanMap {
	boolean[][] oceanMap = new boolean[10][10];	//Initializing the grid size
	int xCell ;
	int yCell ;
	
	public void initiate(int a, int b) {
		xCell =a;
		yCell =b;
	}

	
	
	public boolean[][] getMap(){
		
		return oceanMap;
	}
	public Point getShipLocation() {
		return new Point(xCell,yCell);	//Getting the ships location
	}
}