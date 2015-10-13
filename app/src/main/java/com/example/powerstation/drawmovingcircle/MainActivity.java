package com.example.powerstation.drawmovingcircle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View {

        public Paint p;

        private static final int RADIUS = 60;

        private int centerX;
        private int centerY;
        private int speedX = 21;
        private int speedY = 13;



        public MyView(Context context) {
            super(context);
            p = new Paint();
            p.setColor(Color.BLACK);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldW, int oldH) {
            centerX = w / 2;
            centerY = h / 2;
        }

        protected void onDraw(Canvas c) {
            int w = getWidth();
            int h = getHeight();
            centerX += speedX;
            centerY += speedY;
            int rightLimit = w - RADIUS;
            int bottomLimit = h - RADIUS;

            if (centerX >= rightLimit) {
                centerX = rightLimit;
                speedX *= -1;
            }
            if (centerX <= RADIUS) {
                centerX = RADIUS;
                speedX *= -1;
            }
            if (centerY >= bottomLimit) {
                centerY = bottomLimit;
                speedY *= -1;
            }
            if (centerY <= RADIUS) {
                centerY = RADIUS;
                speedY *= -1;
            }

            c.drawCircle(centerX, centerY, RADIUS, p);
            postInvalidateDelayed(5);
        }
    }
}
