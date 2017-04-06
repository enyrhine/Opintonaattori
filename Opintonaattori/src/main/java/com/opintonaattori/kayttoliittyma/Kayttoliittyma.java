package com.opintonaattori.kayttoliittyma;

import com.opintonaattori.main.Kayttaja;
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
        JLabel nimi = new JLabel(this.tiedosto.toString());

        JLabel uusiKurssi = new JLabel("Lisää uusi kurssisuoritus: ");
        JTextField kurssinNimi = new JTextField();
        JTextField op = new JTextField();
        JTextField arvosana = new JTextField();
        JButton lisaa = new JButton("Lisää kurssisuoritus");

        
        LisaysKuuntelija lisaysKuuntelija = new LisaysKuuntelija(this.kayttaja, kurssinNimi, 0, 0);
        lisaa.addActionListener(lisaysKuuntelija);
        ActionEvent testi = new ActionEvent(lisaysKuuntelija, 1, "lisää");
        lisaysKuuntelija.actionPerformed(testi);
        
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

//        try {
//            if (op.getText().isEmpty() | arvosana.getText().isEmpty()) {
//                LisaysKuuntelija lisaysKuuntelija = new LisaysKuuntelija(this.kayttaja, kurssinNimi, 0, 0);
//                lisaa.addActionListener(lisaysKuuntelija);
//                ActionEvent testi = new ActionEvent(lisaysKuuntelija, 1, "lisää");
//                lisaysKuuntelija.actionPerformed(testi);
//            } else {
//                LisaysKuuntelija lisaysKuuntelija = new LisaysKuuntelija(this.kayttaja, kurssinNimi, Integer.parseInt(op.getText()), Integer.parseInt(arvosana.getText()));
//                lisaa.addActionListener(lisaysKuuntelija);
//                ActionEvent testi = new ActionEvent(lisaysKuuntelija, 1, "lisää");
//                lisaysKuuntelija.actionPerformed(testi);
//            }
//
//        } catch (Exception e) {
//            System.out.println("Virhe tiedostoon kirjoittamisessa: " + e.getMessage());
//        }
    }

    public JFrame getFrame() {
        return frame;
    }

}
