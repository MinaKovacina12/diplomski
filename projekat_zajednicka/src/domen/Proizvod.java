/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mina
 */
public class Proizvod implements DomenskiObjekat {

    private int sifraProizvoda;
    private String nazivProizvoda;
    private String opis;

    public Proizvod() {
    }

    public Proizvod(int sifraProizvoda, String nazivProizvoda, String opis) {
        this.sifraProizvoda = sifraProizvoda;
        this.nazivProizvoda = nazivProizvoda;
        this.opis = opis;
    }

    public int getSifraProizvoda() {
        return sifraProizvoda;
    }

    public void setSifraProizvoda(int sifraProizvoda) {
        this.sifraProizvoda = sifraProizvoda;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return nazivProizvoda;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proizvod other = (Proizvod) obj;
        return this.sifraProizvoda == other.sifraProizvoda;
    }

    @Override
    public String vratiNazivTabele() {
        return "proizvod";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return sifraProizvoda + ", '" + nazivProizvoda + "' , '" + opis + "'";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "sifraProizvoda, nazivProizvoda, opis";
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public void setId(int id) {
        this.sifraProizvoda = id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "opis='" + opis+"'";
    }

    @Override
    public String vratiUslovZaId() {
        return "sifraProizvoda = " + sifraProizvoda;
    }

    @Override
    public String vratiJoinUslov() {
        return "";
    }

    @Override
    public List<DomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {

            int sifraProizvoda = rs.getInt("sifraProizvoda");
            String nazivProizvoda = rs.getString("nazivProizvoda");
            String opis = rs.getString("opis");

            Proizvod proizvod = new Proizvod(sifraProizvoda, nazivProizvoda, opis);

            lista.add(proizvod);
        }
        return lista;
    }

    @Override
    public String vratiUslovPretrage(String parametar) {
        return "nazivProizvoda like '%" + parametar + "%'";
    }

    @Override
    public String vratiJoinUslovJedan() {
        return vratiJoinUslov();
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs) throws Exception {
        Proizvod proizvod=new Proizvod();
        
        while(rs.next()){
            int sifraProizvoda=rs.getInt("sifraProizvoda");
            String nazivProizvoda=rs.getString("nazivProizvoda");
            String opis=rs.getString("opis");
            
            proizvod=new Proizvod(sifraProizvoda, nazivProizvoda, opis);
        }
        
        return proizvod;
    }

}
