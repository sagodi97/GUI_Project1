import java.awt.*;

public class Egg {
    Color cAd;
    int x,y,width,height;

    Egg(Color cAd, int x, int y, int width, int height){
        this.cAd = cAd;
        this.x = x;
        this.y = y;
        this. width = width;
        this.height = height;
    }

    void drawMe(Graphics g){
        g.setColor(Color.white);
        g.drawOval(x,y,width,height);
        g.setColor(cAd);
        g.fillOval(x,y,width,height);
    }
}
