import java.awt.Point;
import java.util.Observable;
import java.util.Observer;


public class PirateShip implements Observer {
Point pirateship;
Point sship;
int ID;
int c,d;
@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	if(o instanceof Ship) {
		sship = ((Ship)o).getShipLocation();
		System.out.println("Ship coordinates "+sship.x+" "+sship.y);
		System.out.println("_____________________________");
		movepShip();	
	}
}

	public void initiate(int a, int b) {
		c=a/50;d=b/50;
		OceanMap.oceanMap[c][d]= true;
		
		pirateship =new Point(a,b);
		
		System.out.println("PirateShip values "+a+" "+b);
	}

	public void movepShip() {
		//System.out.println("Moved");
		if (pirateship.x - sship.x < 0&&OceanMap.oceanMap[c+1][d]==false) {
			 pirateship.x = pirateship.x + 50;
			 OceanMap.oceanMap[c][d]=false;
			 OceanMap.oceanMap[c+1][d]=true;
		 }
		 else if (pirateship.x - sship.x > 0&&OceanMap.oceanMap[c+1][d]==false){
			 pirateship.x =pirateship.x - 50;
			 OceanMap.oceanMap[c][d]=false;
			 OceanMap.oceanMap[c-1][d]=true;
		 }
		 
		 if (pirateship.y - sship.y < 0&&OceanMap.oceanMap[c+1][d]==false) {
			 pirateship.y = pirateship.y+ 50;
			 OceanMap.oceanMap[c][d]=false;
			 OceanMap.oceanMap[c][d+1]=true;
		 }
		 else if (pirateship.y - sship.y > 0&&OceanMap.oceanMap[c+1][d]==false){
			 pirateship.y = pirateship.y-50;
			 OceanMap.oceanMap[c][d]=false;
			 OceanMap.oceanMap[c][d-1]=true;
		 }
		 }
	
public Point getpirateShipLocation() {
		
		return new Point(pirateship.x,pirateship.y); 		//Return the ships coordinates
	}



}