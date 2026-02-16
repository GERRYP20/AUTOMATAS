package Compiladores;

import java.util.StringTokenizer;

public class Principal extends javax.swing.JFrame
{

    int vectorSalida[];

    public Principal()
    {
        initComponents();
        setLocationRelativeTo(null);
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

        // Usamos ArrayList para manejar la lista de tokens dinámicamente
        java.util.ArrayList<Integer> tokensList = new java.util.ArrayList<>();
        String textoSalida = "";

        // Tokenizer incluyendo el espacio " " en los delimitadores para poder ignorarlo manualmente
        java.util.StringTokenizer st = new java.util.StringTokenizer(jTPFuente.getText(), "\b\r\t\n| #!=<>;&,{}()+-*/%\"\' ", true);
        
        String cadena = "";
        String tokenPendiente = ""; // Buffer para mirar adelante (lookahead)
        
        boolean dentroDeCadena = false;
        String acumuladorCadena = "";
        String caracterCierreCadena = ""; // Para saber si abrimos con " o '
        
        Automata automata = new Automata();
        Lexico lexico = new Lexico();

        while (st.hasMoreTokens() || !tokenPendiente.isEmpty()) {
            
            // 1. Obtener el siguiente token (del buffer o del tokenizer)
            if (!tokenPendiente.isEmpty()) {
                cadena = tokenPendiente;
                tokenPendiente = "";
            } else {
                cadena = st.nextToken();
            }

            // 2. Lógica de Cadenas de Texto ("..." o '...')
            if (!dentroDeCadena) {
                if (cadena.equals("\"") || cadena.equals("\'")) {
                    dentroDeCadena = true;
                    caracterCierreCadena = cadena;
                    acumuladorCadena = cadena;
                    continue; 
                }
            } else {
                // Estamos DENTRO de una cadena
                acumuladorCadena += cadena;
                
                // Verificamos si este token cierra la cadena
                if (cadena.equals(caracterCierreCadena)) {
                    dentroDeCadena = false;
                    
                    // Procesar la cadena completa
                    String etiqueta = automata.etiquetar(acumuladorCadena);
                    int idToken = 0;
                    try {
                        // Intentamos obtener el número (ej: "53 Cadena" -> 53)
                        idToken = Integer.parseInt(etiqueta.split(" ")[0]);
                    } catch (Exception e) { idToken = 0; }
                    
                    tokensList.add(idToken);
                    textoSalida += acumuladorCadena + "\t" + etiqueta + "\n";
                    acumuladorCadena = ""; // Limpiar
                }
                continue; // Vamos al siguiente token
            }

            // 3. Ignorar espacios en blanco, saltos de línea y tabuladores (fuera de cadenas)
            if (cadena.trim().isEmpty()) {
                continue;
            }

            // 4. Lógica de Operadores Compuestos (>=, <=, ==, !=, &&, ||, <>)
            // Miramos adelante solo si es un caracter candidato a ser compuesto
            if ((cadena.equals("<") || cadena.equals(">") || cadena.equals("=") || 
                 cadena.equals("!") || cadena.equals("&") || cadena.equals("|")) 
                 && st.hasMoreTokens()) {
                
                String siguiente = st.nextToken();
                
                // Si el siguiente es espacio, no se fusiona, pero guardamos el espacio en el buffer?
                // Mejor lógica: Si es espacio, lo ignoramos para la fusión pero cuidado, 
                // "a < b" (con espacios) no debe fusionarse.
                // "a <= b" (sin espacios) sí.
                // El tokenizer devuelve el espacio como token. 
                
                if (siguiente.trim().isEmpty()) {
                    // Es un espacio, NO fusionar. El operador queda solo.
                    // El 'siguiente' (espacio) se descarta o se guarda? Se descarta.
                } else {
                    // Verificamos combinaciones válidas
                    boolean fusionado = false;
                    
                    if ((cadena.equals("<") && siguiente.equals("=")) || // <=
                        (cadena.equals(">") && siguiente.equals("=")) || // >=
                        (cadena.equals("=") && siguiente.equals("=")) || // ==
                        (cadena.equals("!") && siguiente.equals("=")) || // !=
                        (cadena.equals("<") && siguiente.equals(">")) || // <>
                        (cadena.equals("&") && siguiente.equals("&")) || // &&
                        (cadena.equals("|") && siguiente.equals("|")))   // ||
                    {
                        cadena += siguiente; // Se fusionan (ej: ">=")
                        fusionado = true;
                    } 
                    
                    if (!fusionado) {
                        // No eran pareja (ej: "<" y "num"), guardamos "num" para después
                        tokenPendiente = siguiente;
                    }
                }
            }

            // 5. Etiquetado Final del Token
            String etiqueta = lexico.etiquetar(cadena);
            int idToken = 0;
            
            // Si Lexico no lo reconoce (return "0"), probamos Automata (ID, Num, Real)
            if (etiqueta.equals("0")) {
                etiqueta = automata.etiquetar(cadena);
            }
            
            // Extraer el ID numérico y manejar Errores
            if (etiqueta.startsWith("Error")) {
                // Asignamos ID 100 para errores léxicos, el sintáctico deberá detenerse
                idToken = 100; 
            } else {
                try {
                    idToken = Integer.parseInt(etiqueta.split(" ")[0]);
                } catch (Exception e) {
                    idToken = 0;
                }
            }

            tokensList.add(idToken);
            textoSalida += cadena + "\t" + etiqueta + "\n";
        }
        
        // Convertimos la lista al arreglo para el sintáctico
        vectorSalida = new int[tokensList.size()];
        for (int k = 0; k < tokensList.size(); k++) {
            vectorSalida[k] = tokensList.get(k);
        }
        
        jTPCompilador.setText(textoSalida);

    }//GEN-LAST:event_jBLexicoMouseClicked

