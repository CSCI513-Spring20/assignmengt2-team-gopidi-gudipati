import javafx.scene.input.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.event.ActionEvent;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.lang.Math;
import javafx.scene.layout.BorderPane;
public class OceanExplorer extends Application {
	Random rand = new Random();
	final int dimension = 10;  //initializing the dimension
	final int scale = 50;	//initializing the scale
	ImageView shipImageView;	//Declaring the imageview
	ImageView pshipImageView;
	ImageView ppshipImageView;
	static int a,b,c,d,e,f,g,h,i;
	OceanMap oceanMap = new OceanMap();		//creating a object of oceamMap
	//boolean[][] oceanGrid = oceanMap.getMap();	
	AnchorPane myPane = new AnchorPane();	// creating an object for anchorpane
	Scene scene = new Scene(myPane, scale*dimension, scale*dimension);	//creating a new scene
	Ship ship = new Ship();		//Creating an object for the ship class
	PirateShip pp = new PirateShip();
	PirateShip pp1 = new PirateShip();
	Stage oc = new Stage();
	

	public void start(Stage oceanStage) throws Exception {	//start method for the GUI
		oc = oceanStage;
		drawMap();	//Calling the drawMap method
		setpositions();
		loadislands();
		loadShipImage();	//Calling the loadShipImage Method
		loadPirateShipImage();
		oceanStage.setScene(scene);	//Attaching the scene
		oceanStage.setTitle("Columbus Game");	//Attaching the Title
		oceanStage.show();	//Showing the grid
		ship.addObserver(pp);
		ship.addObserver(pp1);
		startSailing();	//Starting the game
		
	}
	
	
	public void quit() {		//Method to close the stage
		  
		  	//AnchorPane ap = new AnchorPane();
		Button button = new Button("Game Over");	// Initiating the button 
			Scene scene1 = new Scene(button,100,100);	//Initiating the scene
			Stage primaryStage = new Stage();
			button.setOnAction(new EventHandler<ActionEvent>() {	//event handler for the button
	            @Override
	            public void handle(ActionEvent event) {
	                oc.close();		//close the stage
	                primaryStage.close();	
	              
	            }
	        });
			primaryStage.setScene(scene1);	//setting the scene to the stage
			primaryStage.show();		//showing the stage
		}
	
	
	public void setpositions(){		//method to set the positions of the ships and islands
		
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
	
	
	public void loadislands() {		//method to load the islands
		Image island = new Image("island.jpg",50,50,true,true);
		ImageView islandview1 = new ImageView(island);
		islandview1.setX(g*scale);
		islandview1.setY(a*scale);
		myPane.getChildren().add(islandview1);
		
		ImageView islandview2 = new ImageView(island);
		islandview2.setX(h*scale);
		islandview2.setY(b*scale);
		myPane.getChildren().add(islandview2);
		
		ImageView islandview3 = new ImageView(island);
		islandview3.setX(i*scale);
		islandview3.setY(c*scale);
		myPane.getChildren().add(islandview3);
		
		ImageView islandview4 = new ImageView(island);
		islandview4.setX(a*scale);
		islandview4.setY(c*scale);
		myPane.getChildren().add(islandview4);
		
		ImageView islandview5 = new ImageView(island);
		islandview5.setX(c*scale);
		islandview5.setY(h*scale);
		myPane.getChildren().add(islandview5);
		
	
		
		OceanMap.oceanMap[g][a]=true;
		OceanMap.oceanMap[h][b]=true;
		OceanMap.oceanMap[i][c]=true;
		OceanMap.oceanMap[a][c]=true;
		OceanMap.oceanMap[c][h]=true;
		OceanMap.oceanMap[d][i]=true;
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
		}
		catch (Exception e) { // generic exception handling
		    e.printStackTrace();
		}
	}
	
	
	
	
	
	public void loadPirateShipImage() {	//Method to load the pirate ship image
		//First pirate ship
		Image pirateshipImage = new Image("pirateShip.png",50,50,true,true); // image path 
		pshipImageView = new ImageView(pirateshipImage);		
		pshipImageView.setX(c*scale);	//initial position on X axis
		pshipImageView.setY(d*scale);	//initial position on Y axis
		pp.initiate(c*50,d*50);
		myPane.getChildren().add(pshipImageView);	
	
		//-----------------------------------------------------------------------------------
		//Second pirate ship
		
		ppshipImageView = new ImageView(pirateshipImage);
				//Getting a random number from 0 -10
		
		ppshipImageView.setX(e*scale);	//initial position on X axis
		ppshipImageView.setY(f*scale);	//initial position on Y axis
		pp1.initiate(e*50,f*50);
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
				shipImageView.setX(ship.getShipLocation().x);	//Setting the image of ship to its new coordinates
				shipImageView.setY(ship.getShipLocation().y);	//Setting the image of ship to its new coordinates
			//	System.out.println(ship.getShipLocation().x+" "+ship.getShipLocation().x);
				oceanMap.initiate(ship.getShipLocation().x/50, ship.getShipLocation().y/50); //Calling method to store new coordinates
				
				
				pshipImageView.setX(pp.getpirateShipLocation().x);	//Setting the image of ship to its new coordinates
				pshipImageView.setY(pp.getpirateShipLocation().y);	//Setting the image of ship to its new coordinates
			//	System.out.println(pp.getpirateShipLocation().x+" "+pp.getpirateShipLocation().y);
				pp.initiate(pp.getpirateShipLocation().x, pp.getpirateShipLocation().y);
				
				ppshipImageView.setX(pp1.getpirateShipLocation().x);	//Setting the image of ship to its new coordinates
				ppshipImageView.setY(pp1.getpirateShipLocation().y);	//Setting the image of ship to its new coordinates
			//	System.out.println(pp1.getpirateShipLocation().x+" "+pp1.getpirateShipLocation().y);
				pp1.initiate(pp1.getpirateShipLocation().x, pp1.getpirateShipLocation().y);
				
				
				//condition when the game is over
				if(ship.getShipLocation().equals(pp.getpirateShipLocation())||ship.getShipLocation().equals(pp1.getpirateShipLocation())) {
					try {
					
							quit();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
 
	
	public static void main(String[] args) {
		launch(args);
	}

}
