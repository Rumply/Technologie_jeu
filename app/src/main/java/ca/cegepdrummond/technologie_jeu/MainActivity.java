package ca.cegepdrummond.technologie_jeu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity implements SensorEventListener {

    private CanvasView customCanvas;
    private TextView mTextView;
    private TextToSpeech tts; // Déclaration de la variable TextToSpeech

    private SensorManager mSensorManager;
    private Sensor mProximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    int result = tts.setLanguage(Locale.getDefault());
                }
            }
        });

        customCanvas = (CanvasView) findViewById(R.id.touch_canvas);

        customCanvas.setBackground(this.getDrawable(R.drawable.shape));


        mTextView = (TextView) findViewById(R.id.touchState_label);

        customCanvas.mTextView = mTextView;

        String infoToSpeak = "";

        infoToSpeak = "Salut tout le monde. C'est moi la voix virtuel du jeu.";

        tts.speak(infoToSpeak, TextToSpeech.QUEUE_FLUSH, null);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (event.values[0] == 0) {
                //Action quand un objet est proche.
                mTextView.setText("Capteur caché");
            } else {
                //Action quand un objet est loin. (Couleur noir peux nuir.)
                mTextView.setText("Capteur non caché");
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
