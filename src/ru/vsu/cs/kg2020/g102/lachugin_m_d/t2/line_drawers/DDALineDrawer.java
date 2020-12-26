package ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers;

import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.PixelDrawer;

import java.awt.*;

public class DDALineDrawer implements LineDrawer {
    private PixelDrawer pd;
    private Color DefColorX = Color.red;
    private Color DefColorY = Color.blue;

    public void setDefColorX(Color defColorX) {
        DefColorX = defColorX;
    }

    public void setDefColorY(Color defColorY) {
        DefColorY = defColorY;
    }

    public Color getDefColorX() {
        return DefColorX;
    }

    public Color getDefColorY() {
        return DefColorY;
    }

    public DDALineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy)) {
            double k = dy / dx;
            if (x1 > x2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
            for (int j = x1; j <= x2; j++) {
                double i = k * (j - x1) + y1;
                pd.drawPixel(j, (int) i, getDefColorX());
            }

        } else {
            if (y1 > y2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
//            анти к, чтобы к != 0
            double k = dx / dy;
            for (int i = y1; i <= y2; i++) {
                double j = (i - y1) * k + x1;
                pd.drawPixel((int) j, i, getDefColorY());
            }
        }
    }



}
