/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.proizvod;

import database.DatabaseBroker;
import domen.Proizvod;
import java.sql.SQLIntegrityConstraintViolationException;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class ObrisiProizvodOperacija extends ApstraktnaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Proizvod)){
            throw new Exception("Prosledjeni objekat nije klase Proizvod");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        try{
            Proizvod proizvod = (Proizvod) podatak;

            DatabaseBroker.getInstanca().delete(proizvod);

            return proizvod;
        }catch(SQLIntegrityConstraintViolationException ex){
            throw new Exception("Ne mozete obrisati proizvod jer se nalazi na stavkama nekih porudzbenica");
        }
    }
    
}
