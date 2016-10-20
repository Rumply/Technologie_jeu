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
    protected TextView mTextJean;
    protected TextView mTextTouch;
    protected TextView mTextCapteur;

    protected SensorManager mSensorManager;
    protected Sensor mProximity;

    protected CountDownTimer timer;
    protected boolean is_timerFini;
    protected boolean joueur_a_fait_erreur;
    protected Capteur capteurs;

    protected Jean jeu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        customCanvas = (CanvasView) findViewById(R.id.touch_canvas);

        customCanvas.setBackground(this.getDrawable(R.drawable.shape));

        mTextTimer = (TextView) findViewById(R.id.countDown_label);
        mTextJean = (TextView) findViewById(R.id.succes_label);
        mTextTouch = (TextView) findViewById(R.id.touchState_label);
        mTextCapteur = (TextView) findViewById(R.id.capteurState_label);

        customCanvas.mTextTouch = mTextTouch;


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        is_timerFini = true;
        joueur_a_fait_erreur = true;

        jeu = new Jean();
        capteurs = Capteur.getInstance();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (event.values[0] == 0){
                capteurs.setIs_capteur_cacher(true);
            }else{
                capteurs.setIs_capteur_cacher(false);
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
