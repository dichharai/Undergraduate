import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Random;
import java.util.ArrayList;
import java.awt.Shape;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JColorChooser;

import javax.swing.JLabel;


public class GraphicsPanel extends JPanel{
	private JButton theRedButton;
	private JButton theGreenButton;
	private JButton theCircleButton; 
	private JButton theSquareButton;
	private JButton theColorButton;
	private JButton clickCountButton;
	private int count;

	private JLabel theLabel;
	//private Color currentcolor;

	private Random gen; 
	//declaring myCircle so that circle created in private class is visible outside the class
	//private Ellipse2D.Double myCircle;
	//private Rectangle2D.Double mySquare;
	private ArrayList<Shape> theshapelist;

	public GraphicsPanel(){
	super();
	
	theRedButton = new JButton("Red");
	//theButton = new JButton("Click Me");
	this.add(theRedButton); 
	ClickRedButtonListener rbl = new ClickRedButtonListener();
	theRedButton.addActionListener(rbl);

	theGreenButton = new JButton("Green");
	//theButton = new JButton("Click Me");
	this.add(theGreenButton); 
	ClickGreenButtonListener gbl = new ClickGreenButtonListener();
	theGreenButton.addActionListener(gbl);
	
	theCircleButton = new JButton("Circle");
	this.add(theCircleButton); 
	CircleButtonListener cbl = new CircleButtonListener();
	theCircleButton.addActionListener(cbl);

	theSquareButton = new JButton("Square");
	this.add(theSquareButton);
	SquareButtonListener sbl = new SquareButtonListener();
	theSquareButton.addActionListener(sbl);

	theColorButton = new JButton("Choose Color");
	this.add(theColorButton);
	ColorButtonListener cl = new ColorButtonListener();
	theColorButton.addActionListener(cl);

	theshapelist = new ArrayList<Shape>();

	MouseClickListener mcl = new MouseClickListener();
	this.addMouseListener(mcl);

	MouseDraggedMotionListener mml = new MouseDraggedMotionListener();
	this.addMouseMotionListener(mml);

	//currentcolor = new Color();
	clickCountButton = new JButton("Click Count");
	this.add(clickCountButton);
	ClickCountListener ccl = new ClickCountListener();
	clickCountButton.addActionListener(ccl);

	theLabel = new JLabel();
	//theLabel.setText("Hello There!");
	this.add(theLabel);



	gen = new Random();
	//myCircle = null;
	//mySquare = null;
	}

	// paint Componenet calls automatically
	public void paintComponent(Graphics g){
		//
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//Graphics2D g3 = (Graphics2D) g;
		/*if (myCircle!=null){
			g2.fill(myCircle);
		}
		if (mySquare!=null){
			g3.fill(mySquare);
		}*/
		for (Shape shape:theshapelist)
			g2.fill(shape);
		
		// casting to Graphics2D because we are using Graphics 2d draw method
		/*Graphics2D g2 = (Graphics2D) g;
		Rectangle2D.Double r = new Rectangle2D.Double(50,100,200,300);
		g2.setPaint(Color.RED);
		g2.draw(r);
		g2.fill(r);*/

	}
	// for JFrame  to access  ArrayList()
	public void clearShapes(){
		theshapelist.clear();
		repaint();
	}
	private class ClickRedButtonListener implements ActionListener{
		//if we need parameterised 
		public ClickRedButtonListener(){

		}
		public void actionPerformed(ActionEvent ae){
			/*System.out.println("Hello");
			System.out.println(ae.getWhen());
			System.out.println(ae.getActionCommand());*/
			//cannot have this.set
			setBackground(Color.RED);
		}
	}
	private class ClickGreenButtonListener implements ActionListener{
		//if we need parameterised 
		public ClickGreenButtonListener(){

		}
		public void actionPerformed(ActionEvent ae){
			/*System.out.println("Hello");
			System.out.println(ae.getWhen());
			System.out.println(ae.getActionCommand());*/
			//cannot have this.set
			setBackground(Color.GREEN);
		}
	}
	private class ColorButtonListener implements ActionListener{
		//if we need parameterised 
		public ColorButtonListener(){

		}
		public void actionPerformed(ActionEvent ae){
			/*System.out.println("Hello");
			System.out.println(ae.getWhen());
			System.out.println(ae.getActionCommand());*/
			//cannot have this.set
			Color theColor = JColorChooser.showDialog(null,"Choose a Color",Color.BLACK);
			setBackground(theColor);
		}
	}
	private class CircleButtonListener implements ActionListener{
		public CircleButtonListener(){

		}
		public void actionPerformed(ActionEvent ae){
			int x = gen.nextInt(400);
			int y = gen.nextInt(400);
			//myCircle = new Ellipse2D.Double(x,y,50,50);
			Ellipse2D.Double myCircle = new Ellipse2D.Double(x,y,50,50);
			theshapelist.add(myCircle);
	
			//indirect inovaction of PaintComponenet 

			repaint();

		}
	}
	private class SquareButtonListener implements ActionListener{
		public SquareButtonListener(){

		}
		public void actionPerformed(ActionEvent ae){
			int x = gen.nextInt(400);
			int y = gen.nextInt(400);
			//mySquare = new Rectangle2D.Double(x,y,50,50);
			Rectangle2D.Double mySquare = new Rectangle2D.Double(x,y,50,50);
			theshapelist.add(mySquare);
			repaint();
		}
	}

	private class MouseClickListener implements MouseListener{
		public MouseClickListener(){

		}
		public void mouseClicked(MouseEvent me){
			int x = me.getX();
			int y = me.getY();
			Ellipse2D.Double myCircle = new Ellipse2D.Double(x-13,y-13,26,26);
			theshapelist.add(myCircle);
			repaint();

		}
		public void mouseEntered(MouseEvent me){
			
		} 
		public void mouseExited(MouseEvent me){
			//theshapelist.clear();
			//repaint();

			
		}
		public void mousePressed(MouseEvent me){
			
		}
		public void mouseReleased(MouseEvent me){
			
		}    
	}
	private class MouseDraggedMotionListener implements MouseMotionListener{
		public MouseDraggedMotionListener(){

		}
		public void mouseDragged(MouseEvent me){
			int x = me.getX();
			int y = me.getY();
			Ellipse2D.Double myCircle = new Ellipse2D.Double(x-13,y-13,5,5);
			theshapelist.add(myCircle);
			repaint();

		}
		public void mouseMoved(MouseEvent me){
			//System.out.println(me.getX());

		}
	}
	private class ClickCountListener implements ActionListener{
		public ClickCountListener(){

		}
		public void actionPerformed(ActionEvent ae){
			count++;
			System.out.println("The click count is " + count);
		}
	}
}

	
