package ru.vsu.cs.kg2020.g102.lachugin_m_d.t2;

import java.awt.*;

public class Sun implements Drawable {
    private final int x;
    private final int y;
    private final int r;
    private final int R;
    private final int countLine;
    private final Color color;

    public Sun(int x, int y, int r, int R, int countLine, Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.R = R;
        this.countLine = countLine;
        this.color = color;

    }
    @Override
    public void draw(Graphics2D g) {
        drawSun(g, x, y, r, R, countLine, color);
    }

    public static void drawSun(Graphics2D g, int x, int y, int r, int R, int countLine, Color color) {
        g.setColor(color);
        g.fillOval(x - r, y - r, r * 2, r * 2);
        double da = 2 * Math.PI / countLine;
        for (int i = 0; i < countLine; i++) {
            double alpha = da * i;
            double x1 = r * Math.cos(alpha);
            double y1 = r * Math.sin(alpha);
            double x2 = R * Math.cos(alpha);
            double y2 = R * Math.sin(alpha);
            g.drawLine(x + (int) x1, y + (int) y1, x + (int) x2, y + (int) y2);
        }
    }
}
