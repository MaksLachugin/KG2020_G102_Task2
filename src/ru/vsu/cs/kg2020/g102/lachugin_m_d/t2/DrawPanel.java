package ru.vsu.cs.kg2020.g102.lachugin_m_d.t2;

import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers.BresenhamLineDrawer;
import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers.DDALineDrawer;
import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers.WuLineDrawer;
import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers.LineDrawer;
import ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.utils.DrawUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class DrawPanel extends JPanel implements MouseMotionListener, KeyListener {
    private Point position = new Point(0, 0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        PixelDrawer pd = new GrapihcsPixelDrawer(bi_g);

        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.black);

        drawTests(pd);

        g.drawImage(bi, 0, 0, null);

        bi_g.dispose();

    }

    private void drawTests(PixelDrawer pd) {
        LineDrawer ld = new DDALineDrawer(pd);
        drawAll(ld, -getWidth() / 4, getHeight() / 3);
        ld = new BresenhamLineDrawer(pd);
        drawAll(ld, 0, getHeight() / 3);
        ld = new WuLineDrawer(pd);
        drawAll(ld, getWidth() / 4, getHeight() / 3);


        testDDABresenhamLine(pd);
    }

    private void drawAll(LineDrawer ld, int x, int y) {

        DrawUtils.drawSnowFlake(ld, getWidth() / 2 + x, y + getHeight() * 2 / 5, 100, 64);
        ld.drawLine(getWidth() / 2 + x / 2, y, position.x + x / 2, position.y - 100);
    }

    public void testDDABresenhamLine(PixelDrawer pd) {
        LineDrawer ld = new DDALineDrawer(pd);
        ld.setDefColorX(Color.DARK_GRAY);
        ld.setDefColorY(Color.DARK_GRAY);
        drawAll(ld, getWidth() / 5 * 2, getHeight() / 5);
        ld = new BresenhamLineDrawer(pd);
        ld.setDefColorX(Color.YELLOW);
        ld.setDefColorY(Color.YELLOW);
        drawAll(ld, getWidth() / 5 * 2, getHeight() / 5);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            try {
                Rectangle screenRect = new Rectangle(getX(), getY(), getWidth(), getHeight());
                BufferedImage capture = new Robot().createScreenCapture(screenRect);
                ImageIO.write(capture, "bmp", new File("scr.bmp"));
            } catch (Exception exception) {
                System.out.println(exception);
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

