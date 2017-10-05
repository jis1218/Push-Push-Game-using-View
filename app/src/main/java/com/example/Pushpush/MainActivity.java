package com.example.Pushpush;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Button btnUp, btnDown, btnRight, btnLeft;
    View.OnClickListener onClickListener;
    FrameLayout frameLayout;
    Setting setting;
    Background background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setProcessOnButton();
        setListener();

    }

    private void initView(){
        btnUp = (Button) findViewById(R.id.btnUp);
        btnDown = (Button) findViewById(R.id.btnDown);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        frameLayout = (FrameLayout) findViewById(R.id.container);
        setting = new Setting(this);
        background = new Background(this);
        frameLayout.addView(background);
    }

    private void setListener(){
        btnUp.setOnClickListener(onClickListener);
        btnLeft.setOnClickListener(onClickListener);
        btnRight.setOnClickListener(onClickListener);
        btnDown.setOnClickListener(onClickListener);
    }

    private void setProcessOnButton(){

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch(view.getId()){
                    case R.id.btnUp:
                        background.player.moveUp();
                        background.invalidate();
                        break;
                    case R.id.btnDown:
                        background.player.moveDown();
                        background.invalidate();
                        break;
                    case R.id.btnLeft:
                        background.player.moveLeft();
                        background.invalidate();
                        break;
                    case R.id.btnRight:
                        background.player.moveRight();
                        background.invalidate();
                        break;
                }

            }
        };
    }



}
