
package motorph2_v3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




public class frm_Employees2 extends javax.swing.JFrame {
           private boolean isEditMode = false;
           private String originalEmpNo = "";
    
   public frm_Employees2(String empNo, String lastname, String firstname, String birthdate, String address, String phone, String sss, String philhealth, String tin, String pagibig, String status, String position, String supervisor, String basicSalary, String riceSubsidyAllow, String phoneAllow, String clothingAllow, String grossSemiMonth, String hourlyRate, double SLCount, double VLCount, double SLUsed, double VLUsed, double SLBal, double VLBal) {
        initComponents();

        txt_EmpNo.setText(empNo);
        txt_Lastname.setText(lastname);
        txt_Firstname.setText(firstname);
        txt_Birthdate.setText(birthdate);
        txt_Address.setText(address);
        txt_Phone.setText(phone);
        txt_SSS.setText(sss);
        txt_Philhealth.setText(philhealth);
        txt_TIN.setText(tin);
        txt_Pagibig.setText(pagibig);
        txt_Status.setText (status);
        txt_Position.setText (position);
        txt_Supervisor.setText (supervisor);
        txt_Basic.setText (basicSalary);
        txt_RiceAllow.setText (riceSubsidyAllow);
        txt_PhoneAllow.setText (phoneAllow);
        txt_ClothingAllow.setText (clothingAllow);
        txt_GrossSemi.setText (grossSemiMonth);
        txt_HourlyRate.setText (hourlyRate);
        txt_SLCount.setText(String.valueOf(SLCount));
        txt_VLCount.setText(String.valueOf(VLCount));
        txt_SLUsed.setText(String.valueOf(SLUsed));
        txt_VLUsed.setText(String.valueOf(VLUsed));
        txt_SLBal.setText(String.valueOf(SLBal));
        txt_VLBal.setText(String.valueOf(VLBal));
        
        double slBal = SLCount - SLUsed;
        txt_SLBal.setText(String.valueOf(slBal));
        
        double vlBal = VLCount - VLUsed;
        txt_VLBal.setText(String.valueOf(vlBal));
        
        originalEmpNo = empNo;
        isEditMode = true;
    }


