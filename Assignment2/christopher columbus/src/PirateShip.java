import java.util.Observable;
import java.util.Observer;
import java.awt.Point;


public class PirateShip implements Observer {
Point pirateship;
Point sship;
int ID;
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

		
	}
	public void initiate(int a, int b, int id) {
		this.ID = id;
		pirateship =new Point(a,b);
	}
	public void update(Ship ship) {
		sship = ship.getShipLocation();
		System.out.println(sship.x*50+" "+sship.y*50);
		movepShip();
	}
	
	public void movepShip() {
		 if (pirateship.x - sship.x < 0)
			 pirateship.x++;
		 else
			 pirateship.x--;
		 
		 if (pirateship.y - sship.y < 0)
			 pirateship.y++;
		 else
			 pirateship.y--;
	}
	

}