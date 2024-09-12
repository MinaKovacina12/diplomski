/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DatabaseBroker;
import domen.Cenovnik;
import domen.Dobavljac;
import domen.Menadzer;
import domen.Porudzbenica;
import domen.Proizvod;
import domen.StavkaPorudzbenice;
import java.util.ArrayList;
import java.util.List;
import so.cenovnik.KreirajCenovnikOperacija;
import so.cenovnik.UcitajCenovnikOperacija;
import so.dobavljac.KreirajDobavljacaOperacija;
import so.dobavljac.NadjiDobavljaceOperacija;
import so.dobavljac.UcitajDobavljacaOperacija;
import so.dobavljac.UcitajListuDobavljacaOperacija;
import so.dobavljac.ZapamtiDobavljacaOperacija;
import so.menadzer.PronadjiMenadzeraOperacija;
import so.porudzbenica.NadjiPorudzbeniceOperacija;
import so.porudzbenica.UcitajPorudzbenicuOperacija;
//import so.porudzbenica.VratiSvePorudzbenice;
import so.porudzbenica.UcitajListuPorudzbenica;
import so.porudzbenica.KreirajPorudzbenicuOperacija;
import so.porudzbenica.UcitajPorudzbenicuOperacija;
import so.porudzbenica.ZapamtiPorudzbenicuOperacija;
import so.proizvod.KreirajProizvodOperacija;
import so.proizvod.NadjiProizvodeOperacija;
import so.proizvod.ObrisiProizvodOperacija;
import so.proizvod.UcitajListuProizvodaOperacija;
import so.proizvod.UcitajProizvodOperacija;
import so.proizvod.ZapamtiProizvodOperacija;

/**
 *
 * @author Mina
 */
public class ServerController {

    private static ServerController instanca;

    private ServerController() {

    }

    public static ServerController getInstanca() {
        if (instanca == null) {
            instanca = new ServerController();
        }
        return instanca;
    }

    public Menadzer login(Menadzer menadzer) throws Exception {
        PronadjiMenadzeraOperacija loginOperacija = new PronadjiMenadzeraOperacija();

        return (Menadzer) loginOperacija.izvrsiOperaciju(menadzer);
    }

    public List<Porudzbenica> vratiSvePorudzbenice() throws Exception {
        UcitajListuPorudzbenica vratiSvePorudzbeniceOperacija = new UcitajListuPorudzbenica();

        return (List<Porudzbenica>) vratiSvePorudzbeniceOperacija.izvrsiOperaciju(null);
    }

    public Porudzbenica ucitajPorudzbenicu(Porudzbenica porudzbenica) throws Exception {
        UcitajPorudzbenicuOperacija ucitajPorudzbenicuOperacija = new UcitajPorudzbenicuOperacija();

        return (Porudzbenica) ucitajPorudzbenicuOperacija.izvrsiOperaciju(porudzbenica);
    }

    public List<Porudzbenica> pretraziPorudzbenice(String parametar) throws Exception {
        NadjiPorudzbeniceOperacija porudzbeniceOperacija = new NadjiPorudzbeniceOperacija();

        return (List<Porudzbenica>) porudzbeniceOperacija.izvrsiOperaciju(parametar);
    }

    public void kreirajPorudzbenicu(Porudzbenica porudzbenica) throws Exception {
        KreirajPorudzbenicuOperacija kreirajPorudzbenicuOperacija = new KreirajPorudzbenicuOperacija();

        kreirajPorudzbenicuOperacija.izvrsiOperaciju(porudzbenica);
    }

    public List<Dobavljac> pretraziDobavljace(String parametar) throws Exception {
        NadjiDobavljaceOperacija dobavljacOperacija = new NadjiDobavljaceOperacija();

        return (List<Dobavljac>) dobavljacOperacija.izvrsiOperaciju(parametar);
    }

    public Dobavljac ucitajDobavljaca(Dobavljac dobavljac) throws Exception {
        UcitajDobavljacaOperacija ucitajDobavljacaOperacija = new UcitajDobavljacaOperacija();

        return (Dobavljac) ucitajDobavljacaOperacija.izvrsiOperaciju(dobavljac);
    }

