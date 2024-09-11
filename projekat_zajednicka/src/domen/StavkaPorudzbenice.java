/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mina
 */
public class StavkaPorudzbenice implements DomenskiObjekat{
    
    private int redniBroj;
    private int kolicina;
    private Proizvod proizvod;
    private Porudzbenica porudzbenica;
    private double cenaProizvoda;

    public StavkaPorudzbenice() {
    }

    public StavkaPorudzbenice(int redniBroj, int kolicina, Proizvod proizvod, Porudzbenica porudzbenica, double cenaProizvoda) {
        this.redniBroj = redniBroj;
        this.kolicina = kolicina;
        this.proizvod = proizvod;
        this.porudzbenica = porudzbenica;
        this.cenaProizvoda = cenaProizvoda;
    }

    public double getCenaProizvoda() {
        return cenaProizvoda;
    }

    public void setCenaProizvoda(double cenaProizvoda) {
        this.cenaProizvoda = cenaProizvoda;
    }


    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public Porudzbenica getPorudzbenica() {
        return porudzbenica;
    }

    public void setPorudzbenica(Porudzbenica porudzbenica) {
        this.porudzbenica = porudzbenica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final StavkaPorudzbenice other = (StavkaPorudzbenice) obj;
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        return Objects.equals(this.porudzbenica, other.porudzbenica);
    }

    

    @Override
    public String vratiNazivTabele() {
        return "stavkaporudzbenice";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return porudzbenica.getSifraPorudzbenice()+","+redniBroj+","+ kolicina+","+proizvod.getSifraProizvoda()+"," + cenaProizvoda;
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "sifraPorudzbenice, redniBroj, kolicina, sifraProizvoda, cenaProizvoda";
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
        return "kolicina="+kolicina+", sifraProizvoda="+proizvod.getSifraProizvoda()+ ", cenaProizvoda="+cenaProizvoda;
    }

    @Override
    public String vratiUslovZaId() {
        return "sifraPorudzbenice = "+porudzbenica.getSifraPorudzbenice()+" AND redniBroj="+redniBroj;
    }

    @Override
    public String vratiJoinUslov() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovPretrage(String parametar) {
        return "sifraPorudzbenice = " +parametar;
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