    private void jBSintacticoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSintacticoMouseClicked
        jTPCompilador.setText("Se realizará el ANÁLISIS SINTÁCTICO");
        // Habilitar botones
        jBSemantico.setEnabled(true);
        jBIntermedio.setEnabled(false);
        jBOptimizacion.setEnabled(false);
        jBObjeto.setEnabled(false);

        // ---------------------------------------------------------
        // 1. PREPARACIÓN DE TOKENS (Limpieza)
        // ---------------------------------------------------------
        java.util.ArrayList<Integer> cleanTokens = new java.util.ArrayList<>();
        for (int token : vectorSalida) {
            if (token != 0) cleanTokens.add(token);
        }
        
        vectorSalida = new int[cleanTokens.size()];
        String textoMovimientos = ""; // Esto era para mostrar solo el inicio, ya no es tan critico
        for (int k = 0; k < cleanTokens.size(); k++) {
            vectorSalida[k] = cleanTokens.get(k);
        }
        
        jLEtiqueta1.setText("MOVIMIENTOS (PILA)");
        jLEtiqueta2.setText("CADENA A VALIDAR (ENTRADA)");
        
        // Limpiamos las áreas de texto iniciales
        jTPFuente.setText("$ 150"); 
        
        // Mostramos la cadena inicial completa en la derecha
        String cadenaInicial = "";
        for (int token : vectorSalida) cadenaInicial += token + " ";
        cadenaInicial += "$";
        jTPCompilador.setText(cadenaInicial);

