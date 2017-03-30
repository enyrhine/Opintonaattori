package com.opintonaattori.kayttoliittyma;

import com.opintonaattori.Kayttaja;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private File tiedosto;
    //private LisaysKuuntelija lisaysKuuntelija;
    private Kayttaja kayttaja;

    public Kayttoliittyma(File tiedosto, Kayttaja kayttaja) {
        this.tiedosto = tiedosto;
        this.kayttaja = kayttaja;
        //this.lisaysKuuntelija = new LisaysKuuntelija(this.tiedosto.getName(), );
    }

    @Override
    public void run() {
        frame = new JFrame(tiedosto.getName());
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
        JLabel nimi = new JLabel(this.tiedosto.toString());

        JLabel uusiKurssi = new JLabel("Lisää uusi kurssisuoritus: ");
        JTextField kurssinNimi = new JTextField();
        JTextArea op = new JTextArea();
        JTextField arvosana = new JTextField();
        JButton lisaa = new JButton("Lisää kurssisuoritus");
        LisaysKuuntelija lisaysKuuntelija = new LisaysKuuntelija(this.kayttaja, op);
        lisaa.addActionListener(lisaysKuuntelija);
        
        container.add(kurssi);
        container.add(nimi);
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(uusiKurssi);
        container.add(kurssinNimi);
        container.add(op);
        container.add(arvosana);
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(lisaa);
    }

    public JFrame getFrame() {
        return frame;
    }

}
