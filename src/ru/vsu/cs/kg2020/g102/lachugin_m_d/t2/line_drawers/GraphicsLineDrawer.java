package ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers;

import java.awt.*;

public class GraphicsLineDrawer implements LineDrawer {
    private Graphics g;

    public GraphicsLineDrawer(Graphics g) {
        this.g = g;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);

    }

    @Override
    public void setColor(Color color) {
        g.setColor(color);
    }

    @Override
    public void setDefColorX(Color defColorX) {
        g.setColor(defColorX);
    }

    @Override
    public void setDefColorY(Color defColorY) {
        setDefColorX(defColorY);
    }
}
