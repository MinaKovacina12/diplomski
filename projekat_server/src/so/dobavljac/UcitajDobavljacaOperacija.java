/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.dobavljac;

import database.DatabaseBroker;
import domen.Dobavljac;
import domen.Porudzbenica;
import java.sql.SQLIntegrityConstraintViolationException;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class UcitajDobavljacaOperacija extends ApstraktnaOperacija {

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if (!(podatak instanceof Dobavljac)) {
            throw new Exception("Prosledjeni objekat nije tipa Dobavljac");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        
        return DatabaseBroker.getInstanca().findOne((Dobavljac) podatak);

       
    }

}
