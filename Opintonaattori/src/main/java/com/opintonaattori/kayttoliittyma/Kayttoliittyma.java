package com.opintonaattori.kayttoliittyma;

import com.opintonaattori.logiikka.Kayttaja;
import com.opintonaattori.logiikka.Kurssisuoritus;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Luokka tarjoaa käyttöliittymän luontiin tarvittavat metodit.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private File tiedosto;
    private Kayttaja kayttaja;
    //private Container container;

    public Kayttoliittyma(File tiedosto, Kayttaja kayttaja) {
        this.tiedosto = tiedosto;
        this.kayttaja = kayttaja;
        //this.container = new Container();
    }

    @Override
    public void run() {
        frame = new JFrame(kayttaja.getNimi());
        frame.setPreferredSize(new Dimension(1000, 150));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setContentPane(this.container);
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        int j = this.kayttaja.getKurssit().size();
        GridLayout layout = new GridLayout(j+2, 4);
        container.setLayout(layout);

        for (int i = 0; i < this.kayttaja.getKurssit().size(); i++) {
            JLabel kurssi = new JLabel("Kurssin nimi, opintopisteet, arvosana: ");
            container.add(kurssi);
            JLabel nimi = new JLabel(this.kayttaja.tulostaKurssinNimi(i));
            container.add(nimi);
            JLabel opintopiste = new JLabel(this.kayttaja.tulostaKurssinOpintopisteet(i));
            container.add(opintopiste);
            JLabel arvosana = new JLabel(this.kayttaja.tulostaKurssinArvosana(i));
            container.add(arvosana);
        }

        JLabel uusiKurssi = new JLabel("Lisää uusi kurssisuoritus: ");
        JTextField kurssinNimi = new JTextField("Kurssin nimi");
        JTextField op = new JTextField("Opintopisteet");
        JTextField arvosana = new JTextField("Arvosana");
        JButton lisaa = new JButton("Lisää kurssisuoritus");

        setLisayskuuntelija(kurssinNimi, op, arvosana, lisaa);

        container.add(uusiKurssi);
        container.add(kurssinNimi);
        container.add(op);
        container.add(arvosana);
        container.add(lisaa);

    }

    /**
     * Metodi luo uuden lisayskuuntelijan ja asettaa sen arvoiksi halutut
     * kurssin parametrit.
     *
     * @param kurssinNimi annettu JTextField
     * @param op annettu JTextField
     * @param arvosana annettu JTextField
     * @param lisaa annettu JButton
     *
     * @see
     * com.opintonaattori.kayttoliittyma.LisaysKuuntelija#actionPerformed(java.awt.event.ActionEvent)
     */
    public LisaysKuuntelija setLisayskuuntelija(JTextField kurssinNimi, JTextField op, JTextField arvosana, JButton lisaa) {
        LisaysKuuntelija lisaysKuuntelija = new LisaysKuuntelija(this.kayttaja, this, kurssinNimi, op, arvosana);
        lisaa.addActionListener(lisaysKuuntelija);
        ActionEvent tapahtuma = new ActionEvent(lisaysKuuntelija, 2, "lisää");
        lisaysKuuntelija.actionPerformed(tapahtuma);
        return lisaysKuuntelija;
    }
    
    public void paivita(Container container) {
        int j = this.kayttaja.getKurssit().size();
        GridLayout layout = new GridLayout(j+2, 4);
        layout.setRows(j+1);
        container.setLayout(layout);

        for (int i = 0; i < this.kayttaja.getKurssit().size(); i++) {
            JLabel kurssi = new JLabel("Kurssin nimi, opintopisteet, arvosana: ");
            container.add(kurssi);
            JLabel nimi = new JLabel(this.kayttaja.tulostaKurssinNimi(i));
            container.add(nimi);
            JLabel opintopiste = new JLabel(this.kayttaja.tulostaKurssinOpintopisteet(i));
            container.add(opintopiste);
            JLabel arvosana = new JLabel(this.kayttaja.tulostaKurssinArvosana(i));
            container.add(arvosana);
        }
    }
    
    public JTextField lisaaKurssi(Container container) {
        JLabel kurssi = new JLabel("Kurssin nimi, opintopisteet, arvosana: ");
            container.add(kurssi);
            JLabel nimi = new JLabel(this.kayttaja.tulostaKurssinNimi(this.kayttaja.getKurssit().size()-1));
            container.add(nimi);
            JLabel opintopiste = new JLabel(this.kayttaja.tulostaKurssinOpintopisteet(this.kayttaja.getKurssit().size()-1));
            container.add(opintopiste);
            JLabel arvosana = new JLabel(this.kayttaja.tulostaKurssinArvosana(this.kayttaja.getKurssit().size()-1));
            container.add(arvosana);
            
        return null;
    }
//    
//    @Override
//    public String toString() {
//        
//        return this.kayttaja.getKurssit().toString();
//    }

    public JFrame getFrame() {
        return frame;
    }

}
