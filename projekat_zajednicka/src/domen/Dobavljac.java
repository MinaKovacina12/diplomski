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
public class Dobavljac implements DomenskiObjekat {

    private int PIB;
    private String nazivDobavljaca;
    private String adresaDobavljaca;
    private String emailDobavljaca;
    private String brojDobavljac;
    private List<Cenovnik> cenovnici;

    public Dobavljac() {
    }

    public Dobavljac(int PIB, String nazivDobavljaca, String adresaDobavljaca, String emailDobavljaca, String brojDobavljac, List<Cenovnik> cenovnici) {
        this.PIB = PIB;
        this.nazivDobavljaca = nazivDobavljaca;
        this.adresaDobavljaca = adresaDobavljaca;
        this.emailDobavljaca = emailDobavljaca;
        this.brojDobavljac = brojDobavljac;
        this.cenovnici = cenovnici;
    }

    public int getPIB() {
        return PIB;
    }

    public void setPIB(int PIB) {
        this.PIB = PIB;
    }

    public String getNazivDobavljaca() {
        return nazivDobavljaca;
    }

    public void setNazivDobavljaca(String nazivDobavljaca) {
        this.nazivDobavljaca = nazivDobavljaca;
    }

    public String getAdresaDobavljaca() {
        return adresaDobavljaca;
    }

    public void setAdresaDobavljaca(String adresaDobavljaca) {
        this.adresaDobavljaca = adresaDobavljaca;
    }

    public String getEmailDobavljaca() {
        return emailDobavljaca;
    }

    public void setEmailDobavljaca(String emailDobavljaca) {
        this.emailDobavljaca = emailDobavljaca;
    }

    public String getBrojDobavljac() {
        return brojDobavljac;
    }

    public void setBrojDobavljac(String brojDobavljac) {
        this.brojDobavljac = brojDobavljac;
    }

    public List<Cenovnik> getCenovnici() {
        return cenovnici;
    }

    public void setCenovnici(List<Cenovnik> cenovnici) {
        this.cenovnici = cenovnici;
    }

    @Override
    public String toString() {
        return nazivDobavljaca;
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
        final Dobavljac other = (Dobavljac) obj;
        return this.PIB == other.PIB;
    }

    @Override
    public String vratiNazivTabele() {
        return "dobavljac";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return PIB + ", '" + nazivDobavljaca + "' , '" + adresaDobavljaca + "' , '" + emailDobavljaca + "' , '" + brojDobavljac+"'";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "PIB, nazivDobavljaca, adresaDobavljaca, emailDobavljaca, brojDobavljaca";
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
        return "nazivDobavljaca='" + nazivDobavljaca + "' , adresaDobavljaca = '" + adresaDobavljaca + "', emailDobavljaca = '" + emailDobavljaca + "', brojDobavljaca ='" + brojDobavljac + "'"; //kako ovo
    }

    @Override
    public String vratiUslovZaId() {
        return "dobavljac.PIB = " + PIB;
    }

    @Override
    public String vratiJoinUslov() {
        return "";
    }

    @Override
    public List<DomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {

            int PIB = rs.getInt("PIB");
            String nazivDobavljaca = rs.getString("nazivDobavljaca");
            String adresaDobavljaca = rs.getString("adresaDobavljaca");
            String emailDobavljaca = rs.getString("emailDobavljaca");
            String brojDobavljaca = rs.getString("brojDobavljaca");

            Dobavljac dobavljac = new Dobavljac(PIB, nazivDobavljaca, adresaDobavljaca, emailDobavljaca, brojDobavljaca, new ArrayList<>());

            lista.add(dobavljac);
        }
        return lista;
    }

    @Override
    public String vratiUslovPretrage(String parametar) {
        return "nazivDobavljaca like '%" + parametar + "%'";
    }

    @Override
    public String vratiJoinUslovJedan() {
        //return vratiJoinUslov(); // VANJA - ako je neka klasa koja nema listu u sebi stavis ovako
        return " left join cenovnik on dobavljac.PIB = cenovnik.PIB left join proizvod on proizvod.sifraProizvoda = cenovnik.sifraProizvoda";
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs) throws Exception {
        Dobavljac dobavljac = new Dobavljac();
       
        while (rs.next()) {
            if (dobavljac.getPIB() == 0) {
                int PIB = rs.getInt(1);
                String nazivDobavljaca = rs.getString("nazivDobavljaca");
                String adresaDobavljaca = rs.getString("adresaDobavljaca");
                String emailDobavljaca = rs.getString("emailDobavljaca");
                String brojDobavljaca = rs.getString("brojDobavljaca");

                dobavljac = new Dobavljac(PIB, nazivDobavljaca, adresaDobavljaca, emailDobavljaca, brojDobavljaca, new ArrayList<>());
            }

            double cenaProizvoda = rs.getDouble("cenaProizvoda");
            
            int sifraProizvoda = rs.getInt("sifraProizvoda");
            String nazivProizvoda = rs.getString("nazivProizvoda");
            String opis = rs.getString("opis");
            
            Proizvod proizvod = new Proizvod(sifraProizvoda, nazivProizvoda, opis);
            
            Cenovnik cenovnik = new Cenovnik(dobavljac, proizvod, cenaProizvoda);
            
            if(cenaProizvoda !=0 ){
                dobavljac.getCenovnici().add(cenovnik);
            }
            
        }

        return dobavljac;
    }

}
