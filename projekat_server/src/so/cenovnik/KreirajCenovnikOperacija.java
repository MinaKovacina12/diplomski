/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.cenovnik;

import database.DatabaseBroker;
import domen.Cenovnik;
import java.sql.SQLIntegrityConstraintViolationException;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class KreirajCenovnikOperacija extends ApstraktnaOperacija {

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if (!(podatak instanceof Cenovnik)) {
            throw new Exception("Prosledjeni objekat nije klase Cenovnik");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        try {
            Cenovnik cenovnik = (Cenovnik) podatak;
            DatabaseBroker.getInstanca().insert(cenovnik);
            return cenovnik;
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new Exception("Proizvod je vec unet u cenovnik dobavljaca");
        }
    }

}
