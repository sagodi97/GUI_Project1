import java.awt.*;

public class Egg {
    Color cAd;
    int x,y,size;

    Egg(Color cAd, int x, int y, int width){
        this.cAd = cAd;
        this.x = x;
        this.y = y;
        this.size = width;
    }

    void drawMe(Graphics g){
        g.setColor(Color.white);
        g.drawOval(x,y,size,size);
        g.setColor(cAd);
        g.fillOval(x,y,size,size);
    }

    public String toString(){
        return cAd.toString() + "," + x + "," + y + "," + size;
    }
}
