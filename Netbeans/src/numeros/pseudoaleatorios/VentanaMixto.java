package numeros.pseudoaleatorios;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaMixto extends javax.swing.JFrame {
    public static DefaultTableModel modelo;

    public VentanaMixto() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Numeros Pseudoaleatorios");
        modelo = new DefaultTableModel();
        String[] columns = {"n","Numeros Pseudoaleatorios"};
        modelo.setColumnIdentifiers(columns);
        tblSecuencia.setModel(modelo);
    }
    
    public static double[] getTableData (JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount();
        int nColumn = dtm.getColumnCount();
        double[] tableData = new double[nRow];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++) {
                tableData[i] = (double)dtm.getValueAt(i, j);
            } 
        }
        return tableData;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSecuencia = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        btnPruebas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Generacion de Numeros Pseudoaleatorios");

        jLabel2.setText("Ingresar cantidad de numeros pseudoaleatorios que desee.");

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        tblSecuencia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblSecuencia);

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnPruebas.setText("Pruebas");
        btnPruebas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPruebas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnAtras))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtras)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPruebas))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if(Integer.parseInt(txtCantidad.getText())> 0 && Integer.parseInt(txtCantidad.getText())>0){
            Semilla.Iniciar();
                                   
            modelo = new DefaultTableModel();
            String[] columnas = {"Numeros Pseudoaleatorios"};
            modelo.setColumnIdentifiers(columnas);
            
            String cadena = "";
            int semilla = 5;
            int multiplicador = 81;
            int modulo = 100;
            int constante = 89;
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            int copiaSemilla = semilla;
            
            for (int i = 0; i < cantidad; i++) {
                    semilla = ((semilla*multiplicador)+constante)%modulo;
                    cadena = semilla + "";
                    semilla = Integer.parseInt(cadena);
                    modelo.addRow(new Object[]{(double) semilla/modulo});
                    
                    if (semilla == copiaSemilla) {
                        JOptionPane.showMessageDialog(rootPane, "la semilla inicial \"" + copiaSemilla + "\" se repite en : " + i);
                        break;
                    }
                    if (Semilla.esVacio()) {
                        Semilla.Agregar(cadena);
                    } else {
                        if (!Semilla.siExiste(cadena)) {
                            Semilla.Agregar(cadena);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "la semilla inicial se repite en " + i);
                            break;
                        }
                    }
            }
            tblSecuencia.setModel(modelo);            
        }else if(txtCantidad.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "No debes dejar algun campo vacio.");
        }else if(Integer.parseInt(txtCantidad.getText()) <= 0){
            JOptionPane.showMessageDialog(rootPane, "Verificar dato");
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        txtCantidad.setText("");
        modelo = new DefaultTableModel();
        VentanaOpciones opcion = new VentanaOpciones();
        opcion.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnPruebasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebasActionPerformed
        Pruebas p = new Pruebas();
            p.pruebaPromedios(getTableData(tblSecuencia));
            p.pruebaChiCuadrada(getTableData(tblSecuencia));
            p.pruebaKolmogorov(getTableData(tblSecuencia));
            p.pruebaCorridas(getTableData(tblSecuencia));
            p.pruebaHuecos(getTableData(tblSecuencia), 3);
            p.pruebaPoker(getTableData(tblSecuencia));
            p.pruebaAutocorrelacion(getTableData(tblSecuencia));
    }//GEN-LAST:event_btnPruebasActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaMixto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMixto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMixto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMixto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMixto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnPruebas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSecuencia;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
