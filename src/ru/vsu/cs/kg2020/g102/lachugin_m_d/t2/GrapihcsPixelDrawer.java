package ru.vsu.cs.kg2020.g102.lachugin_m_d.t2;

import java.awt.*;

public class GrapihcsPixelDrawer implements PixelDrawer {
    private Graphics2D g;

    public GrapihcsPixelDrawer(Graphics g) {
        this.g = (Graphics2D) g;
        this.g.setStroke(new BasicStroke(5));
    }

    @Override
    public void drawPixel(int x, int y, Color c) {
        g.setColor(c);
        g.fillRect(x, y, 1, 1);
    }
}
