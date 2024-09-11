/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Mina
 */
public class KlijentskiZahtev implements Serializable{
    
    private Object podatak;
    private int operacija;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(Object podatak, int operacija) {
        this.podatak = podatak;
        this.operacija = operacija;
    }

    public Object getPodatak() {
        return podatak;
    }

    public void setPodatak(Object podatak) {
        this.podatak = podatak;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
    
    
}
