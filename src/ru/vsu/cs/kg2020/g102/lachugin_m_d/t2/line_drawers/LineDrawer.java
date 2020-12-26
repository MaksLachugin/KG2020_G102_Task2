package ru.vsu.cs.kg2020.g102.lachugin_m_d.t2.line_drawers;

import java.awt.*;

public interface LineDrawer {
    void drawLine(int x1, int y1, int x2, int y2);


    void setDefColorX(Color defColorX);

    void setDefColorY(Color defColorY);
}
