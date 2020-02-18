import java.awt.Point;
import java.util.Observable;
public class Ship extends Observable {

int xCell;
int yCell;





	public void goEast(int x,int y) { 	//Method when right arrow is pressed
		if(x<450&&OceanMap.oceanMap[x/50+1][y/50]==false) {	// If the ship is in bounds
			xCell = x+50;	// Move the ship to next right cell
			 yCell = y;	
			 
		}
		else {		//// If the ship is in bounds do nothing
			xCell=x;	
			yCell=y;
		}
		setChanged();
		notifyObservers(); 
		
		 
		
		
	}
	public void goWest(int x,int y) {	//Method when left arrow is pressed
		if(x>0&&OceanMap.oceanMap[x/50-1][y/50]==false) {	// If the ship is in bounds
		 xCell = x-50;	//Move the ship to the next left cell
		 yCell = y;
		 
		}
		else {	// If the ship is not in bounds do nothing
			xCell=x;
			yCell=y;
		}
		setChanged();
		notifyObservers(); 
		
		
		
	}
	public void goNorth(int x,int y) {	//Method when up arrow is pressed
		if(y>0&&OceanMap.oceanMap[x/50][y/50-1]==false) {	// If the ship is in bounds
		xCell = x;
		 yCell = y-50;	//Move the ship to the next down cell
		 
		}
		else {	//// If the ship is not in bounds do nothing
			xCell=x;
			yCell=y;
		}
		setChanged();
		notifyObservers(); 
		
		
		
	}
	public void goSouth(int x,int y) {	//Method when down arrow is pressed
		if(y<450&&OceanMap.oceanMap[x/50][y/50+1]==false) { 	// If the ship is in bounds
		xCell = x;
		 yCell = y+50;	//Move the ship to the next upper cell
		 
		}
		else {	// If the ship is not in bounds do nothing
			xCell=x;
			yCell=y;
		}
		setChanged();
		notifyObservers(); 
		
		
		
	}

	public Point getShipLocation() {
		return new Point(xCell,yCell); 		//Return the ships coordinates
	}

}




