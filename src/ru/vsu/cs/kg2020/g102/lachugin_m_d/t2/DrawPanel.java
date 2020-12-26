package ru.vsu.cs.kg2020.g102.lachugin_m_d.t2;

import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers.BresenhamLineDrawer;
import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers.DDALineDrawer;
import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers.WuLineDrawer;
import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers.LineDrawer;
import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0, 0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        PixelDrawer pd = new GrapihcsPixelDrawer(bi_g);

        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.black);

        LineDrawer ld = new DDALineDrawer(pd);
        drawAll(ld, -getWidth() / 4, getHeight()/3);
        ld = new BresenhamLineDrawer(pd);
        drawAll(ld, 0, getHeight()/3);
        ld = new WuLineDrawer(pd);
        drawAll(ld, getWidth() / 4, getHeight()/3);

        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();


    }

    private void drawAll(LineDrawer ld) {

        drawAll(ld, 0, 0);
    }

    private void drawAll(LineDrawer ld, int x, int y) {

        DrawUtils.drawSnowFlake(ld, getWidth()/2+x, getHeight()*4/5, 100, 64);
        ld.drawLine(getWidth()/2+x/2, y, position.x+x/2, position.y-100);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}

