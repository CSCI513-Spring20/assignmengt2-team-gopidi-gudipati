import java.awt.Point;
import java.util.Observable;
public class Ship extends Observable {
int scale = 50;
int xCell;
int yCell;
Point myPosition = new Point(0,0);
Point targetPosition;

public Ship()
{
	targetPosition = new Point(0,0);

}


	public void goEast(int x,int y) { 	//Method when right arrow is pressed
		if(x<450&&OceanMap.oceanMap[x/50+1][y/50]==false) {	// If the ship is in bounds
			xCell = x+50;	// Move the ship to next right cell
			 yCell = y;	
			 OceanMap.oceanMap[x/50][y/50]=false;
		}
		else {		//// If the ship is in bounds do nothing
			xCell=xCell;	
			yCell=yCell;
		}
		setChanged();
		notifyObservers(); 
		
		 OceanMap.oceanMap[xCell/50][yCell/50]=true;
		
		
	}
	public void goWest(int x,int y) {	//Method when left arrow is pressed
		if(x>0&&OceanMap.oceanMap[x/50-1][y/50]==false) {	// If the ship is in bounds
		 xCell = x-50;	//Move the ship to the next left cell
		 yCell = y;
		 OceanMap.oceanMap[x/50][y/50]=false;
		}
		else {	// If the ship is not in bounds do nothing
			xCell=xCell;
			yCell=yCell;
		}
		setChanged();
		notifyObservers(); 
		OceanMap.oceanMap[xCell/50][yCell/50]=true;
		
		
	}
	public void goNorth(int x,int y) {	//Method when up arrow is pressed
		if(y>0&&OceanMap.oceanMap[x/50][y/50-1]==false) {	// If the ship is in bounds
		xCell = x;
		 yCell = y-50;	//Move the ship to the next down cell
		 OceanMap.oceanMap[x/50][y/50]=false;
		}
		else {	//// If the ship is not in bounds do nothing
			xCell=xCell;
			yCell=yCell;
		}
		setChanged();
		notifyObservers(); 
		OceanMap.oceanMap[xCell/50][yCell/50]=true;
		
		
	}
	public void goSouth(int x,int y) {	//Method when down arrow is pressed
		if(y<450&&OceanMap.oceanMap[x/50][y/50+1]==false) { 	// If the ship is in bounds
		xCell = x;
		 yCell = y+50;	//Move the ship to the next upper cell
		 OceanMap.oceanMap[x/50][y/50]=false;
		}
		else {	// If the ship is not in bounds do nothing
			xCell=xCell;
			yCell=yCell;
		}
		setChanged();
		notifyObservers(); 
		OceanMap.oceanMap[xCell/50][yCell/50]=true;
		
		
	}

	public Point getShipLocation() {
		return new Point(xCell,yCell); 		//Return the ships coordinates
	}

}




