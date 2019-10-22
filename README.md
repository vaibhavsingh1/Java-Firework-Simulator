# Animated-Firework-Simulator
I have a main method which creates a new GameMain causing the constructor of GameMain to be called and this causes
the JFrame game to be created and the layout is set to flowlayout and the setGui method is called where all the GUI components are created
and then added to the game frame. the velocitySlider has values from 75 to 125 and the timeSlider has values from 1-5 and the angleSlider has values from 25-75.
These values were set to get optimum projectile performance. The comboboxes are created and the colors are added in the colorDropdown and the gameTypes in the fireworkTypes.
In case when the slider values are changed the source is found and if velocity slider then the velocity label is changed and the value is stored in velocity variable.
the same is done with angleSlider and timeSlider but in case of angleSlider angleRad is converted into radians. if the dropdowns or the gametype dropdown are selected then the
actionPerformed is called and it stores of the value of the dropdown into strings and does action accordingly. The launchBtn when clicked creates a new fireworkGUI frame and automatically
the Frame constructor is called which causes frame to be made and adds the canvas and the paintComponent of canvas causes the background to get black and and then the endingPoint method is called
which calculates the final point of trajectory and then drawTrajectory is called which draws the Trajectory. I then put a switch statement which compares all the gameTypes and calls the methods accordingly.
the Circles method is called if the user has set the gametype to circles and this first from the initial ending trajectory point makes 5 explosive trajectories and then uses that specific trajectories ending point
to draw the circles. the angle increments by 1 radians at the end. the Funnel method called  and this first from the initial ending trajectory point makes 5 explosive trajectories and then uses that specific trajectories ending point
to draw the small funnels the angle at the end is incremented by 1 radians. The standard method draws lines in direction from the ending point of the initial trajectory. the Bomb method
draws 5 trajectories after the first initial trajectory and at the end of each new trajectory it draws an oval and two lines to make a bomb like shape.
My velocity starts from 75, my angle from 25 and my time from 1s to optimise the projectile launch.
Run Instructions: javac GameMain.java, java GameMain

PREVIEW:
![image](https://user-images.githubusercontent.com/46281169/61616256-66fb1380-ac81-11e9-9b70-63db950a52d5.png)
