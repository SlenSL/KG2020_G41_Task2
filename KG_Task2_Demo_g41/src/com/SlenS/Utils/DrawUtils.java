package com.SlenS.Utils;

import java.awt.*;

public class DrawUtils {
    public static void drawSnowflake(Graphics g, int x, int y, int r, int n) {
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double dx = r * Math.cos(da * i);
            double dy = r * Math.sin(da * i);
            g.drawLine(x, y, x + (int) dx, y + (int) dy);
        }
    }
}
