package ca.cegepdrummond.technologie_jeu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private CanvasView customCanvas;
    private TextView mTextTouch;
    private TextView mTextCapteur;

    private SensorManager mSensorManager;
    private Sensor mProximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCanvas = (CanvasView) findViewById(R.id.touch_canvas);

        customCanvas.setBackground(this.getDrawable(R.drawable.shape));


        mTextTouch = (TextView) findViewById(R.id.touchState_label);
        mTextCapteur = (TextView) findViewById(R.id.capteurState_label);

        customCanvas.mTextTouch = mTextTouch;


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (event.values[0] == 0) {
                //Action quand un objet est proche.
                mTextCapteur.setText(R.string.msg_cacher);
            } else {
                //Action quand un objet est loin. (Couleur noir peux nuir.)
                mTextCapteur.setText(R.string.msg_nonCacher);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
