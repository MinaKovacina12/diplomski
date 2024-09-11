/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mina
 */
public interface DomenskiObjekat extends Serializable{

    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();

    public String vratiKoloneZaInsert();

    public boolean isAutoIncrement();

    public void setId(int id);

    public String vratiVrednostiZaUpdate();

    public String vratiUslovZaId();

    public String vratiJoinUslov();

    public List<DomenskiObjekat> vratiListu(ResultSet rs) throws SQLException;

    public String vratiUslovPretrage(String parametar);

    public String vratiJoinUslovJedan();

    public DomenskiObjekat vratiJednog(ResultSet rs) throws Exception;
    
    
}
