package ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers;

import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {

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



    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    private double function(double x, double y, int x1, int y1, int dx, int dy) {
        return (x - x1) * dy - (y - y1) * dx;
    }


    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
//        test(x1, y1, x2, y2);


        if (Math.abs(x2 - x1) >= Math.abs(y2 - y1)) {
            if (x1 > x2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
            int x = x1;
            int y = y1;
            int Dx = x2 - x1;
            int Dy = y2 - y1;
            int DDy = Math.abs(Dy);
            int n = (int) Math.signum(Dy);
            int e = 2 * Dy - Dx;

            for (int i = 1; i <= Dx; i++) {
                pd.drawPixel(x, y, getDefColorX());
                if (e >= 0) {
                    y += n;
                    e -= 2 * Dx - 2 * DDy;
                } else {
                    e += 2 * DDy;
                }
                x++;
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
            int x = x1;
            int y = y1;
            int Dx = x2 - x1;
            int Dy = y2 - y1;
            int DDx = Math.abs(Dx);
            int n = (int) Math.signum(Dx);
            int e = 2 * Dx - Dy;

            for (int i = 1; i <= Dy; i++) {
                pd.drawPixel(x, y, getDefColorY());
                if (e >= 0) {
                    x += n;
                    e += 2 * DDx - 2 * Dy;
                } else {
                    e += 2 * DDx;
                }
                y++;
            }
        }

    }

    @Override
    public void setColor(Color color) {

    }


    private void test(int x1, int y1, int x2, int y2) {
        //    (x-x1)dy - (y-y1) dx = 0
        int dx = x2 - x1;
        int dy = y2 - y1;

        int ddx = Math.abs(dx);
        int ddy = Math.abs(dy);
        double d = 0;
        if (ddx > ddy) {
            if (x1 > x2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
            dx = x2 - x1;
            dy = y2 - y1;

            int ndy = Integer.compare(dy, 0);
            int y = y1;

            for (int x = x1; x <= x2; x++) {
                pd.drawPixel(x, y, Color.BLUE);
                if (ndy > 0) {
                    if (d < 0) {
                        d = function(x + 1, y + 0.5 * ndy, x1, y1, dx, dy);
                    } else {
                        d = function(x + 1, y + 1.5 * ndy, x1, y1, dx, dy);
                        y += ndy;
                    }
                } else {
                    if (d <= 0) {
                        d = function(x + 1, y + 1.5 * ndy, x1, y1, dx, dy);
                        y += ndy;
                    } else {

                        d = function(x + 1, y + 0.5 * ndy, x1, y1, dx, dy);
                    }
                }
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
            dx = x2 - x1;
            dy = y2 - y1;

            int ndx = Integer.compare(dx, 0);
            int x = x1;

            for (int y = y1; y <= y2; y++) {
                pd.drawPixel(x, y, Color.RED);
                if (ndx > 0) {
                    if (d > 0) {
                        d = function(x + 0.5 * ndx, y + 1, x1, y1, dx, dy);
                    } else {

                        d = function(x + 1.5 * ndx, y + 1, x1, y1, dx, dy);
                        x += ndx;
                    }
                } else {
                    if (d > 0) {
                        d = function(x + 1.5 * ndx, y + 1, x1, y1, dx, dy);
                        x += ndx;
                    } else {

                        d = function(x + 0.5 * ndx, y + 1, x1, y1, dx, dy);
                    }
                }
            }
        }

    }

    private void test1(int x1, int y1, int x2, int y2) {
        int x = x1, y = y1, dx = x2 - x1, dy = y2 - y1, count = dx;
        float f = (dy - dx / 2.f);
        pd.drawPixel(x, y, Color.BLUE);
        while (count > 0) {
            count--;

            if (f > 0) {
                y++;
                f += (dy - dx);

            } else {
                f += dy;
            }
            x++;
            pd.drawPixel(x, y, Color.BLUE);
        }

    }

    private void test2(int x1, int y1, int x2, int y2) {

        if (Math.abs(x2 - x1) >= Math.abs(y2 - y1)) {
            if (x1 > x2) {
                int t = x1;
                x1 = x2;
                x2 = t;
                t = y1;
                y1 = y2;
                y2 = t;
            }
            int x = x1, y = y1, dx = x2 - x1, dy = y2 - y1;

            int count = dx, incrE = 2 * dy, incrNE = 2 * dy - 2 * dx;
            float f = (dy - dx / 2.f);
            pd.drawPixel(x, y, Color.BLUE);
            if (dy >= 0) {
                while (count > 0) {
                    count--;
                    if (f > 0) {
                        y++;
                        f += incrNE;

                    } else {
                        f += incrE;
                    }
                    x++;
                    pd.drawPixel(x, y, Color.BLUE);
                }
            } else {
                f = dy - dx / 2.f;
                while (count > 0) {

                    count--;
                    if (f > 0) {
                        y--;
                        f += incrNE;

                    } else {
                        f += incrE;
                    }
                    x++;
                    pd.drawPixel(x, y, Color.BLUE);
                }
            }

        }
    }
}
