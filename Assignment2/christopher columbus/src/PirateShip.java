import java.awt.Point;
import java.util.Observable;
import java.util.Observer;


public class PirateShip implements Observer {
Point pirateship;
Point sship;

int c,d;
@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	if(o instanceof Ship) {
		sship = ((Ship)o).getShipLocation();
	//	System.out.println("Ship coordinates "+sship.x+" "+sship.y);
	//	System.out.println("_____________________________");
		movepShip();	
	}
}

	public void initiate(int a, int b) {
		c=a/50;d=b/50;
		
		
		pirateship =new Point(a,b);
		
		//System.out.println("PirateShip values "+a+" "+b);
	}

	public void movepShip() {
		//System.out.println("Moved");
		if(c+1<10&&d+1<10&&pirateship.x - sship.x < 0&&pirateship.y - sship.y < 0) {
			if(OceanMap.oceanMap[c+1][d+1]==false) {
				pirateship.x=pirateship.x+50;
				pirateship.y=pirateship.y+50;
			}
		}
		else if(c+1<10&&d-1>-1&&pirateship.x - sship.x < 0&&pirateship.y - sship.y > 0) {
			if(OceanMap.oceanMap[c+1][d-1]==false) {
				pirateship.x=pirateship.x+50;
				pirateship.y=pirateship.y-50;
			}
		}
		else if(c-1>-1&&d-1>-1&&pirateship.x - sship.x > 0&&pirateship.y - sship.y > 0) {
			if(OceanMap.oceanMap[c-1][d-1]==false) {
				pirateship.x=pirateship.x-50;
				pirateship.y=pirateship.y-50;
			}
		}
		else if(c-1>-1&&d+1<10&&pirateship.x - sship.x > 0&&pirateship.y - sship.y < 0) {
			if(OceanMap.oceanMap[c-1][d+1]==false) {
				pirateship.x=pirateship.x-50;
				pirateship.y=pirateship.y+50;
			}
		}
		
		else if(c+1<10&&pirateship.x - sship.x < 0) {
			if(OceanMap.oceanMap[c+1][d]==false) {
			 pirateship.x = pirateship.x + 50;
			}	 
		 }
		 else if (c-1>-1&&pirateship.x - sship.x > 0){
			 if(OceanMap.oceanMap[c-1][d]==false) {
			 pirateship.x =pirateship.x - 50;
			 }	 
		 }
		 
		 else if (d+1<10&&pirateship.y - sship.y < 0) {
			 if(OceanMap.oceanMap[c][d+1]==false) {
			 pirateship.y = pirateship.y+ 50;
			 }	 
		 }
		 else if (d-1>-1&&pirateship.y - sship.y > 0){
			if(OceanMap.oceanMap[c][d-1]==false) {
			 pirateship.y = pirateship.y-50;
			} 
		 }
		 }
	
public Point getpirateShipLocation() {
		
		return new Point(pirateship.x,pirateship.y); 		//Return the ships coordinates
	}



}