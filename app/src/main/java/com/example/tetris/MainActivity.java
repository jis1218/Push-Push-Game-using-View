package com.example.tetris;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout = null;
    Button btnUp, btnDown, btnLeft, btnRight;
    View.OnClickListener onClickListener;
    Block block;
    int top;
    int left;
    int vertical_count = 0;
    int horizontal_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setBackground();
        setBlock();
        setProcessOnButton();
        setListener();

    }

    private void initView(){
        frameLayout = (FrameLayout) findViewById(R.id.container);
        btnUp = (Button) findViewById(R.id.btnUp);
        btnDown = (Button) findViewById(R.id.btnDown);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        top = 10;
        left = 10;
    }
    private void setBackground(){
        Background background = new Background(this);
        frameLayout.addView(background);
    }
    private void setBlock(){
        block = new Block(this, top, left);
        frameLayout.addView(block);
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
                        top = top-70;
                        if(top<=10){
                            top = 10;
                        }
                        break;
                    case R.id.btnDown:
                        top = top+70;
                        if(top>=640){
                            top = 640;
                        }
                        break;
                    case R.id.btnLeft:
                        left = left-70;
                        if(left<=10){
                            left = 10;
                        }
                        break;
                    case R.id.btnRight:
                        left = left+70;
                        if(left>=640){
                            left = 640;
                        }
                        break;
                }
                block.left = left;
                block.top = top;
                //frameLayout.addView(block);
                block.invalidate();

            }
        };
    }



}
