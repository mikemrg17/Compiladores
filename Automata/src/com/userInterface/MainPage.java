package com.userInterface;

import java.awt.Color;
import com.automata.AFN;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainPage extends javax.swing.JFrame{
    
    public static HashSet<String> ids_afd = new HashSet<String>(); //Hashset para los ids de los automatas
    public static HashSet<String> ids_seleccionados = new HashSet<String>(); //Para la unión especial

    public MainPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        functionsPanel = new javax.swing.JPanel();
        basicPanel = new javax.swing.JPanel();
        basicLabel = new javax.swing.JLabel();
        mergePanel = new javax.swing.JPanel();
        mergeLabel = new javax.swing.JLabel();
        concatenatePanel = new javax.swing.JPanel();
        concatenateLabel = new javax.swing.JLabel();
        kleenClosurePanel = new javax.swing.JPanel();
        kleenClosureLabel = new javax.swing.JLabel();
        transitiveClosurePanel = new javax.swing.JPanel();
        transitiveClosureLabel = new javax.swing.JLabel();
        optionalPanel = new javax.swing.JPanel();
        optionalLabel = new javax.swing.JLabel();
        rAFNPanel = new javax.swing.JPanel();
        rAFNLabel = new javax.swing.JLabel();
        lexicalAnalyzerPanel = new javax.swing.JPanel();
        lexicalAnalyzerLabel = new javax.swing.JLabel();
        converterPanel = new javax.swing.JPanel();
        converterLabel = new javax.swing.JLabel();
        stringAnalyzerPanel = new javax.swing.JPanel();
        stringAnalyzerLabel = new javax.swing.JLabel();
        testLexicalAnalyzerPanel = new javax.swing.JPanel();
        testLexicalAnalyzerLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        mainLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        afnList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        functionsPanel.setBackground(new java.awt.Color(51, 102, 255));
        functionsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basicPanel.setBackground(new java.awt.Color(51, 102, 255));

        basicLabel.setBackground(new java.awt.Color(255, 255, 255));
        basicLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        basicLabel.setForeground(new java.awt.Color(255, 255, 255));
        basicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        basicLabel.setText("Básico");
        basicLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        basicLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                basicLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                basicLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                basicLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout basicPanelLayout = new javax.swing.GroupLayout(basicPanel);
        basicPanel.setLayout(basicPanelLayout);
        basicPanelLayout.setHorizontalGroup(
            basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basicLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        basicPanelLayout.setVerticalGroup(
            basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(basicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mergePanel.setBackground(new java.awt.Color(51, 102, 255));

        mergeLabel.setBackground(new java.awt.Color(255, 255, 255));
        mergeLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        mergeLabel.setForeground(new java.awt.Color(255, 255, 255));
        mergeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mergeLabel.setText("Unir");
        mergeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mergeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mergeLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mergeLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mergeLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout mergePanelLayout = new javax.swing.GroupLayout(mergePanel);
        mergePanel.setLayout(mergePanelLayout);
        mergePanelLayout.setHorizontalGroup(
            mergePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mergeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        mergePanelLayout.setVerticalGroup(
            mergePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mergeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(mergePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 170, -1));

        concatenatePanel.setBackground(new java.awt.Color(51, 102, 255));

        concatenateLabel.setBackground(new java.awt.Color(255, 255, 255));
        concatenateLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        concatenateLabel.setForeground(new java.awt.Color(255, 255, 255));
        concatenateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        concatenateLabel.setText("Concatenar");
        concatenateLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        concatenateLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                concatenateLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                concatenateLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                concatenateLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout concatenatePanelLayout = new javax.swing.GroupLayout(concatenatePanel);
        concatenatePanel.setLayout(concatenatePanelLayout);
        concatenatePanelLayout.setHorizontalGroup(
            concatenatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(concatenateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        concatenatePanelLayout.setVerticalGroup(
            concatenatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(concatenateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(concatenatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 170, 40));

        kleenClosurePanel.setBackground(new java.awt.Color(51, 102, 255));

        kleenClosureLabel.setBackground(new java.awt.Color(255, 255, 255));
        kleenClosureLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        kleenClosureLabel.setForeground(new java.awt.Color(255, 255, 255));
        kleenClosureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kleenClosureLabel.setText("Cerradura *");
        kleenClosureLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kleenClosureLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kleenClosureLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kleenClosureLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kleenClosureLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout kleenClosurePanelLayout = new javax.swing.GroupLayout(kleenClosurePanel);
        kleenClosurePanel.setLayout(kleenClosurePanelLayout);
        kleenClosurePanelLayout.setHorizontalGroup(
            kleenClosurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kleenClosureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        kleenClosurePanelLayout.setVerticalGroup(
            kleenClosurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kleenClosureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(kleenClosurePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 170, 40));

        transitiveClosurePanel.setBackground(new java.awt.Color(51, 102, 255));

        transitiveClosureLabel.setBackground(new java.awt.Color(255, 255, 255));
        transitiveClosureLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        transitiveClosureLabel.setForeground(new java.awt.Color(255, 255, 255));
        transitiveClosureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transitiveClosureLabel.setText("Cerradura +");
        transitiveClosureLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transitiveClosureLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transitiveClosureLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transitiveClosureLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transitiveClosureLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout transitiveClosurePanelLayout = new javax.swing.GroupLayout(transitiveClosurePanel);
        transitiveClosurePanel.setLayout(transitiveClosurePanelLayout);
        transitiveClosurePanelLayout.setHorizontalGroup(
            transitiveClosurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transitiveClosureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        transitiveClosurePanelLayout.setVerticalGroup(
            transitiveClosurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transitiveClosureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(transitiveClosurePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 170, 40));

        optionalPanel.setBackground(new java.awt.Color(51, 102, 255));

        optionalLabel.setBackground(new java.awt.Color(255, 255, 255));
        optionalLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        optionalLabel.setForeground(new java.awt.Color(255, 255, 255));
        optionalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        optionalLabel.setText("Opcional");
        optionalLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        optionalLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionalLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                optionalLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                optionalLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout optionalPanelLayout = new javax.swing.GroupLayout(optionalPanel);
        optionalPanel.setLayout(optionalPanelLayout);
        optionalPanelLayout.setHorizontalGroup(
            optionalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(optionalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        optionalPanelLayout.setVerticalGroup(
            optionalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(optionalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(optionalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 170, 40));

        rAFNPanel.setBackground(new java.awt.Color(51, 102, 255));

        rAFNLabel.setBackground(new java.awt.Color(255, 255, 255));
        rAFNLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        rAFNLabel.setForeground(new java.awt.Color(255, 255, 255));
        rAFNLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rAFNLabel.setText("R->AFN");
        rAFNLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rAFNLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rAFNLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rAFNLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rAFNLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout rAFNPanelLayout = new javax.swing.GroupLayout(rAFNPanel);
        rAFNPanel.setLayout(rAFNPanelLayout);
        rAFNPanelLayout.setHorizontalGroup(
            rAFNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rAFNLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        rAFNPanelLayout.setVerticalGroup(
            rAFNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rAFNLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(rAFNPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 170, 40));

        lexicalAnalyzerPanel.setBackground(new java.awt.Color(51, 102, 255));

        lexicalAnalyzerLabel.setBackground(new java.awt.Color(255, 255, 255));
        lexicalAnalyzerLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lexicalAnalyzerLabel.setForeground(new java.awt.Color(255, 255, 255));
        lexicalAnalyzerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lexicalAnalyzerLabel.setText("Unión para analizador léxico");
        lexicalAnalyzerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lexicalAnalyzerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lexicalAnalyzerLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lexicalAnalyzerLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lexicalAnalyzerLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout lexicalAnalyzerPanelLayout = new javax.swing.GroupLayout(lexicalAnalyzerPanel);
        lexicalAnalyzerPanel.setLayout(lexicalAnalyzerPanelLayout);
        lexicalAnalyzerPanelLayout.setHorizontalGroup(
            lexicalAnalyzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lexicalAnalyzerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lexicalAnalyzerPanelLayout.setVerticalGroup(
            lexicalAnalyzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lexicalAnalyzerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(lexicalAnalyzerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 170, 40));

        converterPanel.setBackground(new java.awt.Color(51, 102, 255));

        converterLabel.setBackground(new java.awt.Color(255, 255, 255));
        converterLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        converterLabel.setForeground(new java.awt.Color(255, 255, 255));
        converterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        converterLabel.setText("Convertir AFN a AFD");
        converterLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        converterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                converterLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                converterLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                converterLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout converterPanelLayout = new javax.swing.GroupLayout(converterPanel);
        converterPanel.setLayout(converterPanelLayout);
        converterPanelLayout.setHorizontalGroup(
            converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(converterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        converterPanelLayout.setVerticalGroup(
            converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(converterLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(converterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 170, 40));

        stringAnalyzerPanel.setBackground(new java.awt.Color(51, 102, 255));

        stringAnalyzerLabel.setBackground(new java.awt.Color(255, 255, 255));
        stringAnalyzerLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stringAnalyzerLabel.setForeground(new java.awt.Color(255, 255, 255));
        stringAnalyzerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stringAnalyzerLabel.setText("Analizar una cadena");
        stringAnalyzerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stringAnalyzerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stringAnalyzerLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stringAnalyzerLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stringAnalyzerLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout stringAnalyzerPanelLayout = new javax.swing.GroupLayout(stringAnalyzerPanel);
        stringAnalyzerPanel.setLayout(stringAnalyzerPanelLayout);
        stringAnalyzerPanelLayout.setHorizontalGroup(
            stringAnalyzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stringAnalyzerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        stringAnalyzerPanelLayout.setVerticalGroup(
            stringAnalyzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stringAnalyzerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(stringAnalyzerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 170, 40));

        testLexicalAnalyzerPanel.setBackground(new java.awt.Color(51, 102, 255));

        testLexicalAnalyzerLabel.setBackground(new java.awt.Color(255, 255, 255));
        testLexicalAnalyzerLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        testLexicalAnalyzerLabel.setForeground(new java.awt.Color(255, 255, 255));
        testLexicalAnalyzerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        testLexicalAnalyzerLabel.setText("Probar analizador léxico");
        testLexicalAnalyzerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        testLexicalAnalyzerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                testLexicalAnalyzerLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                testLexicalAnalyzerLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                testLexicalAnalyzerLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout testLexicalAnalyzerPanelLayout = new javax.swing.GroupLayout(testLexicalAnalyzerPanel);
        testLexicalAnalyzerPanel.setLayout(testLexicalAnalyzerPanelLayout);
        testLexicalAnalyzerPanelLayout.setHorizontalGroup(
            testLexicalAnalyzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(testLexicalAnalyzerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        testLexicalAnalyzerPanelLayout.setVerticalGroup(
            testLexicalAnalyzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(testLexicalAnalyzerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        functionsPanel.add(testLexicalAnalyzerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 170, 40));

        background.add(functionsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 440));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        mainLabel.setBackground(new java.awt.Color(102, 102, 102));
        mainLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(153, 153, 153));
        mainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel.setText("Id de AFNs:");
        mainLabel.setToolTipText("");

        afnList.setBackground(new java.awt.Color(255, 255, 255));
        afnList.setBorder(null);
        afnList.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        afnList.setForeground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(afnList);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(mainLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        background.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 430, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void basicLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basicLabelMouseEntered
        basicPanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_basicLabelMouseEntered

    private void basicLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basicLabelMouseExited
        basicPanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_basicLabelMouseExited

    private void mergeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mergeLabelMouseExited
        mergePanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_mergeLabelMouseExited

    private void mergeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mergeLabelMouseEntered
        mergePanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_mergeLabelMouseEntered

    private void concatenateLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_concatenateLabelMouseEntered
        concatenatePanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_concatenateLabelMouseEntered

    private void concatenateLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_concatenateLabelMouseExited
        concatenatePanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_concatenateLabelMouseExited

    private void kleenClosureLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kleenClosureLabelMouseEntered
        kleenClosurePanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_kleenClosureLabelMouseEntered

    private void kleenClosureLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kleenClosureLabelMouseExited
        kleenClosurePanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_kleenClosureLabelMouseExited

    private void transitiveClosureLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transitiveClosureLabelMouseEntered
        transitiveClosurePanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_transitiveClosureLabelMouseEntered

    private void transitiveClosureLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transitiveClosureLabelMouseExited
        transitiveClosurePanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_transitiveClosureLabelMouseExited

    private void optionalLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionalLabelMouseEntered
        optionalPanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_optionalLabelMouseEntered

    private void optionalLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionalLabelMouseExited
        optionalPanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_optionalLabelMouseExited

    private void rAFNLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rAFNLabelMouseEntered
        rAFNPanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_rAFNLabelMouseEntered

    private void rAFNLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rAFNLabelMouseExited
        rAFNPanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_rAFNLabelMouseExited

    private void lexicalAnalyzerLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lexicalAnalyzerLabelMouseEntered
        lexicalAnalyzerPanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_lexicalAnalyzerLabelMouseEntered

    private void lexicalAnalyzerLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lexicalAnalyzerLabelMouseExited
        lexicalAnalyzerPanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_lexicalAnalyzerLabelMouseExited

    private void converterLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_converterLabelMouseEntered
        converterPanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_converterLabelMouseEntered

    private void converterLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_converterLabelMouseExited
        converterPanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_converterLabelMouseExited

    private void stringAnalyzerLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stringAnalyzerLabelMouseEntered
        stringAnalyzerPanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_stringAnalyzerLabelMouseEntered

    private void stringAnalyzerLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stringAnalyzerLabelMouseExited
        stringAnalyzerPanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_stringAnalyzerLabelMouseExited

    private void testLexicalAnalyzerLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testLexicalAnalyzerLabelMouseEntered
        testLexicalAnalyzerPanel.setBackground(new Color(86, 127, 250));
    }//GEN-LAST:event_testLexicalAnalyzerLabelMouseEntered

    private void testLexicalAnalyzerLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testLexicalAnalyzerLabelMouseExited
        testLexicalAnalyzerPanel.setBackground(new Color(51, 102, 255));
    }//GEN-LAST:event_testLexicalAnalyzerLabelMouseExited

    private void basicLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basicLabelMouseClicked
        AFN nfa = new AFN();
        String[] options = { "Símbolo", "Rango" };
        int option = JOptionPane.showOptionDialog(null, "Elige una: ", "Opciones", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if(option == 0){
            String input = JOptionPane.showInputDialog("Inserta el símbolo del AFN básico");
            char symbol = input.charAt(0);
            nfa.crearAFNBasico(symbol);
            JOptionPane.showMessageDialog(this, "AFN Básico creado con símbolos: " + symbol + "\n"
                    + "Con id: " + nfa.id 
            );
            updateData();
        }else{
            String input = JOptionPane.showInputDialog("Inserta el símbolo inferior del AFN básico");
            char lowerSymbol = input.charAt(0);
            input = JOptionPane.showInputDialog("Inserta el símbolo superior del AFN básico");
            char upperSymbol = input.charAt(0);
            nfa.crearAFNBasico(lowerSymbol, upperSymbol);
            JOptionPane.showMessageDialog(this, "AFN Básico creado con símbolos: [" + lowerSymbol + "," + upperSymbol + "]" + "\n"
                    + "Con id: " + nfa.id 
            );
            updateData();
        }
        
    }//GEN-LAST:event_basicLabelMouseClicked

    private void mergeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mergeLabelMouseClicked
        String idArray[] = new String[ids_afd.size()];
        ids_afd.toArray(idArray);
        String selectedId = (String) JOptionPane.showInputDialog(null, "Seleccione un AFN", "Opciones", JOptionPane.DEFAULT_OPTION,
                null, idArray, idArray[0]);
        System.out.println("Id seleccionado: " + selectedId);
        String mergingId = (String) JOptionPane.showInputDialog(null, "Une un AFN", "Opciones", JOptionPane.DEFAULT_OPTION,
                null, idArray, idArray[0]);
        AFN nfaToMerge = new AFN();
        AFN globalNFA = new AFN();
        for(AFN nfa: globalNFA.conjunto_afn ){
            if(nfa.id == Integer.parseInt(mergingId))
                nfaToMerge = nfa;
          
        }
        
        for(AFN baseNFA: globalNFA.conjunto_afn ){
            if(baseNFA.id == Integer.parseInt(selectedId)){
                baseNFA = baseNFA.unirAFN(nfaToMerge);
                AFN.borrarAFN(nfaToMerge);
                break;
            }
        }
        
        updateData();
    }//GEN-LAST:event_mergeLabelMouseClicked

    private void concatenateLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_concatenateLabelMouseClicked
        String idArray[] = new String[ids_afd.size()];
        ids_afd.toArray(idArray);
        String selectedId = (String) JOptionPane.showInputDialog(null, "Seleccione un AFN", "Opciones", JOptionPane.DEFAULT_OPTION,
                null, idArray, idArray[0]);
        System.out.println("Id seleccionado: " + selectedId);
        String concatenatingId = (String) JOptionPane.showInputDialog(null, "Concatena un AFN", "Opciones", JOptionPane.DEFAULT_OPTION,
                null, idArray, idArray[0]);
        AFN nfaToConcatenate = new AFN();
        AFN globalNFA = new AFN();
        
        for(AFN nfa: globalNFA.conjunto_afn ){
            if(nfa.id == Integer.parseInt(concatenatingId))
                nfaToConcatenate = nfa;
                    
        }
        
        for(AFN baseNFA: globalNFA.conjunto_afn ){
            if(baseNFA.id == Integer.parseInt(selectedId)){
                baseNFA = baseNFA.concatenarAFN(nfaToConcatenate);
                AFN.borrarAFN(nfaToConcatenate);
                break;
            }
        }
        
        updateData();
    }//GEN-LAST:event_concatenateLabelMouseClicked

    private void kleenClosureLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kleenClosureLabelMouseClicked
        String idArray[] = new String[ids_afd.size()];
        ids_afd.toArray(idArray);
        String selectedId = (String) JOptionPane.showInputDialog(null, "Seleccione un AFN", "Opciones", JOptionPane.DEFAULT_OPTION,
                null, idArray, idArray[0]);
        System.out.println("Selected ID: " + selectedId);
        AFN globalNFA = new AFN();
        for(AFN nfa: globalNFA.conjunto_afn){
            if(nfa.id == Integer.parseInt(selectedId))
                nfa.cerraduraKleen();
        }
    }//GEN-LAST:event_kleenClosureLabelMouseClicked

    private void transitiveClosureLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transitiveClosureLabelMouseClicked
        String idArray[] = new String[ids_afd.size()];
        ids_afd.toArray(idArray);
        String selectedId = (String) JOptionPane.showInputDialog(null, "Seleccione un AFN", "Opciones", JOptionPane.DEFAULT_OPTION,
                null, idArray, idArray[0]);
        System.out.println("Selected ID: " + selectedId);
        AFN globalNFA = new AFN();
        for(AFN nfa: globalNFA.conjunto_afn){
            if(nfa.id == Integer.parseInt(selectedId))
                nfa.cerraduraTransitiva();
        }
    }//GEN-LAST:event_transitiveClosureLabelMouseClicked

    private void optionalLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionalLabelMouseClicked
        String idArray[] = new String[ids_afd.size()];
        ids_afd.toArray(idArray);
        String selectedId = (String) JOptionPane.showInputDialog(null, "Seleccione un AFN", "Opciones", JOptionPane.DEFAULT_OPTION,
                null, idArray, idArray[0]);
        System.out.println("Selected ID: " + selectedId);
        AFN globalNFA = new AFN();
        for(AFN nfa: globalNFA.conjunto_afn){
            if(nfa.id == Integer.parseInt(selectedId))
                nfa.opcional();
        }
    }//GEN-LAST:event_optionalLabelMouseClicked

    private void rAFNLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rAFNLabelMouseClicked
        String expresion_regular = JOptionPane.showInputDialog("Inserta Una expresión regular");
        System.out.println(expresion_regular);
    }//GEN-LAST:event_rAFNLabelMouseClicked

    private void lexicalAnalyzerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lexicalAnalyzerLabelMouseClicked
        JFrame frame = new JFrame();
        JLabel label = new JLabel("Selecciona los automatas:");
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");
        JLabel automatas = new JLabel("Automatas:");
        
        frame.setSize(500, 500);
        
        label.setBounds(10, 10, 500, 20);
        label.setFont(new Font(null, Font.PLAIN, 12));
        
        automatas.setBounds(10, 400, 100, 20);
        
        acceptButton.setBounds(400, 400, 100, 50);
        acceptButton.setVisible(true);
        
        cancelButton.setBounds(300, 400, 100, 50);
        cancelButton.setVisible(true);
        
        
        String[] ids = new String[ids_afd.size()];
        ids_afd.toArray(ids);
        
        JList ListaIds = new JList(ids);
        ListaIds.setBounds(50, 100, 400, 200);
        ListaIds.setVisibleRowCount(8);
        
        JScrollPane jcp = new JScrollPane(ListaIds);
        
        ListaIds.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        ListaIds.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                String idSeleccionado = ListaIds.getSelectedValue().toString();
                automatas.setText(idSeleccionado);
                ids_seleccionados.add(idSeleccionado);
            }
        });
        
        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               AFN.unionEspecial(ids_seleccionados);
               updateData();
               frame.dispose();
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ids_seleccionados.clear();
               frame.dispose();
            }
        });
        
        frame.add(label);
        frame.add(automatas);
        frame.add(acceptButton);
        frame.add(cancelButton);
        frame.add(ListaIds);
        frame.add(jcp);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }//GEN-LAST:event_lexicalAnalyzerLabelMouseClicked
    
    private void converterLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_converterLabelMouseClicked
        try {
            String idArray[] = new String[ids_afd.size()];
            ids_afd.toArray(idArray);
            String selectedId = (String) JOptionPane.showInputDialog(null, "Seleccione un AFN", "Opciones", JOptionPane.DEFAULT_OPTION,
                    null, idArray, idArray[0]);
            System.out.println("Selected ID: " + selectedId);
            AFN globalNFA = new AFN();

            for(AFN nfa: globalNFA.conjunto_afn ){
                if(nfa.id == Integer.parseInt(selectedId))
                    nfa.convertirAFNaAFD();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_converterLabelMouseClicked

    private void stringAnalyzerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stringAnalyzerLabelMouseClicked
        JOptionPane.showMessageDialog(this, "Analizar una cadena");
    }//GEN-LAST:event_stringAnalyzerLabelMouseClicked

    private void testLexicalAnalyzerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testLexicalAnalyzerLabelMouseClicked
        JOptionPane.showMessageDialog(this, "Probar el analizador léxico");
    }//GEN-LAST:event_testLexicalAnalyzerLabelMouseClicked
    
    public void updateData(){
        afnList.setVisible(false);
        ids_afd.clear();
        for(AFN afn: AFN.conjunto_afn) {
            ids_afd.add(Integer.toString(afn.id));
        }
        
        String[] ids_arreglo = new String[ids_afd.size()];
        ids_afd.toArray(ids_arreglo);
        afnList.setListData(ids_arreglo);
        afnList.setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> afnList;
    private javax.swing.JPanel background;
    private javax.swing.JLabel basicLabel;
    private javax.swing.JPanel basicPanel;
    private javax.swing.JLabel concatenateLabel;
    private javax.swing.JPanel concatenatePanel;
    private javax.swing.JLabel converterLabel;
    private javax.swing.JPanel converterPanel;
    private javax.swing.JPanel functionsPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kleenClosureLabel;
    private javax.swing.JPanel kleenClosurePanel;
    private javax.swing.JLabel lexicalAnalyzerLabel;
    private javax.swing.JPanel lexicalAnalyzerPanel;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mergeLabel;
    private javax.swing.JPanel mergePanel;
    private javax.swing.JLabel optionalLabel;
    private javax.swing.JPanel optionalPanel;
    private javax.swing.JLabel rAFNLabel;
    private javax.swing.JPanel rAFNPanel;
    private javax.swing.JLabel stringAnalyzerLabel;
    private javax.swing.JPanel stringAnalyzerPanel;
    private javax.swing.JLabel testLexicalAnalyzerLabel;
    private javax.swing.JPanel testLexicalAnalyzerPanel;
    private javax.swing.JLabel transitiveClosureLabel;
    private javax.swing.JPanel transitiveClosurePanel;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
