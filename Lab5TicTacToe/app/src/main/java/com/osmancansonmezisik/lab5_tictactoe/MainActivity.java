package com.osmancansonmezisik.lab5_tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String PLAYER_1 = "X";
    static final String PLAYER_2 = "O";

    boolean player1Turn = true;

    byte[][] board = new byte[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout tableLayout = findViewById(R.id.board);
        for(int i = 0; i<3;i++ ){
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for(int j = 0; j<3; j++){
                Button button = (Button) row.getChildAt(j);
                button.setOnClickListener(new CellListener(i,j));
            }
        }
    }


    class CellListener implements View.OnClickListener{

        int row,column;

        public CellListener(int row, int column){

            this.row = row;
            this.column = column;
        }

        @Override
        public void onClick(View v) {

            if (!isValidMove(row, column)) {
                Toast.makeText(MainActivity.this,"Cell is already occupied",Toast.LENGTH_LONG).show();
                return;
            }

            if(player1Turn){
                ((Button) v ).setText(PLAYER_1);
                board[row][column] = 1;
            }else{
                ((Button) v ).setText(PLAYER_2);
                board[row][column] = 2;
            }

            if(gameEnded(row,column) == -1){
                player1Turn = !player1Turn;
            } else if (gameEnded(row, column) == 0) {
                Toast.makeText(MainActivity.this,"draw",Toast.LENGTH_LONG).show();

            }else if(gameEnded(row, column) == 1){
                Toast.makeText(MainActivity.this,"p1 won",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this,"p2 won",Toast.LENGTH_LONG).show();

            }

        }
    }

    public boolean isValidMove(int row, int column){

        return (board[row][column] == 0);

        }

    public int gameEnded(int row,int column){
        int symbol = board[row][column];
        boolean win = true;
        for(int i = 0;i<3;i++){
            if(board[i][column] != symbol){
                win = false;
                break;
            }
        }

        if(win){
            return symbol;
        }





        //check columns

        //check rows

        //check diagonals
        return -1;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("player1Turn",player1Turn);
        byte[] boardSingle = new byte[9];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                boardSingle[3*i+j] = board[i][j];
            }
        }

        outState.putByteArray("board",boardSingle);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        player1Turn = savedInstanceState.getBoolean("player1Turn");
        byte[] boardSingle = savedInstanceState.getByteArray("board");
        for(int i = 0; i<9;i++){
            board[i/3][i%3] = boardSingle[i];
        }

        TableLayout tableLayout = findViewById(R.id.board);
        for(int i = 0; i<3;i++ ){
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for(int j = 0; j<3; j++){
                Button button = (Button) row.getChildAt(j);
                if((board[i][j] == 1)){
                    button.setText("X");
                }else if((board[i][j] ==2)){
                    button.setText("O");
                }
            }
        }

    }
}

