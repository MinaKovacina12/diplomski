/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.porudzbenica;

import database.DatabaseBroker;
import domen.DomenskiObjekat;
import domen.Porudzbenica;
import email.Sender;
import java.io.File;
import pdf.Pdf;
import so.ApstraktnaOperacija;

/**
 *
 * @author Mina
 */
public class ObradiPorudzbenicuOperacija extends ApstraktnaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if (!(podatak instanceof Porudzbenica)) {
            throw new Exception("Prosledjeni objekat nije klase Porudzbenica");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Porudzbenica por = (Porudzbenica) podatak;
        DatabaseBroker.getInstanca().update((DomenskiObjekat) por);
         Pdf pdf = new Pdf();
            //pdf.createPdfDocument(porudzbenica);
            try {
                File file = pdf.createPdfDocument(por);
                Sender.getInstanca().posaljiEmail(por, file);
            } catch (Exception ex) {
                throw new Exception("Sistem ne može da posalje mail");
            }
        
        return por;
    }
    
}
