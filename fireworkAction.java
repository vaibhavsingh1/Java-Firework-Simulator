import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*“I did not collaborate with anyone on this Project.” 

Name: Moazzam Salman and Abdul Moid
NET ID: msalman and amunawar.
Project 3
Lab : Tuesday and Thursday (11:05am-12:20pm)

*/
public class fireworkAction extends GameMain {
	protected static int endingX; //the ending point x of trajectory
	protected static int endingY; //the ending point y of trajectory
	public static Random rand=new Random();
	public static void endingPoint() {
		endingX = (int) ((velocity)*(Math.cos(angleRad)*time)); //calculates the endingpoint X
		endingY = (int) (((velocity*Math.sin(angleRad)*time)-(0.5*9.8*Math.pow(time, 2)))); //calculates the endingpoint Y
	}
	public static void drawTrajectory(Graphics e) {
		e.setColor(Color.red); //the trajectory will always draw red
		//the below for loop loops for every value of time from 0 to time with diff of 0.005 and draws each point to form a trajectory.
		for (double z= 0; z <= time; z += 0.005) {
			int x = (int) ((velocity)*(Math.cos(angleRad)*z));
			int y = (int) ((velocity*Math.sin(angleRad)*z)-(0.5*9.8*Math.pow(z, 2)));
			e.fillOval(x - (4/2), y - (4/2), 4, 4);
		}
		
	}
	public static void Circles(Graphics e) {
		int diameter;
		int endingX2 = 0,endingY2 = 0;
		int neg=0;
		
		double angleRad2;
		angleRad2=0;
		for(int p=0;p<5;p++) { //this for loop will draw the different explosive trajectories
		
		
		neg=rand.nextInt(2);
		//the below for loop draws the trajectory once the firework explodes into diff pieces
		for (double z= 0; z <= time; z += 0.005) {
			int x = endingX+(int) ((velocity)*(Math.cos(angleRad2)*z));
			int y = endingY+(int) ((velocity*Math.sin(angleRad2)*z)-(0.5*9.8*Math.pow(z, 2)));
			e.setColor(color.ORANGE);
			
			e.fillOval(x - (4/2), y - (4/2), 4, 4);
			endingX2=x; //the temporary ending value is set to the ending value X of this specific trajectory
			endingY2=y;  //the temporary ending value is set to the ending value Y of this specific trajectory
		}
		e.setColor(color); //the color set by user is set
		for(int x=0;x<=1;x++) {
			diameter=rand.nextInt(60)+5; //the diameter of circle is generated using random number
			e.drawOval(endingX2+rand.nextInt(35),endingY2+rand.nextInt(35),diameter,diameter); //circle is drawn
			
			
		}
		//the below for loops are just a repetition of the first for loop
		for(int x=0;x<=1;x++) {
			diameter=rand.nextInt(60)+5;
			e.drawOval(endingX2-rand.nextInt(35),endingY2-rand.nextInt(35),diameter,diameter);
			
			
		}
		for(int x=0;x<=1;x++) {
			diameter=rand.nextInt(60)+5;
			e.drawOval(endingX2,endingY2+rand.nextInt(35),diameter,diameter);
			
			
		}
		for(int x=0;x<=1;x++) {
			diameter=rand.nextInt(60)+5;
			e.drawOval(endingX2,endingY2-rand.nextInt(35),diameter,diameter);
			
			
		}
		for(int x=0;x<=1;x++) {
			diameter=rand.nextInt(60)+5;
			e.drawOval(endingX2-rand.nextInt(35),endingY2,diameter,diameter);
			
			
		}
		for(int x=0;x<=1;x++) {
			diameter=rand.nextInt(60)+5;
			e.drawOval(endingX2+rand.nextInt(35),endingY2,diameter,diameter);
			
			
		}
		angleRad2=angleRad2+1; //the angleRad2 which is the angle used to draw the explosive trajectory is incremented by 1 radians.
		}
		
		
		
		
	}
	public static void Funnel(Graphics e) {
		int diameter=5;
		e.setColor(color);
		int neg=0;
		int endingX2=0; int endingY2=0;
		double angleRad2=0;
		for(int p=0;p<5;p++) { //this for loop will draw the different explosive trajectories
			
			
			neg=rand.nextInt(2);
			//the below for loop draws the trajectory once the firework explodes into diff pieces
			for (double z= 0; z <= time; z += 0.005) {
				int x = endingX+(int) ((velocity)*(Math.cos(angleRad2)*z));
				int y = endingY+(int) ((velocity*Math.sin(angleRad2)*z)-(0.5*9.8*Math.pow(z, 2)));
				e.setColor(color.ORANGE);
				
				e.fillOval(x - (4/2), y - (4/2), 4, 4);
				endingX2=x; //the temporary ending value is set to the ending value X of this specific trajectory
				endingY2=y; //the temporary ending value is set to the ending value Y of this specific trajectory
			}
			e.setColor(color);
		diameter=20;
		int tempX=endingX2; //tempX is set to the endingX2 value
		for(int x=0;x<10;x++) {
			
			e.drawOval(tempX,endingY2, diameter,diameter); //draws 10 circles in this for loop initially of diamter 20
			tempX=tempX-4; //the tempX decreases by 4 each loop
			diameter=diameter+4; //the diameter increases by 4 each time
		}
		angleRad2=angleRad2+1; //the angleRad2 which is the angle used to draw the explosive trajectory is incremented by 1 radians.
		}
		
	}
	public static void Squares(Graphics e) {
		int length;
		int neg;
		int endingX2=0,endingY2=0;
		int angleRad2=0;
		for(int p=0;p<5;p++) { //this for loop will draw the different explosive trajectories
			
			
			neg=rand.nextInt(2);
			//the below for loop draws the trajectory once the firework explodes into diff pieces
			for (double z= 0; z <= time; z += 0.005) {
				int x = endingX+(int) ((velocity)*(Math.cos(angleRad2)*z)); 
				int y = endingY+(int) ((velocity*Math.sin(angleRad2)*z)-(0.5*9.8*Math.pow(z, 2)));
				e.setColor(color.ORANGE);
				
				e.fillOval(x - (4/2), y - (4/2), 4, 4);
				endingX2=x; //the temporary ending value is set to the ending value X of this specific trajectory
				endingY2=y; //the temporary ending value is set to the ending value Y of this specific trajectory
			}
			e.setColor(color); //sets the color to the user specified color
			
			for(int x=0;x<=2;x++) {
				length=rand.nextInt(60)+5; //the length of the square is randomly generated each time
				e.drawRect(endingX2+rand.nextInt(35),endingY2+rand.nextInt(35),length,length); //draws the Square from the endingX2 and EndingY2 of length
				
				
			}
			//the below for loop repeats what my first for loop did
			for(int x=0;x<=2;x++) {
				length=rand.nextInt(60)+5;
				e.drawRect(endingX2-rand.nextInt(35),endingY2-rand.nextInt(35),length,length);
				
				
			}
			for(int x=0;x<=2;x++) {
				length=rand.nextInt(60)+5;
				e.drawRect(endingX2,endingY2+rand.nextInt(35),length,length);
				
				
			}
			for(int x=0;x<=2;x++) {
				length=rand.nextInt(60)+5;
				e.drawRect(endingX2,endingY2-rand.nextInt(35),length,length);
				
				
			}
			for(int x=0;x<=2;x++) {
				length=rand.nextInt(60)+5;
				e.drawRect(endingX2-rand.nextInt(35),endingY2,length,length);
				
				
			}
			for(int x=0;x<=2;x++) {
				length=rand.nextInt(60)+5;
				e.drawRect(endingX2+rand.nextInt(35),endingY2,length,length);
				
				
			}
			angleRad2=angleRad2+1; //the angleRad2 which is the angle used to draw the explosive trajectory is incremented by 1 radians.
		}
		e.setColor(color);
	
		
	}
	
