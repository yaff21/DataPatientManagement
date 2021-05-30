import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.TableModel;

public class inputhal extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Statement stm;
    private tabel selectedModel = null;
    public inputhal() {
        initComponents();
        Connect();
        caridata();
        viewtable();
        

    }
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stm = (Statement) con.createStatement();
            JOptionPane.showMessageDialog(null, "Berhasil Terhubung");
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.err.println("Koneksi Gagal " +e.getMessage());
        }
}

    public void caridata(){
        try {
            pst = con.prepareStatement("select nik from datapasien");
            rs = pst.executeQuery();
            cari.removeAllItems();
            while(rs.next()){
                cari.addItem(rs.getString(1));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(inputhal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

     public void viewtable(){
        
        
        int CC;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            PreparedStatement insert = con.prepareStatement("SELECT * FROM datapasien");
            ResultSet Rs = insert.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) tableps.getModel();
            DFT.setRowCount(0);

            while (Rs.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("nik"));
                    v2.add(Rs.getString("nama_pasien"));
                    v2.add(Rs.getString("umur"));
                    v2.add(Rs.getString("alamat"));
                    v2.add(Rs.getString("status"));
                    v2.add(Rs.getString("tgl_masuk"));
                    v2.add(Rs.getString("tgl_keluar"));
                }
                DFT.addRow(v2);
            }
        } catch (Exception e) {
        }   
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nikps = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        namalkp = new javax.swing.JTextField();
        umurps = new javax.swing.JTextField();
        alamatps = new javax.swing.JTextField();
        statusps = new javax.swing.JTextField();
        tglmasuk = new javax.swing.JTextField();
        tglkeluar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableps = new javax.swing.JTable();
        carimn = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        cari = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnerase = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnclear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(52, 152, 219));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/protection_mask_50px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Input Data");

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/double_left_20px.png"))); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        btnback.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnbackKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnback)
                .addGap(351, 351, 351)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(475, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnback)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(19, 19, 19))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("NIK *");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Nama");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Umur");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Alamat");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Status **");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Tanggal Masuk");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Tanggal Keluar");

        nikps.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        nikps.setText("16 Digit");
        nikps.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nikpsFocusGained(evt);
            }
        });
        nikps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nikpsActionPerformed(evt);
            }
        });

        namalkp.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        namalkp.setText("Nama lengkap");
        namalkp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                namalkpFocusGained(evt);
            }
        });
        namalkp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namalkpActionPerformed(evt);
            }
        });

        umurps.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        umurps.setText("e.g. 21");
        umurps.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                umurpsFocusGained(evt);
            }
        });
        umurps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umurpsActionPerformed(evt);
            }
        });

        alamatps.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        alamatps.setText("Alamat sesuai KTP");
        alamatps.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                alamatpsFocusGained(evt);
            }
        });

        statusps.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        statusps.setText("ODP/OTG/PDP");
        statusps.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                statuspsFocusGained(evt);
            }
        });

        tglmasuk.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        tglmasuk.setText("YYYY-MM-dd");
        tglmasuk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tglmasukFocusGained(evt);
            }
        });
        tglmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglmasukActionPerformed(evt);
            }
        });

        tglkeluar.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        tglkeluar.setText("YYYY-MM-dd");
        tglkeluar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tglkeluarFocusGained(evt);
            }
        });
        tglkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglkeluarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*Wajib diisi");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Cek Data");

        tableps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIK", "Nama", "Umur", "Alamat", "Status", "Tgl_Masuk", "Tgl_Keluar"
            }
        ));
        tableps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableps);

        carimn.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        carimn.setText("Search");
        carimn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                carimnFocusGained(evt);
            }
        });
        carimn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carimnActionPerformed(evt);
            }
        });
        carimn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                carimnKeyReleased(evt);
            }
        });

        btnsearch.setBackground(new java.awt.Color(255, 255, 255));
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_20px.png"))); // NOI18N
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        cari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(75, 207, 250));

        jPanel5.setBackground(new java.awt.Color(228, 251, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Edit");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Erase");

        btnadd.setBackground(new java.awt.Color(255, 255, 255));
        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add_30px.png"))); // NOI18N
        btnadd.setBorder(null);
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnedit.setBackground(new java.awt.Color(255, 255, 255));
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/data_backup_30px.png"))); // NOI18N
        btnedit.setBorder(null);
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnerase.setBackground(new java.awt.Color(255, 255, 255));
        btnerase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/erase_30px.png"))); // NOI18N
        btnerase.setBorder(null);
        btnerase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneraseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnadd)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnedit))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnerase)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnadd)
                    .addComponent(btnedit)
                    .addComponent(btnerase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(228, 251, 255));

        btnclear.setBackground(new java.awt.Color(228, 251, 255));
        btnclear.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/data_backup_30px.png"))); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnclear)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 629, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator8)
                            .addComponent(jSeparator7)
                            .addComponent(jSeparator6)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nikps, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namalkp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(umurps, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alamatps, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusps, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tglkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator5))
                        .addGap(102, 102, 102)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnsearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carimn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel14))
                .addContainerGap(31, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(nikps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namalkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(umurps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(alamatps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(statusps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(tglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(tglkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cari)
                                    .addComponent(carimn, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnsearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))))
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nikpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nikpsActionPerformed
        // 
    }//GEN-LAST:event_nikpsActionPerformed

    private void namalkpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namalkpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namalkpActionPerformed

    private void umurpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umurpsActionPerformed
        // TODO add your
    }//GEN-LAST:event_umurpsActionPerformed

    private void tglkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglkeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglkeluarActionPerformed

    private void carimnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carimnActionPerformed
        
    }//GEN-LAST:event_carimnActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        try {
            // TODO add your handling code here:
            String caridata = cari.getSelectedItem().toString();
            pst = con.prepareStatement("select * from datapasien where nik= ?");
            pst.setString(1, caridata);
            rs = pst.executeQuery();

            if (rs.next()==true){
                nikps.setText(rs.getString(1));
                namalkp.setText(rs.getString(2));
                umurps.setText(rs.getString(3));
                alamatps.setText(rs.getString(4));
                statusps.setText(rs.getString(5));
                tglmasuk.setText(rs.getString(6));
                tglkeluar.setText(rs.getString(7));
                caridata();
                viewtable();
            }
        } catch (SQLException ex) {
            Logger.getLogger(inputhal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnsearchActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        nikps.setText("");
        namalkp.setText("");
        umurps.setText("");
        alamatps.setText("");
        tglmasuk.setText("");
        statusps.setText("");
        tglkeluar.setText("");
        nikps.requestFocus();
        caridata();
        viewtable();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {
            // TODO add your handling code here:
            String nik = nikps.getText();
            String nama_pasien = namalkp.getText();
            String umur = umurps.getText();
            String alamat = alamatps.getText();
            String status = statusps.getText();
            String tgl_masuk = tglmasuk.getText();
            String tgl_keluar = tglkeluar.getText();
            
            pst = con.prepareStatement("insert into datapasien(nik,nama_pasien,umur,alamat,status,tgl_masuk,tgl_keluar)values(?,?,?,?,?,?,?)");
            pst.setString(1, nik);
            pst.setString(2, nama_pasien);
            pst.setString(3, umur);
            pst.setString(4, alamat);
            pst.setString(5, status);
            pst.setString(6, tgl_masuk);
            pst.setString(7, tgl_keluar);
            int k = pst.executeUpdate();
            
            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "Data Tersimpan");
                nikps.setText("");
                namalkp.setText("");
                umurps.setText("");
                alamatps.setText("");
                statusps.setText("");
                tglmasuk.setText("");
                tglkeluar.setText("");
                nikps.requestFocus();
                caridata();
                viewtable();
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Data Gagal Tersimpan");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(inputhal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        try {
            // TODO add your handling code here:
            String nik = nikps.getText();
            String nama_pasien = namalkp.getText();
            String umur = umurps.getText();
            String alamat = alamatps.getText();
            String status = statusps.getText();
            String tgl_masuk = tglmasuk.getText();
            String tgl_keluar = tglkeluar.getText();
            String caridata = cari.getSelectedItem().toString();

            
            pst = con.prepareStatement("update datapasien set nik=?, nama_pasien=?, umur=?, alamat=?, status=?, tgl_masuk=?, tgl_keluar=? where nik=?");
            pst.setString(1, nik);
            pst.setString(2, nama_pasien);
            pst.setString(3, umur);
            pst.setString(4, alamat);
            pst.setString(5, status);
            pst.setString(6, tgl_masuk);
            pst.setString(7, tgl_keluar);
            pst.setString(8, caridata);
            int k = pst.executeUpdate();
            
            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "Update Berhasil");
                nikps.setText("");
                namalkp.setText("");
                umurps.setText("");
                alamatps.setText("");
                statusps.setText("");
                tglmasuk.setText("");
                tglkeluar.setText("");
                nikps.requestFocus();
                caridata();
                viewtable();
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Update Gagal");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(inputhal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btneraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneraseActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String caridata = cari.getSelectedItem().toString();

            
            pst = con.prepareStatement("delete from datapasien where nik=?");
            pst.setString(1, caridata);
            int k = pst.executeUpdate();
            
            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "Delete Berhasil");
                nikps.setText("");
                namalkp.setText("");
                umurps.setText("");
                alamatps.setText("");
                statusps.setText("");
                tglmasuk.setText("");
                tglkeluar.setText("");
                nikps.requestFocus();
                caridata();
                viewtable();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Delete Gagal");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(inputhal.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btneraseActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        this.dispose();
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    private void nikpsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nikpsFocusGained
        nikps.setText("");
    }//GEN-LAST:event_nikpsFocusGained

    private void namalkpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namalkpFocusGained
        namalkp.setText("");
    }//GEN-LAST:event_namalkpFocusGained

    private void umurpsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_umurpsFocusGained
        umurps.setText("");
    }//GEN-LAST:event_umurpsFocusGained

    private void alamatpsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alamatpsFocusGained
        alamatps.setText("");
    }//GEN-LAST:event_alamatpsFocusGained

    private void statuspsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_statuspsFocusGained
        statusps.setText("");
    }//GEN-LAST:event_statuspsFocusGained

    private void carimnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_carimnFocusGained
        carimn.setText("");
    }//GEN-LAST:event_carimnFocusGained

    private void btnbackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnbackKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
            Menu menu = new Menu();
            menu.setVisible(true);
        }
    }//GEN-LAST:event_btnbackKeyPressed

    private void tglmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglmasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglmasukActionPerformed

    private void tglmasukFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tglmasukFocusGained
        tglmasuk.setText("");
    }//GEN-LAST:event_tglmasukFocusGained

    private void tglkeluarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tglkeluarFocusGained
        tglkeluar.setText("");
    }//GEN-LAST:event_tglkeluarFocusGained

    private void carimnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carimnKeyReleased
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stm = (Statement) con.createStatement();
            String sql = "select * from datapasien where nama_pasien=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, carimn.getText());
            ResultSet rss = pst.executeQuery();
            if (rss.next()){
                String setnik = rss.getString("nik");
                nikps.setText (setnik);
                
                String setnama = rss.getString("nama_pasien");
                namalkp.setText (setnama);
                
                String setumur = rss.getString("umur");
                umurps.setText (setumur);
                
                String setalamat = rss.getString("alamat");
                alamatps.setText (setalamat);
                
                String setstatus = rss.getString("status");
                statusps.setText (setstatus);
                
                String settglmsk = rss.getString("tgl_masuk");
                tglmasuk.setText (settglmsk);
                
                String settglklr = rss.getString("tgl_keluar");
                tglkeluar.setText (settglklr);
            }
                
           
        }catch(Exception e) {
            System.err.println("Koneksi gagal" + e.getMessage());
        }
    }//GEN-LAST:event_carimnKeyReleased

    private void tablepsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepsMouseClicked
        DefaultTableModel model = (DefaultTableModel) tableps.getModel();
        int selectedIndex = tableps.getSelectedRow();
        
        nikps.setText(model.getValueAt(selectedIndex, 1). toString());
        namalkp.setText(model.getValueAt(selectedIndex, 2). toString());
        umurps.setText(model.getValueAt(selectedIndex, 3). toString());
        alamatps.setText(model.getValueAt(selectedIndex, 4). toString());
        statusps.setText(model.getValueAt(selectedIndex, 5). toString());
        tglmasuk.setText(model.getValueAt(selectedIndex, 6). toString());
        tglkeluar.setText(model.getValueAt(selectedIndex, 7). toString());
    }//GEN-LAST:event_tablepsMouseClicked
    

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
            java.util.logging.Logger.getLogger(inputhal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inputhal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inputhal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inputhal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inputhal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatps;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnerase;
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox<String> cari;
    private javax.swing.JTextField carimn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField namalkp;
    private javax.swing.JTextField nikps;
    private javax.swing.JTextField statusps;
    private javax.swing.JTable tableps;
    private javax.swing.JTextField tglkeluar;
    private javax.swing.JTextField tglmasuk;
    private javax.swing.JTextField umurps;
    // End of variables declaration//GEN-END:variables
}
