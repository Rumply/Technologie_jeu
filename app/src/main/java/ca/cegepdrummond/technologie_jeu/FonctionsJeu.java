package ca.cegepdrummond.technologie_jeu;

import java.util.Random;

/**
 * Created by Steve on 4 oct..
 */

public class FonctionsJeu {

    private Random random;

    private boolean jeanCacheCapteur;
    private boolean jeanToucheBouton;


    protected void FonctionsJeu() {
        jeanPense();
    }



    private boolean booleanRandom(){
        return random.nextBoolean();
    }

    public void jeanPense() {
        this.jeanCacheCapteur = booleanRandom();
        this.jeanToucheBouton = booleanRandom();
    }

    public int actionCapteur(){
        int numRessource = -1;
        if (jeanCacheCapteur){
            numRessource = R.string.jean_dit_capteur_true;
        }else{
            numRessource = R.string.jean_dit_capteur_false;
        }

        return  numRessource;
    }

    public int actionBouton(){
        int numRessource = -1;

        if (jeanToucheBouton){
            numRessource = R.string.jean_dit_touch_true;
        }else{
            numRessource = R.string.jean_dit_touch_false;
        }

        return  numRessource;
    }

    public boolean get_jeanCacheCapteur(){
        return jeanCacheCapteur;
    }

    public void set_jeanCacheCapteur(boolean bool){
        jeanCacheCapteur = bool;
    }

    public boolean get_jeanToucheBouton(){
        return jeanToucheBouton;
    }

    public void set_jeanToucheBouton(boolean bool){
        jeanToucheBouton = bool;
    }

}
