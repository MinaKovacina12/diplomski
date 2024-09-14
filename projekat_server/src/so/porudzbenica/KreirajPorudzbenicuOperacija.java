/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.porudzbenica;

import database.DatabaseBroker;
import domen.Porudzbenica;
import domen.StavkaPorudzbenice;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class KreirajPorudzbenicuOperacija extends ApstraktnaOperacija {

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if (!(podatak instanceof Porudzbenica)) {
            throw new Exception("Prosledjeni objekat nije klase Porudzbenica");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Porudzbenica porudzbenica = (Porudzbenica) podatak;

        DatabaseBroker.getInstanca().insert(porudzbenica);
        int rb = 0;
        for (StavkaPorudzbenice stavkaPorudzbenice : porudzbenica.getStavke()) {
            stavkaPorudzbenice.setRedniBroj(++rb);
            stavkaPorudzbenice.setPorudzbenica(porudzbenica);
            DatabaseBroker.getInstanca().insert(stavkaPorudzbenice);
        }
        //
        return porudzbenica;
    }

}
