package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    ArrayList<Button> btnList = new ArrayList<>();
    private int noOfChances=3;
    private int amountWon=0;
    private int amountPaid=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView instructionsTV=findViewById(R.id.instructionsTV);
        instructionsTV.setText("Instructions to play: \n - pay the money and get 3 chances" +
                "\n - press the button to add amount to account \n - press reset button to restart ");

        map.put(1, 1);
        map.put(2, 0);
        map.put(3, 2);
        map.put(4, 1);
        map.put(5, 9);
        map.put(6, 0);
        map.put(7, 0);
        map.put(8, 1);
        map.put(9, 0);
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);
        Button btn6 = findViewById(R.id.button6);
        Button btn7 = findViewById(R.id.button7);
        Button btn8 = findViewById(R.id.button8);
        Button btn9 = findViewById(R.id.button9);

        btnList.add(btn1);
        btnList.add(btn2);
        btnList.add(btn3);
        btnList.add(btn4);
        btnList.add(btn5);
        btnList.add(btn6);
        btnList.add(btn7);
        btnList.add(btn8);
        btnList.add(btn9);
    }


/*
This method will be executed on click of the grid buttons.
These grid buttons won't work if number of chances are less than or equal to zero
 */
    public void onClick(View v){
       ImageButton resetBTN=findViewById(R.id.resetBTN);
        if(noOfChances>0) {
            TextView chancesTV=findViewById(R.id.chancesTV);
            TextView amountWonTV=findViewById(R.id.amountWonTV);

            resetBTN.setClickable(false);


            String s = getResources().getResourceEntryName(v.getId());
            int k = Integer.parseInt(s.substring(s.length() - 1));
            for (int i = 1; i <= btnList.size(); i++) {
                if (i == k) {
                    btnList.get(i - 1).setText((map.get(i)).toString());
                    btnList.get(i - 1).setClickable(false);
                    noOfChances=noOfChances-1;
                    chancesTV.setText("Chances Left "+noOfChances);
                    amountWon=amountWon+map.get(i);
                    amountWonTV.setText("Amount won: "+amountWon);
                    if(noOfChances==0){
                    resetBTN.setClickable(true);
                    }
                }
            }


        }
        else{
           resetBTN.setClickable(true);
        }

        }
        /*
        Below method will be executed by clicking on the reset button.
        This method defaults all the values.
         */
        public void reset(View v) {
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);
        Button btn6 = findViewById(R.id.button6);
        Button btn7 = findViewById(R.id.button7);
        Button btn8 = findViewById(R.id.button8);
        Button btn9 = findViewById(R.id.button9);
        TextView chancesTV=findViewById(R.id.chancesTV);
        TextView amountWonTV=findViewById(R.id.amountWonTV);
        TextView paidTV=findViewById(R.id.paidTV);
        btn1.setText("*");
        btn2.setText("*");
        btn3.setText("*");
        btn4.setText("*");
        btn5.setText("*");
        btn6.setText("*");
        btn7.setText("*");
        btn8.setText("*");
        btn9.setText("*");
        btn1.setClickable(true);
        btn2.setClickable(true);
        btn3.setClickable(true);
        btn4.setClickable(true);
        btn5.setClickable(true);
        btn6.setClickable(true);
        btn7.setClickable(true);
        btn8.setClickable(true);
        btn9.setClickable(true);

        noOfChances=3;
        chancesTV.setText("Chances Left "+noOfChances);
        amountWon=0;
        amountWonTV.setText("Amount won: "+amountWon);
        amountPaid=5;
        paidTV.setText("Paid : "+amountPaid);


    }

    /*
    By clicking on the "Extra chance for 2 " button below method will be executed.
    And increases the number of chances by each click
     */
    public void getExtraChance(View v){
        TextView paidTV=findViewById(R.id.paidTV);
        TextView chancesTV=findViewById(R.id.chancesTV);
        noOfChances=noOfChances+1;
        amountPaid=amountPaid+2;
        chancesTV.setText("Chances Left "+noOfChances);
        paidTV.setText("Paid : "+amountPaid);


    }


}