package com.example.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by 정인섭 on 2017-09-28.
 */

public class Background extends View {

    int window_Width;
    int unit;
    final int COLUMN_NUM = 10;
    //int window_Height;
    Paint paintForBackground;


    public Background(Context context) {
        super(context);
        //window_Height = context.getResources().getDisplayMetrics().heightPixels;
        window_Width = context.getResources().getDisplayMetrics().widthPixels-50;

        unit = window_Width/COLUMN_NUM;
        getBackgroundPaint();
    }

    public Background(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i=0; i<COLUMN_NUM; i++){
            for(int j=0; j<COLUMN_NUM; j++){
                canvas.drawRect(i*unit+10, j*unit+10, (i+1)*unit+10, (j+1)*unit+10, paintForBackground);
            }
        }


    }
    private void getBackgroundPaint(){
        paintForBackground = new Paint();
        paintForBackground.setColor(Color.BLACK);
        paintForBackground.setStrokeWidth(10);
        paintForBackground.setStyle(Paint.Style.STROKE);
    }


}
