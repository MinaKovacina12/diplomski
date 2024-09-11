/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.proizvod;

import database.DatabaseBroker;
import domen.Porudzbenica;
import domen.Proizvod;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class UcitajProizvodOperacija extends ApstraktnaOperacija {

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if (!(podatak instanceof Proizvod)) {
            throw new Exception("Prosledjeni objekat nije tipa Proizvod");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        return DatabaseBroker.getInstanca().findOne((Proizvod) podatak);

    }

}
