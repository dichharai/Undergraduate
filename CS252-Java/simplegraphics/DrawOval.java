import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class DrawOval extends Jpanel{
	private int d = 10;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillOval(10,10, d,d);
	}
	public void setD(int newD){
		d = (newD >= 0? newD: 10);
		repaint();
	}
	public Dimension getPreferredSize(){
		return new Dimension(200,200);

	}
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}

}