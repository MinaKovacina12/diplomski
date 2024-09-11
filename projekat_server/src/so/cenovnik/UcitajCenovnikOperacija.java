/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.cenovnik;

import database.DatabaseBroker;
import domen.Cenovnik;
import domen.Dobavljac;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class UcitajCenovnikOperacija extends ApstraktnaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {
         if(!(podatak instanceof Cenovnik )){
            throw new Exception("Prosledjeni objekat nije klase Cenovnik");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Cenovnik cenovnik = (Cenovnik) podatak;
        return DatabaseBroker.getInstanca().search(cenovnik, cenovnik.getDobavljac().getPIB()+"" );
    }
    
}
