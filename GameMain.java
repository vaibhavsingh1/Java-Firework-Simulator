import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*“I did not collaborate with anyone on this Project.” 

Name: Moazzam Salman and Abdul Moid
NET ID: msalman and amunawar.
Project 3
Lab : Tuesday and Thursday (11:05am-12:20pm)

*/

public class GameMain extends JFrame implements ActionListener,ChangeListener  {
	//Declares all the GUI components and variables to be used a global static variables
		public JButton launchBtn;
		public static Color color=Color.orange;
		public static Frame fireworkGUI;
		public JLabel velocityText,angleText,timeText;
		public JSlider velocitySlider,angleSlider,timeSlider;
		public JComboBox colorDropdown,typeBox;
		public String gameType="Standard";
		public static double velocity=75;
		public static double angleRad=0.436332;
		public static double time=1;
		public static int width,height;
	public GameMain() { 
		JFrame game=new JFrame("FireWork Launcher"); //makes the Frame
		game.setLayout(new FlowLayout()); //uses flowlayout
		setGUI(game); //calls the setGui Method
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(1200,80);
		
		game.setVisible(true);
	}
	public static void main(String[] args) {
		new GameMain();	//calls the GameMain constructor
	}
	public void setGUI(JFrame game) {
		launchBtn=new JButton("Launch"); //creates button
		launchBtn.addActionListener(this);
		game.add(launchBtn); //adds the button to the Frame
		velocityText=new JLabel("Velocity(m/s):75 ");
		game.add(velocityText);
		velocitySlider = new JSlider(75, 125, 75); //creates the slider and values range from 75-125 and starts from 75
		game.add(velocitySlider); 
		angleText=new JLabel("Angle (deg):25 ");
		game.add(angleText);
		angleSlider = new JSlider(25, 70, 25); //creates the slider with value ranges from 25-70 starting from 25
		game.add(angleSlider);
		timeText=new JLabel("Time(s):1 ");
		game.add(timeText);
		timeSlider = new JSlider(1,5,1); //creates the Slider with values ranging from 1-5 and starting from 1
		game.add(timeSlider);
		String[] colors = {"Orange", "Blue", "Cyan", "Red", "Green", "Magenta", "Pink"}; //creates an array of colors
		colorDropdown = new JComboBox(colors); //adds the array to the ComboBox
		game.add(colorDropdown);
		String[] fireworkTypes = {"Standard", "Circles", "Funnel", "Bomb", "Squares"}; //creates an array of gameTypes
		typeBox = new JComboBox(fireworkTypes); //adds the gameTypes to the ComboBox.
		game.add(typeBox);
		addListeners(); //calls the addListeners method where all the listeners are added
		
	}
	public void addListeners() {
		typeBox.addActionListener(this);
		colorDropdown.addActionListener(this);
		timeSlider.addChangeListener(this);
		angleSlider.addChangeListener(this);
		velocitySlider.addChangeListener(this);
		
	}
	@Override
	public void stateChanged(ChangeEvent e) { //called when the slider value changed
		
		System.out.println("FireworksGUI.stateChanged");
		Object source = e.getSource();//gets the source of the slider
		//these if statements below check which slider was touched and do things accordingly
		if (source == velocitySlider) { 
			velocityText.setText("Velocity (m/s): " + String.valueOf(velocitySlider.getValue())); //sets the label to the velocityslider value
			velocity= velocitySlider.getValue(); //sets the velocity value to velocity slider value.
		} else if (source == angleSlider) {
			angleText.setText("Angle (deg): " + String.valueOf(angleSlider.getValue())); //sets the label value to slider value
			angleRad = angleSlider.getValue();
			angleRad = Math.toRadians(angleRad); //converts the degree value to radians
		} else if (source == timeSlider) {
			timeText.setText("Time (s): " + String.valueOf(timeSlider.getValue())); //sets the textlabel value to the timeslider value
			time=timeSlider.getValue(); //sets the time value to the timeslider value
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		Object source=e.getSource(); // gets the source
		if(source==launchBtn) {
			fireworkGUI=new Frame(); //if launch button was clicked then a new frame is created
		
		}
		else if (source == colorDropdown) { //if colorDropdown was selected
			String colorString = (String) colorDropdown.getSelectedItem(); //gets the String value of the colordropdown selected
			//the switch below compares the string with different color values and sets the global color value accordingly
			switch (colorString) {
				case "Blue":
					color = Color.BLUE;
					break;
				case "Cyan":
					color = Color.CYAN;
					break;
				case "Red":
					color = Color.RED;
					break;
				case "Orange":
					color = Color.ORANGE;
					break;
				case "Green":
					color = Color.GREEN;
					break;
				case "Magenta":
					color = Color.MAGENTA;
					break;
				case "Pink":
					color = Color.PINK;
					break;
			}
			System.out.println("Color changed to " + String.valueOf(color));
		} else if (source == typeBox) { // if the typeBox combobox was clicked
			gameType = (String) typeBox.getSelectedItem(); //gets the gameType value selected
		}
		
	}
	public class Frame extends JFrame {
		protected JFrame fireworkFrame;
		
		public Frame() {
			fireworkFrame=new JFrame("Firework Display"); //creates new frame in which firework displays
			Canvas canvas=new Canvas(); //creates an instance of the nested canvas class
			fireworkFrame.add(canvas); //adds the canvas class
			fireworkFrame.setSize(700,700);
			
			fireworkFrame.setResizable(true);
			fireworkFrame.setVisible(true);	
	
		}

		public class Canvas extends JComponent {
		
			public void paintComponent(Graphics e) {
				width=getWidth();
				height=getHeight();
				
				e.fillRect(0, 0, width,height); //sets the frame background to black
				fireworkAction.endingPoint(); //calls the endingPoint method
				fireworkAction.drawTrajectory(e); //the fireworkAction drawTrajectory is called
				//the below switch compares the gameType with the different gameTypes and calls the method accordingly.
				switch(gameType) {
				case "Standard":
					fireworkAction.Standard(e);
					
					break;
				case "Circles":
					fireworkAction.Circles(e);
					break;
				case "Funnel":
					fireworkAction.Funnel(e);
					break;
				case "Bomb":
					fireworkAction.Bomb(e);
					
					break;
				case "Squares":
					fireworkAction.Squares(e);
				break;
				default:
		
					break;
				}
			}
			
		}
	}
		
		
		
	
	
}
