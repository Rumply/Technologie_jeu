package ca.cegepdrummond.technologie_jeu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class CanvasView extends View {

    public TextView mTextView;

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

        mTextView = (TextView) findViewById(R.id.touchState_label);
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
        mTextView.setText("Hold");
    }

    // when ACTION_MOVE move touch according to the x,y values
    private void moveTouch(float x, float y) {

    }

    public void clearCanvas() {
        mEraseAll = true;
        hold = false;
        invalidate();
    }

    // when ACTION_UP stop touch
    private void upTouch() {
        hold = false;
        mTextView.setText("not Hold");
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