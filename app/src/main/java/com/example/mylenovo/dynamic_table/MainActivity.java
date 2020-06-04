package com.example.mylenovo.dynamic_table;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TableLayout tableLayout;
    TextView label_hello;
    TextView label_android;
    EditText editText;
    Button button_add, button_color;
    String[] colors= new  String[100];
    int length=0;
    String color_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableLayout = (TableLayout)findViewById(R.id.table_layout);
        button_add = findViewById(R.id.add_color);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                View view = getLayoutInflater().inflate(R.layout.input_color, null);
                builder.setView(view);
                builder.setCancelable(true);

                editText = (EditText)view.findViewById(R.id.color_name);
                button_color = (Button)view.findViewById(R.id.add_clr);

                final AlertDialog alertDialog = builder.create();

                button_color.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        color_name=editText.getText().toString();
                        colors[length]=color_name;
                        length++;
                        alertDialog.dismiss();
                        show_colors();
                    }
                });
                alertDialog.show();
            }
        });


    }

    private void show_colors() {
            TableRow tableRow = new TableRow(this);
            tableRow.setPadding(0,0, 5, 5);
            TableRow.LayoutParams params=new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(params);

            TextView text = new TextView(this);
            text.setText(colors[length-1]);
            text.setGravity(Gravity.CENTER);
            text.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            text.setPadding(30, 30, 30, 30);
            text.setTextSize(20);

            tableRow.addView(text);
            tableLayout.addView(tableRow);

    }
}
