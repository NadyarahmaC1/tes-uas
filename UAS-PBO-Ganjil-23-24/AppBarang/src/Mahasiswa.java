
import java.awt.HeadlessException;
import java.sql.*; 
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Mahasiswa extends javax.swing.JFrame {

 
    public Statement st;    
    public ResultSet rs;   
    Connection Nadya = koneksi.KoneksiDatabase.BukaKoneksi();
    public Mahasiswa() {
        initComponents();
        TampilData();
    }
    
       
    
    private void Bersih(){
        txtmahasiswa.setText("");
        txtnama.setText("");
        txtalamat.setText("");
        txtprodi.setText("");
        txtusia.setText("");
        btnsimpan.setText("Simpan");
        txtmahasiswa.setEditable(true);
    }
    
   
    private void CariData(){
        try {
            st = Nadya.createStatement();
            rs = st.executeQuery("SELECT * FROM tbl_mahasiswa WHERE "
                    + cmbcari.getSelectedItem().toString()+
                    " LIKE '%" + txtcari.getText() + "%'");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("kode");
            model.addColumn("nama");
            model.addColumn("alamat");
            model.addColumn("prodi");
            model.addColumn("usia");
            
            int no =1;
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            while (rs.next()) {
                Object [] data ={
                  no ++,
                  rs.getString("kode"),
                  rs.getString("nama"),
                  rs.getString("alamat"),
                  rs.getString("prodi"),
                  rs.getString("usia")
                };
                model.addRow(data);
                tbldata.setModel(model);
            }
            
        } catch (Exception e) {
        }
    }
    

  
    private void TampilData(){
        try {
            st = Nadya.createStatement();
            rs = st.executeQuery("SELECT * FROM tbl_mahasiswa");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("kode");
            model.addColumn("nama");
            model.addColumn("alamat");
            model.addColumn("prodi");
            model.addColumn("usia");

            int no =1;
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            while (rs.next()) {
                Object [] data ={
                  no ++,
                  rs.getString("kode"),
                  rs.getString("nama"),
                  rs.getString("alamat"),
                  rs.getString("prodi"),
                  rs.getString("usia")
                  };
                  
                model.addRow(data);
                tbldata.setModel(model);
            }
            
        } catch (SQLException e) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmahasiswa = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txtprodi = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cmbcari = new javax.swing.JComboBox<>();
        txtcari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtusia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Data Mahasiswa");
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel1FocusLost(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("Nama Mahasiswa");

        jLabel3.setText("Kode Mahasiswa");

        jLabel4.setText("Alamat");

        jLabel5.setText("Prodi");

        txtmahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmahasiswaActionPerformed(evt);
            }
        });

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        txtalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalamatActionPerformed(evt);
            }
        });

        txtprodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprodiActionPerformed(evt);
            }
        });

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "kode", "nama", "alamat", "prodi", "usia"
            }
        ));
        tbldata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldata);

        jLabel6.setText("Cari data");

        cmbcari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kode", "nama" }));
        cmbcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcariActionPerformed(evt);
            }
        });

        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        jLabel7.setText("Usia");

        txtusia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusiaActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmahasiswa)
                            .addComponent(txtnama)
                            .addComponent(txtalamat)
                            .addComponent(txtprodi)
                            .addComponent(txtusia))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 146, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbcari, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsimpan))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhapus))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbatal))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtprodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtusia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        try {
            st = Nadya.createStatement();
            
            if (txtmahasiswa.getText().equals("")|| 
                    txtnama.getText().equals("")||
                    txtalamat.getText().equals("")||
                    txtprodi.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Data tidak boleh kosong","Informasi", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            if ("Simpan".equals(btnsimpan.getText())) {
                
                String cek ="SELECT * FROM tbl_mahasiswa WHERE kode = '" + txtmahasiswa.getText()+"'";
                rs = st.executeQuery(cek);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null,"Kode Mahasiswa Sudah dipakai");
                }else{
                    
                    String sql = "INSERT INTO tbl_mahasiswa VALUES('" + txtmahasiswa.getText()+
                            "','"+txtnama.getText() +
                            "','"+txtalamat.getText() +
                            "','"+txtprodi.getText() +
                            "','"+txtusia.getText() +"' )";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Data Mahasiswa Berhasil disimpan");
                    Bersih();
                    TampilData();
                }
            }else{
                
                String Update = "UPDATE tblMahasiswa SET nama ='" + txtnama.getText() +
                        "', alamat ='" +txtalamat.getText()+
                        "', prodi ='" +txtprodi.getText()+
                        "', usia ='" +txtusia.getText()+
                        "' WHERE kode ='" +txtmahasiswa.getText()+"'";
                st.executeUpdate(Update);
                    JOptionPane.showMessageDialog(null,"Data Mahasiswa Berhasil diubah");
                Bersih();
                TampilData();
            }
        } catch ( Exception e) {
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tbldataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldataMouseClicked
        // TODO add your handling code here:
        txtmahasiswa.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 1).toString());
        txtnama.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 2).toString());
        txtalamat.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 3).toString());
        txtprodi.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 4).toString());
        txtmahasiswa.setEditable(false);
        btnsimpan.setText("Ubah");
    }//GEN-LAST:event_tbldataMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        
        if (txtmahasiswa.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Pilih data yang ingin dihapus");
        }else{
             int jawab = JOptionPane.showConfirmDialog(null,"Data ini akan dihapus, lanjutkan","Konfirmasi", JOptionPane.YES_NO_OPTION);
             if (jawab ==0) {
                 try {
                     st = Nadya.createStatement();
                     String sql = "DELETE FROM tbl_mahasiswa WHERE kode = '"+ txtmahasiswa.getText()+"'";
                     st.executeUpdate(sql);
                     JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
                     TampilData();
                     Bersih();
                 } catch (HeadlessException | SQLException e) {
                     JOptionPane.showMessageDialog(null,e);
                     
                 }
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed

        Bersih();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        
        CariData();
    }//GEN-LAST:event_txtcariKeyPressed

    private void jLabel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1FocusLost

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtmahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmahasiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmahasiswaActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatActionPerformed

    private void txtprodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprodiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprodiActionPerformed

    private void txtusiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusiaActionPerformed

    private void cmbcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbcariActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed

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
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Mahasiswa().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cmbcari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtmahasiswa;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtprodi;
    private javax.swing.JTextField txtusia;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel DefaultTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
