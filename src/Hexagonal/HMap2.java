/*
 * HMap2.java
 *
 * Created on August 31, 2008, 4:00 PM
 */
package Hexagonal;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author  Joe Johnston
 */
public class HMap2 extends javax.swing.JFrame {
    private final String VERSION = "1.0";
    private int lastSize = -1;
    private Graphics dbg;
    private Image dbImage = null;
    private HexMap map;
    Color[] myColors = {Color.BLUE, Color.RED, Color.YELLOW,
        Color.CYAN, Color.GREEN, Color.MAGENTA,
    };
    int cycle = 0;
    StringBuffer msg = new StringBuffer();
    private boolean showMap = false;
    private boolean repaint = false;
    
    /** Creates new form HMap2 */
    public HMap2() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        lVersion.setText(VERSION);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bOK = new javax.swing.JButton();
        pMap = new javax.swing.JPanel();
        spMessage = new javax.swing.JScrollPane();
        tMessage = new javax.swing.JTextArea();
        cbSize = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbCols = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbRows = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        lVersion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hex map toy");
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        bOK.setText("Repaint");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        pMap.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pMapLayout = new javax.swing.GroupLayout(pMap);
        pMap.setLayout(pMapLayout);
        pMapLayout.setHorizontalGroup(
            pMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        pMapLayout.setVerticalGroup(
            pMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        tMessage.setColumns(20);
        tMessage.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        tMessage.setRows(5);
        spMessage.setViewportView(tMessage);

        cbSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "25", "50", "75", "100", "125" }));

        jLabel1.setText("Hex Size:");

        jLabel2.setText("Columns:");

        cbCols.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "5", "7", "9" }));

        jLabel3.setText("Rows:");

        cbRows.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "5", "7", "9" }));

        jLabel4.setText("Version:");

        lVersion.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCols, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cbRows, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bOK)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbCols, cbRows, cbSize});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pMap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spMessage, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCols, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbRows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bOK)
                    .addComponent(jLabel4)
                    .addComponent(lVersion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
    showMap = true;
    repaint = true;
    Thread T = new Thread() {

        public void run() {
            while (HMap2.this.showMap) {
                try {
                    HMap2.this.showMap();
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    T.start();

}//GEN-LAST:event_bOKActionPerformed

private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
}//GEN-LAST:event_formWindowStateChanged

    private void showMap() throws Exception {
        int size = Integer.valueOf((String) cbSize.getSelectedItem());
        int rows = Integer.valueOf((String) cbRows.getSelectedItem());
        int cols = Integer.valueOf((String) cbCols.getSelectedItem());
        
        if (size != lastSize || repaint) {
            if (dbImage != null) {
                dbImage.getGraphics().fillRect(0, 0, pMap.getWidth(), pMap.getHeight());
            }
            map = new HexMap(rows, cols, size);
            lastSize = size;
            msg.delete(0, msg.length());
            msg.append("HexSize: " + size + "\n");
            repaint = false;
        }
        if (dbImage == null) {
            dbImage = createImage(pMap.getWidth(), pMap.getHeight());
            if (dbImage == null) {
                throw new Exception("No Image");
            }
        }

        dbg = dbImage.getGraphics();

        while (map.hasNext()) {
            Hex h = map.next();
            Polygon P = new Polygon();
            msg.append("Hex: ");
            while (h.hasNext()) {
                Point p = h.next();
                P.addPoint(p.x, p.y);
                msg.append("[" + p.x + "," + p.y + "], ");
            }
            msg.append("\n");
            dbg.setColor(myColors[cycle % myColors.length]);
            dbg.fillPolygon(P);
            cycle++;
        }
        Graphics g = pMap.getGraphics();
        if (dbImage != null) {
            g.drawImage(dbImage, 0, 0, null);
        }
        tMessage.setText(msg.toString());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bOK;
    private javax.swing.JComboBox cbCols;
    private javax.swing.JComboBox cbRows;
    private javax.swing.JComboBox cbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lVersion;
    private javax.swing.JPanel pMap;
    private javax.swing.JScrollPane spMessage;
    private javax.swing.JTextArea tMessage;
    // End of variables declaration//GEN-END:variables
}
