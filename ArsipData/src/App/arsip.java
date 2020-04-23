/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Kagion
 */
public class arsip extends javax.swing.JFrame {

    private Statement st;
    private ResultSet Rs;
    private String Host;
    private Connection Con;
    String tanggal1;

    public arsip() {
        initComponents();
        refresh();
        tampil();
        this.setLocationRelativeTo(null);
    }

    private void refresh() {
        txtkode_dokumen.setEditable(true);
        txtkode_dokumen.setText(null);
        txtnama_dokumen.setText(null);
        cbKategori_dokumen.setSelectedItem(this);
        txtDir.setText(null);
        txtdeskripsi_dokumen.setText(null);
        tgl_dokumen.setCalendar(null);
    }

    private void tampil() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Kode Dokumen");
        model.addColumn("Nama Dokumen");
        model.addColumn("Kategori Dokumen");
        model.addColumn("Lokasi Dokumen");
        model.addColumn("Deskripsi Dokumen");
        model.addColumn("Tanggal");

        String cari = txtCari.getText();
        try {
            int no = 1;
            String sql = "SELECT * FROM dokumen WHERE nama_dokumen LIKE '%" + cari + "%' OR kategori_dokumen LIKE '%" + cari + "%' "
                    + "OR lokasi_dokumen LIKE '%" + cari + "%' OR deskripsi_dokumen LIKE '%" + cari + "%';";
            java.sql.Connection conn = (Connection) Koneksi.koneksiDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{no++, res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6)});
            }
            tblArsip_data.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private void update_tabel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Kode Dokumen");
        model.addColumn("Nama Dokumen");
        model.addColumn("Kategori Dokumen");
        model.addColumn("Lokasi Dokumen");
        model.addColumn("Deskripsi Dokumen");
        model.addColumn("Tanggal");
        try {
            int no = 1;
            String sql = "SELECT * FROM dokumen";
            java.sql.Connection conn = (Connection) Koneksi.koneksiDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{no++, res.getString(1), res.getString(2),
                    res.getString(3), res.getString(4), res.getString(5), res.getString(6)});
            }
            tblArsip_data.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtkode_dokumen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnama_dokumen = new javax.swing.JTextField();
        txtdeskripsi_dokumen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArsip_data = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btncari = new javax.swing.JLabel();
        cbKategori_dokumen = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnrefresh = new javax.swing.JLabel();
        tgl_dokumen = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        txtDir = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Arsip Dokumen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(306, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel4.setText("Kode Dokumen");

        txtkode_dokumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkode_dokumenActionPerformed(evt);
            }
        });
        txtkode_dokumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkode_dokumenKeyPressed(evt);
            }
        });

        jLabel5.setText("Nama Dokumen");

        jLabel6.setText("Kategori Dokumen");

        jLabel7.setText("Deskripsi Dokumen");

        txtdeskripsi_dokumen.setBackground(new java.awt.Color(228, 241, 254));
        txtdeskripsi_dokumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdeskripsi_dokumenActionPerformed(evt);
            }
        });

        tblArsip_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArsip_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArsip_data);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setText("ubah");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtCari.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.black, java.awt.Color.lightGray));

        btncari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btncari.setText("cari");
        btncari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncariMouseClicked(evt);
            }
        });

        cbKategori_dokumen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Surat Masuk ", "Surat  Keluar", "Surat Ijin" }));

        jLabel10.setText("Lokasi Dokumen");

        jLabel11.setText("Tanggal");

        btnrefresh.setText("muat ulang");
        btnrefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrefreshMouseClicked(evt);
            }
        });

        jButton1.setText("Browse  File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbKategori_dokumen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtkode_dokumen)
                                    .addComponent(txtnama_dokumen)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnSimpan)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEdit)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHapus))
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tgl_dokumen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtdeskripsi_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnrefresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtkode_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel10)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel7)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel11))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtnama_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbKategori_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                    .addComponent(txtDir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdeskripsi_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(tgl_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEdit)
                                    .addComponent(btnHapus)
                                    .addComponent(btnSimpan)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(btncari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnrefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Adobe Devanagari", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("x");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("-");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdeskripsi_dokumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdeskripsi_dokumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeskripsi_dokumenActionPerformed

    private void btnrefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrefreshMouseClicked
        refresh();
        update_tabel();

    }//GEN-LAST:event_btnrefreshMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tgl_dokumen.getDate()));

        String kode_dokumen, nama_dokumen, lokasi_dokumen, deskripsi_dokumen;
        kode_dokumen = txtkode_dokumen.getText();
        nama_dokumen = txtnama_dokumen.getText();
        lokasi_dokumen = txtDir.getText();
        deskripsi_dokumen = txtdeskripsi_dokumen.getText();
        if (kode_dokumen.equals("") | (nama_dokumen.equals("")) | (lokasi_dokumen.equals("")) | (deskripsi_dokumen.equals(""))) {
            JOptionPane.showMessageDialog(null, "isi data terlebih dahulu");
            txtkode_dokumen.requestFocus();
        } else {
            try {
                String sql = "INSERT INTO dokumen (kode_dokumen,nama_dokumen,kategori_dokumen,lokasi_dokumen,"
                        + "deskripsi_dokumen,tanggal) VALUES ('" + txtkode_dokumen.getText() + "','" +
                        txtnama_dokumen.getText() + "','" + cbKategori_dokumen.getSelectedItem() + "','" +
                        txtDir.getText() + "','" + txtdeskripsi_dokumen.getText() + "','" + tanggal + "')";
                java.sql.Connection conn = (Connection) Koneksi.koneksiDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Simpan Data Berhasil.....");
                refresh();
                tampil();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tblArsip_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArsip_dataMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblArsip_data.getModel();
        int baris = tblArsip_data.rowAtPoint(evt.getPoint());
        String kode_dokumen = tblArsip_data.getValueAt(baris, 1).toString();
        txtkode_dokumen.setText(kode_dokumen);

        String nama_dokumen = tblArsip_data.getValueAt(baris, 2).toString();
        txtnama_dokumen.setText(nama_dokumen);

        String kategori_dokumen = tblArsip_data.getValueAt(baris, 3).toString();
        cbKategori_dokumen.setSelectedItem(kategori_dokumen);

        String lokasi_dokumen = tblArsip_data.getValueAt(baris, 4).toString();
        txtDir.setText(lokasi_dokumen);

        String deskripsi_dokumen = tblArsip_data.getValueAt(baris, 5).toString();
        txtdeskripsi_dokumen.setText(deskripsi_dokumen);

        String date = (String) tblArsip_data.getModel().getValueAt(baris, 6);
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-M-dd");
            java.util.Date d = f.parse(date);
            tgl_dokumen.setDate(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblArsip_dataMouseClicked

    private void txtkode_dokumenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkode_dokumenKeyPressed
        // TODO add your handling code here:
        String kode_dokumen = txtkode_dokumen.getText();
        int a = evt.getKeyCode();
        if (a == 10) {
            try {
                String Sql = "SELECT * FROM dokumen WHERE kode_dokumen =" + kode_dokumen + "";
                st = Con.createStatement();
                Rs = st.executeQuery(Sql);
                while (Rs.next()) {
                    txtnama_dokumen.setText(Rs.getString(2));
                    cbKategori_dokumen.setSelectedItem(Rs.getString(3));
                    txtDir.setText(Rs.getString(4));
                    txtdeskripsi_dokumen.setText(Rs.getString(5));
                    tgl_dokumen.setDate(Rs.getDate(6));
                }
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "Data Not Found" + e.getMessage());
                txtkode_dokumen.requestFocus();
            }
        }
    }//GEN-LAST:event_txtkode_dokumenKeyPressed

    private void tglPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglPropertyChange
        // TODO add your handling code here:
        if (tgl_dokumen.getDate() != null) {
            SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
            tanggal1 = Format.format(tgl_dokumen.getDate());
        }
    }//GEN-LAST:event_tglPropertyChange

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tgl_dokumen.getDate()));
        try {
            String sql = "UPDATE dokumen SET kode_dokumen ='" + txtkode_dokumen.getText()
                    + "',nama_dokumen='" + txtnama_dokumen.getText()
                    + "',kategori_dokumen='" + cbKategori_dokumen.getSelectedItem()
                    + "',lokasi_dokumen='" + txtDir.getText()
                    + "',deskripsi_dokumen='" + txtdeskripsi_dokumen.getText()
                    + "',tanggal='" + tanggal
                    + "' WHERE kode_dokumen ='" + txtkode_dokumen.getText() + "' ";
            java.sql.Connection conn = (Connection) Koneksi.koneksiDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            st = conn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil...");
            tampil();
            refresh();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            String sql = "DELETE FROM dokumen WHERE kode_dokumen='" + txtkode_dokumen.getText() + "'";
            java.sql.Connection conn = (Connection) Koneksi.koneksiDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil...");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampil();
        refresh();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btncariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariMouseClicked
        tampil();
    }//GEN-LAST:event_btncariMouseClicked

    private void txtkode_dokumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkode_dokumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkode_dokumenActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);

        File file = jfc.getSelectedFile();
        String dir = file.getPath();
        
        txtDir.setText(dir);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException |
                InstantiationException | UnsupportedLookAndFeelException e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new arsip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel btncari;
    private javax.swing.JLabel btnrefresh;
    private javax.swing.JComboBox<String> cbKategori_dokumen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblArsip_data;
    private com.toedter.calendar.JDateChooser tgl_dokumen;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtdeskripsi_dokumen;
    private javax.swing.JTextField txtkode_dokumen;
    private javax.swing.JTextField txtnama_dokumen;
    // End of variables declaration//GEN-END:variables
}
