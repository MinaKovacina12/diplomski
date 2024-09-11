/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import database.DatabaseBroker;

/**
 *
 * @author Mina
 */
public abstract class ApstraktnaOperacija {
    
    public Object izvrsiOperaciju(Object podatak) throws Exception{
        try{
            DatabaseBroker.getInstanca().connect();
            
            validiraj(podatak);
            Object rezultat = izvrsi(podatak);
            
            DatabaseBroker.getInstanca().commit();
            return rezultat;
        }catch(Exception ex){
            ex.printStackTrace();
            DatabaseBroker.getInstanca().rollback();
            throw ex;
        } finally{
            DatabaseBroker.getInstanca().disconnect();
        }
    }
    
    protected abstract void validiraj(Object podatak) throws Exception;
    protected abstract Object izvrsi(Object podatak) throws Exception;
}
