package com.slenS.factories;


import com.slenS.line_drawers.LineDrawer;

import java.awt.*;

public interface LineDrawerFactory {
    LineDrawer createLineDrawer(Graphics g);

    void setType(LineDrawer.Type t);

    LineDrawer.Type getType();
}
