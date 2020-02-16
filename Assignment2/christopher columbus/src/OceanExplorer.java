

import javafx.scene.input.KeyEvent;
import java.lang.reflect.InvocationTargetException;
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

public class OceanExplorer extends Application {
	Random rand = new Random();
	final int dimension = 10;  //initializing the dimension
	final int scale = 50;	//initializing the scale
	ImageView shipImageView;	//Declaring the imageview
	OceanMap oceanMap = new OceanMap();		//creating a object of oceamMap
	boolean[][] oceanGrid = oceanMap.getMap();	
	AnchorPane myPane = new AnchorPane();	// creating an object for anchorpane
	Scene scene = new Scene(myPane, scale*dimension, scale*dimension);	//creating a new scene
	Ship ship = new Ship();		//Creating an object for the ship class
	public void start(Stage oceanStage) throws Exception {
		
		drawMap();	//Calling the drawMap method
		loadShipImage();	//Calling the loadShipImage Method
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
	public void loadShipImage() throws InvocationTargetException { 	//Method to load the ship image
		try {
			
		Image shipImage = new Image("ship.png",50,50,true,true); // image path 
		shipImageView = new ImageView(shipImage);
		int a = rand.nextInt(10);		// Generating a random number from 0 -10
		int b = rand.nextInt(10);		//Getting a random number from 0 -10
		shipImageView.setX(a*scale);	//initial position on X axis
		shipImageView.setY(b*scale);	//initial position on Y axis
		oceanMap.initiate(a,b);			//Calling the method initiate 
		myPane.getChildren().add(shipImageView);
		
		Image pirateImage = new Image("pirateShip.png",50,50,true,true); // image path
		ImageView pirateImageView = new ImageView(pirateImage);
		int c = rand.nextInt(10);
		int d = rand.nextInt(10);
		if(c==a&&d==b) {
			c = rand.nextInt(10);
			d = rand.nextInt(10);
		}
		pirateImageView.setX(c*scale);
		pirateImageView.setX(d*scale);
		oceanMap.initiate(c, d);
		myPane.getChildren().add(pirateImageView);
		
		Image pirateImage1 = new Image("pirateShip.png",50,50,true,true); // image path
		ImageView pirateImageView1 = new ImageView(pirateImage1);
		int e = rand.nextInt(10);
		int f = rand.nextInt(10);
		if(e==a&&f==b) {
			e = rand.nextInt(10);
			f = rand.nextInt(10);
		}
		else if(e==c&&f==d) {
			e = rand.nextInt(10);
			f = rand.nextInt(10);
		}
		pirateImageView1.setX(e*scale);
		pirateImageView1.setX(f*scale);
		oceanMap.initiate(e, f);
		myPane.getChildren().add(pirateImageView1);
		}
		catch (Exception e) {

		    // generic exception handling
		    e.printStackTrace();
		
		}
		
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