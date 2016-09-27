package ca.cegepdrummond.technologie_jeu;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends Activity {

    private CanvasView customCanvas;
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCanvas = (CanvasView) findViewById(R.id.touch_canvas);


        mTextView = (TextView) findViewById(R.id.touchState_label);

        customCanvas.mTextView = mTextView;
    }



}
