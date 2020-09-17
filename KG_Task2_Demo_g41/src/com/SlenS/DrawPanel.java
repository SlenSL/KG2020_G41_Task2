package com.SlenS;

import com.SlenS.Utils.DrawUtils;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        DrawUtils.drawSnowflake(g,getWidth()/2,getHeight()/2,70, 30);
    }

    @Override
    public void update(Graphics g) {
        super.update(g);

    }

}
