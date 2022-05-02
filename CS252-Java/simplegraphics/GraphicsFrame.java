import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;
import javax.swing.JCheckBoxMenuItem;


import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
//import javax.swing.event.MenuKeyEvent;
//import javax.swing.event.MenuKeyListener;
//in GUI we have to be able to manage lots of file
public class GraphicsFrame extends JFrame{
	//private
	//method
	private JMenuBar mybar;
	private JCheckBoxMenuItem checkBox1;
	private JMenu mymenu;
	private JMenuItem item1;
	private JMenuItem item2;
	private JMenuItem item3;
	private JMenuItem item4;
	private GraphicsPanel gp;



	public GraphicsFrame(){
		super();
		this.setTitle("HELLO Graphics");
		this.setSize(400,400);
		//this.setResizable(false);
		//creating a canvas
		//GraphicsPanel gp = new GraphicsPanel();//error due to shadowing
		gp = new GraphicsPanel();
		//added to  myself
		this.add(gp);
		mybar = new JMenuBar();
		mymenu= new JMenu("Color");
		item1 = new JMenuItem("BG Green");
		item2 = new JMenuItem("Choose BG Color");
		item3 = new JMenuItem("Clear Window");
		checkBox1 = new JCheckBoxMenuItem("Prac0");
		item4 = new JMenuItem("Quit");
		this.setJMenuBar(mybar);
		mybar.add(mymenu);
		mymenu.addSeparator();
		mymenu.add(item2);
		mymenu.addSeparator();
		mymenu.add(item3);
		mymenu.addSeparator();
		mymenu.add(item4);
		mymenu.addSeparator();
		mymenu.add(checkBox1);

		

		/*MenuItem mItem = new MenuItem();
		mi.addMenuKeyListener(mItem);*/
		Item1Listener i1l = new Item1Listener();
		item1.addActionListener(i1l);

		Item2Listener i2l = new Item2Listener();
		item2.addActionListener(i2l);

		Item3Listener i3l = new Item3Listener();
		item3.addActionListener(i3l);

		Item4Listener i4l = new Item4Listener();
		item4.addActionListener(i4l);

		Menu1Listener m1l = new Menu1Listener();
		checkBox1.addActionListener(m1l);
		


	}

	/*private class MenuItem implements MenuKeyListener{
		public MenuItem(){

		}
		public void menuKeyPressed(MenuKeyEvent mke){


		}
		public void menuKeyReleased(MenuKeyEvent mke){

		}
		public void menuKeyTyped(MenuKeyEvent mke){

		}
	}*/


	private class Item1Listener implements ActionListener{
		public Item1Listener(){


		}
		public void actionPerformed(ActionEvent ae){
			gp.setBackground(Color.GREEN);
			//clear arraylist which is also private
			//gp.clearShapes();

		}
	}
	private class Item2Listener implements ActionListener{
		public Item2Listener(){

		}
		public void actionPerformed(ActionEvent ae){
			//System.out.println("Hello");
			Color theColor = JColorChooser.showDialog(null,"Choose a Color",Color.BLUE);
			gp.setBackground(theColor);
		}
	}
	private class Item3Listener implements ActionListener{
		public Item3Listener(){

		}
		public void actionPerformed(ActionEvent ae){
			gp.clearShapes();
		}
	}
	private class Item4Listener implements ActionListener{
		public Item4Listener(){

		}
		public void actionPerformed(ActionEvent ae){
			System.exit(0);//in java.lang so no import
			
		}
	}
	private class Menu1Listener implements ActionListener{
		public Menu1Listener(){

		}
		public void actionPerformed(ActionEvent ae){
			System.out.println("hello there!");
			
		}

		/*public void menuCanceled(MenuEvent me){

		}
		public void menuDeselected(MenuEvent me){

		}
		public void menuSelected(MenuEvent me){
			System.out.println("hell there!");
		}*/
	}
}



