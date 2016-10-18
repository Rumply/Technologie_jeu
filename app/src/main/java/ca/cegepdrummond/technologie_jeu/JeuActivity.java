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
    protected boolean joueur_a_fait_erreur;

    protected boolean is_capteur_cacher;
    protected boolean is_bouton_toucher;

    protected FonctionsJeu jeu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        customCanvas = (CanvasView) findViewById(R.id.touch_canvas);

        customCanvas.setBackground(this.getDrawable(R.drawable.shape));

        mTextTimer = (TextView) findViewById(R.id.countDown_label);
        mTextTouch = (TextView) findViewById(R.id.touchState_label);
        mTextCapteur = (TextView) findViewById(R.id.capteurState_label);

        customCanvas.mTextTouch = mTextTouch;


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        is_capteur_cacher = false;
        is_bouton_toucher = false;
        is_timerFini = true;
        joueur_a_fait_erreur = true;

        jeu = new FonctionsJeu();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (event.values[0] == 0){
                is_capteur_cacher = true;
            }else{
                is_capteur_cacher = false;
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

    protected boolean nouveauTimer(int temps){

        is_timerFini = false;
        mTextTimer.setText(R.string.msg_temps_timer);
        mTextTimer.append(String.valueOf(temps));
        timer = new CountDownTimer(temps*1000, 1000) {

            private int secondsUntilFinished = -1;

            @Override
            public void onTick(long millisUntilFinished) {
                int secondsTemp = Math.round(millisUntilFinished / 1000);
                if (secondsUntilFinished != secondsTemp){
                    secondsUntilFinished = secondsTemp;
                    mTextTimer.setText(String.valueOf(secondsUntilFinished));
                }
            }

            @Override
            public void onFinish() {
                mTextTimer.setText("0");
                is_timerFini = true;
                verification();
            }
        };

        return true;
    }

    protected void verification() {
        if (jeu.get_jeanCacheCapteur() == is_capteur_cacher){
            if (jeu.get_jeanToucheBouton() == is_bouton_toucher){
                mTextCapteur.setText("Bravo");
            }
        }else{
            if (!is_timerFini){
                joueur_a_fait_erreur = false;
            }
        }
    }
}
