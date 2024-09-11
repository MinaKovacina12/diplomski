/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nit;

import domen.Dobavljac;
import domen.Menadzer;
import domen.Porudzbenica;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mina
 */
public class ServerNit extends Thread {

    private ServerSocket serverSocket;
    private List<KlijentNit> klijenti;
    
      public ServerNit() throws IOException {
        serverSocket =new ServerSocket(10000);
        klijenti =new LinkedList<>();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();

                KlijentNit klijentNit = new KlijentNit(socket, this);
                klijentNit.start();
                
                klijenti.add(klijentNit);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stopServer() throws IOException {
        serverSocket.close();

    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    boolean vecUlogovan(Menadzer menadzer) {
         for(KlijentNit klijentNit:klijenti){
            Menadzer m=klijentNit.getUlogovani();
            if(m!=null && menadzer.getUsername().equals(m.getUsername())){
                return true;
            }
        }
        return false;
    }
    
    

}
