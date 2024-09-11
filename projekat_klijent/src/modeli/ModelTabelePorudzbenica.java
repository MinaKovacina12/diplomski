/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Cenovnik;
import domen.Dobavljac;
import domen.Porudzbenica;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mina
 */
public class ModelTabelePorudzbenica extends AbstractTableModel {

    private List<Porudzbenica> lista;

    private String[] kolone = new String[]{"Datum", "Ukupno proizvoda", "Menadžer", "Dobavljač", "Status"};

    public ModelTabelePorudzbenica(List<Porudzbenica> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
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
        Porudzbenica d = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return sdf.format(d.getDatum());
            case 1:
                return d.getUkupnoProizvoda();
            case 2:
                return d.getMenadzer().getImeMenadzera() + d.getMenadzer().getPrezimeMenadzera();
            case 3:
                return d.getDobavljac().getNazivDobavljaca();
            case 4:
                return d.getStatus();
            default:
                return "";
        }
    }

    public List<Porudzbenica> getPorudzbenica() {
        return lista;
    }

    public void obrisiPorudzbenicu(Porudzbenica porudzbenica) {
        lista.remove(porudzbenica);
        fireTableDataChanged();
    }

    public void dodajPorudzbenicu(Porudzbenica porudzbenica) {
        lista.add(porudzbenica);
        fireTableDataChanged();
    }

    public Porudzbenica vratiPorudzbenicu(int red) {
        return lista.get(red);
    }
    
     public void setPorudzbenica(List<Porudzbenica> porudzbenice) {
        this.lista = porudzbenice;
        fireTableDataChanged();
    }

}
