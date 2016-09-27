package ca.cegepdrummond.technologie_jeu;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity {

    private CanvasView customCanvas;
    private TextView mTextView;
    private TextToSpeech tts; // Déclaration de la variable TextToSpeech


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


        mTextView = (TextView) findViewById(R.id.touchState_label);

        customCanvas.mTextView = mTextView;

        String infoToSpeak = "";

        infoToSpeak = "Salut tout le monde. C'est moi la voix virtuel du jeu.";

        tts.speak(infoToSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
}
