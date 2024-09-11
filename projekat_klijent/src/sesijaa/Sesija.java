/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesijaa;

import domen.Menadzer;
import forme.DobavljacPretragaForma;
import forme.PorudzbenicaKreirajForma;
import forme.ProizvodPretragaForma;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mina
 */
public class Sesija {

    private static Sesija instanca;

    private ProizvodPretragaForma pretragap;
    private DobavljacPretragaForma pretragad;
    private PorudzbenicaKreirajForma pretragac;

    /* private FrmKreirajProizvod kreirajP;
    private FrmPretragaProizvoda pretragap;
    private FrmKreirajRacun kreirajR;
    private FrmPretraziRacun pretragaR;
    private FrmMain glavna;*/
    private Menadzer m;

    private Map<String, Object> parametri;

    public void dodajParametar(String ime, Object object) {
        parametri.put(ime, object);
    }

    private Sesija() {

        parametri = new HashMap<>();
        m = new Menadzer();

    }

    public static Sesija getInstanca() {
        if (instanca == null) {
            instanca = new Sesija();
        }
        System.out.println("proverila");
        return instanca;
    }

    public Map<String, Object> getParametri() {
        return parametri;
    }

    public Object vratiParametar(String kljuc) {
        return parametri.get(kljuc);
    }

    public void obrisiParametar(String proizvod) {
        parametri.remove(proizvod);
    }

    public ProizvodPretragaForma getPretragap() {
        return pretragap;
    }

    public void setPretragap(ProizvodPretragaForma pretragap) {
        this.pretragap = pretragap;
    }

    public void setPretragad(DobavljacPretragaForma aThis) {
        this.pretragad = pretragad;
    }

    public void setPretragac(PorudzbenicaKreirajForma pretragac) {
        this.pretragac = pretragac;
    }

    public PorudzbenicaKreirajForma getPretragac() {
        return pretragac;
    }
    
    

}
