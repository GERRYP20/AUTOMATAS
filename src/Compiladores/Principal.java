package Compiladores;

public class Principal extends javax.swing.JFrame
{

    int vectorSalida[];
    private Tokenizer tokenizer;
    private Sintactico sintactico;

    public Principal()
    {
        initComponents();
        setLocationRelativeTo(null);
        this.tokenizer = new Tokenizer();
        this.sintactico = new Sintactico();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTPFuente = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTPCompilador = new javax.swing.JTextArea();
        jLEtiqueta1 = new javax.swing.JLabel();
        jLEtiqueta2 = new javax.swing.JLabel();
        jBCargar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBLexico = new javax.swing.JButton();
        jBSintactico = new javax.swing.JButton();
        jBSemantico = new javax.swing.JButton();
        jBIntermedio = new javax.swing.JButton();
        jBOptimizacion = new javax.swing.JButton();
        jBObjeto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTPFuente.setColumns(20);
        jTPFuente.setRows(5);
        jTPFuente.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jTPFuenteKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTPFuente);

        jTPCompilador.setEditable(false);
        jTPCompilador.setColumns(20);
        jTPCompilador.setRows(5);
        jScrollPane2.setViewportView(jTPCompilador);

        jLEtiqueta1.setText("PROGRAMA FUENTE");

        jLEtiqueta2.setText("PROGRAMA COMPILADOR");

