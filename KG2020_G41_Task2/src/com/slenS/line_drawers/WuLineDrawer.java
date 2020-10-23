package com.slenS.line_drawers;

import com.slenS.pixel_drawers.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        boolean steep = Math.abs(y1 - y2) > Math.abs(x1 - x2); //приращение по x или y?
        if (steep) {
            int temp = x1; x1 = y1; y1 = temp; // поменять местами x0 и y0
            temp = x2; x2 = y2; y2 = temp;
        }

        if (x1 > x2) {  //если x1>x2 поменять местами концы отрезка
            int temp = x1; x1 = x2; x2 = temp;
            temp = y1; y1 = y2; y2 = temp;
        }

        double dx = x2 - x1;
        double dy = y2 - y1;
        double gradient = dy / dx;//угловой коэф.прямой

        // основной цикл
        double y = y1 + gradient;//удаление от прямой
        for (int x = x1 + 1; x < x2; x++) {
            int intY = (int) y;
            pd.setPixel(
                    steep ? intY + 1 : x, steep ? x : intY + 1,
                    new Color(0, 0, 0, (float)  (y - intY))
            );
            pd.setPixel(
                    steep ? intY : x, steep ? x : intY,
                    new Color(0, 0, 0, (float)  (1 - (y - intY)))
            );
            y += gradient;
        }
    }

    public String toString() {
        return "Wu line drawer";
    }
}
