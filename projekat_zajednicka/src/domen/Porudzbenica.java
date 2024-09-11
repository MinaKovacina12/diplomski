/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mina
 */
public class Porudzbenica implements DomenskiObjekat {

    private int sifraPorudzbenice;
    private Date datum;
    private int ukupnoProizvoda;
    private Dobavljac dobavljac;
    private Menadzer menadzer;
    private List<StavkaPorudzbenice> stavke;
    private String status;
    
    public static final String U_PRIPREMI = "U pripremi";
    public static final String KONACNA = "Konacna";
    
    
    

    public Porudzbenica() {
    }

    public Porudzbenica(int sifraPorudzbenice, Date datum, int ukupnoProizvoda, Dobavljac dobavljac, Menadzer menadzer, List<StavkaPorudzbenice> stavke, String status) {
        this.sifraPorudzbenice = sifraPorudzbenice;
        this.datum = datum;
        this.ukupnoProizvoda = ukupnoProizvoda;
        this.dobavljac = dobavljac;
        this.menadzer = menadzer;
        this.stavke = stavke;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public int getSifraPorudzbenice() {
        return sifraPorudzbenice;
    }

    public void setSifraPorudzbenice(int sifraPorudzbenice) {
        this.sifraPorudzbenice = sifraPorudzbenice;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getUkupnoProizvoda() {
        return ukupnoProizvoda;
    }

    public void setUkupnoProizvoda(int ukupnoProizvoda) {
        this.ukupnoProizvoda = ukupnoProizvoda;
    }

    public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    public List<StavkaPorudzbenice> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaPorudzbenice> stavke) {
        this.stavke = stavke;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }
    
    public double sracunajUkupno(){
        double suma = 0;
        if(stavke != null){
            for(StavkaPorudzbenice stavkaPorudzbenice: stavke){
                suma = suma + stavkaPorudzbenice.getCenaProizvoda()*stavkaPorudzbenice.getKolicina();
            }
        }
        
        return suma;
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
        final Porudzbenica other = (Porudzbenica) obj;
        return this.sifraPorudzbenice == other.sifraPorudzbenice;
    }

    @Override
    public String vratiNazivTabele() {
        return "porudzbenica";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

        return sifraPorudzbenice + ",'" + sdf.format(datum) + "'," + ukupnoProizvoda + "," + menadzer.getSifraMenadzer() + "," + dobavljac.getPIB();
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "sifraPorudzbenice, datum, ukupnoProizvoda, sifraMenadzera, PIB";
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public void setId(int id) {
        this.sifraPorudzbenice = id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        
        if (status.equals(Porudzbenica.KONACNA)){
            return "status='" + status+"'";
        }
        
        return "ukupnoProizvoda = "+ukupnoProizvoda;
    }

    @Override
    public String vratiUslovZaId() {
        return "porudzbenica.sifraPorudzbenice = "+ sifraPorudzbenice;
    }

    @Override
    public String vratiJoinUslov() {
        return "INNER JOIN menadzer ON porudzbenica.sifraMenadzera=menadzer.sifraMenadzera INNER JOIN dobavljac ON porudzbenica.PIB = dobavljac.PIB";
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

            int sifraMenadzera = rs.getInt("sifraMenadzera");
            String imeMenadzera = rs.getString("imeMenadzera");
            String prezimeMenadzera = rs.getString("prezimeMenadzera");
            String username = rs.getString("username");
            String password = rs.getString("password");

            int sifraPorudzbenice = rs.getInt("sifraPorudzbenice");
            Date datum = rs.getDate("datum");
            int ukupnoProizvoda = rs.getInt("ukupnoProizvoda");
            String statusPorudzbenice = rs.getString("status");

            Dobavljac dobavljac = new Dobavljac(PIB, nazivDobavljaca, adresaDobavljaca, emailDobavljaca, brojDobavljaca, new ArrayList<>());
            Menadzer menadzer = new Menadzer(sifraMenadzera, imeMenadzera, prezimeMenadzera, username, password);
            Porudzbenica porudzbenica = new Porudzbenica(sifraPorudzbenice, datum, ukupnoProizvoda, dobavljac, menadzer, new ArrayList<>(), statusPorudzbenice);

            lista.add(porudzbenica);
        }
        return lista;
    }

    @Override
    public String vratiUslovPretrage(String parametar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiJoinUslovJedan() {
        return vratiJoinUslov() + " inner join stavkaporudzbenice on porudzbenica.sifraPorudzbenice=stavkaporudzbenice.sifraPorudzbenice "
                + " inner join proizvod on stavkaporudzbenice.sifraProizvoda = proizvod.sifraProizvoda";
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs) throws Exception {
        List<StavkaPorudzbenice> lista = new ArrayList<>();
        boolean hasNext = rs.next();
        
        if(!hasNext) {
            return this;
        }

        int PIB = rs.getInt("PIB");
        String nazivDobavljaca = rs.getString("nazivDobavljaca");
        String adresaDobavljaca = rs.getString("adresaDobavljaca");
        String emailDobavljaca = rs.getString("emailDobavljaca");
        String brojDobavljaca = rs.getString("brojDobavljaca");

        int sifraMenadzera = rs.getInt("sifraMenadzera");
        String imeMenadzera = rs.getString("imeMenadzera");
        String prezimeMenadzera = rs.getString("prezimeMenadzera");
        String username = rs.getString("username");
        String password = rs.getString("password");

        int sifraPorudzbenice = rs.getInt("sifraPorudzbenice");
        Date datum = rs.getDate("datum");
        int ukupnoProizvoda = rs.getInt("ukupnoProizvoda");
         String statusPorudzbenice = rs.getString("status");

        Dobavljac dobavljac = new Dobavljac(PIB, nazivDobavljaca, adresaDobavljaca, emailDobavljaca, brojDobavljaca, new ArrayList<>());
        Menadzer menadzer = new Menadzer(sifraMenadzera, imeMenadzera, prezimeMenadzera, username, password);

        do {
            StavkaPorudzbenice stavkaPorudzbenice=new StavkaPorudzbenice();
            stavkaPorudzbenice.setId(rs.getInt("sifraPorudzbenice"));
            stavkaPorudzbenice.setKolicina(rs.getInt("kolicina"));
            stavkaPorudzbenice.setRedniBroj(rs.getInt("redniBroj"));
            stavkaPorudzbenice.setCenaProizvoda(rs.getDouble("cenaProizvoda"));
            Proizvod pr = new Proizvod();
            pr.setId(rs.getInt("sifraProizvoda"));
            pr.setNazivProizvoda(rs.getString("nazivProizvoda"));
            pr.setOpis(rs.getString("opis"));
            stavkaPorudzbenice.setProizvod(pr);
            lista.add(stavkaPorudzbenice);
            
        } while (rs.next());
        Porudzbenica porudzbenica = new Porudzbenica(sifraPorudzbenice, datum, ukupnoProizvoda, dobavljac, menadzer, lista,statusPorudzbenice);
        for(StavkaPorudzbenice stavka: lista){
            stavka.setPorudzbenica(porudzbenica);
        }

        return porudzbenica;
    }

}
