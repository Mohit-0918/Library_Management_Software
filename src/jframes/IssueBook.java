/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframes;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mohit
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    //Get Book Details
    
   public void GetBookDetails() {
       int id=Integer.parseInt(ISSUETbid.getText());
       try{
           Connection con=DBConnection.getConnection(); 
           PreparedStatement pst=con.prepareStatement("select *from Book_Details where Bookid=?");
           pst.setInt(1, id);
           ResultSet rs=pst.executeQuery();
           if(rs.next()){
               ISBid1.setText(rs.getString("BookId"));
               ISBname1.setText(rs.getString("BookName"));
               ISBauthorname1.setText(rs.getString("Author"));
               ISBquantity1.setText(rs.getString("Quantity"));
           }else{
                  Berror.setText("! INVALID Book ID");
            }
       }catch (Exception e){}
   }
//Get Student Details
   public void GetStudentDetails(){
       int id=Integer.parseInt(ISSUETsid.getText());
       try{
           Connection con =DBConnection.getConnection();
           PreparedStatement pst=con.prepareStatement("Select * from Student_Details  where studentId=?");
           pst.setInt(1, id);
           ResultSet rs=pst.executeQuery();
           if(rs.next()){
           ISSBstudentid.setText(rs.getString("studentId"));
           ISSBstudentname.setText(rs.getString("name"));
           ISSBcourse.setText(rs.getString("course"));
           ISSBbranch.setText(rs.getString("branch"));
       }else{
               Serror.setText("! INVALID Student ID");
           }
       }    catch (Exception e){}
   }
   
   //Inserte Issue dook details to database
   public boolean Issue_book(){
       boolean isIssues=false;
       int bid=Integer.parseInt(ISSUETbid.getText());
       int sid=Integer.parseInt(ISSUETsid.getText());
       String Bname=ISBname1.getText();
       String Sname=ISSBstudentname.getText();
       Date uIssueDate=rSDateChooser1.getDatoFecha();
       Date uDueDate =rSDateChooser2.getDatoFecha();
      long l1=uIssueDate.getTime();
       long l2 =uDueDate.getTime();
       java.sql.Date sIssueDate=new java.sql.Date(l1);
       java.sql.Date sDueDate=new java.sql.Date(l2);
       try{
           Connection con = DBConnection.getConnection();
           String sql="insert into Issue_Book_Details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1,bid);
           pst.setString(2,Bname);
           pst.setInt(3,sid);
           pst.setString(4,Sname);
           pst.setDate(5, sIssueDate);
           pst.setDate(6, sDueDate);
           pst.setString(7,"Pending");
           
           int rowcount=pst.executeUpdate();
           if (rowcount>0){
               isIssues= true;
           }else{
               isIssues=false;
           }
       }catch (Exception e){}
   return isIssues;
   }
   //Updating book detail
   public void updateBookDetails(){
       int bookId=Integer.parseInt(ISSUETbid.getText());
       try{
           Connection con =DBConnection.getConnection();
           String sql="update Book_Details set Quantity=Quantity-1 where BookId=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1,bookId);
           int rowcount=pst.executeUpdate();
           if (rowcount>0){
               JOptionPane.showMessageDialog(this, "Book Count Updated");
               int initialCount=Integer.parseInt(ISBquantity1.getText());
               ISBquantity1.setText(Integer.toString(initialCount-1));
           }else{
               JOptionPane.showMessageDialog(this, "Error");
           }
       }catch (Exception e){}
   }
   //Checking book already issued or not
   public boolean isAlreadyIssued(){
       boolean isIssued=false;
        int bid=Integer.parseInt(ISSUETbid.getText());
       int sid=Integer.parseInt(ISSUETsid.getText());
       try{
           Connection con=DBConnection.getConnection();
           String sql="Select * from Issue_Book_Details where book_id=? and student_id=? and status=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1,bid);
           pst.setInt(2, sid);
           pst.setString(3,"pending");
           ResultSet rs=pst.executeQuery();
           if(rs.next()){
               isIssued=true;
           }else{
               isIssued=false;
           }
       }catch (Exception e){}
       return isIssued;
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main_Panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ISBbranch = new javax.swing.JLabel();
        ISSBbranch = new app.bolivia.swing.JCTextField();
        ISSBcourse = new app.bolivia.swing.JCTextField();
        ISBcourse = new javax.swing.JLabel();
        ISSBstudentname = new app.bolivia.swing.JCTextField();
        ISBstudentname = new javax.swing.JLabel();
        ISSBstudentid = new app.bolivia.swing.JCTextField();
        ISBstudentid = new javax.swing.JLabel();
        Serror = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        IAquantity1 = new javax.swing.JLabel();
        ISBquantity1 = new app.bolivia.swing.JCTextField();
        ISBauthorname1 = new app.bolivia.swing.JCTextField();
        IAname1 = new javax.swing.JLabel();
        ISBname1 = new app.bolivia.swing.JCTextField();
        IBname1 = new javax.swing.JLabel();
        ISBid1 = new app.bolivia.swing.JCTextField();
        IBid1 = new javax.swing.JLabel();
        Berror = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        ISSUEdate = new javax.swing.JLabel();
        ISSUETsid = new app.bolivia.swing.JCTextField();
        ISSUETbid = new app.bolivia.swing.JCTextField();
        ISSUEbid = new javax.swing.JLabel();
        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();
        ISSUEsid1 = new javax.swing.JLabel();
        rSDateChooser2 = new rojeru_san.componentes.RSDateChooser();
        ISSUEdate1 = new javax.swing.JLabel();
        ISSUEadd = new necesario.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Main_Panel.setBackground(new java.awt.Color(255, 255, 255));
        Main_Panel.setForeground(new java.awt.Color(255, 255, 255));
        Main_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Mono", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Student Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 380, 5));

        ISBbranch.setBackground(new java.awt.Color(255, 255, 255));
        ISBbranch.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        ISBbranch.setForeground(new java.awt.Color(0, 0, 0));
        ISBbranch.setText("Branch");
        jPanel1.add(ISBbranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, 30));

        ISSBbranch.setBackground(new java.awt.Color(255, 102, 102));
        ISSBbranch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        ISSBbranch.setForeground(new java.awt.Color(0, 0, 0));
        ISSBbranch.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        ISSBbranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISSBbranchActionPerformed(evt);
            }
        });
        jPanel1.add(ISSBbranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 380, -1));

        ISSBcourse.setBackground(new java.awt.Color(255, 102, 102));
        ISSBcourse.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        ISSBcourse.setForeground(new java.awt.Color(0, 0, 0));
        ISSBcourse.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        ISSBcourse.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ISSBcourseFocusLost(evt);
            }
        });
        ISSBcourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISSBcourseActionPerformed(evt);
            }
        });
        jPanel1.add(ISSBcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 380, -1));

        ISBcourse.setBackground(new java.awt.Color(255, 255, 255));
        ISBcourse.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        ISBcourse.setForeground(new java.awt.Color(0, 0, 0));
        ISBcourse.setText("Course");
        jPanel1.add(ISBcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, 30));

        ISSBstudentname.setBackground(new java.awt.Color(255, 102, 102));
        ISSBstudentname.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        ISSBstudentname.setForeground(new java.awt.Color(0, 0, 0));
        ISSBstudentname.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        ISSBstudentname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISSBstudentnameActionPerformed(evt);
            }
        });
        jPanel1.add(ISSBstudentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 380, -1));

        ISBstudentname.setBackground(new java.awt.Color(255, 255, 255));
        ISBstudentname.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        ISBstudentname.setForeground(new java.awt.Color(0, 0, 0));
        ISBstudentname.setText("Enter Student Name");
        jPanel1.add(ISBstudentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 30));

        ISSBstudentid.setBackground(new java.awt.Color(255, 102, 102));
        ISSBstudentid.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        ISSBstudentid.setForeground(new java.awt.Color(0, 0, 0));
        ISSBstudentid.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        ISSBstudentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ISSBstudentidFocusLost(evt);
            }
        });
        ISSBstudentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISSBstudentidActionPerformed(evt);
            }
        });
        jPanel1.add(ISSBstudentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 380, -1));

        ISBstudentid.setBackground(new java.awt.Color(255, 255, 255));
        ISBstudentid.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        ISBstudentid.setForeground(new java.awt.Color(0, 0, 0));
        ISBstudentid.setText("Enter Student ID");
        jPanel1.add(ISBstudentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 30));

        Serror.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        Serror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(Serror, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 260, 40));

        Main_Panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 420, 810));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        jLabel3.setFont(new java.awt.Font("Liberation Mono", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Book Details");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 300, 5));

        IAquantity1.setBackground(new java.awt.Color(255, 255, 255));
        IAquantity1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        IAquantity1.setForeground(new java.awt.Color(0, 0, 0));
        IAquantity1.setText("Quantity");
        jPanel3.add(IAquantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, 30));

        ISBquantity1.setBackground(new java.awt.Color(255, 102, 102));
        ISBquantity1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        ISBquantity1.setForeground(new java.awt.Color(0, 0, 0));
        ISBquantity1.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        ISBquantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBquantity1ActionPerformed(evt);
            }
        });
        jPanel3.add(ISBquantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 380, -1));

        ISBauthorname1.setBackground(new java.awt.Color(255, 102, 102));
        ISBauthorname1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        ISBauthorname1.setForeground(new java.awt.Color(0, 0, 0));
        ISBauthorname1.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        ISBauthorname1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ISBauthorname1FocusLost(evt);
            }
        });
        ISBauthorname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBauthorname1ActionPerformed(evt);
            }
        });
        jPanel3.add(ISBauthorname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 380, -1));

        IAname1.setBackground(new java.awt.Color(255, 255, 255));
        IAname1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        IAname1.setForeground(new java.awt.Color(0, 0, 0));
        IAname1.setText("Enter Author Name");
        jPanel3.add(IAname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, 30));

        ISBname1.setBackground(new java.awt.Color(255, 102, 102));
        ISBname1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        ISBname1.setForeground(new java.awt.Color(0, 0, 0));
        ISBname1.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        ISBname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBname1ActionPerformed(evt);
            }
        });
        jPanel3.add(ISBname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 380, -1));

        IBname1.setBackground(new java.awt.Color(255, 255, 255));
        IBname1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        IBname1.setForeground(new java.awt.Color(0, 0, 0));
        IBname1.setText("Enter Book Name");
        jPanel3.add(IBname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 30));

        ISBid1.setBackground(new java.awt.Color(255, 102, 102));
        ISBid1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        ISBid1.setForeground(new java.awt.Color(0, 0, 0));
        ISBid1.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        ISBid1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ISBid1FocusLost(evt);
            }
        });
        ISBid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBid1ActionPerformed(evt);
            }
        });
        jPanel3.add(ISBid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 380, -1));

        IBid1.setBackground(new java.awt.Color(255, 255, 255));
        IBid1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        IBid1.setForeground(new java.awt.Color(0, 0, 0));
        IBid1.setText("Enter Book ID");
        jPanel3.add(IBid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 30));

        Berror.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        Berror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(Berror, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 260, 40));

        Main_Panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 810));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel5.setText("Issue Book");
        Main_Panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 80, 250, 80));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        Main_Panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 150, 380, 5));

        ISSUEdate.setBackground(new java.awt.Color(255, 255, 255));
        ISSUEdate.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        ISSUEdate.setForeground(new java.awt.Color(0, 0, 0));
        ISSUEdate.setText("Issue Date");
        Main_Panel.add(ISSUEdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 430, -1, 30));

        ISSUETsid.setBackground(new java.awt.Color(255, 102, 102));
        ISSUETsid.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        ISSUETsid.setForeground(new java.awt.Color(255, 255, 255));
        ISSUETsid.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        ISSUETsid.setPlaceholder("Enter Student ID");
        ISSUETsid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ISSUETsidFocusLost(evt);
            }
        });
        ISSUETsid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISSUETsidActionPerformed(evt);
            }
        });
        Main_Panel.add(ISSUETsid, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 370, 380, -1));

        ISSUETbid.setBackground(new java.awt.Color(255, 102, 102));
        ISSUETbid.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        ISSUETbid.setForeground(new java.awt.Color(255, 255, 255));
        ISSUETbid.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        ISSUETbid.setPlaceholder("Enter Book ID");
        ISSUETbid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ISSUETbidFocusLost(evt);
            }
        });
        ISSUETbid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISSUETbidActionPerformed(evt);
            }
        });
        Main_Panel.add(ISSUETbid, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, 380, -1));

        ISSUEbid.setBackground(new java.awt.Color(255, 255, 255));
        ISSUEbid.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        ISSUEbid.setForeground(new java.awt.Color(0, 0, 0));
        ISSUEbid.setText("Enter Book ID");
        Main_Panel.add(ISSUEbid, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 240, -1, 30));

        rSDateChooser1.setForeground(new java.awt.Color(255, 0, 0));
        rSDateChooser1.setColorBackground(new java.awt.Color(255, 0, 51));
        rSDateChooser1.setColorButtonHover(new java.awt.Color(255, 153, 153));
        rSDateChooser1.setColorDiaActual(new java.awt.Color(0, 0, 255));
        rSDateChooser1.setColorForeground(new java.awt.Color(255, 51, 102));
        rSDateChooser1.setFont(new java.awt.Font("Liberation Mono", 1, 15)); // NOI18N
        rSDateChooser1.setFuente(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        rSDateChooser1.setPlaceholder("Select Issue Date");
        Main_Panel.add(rSDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 460, 380, 50));

        ISSUEsid1.setBackground(new java.awt.Color(255, 255, 255));
        ISSUEsid1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        ISSUEsid1.setForeground(new java.awt.Color(0, 0, 0));
        ISSUEsid1.setText("Enter Student ID");
        Main_Panel.add(ISSUEsid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 340, -1, 30));

        rSDateChooser2.setColorBackground(new java.awt.Color(255, 0, 51));
        rSDateChooser2.setColorButtonHover(new java.awt.Color(255, 153, 153));
        rSDateChooser2.setColorDiaActual(new java.awt.Color(0, 0, 255));
        rSDateChooser2.setColorForeground(new java.awt.Color(255, 51, 102));
        rSDateChooser2.setFont(new java.awt.Font("Liberation Mono", 1, 15)); // NOI18N
        rSDateChooser2.setFuente(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        rSDateChooser2.setPlaceholder("Select Due Date");
        Main_Panel.add(rSDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 560, 380, 50));

        ISSUEdate1.setBackground(new java.awt.Color(255, 255, 255));
        ISSUEdate1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        ISSUEdate1.setForeground(new java.awt.Color(0, 0, 0));
        ISSUEdate1.setText("Due Date");
        Main_Panel.add(ISSUEdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 530, -1, 30));

        ISSUEadd.setBackground(new java.awt.Color(255, 51, 51));
        ISSUEadd.setText("ISSUE Book");
        ISSUEadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISSUEaddActionPerformed(evt);
            }
        });
        Main_Panel.add(ISSUEadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 660, 340, 80));

        getContentPane().add(Main_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1411, 803));

        setSize(new java.awt.Dimension(1421, 833));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ISSBbranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISSBbranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISSBbranchActionPerformed

    private void ISSBcourseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ISSBcourseFocusLost

    }//GEN-LAST:event_ISSBcourseFocusLost

    private void ISSBcourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISSBcourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISSBcourseActionPerformed

    private void ISSBstudentnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISSBstudentnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISSBstudentnameActionPerformed

    private void ISSBstudentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ISSBstudentidFocusLost

    }//GEN-LAST:event_ISSBstudentidFocusLost

    private void ISSBstudentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISSBstudentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISSBstudentidActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
