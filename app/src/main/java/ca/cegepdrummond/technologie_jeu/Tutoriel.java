package ca.cegepdrummond.technologie_jeu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

/**
 * Created by Rumpl_000 on 2016-10-14.
 */

public class Tutoriel extends JeuActivity{

    private int countTutoFini;
    private boolean tutoCommencer = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        countTutoFini = 0;

        mTextTouch.setText(R.string.msg_debut_tuto);
        start();
    }


    /*@Override
    public void onSensorChanged(SensorEvent event) {
        super.onSensorChanged(event);
        if (!tutoCommencer){
            tutoCommencer = true;
            start();
        }

    }*/

    public void start(){

        tutoriel1();
    }



    private boolean tutoriel1() {
        final boolean[] reussis = {false, false, false};
        boolean reussi = false;
        mTextCapteur.setText(R.string.jean_dit_capteur_true);
        nouveauTimer(5);
        timer.start();

        /*TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                while(!is_timerFini){
                    reussis[0] = is_capteur_cacher;
                    reussis[1] = is_bouton_toucher;
                };
            }
        };*/

        //timerTask.run();



        if (reussis[0] & !reussis[1]){
            reussi = true;
            mTextCapteur.setText("Bravo");
        }else{
            mTextCapteur.setText("Nop");
        }

        return reussi;
    }

    private boolean tutoriel2(){
        boolean reussi = false;

        return reussi;
    }

    private boolean tutoriel3(){
        boolean reussi = false;

        nouveauTimer(5);
        timer.start();
        return reussi;
    }

    private boolean tutoriel4(){
        boolean reussi = false;

        return reussi;
    }

    private boolean tutoriel5(){
        boolean reussi = false;

        return reussi;
    }



}
