/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EncerrarLocacao.java
 *
 * Created on 25/11/2011, 12:35:31
 */
package interfacegrafica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Locacao;
import modelo.TipoLocacao;
import modelo.Veiculo;

/**
 *
 * @author samuel
 */
public class EncerrarLocacao extends javax.swing.JFrame {

    /** Creates new form EncerrarLocacao */
    public EncerrarLocacao() {
        initComponents();
        rotuloPreco.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoPlaca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rotuloPreco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Placa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Encerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Preço:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rotuloPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rotuloPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja encerrar a locação?", "Confirmação", 0); //SIM == 0 NÃO == 1
        
        if (opcao == 0) {
            try {
                encerraLocacao();
            } catch (IOException ex) {
                Logger.getLogger(EncerrarLocacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EncerrarLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncerrarLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncerrarLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncerrarLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EncerrarLocacao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoPlaca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel rotuloPreco;
    // End of variables declaration//GEN-END:variables

    private void encerraLocacao() throws IOException {
        
        TelaLogin.em.getTransaction().begin();
        Query query = TelaLogin.em.createQuery("from Locacao l where l.placa = :placa and l.alugado = :true");
        query.setParameter("placa", campoPlaca.getText());
        query.setParameter("true", Boolean.parseBoolean("true"));
        
        Locacao loc = (Locacao)query.getSingleResult();
               
        
        
        if (loc.getPlaca() == null) {
            JOptionPane.showMessageDialog(this, "Não há veículos cadastrados com essa placa", "Erro", 0);
            TelaLogin.em.getTransaction().commit();
        } else {
            loc.setAlugado(false);
            loc.setFinalizado(true);
            loc.setPreco(calculoPreco(loc));
            TelaLogin.em.merge(loc);
            Query query2 = TelaLogin.em.createQuery("from Veiculo v where v.placa = :placa");
            query2.setParameter("placa", campoPlaca.getText());
            Veiculo vec = (Veiculo) query2.getSingleResult();
            vec.setDisponivel(true);
            TelaLogin.em.merge(vec);            
            TelaLogin.em.getTransaction().commit();
            rotuloPreco.setText(String.valueOf(loc.getPreco()));
            rotuloPreco.setVisible(true);
        }
    }
    
    private double calculoPreco(Locacao loc) {
        
        Query query = TelaLogin.em.createQuery("from TipoLocacao t where t.tipo = :tipo");
        query.setParameter("tipo", loc.getTipoLocacao());
        
        TipoLocacao tipoLoc = (TipoLocacao)query.getSingleResult();
        

        if (tipoLoc.getTipo() == 1) {
            double p = (loc.getKmEntrada() - loc.getKmSaida()) + (tipoLoc.getTaxaBase() * calculaDias(loc));
            loc.setPreco(p);
            return loc.getPreco();
        } else {
            loc.setPreco(tipoLoc.getTaxaBase() * calculaDias(loc));
            return loc.getPreco();
        }
    }

    private double calculaDias(Locacao loc) {
        int dias = 0;
        if (loc.getAnoSaida() == loc.getAnoEntrada()) {
            if (loc.getMesEntrada() == loc.getMesSaida()) {
                dias = (loc.getDiaEntrada() - loc.getDiaSaida());
            } else if (loc.getMesEntrada() > loc.getMesSaida()) {
                if (loc.getDiaEntrada() >= loc.getDiaSaida()) {
                    dias = ((loc.getMesEntrada() - loc.getMesSaida()) * 30) + (loc.getDiaEntrada() - loc.getDiaSaida());
                } else {
                    dias = ((loc.getMesEntrada() - loc.getMesSaida()) * 30) - (loc.getDiaEntrada() - loc.getDiaSaida());
                }
            }
        } else if (loc.getAnoSaida() < loc.getAnoEntrada()) {
            if (loc.getMesEntrada() >= loc.getMesSaida()) {
                if (loc.getDiaEntrada() >= loc.getDiaSaida()) {
                    dias = ((loc.getDiaEntrada() - loc.getAnoSaida()) * 365) + ((loc.getMesEntrada() - loc.getMesSaida()) * 30) + (loc.getDiaEntrada() - loc.getDiaSaida());
                } else {
                    dias = ((loc.getDiaEntrada() - loc.getAnoSaida()) * 365) + ((loc.getMesEntrada() - loc.getMesSaida()) * 30) - (loc.getDiaEntrada() - loc.getDiaSaida());
                }
            } else if (loc.getDiaEntrada() >= loc.getDiaSaida()) {
                dias = ((loc.getDiaEntrada() - loc.getAnoSaida()) * 365) - ((loc.getMesEntrada() - loc.getMesSaida()) * 30) + (loc.getDiaEntrada() - loc.getDiaSaida());
            } else {
                dias = ((loc.getDiaEntrada() - loc.getAnoSaida()) * 365) - ((loc.getMesEntrada() - loc.getMesSaida()) * 30) - (loc.getDiaEntrada() - loc.getDiaSaida());
            }
        } else {
            return 0;
        }
        return dias;
    }
}