package view;

import dao.DaoClientes;
import dao.DaoVenda;
import dao.UsuarioDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.AblCliente;
import model.AblUsuarios;
import model.AblVenda;
import util.Conversor;

public class JDlgAblVenda extends javax.swing.JDialog {

    private boolean alterar = false;

    public JDlgAblVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        configurarMascaraData();
        carregarClientes();
        carregarVendedores();

        setTitle("Venda");
        setLocationRelativeTo(null);

        desabilitar();
    }

    // Configura a máscara do campo de data
    private void configurarMascaraData() {
        try {
            MaskFormatter formatador = new MaskFormatter("##/##/####");
            formatador.install(jFmtAblData);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }

    // Atualiza o ComboBox de clientes
    private void carregarClientes() {

        jCboAblCliente.removeAllItems();

        DaoClientes clienteDAO = new DaoClientes();
        List<AblCliente> clientes = (List<AblCliente>) clienteDAO.listAll();

        for (AblCliente c : clientes) {
            String texto = c.getId_cliente() + " - " + c.getNome();
            jCboAblCliente.addItem(texto);
        }
    }

    // Atualiza o ComboBox de vendedores
    private void carregarVendedores() {

        jCboAblVendedor.removeAllItems();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<AblUsuarios> vendedores = (List<AblUsuarios>) usuarioDAO.listAll();

        for (AblUsuarios vendedor : vendedores) {
            String texto = vendedor.getMpvIdUsuarios() + " - " + vendedor.getMpvNome();
            jCboAblVendedor.addItem(texto);
        }
    }

    public void desabilitar() {

        jTxtAblID.setEnabled(false);
        jFmtAblData.setEnabled(false);
        jCboAblCliente.setEnabled(false);
        jCboAblVendedor.setEnabled(false);
        jTxtAblTotal.setEnabled(false);

        jBtnAblConfirmar.setEnabled(false);
        jBtnAblCancelar.setEnabled(false);

        jBtnAblIncluir.setEnabled(true);
        jBtnAblAlterar.setEnabled(true);
        jBtnAblExcluir.setEnabled(true);
        jBtnAblPesquisar.setEnabled(true);
    }

    public void habilitar() {

        jTxtAblID.setEnabled(false);
        jFmtAblData.setEnabled(true);
        jCboAblCliente.setEnabled(true);
        jCboAblVendedor.setEnabled(true);
        jTxtAblTotal.setEnabled(true);

        jBtnAblConfirmar.setEnabled(true);
        jBtnAblCancelar.setEnabled(true);

        jBtnAblIncluir.setEnabled(false);
        jBtnAblAlterar.setEnabled(false);
        jBtnAblExcluir.setEnabled(false);
        jBtnAblPesquisar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCboAblCliente = new javax.swing.JComboBox<>();
        jTxtAblID = new javax.swing.JTextField();
        jFmtAblData = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCboAblVendedor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTxtAblTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jBtnAblIncluirTelinha = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jBtnAblIncluir = new javax.swing.JButton();
        jBtnAblAlterar = new javax.swing.JButton();
        jBtnAblConfirmar = new javax.swing.JButton();
        jBtnAblExcluir = new javax.swing.JButton();
        jBtnAblPesquisar = new javax.swing.JButton();
        jBtnAblCancelar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Numero_Pedido");

        jLabel2.setText("Data");

        jCboAblCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTxtAblID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAblIDActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente");

        jLabel4.setText("Vendedor");

        jCboAblVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCboAblVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboAblVendedorActionPerformed(evt);
            }
        });

        jLabel5.setText("Total");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod", "Produtos", "Qtd.", "Valor Unit.", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jBtnAblIncluirTelinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir_1.png"))); // NOI18N
        jBtnAblIncluirTelinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAblIncluirTelinhaActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N

        jBtnAblIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnAblIncluir.setText("Incluir");
        jBtnAblIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAblIncluirActionPerformed(evt);
            }
        });

        jBtnAblAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAblAlterar.setText("Alterar");
        jBtnAblAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAblAlterarActionPerformed(evt);
            }
        });

        jBtnAblConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gravar.png"))); // NOI18N
        jBtnAblConfirmar.setText("Confirmar");
        jBtnAblConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAblConfirmarActionPerformed(evt);
            }
        });

        jBtnAblExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnAblExcluir.setText("Excluir");
        jBtnAblExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAblExcluirActionPerformed(evt);
            }
        });

        jBtnAblPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jBtnAblPesquisar.setText("Pesquisar");
        jBtnAblPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAblPesquisarActionPerformed(evt);
            }
        });

        jBtnAblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnAblCancelar.setText("Cancelar");
        jBtnAblCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAblCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTxtAblID)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jFmtAblData, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCboAblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jCboAblVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jBtnAblIncluirTelinha, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtAblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jBtnAblIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAblAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAblExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAblConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAblCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAblPesquisar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtAblID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtAblData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboAblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboAblVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtAblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jBtnAblIncluirTelinha, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnAblCancelar)
                        .addComponent(jBtnAblPesquisar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnAblExcluir)
                        .addComponent(jBtnAblConfirmar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnAblIncluir)
                        .addComponent(jBtnAblAlterar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtAblIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAblIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAblIDActionPerformed

    private void jBtnAblIncluirTelinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAblIncluirTelinhaActionPerformed
        // TODO add your handling code here:
         JDlgAblItemVenda telinha = new JDlgAblItemVenda(null, true);
          telinha.setVisible(true);
    }//GEN-LAST:event_jBtnAblIncluirTelinhaActionPerformed

    private void jBtnAblIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAblIncluirActionPerformed
        // TODO add your handling code here:
         alterar = false;
          habilitar();

    }//GEN-LAST:event_jBtnAblIncluirActionPerformed

    private void jBtnAblAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAblAlterarActionPerformed
        alterar = true;
    habilitar();

    int id = Integer.parseInt(
            JOptionPane.showInputDialog("Informe o número do pedido"));

    DaoVenda dao = new DaoVenda();

    AblVenda venda = (AblVenda) dao.list(id);

    if (venda != null) {

       jTxtAblID.setText(String.valueOf(venda.getIdPedido()));
        if (venda.getData() != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            jFmtAblData.setText(sdf.format(venda.getData()));
        }
        jTxtAblTotal.setText(String.valueOf(venda.getTotal()));
        //Selecionar cliente
        for (int i = 0; i < jCboAblCliente.getItemCount(); i++) {
            if (jCboAblCliente.getItemAt(i).startsWith(venda.getIdCliente() + "-")) {
                jCboAblCliente.setSelectedIndex(i);
                break;
            }
        }

        //Selecionar vendedor
        for (int i = 0; i < jCboAblVendedor.getItemCount(); i++) {
            if (jCboAblVendedor.getItemAt(i).startsWith(venda.getIdVendedor() + "-")) {
                jCboAblVendedor.setSelectedIndex(i);
                break;
            }
        }

    } else {

        JOptionPane.showMessageDialog(this, "Venda não encontrada.");

        desabilitar();
        alterar = false;
    }

    }//GEN-LAST:event_jBtnAblAlterarActionPerformed

    private void jBtnAblConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAblConfirmarActionPerformed

