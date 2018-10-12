
import java.awt.*;
import java.applet.*;
import java.net.* ;
import java.lang.*;

public class Julie extends Frame {
  double x0= -2.0, x1= 1.5, y0= -1.75, y1=1.75 ;
  static double cx= (1. - Math.sqrt( 5.))/ 2.,  cy= cx; // INTERESTING

  public void init() { setBackground(Color.white); }

   public static double interpol( double x0, double y0, double x1, double y1, double x)
   { 	return y0*(x-x1)/(x0-x1) + y1*(x-x0)/(x1-x0) ;  
   }

	// compte le nombre d'itérations pour "aller vers l'infini"=sortir du cercle
   public static int julia( int i, double zx, double zy)
   {	if (i==255 || zx * zx + zy*zy > 4.) return i;
        return julia( i+1, ???????????????? );
   }

   public void paint(Graphics g) 
   {
      double w= getSize().width; double h= getSize().height; 
      Point p=MouseInfo.getPointerInfo().getLocation();
      int ix=p.x; int iy=p.y;
      while( true)
	{
		p=MouseInfo.getPointerInfo().getLocation(); ix=p.x; iy=p.y; 
		if (0 <= ix && ix < 800 && 0 <= iy && iy < 800)
		{ cx= interpol( 0., -1., w, 1., ix); cy = interpol( 0., 1., h, -1., iy); }
		else {	cx= (1. - Math.sqrt( 5.))/ 2.;  cy= cx; }

		for( int x=0; x < w; x++ ) for (int y= 0; y < h; y++ )
		      { double zx= interpol( 0.,x0,w,x1,x );
			double zy= interpol( 0.,y1,h,y0,y );
			int gris= julia( 0, zx, zy);
			g.setColor(new Color( 255-1*gris, 255-1*gris, 255-1*gris)); 
			g.fillRect( x,y, 1, 1);
		      }
		String sx=Float.toString( new Float( cx));
		String sy=Float.toString( new Float( cy));
		//1000 milliseconds is one second.
		String s= "xpixel=" + ix + " ypixel=" + iy + "  z= " + sx + " + " + sy + "i";
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		g.setColor( Color.black );
		g.drawString( s, 30, 60);
		try { Thread.sleep(100);} 
		catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
	}
}

public static void main (String arg[]) {
  Julie f = new Julie();
  f.setBounds(0, 0, 800, 800);
  f.setVisible(true);
 }

}
