import java.awt.*;

public class Ufo {
    Color c;
    Polygon u;
    Ufo(int[] x, int[] y, Color c){
        this.u = new Polygon(x,y,x.length);
        this.c = c;
    }
    void drawMe(Graphics g){
        g.setColor(Color.white);
        g.drawPolygon(u);
        g.setColor(c);
        g.fillPolygon(u);
    }
    public String toString(){
        return "[" + this.u.xpoints[0] + "," + this.u.xpoints[1] + "," + this.u.xpoints[2] + "," + this.u.xpoints[3] + "," + this.u.xpoints[4] + "]" +"," + "[" + this.u.ypoints[0] + "," + this.u.ypoints[1] + "," + this.u.ypoints[2] + "," + this.u.ypoints[3] + "," + this.u.ypoints[4] + "]" + "," + this.u.npoints ;
    }
}
