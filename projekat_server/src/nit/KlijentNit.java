/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nit;

import controller.ServerController;
import domen.Cenovnik;
import domen.Dobavljac;
import domen.Menadzer;
import domen.Porudzbenica;
import domen.Proizvod;
import domen.StavkaPorudzbenice;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import util.KlijentskiZahtev;
import util.Operacije;
import util.ServerskiOdgovor;

/**
 *
 * @author Mina
 */
public class KlijentNit extends Thread {

    private Socket socket;
    private ServerNit serverNit;
    private Menadzer ulogovani;

    public KlijentNit(Socket socket, ServerNit serverNit) {
        this.socket = socket;
        this.serverNit = serverNit;
        ulogovani = null;
    }

    public Menadzer getUlogovani() {
        return ulogovani;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev klijentskiZahtev = (KlijentskiZahtev) in.readObject();

                ServerskiOdgovor serverskiOdgovor = obradiZahtev(klijentskiZahtev);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(serverskiOdgovor);
            }
        } catch (Exception ex) {
            ulogovani = null;
            ex.printStackTrace();

        }
    }

    private ServerskiOdgovor obradiZahtev(KlijentskiZahtev klijentskiZahtev) {
        ServerskiOdgovor serverskiOdgovor = new ServerskiOdgovor();

        try {
            switch (klijentskiZahtev.getOperacija()) {
                case Operacije.LOGIN:
                    Menadzer menadzerPokusaj = (Menadzer) klijentskiZahtev.getPodatak();
                    Menadzer menadzer = ServerController.getInstanca().login(menadzerPokusaj);

                    if (serverNit.vecUlogovan(menadzer)) {
                        throw new Exception("Ne mozete se ulogovati. Vec ste ulogovani");
                    }
                    ulogovani = menadzer;
                    serverskiOdgovor.setPodatak(menadzer);
                    break;

                case Operacije.KREIRAJ_DOBAVLJACA:
                    Dobavljac dobavljac = (Dobavljac) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().kreirajDobavljaca(dobavljac);
                    break;

                case Operacije.KREIRAJ_PROIZVOD:
                    Proizvod proizvod = (Proizvod) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().kreirajProizvod(proizvod);
                    break;

                case Operacije.PRETRAZI_PROIZVODE:
                    String uslov = (String) klijentskiZahtev.getPodatak();
                    Proizvod p3 = new Proizvod();
                    p3.vratiUslovPretrage(uslov);
                    List<Proizvod> listaProizvoda = ServerController.getInstanca().nadjiProizvode(uslov);
                    serverskiOdgovor.setPodatak(listaProizvoda);
                    break;

                case Operacije.UCITAJ_SVE_PROIZVODE:
                    List<Proizvod> listaProizvoda2 = ServerController.getInstanca().ucitajListuProizvoda();
                    serverskiOdgovor.setPodatak(listaProizvoda2);
                    break;

                case Operacije.PRETRAZI_DOBAVLJACE:
                    String uslov1 = (String) klijentskiZahtev.getPodatak();
                    Dobavljac d3 = new Dobavljac();
                    d3.vratiUslovPretrage(uslov1);
                    List<Dobavljac> listaDobavljaca = ServerController.getInstanca().pretraziDobavljace(uslov1);
                    serverskiOdgovor.setPodatak(listaDobavljaca);
                    break;

                case Operacije.UCITAJ_SVE_DOBAVLJACE:
                    List<Dobavljac> listaDobavljaca1 = ServerController.getInstanca().ucitajListuDobavljaca();
                    serverskiOdgovor.setPodatak(listaDobavljaca1);
                    break;

                case Operacije.UCITAJ_DOBAVLJACA:
                    Dobavljac dob = ServerController.getInstanca().ucitajDobavljaca((Dobavljac) klijentskiZahtev.getPodatak());
                    serverskiOdgovor.setPodatak(dob);
                    break;
                case Operacije.ZAPAMTI_DOBAVLJACA:
                    ServerController.getInstanca().zapamtiDobavljaca((Dobavljac) klijentskiZahtev.getPodatak());
                    break;
                case Operacije.KREIRAJ_CENOVNIK:
                    ServerController.getInstanca().kreirajCenovnik((Cenovnik) klijentskiZahtev.getPodatak());
                    break;

                case Operacije.UCITAJ_PORUDZBENICU:
                    Porudzbenica por = ServerController.getInstanca().ucitajPorudzbenicu((Porudzbenica) klijentskiZahtev.getPodatak());
                    serverskiOdgovor.setPodatak(por);
                    break;

                case Operacije.UCITAJ_PORUDZBENICE:
                    List<Porudzbenica> por1 = ServerController.getInstanca().vratiSvePorudzbenice();
                    serverskiOdgovor.setPodatak(por1);
                    break;

                case Operacije.PRETRAZI_PORUDZBENICE:
                    List<Porudzbenica> listaa = ServerController.getInstanca().pretraziPorudzbenice((String) klijentskiZahtev.getPodatak());
                    serverskiOdgovor.setPodatak(listaa);
                    break;

                case Operacije.KREIRAJ_PORUDZBENICU:
                    Porudzbenica porudzbenica1 = (Porudzbenica) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().kreirajPorudzbenicu(porudzbenica1);
                    break;
                case Operacije.ZAPAMTI_PORUDZBENICU:
                    ServerController.getInstanca().zapamtiPorudzbenicu((Porudzbenica) klijentskiZahtev.getPodatak());
                    break;

                case Operacije.UCITAJ_CENOVNIK:
                    List<Cenovnik> listaa1 = ServerController.getInstanca().ucitajCenovnik((Cenovnik) klijentskiZahtev.getPodatak());
                    serverskiOdgovor.setPodatak(listaa1);
                    break;
                case Operacije.ZAPAMTI_PROIZVOD:
                    ServerController.getInstanca().zapamtiProizvod((Proizvod) klijentskiZahtev.getPodatak());
                    break;
                case Operacije.OBRISI_PROIZVOD:
                    ServerController.getInstanca().obrisiProizvod((Proizvod) klijentskiZahtev.getPodatak());
                    break;


            }
        } catch (Exception ex) {
            serverskiOdgovor.setGreska(ex);
        }
        return serverskiOdgovor;
    }

}
