/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.StavkaPorudzbenice;
import domen.Proizvod;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mina
 */
public class ModelTabeleStavke extends AbstractTableModel {

    private List<StavkaPorudzbenice> stavke;

    private String[] kolone = new String[]{"RB","Naziv proizvoda", "Opis", "Količina", "Cena", "Ukupno"};

    public ModelTabeleStavke() {
        this.stavke = new LinkedList<>();
    }

    public ModelTabeleStavke(List<StavkaPorudzbenice> stavke) {
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
        StavkaPorudzbenice c = stavke.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getRedniBroj();
            case 1:
                return c.getProizvod().getNazivProizvoda();
            case 2:
                return c.getProizvod().getOpis();
            case 3:
                return c.getKolicina();
            case 4:
                return c.getCenaProizvoda();
            case 5:
                return c.getCenaProizvoda()*c.getKolicina();
            default:
                return "";
        }
    }

    public List<StavkaPorudzbenice> getStavke() {
        return stavke;
    }

    public void obrisiStavkaPorudzbenice(int red) {
        stavke.remove(red);
        
        for(int i=0 ; i<stavke.size(); i++){
            stavke.get(i).setRedniBroj(i+1);
        }
        fireTableDataChanged();
    }

    public void dodajStavkaPorudzbenice(StavkaPorudzbenice stavka) throws Exception {

        for (StavkaPorudzbenice st : stavke) {
            if (st.getProizvod().getSifraProizvoda() == stavka.getProizvod().getSifraProizvoda()) {
                throw new Exception("Već ste uneli količinu za ovaj proizvod");
            }
        }
        stavka.setRedniBroj(stavke.size()+1);
        stavke.add(stavka);
        fireTableDataChanged();
    }

}
