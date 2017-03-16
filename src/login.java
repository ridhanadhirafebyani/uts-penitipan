
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ridha Nadhira Febyan
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        thisispanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        signin = new javax.swing.JButton();
        uname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        signup1 = new javax.swing.JButton();
        pw = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        thisispanel.setBackground(new java.awt.Color(153, 204, 255));
        thisispanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 15))); // NOI18N
        thisispanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Username");
        thisispanel.add(jLabel1);
        jLabel1.setBounds(150, 43, 110, 30);

        signin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signin.setText("Sign In");
        signin.setMargin(new java.awt.Insets(-5, -5, -5, -5));
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });
        thisispanel.add(signin);
        signin.setBounds(200, 230, 160, 40);

        uname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        thisispanel.add(uname);
        uname.setBounds(110, 84, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Password");
        thisispanel.add(jLabel2);
        jLabel2.setBounds(150, 120, 110, 30);

        signup1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signup1.setText("Sign Up");
        signup1.setMargin(new java.awt.Insets(-5, -5, -5, -5));
        signup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup1ActionPerformed(evt);
            }
        });
        thisispanel.add(signup1);
        signup1.setBounds(20, 230, 160, 40);

        pw.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        thisispanel.add(pw);
        pw.setBounds(110, 156, 150, 37);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thisispanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thisispanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 416, 349);
    }// </editor-fold>//GEN-END:initComponents

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
        Connection connection;
        PreparedStatement ps;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/db_penitipan?zeroDateTimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT `username`, `password` FROM `tb_admin` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, uname.getText());
            ps.setString(2, pw.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                new main_frame_uts().show();
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                pw.setText("");
                uname.requestFocus();
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Gagal");
        }
    }//GEN-LAST:event_signinActionPerformed

    private void signup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup1ActionPerformed
        String username = uname.getText();
        String password = pw.getText();

        try{
            try(Statement statement = (Statement) file_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("insert into tb_admin(username, password) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null, "Selamat! Anda berhasil sign up!");
        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Mohon maaf, ulangi lagi prosedur");
        }
    }//GEN-LAST:event_signup1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField pw;
    private javax.swing.JButton signin;
    private javax.swing.JButton signup1;
    private javax.swing.JPanel thisispanel;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
