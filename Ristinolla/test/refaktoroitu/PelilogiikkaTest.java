package refaktoroitu;

import refaktoroitu.Pelaaja;
import refaktoroitu.Pelilogiikka;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelilogiikkaTest {

    Pelilogiikka peli;

    @Before
    public void setUp() {
        peli = new Pelilogiikka();
    }

    @Test
    public void pelaajaXvoittaaPystysuorasti1() {
        peli.siirto(0);
        peli.siirto(1);
        peli.siirto(3);
        peli.siirto(4);
        assertFalse(peli.loppunut());
        peli.siirto(6);
        assertTrue(peli.loppunut());
        assertEquals(Pelaaja.X, peli.voittaja());
    }

    @Test
    public void pelaajaXvoittaaPystysuorasti2() {
        peli.siirto(2);
        peli.siirto(1);
        peli.siirto(5);
        peli.siirto(4);
        assertFalse(peli.loppunut());
        peli.siirto(8);
        assertTrue(peli.loppunut());
        assertEquals(Pelaaja.X, peli.voittaja());
    }

    @Test
    public void pelaajaOvoittaaPystysuorasti() {
        peli.siirto(0);
        peli.siirto(1);
        peli.siirto(3);
        peli.siirto(4);
        peli.siirto(8);
        assertFalse(peli.loppunut());
        peli.siirto(7);
        assertTrue(peli.loppunut());
        assertEquals(Pelaaja.O, peli.voittaja());
    }

    @Test
    public void pelaajaOvoittaaVaakasuoraan() {
        peli.siirto(0);
        peli.siirto(3);
        peli.siirto(1);
        peli.siirto(4);
        peli.siirto(6);
        assertFalse(peli.loppunut());
        peli.siirto(5);
        assertTrue(peli.loppunut());
        assertEquals(Pelaaja.O, peli.voittaja());
    }

    @Test
    public void pelaajaXvoittaaVaakasuoraan() {
        peli.siirto(0);
        peli.siirto(3);
        peli.siirto(6);
        peli.siirto(4);
        peli.siirto(7);
        peli.siirto(2);
        assertFalse(peli.loppunut());
        peli.siirto(8);
        assertTrue(peli.loppunut());
        assertEquals(Pelaaja.X, peli.voittaja());
    }

    @Test
    public void pelaajaXvoittaaDiagnonalisesti() {
        peli.siirto(0);
        peli.siirto(3);
        peli.siirto(4);
        peli.siirto(5);
        assertFalse(peli.loppunut());
        peli.siirto(8);
        assertTrue(peli.loppunut());
        assertEquals(Pelaaja.X, peli.voittaja());
    }

    @Test
    public void tasapeli() {
        peli.siirto(0);
        peli.siirto(3);
        peli.siirto(6);

        assertFalse(peli.loppunut());
        peli.siirto(2);
        assertFalse(peli.loppunut());
        peli.siirto(5);
        assertFalse(peli.loppunut());
        peli.siirto(8);
        assertFalse(peli.loppunut());
        peli.siirto(1);
        assertFalse(peli.loppunut());
        peli.siirto(4);
        assertFalse(peli.loppunut());
        peli.siirto(7);
        assertTrue(peli.loppunut());
        assertTrue(peli.tasapeli());
    }
}
