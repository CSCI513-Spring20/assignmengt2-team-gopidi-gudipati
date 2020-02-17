import javafx.scene.input.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.lang.Math;

public class OceanExplorer extends Application {
	Random rand = new Random();
	final int dimension = 10;  //initializing the dimension
	final int scale = 50;	//initializing the scale
	ImageView shipImageView;	//Declaring the imageview
	ImageView pshipImageView;
	ImageView ppshipImageView;
	static int a,b,c,d,e,f,g,h,i;
	OceanMap oceanMap = new OceanMap();		//creating a object of oceamMap
	boolean[][] oceanGrid = oceanMap.getMap();	
	AnchorPane myPane = new AnchorPane();	// creating an object for anchorpane
	Scene scene = new Scene(myPane, scale*dimension, scale*dimension);	//creating a new scene
	Ship ship = new Ship();		//Creating an object for the ship class
	PirateShip pp = new PirateShip();
	PirateShip pp1 = new PirateShip();
	
	public void setpositions()
	{
		ArrayList<Integer> list1 = new ArrayList<Integer>();	//initializing the list
		
		for(int i=0;i<10;i++) {
			list1.add(new Integer(i));	//storing the values in the list
			
		}
		Collections.shuffle(list1);	//Shuffling the list to create a list with random order numbers
		
		a = list1.get(0);
		b = list1.get(1);
		c = list1.get(2);
		d = list1.get(3);
		e = list1.get(4);
		f = list1.get(5);
		g = list1.get(6);
		h = list1.get(7);
		i = list1.get(8);
	}
	
	
	
	
	
	public void start(Stage oceanStage) throws Exception {
		
		drawMap();	//Calling the drawMap method
		setpositions();
		loadShipImage();	//Calling the loadShipImage Method
		loadPirateShipImage();
		oceanStage.setScene(scene);	//Attaching the scene
		oceanStage.setTitle("Columbus Game");	//Attaching the Title
		oceanStage.show();	//Showing the grid
		startSailing();	//Starting the game
		

		
	}
	
	
	
	public void drawMap() {		//Method to draw the map
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);	//making the lines color black
				rect.setFill(Color.PALETURQUOISE);	//Filling the background
				myPane.getChildren().add(rect);
			}
		}
	}
	public void loadShipImage() { 	//Method to load the ship image
		try {
			
		Image shipImage = new Image("ship.png",50,50,true,true); // image path 
		shipImageView = new ImageView(shipImage);
		//a = rand.nextInt(10);		// Generating a random number from 0 -10
		//b = rand.nextInt(10);		//Getting a random number from 0 -10
		shipImageView.setX(a*scale);	//initial position on X axis
		shipImageView.setY(b*scale);	//initial position on Y axis
		oceanMap.initiate(a,b);			//Calling the method initiate 
		//System.out.println(a*scale+" "+b*scale);
		myPane.getChildren().add(shipImageView);
		
		//----------------------------------------------------------------------------------
		
		
		
		}
		catch (Exception e) {

		    // generic exception handling
		    e.printStackTrace();
		
		}
		
	}
	
	public void loadPirateShipImage() {
		//First pirate ship
				Image pirateshipImage = new Image("pirateShip.png",50,50,true,true); // image path 
				pshipImageView = new ImageView(pirateshipImage);
//				//c = rand.nextInt(10);		// Generating a random number from 0 -10
//				d = rand.nextInt(10);		//Getting a random number from 0 -10
//				if(c==a&&d==b) {
//					c = rand.nextInt(10);
//					d = rand.nextInt(10);
//				}
				OceanMap.oceanMap[c][d]=true;		
		pshipImageView.setX(c*scale);	//initial position on X axis
		pshipImageView.setY(d*scale);	//initial position on Y axis
		pp.initiate(c,d,1);
		//oceanMap.initiate(c,d);			//Calling the method initiate 
		//System.out.println(c*scale+" "+d*scale);
		myPane.getChildren().add(pshipImageView);	
		
		//-----------------------------------------------------------------------------------
		//Second pirate ship
		
		ppshipImageView = new ImageView(pirateshipImage);
//		e = rand.nextInt(10);		// Generating a random number from 0 -10
//		f = rand.nextInt(10);		//Getting a random number from 0 -10
//		if(e==a&&f==b) {
//			e = rand.nextInt(10);
//			f = rand.nextInt(10);
//		}
//		else if (e==c||f==d) {
//			e = rand.nextInt(10);
//			f = rand.nextInt(10);
//		}
		OceanMap.oceanMap[e][f]=true;
		ppshipImageView.setX(e*scale);	//initial position on X axis
		ppshipImageView.setY(f*scale);	//initial position on Y axis
		pp.initiate(e,f,2);
		//oceanMap.initiate(e,f);			//Calling the method initiate 
		//System.out.println(e*scale+" "+f*scale);
		myPane.getChildren().add(ppshipImageView);
		
		
	}
 	private void startSailing() {	//Method to  start Sailing
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			
			
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {	//Switch statement
				case RIGHT :
					//System.out.println("right");
					ship.goEast(oceanMap.getShipLocation().x*scale,oceanMap.getShipLocation().y*scale); //Method to move ship
					//System.out.println(oceanMap.getShipLocation().x*scale+" "+oceanMap.getShipLocation().y*scale);
					
					break;
				case LEFT :
					ship.goWest(oceanMap.getShipLocation().x*scale,oceanMap.getShipLocation().y*scale); //Method to move ship
					
					break;
				case UP :
					ship.goNorth(oceanMap.getShipLocation().x*scale,oceanMap.getShipLocation().y*scale);//Method to move ship
					break;
				case DOWN :
					ship.goSouth(oceanMap.getShipLocation().x*scale,oceanMap.getShipLocation().y*scale);//Method to move ship
					break;
				default :
					break;	
				}
				shipImageView.setX(ship.getShipLocation().x);
				shipImageView.setY(ship.getShipLocation().y);
				oceanMap.initiate(ship.getShipLocation().x/50, ship.getShipLocation().y/50); //Calling method to store new coordinates
				
			}
		});
	}
 
	
	public static void main(String[] args) {
		launch(args);
	}

}
