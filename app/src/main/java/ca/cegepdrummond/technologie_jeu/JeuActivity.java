package ca.cegepdrummond.technologie_jeu;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by Rumpl_000 on 2016-10-14.
 */

public class JeuActivity  extends Activity implements SensorEventListener {

    protected CanvasView customCanvas;
    protected TextView mTextTimer;
    protected TextView mTextTouch;
    protected TextView mTextCapteur;

    protected SensorManager mSensorManager;
    protected Sensor mProximity;

    protected CountDownTimer timer;
    protected boolean is_timerFini;

    protected boolean is_capteur_cacher;
    protected boolean is_bouton_toucher;

    protected FonctionsJeu jeu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        customCanvas = (CanvasView) findViewById(R.id.touch_canvas);

        customCanvas.setBackground(this.getDrawable(R.drawable.shape));

        mTextTimer = (TextView) findViewById(R.id.msg_temps_timer_label);
        mTextTouch = (TextView) findViewById(R.id.touchState_label);
        mTextCapteur = (TextView) findViewById(R.id.capteurState_label);

        customCanvas.mTextTouch = mTextTouch;


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        is_capteur_cacher = false;
        is_bouton_toucher = false;
        is_timerFini = true;

        jeu = new FonctionsJeu();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            is_capteur_cacher = (event.values[0] == 0);
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

    protected boolean nouveauTimer(int temps){

        is_timerFini = false;

        timer = new CountDownTimer(temps*1000, 1000) {

            private int secondsUntilFinished = -1;

            @Override
            public void onTick(long millisUntilFinished) {
                int secondsTemp = Math.round(millisUntilFinished / 1000);
                if (secondsUntilFinished != secondsTemp){
                    secondsUntilFinished = secondsTemp;
                    mTextTimer.setText(R.string.msg_temps_timer);
                    mTextTimer.append(String.valueOf(secondsUntilFinished));
                }

            }

            @Override
            public void onFinish() {
                mTextTimer.setText(R.string.msg_temps_timer);
                mTextTimer.append("0");
                is_timerFini = true;
            }
        };

        return true;
    }
}
