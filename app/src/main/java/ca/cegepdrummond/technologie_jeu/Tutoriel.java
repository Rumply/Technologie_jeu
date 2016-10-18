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
        start();
    }

    public void start(){

        tutoriel1();
    }



    private boolean tutoriel1() {
        boolean reussi = false;
        nouveauTimer(5);
        timer.start();

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
