/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mina
 */
public class Cenovnik implements DomenskiObjekat {

    private Dobavljac dobavljac;
    private Proizvod proizvod;
    private double cenaProizvoda;

    public Cenovnik() {
    }

    public Cenovnik(Dobavljac dobavljac, Proizvod proizvod, double cenaProizvoda) {
        this.dobavljac = dobavljac;
        this.proizvod = proizvod;
        this.cenaProizvoda = cenaProizvoda;
    }

    public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public double getCenaProizvoda() {
        return cenaProizvoda;
    }

    public void setCenaProizvoda(double cenaProizvoda) {
        this.cenaProizvoda = cenaProizvoda;
    }

    @Override
    public String vratiNazivTabele() {
        return "cenovnik";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return proizvod.getSifraProizvoda() + "," + dobavljac.getPIB() + "," + cenaProizvoda;
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "sifraProizvoda, PIB, cenaProizvoda";
    }

    @Override
    public boolean isAutoIncrement() {
        return false;
    }

    @Override
    public void setId(int id) {
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiJoinUslov() {
        return "inner join proizvod on cenovnik.sifraProizvoda = proizvod.sifraProizvoda";
    }

    @Override
    public List<DomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> cenovnikLista = new LinkedList<>();

        while (rs.next()) {
            Cenovnik cen = new Cenovnik();
            double cena = rs.getDouble("cenaProizvoda");
            cen.setCenaProizvoda(cena);
            Dobavljac dob = new Dobavljac();
            dob.setPIB(rs.getInt("PIB"));
            cen.setDobavljac(dob);
            int sifraP = rs.getInt("sifraProizvoda");
            String nazivv = rs.getString("nazivProizvoda");
            String opiss = rs.getString("opis");

            Proizvod proiz = new Proizvod(sifraP, nazivv, opiss);
            
            cen.setProizvod(proiz);
            
            cenovnikLista.add(cen);
        }
        return cenovnikLista;
    }

    @Override
    public String vratiUslovPretrage(String parametar) {
        return "PIB = " + parametar;
    }

    @Override
    public String vratiJoinUslovJedan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
