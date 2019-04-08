package numeros.pseudoaleatorios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaModelos extends javax.swing.JFrame {
    public static DefaultTableModel modelo;
    public static JTable tabla;
    int numModelo;
    int pseudo[];

    public VentanaModelos() {
        initComponents();
        
        setLocationRelativeTo(this);
        setTitle("Modelos Para la Generacion de Numeros Pseudoaleatorios");
        modelo = new DefaultTableModel();
        String[] columns = {"Numeros Pseudoaleatorios"};
        modelo.setColumnIdentifiers(columns);
        tblSecuencia.setModel(modelo);
        
        if(VentanaOpciones.opcion == 1){
            btnAyuda.setVisible(true);
        }
        
        if(VentanaOpciones.opcion == 2){
            btnAyuda.setVisible(false);
        }
        
        btnGenerar.setVisible(false);
        tblSecuencia.setVisible(false);
        
        txtAleatorio.setVisible(false);
        txtAleatorio.setText("");
        lblAleatorio.setVisible(false);
        
        txtMultiplicador.setVisible(false);
        txtMultiplicador.setText("");
        lblMultiplicador.setVisible(false);
        
        txtReferencia.setVisible(false);
        txtReferencia.setText("");
        lblReferencia.setVisible(false);
        
        txtModulo.setVisible(false);
        txtModulo.setText("");
        lblModulo.setVisible(false);
        
        txtConstante.setVisible(false);
        txtConstante.setText("");
        lblConstante.setVisible(false);
    }
    
    private void guardarTabla(String ruta){
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(ruta));
            for (int i = 0 ; i < tblSecuencia.getRowCount(); i++){ //realiza un barrido por filas.
                for(int j = 0 ; j < tblSecuencia.getColumnCount();j++){ //realiza un barrido por columnas.
                    bfw.write("" + tblSecuencia.getValueAt(i,j));
                    if (j < tblSecuencia.getColumnCount() -1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        bfw.write(",");
                    }
                }
                bfw.newLine(); //inserta nueva linea.
            }

            bfw.close(); //cierra archivo!
            System.out.println("El archivo fue salvado correctamente!");
        } catch (IOException e) {
            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + e.getMessage());
        }
    }
    
    private void registrar (int num, int numerosemillas){
        pseudo=new int[num];
        for (int i = 0; i < numerosemillas; i++){
            pseudo[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor de la semilla X"+(i+1)));
        }
    }
    
    private void calcular (int num, int modulo, int numerosemillas){
        for (int i=numerosemillas;i<num;i++){
            pseudo[i]=(pseudo[i-1]+pseudo[i-numerosemillas])%modulo;
            for (int aux=0;aux<i;aux++){
                    if(pseudo[i]==pseudo[aux]){
                        JOptionPane.showMessageDialog(null, "Se repitió en la posición "+i);
                        for(int x = 0; x <= i; x++){
                          System.out.println(pseudo[x]);
                        }
                        break;
                    }
                }
        }
        mostrar(num);
    }
    
    private void mostrar (int num){
        for(int i=0;i<num;i++){
            System.out.println(pseudo[i]);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNeumann = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnProducto = new javax.swing.JButton();
        btnFactor = new javax.swing.JButton();
        btnAditivo = new javax.swing.JButton();
        btnMultiplicativo = new javax.swing.JButton();
        btnMixto = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        lblSemilla = new javax.swing.JLabel();
        txtSemilla = new javax.swing.JTextField();
        lblAleatorio = new javax.swing.JLabel();
        txtAleatorio = new javax.swing.JTextField();
        lblReferencia = new javax.swing.JLabel();
        lblMultiplicador = new javax.swing.JLabel();
        lblModulo = new javax.swing.JLabel();
        lblConstante = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        txtMultiplicador = new javax.swing.JTextField();
        txtModulo = new javax.swing.JTextField();
        txtConstante = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSecuencia = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        btnPruebas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Modelos Para la Generacion de Numeros Pseudoaleatorios");

        btnNeumann.setText("Modelo de Von Neumann");
        btnNeumann.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNeumannActionPerformed(evt);
            }
        });

        jLabel2.setText("Elije un modelo dando clic en alguno.");

        btnProducto.setText("Producto Central");
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });

        btnFactor.setText("Factor Constante");
        btnFactor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFactorActionPerformed(evt);
            }
        });

        btnAditivo.setText("Aditivo");
        btnAditivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAditivoActionPerformed(evt);
            }
        });

        btnMultiplicativo.setText("Multiplicativo");
        btnMultiplicativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplicativoActionPerformed(evt);
            }
        });

        btnMixto.setText("Mixto");
        btnMixto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMixtoActionPerformed(evt);
            }
        });

        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        lblSemilla.setText("Semilla: ");

        lblAleatorio.setText("Numero Aleatorio: ");

        lblReferencia.setText("Referencia:");

        lblMultiplicador.setText("Multiplicador: ");

        lblModulo.setText("Modulo:");

        lblConstante.setText("Constante Aditiva:");

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

        btnAtras.setText("Regresar");
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
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAyuda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMixto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNeumann, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFactor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAditivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMultiplicativo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnPruebas, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblConstante)
                                .addGap(18, 18, 18)
                                .addComponent(txtConstante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblSemilla)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblModulo)
                                        .addGap(10, 10, 10)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(lblMultiplicador)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMultiplicador, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(lblAleatorio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAleatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43))))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtReferencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(lblSemilla)
                                .addComponent(txtSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAleatorio)
                                .addComponent(txtAleatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblReferencia)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNeumann, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMultiplicador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblMultiplicador))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConstante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblModulo)
                                .addComponent(txtModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblConstante)))
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAditivo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMultiplicativo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMixto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPruebas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        numModelo = 2;
                
        btnGenerar.setVisible(true);
        tblSecuencia.setVisible(true);
        
        lblSemilla.setVisible(true);
        txtSemilla.setVisible(true);
        txtSemilla.setText("");
        
        txtAleatorio.setVisible(true);
        txtAleatorio.setText("");
        lblAleatorio.setVisible(true);
        
        txtMultiplicador.setVisible(false);
        txtMultiplicador.setText("");
        lblMultiplicador.setVisible(false);
        
        txtReferencia.setVisible(false);
        txtReferencia.setText("");
        lblReferencia.setVisible(false);
        
        txtModulo.setVisible(false);
        txtModulo.setText("");
        lblModulo.setVisible(false);
        
        txtConstante.setVisible(false);
        txtConstante.setText("");
        lblConstante.setVisible(false);
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnNeumannActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNeumannActionPerformed
        numModelo = 1;
        
        btnGenerar.setVisible(true);
        tblSecuencia.setVisible(true);
        
        lblSemilla.setVisible(true);
        txtSemilla.setText("");
        txtSemilla.setVisible(true);
        
        txtAleatorio.setVisible(false);
        txtAleatorio.setText("");
        lblAleatorio.setVisible(false);
        
        txtMultiplicador.setVisible(false);
        txtMultiplicador.setText("");
        lblMultiplicador.setVisible(false);
        
        txtReferencia.setVisible(false);
        txtReferencia.setText("");
        lblReferencia.setVisible(false);
        
        txtModulo.setVisible(false);
        txtModulo.setText("");
        lblModulo.setVisible(false);
        
        txtConstante.setVisible(false);
        txtConstante.setText("");
        lblConstante.setVisible(false);
    }//GEN-LAST:event_btnNeumannActionPerformed

    private void btnFactorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFactorActionPerformed
        numModelo = 3;
        
        btnGenerar.setVisible(true);
        tblSecuencia.setVisible(true);
        
        lblSemilla.setVisible(true);
        txtSemilla.setVisible(true);
        txtSemilla.setText("");
        
        txtAleatorio.setVisible(false);
        txtAleatorio.setText("");
        lblAleatorio.setVisible(false);
        
        txtMultiplicador.setVisible(false);
        txtMultiplicador.setText("");
        lblMultiplicador.setVisible(false);
        
        txtReferencia.setVisible(true);
        txtReferencia.setText("");
        lblReferencia.setVisible(true);
        
        txtModulo.setVisible(false);
        txtModulo.setText("");
        lblModulo.setVisible(false);
        
        txtConstante.setVisible(false);
        txtConstante.setText("");
        lblConstante.setVisible(false);
    }//GEN-LAST:event_btnFactorActionPerformed

    private void btnAditivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAditivoActionPerformed
        numModelo = 4;
        
        btnGenerar.setVisible(false);
        tblSecuencia.setVisible(true);
        
        lblSemilla.setVisible(false);
        txtSemilla.setVisible(false);
        txtSemilla.setText("");
        
        txtAleatorio.setVisible(false);
        txtAleatorio.setText("");
        lblAleatorio.setVisible(false);
        
        txtMultiplicador.setVisible(false);
        txtMultiplicador.setText("");
        lblMultiplicador.setVisible(false);
        
        txtReferencia.setVisible(false);
        txtReferencia.setText("");
        lblReferencia.setVisible(false);
        
        txtModulo.setVisible(false);
        txtModulo.setText("");
        lblModulo.setVisible(false);
        
        txtConstante.setVisible(false);
        txtConstante.setText("");
        lblConstante.setVisible(false);
        
        String[] columnas = {"Numeros Pseudoaleatorios"};
        modelo.setColumnIdentifiers(columnas);
        
        try{
            int num = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos números pseudoaleatorios quieres?"));
            int modulo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor del módulo"));
            int numerosemillas = Integer.parseInt(JOptionPane.showInputDialog("¿Con cuántas semillas quieres realizar el cálculo?"));

            registrar(num, numerosemillas);
            calcular(num, modulo, numerosemillas);

            for (int i = 0; i < pseudo.length; i++) {
                modelo.addRow(new Object[]{new Integer(pseudo[i])}); 
            }

            tblSecuencia.setModel(modelo);
            guardarTabla("src\\Aditivo.txt");
        }catch(Exception e){
            System.out.println("Operacion cancelada");
        }
    }//GEN-LAST:event_btnAditivoActionPerformed

    private void btnMultiplicativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplicativoActionPerformed
        numModelo = 5;
        
        btnGenerar.setVisible(true);
        tblSecuencia.setVisible(true);
        
        lblSemilla.setVisible(true);
        txtSemilla.setVisible(true);
        txtSemilla.setText("");
        
        txtAleatorio.setVisible(false);
        txtAleatorio.setText("");
        lblAleatorio.setVisible(false);
        
        txtMultiplicador.setVisible(true);
        txtMultiplicador.setText("");
        lblMultiplicador.setVisible(true);
        
        txtReferencia.setVisible(false);
        txtReferencia.setText("");
        lblReferencia.setVisible(false);
        
        txtModulo.setVisible(true);
        txtModulo.setText("");
        lblModulo.setVisible(true);
        
        txtConstante.setVisible(false);
        txtConstante.setText("");
        lblConstante.setVisible(false);
    }//GEN-LAST:event_btnMultiplicativoActionPerformed

    private void btnMixtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMixtoActionPerformed
        numModelo = 6;
        
        btnGenerar.setVisible(true);
        tblSecuencia.setVisible(true);
        
        lblSemilla.setVisible(true);
        txtSemilla.setVisible(true);
        txtSemilla.setText("");
        
        txtAleatorio.setVisible(false);
        txtAleatorio.setText("");
        lblAleatorio.setVisible(false);
        
        txtMultiplicador.setVisible(true);
        txtMultiplicador.setText("");
        lblMultiplicador.setVisible(true);
        
        txtReferencia.setVisible(false);
        txtReferencia.setText("");
        lblReferencia.setVisible(false);
        
        txtModulo.setVisible(true);
        txtModulo.setText("");
        lblModulo.setVisible(true);
        
        txtConstante.setVisible(true);
        txtConstante.setText("");
        lblConstante.setVisible(true);
    }//GEN-LAST:event_btnMixtoActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null, "Para el calculo de numeros pseudoaleatorios te sugerimos que: \n\n"
                + "Metodo de Neumann: \n"
                    + "         La semilla sea un numero impar.\n"
                    + "         La semilla sea un numero de 4 digitos.\n\n"
                + "Metodo de Producto Central: \n"
                    + "         Las semillas sea un numero impar\n\n"
                + "Metodo de Factor Constante: \n"
                    + "         La semilla sea un numero impar.\n"
                    + "         La semilla y la referencia sean numeros de 4 digitos.\n"
                + "Metodo Aditivo: \n"
                    + "         Las semillas sea un numero impar\n\n"
                + "Metodo Multiplicativo: \n"
                    + "         La semilla sea un numero mayor a 0.\n"
                    + "         El multiplicador sea un numero mayor a 0.\n"
                    + "         El modulo sea mayor a la semilla y al multiplicador.\n\n"
                + "Metodo Mixto: \n"
                    + "         La semilla sea un numero mayor a 0.\n"
                    + "         El multiplicador sea un numero mayor a 0.\n"
                    + "         La constante aditivia sea un numero mayor a 0.\n"
                    + "         El modulo sea mayor a la semilla y al multiplicador.\n\n"
        );
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        modelo = new DefaultTableModel();
        VentanaOpciones opcion = new VentanaOpciones();
        opcion.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        switch(numModelo){
            case 1:
                //Neumann
                if(txtSemilla.getText().length()>0 && Integer.parseInt(txtSemilla.getText())>999 && Integer.parseInt(txtSemilla.getText())<=10000){
                    Semilla.Iniciar();
          
                modelo = new DefaultTableModel();
                int contador = 0;
                int xSemilla = 0;
           
                String cadena = "";
                String[] columnas = {"Numeros Pseudoaleatorios"};
                modelo.setColumnIdentifiers(columnas);
                int semilla = Integer.parseInt(txtSemilla.getText());
                xSemilla = semilla;
                int copiaSemilla = semilla;
                                
                while (true) {
                    int op = (semilla * semilla);
                    char[] numeros = ("" + op).toCharArray();
                    int longitud = numeros.length;
                    if (longitud == 4) {
                        semilla = op;
                    } else if (longitud == 1) {
                        cadena = "" + 0 + "" + 0 + "" + 0 + "" + numeros[0];
                        semilla = Integer.parseInt(cadena);
                    } else if (longitud == 2) {
                        cadena = "" + 0 + "" + 0 + "" + numeros[0] + "" + numeros[1];
                        semilla = Integer.parseInt(cadena);
                    } else if (longitud == 3) {
                        cadena = "" + 0 + "" + numeros[0] + "" + numeros[1] + "" + numeros[2];
                        semilla = Integer.parseInt(cadena);
                    } else if (longitud == 5) {
                        cadena = "" + 0+ "" + numeros[0] + "" + numeros[1] + "" + numeros[2];
                        semilla = Integer.parseInt(cadena);
                    } else if (longitud == 6) {
                        cadena = "" + numeros[0] + "" + numeros[1] + "" + numeros[2] + "" + numeros[3];
                        semilla = Integer.parseInt(cadena);
                    } else if (longitud == 7) {
                        cadena = "" + numeros[1] + "" + numeros[2] + "" + numeros[3] + "" + numeros[4];
                        semilla = Integer.parseInt(cadena);
                    } else if (longitud == 8) {
                        cadena = "" + numeros[2] + "" + numeros[3] + "" + numeros[4] + "" + numeros[5];
                        semilla = Integer.parseInt(cadena);
                    }
                    modelo.addRow(new Object[]{(double)xSemilla/10000});
                    xSemilla = semilla;
                    if (semilla == copiaSemilla) {
                        JOptionPane.showMessageDialog(rootPane, "la semilla inicial \"" + copiaSemilla + "\" se repite en : " + contador);
                        break;
                    } else if (semilla == 0) {
                        JOptionPane.showMessageDialog(rootPane, "el ciclo termina en 000 : " + contador);
                        break;
                    }
                    if (Semilla.esVacio()) {
                        Semilla.Agregar(cadena);
                    } else {
                        if (!Semilla.siExiste(cadena)) {
                            Semilla.Agregar(cadena);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El numero se repite en " + contador);
                            break;
                        }
                    }

                    contador++;
                }
                tblSecuencia.setModel(modelo);
                tabla = tblSecuencia;
                guardarTabla("src\\Neumann.txt");
           
                }else if(txtSemilla.getText().length() == 0){
                    JOptionPane.showMessageDialog(rootPane, "No debes dejar algun campo vacio.");
                }else if(Integer.parseInt(txtSemilla.getText())<=999 || Integer.parseInt(txtSemilla.getText())>=10000){
                    JOptionPane.showMessageDialog(rootPane, "El campo de la semilla debe ser de 4 digitos");

                }
                break;
                
            case 2:
                //Producto Central
                class Proceso{
                    int semilla, numRandom;
                    String resultado ;  
                     
                   
                    public Proceso(int semilla, int numRandom) {
                    this.semilla = semilla;
                    this.numRandom = numRandom;
                    }
                    
                    public void multiplicar() {
                        int aux = semilla * numRandom;
                        resultado = refactorizar(aux);
                    }

                    public String substraer() {
                        String xsemilla = resultado.substring(2, 6);
                        return xsemilla;
                    }

                    public String refactorizar(int refactor) {
                        String aux = String.valueOf(refactor);

                        if (aux.length() < 8) {

                            int numCeros = 8 - aux.length();
                            String ceros = "";
                            for (int i = 0; i < numCeros; i++)
                                ceros += "0";

                            aux = ceros + aux;
                        }
                        return aux;
                    }

                    public void conmutar(String substring){
                        semilla = numRandom;
                        numRandom = Integer.valueOf(substring);
                    }

                    public boolean verificar(String substring){
                        int aux = Integer.valueOf(substring);
                        return aux != semilla;
                    }

                    public void start(){
                        String xsemilla;
                        int contador = 1;
                        do{
                            multiplicar();
                            xsemilla = substraer();
                            conmutar(xsemilla);

                            modelo.addRow(new Object[]{Double.parseDouble(xsemilla)/10000});
                            contador++;
                            tblSecuencia.setModel(modelo);
                            tabla = tblSecuencia;

                        }while (verificar(xsemilla));
                        if(xsemilla.equals("0000")){
                           JOptionPane.showMessageDialog(rootPane, "El ciclo termina en 000: " + contador);
                        }
                        if(!verificar(xsemilla)){
                            JOptionPane.showMessageDialog(rootPane, "El numero se repite en " + contador);
                        }

                        guardarTabla("src\\ProductoCentral.txt");

                    }
                }
                if (txtSemilla.getText().length() > 0 && Integer.parseInt(txtSemilla.getText()) > 999 && Integer.parseInt(txtSemilla.getText()) <= 10000 
                         && txtAleatorio.getText().length() > 0 && Integer.parseInt(txtAleatorio.getText()) > 999 && Integer.parseInt(txtAleatorio.getText()) <= 10000){
                    modelo = new DefaultTableModel();
                    String[] columnas = {"n","Numeros Pseudoaleatorios"};
                    modelo.setColumnIdentifiers(columnas);
                    int semilla=Integer.parseInt(txtSemilla.getText());
                    int numRandom=Integer.parseInt(txtAleatorio.getText());
                    Proceso proceso = new Proceso(semilla,numRandom);
                    proceso.start();
                    
                } else if (txtSemilla.getText().length() == 0 || txtAleatorio.getText().length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "No debes dejar algun campo vacio.");
                } else if (Integer.parseInt(txtSemilla.getText()) <= 999 || Integer.parseInt(txtAleatorio.getText()) >= 10000
                        || Integer.parseInt(txtAleatorio.getText()) <= 999 || Integer.parseInt(txtAleatorio.getText()) >= 10000) {
                    JOptionPane.showMessageDialog(rootPane, "El campo de la semilla y/o el campo de la referencia debe ser de 4 digitos");
                }
                break;
                
            case 3:
                //Factor Constante
                if (txtSemilla.getText().length() > 0 && Integer.parseInt(txtSemilla.getText()) > 999 && Integer.parseInt(txtSemilla.getText()) <= 10000 && txtReferencia.getText().length() > 0 && Integer.parseInt(txtReferencia.getText()) > 999 && Integer.parseInt(txtReferencia.getText()) <= 10000) {
                    Semilla.Iniciar();
                    
                    boolean existe = true;

                    try {
                        int numeroSemilla = Integer.parseInt(txtSemilla.getText().toString());
                        int numeroReferencia = Integer.parseInt(txtReferencia.getText().toString());
                    } catch (java.lang.NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(rootPane, "No se puede procesar tu entrada, debes escribir caracteres numericos !");
                        existe = false;
                    }

                    if (existe == true) {
                        modelo = new DefaultTableModel();
                        int contador = 0;
                        int xSemilla = 0;
                        int xReferencia = 0;
                        String cadena = "";
                        String[] columnas = {"Numeros Pseudoaleatorios"};
                        modelo.setColumnIdentifiers(columnas);
                        int semilla = Integer.parseInt(txtSemilla.getText());
                        int referencia = Integer.parseInt(txtReferencia.getText());
                        xSemilla = semilla;
                        int copiaSemilla = semilla;

                        while (true) {
                            int op = (semilla * referencia);
                            char[] numeros = ("" + op).toCharArray();
                            int longitud = numeros.length;
                            if (longitud == 4) {
                                semilla = op;
                            } else if (longitud == 1) {
                                cadena = "" + 0 + "" + 0 + "" + 0 + "" + numeros[0];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 2) {
                                cadena = "" + 0 + "" + 0 + "" + numeros[0] + "" + numeros[1];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 3) {
                                cadena = "" + 0 + "" + numeros[0] + "" + numeros[1] + "" + numeros[2];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 5) {
                                cadena = "" + 0 + "" + numeros[0] + "" + numeros[1] + "" + numeros[2];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 6) {
                                cadena = "" + numeros[0] + "" + numeros[1] + "" + numeros[2] + "" + numeros[3];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 7) {
                                cadena = "" + numeros[1] + "" + numeros[2] + "" + numeros[3] + "" + numeros[4];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 8) {
                                cadena = "" + numeros[2] + "" + numeros[3] + "" + numeros[4] + "" + numeros[5];
                                semilla = Integer.parseInt(cadena);
                            }
                            modelo.addRow(new Object[]{(double)xSemilla/10000});
                            xSemilla = semilla;
                            if (semilla == copiaSemilla) {
                                JOptionPane.showMessageDialog(rootPane, "la semilla inicial \"" + copiaSemilla + "\" se repite en : " + contador);
                                break;
                            } else if (semilla == 0) {
                                JOptionPane.showMessageDialog(rootPane, "el ciclo termina en 000 : " + contador);
                                break;
                            }
                            if (Semilla.esVacio()) {
                                Semilla.Agregar(cadena);
                            } else {
                                if (!Semilla.siExiste(cadena)) {
                                    Semilla.Agregar(cadena);
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "El numero se repite en " + contador);
                                    break;
                                }
                            }

                            contador++;
                        }
                        tblSecuencia.setModel(modelo);
                        tabla = tblSecuencia;
                        guardarTabla("src\\FactorConstante.txt");
                    }
                } else if (txtSemilla.getText().length() == 0 || txtReferencia.getText().length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "No debes dejar algun campo vacio.");
                } else if (Integer.parseInt(txtSemilla.getText()) <= 999 || Integer.parseInt(txtSemilla.getText()) >= 10000
                        || Integer.parseInt(txtReferencia.getText()) <= 999 || Integer.parseInt(txtReferencia.getText()) >= 10000) {
                    JOptionPane.showMessageDialog(rootPane, "El campo de la semilla y/o el campo de la referencia debe ser de 4 digitos");
                }
                break;
                
            case 5:
                //Multiplicativo
                if(Integer.parseInt(txtSemilla.getText())> 0 && Integer.parseInt(txtMultiplicador.getText())>0 && Integer.parseInt(txtModulo.getText()) > Integer.parseInt(txtSemilla.getText()) && Integer.parseInt(txtModulo.getText()) > Integer.parseInt(txtMultiplicador.getText())){
                    Semilla.Iniciar();
            
                    modelo = new DefaultTableModel();
                    String[] columnas = {"Numeros Pseudoaleatorios"};
                    String cadena = "";
                    modelo.setColumnIdentifiers(columnas);
                    int semilla = Integer.parseInt(txtSemilla.getText());
                    int multiplicador = Integer.parseInt(txtMultiplicador.getText());
                    int modulo = Integer.parseInt(txtModulo.getText());
                    int copiaSemilla = semilla;
                    
                    for (int i = 1; i < 100; i++) {
                        semilla = (semilla * multiplicador) % modulo;
                        cadena = semilla + "";
                        semilla = Integer.parseInt(cadena);
                        modelo.addRow(new Object[]{(double)semilla/modulo});

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
                    tabla = tblSecuencia;
                    guardarTabla("src\\Multiplicativo.txt");
                } else if (txtSemilla.getText().length() == 0 || txtMultiplicador.getText().length() == 0 || txtModulo.getText().length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "No debes dejar algun campo vacio.");
                } else if (Integer.parseInt(txtSemilla.getText()) <= 0 || Integer.parseInt(txtMultiplicador.getText()) <= 0
                        || Integer.parseInt(txtModulo.getText()) < Integer.parseInt(txtSemilla.getText()) || Integer.parseInt(txtModulo.getText()) < Integer.parseInt(txtMultiplicador.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Verificar datos");
                }
                break;
                
            case 6:
                //Mixto
                if(Integer.parseInt(txtSemilla.getText())> 0 && Integer.parseInt(txtMultiplicador.getText())>0 && Integer.parseInt(txtConstante.getText())>0 && Integer.parseInt(txtModulo.getText()) > Integer.parseInt(txtSemilla.getText()) && Integer.parseInt(txtModulo.getText()) > Integer.parseInt(txtMultiplicador.getText())){
                    Semilla.Iniciar();
            
                    modelo = new DefaultTableModel();
                    String[] columnas = {"Numeros Pseudoaleatorios"};
                    modelo.setColumnIdentifiers(columnas);
                    String cadena = "";
                    int semilla = Integer.parseInt(txtSemilla.getText());
                    int multiplicador = Integer.parseInt(txtMultiplicador.getText());
                    int modulo = Integer.parseInt(txtModulo.getText());
                    int constante = Integer.parseInt(txtConstante.getText());
                    
                    int copiaSemilla = semilla;

                    for (int i = 1; i < 100; i++) {
                        semilla = ((semilla * multiplicador) + constante) % modulo;
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
                    tabla = tblSecuencia;
                    guardarTabla("src\\Mixto.txt");
                } else if (txtSemilla.getText().length() == 0 || txtMultiplicador.getText().length() == 0 || txtModulo.getText().length() == 0 || txtConstante.getText().length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "No debes dejar algun campo vacio.");
                } else if (Integer.parseInt(txtSemilla.getText()) <= 0 || Integer.parseInt(txtMultiplicador.getText()) <= 0 || Integer.parseInt(txtConstante.getText()) <= 0
                        || Integer.parseInt(txtModulo.getText()) < Integer.parseInt(txtSemilla.getText()) || Integer.parseInt(txtModulo.getText()) < Integer.parseInt(txtMultiplicador.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Verificar datos");
                }
                break;
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

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
    
    private void btnPruebasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebasActionPerformed
        if(VentanaOpciones.opcion == 1){
            Pruebas p = new Pruebas();
            p.pruebaPromedios(getTableData(tblSecuencia));
            p.pruebaChiCuadrada(getTableData(tblSecuencia));
            p.pruebaKolmogorov(getTableData(tblSecuencia));
            p.pruebaCorridas(getTableData(tblSecuencia));
            p.pruebaHuecos(getTableData(tblSecuencia), 3);
            p.pruebaPoker(getTableData(tblSecuencia));
            p.pruebaAutocorrelacion(getTableData(tblSecuencia));
        }
        if(VentanaOpciones.opcion == 2){
            VentanaPruebas comprobacion = new VentanaPruebas();
            comprobacion.setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(VentanaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaModelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAditivo;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnFactor;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnMixto;
    private javax.swing.JButton btnMultiplicativo;
    private javax.swing.JButton btnNeumann;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnPruebas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAleatorio;
    private javax.swing.JLabel lblConstante;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JLabel lblMultiplicador;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblSemilla;
    private javax.swing.JTable tblSecuencia;
    private javax.swing.JTextField txtAleatorio;
    private javax.swing.JTextField txtConstante;
    private javax.swing.JTextField txtModulo;
    private javax.swing.JTextField txtMultiplicador;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtSemilla;
    // End of variables declaration//GEN-END:variables
}