        // ---------------------------------------------------------
        // 2. DEFINICIÓN DE LA GRAMÁTICA (Reglas 1-52)
        // ---------------------------------------------------------
        // (Pega aquí tu matrizGramatica grande de 52 reglas tal cual la tenías)
        int matrizGramatica[][] = {
            {}, // 0
            {2, 151, 2, 52, 1},        // 1. <Principal>
            {153, 152},                // 2. <Principal1>
            {151},                     // 3. <Principal2>
            {},                        // 4. Lambda
            {157},                     // 5. <principalTipo> -> Comentario
            {158},                     // 6. <principalTipo> -> Sentencia
            {161},                     // 7. <principalTipo> -> Funcion
            {155, 52},                 // 8. <Dec2>
            {},                        // 9. Lambda
            {154, 4},                  // 10. <Dec3>
            {},                        // 11. Lambda
            {5},                       // 12. <tipoDato>
            {8, 53, 7, 6},             // 13. <Comentario>
            {159, 52},                 // 14. <Sentencia> -> ID
            {3, 11, 170, 10, 15},      // 15. <Sentencia> -> Escribir
            {3, 156},                  // 16. <Sentencia> -> Tipo
            {174, 2, 158, 2, 11, 175, 10, 16}, // 17. Si
            {2, 158, 2, 11, 175, 10, 20},      // 18. Mientras
            {160, 12},                 // 19. <Sentencia2> -> =
            {3, 156, 155},             // 20. <Sentencia2> -> Declaracion
            {3, 11, 10, 14},           // 21. <Sentencia3> -> Leer
            {3, 163},                  // 22. <Sentencia3> -> Expresion
            {2, 158, 2, 11, 166, 10, 52, 9},   // 23. Funcion
            {3, 163, 12, 52},          // 24. Asignacion
            {164, 165},                // 25. Expresion
            {164, 165, 13},            // 26. Expresion1
            {},                        // 27. Lambda
            {52},                      // 28. ID
            {50},                      // 29. Num
            {53},                      // 30. Cadena
            {51},                      // 31. Dec
            {11, 163, 10},             // 32. (Exp)
            {167, 156, 52},            // 33. Parametro
            {166, 4},                  // 34. Parametro1
            {},                        // 35. Lambda
            {3, 11, 10, 14, 12, 52},   // 36. Lectura
            {3, 11, 170, 10, 15},      // 37. Escritura
            {172, 171},                // 38. Escritura1
            {52},                      // 39. tipo -> ID
            {53},                      // 40. tipo -> Cadena
            {172, 171, 4},             // 41. Escritura2
            {},                        // 42. Lambda
            {174, 2, 158, 2, 11, 175, 10, 16}, // 43. Sentencia_si
            {173},                     // 44. Sentencia_si2 -> si
            {2, 158, 2, 19},           // 45. Sentencia_si2 -> entonces
            {},                        // 46. Lambda
            {177, 163, 176, 163},      // 47. Condicion
            {17},                      // 48. OpRel
            {175, 178},                // 49. Condicion2
            {},                        // 50. Lambda
            {18},                      // 51. OpLog
            {2, 158, 2, 11, 175, 10, 20} // 52. Sentencia_mientras
        };

        // 3. MATRIZ M (Pega aquí tu matriz[][] completa)
        int matriz[][] = new int[30][54];
        for (int i = 0; i < 30; i++) { for (int j = 0; j < 54; j++) { matriz[i][j] = -1; } }
        
        // ... (RESUMEN DE TU LLENADO DE MATRIZ) ...
        matriz[0][0]=1; matriz[1][4]=2; matriz[1][5]=2; matriz[1][8]=2; matriz[1][14]=2; matriz[1][15]=2; matriz[1][19]=2; matriz[1][51]=2;
        matriz[3][4]=3; matriz[3][5]=3; matriz[3][8]=3; matriz[3][14]=3; matriz[3][15]=3; matriz[3][19]=3; matriz[3][51]=3; matriz[3][1]=4;
        matriz[2][5]=5; matriz[2][4]=6; matriz[2][14]=6; matriz[2][15]=6; matriz[2][19]=6; matriz[2][51]=6; matriz[2][8]=7;
        matriz[4][51]=8; matriz[4][4]=9; matriz[5][3]=10; matriz[5][4]=11; matriz[6][4]=12; matriz[7][5]=13;
        matriz[8][51]=14; matriz[8][14]=15; matriz[8][4]=16; matriz[8][15]=17; matriz[8][19]=18;
        matriz[9][11]=19; matriz[9][3]=20; matriz[9][4]=20; matriz[10][13]=21; matriz[10][9]=22; matriz[10][49]=22; matriz[10][50]=22; matriz[10][51]=22; matriz[10][52]=22;
        matriz[11][8]=23; matriz[12][51]=24; matriz[13][9]=25; matriz[13][49]=25; matriz[13][50]=25; matriz[13][51]=25; matriz[13][52]=25;
        matriz[14][12]=26; matriz[14][2]=27; matriz[14][10]=27; matriz[14][16]=27; matriz[14][17]=27;
        matriz[15][51]=28; matriz[15][49]=29; matriz[15][52]=30; matriz[15][50]=31; matriz[15][9]=32;
        matriz[16][51]=33; matriz[17][3]=34; matriz[17][10]=35; matriz[18][51]=36; matriz[19][14]=37;
        matriz[20][51]=38; matriz[20][52]=38; matriz[21][51]=39; matriz[21][52]=40; matriz[22][3]=41; matriz[22][10]=42;
        matriz[23][15]=43; matriz[24][15]=44; matriz[24][18]=45; matriz[24][1]=46; matriz[24][4]=46; matriz[24][5]=46; matriz[24][8]=46; matriz[24][14]=46; matriz[24][19]=46; matriz[24][51]=46;
        matriz[25][9]=47; matriz[25][49]=47; matriz[25][50]=47; matriz[25][51]=47; matriz[25][52]=47;
        matriz[26][16]=48; matriz[27][17]=49; matriz[27][10]=50; matriz[28][17]=51; matriz[29][19]=52;


