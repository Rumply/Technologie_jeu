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

interface startFunction
{
    public void start();
}

public class Tutoriel extends JeuActivity implements startFunction{

    private int countTutoFini;
    private DecompteTimer timer;
    private boolean tutoCommencer = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countTutoFini = 0;
        start();
    }

    public void start(){

        tutoriel1();
    }

    public void partirTimer(int temps, boolean is_visible){
        timer = new DecompteTimer(temps,is_visible,mTextTimer, jeu);
        timer.start();
    }

    public void jeanDit(boolean cacherCapteur, boolean toucherEcran){
        if (cacherCapteur){
            jeu.set_jeanCacheCapteur(true);
            mTextCapteur.setText(R.string.jean_dit_capteur_true);
        }else{
            jeu.set_jeanCacheCapteur(false);
            mTextCapteur.setText(R.string.jean_dit_capteur_false);
        }

        if (toucherEcran){
            jeu.set_jeanToucheBouton(true);
            mTextTouch.setText(R.string.jean_dit_touch_true);
        }else {
            jeu.set_jeanToucheBouton(false);
            mTextTouch.setText(R.string.jean_dit_touch_false);
        }
    }

    private void tutoriel1() {
        jeu.set_jeanCacheCapteur(true);
        mTextCapteur.setText(R.string.jean_dit_capteur_true);
        jeu.set_jeanToucheBouton(false);
        mTextTouch.setText(R.string.jean_dit_touch_false);

        tutoriel2();
    }

    private void tutoriel2(){
        jeanDit(false, true);
        partirTimer(5, true);

        tutoriel3();
    }

    private void tutoriel3(){
        jeanDit(true, true);
        partirTimer(5, true);
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
