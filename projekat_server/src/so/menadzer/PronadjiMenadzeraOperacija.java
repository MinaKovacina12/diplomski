/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.menadzer;

import database.DatabaseBroker;
import domen.DomenskiObjekat;
import domen.Menadzer;
import java.util.List;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class PronadjiMenadzeraOperacija extends ApstraktnaOperacija {

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Menadzer)){
            throw new Exception("Prosledjeni objekat nije klase menadzer");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Menadzer menadzer = (Menadzer) podatak;
        
        List<DomenskiObjekat> listaDom = DatabaseBroker.getInstanca().search(menadzer, menadzer.getUsername());
        List<Menadzer> lista = (List<Menadzer>)(List<?>)listaDom;
        
        for(Menadzer m: lista){
            if(m.getPassword().equals(menadzer.getPassword())){
                return m;
            }
        }
        
        throw new Exception("Pogresni kredencijali");
    }
    
}