        // 4. LÓGICA DEL PARSER (Actualización Visual Mejorada)
        int vectorMov[] = {0, 150};
        int vectorAux[];
        int i = 0;
        int pr = 0;
        int pc = 0;
        int nl = 0;
        int tv = 0;
        
        // VARIABLES DE HISTORIAL (Acumulan el texto para mostrarlos línea por línea)
        String historialPila = jTPFuente.getText(); 
        String historialEntrada = jTPCompilador.getText();
        
        // Flag para detectar errores sintácticos
        boolean errorSintactico = false;

        do {
            // Verificar errores léxicos
            if (i < vectorSalida.length) {
                if (vectorSalida[i] >= 100) {
                    String nombreError = obtenerNombreToken(vectorSalida[i]);
                    jTPFuente.setText(historialPila + "\n\n " + nombreError);
                    return; 
                }
                if (vectorSalida[i] >= 54 && vectorSalida[i] < 100) {
                     jTPFuente.setText(historialPila + "\n\n ID desconocido: " + vectorSalida[i]);
                     return;
                }
            }

            pr = vectorMov[vectorMov.length - 1]; 
            
            // --- CASO 1: NO TERMINAL ---
            if (pr >= 150) { 
                pr = pr - 150;
                if (i >= vectorSalida.length) break;
                pc = vectorSalida[i] - 1;
                nl = matriz[pr][pc];

                if (nl != -1) {
                    // EXPANDIR PILA
                    vectorAux = vectorMov;
                    vectorMov = new int[(vectorAux.length + matrizGramatica[nl].length) - 1];
                    tv = 0;
                    System.arraycopy(vectorAux, 0, vectorMov, 0, vectorAux.length - 1);
                    for (int j = vectorAux.length - 1; j < vectorMov.length; j++) {
                        vectorMov[j] = matrizGramatica[nl][tv];
                        tv++;
                    }
                    
                    // --- ACTUALIZACIÓN VISUAL (IZQUIERDA: PILA) ---
                    String nuevaLineaPila = "";
                    for (int j = 0; j < vectorMov.length; j++) {
                        nuevaLineaPila += vectorMov[j] + " ";
                    }
                    historialPila += "\n" + nuevaLineaPila;
                    jTPFuente.setText(historialPila);
                    
                    // --- ACTUALIZACIÓN VISUAL (DERECHA: ENTRADA RESTANTE) ---
                    // Generamos qué tokens quedan por leer desde 'i' hasta el final
                    String nuevaLineaEntrada = "";
                    for (int k = i; k < vectorSalida.length; k++) {
                        nuevaLineaEntrada += vectorSalida[k] + " ";
                    }
                    nuevaLineaEntrada += "$";
                    
                    historialEntrada += "\n" + nuevaLineaEntrada;
                    jTPCompilador.setText(historialEntrada);

                } else {
                    // ERROR SINTÁCTICO
                    errorSintactico = true;
                    String rec = obtenerNombreToken(vectorSalida[i]);
                    String esp = obtenerNombreToken(pr + 150);
                    jTPFuente.setText(historialPila + "\n\n Error sintactico: Recibido [" + rec + "], se esperaba [" + esp + "]");
                    break;
                }
            } 
            // --- CASO 2: TERMINAL ---
            else { 
                if (i >= vectorSalida.length) break;
                
                if (vectorSalida[i] == vectorMov[vectorMov.length - 1]) {
                    // MATCH: AVANZAR Y DESAPILAR
                    i++; 
                    vectorAux = vectorMov;
                    vectorMov = new int[vectorAux.length - 1];
                    System.arraycopy(vectorAux, 0, vectorMov, 0, vectorMov.length); 
                    
                    // --- ACTUALIZACIÓN VISUAL (IZQUIERDA) ---
                    String nuevaLineaPila = "";
                    for (int j = 0; j < vectorMov.length; j++) {
                        nuevaLineaPila += vectorMov[j] + " ";
                    }
                    historialPila += "\n" + nuevaLineaPila;
                    jTPFuente.setText(historialPila);
                    
                    // --- ACTUALIZACIÓN VISUAL (DERECHA) ---
                    // Ahora 'i' avanzó, así que la cadena será más corta
                    String nuevaLineaEntrada = "";
                    for (int k = i; k < vectorSalida.length; k++) {
                        nuevaLineaEntrada += vectorSalida[k] + " ";
                    }
                    nuevaLineaEntrada += "$";
                    
                    historialEntrada += "\n" + nuevaLineaEntrada;
                    jTPCompilador.setText(historialEntrada);
                    
                } else {
                    // ERROR DE COINCIDENCIA
                    errorSintactico = true;
                    String rec = obtenerNombreToken(vectorSalida[i]);
                    String esp = obtenerNombreToken(vectorMov[vectorMov.length - 1]);
                    jTPFuente.setText(historialPila + "\n\n Error sintactico: Recibido [" + rec + "], Se esperaba [" + esp + "]");
                    break;
                }
            }
        } while (i < vectorSalida.length || (vectorMov.length > 1 && vectorMov[vectorMov.length-1] >= 150));