    public void zapamtiDobavljaca(Dobavljac dobavljac) throws Exception {
        ZapamtiDobavljacaOperacija zapamtiDobavljacaOperacija = new ZapamtiDobavljacaOperacija();

        zapamtiDobavljacaOperacija.izvrsiOperaciju(dobavljac);
    }

    public void zapamtiProizvod(Proizvod proizvod) throws Exception {
        ZapamtiProizvodOperacija zapamtiProizvodOperacija = new ZapamtiProizvodOperacija();

        zapamtiProizvodOperacija.izvrsiOperaciju(proizvod);
    }

    public Proizvod ucitajProizvod(Proizvod proizvod) throws Exception {
        UcitajProizvodOperacija ucitajProizvodOperacija = new UcitajProizvodOperacija();

        return (Proizvod) ucitajProizvodOperacija.izvrsiOperaciju(proizvod);
    }

    public void kreirajDobavljaca(Dobavljac dobavljac) throws Exception {
        KreirajDobavljacaOperacija kreirajDobavljacaOperacija = new KreirajDobavljacaOperacija();

        kreirajDobavljacaOperacija.izvrsiOperaciju(dobavljac);
    }

    public void kreirajProizvod(Proizvod proizvod) throws Exception {
        KreirajProizvodOperacija kreirajProizvodOperacija = new KreirajProizvodOperacija();

        kreirajProizvodOperacija.izvrsiOperaciju(proizvod);
    }

    public List<Proizvod> nadjiProizvode(String parametar) throws Exception {
        NadjiProizvodeOperacija nadjiProizvodeOperacija = new NadjiProizvodeOperacija();

        return (List<Proizvod>) nadjiProizvodeOperacija.izvrsiOperaciju(parametar);
    }

    /*public List<Menadzer> ucitajListuMenadzera() throws Exception {
        UcitajListuMenadzeraOperacija ucitajListuMenadzeraOperacija = new UcitajListuMenadzeraOperacija();

        return (List<Menadzer>) ucitajListuMenadzeraOperacija.izvrsiOperaciju(null);
     */
    public List<Dobavljac> ucitajListuDobavljaca() throws Exception {
        UcitajListuDobavljacaOperacija ucitajListuDobavljacaOperacija = new UcitajListuDobavljacaOperacija();

        return (List<Dobavljac>) ucitajListuDobavljacaOperacija.izvrsiOperaciju(null);
    }

    public List<Proizvod> ucitajListuProizvoda() throws Exception {
        UcitajListuProizvodaOperacija ucitajListuProizvodaOperacija = new UcitajListuProizvodaOperacija();

        return (List<Proizvod>) ucitajListuProizvodaOperacija.izvrsiOperaciju(null);
    }

    public void kreirajCenovnik(Cenovnik cenovnik) throws Exception {
        KreirajCenovnikOperacija kreirajCenovnikOperacija = new KreirajCenovnikOperacija();
        kreirajCenovnikOperacija.izvrsiOperaciju(cenovnik);
    }

    public void zapamtiPorudzbenicu(Porudzbenica porudzbenica) throws Exception {
        ZapamtiPorudzbenicuOperacija zapamtiPorudzbenicuOperacija = new ZapamtiPorudzbenicuOperacija();

        zapamtiPorudzbenicuOperacija.izvrsiOperaciju(porudzbenica);
    }

    public List<Cenovnik> ucitajCenovnik(Cenovnik cenovnik) throws Exception {
        UcitajCenovnikOperacija ucitajCenovnikOperacija = new UcitajCenovnikOperacija();

        return (List<Cenovnik>) ucitajCenovnikOperacija.izvrsiOperaciju(cenovnik);
    }

    public void obrisiProizvod(Proizvod proizvod) throws Exception {
        ObrisiProizvodOperacija obrisiProizvodOperacija = new ObrisiProizvodOperacija();
        obrisiProizvodOperacija.izvrsiOperaciju(proizvod);
    }

    public List<StavkaPorudzbenice> vratiSveStavke() throws Exception {
        List<Porudzbenica> porudzbenice = ServerController.getInstanca().vratiSvePorudzbenice();
        List<StavkaPorudzbenice> sveStavke = new ArrayList<>();
        

        for (Porudzbenica p : porudzbenice) {
            Porudzbenica nova=ucitajPorudzbenicu(p);
            sveStavke.addAll(nova.getStavke());
        }

        return sveStavke;
    }
}
