package com.example.Pushpush;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by 정인섭 on 2017-10-05.
 */

public class Player {
    //플레이어의 초기 위치
    int x, y;
    Setting setting;
    Paint paint;
    Board boardObject;

    public Player(Context context) {
        setting = new Setting(context);
        paint = new Paint();
        paint.setColor(Color.RED);
        boardObject = new Board(context);
        x = 6;
        y = 9;
    }

    protected void drawPlayer(Canvas canvas){
        canvas.drawRect(x*setting.cell_width, y*setting.cell_width, (x+1)*setting.cell_width, (y+1)*setting.cell_width, paint);
    }

    protected boolean checkCollisionTarget(){

        if(boardObject.board[y][x]==2 || boardObject.board[y][x]==5){
            return true;
        }
        return false;
    }
    protected boolean checkCollisionBlack(){

        if(boardObject.board[y][x]==9){
            return true;
        }
        return false;
    }

    protected void moveUp(){
        y = y-1;
        if(checkCollisionTarget()){
            if(boardObject.board[y-1][x]!=9 && boardObject.board[y-1][x]!=2 && boardObject.board[y-1][x]!=5) {
                boardObject.board[y][x] = boardObject.board[y][x]-2;
                boardObject.board[y - 1][x] = boardObject.board[y-1][x]+2;

            }else{
                y = y+1;
            }
        }
        if(checkCollisionBlack()){
            y = y+1;
        }
    }

    protected void moveDown(){
        y = y+1;
        if(checkCollisionTarget()){
            if(boardObject.board[y+1][x]!=9 && boardObject.board[y+1][x]!=2 && boardObject.board[y+1][x]!=5) {
                boardObject.board[y][x] = boardObject.board[y][x]-2;
                boardObject.board[y + 1][x] = boardObject.board[y+1][x]+2;

            }else{
                y = y-1;
            }
        }
        if(checkCollisionBlack()){
            y = y-1;
        }
    }

    protected void moveLeft(){
        x = x-1;
        if(checkCollisionTarget()){
            if(boardObject.board[y][x-1]!=9 && boardObject.board[y][x-1]!=2 && boardObject.board[y][x-1]!=5) {
                boardObject.board[y][x] = boardObject.board[y][x]-2;
                boardObject.board[y][x-1] = boardObject.board[y][x-1]+2;

            }else{
                x = x+1;
            }
        }
        if(checkCollisionBlack()){
            x = x+1;
        }
    }

    protected void moveRight(){
        x = x+1;
        if(checkCollisionTarget()){
            if(boardObject.board[y][x+1]!=9 && boardObject.board[y][x+1]!=2 && boardObject.board[y][x+1]!=5) {
                boardObject.board[y][x] = boardObject.board[y][x]-2;
                boardObject.board[y][x+1] = boardObject.board[y][x+1]+2;

            }else{
                x = x-1;
            }
        }
        if(checkCollisionBlack()){
            x = x-1;
        }
    }
}
