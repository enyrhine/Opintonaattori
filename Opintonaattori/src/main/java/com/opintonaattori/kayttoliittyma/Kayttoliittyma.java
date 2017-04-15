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

    public Kayttoliittyma(File tiedosto, Kayttaja kayttaja) {
        this.tiedosto = tiedosto;
        this.kayttaja = kayttaja;
    }

    @Override
    public void run() {
        frame = new JFrame(kayttaja.getNimi());
        frame.setPreferredSize(new Dimension(650, 150));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 4);
        container.setLayout(layout);
        JLabel kurssi = new JLabel("Kurssin nimi: ");
        //muokkaa kurrsin nimeksi
        JLabel nimi = new JLabel(this.kayttaja.getKurssit().toString());

        JLabel uusiKurssi = new JLabel("Lisää uusi kurssisuoritus: ");
        JTextField kurssinNimi = new JTextField("Kurssin nimi");
        JTextField op = new JTextField("Opintopisteet");
        JTextField arvosana = new JTextField("Arvosana");
        JButton lisaa = new JButton("Lisää kurssisuoritus");
     
        setLisayskuuntelija(kurssinNimi, op, arvosana, lisaa);
        
        container.add(kurssi);
        container.add(nimi);
        for (int i = 0; i < 2; i++) {
            container.add(new JLabel(""));
        }
        container.add(uusiKurssi);
        container.add(kurssinNimi);
        container.add(op);
        container.add(arvosana);
        for (int i = 0; i < 3; i++) {
            container.add(new JLabel(""));
        }
        container.add(lisaa);

    }
    
    /**
     * Metodi luo uuden lisayskuuntelijan ja asettaa sen arvoiksi halutut kurssin parametrit.
     *
     * @param kurssinNimi annettu JTextField
     * @param op annettu JTextField
     * @param arvosana annettu JTextField
     * @param lisaa annettu JButton
     *
     * @see com.opintonaattori.kayttoliittyma.LisaysKuuntelija#actionPerformed(java.awt.event.ActionEvent) 
     */
    public LisaysKuuntelija setLisayskuuntelija(JTextField kurssinNimi, JTextField op, JTextField arvosana, JButton lisaa) {
        LisaysKuuntelija lisaysKuuntelija = new LisaysKuuntelija(this.kayttaja, kurssinNimi, op, arvosana);
        lisaa.addActionListener(lisaysKuuntelija);
        ActionEvent tapahtuma = new ActionEvent(lisaysKuuntelija, 2, "lisää");
        lisaysKuuntelija.actionPerformed(tapahtuma);
        return lisaysKuuntelija;
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
