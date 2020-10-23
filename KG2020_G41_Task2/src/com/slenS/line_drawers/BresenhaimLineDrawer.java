package com.slenS.line_drawers;

import com.slenS.pixel_drawers.PixelDrawer;

import java.awt.*;

public class BresenhaimLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenhaimLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }


    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
//        int x2 = line.getEnd().x;
//        int x1 = line.getStart().x;
//        int y2 = line.getEnd().y;
//        int y1 = line.getStart().y;
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int dx2 = 2 * dx;
        int dy2 = 2 * dy;

        int ix = x1 < x2 ? 1 : -1;//если начало отрезка меньше конца, то будем двигаться вправо, больше - влево
        int iy = y1 < y2 ? 1 : -1;//если начало отрезка меньше конца, то будем двигаться вверх, больше - вниз

        int d = 0;
        if (dx >= dy) {//берем независимой переменную x, т.к. велечина углового коэф. не превосходит единицу
            while (true) {
                pd.setPixel(x1, y1, Color.RED);//ставим очередной пиксель пиксель, пока не дойдем до конца отрезка
                if (x1 == x2)//дошли до конца отрезка
                    break;
                x1 += ix;//переходим на следующую координату по x
                d += dy2;
                if (d > dx) {//отрезок проходит выше срединной точки
                    y1 += iy;//переходим не следующую координута по y
                    d -= dx2;
                }
            }
        } else {//берем независимой переменную y, т.к. наклон больше единицы
            while (true) {
                pd.setPixel(x1, y1, Color.RED);//ставим первый пиксель
                if (y1 == y2)
                    break;
                y1 += iy;//переходим на следующую координату по y
                d += dx2;
                if (d > dy) {//отрезок проходит выше срединной точки
                    x1 += ix;//переходим не следующую координута по x
                    d -= dy2;
                }
            }
        }
    }

    public String toString() {
        return "Bresenham line drawer";
    }
}
