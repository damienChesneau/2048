package fr.damienchesneau.ugame.client;

import fr.damienchesneau.ugame.client.font.FontGame;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * IHM utilisateur.
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
class Window extends javax.swing.JFrame {

    private final Commands cmds;
    
    Window(Commands commands) {
        initComponents();
        cmds = commands;
        this.getContentPane().setBackground(Color.WHITE);
        this.jPanelCommands.setBackground(Color.WHITE);
        addKeyListener(commands);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new GameWindowListener(this, commands.getPlateau()));
        this.jButtonRetry.setFont(new Font(fontGameName, 50, 20));
        this.jButtonSolveGame.setFont(new Font(fontGameName, 50, 20));
        this.jLabel1.setFont(new Font(fontGameName, 50, 20));
        this.jLabel2.setFont(new Font(fontGameName, 50, 15));
        pack();
        setTitle("2048");
        setVisible(true);
    }

    public Window(Commands commands,int newHeight) throws HeadlessException {
        this(commands);
        this.setSize(600, 600);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCommands = new javax.swing.JPanel();
        jButtonRetry = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonSolveGame = new javax.swing.JButton();
        jPanelPlateau = new javax.swing.JPanel();
        jPanelColumn1Cell1 = new javax.swing.JPanel();
        jLabelColumn1Cell1 = new javax.swing.JLabel();
        jPanelColumn4Cell1 = new javax.swing.JPanel();
        jLabelColumn4Cell1 = new javax.swing.JLabel();
        jPanelColumn2Cell2 = new javax.swing.JPanel();
        jLabelColumn2Cell2 = new javax.swing.JLabel();
        jPanelColumn2Cell1 = new javax.swing.JPanel();
        jLabelColumn2Cell1 = new javax.swing.JLabel();
        jPanelColumn4Cell3 = new javax.swing.JPanel();
        jLabelColumn4Cell3 = new javax.swing.JLabel();
        jPanelColumn1Cell3 = new javax.swing.JPanel();
        jLabelColumn1Cell3 = new javax.swing.JLabel();
        jPanelColumn3Cell1 = new javax.swing.JPanel();
        jLabelColumn3Cell1 = new javax.swing.JLabel();
        jPanelColumn1Cell2 = new javax.swing.JPanel();
        jLabelColumn1Cell2 = new javax.swing.JLabel();
        jPanelColumn2Cell3 = new javax.swing.JPanel();
        jLabelColumn2Cell3 = new javax.swing.JLabel();
        jPanelColumn3Cell2 = new javax.swing.JPanel();
        jLabelColumn3Cell2 = new javax.swing.JLabel();
        jPanelColumn4Cell2 = new javax.swing.JPanel();
        jLabelColumn4Cell2 = new javax.swing.JLabel();
        jPanelColumn3Cell3 = new javax.swing.JPanel();
        jLabelColumn3Cell3 = new javax.swing.JLabel();
        jPanelColumn1Cell4 = new javax.swing.JPanel();
        jLabelColumn1Cell4 = new javax.swing.JLabel();
        jPanelColumn2Cell4 = new javax.swing.JPanel();
        jLabelColumn2Cell4 = new javax.swing.JLabel();
        jPanelColumn3Cell4 = new javax.swing.JPanel();
        jLabelColumn3Cell4 = new javax.swing.JLabel();
        jPanelColumn4Cell4 = new javax.swing.JPanel();
        jLabelColumn4Cell4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelCommands.setPreferredSize(new java.awt.Dimension(445, 80));

        jButtonRetry.setBackground(new java.awt.Color(143, 122, 102));
        jButtonRetry.setForeground(new java.awt.Color(249, 246, 242));
        jButtonRetry.setText("Retry");
        jButtonRetry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetryActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(187, 173, 160));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SCORE");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("160");
        jLabel2.setToolTipText("");
        jLabel2.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonSolveGame.setBackground(new java.awt.Color(143, 122, 102));
        jButtonSolveGame.setForeground(new java.awt.Color(249, 246, 242));
        jButtonSolveGame.setText("Solve");
        jButtonSolveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSolveGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCommandsLayout = new javax.swing.GroupLayout(jPanelCommands);
        jPanelCommands.setLayout(jPanelCommandsLayout);
        jPanelCommandsLayout.setHorizontalGroup(
            jPanelCommandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCommandsLayout.createSequentialGroup()
                .addComponent(jButtonRetry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSolveGame, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelCommandsLayout.setVerticalGroup(
            jPanelCommandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCommandsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCommandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSolveGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRetry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelPlateau.setBackground(new java.awt.Color(187, 173, 160));
        jPanelPlateau.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanelColumn1Cell1.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn1Cell1.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn1Cell1Layout = new javax.swing.GroupLayout(jPanelColumn1Cell1);
        jPanelColumn1Cell1.setLayout(jPanelColumn1Cell1Layout);
        jPanelColumn1Cell1Layout.setHorizontalGroup(
            jPanelColumn1Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelColumn1Cell1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelColumn1Cell1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelColumn1Cell1Layout.setVerticalGroup(
            jPanelColumn1Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelColumn1Cell1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabelColumn1Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanelColumn4Cell1.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn4Cell1.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn4Cell1Layout = new javax.swing.GroupLayout(jPanelColumn4Cell1);
        jPanelColumn4Cell1.setLayout(jPanelColumn4Cell1Layout);
        jPanelColumn4Cell1Layout.setHorizontalGroup(
            jPanelColumn4Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn4Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn4Cell1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn4Cell1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn4Cell1Layout.setVerticalGroup(
            jPanelColumn4Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn4Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn4Cell1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn4Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn2Cell2.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn2Cell2.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn2Cell2Layout = new javax.swing.GroupLayout(jPanelColumn2Cell2);
        jPanelColumn2Cell2.setLayout(jPanelColumn2Cell2Layout);
        jPanelColumn2Cell2Layout.setHorizontalGroup(
            jPanelColumn2Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn2Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn2Cell2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn2Cell2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn2Cell2Layout.setVerticalGroup(
            jPanelColumn2Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn2Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn2Cell2Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn2Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn2Cell1.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn2Cell1.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn2Cell1Layout = new javax.swing.GroupLayout(jPanelColumn2Cell1);
        jPanelColumn2Cell1.setLayout(jPanelColumn2Cell1Layout);
        jPanelColumn2Cell1Layout.setHorizontalGroup(
            jPanelColumn2Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn2Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn2Cell1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn2Cell1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn2Cell1Layout.setVerticalGroup(
            jPanelColumn2Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn2Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn2Cell1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn2Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn4Cell3.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn4Cell3.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn4Cell3Layout = new javax.swing.GroupLayout(jPanelColumn4Cell3);
        jPanelColumn4Cell3.setLayout(jPanelColumn4Cell3Layout);
        jPanelColumn4Cell3Layout.setHorizontalGroup(
            jPanelColumn4Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn4Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn4Cell3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn4Cell3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn4Cell3Layout.setVerticalGroup(
            jPanelColumn4Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn4Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn4Cell3Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn4Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn1Cell3.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn1Cell3.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn1Cell3Layout = new javax.swing.GroupLayout(jPanelColumn1Cell3);
        jPanelColumn1Cell3.setLayout(jPanelColumn1Cell3Layout);
        jPanelColumn1Cell3Layout.setHorizontalGroup(
            jPanelColumn1Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn1Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn1Cell3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn1Cell3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn1Cell3Layout.setVerticalGroup(
            jPanelColumn1Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn1Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn1Cell3Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn1Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn3Cell1.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn3Cell1.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn3Cell1Layout = new javax.swing.GroupLayout(jPanelColumn3Cell1);
        jPanelColumn3Cell1.setLayout(jPanelColumn3Cell1Layout);
        jPanelColumn3Cell1Layout.setHorizontalGroup(
            jPanelColumn3Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn3Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn3Cell1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn3Cell1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn3Cell1Layout.setVerticalGroup(
            jPanelColumn3Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn3Cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn3Cell1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn3Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn1Cell2.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn1Cell2.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn1Cell2Layout = new javax.swing.GroupLayout(jPanelColumn1Cell2);
        jPanelColumn1Cell2.setLayout(jPanelColumn1Cell2Layout);
        jPanelColumn1Cell2Layout.setHorizontalGroup(
            jPanelColumn1Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn1Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn1Cell2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn1Cell2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn1Cell2Layout.setVerticalGroup(
            jPanelColumn1Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn1Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn1Cell2Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn1Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn2Cell3.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn2Cell3.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn2Cell3Layout = new javax.swing.GroupLayout(jPanelColumn2Cell3);
        jPanelColumn2Cell3.setLayout(jPanelColumn2Cell3Layout);
        jPanelColumn2Cell3Layout.setHorizontalGroup(
            jPanelColumn2Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn2Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn2Cell3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn2Cell3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn2Cell3Layout.setVerticalGroup(
            jPanelColumn2Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn2Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn2Cell3Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn2Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn3Cell2.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn3Cell2.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn3Cell2Layout = new javax.swing.GroupLayout(jPanelColumn3Cell2);
        jPanelColumn3Cell2.setLayout(jPanelColumn3Cell2Layout);
        jPanelColumn3Cell2Layout.setHorizontalGroup(
            jPanelColumn3Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn3Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn3Cell2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn3Cell2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn3Cell2Layout.setVerticalGroup(
            jPanelColumn3Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn3Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn3Cell2Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn3Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn4Cell2.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn4Cell2.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn4Cell2Layout = new javax.swing.GroupLayout(jPanelColumn4Cell2);
        jPanelColumn4Cell2.setLayout(jPanelColumn4Cell2Layout);
        jPanelColumn4Cell2Layout.setHorizontalGroup(
            jPanelColumn4Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn4Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn4Cell2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn4Cell2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn4Cell2Layout.setVerticalGroup(
            jPanelColumn4Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn4Cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn4Cell2Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn4Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn3Cell3.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn3Cell3.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn3Cell3Layout = new javax.swing.GroupLayout(jPanelColumn3Cell3);
        jPanelColumn3Cell3.setLayout(jPanelColumn3Cell3Layout);
        jPanelColumn3Cell3Layout.setHorizontalGroup(
            jPanelColumn3Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn3Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn3Cell3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn3Cell3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn3Cell3Layout.setVerticalGroup(
            jPanelColumn3Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn3Cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn3Cell3Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn3Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn1Cell4.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn1Cell4.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn1Cell4Layout = new javax.swing.GroupLayout(jPanelColumn1Cell4);
        jPanelColumn1Cell4.setLayout(jPanelColumn1Cell4Layout);
        jPanelColumn1Cell4Layout.setHorizontalGroup(
            jPanelColumn1Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn1Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn1Cell4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn1Cell4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn1Cell4Layout.setVerticalGroup(
            jPanelColumn1Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn1Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn1Cell4Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn1Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn2Cell4.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn2Cell4.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn2Cell4Layout = new javax.swing.GroupLayout(jPanelColumn2Cell4);
        jPanelColumn2Cell4.setLayout(jPanelColumn2Cell4Layout);
        jPanelColumn2Cell4Layout.setHorizontalGroup(
            jPanelColumn2Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn2Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn2Cell4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn2Cell4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn2Cell4Layout.setVerticalGroup(
            jPanelColumn2Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn2Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn2Cell4Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn2Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn3Cell4.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn3Cell4.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn3Cell4Layout = new javax.swing.GroupLayout(jPanelColumn3Cell4);
        jPanelColumn3Cell4.setLayout(jPanelColumn3Cell4Layout);
        jPanelColumn3Cell4Layout.setHorizontalGroup(
            jPanelColumn3Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn3Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn3Cell4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn3Cell4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn3Cell4Layout.setVerticalGroup(
            jPanelColumn3Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn3Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn3Cell4Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn3Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jPanelColumn4Cell4.setBackground(new java.awt.Color(238, 228, 218));
        jPanelColumn4Cell4.setPreferredSize(new java.awt.Dimension(106, 106));

        javax.swing.GroupLayout jPanelColumn4Cell4Layout = new javax.swing.GroupLayout(jPanelColumn4Cell4);
        jPanelColumn4Cell4.setLayout(jPanelColumn4Cell4Layout);
        jPanelColumn4Cell4Layout.setHorizontalGroup(
            jPanelColumn4Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn4Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn4Cell4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelColumn4Cell4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelColumn4Cell4Layout.setVerticalGroup(
            jPanelColumn4Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanelColumn4Cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelColumn4Cell4Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelColumn4Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanelPlateauLayout = new javax.swing.GroupLayout(jPanelPlateau);
        jPanelPlateau.setLayout(jPanelPlateauLayout);
        jPanelPlateauLayout.setHorizontalGroup(
            jPanelPlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlateauLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPlateauLayout.createSequentialGroup()
                        .addComponent(jPanelColumn1Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelColumn2Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelColumn3Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelColumn4Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPlateauLayout.createSequentialGroup()
                        .addGroup(jPanelPlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelColumn1Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelColumn1Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPlateauLayout.createSequentialGroup()
                                .addComponent(jPanelColumn2Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelColumn3Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelColumn4Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelPlateauLayout.createSequentialGroup()
                                .addComponent(jPanelColumn2Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jPanelColumn3Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelColumn4Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelPlateauLayout.createSequentialGroup()
                        .addComponent(jPanelColumn1Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelColumn2Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelColumn3Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelColumn4Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelPlateauLayout.setVerticalGroup(
            jPanelPlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlateauLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelColumn1Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelColumn3Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelColumn4Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelColumn2Cell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelPlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelColumn2Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelColumn3Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelColumn4Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelColumn1Cell2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelPlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPlateauLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanelPlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelColumn1Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelColumn2Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelColumn3Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelColumn4Cell3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelColumn1Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelColumn2Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelColumn3Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelPlateauLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jPanelColumn4Cell4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelPlateau, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addComponent(jPanelCommands, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCommands, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelPlateau, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetryActionPerformed
        this.cmds.retry();
    }//GEN-LAST:event_jButtonRetryActionPerformed

    private void jButtonSolveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSolveGameActionPerformed
       this.cmds.solveGame();
    }//GEN-LAST:event_jButtonSolveGameActionPerformed
    /**
     *
     * @return if the user want's to retry or not.
     */
    public boolean infoGameOver() {
        if(JOptionPane.showConfirmDialog(this, "Game over !\n You want to retry ? ", "Game over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            return true;
        } 
        return false;
    }

    public void printPlateau(int[][] tab) {
        initPlat();
        setColumn1Cell1Value(tab[0][0]);
        setColumn1Cell2Value(tab[0][1]);
        setColumn1Cell3Value(tab[0][2]);
        setColumn1Cell4Value(tab[0][3]);
        setColumn2Cell1Value(tab[1][0]);
        setColumn2Cell2Value(tab[1][1]);
        setColumn2Cell3Value(tab[1][2]);
        setColumn2Cell4Value(tab[1][3]);
        setColumn3Cell1Value(tab[2][0]);
        setColumn3Cell2Value(tab[2][1]);
        setColumn3Cell3Value(tab[2][2]);
        setColumn3Cell4Value(tab[2][3]);
        setColumn4Cell1Value(tab[3][0]);
        setColumn4Cell2Value(tab[3][1]);
        setColumn4Cell3Value(tab[3][2]);
        setColumn4Cell4Value(tab[3][3]);
    }

    private void initPlat() {
        setColumn1Cell1Value(0);
        setColumn1Cell2Value(0);
        setColumn1Cell3Value(0);
        setColumn1Cell4Value(0);
        setColumn2Cell1Value(0);
        setColumn2Cell2Value(0);
        setColumn2Cell3Value(0);
        setColumn2Cell4Value(0);
        setColumn3Cell1Value(0);
        setColumn3Cell2Value(0);
        setColumn3Cell3Value(0);
        setColumn3Cell4Value(0);
        setColumn4Cell1Value(0);
        setColumn4Cell2Value(0);
        setColumn4Cell3Value(0);
        setColumn4Cell4Value(0);
    }

    public void setColumn1Cell1Value(int level) {
        updateLevel(level, 1, 1);
    }

    public void setColumn1Cell2Value(int level) {
        updateLevel(level, 1, 2);
    }

    public void setColumn1Cell3Value(int level) {
        updateLevel(level, 1, 3);
    }

    public void setColumn1Cell4Value(int level) {
        updateLevel(level, 1, 4);
    }

    public void setColumn2Cell1Value(int level) {
        updateLevel(level, 2, 1);
    }

    public void setColumn2Cell2Value(int level) {
        updateLevel(level, 2, 2);
    }

    public void setColumn2Cell3Value(int level) {
        updateLevel(level, 2, 3);
    }

    public void setColumn2Cell4Value(int level) {
        updateLevel(level, 2, 4);
    }

    public void setColumn3Cell1Value(int level) {
        updateLevel(level, 3, 1);
    }

    public void setColumn3Cell2Value(int level) {
        updateLevel(level, 3, 2);
    }

    public void setColumn3Cell3Value(int level) {
        updateLevel(level, 3, 3);
    }

    public void setColumn3Cell4Value(int level) {
        updateLevel(level, 3, 4);
    }

    public void setColumn4Cell1Value(int level) {
        updateLevel(level, 4, 1);
    }

    public void setColumn4Cell2Value(int level) {
        updateLevel(level, 4, 2);
    }

    public void setColumn4Cell3Value(int level) {
        updateLevel(level, 4, 3);
    }

    public void setColumn4Cell4Value(int level) {
        updateLevel(level, 4, 4);
    }

    private void updateLevel(int level, int column, int cell) {
        JPanel jpanel = null;
        JLabel jlabel = null;
        try {
            jpanel = (JPanel) this.getClass().getDeclaredField("jPanelColumn" + column + "Cell" + cell).get(this);
            jlabel = (JLabel) this.getClass().getDeclaredField("jLabelColumn" + column + "Cell" + cell).get(this);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlabel.setHorizontalAlignment(SwingConstants.CENTER);
        switch (level) {
            case 0:
                jlabel.setBackground(standard.getBackgroundColor());
                jlabel.setText("");
                jlabel.repaint();
                jpanel.setBackground(standard.getBackgroundColor());
                jpanel.repaint();
                this.repaint();
                break;
            case 2:
                jlabel.setForeground(level1Color.getFontColor());
                jlabel.setFont(level1Color.getFont());
                jlabel.setText("2");
                jpanel.setBackground(level1Color.getBackgroundColor());
                break;
            case 4:
                jlabel.setForeground(level2Color.getFontColor());
                jlabel.setFont(level2Color.getFont());
                jlabel.setText("4");
                jpanel.setBackground(level2Color.getBackgroundColor());
                break;
            case 8:
                jlabel.setForeground(level3Color.getFontColor());
                jlabel.setFont(level3Color.getFont());
                jlabel.setText("8");
                jpanel.setBackground(level3Color.getBackgroundColor());
                break;
            case 16:
                jlabel.setForeground(level4Color.getFontColor());
                jlabel.setFont(level4Color.getFont());
                jlabel.setText("16");
                jpanel.setBackground(level4Color.getBackgroundColor());
                break;
            case 32:
                jlabel.setForeground(level5Color.getFontColor());
                jlabel.setFont(level5Color.getFont());
                jlabel.setText("32");
                jpanel.setBackground(level5Color.getBackgroundColor());
                break;
            case 64:
                jlabel.setForeground(level6Color.getFontColor());
                jlabel.setFont(level6Color.getFont());
                jlabel.setText("64");
                jpanel.setBackground(level6Color.getBackgroundColor());
                break;
            case 128:
                jlabel.setForeground(level7Color.getFontColor());
                jlabel.setFont(level7Color.getFont());
                jlabel.setText("128");
                jpanel.setBackground(level7Color.getBackgroundColor());
                break;
            case 256:
                jlabel.setForeground(level8Color.getFontColor());
                jlabel.setFont(level8Color.getFont());
                jlabel.setText("256");
                jpanel.setBackground(level8Color.getBackgroundColor());
                break;
            case 512:
                jlabel.setForeground(level9Color.getFontColor());
                jlabel.setFont(level9Color.getFont());
                jlabel.setText("512");
                jpanel.setBackground(level9Color.getBackgroundColor());
                break;
            case 1024:
                jlabel.setForeground(level10Color.getFontColor());
                jlabel.setFont(level10Color.getFont());
                jlabel.setText("1024");
                jpanel.setBackground(level10Color.getBackgroundColor());
                break;
            case 2048:
                jlabel.setForeground(level11Color.getFontColor());
                jlabel.setFont(level11Color.getFont());
                jlabel.setText("2048");
                jpanel.setBackground(level11Color.getBackgroundColor());
                break;
        }
        pack();
    }

    public void setScore(int score) {
        this.jLabel2.setText(String.valueOf(score));
    }

    private class PanelConfig {

        private final Font font;
        private final Color backgroudColor;
        private final Color fontColor;

        public PanelConfig(Font font, Color backgroudColor, Color fontColor) {
            this.font = font;
            this.backgroudColor = backgroudColor;
            this.fontColor = fontColor;
        }

        public Font getFont() {
            return font;
        }

        public Color getBackgroundColor() {
            return backgroudColor;
        }

        public Color getFontColor() {
            return fontColor;
        }
    }
    private static final String fontGameName;

    static {
        fontGameName = new FontGame().getFont(FontGame.FontGameAvalable.CLEAR_SANS_BOLD);
    }
    private final PanelConfig standard = new PanelConfig(null, new Color(238, 228, 218, 35), new Color(238, 228, 218, 35));
    private final PanelConfig level1Color = new PanelConfig(new Font(fontGameName, 107, 55), new Color(238, 228, 218, 255), new Color(119, 110, 101, 255));
    private final PanelConfig level2Color = new PanelConfig(new Font(fontGameName, 107, 55), new Color(237, 224, 200, 255), new Color(119, 110, 101, 255));
    private final PanelConfig level3Color = new PanelConfig(new Font(fontGameName, 107, 55), new Color(242, 177, 121, 255), new Color(249, 246, 242, 255));
    private final PanelConfig level4Color = new PanelConfig(new Font(fontGameName, 107, 55), new Color(245, 149, 99, 255), new Color(249, 246, 242, 255));
    private final PanelConfig level5Color = new PanelConfig(new Font(fontGameName, 107, 55), new Color(246, 124, 95, 255), new Color(249, 246, 242, 255));
    private final PanelConfig level6Color = new PanelConfig(new Font(fontGameName, 107, 55), new Color(246, 94, 59, 255), new Color(249, 246, 242, 255));
    private final PanelConfig level7Color = new PanelConfig(new Font(fontGameName, 107, 45), new Color(237, 207, 114, 255), new Color(249, 246, 242, 255));
    private final PanelConfig level8Color = new PanelConfig(new Font(fontGameName, 107, 45), new Color(237, 204, 97, 255), new Color(249, 246, 242, 255));
    private final PanelConfig level9Color = new PanelConfig(new Font(fontGameName, 107, 45), new Color(237, 200, 80, 255), new Color(249, 246, 242, 255));
    private final PanelConfig level10Color = new PanelConfig(new Font(fontGameName, 107, 35), new Color(237, 197, 63, 255), new Color(249, 246, 242, 255));
    private final PanelConfig level11Color = new PanelConfig(new Font(fontGameName, 120, 35), new Color(237, 194, 46, 255), new Color(249, 246, 242, 255));
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRetry;
    private javax.swing.JButton jButtonSolveGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelColumn1Cell1;
    private javax.swing.JLabel jLabelColumn1Cell2;
    private javax.swing.JLabel jLabelColumn1Cell3;
    private javax.swing.JLabel jLabelColumn1Cell4;
    private javax.swing.JLabel jLabelColumn2Cell1;
    private javax.swing.JLabel jLabelColumn2Cell2;
    private javax.swing.JLabel jLabelColumn2Cell3;
    private javax.swing.JLabel jLabelColumn2Cell4;
    private javax.swing.JLabel jLabelColumn3Cell1;
    private javax.swing.JLabel jLabelColumn3Cell2;
    private javax.swing.JLabel jLabelColumn3Cell3;
    private javax.swing.JLabel jLabelColumn3Cell4;
    private javax.swing.JLabel jLabelColumn4Cell1;
    private javax.swing.JLabel jLabelColumn4Cell2;
    private javax.swing.JLabel jLabelColumn4Cell3;
    private javax.swing.JLabel jLabelColumn4Cell4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelColumn1Cell1;
    private javax.swing.JPanel jPanelColumn1Cell2;
    private javax.swing.JPanel jPanelColumn1Cell3;
    private javax.swing.JPanel jPanelColumn1Cell4;
    private javax.swing.JPanel jPanelColumn2Cell1;
    private javax.swing.JPanel jPanelColumn2Cell2;
    private javax.swing.JPanel jPanelColumn2Cell3;
    private javax.swing.JPanel jPanelColumn2Cell4;
    private javax.swing.JPanel jPanelColumn3Cell1;
    private javax.swing.JPanel jPanelColumn3Cell2;
    private javax.swing.JPanel jPanelColumn3Cell3;
    private javax.swing.JPanel jPanelColumn3Cell4;
    private javax.swing.JPanel jPanelColumn4Cell1;
    private javax.swing.JPanel jPanelColumn4Cell2;
    private javax.swing.JPanel jPanelColumn4Cell3;
    private javax.swing.JPanel jPanelColumn4Cell4;
    private javax.swing.JPanel jPanelCommands;
    private javax.swing.JPanel jPanelPlateau;
    // End of variables declaration//GEN-END:variables
}
