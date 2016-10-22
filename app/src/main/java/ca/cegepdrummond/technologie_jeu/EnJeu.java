package ca.cegepdrummond.technologie_jeu;


import android.os.Bundle;

import java.util.Random;

/**
 * Created by Guillaume HG on 2016-10-14.
 */

public class EnJeu extends JeuActivity {

    boolean victoire = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        start();
    }

    public void start(){
        enJeuGo();
        enJeuGo();
    }

    private void enJeuGo() {
        Random r = new Random();
        int numeroQuestion = r.nextInt(2); //Donne un chiffre entre 0 (inclus) et 2 (exclu)

        if (numeroQuestion == 1) {
            jeanDit(true, false);
        } else {
            jeanDit(false, true);
        }

        partirTimer(5, true);
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

    public void partirTimer(int temps, boolean is_visible){
        timer = new DecompteTimer(temps,is_visible,mTextTimer, jeu);
        timer.start();
    }
}
