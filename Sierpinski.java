import java.awt.*;
import java.math.*;


	public class Sierpinski extends Frame
	{
		int width, height, niveau;
		
	public void init(int n)
	{
		niveau=n;
      width = getSize().width;
      height = getSize().height;
      setBackground( Color.white );
	}	
	
	public void dessine(Graphics g, int n, double x1, double y1, double x2, double y2, double x3, double y3)
	{
		if (1==n) 
		{
			g.drawLine( (int) x1, (int) y1, (int) x2, (int) y2);
			g.drawLine( (int) x1, (int) y1, (int) x3, (int) y3);
			g.drawLine( (int) x3, (int) y3, (int) x2, (int) y2);
			return;
		}	
		
		double xa = (x2+x3)/2.;
		double ya = (y2+y3)/2.;
		double xb = (x1+x3)/2.;
		double yb = (y1+y3)/2.;
		double xc = (x1+x2)/2.;
		double yc = (y1+y2)/2.;
		
		dessine(g ,n-1 ,x1, y1, xb, yb, xc, yc);
		dessine(g ,n-1 ,xa, ya, xb, yb, x3, y3);
		dessine(g ,n-1 ,xa, ya, x2, y2, xc, yc);
	}
	
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		dessine( g, niveau, 130., 250., 390., 250., 260., 50);	
	}

	public static void main (String args[])
	{
		Sierpinski s = new Sierpinski();
		s.init(10);
		s.setBounds(0, 0, 500, 500);
	   s.setVisible(true); 
	}
}