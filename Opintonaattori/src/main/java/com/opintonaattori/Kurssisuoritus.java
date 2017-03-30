package com.opintonaattori;

public class Kurssisuoritus {

    private String kurssi;
    private int op;
    private int arvosana;
    private boolean tutkinto;

    public Kurssisuoritus(String kurssi, int op, int arvosana) {
        this.kurssi = kurssi;
        this.op = op;
        this.arvosana = arvosana;
        this.tutkinto = false;
    }
    
    public void setTutkinto(boolean arvo) {
        this.tutkinto = arvo;
    }
    
    public boolean getTutkinto() {
        return this.tutkinto;
    }
    
    public String getNimi() {
        return this.kurssi;
    }
    
    public int getOp() {
        return this.op;
    }
    
    public int getArvosana() {
        return this.arvosana;
    }
    
    public void setArvosana(int as) {
        this.arvosana = as;
    }
    
    public void setOp(int op) {
        this.op = op;
    }
    
    public String getKurssisuoritus() {
        return this.kurssi + "," + this.op + "," + this.arvosana;
    }
    
}
