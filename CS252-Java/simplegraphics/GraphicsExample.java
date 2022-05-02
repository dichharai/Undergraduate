import javax.swing.JFrame;

public class GraphicsExample{
	public static void main(String[] args){
		GraphicsFrame gf = new GraphicsFrame();
		gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//convention says visible is the last thing you want to do
		gf.setVisible(true);
	}
	public void quit(){
		GraphicsFrame gf = new GraphicsFrame();
		gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}