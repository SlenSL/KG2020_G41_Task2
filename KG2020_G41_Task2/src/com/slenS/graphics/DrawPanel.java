package com.slenS.graphics;


import com.slenS.factories.LDFactory;
import com.slenS.factories.LineDrawerFactory;
import com.slenS.line_drawers.LineDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener {
    private Point[] points = {new Point(0, 0), new Point(0, 0)};
    private LineDrawerFactory f;


    public DrawPanel() {
        f = new LDFactory();
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        //this.addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();

        LineDrawer ld = f.createLineDrawer(bi_g);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.black);
        bi_g.drawString(ld.toString(), 0, getFontMetrics(getFont()).getHeight());
        drawAll(ld);

        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawAll(LineDrawer ld) {
        //DrawUtils.drawSnowflake(ld, getWidth() / 2, getHeight() / 2, 150, 32);
        ld.drawLine(points[0].x, points[0].y, points[1].x, points[1].y);
    }


//    @Override
//    public void keyTyped(KeyEvent e) {
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            f.setType(LineDrawer.Type.Briesenham);
        }
        if (e.getButton() == MouseEvent.BUTTON2) {
            f.setType(LineDrawer.Type.DDA);
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            f.setType(LineDrawer.Type.Wu);
        }


        points[0] = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        points[1] = e.getPoint();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        points[1] = e.getPoint();
    }
}
