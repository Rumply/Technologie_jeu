package ca.cegepdrummond.technologie_jeu;

import java.util.Random;

/**
 * Created by Steve on 4 oct..
 */

public class FonctionsJeu {

    public int numeroJeanDit;

    protected void FonctionsJeu() {
        numeroRandom();
    }

    public void numeroRandom() {
        Random r = new Random();
        this.numeroJeanDit = r.nextInt(1); // Gives n such that 0 <= n < 1
    }

    public int quoiDire() {
        if (this.numeroJeanDit == 0) {
            return R.string.jean_dit_toucher_ecran;
        } else {
            return R.string.jean_dit_cacher_capteur;
        }
    }
}
