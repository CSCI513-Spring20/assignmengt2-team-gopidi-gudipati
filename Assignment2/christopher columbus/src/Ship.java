

import java.awt.Point;

public class Ship {
int scale = 50;
int xCell=6;
int yCell=6;
	public Point goEast(int x,int y) { 	//Method when right arrow is pressed
		if(x<450) {	// If the ship is in bounds
			xCell = x+50;	// Move the ship to next right cell
			 yCell = y;	
		}
		else {		//// If the ship is in bounds do nothing
			xCell=xCell;	
			yCell=yCell;
		}
		 
		return new Point(xCell,yCell);	//Return the positions
		
	}
	public Point goWest(int x,int y) {	//Method when left arrow is pressed
		if(xCell>0) {	// If the ship is in bounds
		 xCell = x-50;	//Move the ship to the next left cell
		 yCell = y;
		}
		else {	// If the ship is not in bounds do nothing
			xCell=xCell;
			yCell=yCell;
		}
		return new Point(xCell,yCell);	//Return the posistions
		
	}
	public Point goNorth(int x,int y) {	//Method when up arrow is pressed
		if(yCell>0) {	// If the ship is in bounds
		xCell = x;
		 yCell = y-50;	//Move the ship to the next down cell
		}
		else {	//// If the ship is not in bounds do nothing
			xCell=xCell;
			yCell=yCell;
		}
		return new Point(xCell,yCell);	//Return the positions
		
	}
	public Point goSouth(int x,int y) {	//Method when down arrow is pressed
		if(yCell<450) { 	// If the ship is in bounds
		xCell = x;
		 yCell = y+50;	//Move the ship to the next upper cell
		}
		else {	// If the ship is not in bounds do nothing
			xCell=xCell;
			yCell=yCell;
		}
		return new Point(xCell,yCell); 	//Return nothing
		
	}

	public Point getShipLocation() {
		
		return new Point(xCell,yCell); 		//Return the ships coordinates
	}

}
