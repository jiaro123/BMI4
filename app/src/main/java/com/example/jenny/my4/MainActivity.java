package com.example.jenny.my4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText etheight;
    private EditText etweight;
    private RadioButton rb1;
    private RadioButton rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.compute);
        b1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                etheight = findViewById(R.id.etheight);
                etweight = findViewById(R.id.etweight);
                Double h= Double.parseDouble(etheight.getText().toString());
                Double w= Double.parseDouble(etweight.getText().toString());
                rb1 = findViewById(R.id.boy);
                String sex=rb1.isChecked() ? "M" : "W";
                Log.i("toy","h="+h+",w="+w+",sex="+sex);
                Bundle bundle= new Bundle();
                bundle.putDouble("height",h);
                bundle.putDouble("weight",w);
                bundle.putString("Sex",sex);
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch (resultCode)
        {
            case RESULT_OK:
                Bundle bundle = data.getExtras();
                String Sex = bundle.getString("Sex");
                double height = bundle.getDouble("height");
                double weight = bundle.getDouble("weight");
                etheight.setText("" + height);
                etweight.setText("" + weight);
                if(Sex.equals("M"))
                {
                    rb1.setChecked(true);
                }else
                {
                    rb2.setChecked(true);
                }
                break;
            default:
                break;
        }
    }
}