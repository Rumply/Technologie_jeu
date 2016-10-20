package ca.cegepdrummond.technologie_jeu;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by Guillaume on 2016-10-18.
 */

public class DecompteTimer extends CountDownTimer {

    private int secondsUntilFinished;
    private TextView mTextView_countDown;

    private boolean is_visible;
    private boolean is_timerFini;

    private Jean mjeu;
    private Capteur capteurs;

    public DecompteTimer(int seconde, boolean is_visible, TextView coundDown, Jean jeu) {
        super(seconde*1000, 1000);
        this.is_visible = is_visible;
        mTextView_countDown = coundDown;
        capteurs = Capteur.getInstance();
        mjeu = jeu;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        int secondsTemp = Math.round(millisUntilFinished / 1000);
        if (secondsUntilFinished != secondsTemp){
            secondsUntilFinished = secondsTemp;
            if (is_visible){
                set_Time(secondsUntilFinished);
            }
        }
    }

    @Override
    public void onFinish() {
        mTextView_countDown.setText("0");
        is_timerFini = true;
        verification();
    }

    private void set_Time(long time){
        if (is_visible)
            mTextView_countDown.setText(String.valueOf(time));
    }

    private void verification() {
        if (mjeu.get_jeanCacheCapteur() == capteurs.is_capteur_cacher()){
            if (mjeu.get_jeanToucheBouton() == capteurs.is_bouton_toucher()){
                get_mTextTimer().setText("Bravo");
            }
        }
    }

    public boolean is_visible() {
        return is_visible;
    }

    public void setIs_visible(boolean is_visible) {
        this.is_visible = is_visible;
    }

    public boolean is_timerFini() {
        return is_timerFini;
    }

    public void setIs_timerFini(boolean is_timerFini) {
        this.is_timerFini = is_timerFini;
    }

    public TextView get_mTextTimer() {
        return mTextView_countDown;
    }

    public void set_mTextTimer(TextView mTextTimer) {
        this.mTextView_countDown = mTextTimer;
    }

}
