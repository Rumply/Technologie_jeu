package ca.cegepdrummond.technologie_jeu;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private CanvasView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCanvas = (CanvasView) findViewById(R.id.touch_canvas);
    }
}
