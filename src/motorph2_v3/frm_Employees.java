
package motorph2_v3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class frm_Employees extends javax.swing.JFrame {

   
    public frm_Employees() {
        initComponents();
        
        importCSV();
    }

    private void importCSV() {
        DefaultTableModel model = (DefaultTableModel) tbl_Emp.getModel();
        model.setRowCount(0); // Clear existing data

        String filePath = "C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Employee Details.csv";

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
        btn_Logout = new javax.swing.JLabel();
        btn_Payroll = new javax.swing.JLabel();
        btn_Salary = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_Home = new javax.swing.JLabel();
        btn_Employees = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Emp = new javax.swing.JTable();
        btn_ViewEmp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Details");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(813, 600));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg9.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg7.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(42, 500));

        btn_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Logout.png"))); // NOI18N
        btn_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LogoutMouseClicked(evt);
            }
        });

        btn_Payroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Payroll2.png"))); // NOI18N
        btn_Payroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_PayrollMouseClicked(evt);
            }
        });

        btn_Salary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Leave (2).png"))); // NOI18N
        btn_Salary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SalaryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_Salary)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Payroll, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_Logout, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_Salary)
                .addGap(18, 18, 18)
                .addComponent(btn_Payroll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));

        btn_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Home.png"))); // NOI18N
        btn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_HomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Home)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Home, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
        );

        btn_Employees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Employees2.png"))); // NOI18N
        btn_Employees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EmployeesMouseClicked(evt);
            }
        });

        tbl_Emp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee No.", "Lastname", "Firstname", "Birthdate", "Address", "Phone Number", "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position", "Supervisor", "Basic Salary", "Rice Subsidy Allow", "Phone Allow", "Clothing Allow", "Gross Semi Allow", "Hourly Rate", "SL Count", "VL Count", "SL Used", "VL Used", "SL Bal", "VL Bal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_EmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Emp);

        btn_ViewEmp.setBackground(new java.awt.Color(0, 0, 153));
        btn_ViewEmp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ViewEmp.setForeground(new java.awt.Color(255, 255, 255));
        btn_ViewEmp.setText("VIEW EMPLOYEE");
        btn_ViewEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Employees))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 717, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ViewEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ViewEmp, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Employees)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ViewEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewEmpActionPerformed
    int selectedRowIndex = tbl_Emp.getSelectedRow();
    if (selectedRowIndex != -1) {
        // Extract the displayed columns
        String empNo = tbl_Emp.getValueAt(selectedRowIndex, 0).toString();
        String lastname = tbl_Emp.getValueAt(selectedRowIndex, 1).toString();
        String firstname = tbl_Emp.getValueAt(selectedRowIndex, 2).toString();
        String birthdate = tbl_Emp.getValueAt(selectedRowIndex, 3).toString();
        String address = tbl_Emp.getValueAt(selectedRowIndex, 4).toString();
        String phone = tbl_Emp.getValueAt(selectedRowIndex, 5).toString();
        String sss = tbl_Emp.getValueAt(selectedRowIndex, 6).toString();
        String philhealth = tbl_Emp.getValueAt(selectedRowIndex, 7).toString();
        String tin = tbl_Emp.getValueAt(selectedRowIndex, 8).toString();
        String pagibig = tbl_Emp.getValueAt(selectedRowIndex, 9).toString();
        String status = tbl_Emp.getValueAt(selectedRowIndex, 10).toString();
        String position = tbl_Emp.getValueAt(selectedRowIndex, 11).toString();
        String supervisor = tbl_Emp.getValueAt(selectedRowIndex, 12).toString();
        String basicSalary = tbl_Emp.getValueAt(selectedRowIndex, 13).toString();
        String riceSubsidyAllow = tbl_Emp.getValueAt(selectedRowIndex, 14).toString();
        String phoneAllow = tbl_Emp.getValueAt(selectedRowIndex, 15).toString();
        String clothingAllow = tbl_Emp.getValueAt(selectedRowIndex, 16).toString();
        String grossSemiAllow = tbl_Emp.getValueAt(selectedRowIndex, 17).toString();
        String hourlyRate = tbl_Emp.getValueAt(selectedRowIndex, 18).toString();
        
        double SLCount = 0;
        double VLCount = 0;
        double SLUsed = 0;
        double VLUsed = 0;
        double SLBal = 0;
        double VLBal = 0;
        // Check if the SLCount and VLCount columns exist
        if (tbl_Emp.getColumnCount() > 19) {
            SLCount = Double.parseDouble(tbl_Emp.getValueAt(selectedRowIndex, 19).toString());
        }
        if (tbl_Emp.getColumnCount() > 20) {
            VLCount = Double.parseDouble(tbl_Emp.getValueAt(selectedRowIndex, 20).toString());
        }
        if (tbl_Emp.getColumnCount() > 21) {
            SLUsed = Double.parseDouble(tbl_Emp.getValueAt(selectedRowIndex, 21).toString());
        }
        if (tbl_Emp.getColumnCount() > 22) {
            VLUsed = Double.parseDouble(tbl_Emp.getValueAt(selectedRowIndex, 22).toString());
        }
        if (tbl_Emp.getColumnCount() > 23) {
            SLBal = Double.parseDouble(tbl_Emp.getValueAt(selectedRowIndex, 23).toString());
        }
        if (tbl_Emp.getColumnCount() > 24) {
            VLBal = Double.parseDouble(tbl_Emp.getValueAt(selectedRowIndex, 24).toString());
        }
        

        // Pass all the values to frm_Employees2
        frm_Employees2 employees2 = new frm_Employees2(empNo, lastname, firstname, birthdate, address, phone, sss, philhealth, tin, pagibig, status, position, supervisor, basicSalary, riceSubsidyAllow, phoneAllow, clothingAllow, grossSemiAllow, hourlyRate, SLCount, VLCount, SLUsed, VLUsed, SLBal, VLBal);
        employees2.setVisible(true);
        
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Please select an employee to view.", "No Employee Selected", JOptionPane.INFORMATION_MESSAGE);
    }
    
   

    }//GEN-LAST:event_btn_ViewEmpActionPerformed

    private void btn_EmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EmployeesMouseClicked

        new frm_Employees().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_EmployeesMouseClicked

    private void btn_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseClicked

        new frm_MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_HomeMouseClicked

    private void btn_SalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SalaryMouseClicked
        this.dispose();
        new frm_Leave().setVisible(true);
    }//GEN-LAST:event_btn_SalaryMouseClicked

    private void btn_PayrollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PayrollMouseClicked

      //  new frm_Payroll().setVisible(true);
      //  this.dispose();

    }//GEN-LAST:event_btn_PayrollMouseClicked

    private void btn_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogoutMouseClicked

        new frm_Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_LogoutMouseClicked

    private void tbl_EmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_EmpMouseClicked
        
        
        
    }//GEN-LAST:event_tbl_EmpMouseClicked

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
            java.util.logging.Logger.getLogger(frm_Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Employees().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Emp;
    // End of variables declaration//GEN-END:variables
}
