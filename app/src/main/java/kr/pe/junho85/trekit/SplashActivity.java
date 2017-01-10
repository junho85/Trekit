package kr.pe.junho85.trekit;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";
    private ImageView mMapImageView;
    private TextView mTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        mMapImageView = (ImageView) findViewById(R.id.map_image_view);
        mTitleTextView = (TextView) findViewById(R.id.title_text_view);

        // set title
        mTitleTextView.setTypeface(Typeface.createFromAsset(getAssets(), "font/Montserrat-Medium.otf"));
        mTitleTextView.setText("TREKIT");
        mTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 38.7f);
        mTitleTextView.setTextColor(Color.WHITE);

        // set bottom image
        Drawable drawable = loadDrawableFromAssets("img/map.png");
        mMapImageView.setImageDrawable(drawable);

//        Bitmap bitmap = loadBitmapFromAssets("img/map.png");
//        mMapImageView.setImageBitmap(bitmap);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        mMapImageView.setLayoutParams(layoutParams);
        mMapImageView.setScaleType(ImageView.ScaleType.FIT_END);
    }

    public Bitmap loadBitmapFromAssets(String path) {
        AssetManager assetManager = getAssets();

        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(path);
            return BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ignored) {
                }
            }
        }
        return null;
    }

    public Drawable loadDrawableFromAssets(String path) {
        AssetManager assetManager = getAssets();

        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(path);
            return Drawable.createFromStream(inputStream, null);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ignored) {
                }
            }
        }
        return null;
    }
}
