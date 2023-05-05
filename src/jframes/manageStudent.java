/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframes;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

/**
 *
 * @author mohit
 */
public class manageStudent extends javax.swing.JFrame {

    /**
     * Creates new form BookManage
     */
    public manageStudent() {
        initComponents();
        setSDetails();
        setCourse();
    }
    
    String Stdname,StdCourse,StdBranch;int Stdid;
    DefaultTableModel model;
   //set course options from database 
    public void setCourse(){
        try{
            Connection con= DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select CName from Course");
        
        while(rs.next()){
            String cranch =rs.getString("CName");
           Branch.addItem(cranch);
        }
        
        }catch  (Exception e){}
    }
//Getting Student Details to table
    public void setSDetails(){
        try{
            Connection con =DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select * from Student_Details");
            
            while(rs.next()){
            String Stdid=rs.getString("studentId");
            String Stdname=rs.getString("name");
            String StdCourse=rs.getString("course");
            String StdBranch=rs.getString("branch");
            
            Object[] obj={Stdid,Stdname,StdCourse,StdBranch};
            model =(DefaultTableModel) StudentDetails.getModel();
            model.addRow(obj);
        }

            
        }catch (Exception e){
            
        }
    }
    
    //Adding Student details to database
    public boolean addStudent(){
        boolean isAdded = false;
          Stdid=Integer.parseInt(StudenID.getText());
             Stdname=StudentName.getText();
             StdBranch=Branch.getSelectedItem().toString();
             StdCourse=Course.getSelectedItem().toString();
             try{
                   Connection con=DBConnection.getConnection();
                   String sql="insert into Student_Details(studentID,name,course,branch) values(?,?,?,?)";
                   PreparedStatement pst=con.prepareStatement(sql);
                   pst.setInt(1,Stdid);
                   pst.setString(2,Stdname);
                   pst.setString(3, StdCourse);
                   pst.setString(4,StdBranch);
                   
                   int rowcount=pst.executeUpdate();
                   if(rowcount>0){
                       isAdded=true;
                   }else
                   {
                       isAdded=false;
                   }
    }catch (Exception e){
        e.printStackTrace();
        
    }
    return isAdded;
    }
    //Clear Table
    public void clearTable(){
        DefaultTableModel model1=(DefaultTableModel) StudentDetails.getModel();
        model1.setRowCount(0);
    }
    
    //To Update STUDENT DETAILS
    public boolean updateStudent(){
        boolean isUpdated = false;
         Stdid=Integer.parseInt(StudenID.getText());
             Stdname=StudentName.getText();
             StdBranch=Branch.getSelectedItem().toString();
             StdCourse=Course.getSelectedItem().toString();
             try{
                   Connection con=DBConnection.getConnection();
                   String sql="update Student_Details set  name=?, course=?, branch=? where studentID=? ";
                   PreparedStatement pst=con.prepareStatement(sql);
                   pst.setInt(4,Stdid);
                   pst.setString(1,Stdname);
                   pst.setString(2, StdCourse);
                   pst.setString(3,StdBranch);
                   
                   int rowcount=pst.executeUpdate();
                   if(rowcount>0){
                       isUpdated=true;
                   }else
                   {
                       isUpdated=false;
                   }
             }catch (Exception e){
                 
             }
             return isUpdated;
        
    }
    //Deleting the book from data
    public boolean deleteStudent(){
        boolean isDeleted=false;
        Stdid=Integer.parseInt(StudenID.getText());
        try{
            Connection con=DBConnection.getConnection();
            String sql="delete from Book_Details where BookID=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, Stdid);
            int rowcount =pst.executeUpdate();
                   if(rowcount>0){
                       isDeleted=true;
                   }else
                   {
                       isDeleted=false;
                   }            
        }catch (Exception e){}
        return isDeleted;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        StudenID = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        StudentName = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new necesario.RSMaterialButtonCircle();
        Branch = new javax.swing.JComboBox<>();
        Course = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        StudentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 60, 70));

        StudenID.setBackground(new java.awt.Color(255, 102, 102));
        StudenID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        StudenID.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        StudenID.setPlaceholder("Enter Student ID");
        StudenID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                StudenIDFocusLost(evt);
            }
        });
        StudenID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudenIDActionPerformed(evt);
            }
        });
        jPanel1.add(StudenID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 380, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel8.setText("Enter Student ID");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 60, 70));

        StudentName.setBackground(new java.awt.Color(255, 102, 102));
        StudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        StudentName.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        StudentName.setPlaceholder("Enter Student Name");
        StudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentNameActionPerformed(evt);
            }
        });
        jPanel1.add(StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 380, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel14.setText("Enter Student Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 60, 70));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel9.setText("Select Course");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 60, 70));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel16.setText("Select Branch");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, -1, 30));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("DELETE");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 130, 80));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("ADD");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 130, 80));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle4.setText("UPDATE");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, 130, 80));

        Branch.setFont(new java.awt.Font("Liberation Mono", 0, 17)); // NOI18N
        jPanel1.add(Branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 370, 30));

        Course.setFont(new java.awt.Font("Liberation Mono", 0, 17)); // NOI18N
        Course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.Tech", "M.Tech", " " }));
        jPanel1.add(Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 370, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setFont(new java.awt.Font("Liberation Mono", 0, 25)); // NOI18N

        StudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        StudentDetails.setRowHeight(44);
        StudentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(StudentDetails);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 880, 270));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel1.setText("Manage Books");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 440, 120));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1140, 820));

        setSize(new java.awt.Dimension(1724, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
      HomePage home=new HomePage();
        home.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void StudenIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StudenIDFocusLost
       
    }//GEN-LAST:event_StudenIDFocusLost

    private void StudenIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudenIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudenIDActionPerformed

    private void StudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentNameActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(deleteStudent()==true){
            JOptionPane.showMessageDialog(this, "Deleted Successfully");
            clearTable();
            setSDetails();
        }else
            JOptionPane.showMessageDialog(this, "Unsuccessful Update");
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if(addStudent()==true){
            JOptionPane.showMessageDialog(this, "Added Successfully");
            clearTable();
            setSDetails();
        }else
            JOptionPane.showMessageDialog(this, "Unsuccessful Update");
                
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
         if(updateStudent()==true){
            JOptionPane.showMessageDialog(this, "Updated Successfully");
            clearTable();
            setSDetails();
        }else
            JOptionPane.showMessageDialog(this, "Unsuccessful Update");       // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void StudentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentDetailsMouseClicked
    int rowno=StudentDetails.getSelectedRow();
    TableModel model=StudentDetails.getModel();
    StudenID.setText(model.getValueAt(rowno,0).toString());
    StudentName.setText(model.getValueAt(rowno,1).toString());
    Course.setSelectedItem(model.getValueAt(rowno,2).toString());
    Branch.setSelectedItem(model.getValueAt(rowno,3).toString());

            
    }//GEN-LAST:event_StudentDetailsMouseClicked


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
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Branch;
    private javax.swing.JComboBox<String> Course;
    private app.bolivia.swing.JCTextField StudenID;
    private rojeru_san.complementos.RSTableMetro StudentDetails;
    private app.bolivia.swing.JCTextField StudentName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle4;
    // End of variables declaration//GEN-END:variables
}
