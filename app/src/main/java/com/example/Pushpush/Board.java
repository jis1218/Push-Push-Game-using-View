package com.example.Pushpush;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by 정인섭 on 2017-10-05.
 */

public class Board {

    private Setting setting;
    private Paint paint;
    private int color_pick[] = {Color.WHITE, Color.BLUE, Color.BLUE, Color.GRAY, Color.GRAY, Color.MAGENTA, 0, 0, 0, Color.BLACK};

    protected int board[][] = {
          //(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11)
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, // 0
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9}, // 1
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 0, 9}, // 2
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 0, 9}, // 3
            {9, 9, 0, 0, 9, 9, 0, 0, 0, 9, 0, 9}, // 4
            {9, 9, 0, 0, 0, 2, 0, 0, 0, 9, 0, 9}, // 5
            {9, 9, 2, 0, 9, 9, 9, 0, 2, 9, 0, 9}, // 6
            {9, 9, 0, 9, 3, 3, 3, 9, 0, 9, 0, 9}, // 7
            {9, 9, 0, 9, 3, 3, 3, 9, 0, 9, 9, 9}, // 8
            {9, 0, 2, 0, 0, 2, 0, 0, 2, 0, 9, 9}, // 9
            {9, 0, 0, 0, 0, 0, 9, 0, 0, 0, 9, 9}, // 10
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, // 11
    };

    public Board(Context context) {
        setting = new Setting(context);
        paint = new Paint();
        //paint.setStyle(Paint.Style.STROKE);
        //paint.setStrokeWidth(10);
    }

    public Paint getPaint(int color){
        paint.setColor(color_pick[color]);

        return paint;
    }

    public void drawBoard(Canvas canvas) {

        for (int v = 0; v < board.length; v++) {
            for (int h = 0; h < board[0].length; h++) {
                canvas.drawRect(h*setting.cell_width, v*setting.cell_width,
                        (h+1)*setting.cell_width, (v+1)*setting.cell_width, getPaint(board[v][h]) );
            }
        }
    }

}