        jBCargar.setText("CARGAR");
        jBCargar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBCargarMouseClicked(evt);
            }
        });
        jBCargar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBCargarActionPerformed(evt);
            }
        });

        jBGuardar.setText("GUARDAR");
        jBGuardar.setEnabled(false);
        jBGuardar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBGuardarMouseClicked(evt);
            }
        });
        jBGuardar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBGuardarActionPerformed(evt);
            }
        });

        jBLexico.setText("LÉXICO");
        jBLexico.setEnabled(false);
        jBLexico.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBLexicoMouseClicked(evt);
            }
        });

        jBSintactico.setText("SINTÁCTICO");
        jBSintactico.setEnabled(false);
        jBSintactico.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBSintacticoMouseClicked(evt);
            }
        });

        jBSemantico.setText("SEMÁNTICO");
        jBSemantico.setEnabled(false);
        jBSemantico.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBSemanticoMouseClicked(evt);
            }
        });

        jBIntermedio.setText("INTERMEDIO");
        jBIntermedio.setEnabled(false);
        jBIntermedio.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBIntermedioMouseClicked(evt);
            }
        });

        jBOptimizacion.setText("OPTIMIZACIÓN");
        jBOptimizacion.setToolTipText("");
        jBOptimizacion.setEnabled(false);
        jBOptimizacion.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBOptimizacionMouseClicked(evt);
            }
        });

        jBObjeto.setText("OBJETO");
        jBObjeto.setEnabled(false);
        jBObjeto.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBObjetoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLEtiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLEtiqueta2)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jBLexico))
                            .addComponent(jBIntermedio))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBOptimizacion)
                            .addComponent(jBSintactico))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBSemantico)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jBObjeto)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBGuardar)
                        .addGap(140, 140, 140))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEtiqueta1)
                    .addComponent(jLEtiqueta2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCargar)
                    .addComponent(jBGuardar))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLexico)
                    .addComponent(jBSintactico)
                    .addComponent(jBSemantico))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIntermedio)
                    .addComponent(jBOptimizacion)
                    .addComponent(jBObjeto))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCargarMouseClicked
        jTPCompilador.setText("Se cargará el archivo");
        jLEtiqueta1.setText("PROGRAMA FUENTE");
        jLEtiqueta2.setText("PROGRAM COMPILADOR");
        jBGuardar.setEnabled(true);
        jBLexico.setEnabled(true);
        jBSintactico.setEnabled(false);
        jBSemantico.setEnabled(false);
        jBIntermedio.setEnabled(false);
        jBOptimizacion.setEnabled(false);
        jBObjeto.setEnabled(false);

        jTPFuente.setText(manejoArchivos.cargarArchivo());
    }//GEN-LAST:event_jBCargarMouseClicked

    private void jBGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBGuardarMouseClicked
        manejoArchivos.guardarArchivo(jTPFuente.getText());
        jTPCompilador.setText("Se guardará el archivo");

    }//GEN-LAST:event_jBGuardarMouseClicked

    private void jBLexicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLexicoMouseClicked
        jTPCompilador.setText("Se realizará el ANÁLISIS LÉXICO");
        jLEtiqueta1.setText("PROGRAMA FUENTE");
        jLEtiqueta2.setText("PROGRAMA COMPILADOR");
        jBSintactico.setEnabled(true);
        jBSemantico.setEnabled(false);
        jBIntermedio.setEnabled(false);
        jBOptimizacion.setEnabled(false);
        jBObjeto.setEnabled(false);

        // Use Tokenizer to perform lexical analysis
        tokenizer.tokenize(jTPFuente.getText());
        vectorSalida = tokenizer.getTokenIds();
        
        jTPCompilador.setText(tokenizer.getTextoSalida());

    }//GEN-LAST:event_jBLexicoMouseClicked

    private void jBSintacticoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSintacticoMouseClicked
        jTPCompilador.setText("Se realizará el ANÁLISIS SINTÁCTICO");
        // Habilitar botones
        jBSemantico.setEnabled(true);
        jBIntermedio.setEnabled(false);
        jBOptimizacion.setEnabled(false);
        jBObjeto.setEnabled(false);

        jLEtiqueta1.setText("MOVIMIENTOS (PILA)");
        jLEtiqueta2.setText("CADENA A VALIDAR (ENTRADA)");
        
        // Limpiamos las áreas de texto iniciales
        jTPFuente.setText("$ 150"); 
        
        // Mostramos la cadena inicial completa en la derecha
        String cadenaInicial = "";
        for (int token : vectorSalida) cadenaInicial += token + " ";
        cadenaInicial += "$";
        jTPCompilador.setText(cadenaInicial);

        // Use Sintactico to perform parsing
        boolean success = sintactico.parse(vectorSalida);
        
        if (sintactico.hasError()) {
            jTPFuente.setText(jTPFuente.getText() + "\n\n " + sintactico.getErrorMessage());
        } else if (success) {
            jTPFuente.setText(sintactico.getFullPilaHistory() + "\n\n Sintacticamente correcto");
            jTPCompilador.setText(sintactico.getEntradaHistory());
        }
    }//GEN-LAST:event_jBSintacticoMouseClicked

    // Helper method to get token names (delegates to Sintactico)
    private String obtenerNombreToken(int id) {
        return Sintactico.getTokenName(id);
    }
    
    private void jBSemanticoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSemanticoMouseClicked
        jTPCompilador.setText("Se realizará el ANÁLISIS SEMÁNTICO");
        jBIntermedio.setEnabled(true);
        jBOptimizacion.setEnabled(false);
        jBObjeto.setEnabled(false);
    }//GEN-LAST:event_jBSemanticoMouseClicked

    private void jBIntermedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBIntermedioMouseClicked
        jTPCompilador.setText("Se realizará la generación del CÓDIGO INTERMEDIO");
        jBOptimizacion.setEnabled(true);
        jBObjeto.setEnabled(false);
    }//GEN-LAST:event_jBIntermedioMouseClicked

    private void jBOptimizacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBOptimizacionMouseClicked
        jTPCompilador.setText("Se realizará la generación del CÓDIGO DE OPTIMIZACIÓN");
        jBObjeto.setEnabled(true);
    }//GEN-LAST:event_jBOptimizacionMouseClicked

    private void jBObjetoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBObjetoMouseClicked
        jTPCompilador.setText("Se realizará la generación del CÓDIGO OBJETO");
    }//GEN-LAST:event_jBObjetoMouseClicked

    private void jTPFuenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPFuenteKeyTyped
        jBGuardar.setEnabled(true);
        jBLexico.setEnabled(true);
        jBSintactico.setEnabled(false);
        jBSemantico.setEnabled(false);
        jBIntermedio.setEnabled(false);
        jBOptimizacion.setEnabled(false);
        jBObjeto.setEnabled(false);
    }//GEN-LAST:event_jTPFuenteKeyTyped

    private void jBCargarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBCargarActionPerformed
    {//GEN-HEADEREND:event_jBCargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCargarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBGuardarActionPerformed
    {//GEN-HEADEREND:event_jBGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBGuardarActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCargar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBIntermedio;
    private javax.swing.JButton jBLexico;
    private javax.swing.JButton jBObjeto;
    private javax.swing.JButton jBOptimizacion;
    private javax.swing.JButton jBSemantico;
    private javax.swing.JButton jBSintactico;
    private javax.swing.JLabel jLEtiqueta1;
    private javax.swing.JLabel jLEtiqueta2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTPCompilador;
    private javax.swing.JTextArea jTPFuente;
    // End of variables declaration//GEN-END:variables
}
