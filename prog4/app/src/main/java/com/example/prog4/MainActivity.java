package com.example.prog4;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Boolean running = false;
    Button chnge;
    int i = 1;
    int[] images = new int[] {
            R.drawable.wallpaper1, R.drawable.wallpaper2,
            R.drawable.wallpaper3, R.drawable.wallpaper4
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chnge = (Button) findViewById(R.id.chng);
        chnge.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (!running) {
            new Timer().schedule(new MyTimer(), 0, 3000);
            running = false;
        }
    }
    class MyTimer extends TimerTask {
        public void run() {
            try {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                Random rand = new Random();
                i = rand.nextInt(6);
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), images[i]));
            } catch (Exception e) {
            }
        }
    }
}