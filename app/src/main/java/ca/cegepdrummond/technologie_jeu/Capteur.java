package ca.cegepdrummond.technologie_jeu;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by Guillaume on 2016-10-19.
 */

public class Capteur {

    private static Capteur capteur = new Capteur();

    private boolean is_capteur_cacher;
    private boolean is_bouton_toucher;

    private Capteur() {
        setIs_bouton_toucher(false);
        setIs_capteur_cacher(false);
    }

    public static Capteur getInstance(){
        return capteur;
    }

    public boolean is_capteur_cacher() {
        return is_capteur_cacher;
    }

    public void setIs_capteur_cacher(boolean is_capteur_cacher) {
        this.is_capteur_cacher = is_capteur_cacher;
    }

    public boolean is_bouton_toucher() {
        return is_bouton_toucher;
    }

    public void setIs_bouton_toucher(boolean is_bouton_toucher) {
        this.is_bouton_toucher = is_bouton_toucher;
    }

}