HomePage hm=new HomePage();
hm.setVisible(true);
dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ISBquantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBquantity1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBquantity1ActionPerformed

    private void ISBauthorname1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ISBauthorname1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBauthorname1FocusLost

    private void ISBauthorname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBauthorname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBauthorname1ActionPerformed

    private void ISBname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBname1ActionPerformed

    private void ISBid1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ISBid1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBid1FocusLost

    private void ISBid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBid1ActionPerformed

    private void ISSUETsidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ISSUETsidFocusLost
if (!ISSUETsid.getText().equals("")) {
  GetStudentDetails();
}// TODO add your handling code here:
    }//GEN-LAST:event_ISSUETsidFocusLost

    private void ISSUETsidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISSUETsidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISSUETsidActionPerformed

    private void ISSUETbidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ISSUETbidFocusLost
 if(!ISSUETbid.getText().equals("")){
            GetBookDetails();
        }
    }//GEN-LAST:event_ISSUETbidFocusLost

    private void ISSUETbidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISSUETbidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISSUETbidActionPerformed

    private void ISSUEaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISSUEaddActionPerformed
if(ISBquantity1.getText().equals("0")){
    JOptionPane.showMessageDialog(this,"Book Not Available");
            }else{
        if(isAlreadyIssued()==false){
        if(Issue_book()==true){
   JOptionPane.showMessageDialog(this,"Book Issued Successfully");
   updateBookDetails();
} else{
    JOptionPane.showMessageDialog(this,"Book Issued Failed");
}
}else{
    JOptionPane.showMessageDialog(this, "Already issue to same student");
}
}
    }//GEN-LAST:event_ISSUEaddActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Berror;
    private javax.swing.JLabel IAname1;
    private javax.swing.JLabel IAquantity1;
    private javax.swing.JLabel IBid1;
    private javax.swing.JLabel IBname1;
    private app.bolivia.swing.JCTextField ISBauthorname1;
    private javax.swing.JLabel ISBbranch;
    private javax.swing.JLabel ISBcourse;
    private app.bolivia.swing.JCTextField ISBid1;
    private app.bolivia.swing.JCTextField ISBname1;
    private app.bolivia.swing.JCTextField ISBquantity1;
    private javax.swing.JLabel ISBstudentid;
    private javax.swing.JLabel ISBstudentname;
    private app.bolivia.swing.JCTextField ISSBbranch;
    private app.bolivia.swing.JCTextField ISSBcourse;
    private app.bolivia.swing.JCTextField ISSBstudentid;
    private app.bolivia.swing.JCTextField ISSBstudentname;
    private app.bolivia.swing.JCTextField ISSUETbid;
    private app.bolivia.swing.JCTextField ISSUETsid;
    private necesario.RSMaterialButtonCircle ISSUEadd;
    private javax.swing.JLabel ISSUEbid;
    private javax.swing.JLabel ISSUEdate;
    private javax.swing.JLabel ISSUEdate1;
    private javax.swing.JLabel ISSUEsid1;
    private javax.swing.JPanel Main_Panel;
    private javax.swing.JLabel Serror;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private rojeru_san.componentes.RSDateChooser rSDateChooser1;
    private rojeru_san.componentes.RSDateChooser rSDateChooser2;
    // End of variables declaration//GEN-END:variables
}
