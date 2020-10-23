package com.slenS.line_drawers;

public interface LineDrawer {
    enum Type {
        Briesenham,
        DDA,
        Wu
    }
    void drawLine(int x1, int y1, int x2, int y2);
}
