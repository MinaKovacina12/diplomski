/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.proizvod;

import database.DatabaseBroker;
import domen.Porudzbenica;
import domen.Proizvod;
import java.util.List;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class NadjiProizvodeOperacija extends ApstraktnaOperacija {

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof String)){
            throw new Exception("Prosledjeni objekat nije klase String");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        String parametar = (String) podatak;
        return (List<Proizvod>) (List<?>) DatabaseBroker.getInstanca().search(new Proizvod(), parametar);
    }
    
}
