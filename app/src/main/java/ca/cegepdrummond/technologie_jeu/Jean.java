package ca.cegepdrummond.technologie_jeu;

import java.util.Random;

/**
 * Created by Steve on 4 oct..
 */

public class Jean {

    private Random random;

    private boolean jeanCacheCapteur;
    private boolean jeanToucheBouton;


    public Jean() {
        random = new Random();
        jeanPense();
    }

    private boolean booleanRandom(){
        return random.nextBoolean();
    }

    public void jeanPense() {
        this.jeanCacheCapteur = booleanRandom();
        this.jeanToucheBouton = booleanRandom();
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
