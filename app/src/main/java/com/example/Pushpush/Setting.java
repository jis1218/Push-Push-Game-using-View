package com.example.Pushpush;

import android.content.Context;

/**
 * Created by 정인섭 on 2017-10-05.
 */

public class Setting {

    int board_width;
    int cell_width;
    int board_row;

    int first_x;
    int first_y;

    public Setting(Context context) {
        board_width = context.getResources().getDisplayMetrics().widthPixels-20;
        board_row = 12;
        cell_width = board_width/board_row;
    }





}
