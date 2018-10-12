import java.awt.*;
import java.math.*;

	public class Hanoi extends Frame
	{
		int width,height,niveau;	
	
	
	public void init(int n)
	{
		niveau=n;
      width = getSize().width;
      height = getSize().height;
      setBackground( Color.white );
	}	
	
	public void dessineB(Graphics g, int n)
	{
		//Affichage des tours sans les disques
		g.drawLine(100,100,100,200);		
		g.drawLine(100+25*n,100,100+25*n,200);		
		g.drawLine((100+25*n)+25*n,100,(100+25*n)+25*n,200);		
	}
	
	public void dessineD(Graphics g, int n,)
	{
		//Affichage des disques	
		
	
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		dessineB(g, niveau);	
	}

	public static void main (String args[])
	{
		Hanoi h = new Hanoi();
		h.init(8);
		h.setBounds(0, 0, 500, 500);
	   h.setVisible(true); 
	}
}