/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import domen.Porudzbenica;
import domen.Proizvod;
import domen.StavkaPorudzbenice;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mina
 */
public class ModelTabeleProiPorudz extends AbstractTableModel{
    
    private List<StavkaPorudzbenice> stavke; 
    private String[] kolone = {"ID Porudžbenice", "Naziv Proizvoda"};

    public ModelTabeleProiPorudz(List<StavkaPorudzbenice> stavke) {
        this.stavke = stavke;
    }

    @Override
    public int getRowCount() {
        return stavke.size(); 
    }

    @Override
    public int getColumnCount() {
        return kolone.length; 
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column]; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPorudzbenice stavka = stavke.get(rowIndex); 

        switch (columnIndex) {
             case 0:
                return stavka.getPorudzbenica().getSifraPorudzbenice();
            case 1:
                return stavka.getProizvod().getNazivProizvoda();
            default:
                return null;
           
        }
    }
    
     public void osveziModel(List<StavkaPorudzbenice> novaLista) {
        this.stavke = novaLista;
        fireTableDataChanged(); 
    }
}
