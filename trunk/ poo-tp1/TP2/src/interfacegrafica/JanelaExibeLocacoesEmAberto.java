/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaExibeLocacoesEmAberto.java
 *
 * Created on 22/11/2011, 15:17:24
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
public class JanelaExibeLocacoesEmAberto extends javax.swing.JFrame {

    /** Creates new form JanelaExibeLocacoesEmAberto */
    public JanelaExibeLocacoesEmAberto() {
        initComponents();
        
    }
    
    private void tabelaExibeLocacoesEmAberto(){     //FALTAR CALCULAR O PERÍODO!
        int x = 0;
        Data inicio = new Data();
        Data fim = new Data();
        JOptionPane.showMessageDialog(this, campoFimDia.getText());
        fim.setDia(Integer.parseInt(campoFimDia.getText()));
        fim.setMes(Integer.parseInt(campoFimMes.getText()));
        fim.setAno(Integer.parseInt(campoFimAno.getText()));
        inicio.setDia(Integer.parseInt(campoInicioDia.getText()));
        inicio.setMes(Integer.parseInt(campoInicioMes.getText()));
        inicio.setAno(Integer.parseInt(campoInicioAno.getText()));
        Locacao loc1 = new Locacao(0, 0, 0);
        Locacao loc2;
        List lista = new ArrayList<Locacao>();

        TelaLogin.em.getTransaction().begin();
        Query query = TelaLogin.em.createQuery("from Locacao l where l.alugado = :alugado");
        query.setParameter("alugado", Boolean.parseBoolean("true"));
        lista = query.getResultList();
        TelaLogin.em.getTransaction().commit();

        if (lista.size() == 0) {
            JOptionPane.showMessageDialog(this, "Não há locações em aberto", "Erro", 0);
        } else {
            for (int i = 0; i < lista.size(); i++) {
                loc2 = (Locacao) lista.get(i);
                if (verificaDiasLocacaoAberta(loc2, inicio, fim) == true) {
                    tabelaLocacoesEmAberto.setValueAt(loc2.getId(), x, 0);
                    tabelaLocacoesEmAberto.setValueAt(loc2.getValor(), x, 1);
                    tabelaLocacoesEmAberto.setValueAt(loc2.getKmSaida(), x, 2);
                    tabelaLocacoesEmAberto.setValueAt(loc2.getTipoVeiculo(), x, 3);
                    tabelaLocacoesEmAberto.setValueAt(concatenarData(loc2.getDiaEntrada(), loc2.getMesEntrada(), loc2.getAnoEntrada()), x, 4);
                    tabelaLocacoesEmAberto.setValueAt(loc2.getPrevisaoDias(), x, 5);
                    x++;
                }
            }
        }
    }
    
    private String concatenarData (int dia,int mes,int ano) {
        String result = "";
        result = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano);
        return result;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLocacoesEmAberto = new javax.swing.JTable();
        botaoOK = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoInicioDia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoFimDia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botaoConfirmar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        campoInicioMes = new javax.swing.JTextField();
        campoInicioAno = new javax.swing.JTextField();
        campoFimMes = new javax.swing.JTextField();
        campoFimAno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Locações em aberto"));

        tabelaLocacoesEmAberto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Valor", "Km de Saida", "Tipo veiculo", "Data saída", "Previsao de dias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaLocacoesEmAberto.setEnabled(false);
        tabelaLocacoesEmAberto.setOpaque(false);
        jScrollPane1.setViewportView(tabelaLocacoesEmAberto);
        tabelaLocacoesEmAberto.getColumnModel().getColumn(0).setPreferredWidth(2);
        tabelaLocacoesEmAberto.getColumnModel().getColumn(1).setPreferredWidth(5);
        tabelaLocacoesEmAberto.getColumnModel().getColumn(4).setPreferredWidth(7);
        tabelaLocacoesEmAberto.getColumnModel().getColumn(5).setPreferredWidth(2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoOK.setText("OK");
        botaoOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOKActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Início do período");

        jLabel2.setText("Fim do período");

        jLabel3.setText("dd/mm/aaaa");

        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });

        botaoLimpar.setText("Limpar");

        campoInicioMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoInicioMesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoCancelar)
                                .addGap(750, 750, 750)
                                .addComponent(botaoOK, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campoFimDia, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoInicioDia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoFimMes, 0, 0, Short.MAX_VALUE)
                            .addComponent(campoInicioMes, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoFimAno, 0, 0, Short.MAX_VALUE)
                            .addComponent(campoInicioAno, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(botaoLimpar)
                .addGap(149, 149, 149)
                .addComponent(botaoConfirmar)
                .addGap(372, 372, 372))
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel3)
                .addContainerGap(641, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoInicioDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoInicioMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoInicioAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoFimDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFimMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFimAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoLimpar))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoOK))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOKActionPerformed
        dispose();
    }//GEN-LAST:event_botaoOKActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        tabelaExibeLocacoesEmAberto();
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    private void campoInicioMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoInicioMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoInicioMesActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaExibeLocacoesEmAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaExibeLocacoesEmAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaExibeLocacoesEmAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaExibeLocacoesEmAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JanelaExibeLocacoesEmAberto().setVisible(true);
            }
        });
    }
    
    private boolean verificaDiasLocacaoAberta(Locacao loc, Data inicio, Data fim) {
        // Verificando se a data de saida do veiculo é menor do que a data de início do período
        if (loc.getAnoEntrada() < inicio.getAno() || (loc.getAnoEntrada() == inicio.getAno() && loc.getMesEntrada() < inicio.getMes())
                || (loc.getAnoEntrada() == inicio.getAno() && loc.getMesEntrada() == inicio.getMes() && loc.getDiaEntrada() < inicio.getMes())) {
            if (loc.getAnoSaida() > fim.getAno() || (loc.getAnoSaida() == fim.getAno() && loc.getMesSaida() > fim.getMes())
                    || (loc.getAnoSaida() == fim.getAno() && loc.getMesSaida() == fim.getMes() && loc.getDiaSaida() > fim.getDia())) {
                return true;
            }
        }

        // Verifica se a data de saida do veículo está no meio do período informado
        if (loc.getAnoSaida() > inicio.getAno() || (loc.getAnoSaida() == inicio.getAno() && loc.getMesSaida() > inicio.getMes())
                || (loc.getAnoSaida() == inicio.getAno() && loc.getMesSaida() == inicio.getMes() && loc.getDiaSaida() > inicio.getDia())) {
            if (loc.getAnoSaida() < fim.getAno() || (loc.getAnoSaida() == fim.getAno() && loc.getMesSaida() < fim.getMes())
                    || (loc.getAnoSaida() == fim.getAno() && loc.getMesSaida() == fim.getMes() && loc.getDiaSaida() < fim.getMes())) {
                return true;
            }
        }

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoOK;
    private javax.swing.JTextField campoFimAno;
    private javax.swing.JTextField campoFimDia;
    private javax.swing.JTextField campoFimMes;
    private javax.swing.JTextField campoInicioAno;
    private javax.swing.JTextField campoInicioDia;
    private javax.swing.JTextField campoInicioMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLocacoesEmAberto;
    // End of variables declaration//GEN-END:variables
}
