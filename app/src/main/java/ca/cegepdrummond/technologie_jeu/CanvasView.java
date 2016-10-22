package ca.cegepdrummond.technologie_jeu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class CanvasView extends View {

    public TextView mTextTouch;

    private Bitmap mBitmap;
    private Canvas mCanvas;
    private boolean mEraseAll;
    private Path mPath;
    Context context;
    private Paint mPaint;
    private float mX, mY;
    private static final float TOLERANCE = 3;
    private Random mRng;

    private Boolean hold;

    public float mBoutonRayon;
    public float center_x;
    public float center_y;

    public Capteur capteurs;


    public CanvasView(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;
        mEraseAll = false;
        mRng = new Random();

        // we set a new Path
        mPath = new Path();

        // and we set a new Paint with the desired attributes
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(12f);

        mTextTouch = (TextView) findViewById(R.id.touchState_label);
        capteurs = Capteur.getInstance();
    }

    // override onSizeChanged
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // your Canvas will draw onto the defined Bitmap
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        invalidate();
    }



    // when ACTION_DOWN start touch according to the x,y values
    private void startTouch(float x, float y) {
        hold = true;
        capteurs.setIs_bouton_toucher(true);

    }

    private float hyp(float a, float b){
        float c = (float) Math.hypot(a,b);
        return c;
    }

    // when ACTION_MOVE move touch according to the x,y values
    private void moveTouch(float x, float y) {
        mBoutonRayon = this.getMeasuredHeight()/2;
        center_x = this.getMeasuredWidth()/2;
        center_y = this.getMeasuredHeight()/2;


        float distance = mBoutonRayon - hyp(center_x - x, center_y - y);

        if (distance < 1){
            capteurs.setIs_bouton_toucher(false);
        } else if (distance > 0){
            capteurs.setIs_bouton_toucher(true);
        }


    }

    //
    public String str(float valeur){
        return String.valueOf((int) valeur);
    }

    public void clearCanvas() {
        mEraseAll = true;
        hold = false;
        invalidate();
    }

    // when ACTION_UP stop touch
    private void upTouch() {
        hold = false;
        capteurs.setIs_bouton_toucher(false);
        mPath.reset();
    }

    //override the onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                moveTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                upTouch();
                invalidate();
                break;
        }
        return true;
    }

    public boolean is_getting_touched(){
        return hold;
    }
}