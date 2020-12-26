package ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers;

import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
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

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    private void DrawPoint(boolean s, int x, int y, double k) {
        if (s) {
            pd.drawPixel(y, x, new Color(DefColorY.getRed(), DefColorY.getGreen(), DefColorY.getBlue(), (int) (255 * k)));
        } else {
            try {
                pd.drawPixel(x, y, new Color(DefColorX.getRed(), DefColorX.getGreen(), DefColorX.getBlue(), (int) (255 * k)));
            } catch (Exception e) {
            }

        }
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        var steep = Math.abs(y2 - y1) > Math.abs(x2 - x1);
        if (steep) {
            int temp = x1;
            x1 = y1;
            y1 = temp;
            temp = x2;
            x2 = y2;
            y2 = temp;
        }
        if (x1 > x2) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
            temp = y1;
            y1 = y2;
            y2 = temp;

        }

        DrawPoint(steep, x1, y1, 1);
        DrawPoint(steep, x2, y2, 1);
        float dx = x2 - x1;
        float dy = y2 - y1;
        float gradient = dy / dx;
        float y = y1 + gradient;
        for (var x = x1 + 1; x <= x2 - 1; x++) {
            DrawPoint(steep, x, (int) y, 1 - y % 1);
            DrawPoint(steep, x, (int) y + 1, y % 1);

            y += gradient;
        }

    }

    @Override
    public void setColor(Color color) {

    }
}
