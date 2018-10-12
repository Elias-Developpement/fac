import java.awt.*;
import java.math.*;

	public class VonKoch extends Frame {
		int width, height, niveau;

		public void init(int n) {
			niveau = n;
			width = getSize().width;
	    height = getSize().height;
	    setBackground(Color.white);
		}

		public void dessine(Graphics g, int n, double x1, double y1, double x2, double y2) {
			if (0 == n) {
				// Dessine le premier segment
				g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
				return;
			}

			// Détermine le milieu du premier segment
			double dx = x2 - x1;
			double dy = y2 - y1;

			// Premier tier du segment
			double xp = x1 + (dx / 3.);
			double yp = y1 + (dy / 3.);

			// Deuxième tier du segment
			double xq = x1 + 2 * dx / 3.;
			double yq = y1 + 2 * dy / 3.;

			// Moitié de la moitié du segment
			double xm = x1 + dx / 2.;
			double ym = y1 + dy / 2.;

			// Sommet du triangle
			double xt = xm - dy / Math.sqrt(12);
			double yt = ym + dx / Math.sqrt(12);

			// Dessine les segments
			dessine(g, n-1, x1, y1, xp, yp);
			dessine(g, n-1, xp, yp, xt, yt);
			dessine(g, n-1, xt, yt, xq, yq);
			dessine(g, n-1, xq, yq, x2, y2);
		}


	public void paint(Graphics g) {
		g.setColor(Color.black);
		dessine(g, niveau, 130., 250., 490., 250.);
	}

	public static void main(String args[]) {
		VonKoch v = new VonKoch();

		v.init(2);
		v.setBounds(0, 0, 500, 500);
	  v.setVisible(true);
	}
}
