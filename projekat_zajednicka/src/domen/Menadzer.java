/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mina
 */
public class Menadzer implements DomenskiObjekat {

    private int sifraMenadzer;
    private String imeMenadzera;
    private String prezimeMenadzera;
    private String username;
    private String password;

    public Menadzer() {
    }

    public Menadzer(int sifraMenadzer, String imeMenadzera, String prezimeMenadzera, String username, String password) {
        this.sifraMenadzer = sifraMenadzer;
        this.imeMenadzera = imeMenadzera;
        this.prezimeMenadzera = prezimeMenadzera;
        this.username = username;
        this.password = password;
    }

    public int getSifraMenadzer() {
        return sifraMenadzer;
    }

    public void setSifraMenadzer(int sifraMenadzer) {
        this.sifraMenadzer = sifraMenadzer;
    }

    public String getImeMenadzera() {
        return imeMenadzera;
    }

    public void setImeMenadzera(String imeMenadzera) {
        this.imeMenadzera = imeMenadzera;
    }

    public String getPrezimeMenadzera() {
        return prezimeMenadzera;
    }

    public void setPrezimeMenadzera(String prezimeMenadzera) {
        this.prezimeMenadzera = prezimeMenadzera;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        final Menadzer other = (Menadzer) obj;
        return this.sifraMenadzer == other.sifraMenadzer;
    }

    @Override
    public String vratiNazivTabele() {
        return "menadzer";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return sifraMenadzer + ",'" + imeMenadzera + "','" + prezimeMenadzera + "','" + username + "','" + password + "'";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "sifraMenadzera, imeMenadzera, prezimeMenadzera, username, password";
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public void setId(int id) {
        this.sifraMenadzer = id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " imeMenadzera = '" + imeMenadzera + "', prezimeMenadzera = '" + prezimeMenadzera + "'";
    }

    @Override
    public String vratiUslovZaId() {
        return "sifraMenadzera = " + sifraMenadzer;
    }

    @Override
    public String vratiJoinUslov() {
        return "";
    }

    @Override
    public List<DomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> list = new ArrayList<>();

        while (rs.next()) {
            int sifraMenadzera = rs.getInt("sifraMenadzera");
            String imeMenadzera = rs.getString("imeMenadzera");
            String prezimeMenadzera = rs.getString("prezimeMenadzera");
            String username = rs.getString("username");
            String password = rs.getString("password");
            
            Menadzer menadzer=new Menadzer(sifraMenadzera, imeMenadzera, prezimeMenadzera, username, password);
            list.add(menadzer);
        }

        return list;
    }

    @Override
    public String vratiUslovPretrage(String parametar) {
        return "username='" + parametar + "'";
    }

    @Override
    public String vratiJoinUslovJedan() {
        return vratiJoinUslov();
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs) throws Exception {

        rs.next();

        int sifraMenadzera = rs.getInt("sifraMenadzera");
        String imeMenadzera = rs.getString("imeMenadzera");
        String prezimeMenadzera = rs.getString("prezimeMenadzera");
        String username = rs.getString("username");
        String password = rs.getString("password");

        return new Menadzer(sifraMenadzera, imeMenadzera, prezimeMenadzera, username, password);

    }

}
