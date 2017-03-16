package in.thegeekybaniya.reactiontester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent i = getIntent();

        i.getExtras();

        double res=i.getDoubleExtra("sum",0);

        res/=10;


        tv= (TextView) findViewById(R.id.textView);

        tv.setText(String.valueOf(res)+ "s");


    }
}
