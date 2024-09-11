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
public class ZapamtiPorudzbenicuOperacija extends ApstraktnaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Porudzbenica)){
            throw new Exception("Prosledjeni objekat nije klase Porudzbenica");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Porudzbenica novaPorudzbenica = (Porudzbenica) podatak;
        
        try {
            DatabaseBroker.getInstanca().update(novaPorudzbenica);
        
        Porudzbenica staraPorudzebica = (Porudzbenica) DatabaseBroker.getInstanca().findOne(novaPorudzbenica);
        
        for(StavkaPorudzbenice stavka: staraPorudzebica.getStavke()){
            if(!novaPorudzbenica.getStavke().contains(stavka)){
                DatabaseBroker.getInstanca().delete(stavka);
            }
        }
        
        for(StavkaPorudzbenice stavka: novaPorudzbenica.getStavke()){
            if(!staraPorudzebica.getStavke().contains(stavka)){
                DatabaseBroker.getInstanca().insert(stavka);
            }else{
                int index = staraPorudzebica.getStavke().indexOf(stavka);
                StavkaPorudzbenice staraStavka = staraPorudzebica.getStavke().get(index);
                
                if(!stavka.getProizvod().equals(staraStavka.getProizvod()) || stavka.getKolicina() != staraStavka.getKolicina()){
                    DatabaseBroker.getInstanca().update(stavka);
                }
            }
        }
        } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("Sistem ne moze da zapamti porudzbenicu");
        }
        
        return novaPorudzbenica;
    }
    
    
}
