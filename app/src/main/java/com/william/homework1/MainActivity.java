package com.william.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
//William's project
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageview;

        Button draw = findViewById(R.id.button);

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imgView = findViewById(R.id.imageView);
                Bitmap orig = ((BitmapDrawable) imgView.getDrawable()).getBitmap();
                Mat img = new Mat(orig.getHeight(), orig.getWidth(), CvType.CV_8UC4);
                Utils.bitmapToMat(orig, img);
                org.opencv.core.Point firstPoint= new org.opencv.core.Point (50,  50);
                org.opencv.core.Point secondPoint = new org.opencv.core.Point(50, 150);

                Scalar LineColor = new Scalar(255, 0, 0, 255);
                int linewidth = 3;

                Imgproc.line(img, firstPoint, secondPoint, LineColor, linewidth);


            }
        });
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imgView = findViewById(R.id.imageView);
                Bitmap orig = ((BitmapDrawable) imgView.getDrawable()).getBitmap();
                Mat img = new Mat(orig.getHeight(), orig.getWidth(), CvType.CV_8UC4);
                Utils.bitmapToMat(orig, img);
                org.opencv.core.Point firstPoint= new org.opencv.core.Point (50,  50);
                org.opencv.core.Point secondPoint = new org.opencv.core.Point(50, 150);
                org.opencv.core.Point thirdPoint = new org.opencv.core.Point(150, 150);
                org.opencv.core.Point forthPoint = new org.opencv.core.Point(150, 50);
                Scalar LineColor = new Scalar(255, 0, 0, 255);
                int linewidth = 3;


                Imgproc.line(img, secondPoint, thirdPoint, LineColor, linewidth);


            }
        });
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imgView = findViewById(R.id.imageView);
                Bitmap orig = ((BitmapDrawable) imgView.getDrawable()).getBitmap();
                Mat img = new Mat(orig.getHeight(), orig.getWidth(), CvType.CV_8UC4);
                Utils.bitmapToMat(orig, img);

                org.opencv.core.Point thirdPoint = new org.opencv.core.Point(150, 150);
                org.opencv.core.Point forthPoint = new org.opencv.core.Point(150, 50);
                Scalar LineColor = new Scalar(255, 0, 0, 255);
                int linewidth = 3;


                Imgproc.line(img, thirdPoint, forthPoint, LineColor, linewidth);


            }
        });
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imgView = findViewById(R.id.imageView);
                Bitmap orig = ((BitmapDrawable) imgView.getDrawable()).getBitmap();
                Mat img = new Mat(orig.getHeight(), orig.getWidth(), CvType.CV_8UC4);
                Utils.bitmapToMat(orig, img);
                org.opencv.core.Point firstPoint= new org.opencv.core.Point (50,  50);
                org.opencv.core.Point forthPoint = new org.opencv.core.Point(150, 50);
                Scalar LineColor = new Scalar(255, 0, 0, 255);
                int linewidth = 3;


                Imgproc.line(img, forthPoint, firstPoint, LineColor, linewidth);


            }
        });
    }


}
