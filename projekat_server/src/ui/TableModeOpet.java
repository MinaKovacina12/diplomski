/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import domen.Cenovnik;
import domen.Dobavljac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mina
 */
public class TableModeOpet extends AbstractTableModel {
    
    private List<Dobavljac> dobavljaci;
    private String[] kolone = {"Dobavljac", "Proizvod"};

    public TableModeOpet(List<Dobavljac> dobavljaci) {
        this.dobavljaci = dobavljaci;
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
        int currentRow = 0;
        for (Dobavljac dobavljac : dobavljaci) {
            List<Cenovnik> cenovnici = dobavljac.getCenovnici();
            if (rowIndex < currentRow + cenovnici.size()) {
                Cenovnik cenovnik = cenovnici.get(rowIndex - currentRow);
                switch (columnIndex) {
                    case 0:
                        return dobavljac.getNazivDobavljaca();
                    case 1:
                        return cenovnik.getProizvod().getNazivProizvoda();
                    default:
                        throw new IllegalArgumentException("Invalid column index");
                }
            }
            currentRow += cenovnici.size();
        }
        return null;
    }
    
}
