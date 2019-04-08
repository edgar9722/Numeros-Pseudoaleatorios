package numeros.pseudoaleatorios;

public class VentanaPruebas extends javax.swing.JFrame {
    Pruebas p = new Pruebas();

    public VentanaPruebas() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Prueba de Aleatoridad");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPromedios = new javax.swing.JButton();
        btnChi = new javax.swing.JButton();
        btnKolmogorov = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btnAutocorrelacion = new javax.swing.JButton();
        btnCorridas = new javax.swing.JButton();
        btnHuecos = new javax.swing.JButton();
        btnPoker = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setText("Prueba de Aleatoridad");

        jLabel2.setText("Da clic sobre la distribucion uniforme continua que desee.");

        btnPromedios.setText("Promedios");
        btnPromedios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromediosActionPerformed(evt);
            }
        });

        btnChi.setText("Chi Cuadrada");
        btnChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiActionPerformed(evt);
            }
        });

        btnKolmogorov.setText("Kolmogorov");
        btnKolmogorov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKolmogorovActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione una opcion para determinar la independencia estadistica.");

        btnAutocorrelacion.setText("Prueba de Autocorrelacion");
        btnAutocorrelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutocorrelacionActionPerformed(evt);
            }
        });

        btnCorridas.setText("Arriba/Debajo de la Media");
        btnCorridas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorridasActionPerformed(evt);
            }
        });

        btnHuecos.setText("Huecos");
        btnHuecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuecosActionPerformed(evt);
            }
        });

        btnPoker.setText("Poker");
        btnPoker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokerActionPerformed(evt);
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
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPromedios, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(btnChi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKolmogorov, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAutocorrelacion, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnCorridas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHuecos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnPoker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKolmogorov, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnPromedios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAutocorrelacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuecos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCorridas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPoker, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromediosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromediosActionPerformed
        p.pruebaPromedios(VentanaModelos.getTableData(VentanaModelos.tabla));
    }//GEN-LAST:event_btnPromediosActionPerformed

    private void btnChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiActionPerformed
        p.pruebaChiCuadrada(VentanaModelos.getTableData(VentanaModelos.tabla));
    }//GEN-LAST:event_btnChiActionPerformed

    private void btnKolmogorovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKolmogorovActionPerformed
        p.pruebaKolmogorov(VentanaModelos.getTableData(VentanaModelos.tabla));
    }//GEN-LAST:event_btnKolmogorovActionPerformed

    private void btnHuecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuecosActionPerformed
        p.pruebaHuecos(VentanaModelos.getTableData(VentanaModelos.tabla),3);
    }//GEN-LAST:event_btnHuecosActionPerformed

    private void btnCorridasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorridasActionPerformed
        p.pruebaCorridas(VentanaModelos.getTableData(VentanaModelos.tabla));
    }//GEN-LAST:event_btnCorridasActionPerformed

    private void btnPokerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokerActionPerformed
        p.pruebaPoker(VentanaModelos.getTableData(VentanaModelos.tabla));
    }//GEN-LAST:event_btnPokerActionPerformed

    private void btnAutocorrelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutocorrelacionActionPerformed
        p.pruebaAutocorrelacion(VentanaModelos.getTableData(VentanaModelos.tabla));
    }//GEN-LAST:event_btnAutocorrelacionActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPruebas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutocorrelacion;
    private javax.swing.JButton btnChi;
    private javax.swing.JButton btnCorridas;
    private javax.swing.JButton btnHuecos;
    private javax.swing.JButton btnKolmogorov;
    private javax.swing.JButton btnPoker;
    private javax.swing.JButton btnPromedios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
