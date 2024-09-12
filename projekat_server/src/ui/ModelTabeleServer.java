/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import domen.Dobavljac;
import domen.Porudzbenica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mina
 */
public class ModelTabeleServer extends AbstractTableModel{

   private List<Dobavljac> dobavljaci;
   private List<Porudzbenica> porudzbenice;
   
   private String[] kolone= new String []{"Dobavljac","Broj porudzbenica"};

    public ModelTabeleServer(List<Dobavljac> dobavljaci, List<Porudzbenica> porudzbenice) {
        this.dobavljaci = dobavljaci;
        this.porudzbenice = porudzbenice;
    }
   
   
    
    @Override
    public int getRowCount() {
        return dobavljaci.size();
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
        Dobavljac d=dobavljaci.get(rowIndex);
        int broj=0;
        switch(columnIndex){
            case 0: return d.getNazivDobavljaca();
            case 1:
                for(Porudzbenica porudzbenica: porudzbenice){
                    if(porudzbenica.getDobavljac().getPIB()==d.getPIB()){
                        broj=broj+1;
                    }
                }
                return broj;
            default: return "";
        }
    }
    
   
    
}
    

