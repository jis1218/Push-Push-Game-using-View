package com.example.Pushpush;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by 정인섭 on 2017-10-05.
 */

public class Background extends View {
    Board board;
    Player player;

    public Background(Context context) {
        super(context);
        board = new Board(context);
        player = new Player(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        board = player.boardObject;
        board.drawBoard(canvas);
        player.drawPlayer(canvas);
    }
}
