/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Dobavljac;
import domen.StavkaPorudzbenice;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mina
 */
public class ModelTabeleStavkaPorudzbenice extends AbstractTableModel {

    private List<StavkaPorudzbenice> list;

    private String[] kolone = new String[]{"Redni broj", "Količina", "Proizvod", "Cena proizvoda", "Ukupno"}; 

    public ModelTabeleStavkaPorudzbenice(List<StavkaPorudzbenice> list) {
        this.list = list;
    }

    public void dodajStavku(StavkaPorudzbenice stavkaPorudzbenice) {
        stavkaPorudzbenice.setRedniBroj(list.size());
        list.add(stavkaPorudzbenice);
        fireTableDataChanged();
    }

    public void izbrisiStavku(int red) {
        list.remove(red);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setRedniBroj(i + 1);
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
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
        StavkaPorudzbenice sp = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sp.getRedniBroj();
            case 1:
                return sp.getKolicina();
            case 2:
                return sp.getProizvod().getNazivProizvoda();
            case 3:
                return sp.getCenaProizvoda();
            case 4:
                return sp.getCenaProizvoda()*sp.getKolicina();
            default:
                return "";
        }
    }

}