        // Éxito final
        if (!errorSintactico && vectorMov.length > 0 && vectorMov[vectorMov.length - 1] == 0) {
            jTPFuente.setText(historialPila + "\n\n Sintacticamente correcto");
        }
    }//GEN-LAST:event_jBSintacticoMouseClicked

    // Método para traducir IDs a Nombres usando tus Clases y Tablas
    private String obtenerNombreToken(int id) {
        
        // 1. BUSCAR EN CLASE LEXICO (Tokens 1-20)
        // Como dic es static, lo accedemos directo: Lexico.dic
        for (int i = 0; i < Lexico.dic.length; i++) {
            try {
                int idDic = Integer.parseInt(Lexico.dic[i][2]);
                if (idDic == id) {
                    return Lexico.dic[i][1]; // Retorna el "Nombre" (columna 1)
                }
            } catch (NumberFormatException e) { continue; }
        }

        // 2. BUSCAR EN TABLA DE ERRORES (100-109)
        // Basado en tu imagen "TABLA DE ERRORES"
        switch(id) {
            case 100: return "Error 100: CARÁCTER NO VALIDO";
            case 101: return "Error 101: CADENA NO VALIDA";
            case 102: return "Error 102: CADENA NO VALIDA";
            case 103: return "Error 103: CADENA NO VALIDA";
            case 104: return "Error 104: CADENA NO VALIDA";
            case 105: return "Error 105: CADENA NO VALIDA";
            case 106: return "Error 106: NUMERO NO VALIDO";
            case 107: return "Error 107: DECIMAL NO VALIDO";
            case 108: return "Error 108: DECIMAL NO VALIDO";
            case 109: return "Error 109: IDENTIF. NO VALIDO";
        }

        // 3. TOKENS DEL AUTOMATA (50-53)
        switch(id) {
            case 50: return "Numero Entero";
            case 51: return "Numero Decimal";
            case 52: return "Identificador";
            case 53: return "Cadena";
            case 0:  return "Fin de Archivo ($)";
        }

        // 4. NO TERMINALES (Gramática 150-179)
        if (id >= 150) {
            String[] noTerminales = {
                "Principal", "Principal1", "principalTipo", "Principal2", "Dec2", "Dec3",
                "tipoDato", "Comentario", "Sentencia", "Sentencia2", "Sentencia3", "Funcion",
                "Asignacion", "Expresion", "Expresion1", "Expresion2", "Parametro", "Parametro1",
                "Lectura", "Escritura", "Escritura1", "tipo", "Escritura2", "Sentencia_si",
                "Sentencia_si2", "Condicion", "opRelacional", "Condicion2", "opLogico", "Sentencia_mientras"
            };
            if (id - 150 < noTerminales.length) {
                return "<" + noTerminales[id - 150] + ">";
            }
        }
        
        return "Token Desconocido (" + id + ")";
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
