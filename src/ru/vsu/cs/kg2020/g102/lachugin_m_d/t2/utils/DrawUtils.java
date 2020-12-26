package ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.utils;

import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers.LineDrawer;

public class DrawUtils {

    public static void drawSnowFlake(LineDrawer g, int x, int y, int r, int n, int num) {
        if (num > 2) {
            return;
        }


        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {

            double dx = r * Math.cos(da * i);
            double dy = r * Math.sin(da * i);
            g.drawLine(x, y, x + (int) dx, y + (int) dy);
            drawSnowFlake(g, x + (int) dx, y + (int) dy, r / 3, n, num + 1);
//            for (int j = 0; j < 3; j++) {
//                g.setColor(Color.BLUE);
//                double dx1 = r * Math.cos(2 * da * j);
//                double dy1 = r * Math.sin(2 * da * j);
//                g.drawLine(x + (int) dx, y + (int) dy, 2 * x + (int) dx1, y + (int) dy1);
//            }
        }
    }
    public static void drawSnowFlake(LineDrawer g, int x, int y, int r, int n) {
        drawSnowFlake(g, x, y, r, n, 2);
    }

}
