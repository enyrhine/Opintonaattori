package com.opintonaattori.kayttoliittyma;

import com.opintonaattori.logiikka.Kayttaja;
import com.opintonaattori.logiikka.Kurssisuoritus;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
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
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * Luokka tarjoaa käyttöliittymän luontiin tarvittavat metodit.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private File tiedosto;
    private Kayttaja kayttaja;
    private int korkeus;

    /**
     * Luokka luo käyttöliittymän jonka avulla hallitaan kurssien lisäystä ja
     * näkymää.
     *
     * @param tiedosto kertoo käyttäjän tiedoston
     * @param kayttaja antaa käyttäjän
     *
     */
    public Kayttoliittyma(File tiedosto, Kayttaja kayttaja) {
        this.tiedosto = tiedosto;
        this.kayttaja = kayttaja;
        this.korkeus = 800;
    }

    @Override
    public void run() {
        frame = new JFrame(kayttaja.getNimi());
        //frame.setPreferredSize(new Dimension(1000, this.korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Metodi luo uuden päivitetyn ikkunan.
     *
     * @param i antaa halutun sivun korkeuden
     */
    public void runAgain(int i) {
        frame.setVisible(false);
        this.korkeus = this.korkeus + i;
        frame = new JFrame(kayttaja.getNimi());
        //frame.setPreferredSize(new Dimension(1000, this.korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        paivita(container);
        JLabel opintopisteet = new JLabel("Opintopisteet: ");
        JLabel opintoPisteet = new JLabel(this.kayttaja.getOpintopisteet() + "");
        JLabel keskiArvo = new JLabel("Arvosanojen keskiarvo: ");
        JLabel keskiarvo = new JLabel(this.kayttaja.getKeskiarvo().toString());
        JLabel uusiKurssi = new JLabel("Lisää uusi kurssisuoritus: ");
        JTextField kurssinNimi = new JTextField("Kurssin nimi");
        JTextField op = new JTextField("Opintopisteet");
        JTextField arvosana = new JTextField("Arvosana");
        JButton lisaa = new JButton("Lisää kurssisuoritus");
        setLisayskuuntelija(kurssinNimi, op, arvosana, lisaa);
        container.add(opintopisteet);
        container.add(opintoPisteet);
        container.add(keskiArvo);
        container.add(keskiarvo);
        container.add(uusiKurssi);
        container.add(kurssinNimi);
        container.add(op);
        container.add(arvosana);
        container.add(lisaa);
        container.add(new JLabel(" "));
        container.add(new JLabel(" "));
        container.add(new JLabel(" "));
    }

    /**
     * Metodi luo uuden lisayskuuntelijan ja asettaa sen arvoiksi halutut
     * kurssin parametrit.
     *
     * @param kurssinNimi annettu JTextField
     * @param op annettu JTextField
     * @param arvosana annettu JTextField
     * @param lisaa annettu JButton
     * @return palauttaa olion lisaysKuuntelija
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

    /**
     * Metodi päivittää kurssien tiedot käyttöliittymälle.
     *
     * @param container annetaan container olio
     */
    public void paivita(Container container) {
        int j = this.kayttaja.getKurssisuorituksetList().size();
        GridLayout layout = new GridLayout(j + 4, 4);
        container.setLayout(layout);
        JLabel tyhja = new JLabel("");
        JLabel kurssi = new JLabel("Kurssin nimi:");
        JLabel opt = new JLabel("Opintopisteet: ");
        JLabel arvosanat = new JLabel("Arvosanat: ");
        container.add(kurssi);
        container.add(opt);
        container.add(arvosanat);
        container.add(tyhja);

        if (this.kayttaja.getKurssisuorituksetList().size() > 0) {
            for (int i = 0; i < this.kayttaja.getKurssisuorituksetList().size(); i++) {

                JLabel nimi = new JLabel(this.kayttaja.tulostaKurssinNimi(i));
                container.add(nimi);
                JLabel opintopiste = new JLabel(this.kayttaja.tulostaKurssinOpintopisteet(i));
                container.add(opintopiste);
                JLabel arvosana = new JLabel(this.kayttaja.tulostaKurssinArvosana(i));
                container.add(arvosana);
                container.add(new JLabel(" "));
            }
        }

    }

    public JFrame getFrame() {
        return frame;
    }

}
