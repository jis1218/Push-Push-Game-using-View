package com.example.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by 정인섭 on 2017-09-28.
 */

public class Block extends View {


    public int top;
    public int left;

    Paint paintForBlock;

    public Block(Context context, int top, int left) {
        super(context);

        this.top = top;
        this.left = left;

        paintForBlock = new Paint();
        paintForBlock.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(left,top,left+70,top+70, paintForBlock);
    }
}
