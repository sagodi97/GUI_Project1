import java.awt.*;

public class Ufo {
    Color c;
    Polygon u;
    Ufo(int[] x, int[] y, Color c){
        this.u = new Polygon(x,y,x.length);
        this.c = c;
    }
    void drawMe(Graphics g){
        g.setColor(c);
        g.drawPolygon(u);
    }

}
