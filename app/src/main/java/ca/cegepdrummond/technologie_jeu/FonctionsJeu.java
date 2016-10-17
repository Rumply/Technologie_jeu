package ca.cegepdrummond.technologie_jeu;

import java.util.Random;

/**
 * Created by Steve on 4 oct..
 */

public class FonctionsJeu {

    private boolean capteurActif;
    private boolean touchScreenActif;


    protected void FonctionsJeu() {
        capteurActif = false;
        touchScreenActif = false;
    }

    private boolean randomBool() {
        Random r = new Random();
        boolean bool = r.nextBoolean();
        return bool;
    }

    public void nouvelleCommande() {
        capteurActif = randomBool();
        touchScreenActif = randomBool();
    }
}
