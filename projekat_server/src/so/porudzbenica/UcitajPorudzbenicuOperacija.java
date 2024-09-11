/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.porudzbenica;

import database.DatabaseBroker;
import domen.Porudzbenica;
import domen.StavkaPorudzbenice;
import java.util.List;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class UcitajPorudzbenicuOperacija extends ApstraktnaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Porudzbenica)){
            throw new Exception("Prosledjeni objekat nije klase Porudzbenica");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {

        return DatabaseBroker.getInstanca().findOne((Porudzbenica) podatak);
    }
    
}