AblVenda registroVenda = new AblVenda();

if (alterar) {
    registroVenda.setIdPedido(Integer.valueOf(jTxtAblID.getText()));
}

// Recupera os IDs selecionados nos ComboBox
String[] dadosCliente = jCboAblCliente.getSelectedItem().toString().split("-");
String[] dadosVendedor = jCboAblVendedor.getSelectedItem().toString().split("-");

// Preenche os dados da venda
registroVenda.setIdCliente(Integer.parseInt(dadosCliente[0].trim()));
registroVenda.setIdVendedor(Integer.parseInt(dadosVendedor[0].trim()));
registroVenda.setData(Conversor.TextoToDate(jFmtAblData.getText()));
registroVenda.setTotal(Double.valueOf(jTxtAblTotal.getText()));

DaoVenda vendaDAO = new DaoVenda();

if (alterar) {

    vendaDAO.update(registroVenda);

    JOptionPane.showMessageDialog(
            this,
            "Venda alterada com sucesso."
    );

} else {

    boolean gravou = vendaDAO.insert(registroVenda);

    if (gravou) {
        JOptionPane.showMessageDialog(
                this,
                "Venda cadastrada com sucesso!"
        );
    } else {
        JOptionPane.showMessageDialog(
                this,
                "Erro ao cadastrar venda."
        );
    }
}

// Retorna o formulário ao estado inicial
alterar = false;
desabilitar();
    }//GEN-LAST:event_jBtnAblConfirmarActionPerformed

    private void jBtnAblExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAblExcluirActionPerformed
          int id = Integer.parseInt(
            JOptionPane.showInputDialog("Informe o número do pedido"));

    DaoVenda dao = new DaoVenda();

    AblVenda venda = (AblVenda) dao.list(id);

    if (venda != null) {

        int resp = JOptionPane.showConfirmDialog(
                this,
                "Deseja excluir esta venda?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {

            dao.delete(venda);

            JOptionPane.showMessageDialog(this,
                    "Venda excluída com sucesso.");

        }

    } else {

        JOptionPane.showMessageDialog(this,
                "Venda não encontrada.");

    }


    }//GEN-LAST:event_jBtnAblExcluirActionPerformed

    private void jBtnAblPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAblPesquisarActionPerformed
       JDlgAblVendaList telaListar = new JDlgAblVendaList(null, true);
        telaListar.setVisible(true);
    }//GEN-LAST:event_jBtnAblPesquisarActionPerformed

    private void jBtnAblCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAblCancelarActionPerformed
        // TODO add your handling code here:jTxtCodigo.setEnabled(true);
        //desabilitar();
        desabilitar();
    }//GEN-LAST:event_jBtnAblCancelarActionPerformed

    private void jCboAblVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboAblVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboAblVendedorActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgAblVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgAblVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgAblVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgAblVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgAblVenda dialog = new JDlgAblVenda(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAblAlterar;
    private javax.swing.JButton jBtnAblCancelar;
    private javax.swing.JButton jBtnAblConfirmar;
    private javax.swing.JButton jBtnAblExcluir;
    private javax.swing.JButton jBtnAblIncluir;
    private javax.swing.JButton jBtnAblIncluirTelinha;
    private javax.swing.JButton jBtnAblPesquisar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jCboAblCliente;
    private javax.swing.JComboBox<String> jCboAblVendedor;
    private javax.swing.JFormattedTextField jFmtAblData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTxtAblID;
    private javax.swing.JTextField jTxtAblTotal;
    // End of variables declaration//GEN-END:variables
}
