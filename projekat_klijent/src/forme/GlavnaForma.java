/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import controller.ClientController;
import domen.Porudzbenica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modeli.ModelTabelePorudzbenica;
import modeli.ModelTabeleStavkaPorudzbenice;


/**
 *
 * @author Mina
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    List<Porudzbenica> porudzbenice = new ArrayList<>();

    public GlavnaForma() {
        initComponents();

        setLocationRelativeTo(null);

        popuniTabele();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPorudzbenice = new javax.swing.JTable();
        btnIzmeni = new javax.swing.JButton();
        btnKreiraj = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStavkePorudzbenice = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnObradi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnPonisti = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MeniPretragaDobavljac = new javax.swing.JMenuItem();
        MeniKreirajDobavljac = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MeniPretragaProizvod = new javax.swing.JMenuItem();
        MeniKreirajProizvod = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("PORUDŽBENICA");

        tblPorudzbenice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPorudzbenice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPorudzbeniceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPorudzbenice);

        btnIzmeni.setText("IZMENI");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnKreiraj.setText("KREIRAJ");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        tblStavkePorudzbenice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblStavkePorudzbenice);

        jLabel2.setText("STAVKE PORUDŽBENICE");

        btnObradi.setText("OBRADI");
        btnObradi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObradiActionPerformed(evt);
            }
        });

        jLabel3.setText("Pretraži po nazivu dobavljača:");

        btnPretrazi.setText("PRETRAŽI");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnPonisti.setText("PONIŠTI");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        jMenu2.setText("DOBAVLJAČ");

        MeniPretragaDobavljac.setText("Pretraga");
        MeniPretragaDobavljac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeniPretragaDobavljacMouseClicked(evt);
            }
        });
        MeniPretragaDobavljac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniPretragaDobavljacActionPerformed(evt);
            }
        });
        jMenu2.add(MeniPretragaDobavljac);

        MeniKreirajDobavljac.setText("Kreiraj");
        MeniKreirajDobavljac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeniKreirajDobavljacMouseClicked(evt);
            }
        });
        MeniKreirajDobavljac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniKreirajDobavljacActionPerformed(evt);
            }
        });
        jMenu2.add(MeniKreirajDobavljac);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("PROIZVOD");

        MeniPretragaProizvod.setText("Pretraga");
        MeniPretragaProizvod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeniPretragaProizvodMouseClicked(evt);
            }
        });
        MeniPretragaProizvod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniPretragaProizvodActionPerformed(evt);
            }
        });
        jMenu3.add(MeniPretragaProizvod);

        MeniKreirajProizvod.setText("Kreiraj");
        MeniKreirajProizvod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeniKreirajProizvodMouseClicked(evt);
            }
        });
        MeniKreirajProizvod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniKreirajProizvodActionPerformed(evt);
            }
        });
        jMenu3.add(MeniKreirajProizvod);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("CENOVNIK");

        jMenuItem1.setText("Unesi");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btnKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btnObradi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(210, 210, 210)
                                        .addComponent(jLabel1)))
                                .addGap(18, 18, 18)
                                .addComponent(btnPretrazi)
                                .addGap(18, 18, 18)
                                .addComponent(btnPonisti, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi)
                    .addComponent(btnPonisti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnKreiraj)
                    .addComponent(btnObradi))
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MeniPretragaDobavljacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniPretragaDobavljacActionPerformed
        // TODO add your handling code here:
        new DobavljacPretragaForma(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_MeniPretragaDobavljacActionPerformed

    private void MeniKreirajDobavljacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniKreirajDobavljacActionPerformed
        // TODO add your handling code here:
        new DobavljacKreirajForma(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_MeniKreirajDobavljacActionPerformed

    private void MeniPretragaProizvodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniPretragaProizvodActionPerformed
        // TODO add your handling code here:
        new ProizvodPretragaForma(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_MeniPretragaProizvodActionPerformed

    private void MeniKreirajProizvodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniKreirajProizvodActionPerformed
        // TODO add your handling code here:
        new ProizvodKreirajForma(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_MeniKreirajProizvodActionPerformed

    private void MeniPretragaDobavljacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniPretragaDobavljacMouseClicked

    }//GEN-LAST:event_MeniPretragaDobavljacMouseClicked

    private void MeniKreirajDobavljacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniKreirajDobavljacMouseClicked

    }//GEN-LAST:event_MeniKreirajDobavljacMouseClicked

    private void MeniPretragaProizvodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniPretragaProizvodMouseClicked

    }//GEN-LAST:event_MeniPretragaProizvodMouseClicked

    private void MeniKreirajProizvodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniKreirajProizvodMouseClicked

    }//GEN-LAST:event_MeniKreirajProizvodMouseClicked

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        new PorudzbenicaKreirajForma(this, rootPaneCheckingEnabled).setVisible(true);

    }//GEN-LAST:event_btnKreirajActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new CenovnikKreirajForma(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tblPorudzbeniceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPorudzbeniceMouseClicked

        try {
            int red = tblPorudzbenice.getSelectedRow();
            if (red == -1) {
                JOptionPane.showMessageDialog(rootPane, "Niste izabrali porudžbenicu za izmenu");
                return;
            }
            // Dobavljac dob = ((ModelTabeleDobavljaci)tblPorudzbenice.getModel()).vratiDobavljaca(red);
            // new DobavljacKreirajForma(null, true, dob).setVisible(true);
            Porudzbenica por = ((ModelTabelePorudzbenica) tblPorudzbenice.getModel()).vratiPorudzbenicu(red);
            Porudzbenica porudzbenica = ClientController.getInstanca().ucitajPorudzbenicu(por);
            ModelTabeleStavkaPorudzbenice mtsp = new ModelTabeleStavkaPorudzbenice(porudzbenica.getStavke());
            tblStavkePorudzbenice.setModel(mtsp);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_tblPorudzbeniceMouseClicked

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        try {
            int red = tblPorudzbenice.getSelectedRow();
            if (red == -1) {
                JOptionPane.showMessageDialog(rootPane, "Sistem ne može da učita porudžbenicu");
                return;
            }

            Porudzbenica por = ((ModelTabelePorudzbenica) tblPorudzbenice.getModel()).vratiPorudzbenicu(red);

            if (por.getStatus().equals(Porudzbenica.KONACNA)) {
                JOptionPane.showMessageDialog(rootPane, "Porudžbenica je konačna, ne može se izmeniti");
                return;
            }

            JOptionPane.showMessageDialog(rootPane, "Sistem je učitao porudžbenicu");
            new PorudzbenicaKreirajForma(this, rootPaneCheckingEnabled, por).setVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        popuniTabele();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnObradiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObradiActionPerformed
        try {
            int red = tblPorudzbenice.getSelectedRow();
            if (red == -1) {
                JOptionPane.showMessageDialog(rootPane, "Sistem ne može da učita porudžbenicu");
                return;
            }

            Porudzbenica por = ((ModelTabelePorudzbenica) tblPorudzbenice.getModel()).vratiPorudzbenicu(red);

            if (por.getStatus().equals(Porudzbenica.KONACNA)) {
                JOptionPane.showMessageDialog(rootPane, "Porudžbenica je konačna, ne može se ponovo obraditi");
                return;
            }
            
            

            JOptionPane.showMessageDialog(rootPane, "Sistem je učitao porudžbenicu");

            Porudzbenica porudzbenica = ClientController.getInstanca().ucitajPorudzbenicu(por);

            porudzbenica.setStatus(Porudzbenica.KONACNA);
            
            try {
                ClientController.getInstanca().obradi(porudzbenica);
                JOptionPane.showMessageDialog(rootPane, "Dokument je uspesno generisan. Email je poslat!");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(rootPane, exception.getMessage());
            }
            
            
            //ClientController.getInstanca().zapamtiPorudzbenicu(porudzbenica);

           

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }//GEN-LAST:event_btnObradiActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        try {
            String pretraga = txtPretraga.getText();

            List<Porudzbenica> pretrazenePorudzbenice = new ArrayList<>();
            ModelTabelePorudzbenica mtp = (ModelTabelePorudzbenica) tblPorudzbenice.getModel();

            if (pretraga.equals("")) {
                mtp.setPorudzbenica(porudzbenice);
                return;
            } else {

                for (Porudzbenica porudzbenica : porudzbenice) {
                  
                    if (porudzbenica.getDobavljac().getNazivDobavljaca().toLowerCase().contains(pretraga.toLowerCase())) {
                    
                     
                          pretrazenePorudzbenice.add(porudzbenica);
                    }
                    
                }
                mtp.setPorudzbenica(pretrazenePorudzbenice);

            }
                     if(pretrazenePorudzbenice.isEmpty()){
                        JOptionPane.showMessageDialog(rootPane, "Nije pronađena porudžbenica prema zadatom kriterijumu");
                        return;
                    }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiActionPerformed
        try {

            txtPretraga.setText("");

            ModelTabelePorudzbenica mtp = (ModelTabelePorudzbenica) tblPorudzbenice.getModel();
            mtp.setPorudzbenica(porudzbenice);

            // Takođe, može biti korisno resetovati pretragu i osvežiti tabelu
            tblPorudzbenice.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_btnPonistiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlavnaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MeniKreirajDobavljac;
    private javax.swing.JMenuItem MeniKreirajProizvod;
    private javax.swing.JMenuItem MeniPretragaDobavljac;
    private javax.swing.JMenuItem MeniPretragaProizvod;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObradi;
    private javax.swing.JButton btnPonisti;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tblPorudzbenice;
    private javax.swing.JTable tblStavkePorudzbenice;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    private void popuniTabele() {
        try {

            porudzbenice = ClientController.getInstanca().ucitajPorudzbenice();
            ModelTabelePorudzbenica mtp = new ModelTabelePorudzbenica(porudzbenice);
            tblPorudzbenice.setModel(mtp);

            ModelTabeleStavkaPorudzbenice mtsp = new ModelTabeleStavkaPorudzbenice(new ArrayList<>());
            tblStavkePorudzbenice.setModel(mtsp);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }
}
