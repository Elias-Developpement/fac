
import java.awt.*;
import java.applet.*;
import java.net.* ;

// DESSIN DE L'ENSEMBLE DE mandelbrot. Le cadre est [x0..x1][y0..y1]

public class Mandel extends Frame {
  static double x0= -2.0, x1= 1.0, y0= -1.5, y1=1.5 ;

  public void init() { setBackground(Color.white); }

   public static double interpol( double x0, double y0, double x1, double y1, double x)
   { 	return y0*(x-x1)/(x0-x1) + y1*(x-x0)/(x1-x0) ;  }

   public static int mandel( int i, double zx, double zy, double cx, double cy)
   {	if (i==25 || zx * zx + zy*zy > 4.) {return i;}
		else {
			return mandel (i+1,zx*zx-zy*zy+cx,2*zx*zy+cy,cx,cy);
		}      

   }
   public void paint(Graphics g) {
      double w= getSize().width; double h= getSize().height; 
      for( int x=0; x < w; x++ ) for (int y= 0; y < h; y++ )
      {
	double cx= interpol( 0.,x0,w,x1,x );
        double cy= interpol( 0.,y1,h,y0,y );
        int gris= mandel( 0, cx, cy, 0.5,0.5);
        g.setColor(new Color( 10*gris, 10*gris, 10*gris)); 
        g.fillRect( x,y, 1, 1);
      }
  }

public static void main (String arg[]) {
  Mandel f = new Mandel();
  f.setBounds(100, 100, 512, 512);
  f.setVisible(true);
 }
}
