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
import android.widget.TextView;

import org.opencv.android.InstallCallbackInterface;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.w3c.dom.Text;

//William's project

public class MainActivity extends AppCompatActivity {
    private int clickTime = 0;
    LoaderCallbackInterface loaderCallbackInterface = new LoaderCallbackInterface() {
        @Override
        public void onManagerConnected(int status) {

        }

        @Override
        public void onPackageInstall(int operation, InstallCallbackInterface callback) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView text = (TextView)findViewById(R.id.textView);
        if (!OpenCVLoader.initDebug()) {
            boolean success =
                    OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_4_0
                            , this, loaderCallbackInterface
                    );


        }else{
            loaderCallbackInterface.onManagerConnected(LoaderCallbackInterface.SUCCESS);


        }
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
                org.opencv.core.Point thirdPoint = new org.opencv.core.Point(150, 150);
                org.opencv.core.Point forthPoint = new org.opencv.core.Point(150, 50);

                Scalar LineColor = new Scalar(255, 0, 0, 255);
                int linewidth = 3;

                if (clickTime == 0) {
                    Imgproc.line(img, firstPoint, secondPoint, LineColor, linewidth);
                    Bitmap resultBitmap = Bitmap.createBitmap(img.cols(),img.rows(),Bitmap.Config.ARGB_8888);
                    Utils.matToBitmap(img, resultBitmap);

                    imgView.setImageBitmap(resultBitmap);
                    imgView.requestLayout();
                    imgView.getLayoutParams().height += 500;
                    imgView.getLayoutParams().width += 500;
                    clickTime ++;

                }
                else if (clickTime == 1){
                    Imgproc.line(img, thirdPoint, secondPoint, LineColor, linewidth);
                    Bitmap resultBitmap = Bitmap.createBitmap(img.cols(),img.rows(),Bitmap.Config.ARGB_8888);
                    Utils.matToBitmap(img, resultBitmap);

                    imgView.setImageBitmap(resultBitmap);


                    clickTime ++;

                }
                else if (clickTime == 2){
                    Imgproc.line(img, thirdPoint, forthPoint, LineColor, linewidth);
                    Bitmap resultBitmap = Bitmap.createBitmap(img.cols(),img.rows(),Bitmap.Config.ARGB_8888);
                    Utils.matToBitmap(img, resultBitmap);

                    imgView.setImageBitmap(resultBitmap);


                    clickTime ++;

                }
                else if (clickTime == 3){
                    Imgproc.line(img, forthPoint, firstPoint, LineColor, linewidth);
                    Bitmap resultBitmap = Bitmap.createBitmap(img.cols(),img.rows(),Bitmap.Config.ARGB_8888);
                    Utils.matToBitmap(img, resultBitmap);

                    imgView.setImageBitmap(resultBitmap);


                    clickTime ++;

                }



            }
        });






    }


}