	public static void Standard(Graphics e) {
		
		e.setColor(color);
		int stepY=20;
		int stepX=20;
		int initialHeight=0; //initialHeight set to 0
		int initialWidth=endingX; //initialWidth set to the endingpointX of trajectory
		for(int x=0;x<=5;x++) {
			
			e.drawLine(endingX,endingY,initialWidth,initialHeight); //draws six lines from endingX and endingY to initialWidth and initialHeight.
			initialHeight=initialHeight+20; //initialHeight is incremented by 20
			initialWidth=initialWidth+20; //initialWidth is incremented by 20
			
		}
		initialWidth=0;
		initialHeight=endingY; 
		//the below for loop behaves similarly to the above for loop apart from the fact that it draws 8 lines and its initialWidth is 0 and height is equal to the endingY
		for(int x=0;x<=7;x++) {
			
			e.drawLine(endingX,endingY,initialWidth,initialHeight);
			initialHeight=initialHeight+20;
			initialWidth=initialWidth+20;
			
		}
		
	}
	public static void Bomb(Graphics e) {
		int endingX2=0,endingY2=0;
		int angleRad2=0;
		for(int p=0;p<5;p++) { //this for loop will draw the different explosive trajectories
			
			//the below for loop draws the trajectory once the firework explodes into diff pieces
			for (double z= 0; z <= time; z += 0.005) {
				int x = endingX+(int) ((velocity)*(Math.cos(angleRad2)*z));
				int y = endingY+(int) ((velocity*Math.sin(angleRad2)*z)-(0.5*9.8*Math.pow(z, 2)));
				e.setColor(color.ORANGE);
				
				e.fillOval(x - (4/2), y - (4/2), 4, 4);
				endingX2=x; //the temporary ending value is set to the ending value X of this specific trajectory
				endingY2=y; //the temporary ending value is set to the ending value Y of this specific trajectory
			}
		e.setColor(Color.black); //the BOMB color is always black
		e.fillOval(endingX2-45, endingY2, 90,90); // makes black circle of radius 45
		e.setColor(Color.red);// sets color to red
		e.drawLine(endingX2, endingY2, endingX2, endingY2-10); // draws line from endingX2 endingY2 to endingX2 endingY2-10
		e.drawLine(endingX2, endingY2-10, endingX2+10, endingY2-20); //draws another line from endingX2,EndingY2-10 to endingX2+10,endingY2-20
		angleRad2=angleRad2+1;  //the angleRad2 which is the angle used to draw the explosive trajectory is incremented by 1 radians.
		}
	}
}
