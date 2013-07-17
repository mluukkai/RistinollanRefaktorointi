package refaktoroitu;

public class Pelilogiikka {

    private Pelaaja[] ruudut;
    private int vuoro;
    private boolean tasapeli;
    private Pelaaja voittaja;

    public Pelilogiikka() {
        ruudut = new Pelaaja[9];
    }

    public void siirto(int kohde) {
        ruudut[kohde] = pelaaja();
        vuoro++;
    }

    public Pelaaja pelaaja() {
        return vuoro % 2 == 0 ? Pelaaja.X : Pelaaja.O;
    }

    private void tarkistaVoitto() {

        for (int i = 0; i < 3; i++) {
            if (samatPystyyn(i)) {
                asetaVoittaja(i);
            }
        }

        for (int i = 0; i < 8; i = i + 3) {
            if (samatVaakaan(i)) {
                asetaVoittaja(i);
            }
        }

        if (samatDiagonalilla()) {
            asetaVoittaja(4);
        }

        if (voittaja == null && vuoro == 9) {
            tasapeli = true;
        }
    }

    public boolean loppunut() {
        tarkistaVoitto();

        return tasapeli || voittaja != null;
    }

    public boolean tasapeli() {
        return tasapeli;
    }

    public Pelaaja voittaja() {
        return voittaja;
    }

    private boolean pelaajaRuudussa(int i) {
        return ruudussa(i) != null;
    }

    private void asetaVoittaja(int i) {
        voittaja = ruudussa(i);
    }

    private Pelaaja ruudussa(int i) {
        return ruudut[i];
    }

    private boolean samatPystyyn(int i) {
        if (!pelaajaRuudussa(i)) {
            return false;
        }

        return ruudussa(i) == ruudussa(i + 3) && ruudussa(i) == ruudussa(i + 6);
    }

    private boolean samatVaakaan(int i) {
        if (!pelaajaRuudussa(i)) {
            return false;
        }
        
        return ruudussa(i) == ruudussa(i + 1) && ruudussa(i) == ruudussa(i + 2);
    }

    private boolean samatDiagonalilla() {
        if (!pelaajaRuudussa(4)) {
            return false;
        }

        return (ruudussa(0) == ruudussa(4) && ruudussa(0) == ruudussa(8))
                || (ruudussa(2) == ruudussa(4) && ruudussa(2) == ruudussa(6));
    }
}
