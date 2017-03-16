package in.thegeekybaniya.reactiontester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";


    RelativeLayout canvas;
    Random rand;
    RelativeLayout.LayoutParams lp;

    long startTime, endTime;

    ImageButton ball;
    int i = 1;


    double result = 0;

    TextView resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        canvas = (RelativeLayout) findViewById(R.id.canvas);

        ball = (ImageButton) findViewById(R.id.button);
        rand = new Random();
        resp = (TextView) findViewById(R.id.resp);

        lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ball.setVisibility(View.GONE);

                endTime = System.currentTimeMillis();
                ++i;

                double r = (double) (endTime - startTime) / (double) 1000;

                result += r;

                resp.setText(String.valueOf(r) + "s");

                Log.d(TAG, "onClick: ");

                appearAfterDelay();


                if (i == 10) {

                    Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                    i.putExtra("sum", result);
                    startActivity(i);
                    finish();


                }


            }
        });


        canvas.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                canvas.getViewTreeObserver().removeOnGlobalLayoutListener(this);


                makeShapeAppear();


            }
        });


    }

    @Override
    public void onBackPressed() {


    }

    void makeShapeAppear() {

        lp.setMargins(rand.nextInt(canvas.getWidth() - 100
        ), rand.nextInt(canvas.getHeight() - 100), 0, 0);

        ball.setLayoutParams(lp);

        ball.setVisibility(View.VISIBLE);

        startTime = System.currentTimeMillis();


    }


    void appearAfterDelay() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        makeShapeAppear();
                    }
                });


            }
        }, (rand.nextInt(5) + 1) * 1000);
    }

}
