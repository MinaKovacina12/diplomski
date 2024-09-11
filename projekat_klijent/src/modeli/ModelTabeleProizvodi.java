/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Proizvod;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mina
 */
public class ModelTabeleProizvodi extends AbstractTableModel {

    private List<Proizvod> proizvodi;

    private String[] kolone = new String[]{"Naziv proizvoda", "Opis"};

    public ModelTabeleProizvodi(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    @Override
    public int getRowCount() {
        return proizvodi.size();

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
        Proizvod p = proizvodi.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return p.getNazivProizvoda();
            case 1:
                return p.getOpis();
            default:
                return "";
        }
    }
    
    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void obrisiProizvod(Proizvod proizvod) {
        proizvodi.remove(proizvod);
        fireTableDataChanged();
    }

    public void dodajProizvod(Proizvod proizvod) {
        proizvodi.add(proizvod);
        fireTableDataChanged();
    }

    public Proizvod vratiProizvod(int red) {
        return proizvodi.get(red);
    }

}
