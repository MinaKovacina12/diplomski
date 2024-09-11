/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.dobavljac;

import database.DatabaseBroker;
import domen.Dobavljac;
import domen.Porudzbenica;
import java.util.List;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class NadjiDobavljaceOperacija extends ApstraktnaOperacija {

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if (!(podatak instanceof String)) {
            throw new Exception("Prosledjeni objekat nije tipa Dobavljac");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        String parametar = (String) podatak;
        return (List<Dobavljac>) (List<?>) DatabaseBroker.getInstanca().search(new Dobavljac(), parametar);
    }

}
