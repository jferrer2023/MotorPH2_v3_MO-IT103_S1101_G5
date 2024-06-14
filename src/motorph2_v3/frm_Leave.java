package motorph2_v3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frm_Leave extends javax.swing.JFrame {

     public frm_Leave() {
        initComponents();
        importCSV();
    }
 
    private void importCSV() {
        DefaultTableModel model = (DefaultTableModel) tbl_Leave.getModel();
        model.setRowCount(0); // Clear existing data

        String filePath = "C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                model.addRow(columns);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading CSV file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_Payroll = new javax.swing.JLabel();
        btn_Logout = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_Home = new javax.swing.JLabel();
        btn_Employees = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Leave = new javax.swing.JTable();
        btn_Salary = new javax.swing.JLabel();
        btn_ViewEmp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Leave Application");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(612, 612));
        jPanel1.setPreferredSize(new java.awt.Dimension(813, 600));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg9.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg7.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(42, 500));

        btn_Payroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Payroll2.png"))); // NOI18N
        btn_Payroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_PayrollMouseClicked(evt);
            }
        });

        btn_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Logout.png"))); // NOI18N
        btn_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Payroll)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Logout)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btn_Payroll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(597, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));

        btn_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Home.png"))); // NOI18N
        btn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_HomeMouseClicked(evt);
            }
        });

        btn_Employees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Employees2.png"))); // NOI18N
        btn_Employees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EmployeesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Home)
                    .addComponent(btn_Employees))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Employees)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tbl_Leave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee No.", "Lastname", "Firstname", "Status", "Position", "Supervisor", "Date From", "Date To", "Time In", "Time Out", "Hours Worked", "Duration", "Attendance Type", "Attendance Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_Leave);

        btn_Salary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Leave (2).png"))); // NOI18N
        btn_Salary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SalaryMouseClicked(evt);
            }
        });

        btn_ViewEmp.setBackground(new java.awt.Color(0, 0, 153));
        btn_ViewEmp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ViewEmp.setForeground(new java.awt.Color(255, 255, 255));
        btn_ViewEmp.setText("VIEW EMPLOYEE");
        btn_ViewEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewEmpActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg9.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Salary)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_ViewEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ViewEmp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(202, 202, 202)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_Salary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ViewEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewEmpActionPerformed
    int selectedRowIndex = tbl_Leave.getSelectedRow();

    if (selectedRowIndex != -1) {
        String empNo = tbl_Leave.getValueAt(selectedRowIndex, 0).toString();
        String lastname = tbl_Leave.getValueAt(selectedRowIndex, 1).toString();
        String firstname = tbl_Leave.getValueAt(selectedRowIndex, 2).toString();
        String status = tbl_Leave.getValueAt(selectedRowIndex, 3).toString();
        String position = tbl_Leave.getValueAt(selectedRowIndex, 4).toString();
        String supervisor = tbl_Leave.getValueAt(selectedRowIndex, 5).toString();
        String dateFromString = tbl_Leave.getValueAt(selectedRowIndex, 6).toString();
        String dateToString = tbl_Leave.getValueAt(selectedRowIndex, 7).toString();
        String timeInString = tbl_Leave.getValueAt(selectedRowIndex, 8).toString();
        String timeOutString = tbl_Leave.getValueAt(selectedRowIndex, 9).toString();
        double hoursWorked = Double.parseDouble(tbl_Leave.getValueAt(selectedRowIndex, 10).toString());
        double duration = Double.parseDouble(tbl_Leave.getValueAt(selectedRowIndex, 11).toString());
        String attendanceType = tbl_Leave.getValueAt(selectedRowIndex, 12).toString();
        String attendanceStatus = tbl_Leave.getValueAt(selectedRowIndex, 13).toString();

        try {
            // Define the date and time formats
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            // Parse the date and time strings into Date objects
            Date dateFrom = dateFormat.parse(dateFromString);
            Date dateTo = dateFormat.parse(dateToString);
            Date timeIn = timeFormat.parse(timeInString);
            Date timeOut = timeFormat.parse(timeOutString);

            // Convert Date objects back to String if necessary
            String dateFromStr = dateFormat.format(dateFrom);
            String dateToStr = dateFormat.format(dateTo);
            String timeInStr = timeFormat.format(timeIn);
            String timeOutStr = timeFormat.format(timeOut);

            frm_Leave2 leave2 = new frm_Leave2(empNo, lastname, firstname, status, position, supervisor, dateFromStr, dateToStr, timeInStr, timeOutStr, hoursWorked, duration, attendanceType, attendanceStatus);
            leave2.setVisible(true);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error parsing date or time.", "Parsing Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error parsing hours worked or duration.", "Parsing Error", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Please select an employee to view.", "No Employee Selected", JOptionPane.INFORMATION_MESSAGE);
    }
    

        
    }//GEN-LAST:event_btn_ViewEmpActionPerformed

    private void btn_SalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SalaryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SalaryMouseClicked

    private void btn_EmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EmployeesMouseClicked

        new frm_Employees().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_EmployeesMouseClicked
 
    private void btn_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseClicked

        new frm_MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_HomeMouseClicked

    private void btn_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogoutMouseClicked

        new frm_Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_LogoutMouseClicked

    private void btn_PayrollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PayrollMouseClicked

      //  new frm_Payroll().setVisible(true);
      //  this.dispose();
    }//GEN-LAST:event_btn_PayrollMouseClicked

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
            java.util.logging.Logger.getLogger(frm_Leave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Leave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Leave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Leave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new frm_Leave().setVisible(true);
                
            }
        });
    }

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_Employees;
    private javax.swing.JLabel btn_Home;
    private javax.swing.JLabel btn_Logout;
    private javax.swing.JLabel btn_Payroll;
    private javax.swing.JLabel btn_Salary;
    private javax.swing.JButton btn_ViewEmp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Leave;
    // End of variables declaration//GEN-END:variables
}
