
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mmvergara
 */
public class BLMSForm extends javax.swing.JFrame {

    public BLMSForm() {
        initComponents();
        ConnectDB();
        ShowTableData();
    }
    
    Connection con;
    PreparedStatement pst;  
    
    DefaultTableModel df;
    ResultSet rs;
    
    public void ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/blmsdb", "root", "");
            System.err.println("Done Connecting");
        } catch (SQLException ex) {
            Logger.getLogger(BLMSForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BLMSForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void ShowTableData(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM blmstable");
            rs = pst.executeQuery();
            ResultSetMetaData rsmeta = rs.getMetaData();
            q = rsmeta.getColumnCount();
            df =(DefaultTableModel)MainTable.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int i = 1 ; i <= q ; i++){
                    v2.add(rs.getString("book_number"));
                    v2.add(rs.getString("book_title"));
                    v2.add(rs.getString("book_author"));
                    v2.add(rs.getString("book_genre"));
                    v2.add(rs.getString("borrowed_by"));
                    v2.add(rs.getString("status"));
                }
                df.addRow(v2);
            } 
                } catch (SQLException ex) {
            Logger.getLogger(BLMSForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        AddBookButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainTable = new javax.swing.JTable();
        BookTitleField = new javax.swing.JTextField();
        BookAuthorField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BookGenreComboBox = new javax.swing.JComboBox<>();
        MarkAsAvailableButton = new javax.swing.JButton();
        BorrowerNameField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Library Management System");

        jLabel1.setText("Book Title");

        AddBookButton.setBackground(new java.awt.Color(0, 153, 0));
        AddBookButton.setForeground(new java.awt.Color(255, 255, 255));
        AddBookButton.setText("Add Book");
        AddBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookButtonActionPerformed(evt);
            }
        });

        MainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Book Number", "Title", "Author", "Genre", "BorrowedBy", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(MainTable);

        jLabel2.setText("Book Author");

        jLabel3.setText("Genre");

        BookGenreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "History", "Fiction", "Mystery", "Sci-Fi", "Thriller" }));
        BookGenreComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookGenreComboBoxActionPerformed(evt);
            }
        });

        MarkAsAvailableButton.setText("Mark as Available");
        MarkAsAvailableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarkAsAvailableButtonActionPerformed(evt);
            }
        });

        BorrowerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrowerNameFieldActionPerformed(evt);
            }
        });

        jButton3.setText("Mark as Borrowed");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Borrower name");

        DeleteButton.setBackground(new java.awt.Color(204, 51, 0));
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BookGenreComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(AddBookButton, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(MarkAsAvailableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BookAuthorField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(BookTitleField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BorrowerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BookAuthorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BorrowerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BookGenreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MarkAsAvailableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBookButtonActionPerformed
          try {          
            String title = BookTitleField.getText();
            String author = BookAuthorField.getText();
            String genre = BookGenreComboBox.getSelectedItem().toString();
            
            if(title.isEmpty() || author.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Please fill out all fields");
                return;
            }
       
            pst = con.prepareStatement("INSERT INTO blmstable (book_title, book_author, book_genre, borrowed_by, status) VALUES (?,?,?,?,?)");
            
            pst.setString(1, title);
            pst.setString(2, author);
            pst.setString(3, genre);
            pst.setString(4,"");
            pst.setString(5,"Available");
            
            
      
            pst.executeUpdate();

            BookTitleField.setText("");
            BookAuthorField.setText("");
            BookGenreComboBox.setSelectedIndex(0); 
        } catch (SQLException ex) {
            Logger.getLogger(BLMSForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        ShowTableData();
    }//GEN-LAST:event_AddBookButtonActionPerformed

    private void BookGenreComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookGenreComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookGenreComboBoxActionPerformed

    private void MarkAsAvailableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarkAsAvailableButtonActionPerformed
       int index = MainTable.getSelectedRow();
        if(index == -1){
           JOptionPane.showMessageDialog(rootPane, "Please select a book");
           return;
       }
         try {
                String bookNumber = df.getValueAt(index,0).toString();
                pst = con.prepareStatement("UPDATE blmstable SET status = ?, borrowed_by = ? WHERE book_number = ?");
                pst.setString(1, "Available");                
                pst.setString(2,  "");
                pst.setString(3, bookNumber);
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(BLMSForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        ShowTableData(); 
    }//GEN-LAST:event_MarkAsAvailableButtonActionPerformed

    private void BorrowerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BorrowerNameFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int index = MainTable.getSelectedRow();
       String borrower = BorrowerNameField.getText();
       
        if(index == -1){
           JOptionPane.showMessageDialog(rootPane, "Please select a book");
           return;
       }
        
       if (borrower.isEmpty()){
           JOptionPane.showMessageDialog(rootPane, "Please enter borrower's name");
           return;
       }
         try {
                String bookNumber = df.getValueAt(index,0).toString();
                pst = con.prepareStatement("UPDATE blmstable SET status = ?, borrowed_by = ? WHERE book_number = ?");
                pst.setString(1, "Borrowed");                
                pst.setString(2,  borrower);
                pst.setString(3, bookNumber);
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(BLMSForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        ShowTableData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       int index = MainTable.getSelectedRow();
       if(index == -1){
           JOptionPane.showMessageDialog(rootPane, "Please select a book");
           return;
       }
            try {
                String bookNumber = df.getValueAt(index,0).toString();
                pst = con.prepareStatement("DELETE FROM blmstable WHERE book_number = ?");
                pst.setString(1, bookNumber);
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(BLMSForm.class.getName()).log(Level.SEVERE, null, ex);
            }
       ShowTableData();
    }//GEN-LAST:event_DeleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BLMSForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BLMSForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BLMSForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BLMSForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BLMSForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBookButton;
    private javax.swing.JTextField BookAuthorField;
    private javax.swing.JComboBox<String> BookGenreComboBox;
    private javax.swing.JTextField BookTitleField;
    private javax.swing.JTextField BorrowerNameField;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTable MainTable;
    private javax.swing.JButton MarkAsAvailableButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
