/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Cenovnik;
import domen.Dobavljac;
import domen.Menadzer;
import domen.Porudzbenica;
import domen.Proizvod;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import javax.sound.sampled.Port;
import util.KlijentskiZahtev;
import util.Operacije;
import util.ServerskiOdgovor;

/**
 *
 * @author Mina
 */
public class ClientController {

    private static ClientController instanca;
    private Socket socket;
    private Menadzer trenutnoUlogovani;

    public ClientController() throws Exception {
        socket = new Socket("localhost", 10000);
    }

    public Menadzer getTrenutnoUlogovani() {
        return trenutnoUlogovani;
    }

    public void setTrenutnoUlogovani(Menadzer trenutnoUlogovani) {
        this.trenutnoUlogovani = trenutnoUlogovani;
    }

    public static ClientController getInstanca() throws Exception {
        if (instanca == null) {
            instanca = new ClientController();
        }
        return instanca;
    }

    public Menadzer login(Menadzer menadzer) throws Exception {
        return (Menadzer) posaljiZahtevServeru(Operacije.LOGIN, menadzer);
    }

    public Dobavljac ucitajDobavljaca(Dobavljac dobavljac) throws Exception {
        return (Dobavljac) posaljiZahtevServeru(Operacije.UCITAJ_DOBAVLJACA, dobavljac);
    }

    public Proizvod ucitajProizvod(Proizvod proizvod) throws Exception {
        return (Proizvod) posaljiZahtevServeru(Operacije.UCITAJ_PROIZVOD, proizvod);
    }

    public void kreirajDobavljaca(Dobavljac dobavljac) throws Exception {
        posaljiZahtevServeru(Operacije.KREIRAJ_DOBAVLJACA, dobavljac);
    }

    public void kreirajProizvod(Proizvod proizvod) throws Exception {
        posaljiZahtevServeru(Operacije.KREIRAJ_PROIZVOD, proizvod);
    }

    public List<Proizvod> pretraziProizvode(String kriterijum) throws Exception {
        return (List<Proizvod>) posaljiZahtevServeru(Operacije.PRETRAZI_PROIZVODE, kriterijum);
    }

    public List<Proizvod> prikaziProizvode() throws Exception {
        return (List<Proizvod>) posaljiZahtevServeru(Operacije.UCITAJ_SVE_PROIZVODE, null);
    }

    public List<Dobavljac> pretraziDobavljace(String kriterijum) throws Exception {
        return (List<Dobavljac>) posaljiZahtevServeru(Operacije.PRETRAZI_DOBAVLJACE, kriterijum);
    }

    public List<Dobavljac> prikaziDobavljace() throws Exception {
        return (List<Dobavljac>) posaljiZahtevServeru(Operacije.UCITAJ_SVE_DOBAVLJACE, null);
    }

    public void zapamtiDobavljaca(Dobavljac dobavljac) throws Exception {
        posaljiZahtevServeru(Operacije.ZAPAMTI_DOBAVLJACA, dobavljac);
    }

    public void kreirajCenovnik(Cenovnik cenovnik) throws Exception {
        posaljiZahtevServeru(Operacije.KREIRAJ_CENOVNIK, cenovnik);
    }

    public List<Porudzbenica> ucitajPorudzbenice() throws Exception {
        return (List<Porudzbenica>) posaljiZahtevServeru(Operacije.UCITAJ_PORUDZBENICE, null);
    }

    public List<Porudzbenica> pretraziPorudzbenice(String parametar) throws Exception {
        return (List<Porudzbenica>) posaljiZahtevServeru(Operacije.PRETRAZI_PORUDZBENICE, parametar);
    }

    public Porudzbenica ucitajPorudzbenicu(Porudzbenica porudzbenica) throws Exception {
        return (Porudzbenica) posaljiZahtevServeru(Operacije.UCITAJ_PORUDZBENICU, porudzbenica);
    }

    public void kreirajPorudzbenicu(Porudzbenica porudzbenica) throws Exception {
        posaljiZahtevServeru(Operacije.KREIRAJ_PORUDZBENICU, porudzbenica);
    }

    public void zapamtiPorudzbenicu(Porudzbenica porudzbenica) throws Exception {
        posaljiZahtevServeru(Operacije.ZAPAMTI_PORUDZBENICU, porudzbenica);
    }

    public List<Cenovnik> ucitajCenovnik(Cenovnik cenovnik) throws Exception {
        return (List<Cenovnik>) posaljiZahtevServeru(Operacije.UCITAJ_CENOVNIK, cenovnik);
    }

    public void zapamtiProizvod(Proizvod proizvod) throws Exception {
        posaljiZahtevServeru(Operacije.ZAPAMTI_PROIZVOD, proizvod);
    }

    public void obrisiProizvod(Proizvod proizvod) throws Exception {
        posaljiZahtevServeru(Operacije.OBRISI_PROIZVOD, proizvod);
    }

  

    private Object posaljiZahtevServeru(int operacija, Object podatak) throws Exception {
        KlijentskiZahtev klijentskiZahtev = new KlijentskiZahtev(podatak, operacija);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(klijentskiZahtev);

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ServerskiOdgovor serverskiOdgovor = (ServerskiOdgovor) in.readObject();

        if (serverskiOdgovor.getGreska() != null) {
            throw serverskiOdgovor.getGreska();
        }
        return serverskiOdgovor.getPodatak();

    }

}
