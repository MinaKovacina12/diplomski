/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Dobavljac;
import domen.Proizvod;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mina
 */
public class ModelTabeleDobavljaci extends AbstractTableModel {

    private List<Dobavljac> dobavljaci;

    private String[] kolone = new String[]{"Naziv dobavljača", "Adresa dobavljača", "Email dobavljača", "Broj dobavljača"};

    public ModelTabeleDobavljaci(List<Dobavljac> dobavljaci) {
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
        Dobavljac d = dobavljaci.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getNazivDobavljaca();
            case 1:
                return d.getAdresaDobavljaca();
            case 2:
                return d.getEmailDobavljaca();
            case 3:
                return d.getBrojDobavljac();
            default:
                return "";
        }
    }
    
     public List<Dobavljac> getDobavljaci() {
        return dobavljaci;
    }

    public void obrisiDobavljaca(Dobavljac dobavljac) {
        dobavljaci.remove(dobavljac);
        fireTableDataChanged();
    }

    public void dodajDobavljaca(Dobavljac dobavljac) {
        dobavljaci.add(dobavljac);
        fireTableDataChanged();
    }

    public Dobavljac vratiDobavljaca(int red) {
        return dobavljaci.get(red);
    }

}
