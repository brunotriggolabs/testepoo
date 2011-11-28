/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExibeLocacoesFinalizadas.java
 *
 * Created on 28/11/2011, 13:28:26
 */
package interfacegrafica;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Data;
import modelo.Locacao;

/**
 *
 * @author samuel
 */
import org.apache.log4j.Logger;
public class ExibeLocacoesFinalizadas extends javax.swing.JFrame {
    private static Logger logger = Logger.getLogger(ExibeLocacoesFinalizadas.class);
    /** Creates new form ExibeLocacoesFinalizadas */
    public ExibeLocacoesFinalizadas() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoDiaPeriodo = new javax.swing.JTextField();
        campoMesInicio = new javax.swing.JTextField();
        campoAnoInicio = new javax.swing.JTextField();
        campoDiaFIm = new javax.swing.JTextField();
        campoMesFim = new javax.swing.JTextField();
        campoFimAno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botaoLimparCampos = new javax.swing.JButton();
        botaoEnviarPeriodos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLocacoesFinalizadas = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Início Período:");

        jLabel2.setText("Fim Período:");

        campoDiaPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDiaPeriodoActionPerformed(evt);
            }
        });

        campoMesInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMesInicioActionPerformed(evt);
            }
        });

        campoDiaFIm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDiaFImActionPerformed(evt);
            }
        });

        jLabel3.setText("dd/mm/aaaa");

        botaoLimparCampos.setText("Limpar");
        botaoLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparCamposActionPerformed(evt);
            }
        });

        botaoEnviarPeriodos.setText("Enviar");
        botaoEnviarPeriodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEnviarPeriodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoDiaPeriodo)
                            .addComponent(campoDiaFIm, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoMesInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(campoMesFim, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoAnoInicio)
                            .addComponent(campoFimAno, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(623, 623, 623))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoLimparCampos)
                        .addGap(18, 18, 18)
                        .addComponent(botaoEnviarPeriodos))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel3)
                .addContainerGap(492, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoAnoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoFimAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDiaFIm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoMesFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoDiaPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoLimparCampos)
                    .addComponent(botaoEnviarPeriodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tabelaLocacoesFinalizadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Valor", "Km Saida", "Km Entrada", "Data Saída", "Data Entrada", "Tipo Veiculo", "Tipo Locacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaLocacoesFinalizadas);

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoMesInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMesInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMesInicioActionPerformed

    private void campoDiaFImActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDiaFImActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDiaFImActionPerformed

    private void campoDiaPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDiaPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDiaPeriodoActionPerformed

    private void botaoEnviarPeriodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEnviarPeriodosActionPerformed
        logger.info("O usuário " + InterfaceGrafica.login + " exibiu as locações finalizadas.");
        exibeTabela();
    }//GEN-LAST:event_botaoEnviarPeriodosActionPerformed

    private void botaoLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparCamposActionPerformed
        campoAnoInicio.setText("");
        campoMesInicio.setText("");
        campoDiaPeriodo.setText("");
        campoDiaFIm.setText("");
        campoMesFim.setText("");
        campoFimAno.setText("");
    }//GEN-LAST:event_botaoLimparCamposActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ExibeLocacoesFinalizadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExibeLocacoesFinalizadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExibeLocacoesFinalizadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExibeLocacoesFinalizadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ExibeLocacoesFinalizadas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEnviarPeriodos;
    private javax.swing.JButton botaoLimparCampos;
    private javax.swing.JTextField campoAnoInicio;
    private javax.swing.JTextField campoDiaFIm;
    private javax.swing.JTextField campoDiaPeriodo;
    private javax.swing.JTextField campoFimAno;
    private javax.swing.JTextField campoMesFim;
    private javax.swing.JTextField campoMesInicio;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLocacoesFinalizadas;
    // End of variables declaration//GEN-END:variables
    
    private void exibeTabela() {
        int x = 0;
        Data inicio = new Data();
        Data fim = new Data();
        
        fim.setDia(Integer.parseInt(campoDiaFIm.getText()));
        fim.setMes(Integer.parseInt(campoMesFim.getText()));
        fim.setAno(Integer.parseInt(campoFimAno.getText()));
        inicio.setDia(Integer.parseInt(campoDiaPeriodo.getText()));
        inicio.setMes(Integer.parseInt(campoMesInicio.getText()));
        inicio.setAno(Integer.parseInt(campoAnoInicio.getText()));
        Locacao loc2;
        List lista = new ArrayList<Locacao>();

        TelaLogin.em.getTransaction().begin();
        Query query = TelaLogin.em.createQuery("from Locacao l where l.finalizado = :finalizado");
        query.setParameter("finalizado", Boolean.parseBoolean("true"));
        lista = query.getResultList();
        TelaLogin.em.getTransaction().commit();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há locações em aberto", "Erro", 0);
        } else {
            for (int i = 0; i < lista.size(); i++) {
                loc2 = (Locacao) lista.get(i);
                System.out.println("i = " + i);
                if (verificarDiasLocacaoFinalizada(loc2, inicio, fim) == true) {
                    tabelaLocacoesFinalizadas.setValueAt(loc2.getId(), x, 0);
                    tabelaLocacoesFinalizadas.setValueAt(loc2.getValor(), x, 1);
                    tabelaLocacoesFinalizadas.setValueAt(loc2.getKmSaida(), x, 2);
                    tabelaLocacoesFinalizadas.setValueAt(loc2.getKmEntrada(), x, 3);
                    tabelaLocacoesFinalizadas.setValueAt(concatenarData(loc2.getDiaSaida(), loc2.getMesSaida(), loc2.getAnoSaida()), x, 4);
                    tabelaLocacoesFinalizadas.setValueAt(concatenarData(loc2.getDiaEntrada(), loc2.getMesEntrada(), loc2.getAnoEntrada()), x, 5);
                    tabelaLocacoesFinalizadas.setValueAt(loc2.getTipoVeiculo(), x, 6);
                    tabelaLocacoesFinalizadas.setValueAt(loc2.getTipoLocacao(), x, 7);
                    x++;
                }
            }
        }
    }

    private boolean verificarDiasLocacaoFinalizada(Locacao loc, Data inicio, Data fim) {
        // Verifica se a data de entrada do veículo está no meio do período informado
        if (loc.getAnoEntrada() > inicio.getAno() || (loc.getAnoEntrada() == inicio.getAno() && loc.getMesEntrada() > inicio.getMes())
                || (loc.getAnoEntrada() == inicio.getAno() && loc.getMesEntrada() == inicio.getMes() && loc.getDiaEntrada() > inicio.getDia())) {
            if (loc.getAnoEntrada() < fim.getAno() || (loc.getAnoEntrada() == fim.getAno() && loc.getMesEntrada() < fim.getMes())
                    || (loc.getAnoEntrada() == fim.getAno() && loc.getMesEntrada() == fim.getMes() && loc.getDiaEntrada() < fim.getMes())) {
                return true;
            }
        }
        return false;
    }
    
    private String concatenarData (int dia,int mes,int ano) {
        String result = "";
        result = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano);
        return result;
    }
}