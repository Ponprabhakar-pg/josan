package com.example.ex_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_main);
        Paint paint = new Paint();
        Path path = new Path();
        TextView t= (TextView) findViewById(R.id.textView);
        Button b1= (Button) findViewById(R.id.button1);
        Button b2= (Button) findViewById(R.id.button2);
        Button b3= (Button) findViewById(R.id.button3);
        Button b4= (Button) findViewById(R.id.button4);

        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        //Setting the Bitmap as background for the ImageView
        ImageView i = (ImageView) findViewById(R.id.imageView);
        i.setBackgroundDrawable(new BitmapDrawable(bg));
        //Creating the Canvas Object
        Canvas canvas = new Canvas(bg);
        //Creating the Paint Object and set its color & TextSize

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("Circle");
                t.setTextSize(30);
                t.setTextColor(Color.RED);
                paint.setColor(Color.WHITE);
                canvas.drawRect(50, 200, 650, 1150, paint);
                paint.setColor(Color.RED);
                canvas.drawCircle(200, 350, 150, paint);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("Rectangle");
                t.setTextSize(30);
                t.setTextColor(Color.BLUE);
                paint.setColor(Color.WHITE);
                canvas.drawRect(50, 50, 850, 1150, paint);
                paint.setColor(Color.BLUE);
                canvas.drawRect(50, 200, 350, 1150, paint);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("Triangle");
                t.setTextSize(30);
                t.setTextColor(Color.GREEN);
                paint.setColor(Color.WHITE);
                canvas.drawRect(50, 200, 650, 1150, paint);
                paint.setColor(Color.GREEN);
                Point a = new Point(450, 150);
                Point b = new Point(450, 400);
                Point c = new Point(750, 150);

                path.setFillType(Path.FillType.EVEN_ODD);

                path.lineTo(a.x, a.y);
                path.lineTo(b.x, b.y);
                path.lineTo(c.x, c.y);
                path.lineTo(a.x, a.y);
                path.close();

                canvas.drawPath(path, paint);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("Line");
                t.setTextSize(30);
                t.setTextColor(Color.BLACK);
                paint.setColor(Color.WHITE);
                canvas.drawRect(50, 200, 650, 1150, paint);
                paint.setColor(Color.BLACK);
                canvas.drawLine(200, 200, 200, 850, paint);
            }
        });
    }
}