    public frm_Employees2() {
        initComponents();
    }
    
    
//*****Methods to sync the data from frm_Employees2 to frm_Leave (Attendance CSV)
        private void writeToLeaveApplicationCSV(String empNo, String lastname, String firstname, String status, String position, String supervisor, String dateFrom, String dateTo, String timeIn, String timeOut, String hoursWorked, String duration, String attendanceType, String attendanceStatus) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv", true))) {
            bw.write(empNo + "," + lastname + "," + firstname + "," + status + "," + position + "," + supervisor + "," + dateFrom + "," + dateTo + "," + timeIn + "," + timeOut + "," + hoursWorked + "," + duration + "," + attendanceType + "," + attendanceStatus);
            bw.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error writing to Leave Application CSV: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
 private void removeFromLeaveApplicationCSV(String empNo) {
    List<String> leaveLines = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            // Check if the employee number matches, and skip writing that line
            if (parts.length > 0 && !parts[0].equals(empNo)) {
                leaveLines.add(line);
            }
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error reading leave application data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv"))) {
        for (String line : leaveLines) {
            bw.write(line);
            bw.newLine();
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error updating leave application data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void updateInLeaveApplicationCSV(String empNo, String lastname, String firstname, String status, String position, String supervisor) {
   List<String> leaveLines = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            // Check if the employee number matches, and update the corresponding line
            if (parts.length > 0 && parts[0].equals(empNo)) {
                // Update the relevant fields (assuming the structure of the leave CSV)
                parts[1] = lastname;
                parts[2] = firstname;
                parts[3] = status;
                parts[4] = position;
                parts[5] = supervisor;
              
                // Reconstruct the line
                line = String.join(",", parts);
            }
            leaveLines.add(line);
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error reading leave application data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv"))) {
        for (String line : leaveLines) {
            bw.write(line);
            bw.newLine();
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error updating leave application data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }
    

    
//*****Methods for updating the Used SL and VS from frm_Leave2 to frm_Employees2
    public void updateSLUsedField(String empNo) {
    
    }
    
     public void updateVLUsedField(String empNo) {
 
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_Logout = new javax.swing.JLabel();
        btn_Payroll = new javax.swing.JLabel();
        btn_Salary = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_Home = new javax.swing.JLabel();
        btn_Employees = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_EmpNo = new javax.swing.JTextField();
        txt_Lastname = new javax.swing.JTextField();
        txt_Firstname = new javax.swing.JTextField();
        txt_Birthdate = new javax.swing.JTextField();
        txt_Address = new javax.swing.JTextField();
        txt_Phone = new javax.swing.JTextField();
        txt_SSS = new javax.swing.JTextField();
        txt_Philhealth = new javax.swing.JTextField();
        txt_TIN = new javax.swing.JTextField();
        txt_Pagibig = new javax.swing.JTextField();
        btn_EditEmp = new javax.swing.JButton();
        btn_DelEmp = new javax.swing.JButton();
        btn_SaveEmp = new javax.swing.JButton();
        btn_AddEmp = new javax.swing.JButton();
        btn_Back = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_Status = new javax.swing.JTextField();
        txt_Position = new javax.swing.JTextField();
        txt_Supervisor = new javax.swing.JTextField();
        txt_Basic = new javax.swing.JTextField();
        txt_HourlyRate = new javax.swing.JTextField();
        txt_PhoneAllow = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_ClothingAllow = new javax.swing.JTextField();
        txt_GrossSemi = new javax.swing.JTextField();
        txt_RiceAllow = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        dropdown_PayMonth = new javax.swing.JComboBox<>();
        btn_Compute = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_Netpay = new javax.swing.JTextField();
        txt_SLCount = new javax.swing.JTextField();
        txt_VLCount = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_SLUsed = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_VLUsed = new javax.swing.JTextField();
        txt_SLBal = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txt_VLBal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Details");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(813, 600));

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Salary))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Payroll)
                            .addComponent(btn_Logout))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btn_Salary)
                .addGap(18, 18, 18)
                .addComponent(btn_Payroll)
                .addGap(18, 18, 18)
                .addComponent(btn_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(364, Short.MAX_VALUE))
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

        jLabel1.setText("Employee No:");

        jLabel4.setText("Lastname:");

        jLabel5.setText("Firstname:");

        jLabel6.setText("Birthdate:");

        jLabel7.setText("Address:");

        jLabel8.setText("Phone No:");

        jLabel9.setText("SSS No:");

        jLabel10.setText("Philhealth No:");

        jLabel11.setText("TIN No:");

        jLabel12.setText("Pagibig No:");

        txt_EmpNo.setEditable(false);

        txt_Lastname.setEditable(false);

        txt_Firstname.setEditable(false);

        txt_Birthdate.setEditable(false);

        txt_Address.setEditable(false);
        txt_Address.setMaximumSize(new java.awt.Dimension(64, 22));

        txt_Phone.setEditable(false);

        txt_SSS.setEditable(false);

        txt_Philhealth.setEditable(false);

        txt_TIN.setEditable(false);

        txt_Pagibig.setEditable(false);
        txt_Pagibig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PagibigActionPerformed(evt);
            }
        });

        btn_EditEmp.setBackground(new java.awt.Color(0, 0, 153));
        btn_EditEmp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_EditEmp.setForeground(new java.awt.Color(255, 255, 255));
        btn_EditEmp.setText("EDIT");
        btn_EditEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditEmpActionPerformed(evt);
            }
        });

        btn_DelEmp.setBackground(new java.awt.Color(0, 0, 153));
        btn_DelEmp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_DelEmp.setForeground(new java.awt.Color(255, 255, 255));
        btn_DelEmp.setText("DELETE");
        btn_DelEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DelEmpActionPerformed(evt);
            }
        });

        btn_SaveEmp.setBackground(new java.awt.Color(0, 0, 153));
        btn_SaveEmp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_SaveEmp.setForeground(new java.awt.Color(255, 255, 255));
        btn_SaveEmp.setText("SAVE");
        btn_SaveEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveEmpActionPerformed(evt);
            }
        });

        btn_AddEmp.setBackground(new java.awt.Color(0, 0, 153));
        btn_AddEmp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_AddEmp.setForeground(new java.awt.Color(255, 255, 255));
        btn_AddEmp.setText("ADD");
        btn_AddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddEmpActionPerformed(evt);
            }
        });

        btn_Back.setBackground(new java.awt.Color(0, 0, 153));
        btn_Back.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Back.setForeground(new java.awt.Color(255, 255, 255));
        btn_Back.setText("BACK");
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });

        jLabel13.setText("Status:");

        jLabel14.setText("Position:");

        jLabel15.setText("Supervisor:");

        jLabel16.setText("Rice Subsidy Allow.:");

        jLabel17.setText("Phone Allow.:");

        jLabel18.setText("Gross Semi Month:");

        txt_Status.setEditable(false);

        txt_Position.setEditable(false);

        txt_Supervisor.setEditable(false);

        txt_Basic.setEditable(false);

        txt_HourlyRate.setEditable(false);

        txt_PhoneAllow.setEditable(false);
        txt_PhoneAllow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PhoneAllowActionPerformed(evt);
            }
        });

        jLabel19.setText("Hourly Rate:");

        jLabel21.setText("Clothing Allow.:");

        txt_ClothingAllow.setEditable(false);
        txt_ClothingAllow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ClothingAllowActionPerformed(evt);
            }
        });

        txt_GrossSemi.setEditable(false);
        txt_GrossSemi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GrossSemiActionPerformed(evt);
            }
        });

        txt_RiceAllow.setEditable(false);

        jLabel20.setText("Basic Salary:");

        jLabel22.setText("Payroll Month:");

        dropdown_PayMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dropdown_PayMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdown_PayMonthActionPerformed(evt);
            }
        });

        btn_Compute.setBackground(new java.awt.Color(0, 0, 153));
        btn_Compute.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Compute.setForeground(new java.awt.Color(255, 255, 255));
        btn_Compute.setText("COMPUTE");
        btn_Compute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ComputeActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg9.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("EARNINGS:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("DEDUCTIONS:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("NET PAY:");

        txt_SLCount.setEditable(false);

        txt_VLCount.setEditable(false);

        jLabel25.setText("SL Count:");

        jLabel26.setText("VL Count:");

        txt_SLUsed.setEditable(false);

        jLabel27.setText("SL Used:");

        jLabel28.setText("VL Used:");

        jLabel29.setText("SL Bal:");

        txt_VLUsed.setEditable(false);

        txt_SLBal.setEditable(false);

        jLabel30.setText("VL Bal:");

        txt_VLBal.setEditable(false);

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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_AddEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_EditEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_SaveEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_DelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_RiceAllow, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_PhoneAllow, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_Basic, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                    .addComponent(txt_Position)
                                    .addComponent(txt_Status)
                                    .addComponent(txt_Pagibig)
                                    .addComponent(txt_TIN)
                                    .addComponent(txt_Philhealth)
                                    .addComponent(txt_SSS)
                                    .addComponent(txt_Phone)
                                    .addComponent(txt_Birthdate)
                                    .addComponent(txt_Firstname)
                                    .addComponent(txt_Lastname)
                                    .addComponent(txt_EmpNo)
                                    .addComponent(txt_Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_Supervisor))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(2, 2, 2)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel30)
                                                            .addComponent(jLabel29))))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(26, 26, 26)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(txt_SLCount, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txt_VLCount, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txt_SLBal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txt_VLBal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel27)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_SLUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_VLUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_GrossSemi, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(txt_HourlyRate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ClothingAllow))))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24))
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dropdown_PayMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Compute, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_Netpay, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_AddEmp)
                            .addComponent(btn_EditEmp)
                            .addComponent(btn_SaveEmp)
                            .addComponent(btn_DelEmp)
                            .addComponent(btn_Back)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Compute)
                            .addComponent(dropdown_PayMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Employees)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_EmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_SLCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_VLCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_SLUsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)
                                    .addComponent(txt_VLUsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel29)
                            .addComponent(txt_SLBal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel30)
                            .addComponent(txt_VLBal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_SSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addComponent(jLabel23))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Philhealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_TIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Pagibig, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Position, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Supervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Basic, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_RiceAllow, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_PhoneAllow, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_ClothingAllow, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_GrossSemi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(txt_HourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(txt_Netpay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogoutMouseClicked

        new frm_Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_LogoutMouseClicked

    private void btn_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseClicked

        new frm_MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_HomeMouseClicked

    private void btn_EmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EmployeesMouseClicked
        
        new frm_Employees2().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btn_EmployeesMouseClicked

    private void btn_PayrollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PayrollMouseClicked
        
     //   new frm_Payroll().setVisible(true);
     //   this.dispose();
        
    }//GEN-LAST:event_btn_PayrollMouseClicked
      
    private void btn_EditEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditEmpActionPerformed
    if (txt_Lastname.getText().isEmpty() || 
        txt_Firstname.getText().isEmpty() ||
        txt_Birthdate.getText().isEmpty() ||
        txt_Address.getText().isEmpty() ||
        txt_Phone.getText().isEmpty() ||
        txt_SSS.getText().isEmpty() ||
        txt_Philhealth.getText().isEmpty() ||
        txt_TIN.getText().isEmpty() ||
        txt_Pagibig.getText().isEmpty() ||
        txt_Status.getText().isEmpty() ||
        txt_Position.getText().isEmpty() ||
        txt_Supervisor.getText().isEmpty() ||
        txt_Basic.getText().isEmpty() ||
        txt_RiceAllow.getText().isEmpty() ||
        txt_PhoneAllow.getText().isEmpty() ||
        txt_ClothingAllow.getText().isEmpty() ||
        txt_GrossSemi.getText().isEmpty() ||
        txt_HourlyRate.getText().isEmpty() ||
        txt_SLCount.getText().isEmpty() ||
        txt_VLCount.getText().isEmpty() ) {
        
        
        // Show error message
        JOptionPane.showMessageDialog(null, "Please fill out all the information", "Error", JOptionPane.ERROR_MESSAGE);
    } else { 
        // Enable text fields
        txt_Lastname.setEditable(true);
        txt_Firstname.setEditable(true);
        txt_Birthdate.setEditable(true);
        txt_Address.setEditable(true);
        txt_Phone.setEditable(true);
        txt_SSS.setEditable(true);
        txt_Philhealth.setEditable(true);
        txt_TIN.setEditable(true);
        txt_Pagibig.setEditable(true);
        txt_Status.setEditable(true);
        txt_Position.setEditable(true);
        txt_Supervisor.setEditable(true);
        txt_Basic.setEditable(true);
        txt_RiceAllow.setEditable(true);
        txt_PhoneAllow.setEditable(true);
        txt_ClothingAllow.setEditable(true);
        txt_GrossSemi.setEditable(true);
        txt_HourlyRate.setEditable(true);
        txt_SLCount.setEditable(true);
        txt_VLCount.setEditable(true);

        // Set edit mode to true (for editing an existing record)
        isEditMode = true;
    }
    
    
    
     
    }//GEN-LAST:event_btn_EditEmpActionPerformed

    private void btn_DelEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DelEmpActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            String empNo = txt_EmpNo.getText();

            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Employee Details.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading employee data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                if (parts.length >= 10 && parts[0].equals(empNo)) {
                    lines.remove(i);
                    found = true;
                    break;
                }
            }

            if (found) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Employee Details.csv"))) {
                    for (String line : lines) {
                        bw.write(line);
                        bw.newLine();
                    }
                    JOptionPane.showMessageDialog(this, "Employee data deleted successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error deleting employee data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        // Remove from Leave Application CSV
        removeFromLeaveApplicationCSV(empNo);
        
            clearTextFields();
            setFieldsEditable(false);
        }
    }

    private void clearTextFields() {
        txt_EmpNo.setText("");
        txt_Lastname.setText("");
        txt_Firstname.setText("");
        txt_Birthdate.setText("");
        txt_Address.setText("");
        txt_Phone.setText("");
        txt_SSS.setText("");
        txt_Philhealth.setText("");
        txt_TIN.setText("");
        txt_Pagibig.setText("");
        txt_Status.setText("");
        txt_Position.setText("");
        txt_Supervisor.setText("");
        txt_Basic.setText("");
        txt_RiceAllow.setText("");
        txt_PhoneAllow.setText("");
        txt_ClothingAllow.setText("");
        txt_GrossSemi.setText("");
        txt_HourlyRate.setText(""); 
        txt_SLCount.setText("");
        txt_VLCount.setText(""); 
        txt_SLUsed.setText("");
        txt_VLUsed.setText(""); 
        txt_SLBal.setText("");
        txt_VLBal.setText(""); 
    }

    private void setFieldsEditable(boolean editable) {
        txt_EmpNo.setEditable(editable);
        txt_Lastname.setEditable(editable);
        txt_Firstname.setEditable(editable);
        txt_Birthdate.setEditable(editable);
        txt_Address.setEditable(editable);
        txt_Phone.setEditable(editable);
        txt_SSS.setEditable(editable);
        txt_Philhealth.setEditable(editable);
        txt_TIN.setEditable(editable);
        txt_Pagibig.setEditable(editable);
        txt_Status.setEditable(editable);
        txt_Position.setEditable(editable);
        txt_Supervisor.setEditable(editable);
        txt_Basic.setEditable(editable);
        txt_RiceAllow.setEditable(editable);
        txt_PhoneAllow.setEditable(editable);
        txt_ClothingAllow.setEditable(editable);
        txt_GrossSemi.setEditable(editable);
        txt_HourlyRate.setEditable(editable);   
        txt_SLCount.setEditable(editable);
        txt_VLCount.setEditable(editable); 
        txt_SLUsed.setEditable(editable);
        txt_VLUsed.setEditable(editable);
        txt_SLBal.setEditable(editable);
        txt_VLBal.setEditable(editable);
    }//GEN-LAST:event_btn_DelEmpActionPerformed

    private void btn_SaveEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveEmpActionPerformed
    if (txt_Lastname.getText().isEmpty() || 
        txt_Firstname.getText().isEmpty() ||
        txt_Birthdate.getText().isEmpty() ||
        txt_Address.getText().isEmpty() ||
        txt_Phone.getText().isEmpty() ||
        txt_SSS.getText().isEmpty() ||
        txt_Philhealth.getText().isEmpty() ||
        txt_TIN.getText().isEmpty() ||
        txt_Pagibig.getText().isEmpty() ||
        txt_Status.getText().isEmpty() ||
        txt_Position.getText().isEmpty() ||
        txt_Supervisor.getText().isEmpty() ||
        txt_Basic.getText().isEmpty() ||
        txt_RiceAllow.getText().isEmpty() ||
        txt_PhoneAllow.getText().isEmpty() ||
        txt_ClothingAllow.getText().isEmpty() ||
        txt_GrossSemi.getText().isEmpty() ||
        txt_HourlyRate.getText().isEmpty() ||
        txt_SLCount.getText().isEmpty() ||
        txt_VLCount.getText().isEmpty() ||
        txt_SLUsed.getText().isEmpty() ||
        txt_VLUsed.getText().isEmpty() ||
        txt_SLBal.getText().isEmpty() ||
        txt_VLBal.getText().isEmpty() ) {
        // Show error message
        JOptionPane.showMessageDialog(null, "Please fill out all the information", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String empNo = txt_EmpNo.getText(); // Ensure empNo is declared here
        String lastname = txt_Lastname.getText();
        String firstname = txt_Firstname.getText();
        String birthdate = txt_Birthdate.getText();
        String address = txt_Address.getText();
        String phone = txt_Phone.getText();
        String sss = txt_SSS.getText();
        String philhealth = txt_Philhealth.getText();
        String tin = txt_TIN.getText();
        String pagibig = txt_Pagibig.getText();
      
        String status = txt_Status.getText();
        String position = txt_Position.getText();
        String supervisor = txt_Supervisor.getText();
        String basic = txt_Basic.getText();
        String phoneallow = txt_PhoneAllow.getText();
        String riceallow = txt_RiceAllow.getText();
        String clothingallow = txt_ClothingAllow.getText();
        String grosssemi = txt_GrossSemi.getText();
        String hourlyrate = txt_HourlyRate.getText();
        String SLCount = txt_SLCount.getText();
        String VLCount = txt_VLCount.getText();
        String SLUsed = txt_SLUsed.getText();
        String VLUsed = txt_VLUsed.getText();
        String SLBal = txt_SLBal.getText();
        String VLBal = txt_VLBal.getText();

        if (isEditMode) {
            // Read the existing data from the CSV file
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Employee Details.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading employee data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update the relevant record
            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                if (parts.length >= 10 && parts[0].equals(empNo)) {
                    lines.set(i, empNo + "," + lastname + "," + firstname + "," + birthdate + "," + address + "," + phone + "," + sss + "," + philhealth + "," + tin + "," + pagibig + "," + status + "," + position + "," + supervisor + "," + basic + "," + phoneallow + "," + riceallow + "," + clothingallow + "," + grosssemi + "," + hourlyrate+ "," + SLCount + "," + VLCount+ "," + SLUsed + "," + VLUsed + "," + SLBal + "," + VLBal);
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Error: Employee record not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Write the updated data back to the CSV file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Employee Details.csv"))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(this, "Employee data updated successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error updating employee data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Call the method to update CSV
            updateInLeaveApplicationCSV(empNo, lastname, firstname, status, position, supervisor);
    /*    } else {
            // Append new record to the CSV file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v2_Ryu\\src\\motorph2_v2\\MotorPH Employee Details.csv", true))) {
                bw.write(empNo + "," + lastname + "," + firstname + "," + birthdate + "," + address + "," + phone + "," + sss + "," + philhealth + "," + tin + "," + pagibig + "," + status + "," + position + "," + supervisor + "," + basic + "," + phoneallow + "," + riceallow + "," + clothingallow + "," + grosssemi + "," + hourlyrate+ "," + SLCount + "," + VLCount+ "," + SLUsed + "," + VLUsed+ "," + SLBal + "," + VLBal);
                bw.newLine();
                JOptionPane.showMessageDialog(this, "Employee data saved successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving employee data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }   */

    //MIKKO START (In-Progress)
    } else {
                
            String SLUsedDefault = "0";
            String VLUsedDefault = "0";
            String VLBalDefault = "0";
            String SLBalDefault = "0";
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Employee Details.csv", true))) {
                bw.write(empNo + "," + lastname + "," + firstname + "," + birthdate + "," + address + "," + phone + "," + sss + "," + philhealth + "," + tin + "," + pagibig + "," + status + "," + position + "," + supervisor + "," + basic + "," + phoneallow + "," + riceallow + "," + clothingallow + "," + grosssemi + "," + hourlyrate+ "," + SLCount + "," + VLCount + "," + SLUsedDefault + "," + VLUsedDefault + "," + VLBalDefault + "," + SLBalDefault);
                bw.newLine();
                    JOptionPane.showMessageDialog(this, "Employee data saved successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving employee data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }

            // Call the method to write to Leave Application CSV
            
            
          
            String dateFrom = "01-Jan-1900";
            String dateTo = "01-Jan-1900";
            String timeIn = "00:00";
            String timeOut = "00:00";
            String hoursWorked = "0.0";
            String duration = "0.0";
            String attendanceType = "Select Attendance Type";
            String attendanceStatus = "Select Attendance Status";
           
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv", true))) {
                bw.write(empNo + "," + lastname + "," + lastname + "," + status + "," + position + "," + supervisor + "," + dateFrom + "," + dateTo + "," + timeIn + "," + timeOut + "," + hoursWorked + "," + duration + "," + attendanceType + "," + attendanceStatus);
                bw.newLine();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error updating attendance data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        
    
    //MIKOO END (In-Progress)
    
            // Call the method to write to Leave Application CSV
            writeToLeaveApplicationCSV(empNo, lastname, firstname, status, position, supervisor, dateFrom, dateTo, timeIn, timeOut, hoursWorked, duration, attendanceType, attendanceStatus);
        }

        // Disable the text fields after saving
        txt_EmpNo.setEditable(false);
        txt_Lastname.setEditable(false);
        txt_Firstname.setEditable(false);
        txt_Birthdate.setEditable(false);
        txt_Address.setEditable(false);
        txt_Phone.setEditable(false);
        txt_SSS.setEditable(false);
        txt_Philhealth.setEditable(false);
        txt_TIN.setEditable(false);
        txt_Pagibig.setEditable(false);
        txt_Status.setEditable(false);
        txt_Position.setEditable(false);
        txt_Supervisor.setEditable(false);
        txt_Basic.setEditable(false);
        txt_RiceAllow.setEditable(false);
        txt_PhoneAllow.setEditable(false);
        txt_ClothingAllow.setEditable(false);
        txt_GrossSemi.setEditable(false);
        txt_HourlyRate.setEditable(false);
        txt_SLCount.setEditable(false);
        txt_VLCount.setEditable(false);
        txt_SLUsed.setEditable(false);
        txt_VLUsed.setEditable(false);
        txt_SLBal.setEditable(false);
        txt_VLBal.setEditable(false);
    }
        
    }//GEN-LAST:event_btn_SaveEmpActionPerformed

    private void btn_SalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SalaryMouseClicked
        this.dispose();
        new frm_Leave().setVisible(true);
    }//GEN-LAST:event_btn_SalaryMouseClicked
    
    
    private void btn_AddEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddEmpActionPerformed
     if (txt_Lastname.getText().isEmpty() || 
        txt_Firstname.getText().isEmpty() ||
        txt_Birthdate.getText().isEmpty() ||
        txt_Address.getText().isEmpty() ||
        txt_Phone.getText().isEmpty() ||
        txt_SSS.getText().isEmpty() ||
        txt_Philhealth.getText().isEmpty() ||
        txt_TIN.getText().isEmpty() ||
        txt_Pagibig.getText().isEmpty() ||
        txt_Status.getText().isEmpty() ||
        txt_Position.getText().isEmpty() ||
        txt_Supervisor.getText().isEmpty() ||
        txt_Basic.getText().isEmpty() ||
        txt_RiceAllow.getText().isEmpty() ||
        txt_PhoneAllow.getText().isEmpty() ||
        txt_ClothingAllow.getText().isEmpty() ||
        txt_GrossSemi.getText().isEmpty() ||
        txt_HourlyRate.getText().isEmpty() ||
        txt_SLCount.getText().isEmpty() ||
        txt_VLCount.getText().isEmpty() ||
        txt_SLUsed.getText().isEmpty() ||
        txt_VLUsed.getText().isEmpty() ||
        txt_SLBal.getText().isEmpty() ||
        txt_VLBal.getText().isEmpty()
             
             ) {
        
        // Show error message
        JOptionPane.showMessageDialog(null, "Please fill out all the information", "Error", JOptionPane.ERROR_MESSAGE);
    } else { 
        // Clear text fields
        txt_EmpNo.setText("");
        txt_Lastname.setText("");
        txt_Firstname.setText("");
        txt_Birthdate.setText("");
        txt_Address.setText("");
        txt_Phone.setText("");
        txt_SSS.setText("");
        txt_Philhealth.setText("");
        txt_TIN.setText("");
        txt_Pagibig.setText("");
        txt_Status.setText("");
        txt_Position.setText("");
        txt_Supervisor.setText("");
        txt_Basic.setText("");
        txt_RiceAllow.setText("");
        txt_PhoneAllow.setText("");
        txt_ClothingAllow.setText("");
        txt_GrossSemi.setText("");
        txt_HourlyRate.setText(""); 
        txt_SLCount.setText("");
        txt_VLCount.setText(""); 
        txt_SLUsed.setText("");
        txt_VLUsed.setText(""); 
        txt_SLBal.setText("");
        txt_VLBal.setText(""); 
        
        // Enable text fields
        txt_EmpNo.setEditable(true);
        txt_Lastname.setEditable(true);
        txt_Firstname.setEditable(true);
        txt_Birthdate.setEditable(true);
        txt_Address.setEditable(true);
        txt_Phone.setEditable(true);
        txt_SSS.setEditable(true);
        txt_Philhealth.setEditable(true);
        txt_TIN.setEditable(true);
        txt_Pagibig.setEditable(true);
        txt_Status.setEditable(true);
        txt_Position.setEditable(true);
        txt_Supervisor.setEditable(true);
        txt_Basic.setEditable(true);
        txt_RiceAllow.setEditable(true);
        txt_PhoneAllow.setEditable(true);
        txt_ClothingAllow.setEditable(true);
        txt_GrossSemi.setEditable(true);
        txt_HourlyRate.setEditable(true);
        txt_SLCount.setEditable(true);
        txt_VLCount.setEditable(true);
        txt_SLUsed.setEditable(true);
        txt_VLUsed.setEditable(true);
        txt_SLBal.setEditable(true);
        txt_VLBal.setEditable(true);
        // Set edit mode to false (for adding a new record)
        isEditMode = false;
    }

    }//GEN-LAST:event_btn_AddEmpActionPerformed

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        new frm_Employees().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_BackActionPerformed

    private void txt_PhoneAllowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PhoneAllowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PhoneAllowActionPerformed

    private void txt_ClothingAllowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ClothingAllowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ClothingAllowActionPerformed

    private void txt_GrossSemiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GrossSemiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GrossSemiActionPerformed

    private void btn_ComputeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ComputeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ComputeActionPerformed

    private void txt_PagibigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PagibigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PagibigActionPerformed

    private void dropdown_PayMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropdown_PayMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dropdown_PayMonthActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Employees2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Employees2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Employees2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Employees2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new frm_Employees2().setVisible(true);
            }
        });
    }

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddEmp;
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_Compute;
    private javax.swing.JButton btn_DelEmp;
    private javax.swing.JButton btn_EditEmp;
    private javax.swing.JLabel btn_Employees;
    private javax.swing.JLabel btn_Home;
    private javax.swing.JLabel btn_Logout;
    private javax.swing.JLabel btn_Payroll;
    private javax.swing.JLabel btn_Salary;
    private javax.swing.JButton btn_SaveEmp;
    private javax.swing.JComboBox<String> dropdown_PayMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_Address;
    private javax.swing.JTextField txt_Basic;
    private javax.swing.JTextField txt_Birthdate;
    private javax.swing.JTextField txt_ClothingAllow;
    private javax.swing.JTextField txt_EmpNo;
    private javax.swing.JTextField txt_Firstname;
    private javax.swing.JTextField txt_GrossSemi;
    private javax.swing.JTextField txt_HourlyRate;
    private javax.swing.JTextField txt_Lastname;
    private javax.swing.JTextField txt_Netpay;
    private javax.swing.JTextField txt_Pagibig;
    private javax.swing.JTextField txt_Philhealth;
    private javax.swing.JTextField txt_Phone;
    private javax.swing.JTextField txt_PhoneAllow;
    private javax.swing.JTextField txt_Position;
    private javax.swing.JTextField txt_RiceAllow;
    private javax.swing.JTextField txt_SLBal;
    private javax.swing.JTextField txt_SLCount;
    private javax.swing.JTextField txt_SLUsed;
    private javax.swing.JTextField txt_SSS;
    private javax.swing.JTextField txt_Status;
    private javax.swing.JTextField txt_Supervisor;
    private javax.swing.JTextField txt_TIN;
    private javax.swing.JTextField txt_VLBal;
    private javax.swing.JTextField txt_VLCount;
    private javax.swing.JTextField txt_VLUsed;
    // End of variables declaration//GEN-END:variables

    private void setEditableTextFields(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
