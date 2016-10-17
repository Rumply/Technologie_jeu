package ca.cegepdrummond.technologie_jeu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btn_start;
    private Button btn_tutoriel;
    private Button btn_a_propos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button) findViewById(R.id.button_jouer);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnJeu.class);
                startActivity(intent);
            }
        });

        btn_tutoriel = (Button) findViewById(R.id.button_tutoriel);
        btn_tutoriel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tutoriel.class);
                startActivity(intent);
            }
        });

        btn_a_propos = (Button) findViewById(R.id.button_a_propos);
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
