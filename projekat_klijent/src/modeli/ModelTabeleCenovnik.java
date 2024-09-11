/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Cenovnik;
import domen.Proizvod;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mina
 */
public class ModelTabeleCenovnik extends AbstractTableModel {

    private List<Cenovnik> cenovnici;

    private String[] kolone = new String[]{"Naziv proizvoda", "Opis", "Cena"};

    public ModelTabeleCenovnik(List<Cenovnik> cenovnici) {
        this.cenovnici = cenovnici;
    }
    

    @Override
    public int getRowCount() {
        return cenovnici.size();

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
        Cenovnik c = cenovnici.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getProizvod().getNazivProizvoda();
            case 1:
                return c.getProizvod().getOpis();
            case 2:
                return c.getCenaProizvoda();
            default:
                return "";
        }
    }

    public List<Cenovnik> getCenovnici() {
        return cenovnici;
    }

    public void obrisiCenovnik(Cenovnik cenovnik) {
        cenovnici.remove(cenovnik);
        fireTableDataChanged();
    }

    public void dodajCenovnik(Cenovnik cenovnik) {
        cenovnici.add(cenovnik);
        fireTableDataChanged();
    }

    public Cenovnik vratiCenovnik(int red) {
        return cenovnici.get(red);
    }

    public void setCenovnici(List<Cenovnik> cenovnici) {
        this.cenovnici = cenovnici;
        fireTableDataChanged();
    }
    
    
}
