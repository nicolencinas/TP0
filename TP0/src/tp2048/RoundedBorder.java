package tp2048;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

class RoundedBorder implements Border {

    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }
    
    

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
    	c.setBackground(new Color(241,245,169));
    	g.setColor(new Color (162,172,4));
    	
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
