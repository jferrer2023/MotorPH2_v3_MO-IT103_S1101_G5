package motorph2_v3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frm_Leave2 extends javax.swing.JFrame {
           private boolean isEditMode = false;
           private String originalEmpNo = "";
           
    public frm_Leave2(String empNo, String lastname, String firstname, String status, String position, String supervisor, String dateFrom, String dateTo, String timeIn, String timeOut, double hoursWorked, double duration, String attendanceType, String attendanceStatus) {
    initComponents();
    txt_EmpNo.setText(empNo);
    txt_Lastname.setText(lastname);
    txt_Firstname.setText(firstname);
    txt_Status.setText (status);
    txt_Position.setText (position);
    txt_Supervisor.setText (supervisor);

    // Convert date strings to Date objects
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            Date fromDate = dateFormat.parse(dateFrom);
            Date toDate = dateFormat.parse(dateTo);

            jcal_DateFrom.setDate(fromDate);
            jcal_DateTo.setDate(toDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error parsing date.", "Date Parsing Error", JOptionPane.ERROR_MESSAGE);
        }
 
    txt_TimeIn.setText(timeIn);
    txt_TimeOut.setText(timeOut);
    txt_HoursWorked.setText(String.valueOf(hoursWorked));
    txt_Duration.setText(String.valueOf(duration));
    dropdown_Attendancetype.setSelectedItem(attendanceType);
    dropdown_AttendanceStatus.setSelectedItem(attendanceStatus);
    

    originalEmpNo = empNo;
    isEditMode = true;
       
    }

    public frm_Leave2() {
        initComponents();
    }
    
    private void updateDuration() {
        Date fromDate = jcal_DateFrom.getDate();
        Date toDate = jcal_DateTo.getDate();

        long difference = toDate.getTime() - fromDate.getTime();
        long daysDifference = difference / (1000 * 60 * 60 * 24);

        txt_Duration.setText(String.valueOf(daysDifference));
    }
    
private void updateInAttendanceCSV(String empNo, String lastname, String firstname, String status, String position, String supervisor, String dateFrom, String dateTo, String timeIn, String timeOut, String hoursWorked, String duration, String attendanceType, String attendanceStatus) {
    List<String> attendanceLines = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            // Check if the employee number matches, and update the corresponding line
            if (parts.length >= 17 && parts[0].equals(empNo)) {
                // Update the relevant fields
                parts[1] = lastname;
                parts[2] = firstname;
                parts[3] = status;
                parts[4] = position;
                parts[5] = supervisor;
                parts[6] = dateFrom;
                parts[7] = dateTo;
                parts[8] = timeIn;
                parts[9] = timeOut;
                parts[10] = hoursWorked;
                parts[11] = duration;
                parts[12] = attendanceType;
                parts[13] = attendanceStatus;
                // Reconstruct the line
                line = String.join(",", parts);
            }
            attendanceLines.add(line);
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error reading attendance data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv"))) {
        for (String line : attendanceLines) {
            bw.write(line);
            bw.newLine();
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error updating attendance data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void writeToAttendanceCSV(String empNo, String lastname, String firstname, String status, String position, String supervisor, String dateFrom, String dateTo, String timeIn, String timeOut, String hoursWorked, String duration, String attendanceType, String attendanceStatus) {
    List<String> attendanceLines = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            // Check if the employee number matches, and update the corresponding line
            if (parts.length >= 17 && parts[0].equals(empNo)) {
                // Update the relevant fields
                parts[1] = lastname;
                parts[2] = firstname;
                parts[3] = status;
                parts[4] = position;
                parts[5] = supervisor;
                parts[6] = dateFrom;
                parts[7] = dateTo;
                parts[8] = timeIn;
                parts[9] = timeOut;
                parts[10] = hoursWorked;
                parts[11] = duration;
                parts[12] = attendanceType;
                parts[13] = attendanceStatus;
                // Reconstruct the line
                line = String.join(",", parts);
            }
            attendanceLines.add(line);
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error reading attendance data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv"))) {
        for (String line : attendanceLines) {
            bw.write(line);
            bw.newLine();
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error adding attendance data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        btn_Salary = new javax.swing.JLabel();
        btn_AddLeave = new javax.swing.JButton();
        btn_EditLeave = new javax.swing.JButton();
        btn_SubmitLeave = new javax.swing.JButton();
        btn_DelLeave = new javax.swing.JButton();
        btn_ApproveLeave = new javax.swing.JButton();
        btn_RejectLeave = new javax.swing.JButton();
        btn_Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_EmpNo = new javax.swing.JTextField();
        txt_Lastname = new javax.swing.JTextField();
        txt_Firstname = new javax.swing.JTextField();
        txt_Status = new javax.swing.JTextField();
        txt_Position = new javax.swing.JTextField();
        txt_Supervisor = new javax.swing.JTextField();
        dropdown_Attendancetype = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_Duration = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_TimeIn = new javax.swing.JFormattedTextField();
        txt_TimeOut = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_HoursWorked = new javax.swing.JTextField();
        dropdown_AttendanceStatus = new javax.swing.JComboBox<>();
        jcal_DateFrom = new com.toedter.calendar.JDateChooser();
        jcal_DateTo = new com.toedter.calendar.JDateChooser();
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Payroll)
                    .addComponent(btn_Logout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btn_Payroll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(594, Short.MAX_VALUE))
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

        btn_Salary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frm_MainMenu_Leave (2).png"))); // NOI18N
        btn_Salary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SalaryMouseClicked(evt);
            }
        });

        btn_AddLeave.setBackground(new java.awt.Color(0, 0, 153));
        btn_AddLeave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_AddLeave.setForeground(new java.awt.Color(255, 255, 255));
        btn_AddLeave.setText("ADD");
        btn_AddLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddLeaveActionPerformed(evt);
            }
        });

        btn_EditLeave.setBackground(new java.awt.Color(0, 0, 153));
        btn_EditLeave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_EditLeave.setForeground(new java.awt.Color(255, 255, 255));
        btn_EditLeave.setText("EDIT");
        btn_EditLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditLeaveActionPerformed(evt);
            }
        });

        btn_SubmitLeave.setBackground(new java.awt.Color(0, 0, 153));
        btn_SubmitLeave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_SubmitLeave.setForeground(new java.awt.Color(255, 255, 255));
        btn_SubmitLeave.setText("SUBMIT");
        btn_SubmitLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SubmitLeaveActionPerformed(evt);
            }
        });

        btn_DelLeave.setBackground(new java.awt.Color(0, 0, 153));
        btn_DelLeave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_DelLeave.setForeground(new java.awt.Color(255, 255, 255));
        btn_DelLeave.setText("DELETE");
        btn_DelLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DelLeaveActionPerformed(evt);
            }
        });

        btn_ApproveLeave.setBackground(new java.awt.Color(0, 0, 153));
        btn_ApproveLeave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ApproveLeave.setForeground(new java.awt.Color(255, 255, 255));
        btn_ApproveLeave.setText("APPROVE");
        btn_ApproveLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ApproveLeaveActionPerformed(evt);
            }
        });

        btn_RejectLeave.setBackground(new java.awt.Color(0, 0, 153));
        btn_RejectLeave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_RejectLeave.setForeground(new java.awt.Color(255, 255, 255));
        btn_RejectLeave.setText("REJECT");
        btn_RejectLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RejectLeaveActionPerformed(evt);
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

        jLabel1.setText("Employee ID:");

        jLabel5.setText("Lastname:");

        jLabel6.setText("Firstname:");

        jLabel7.setText("Status:");

        jLabel8.setText("Position:");

        jLabel9.setText("Supervisor:");

        txt_EmpNo.setEditable(false);

        txt_Lastname.setEditable(false);

        txt_Firstname.setEditable(false);

        txt_Status.setEditable(false);

        txt_Position.setEditable(false);

        txt_Supervisor.setEditable(false);

        dropdown_Attendancetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Attendance Type", "VL Request", "SL Request", "Unpaid Leave", "Work" }));
        dropdown_Attendancetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdown_AttendancetypeActionPerformed(evt);
            }
        });

        jLabel10.setText("Attendance Type");

        jLabel11.setText("Date To:");

        jLabel12.setText("Date From:");

        jLabel13.setText("Duration:");

        jLabel18.setText("Attendance Status:");

        jLabel17.setText("Time In:");

        jLabel20.setText("Time Out:");

        txt_TimeIn.setEditable(false);

        txt_TimeOut.setEditable(false);

        jLabel23.setText("Hours Worked:");

        txt_HoursWorked.setEditable(false);

        dropdown_AttendanceStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Attendance Status", "Pending", "Approved", "Rejected", "Closed-On Time", "Closed-Late" }));

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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_AddLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_EditLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_SubmitLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_DelLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_ApproveLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_RejectLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)
                        .addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(jLabel23)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_EmpNo)
                            .addComponent(dropdown_Attendancetype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_TimeIn)
                            .addComponent(txt_TimeOut)
                            .addComponent(txt_HoursWorked)
                            .addComponent(txt_Duration)
                            .addComponent(txt_Firstname)
                            .addComponent(txt_Status)
                            .addComponent(txt_Position)
                            .addComponent(txt_Supervisor)
                            .addComponent(txt_Lastname)
                            .addComponent(dropdown_AttendanceStatus, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcal_DateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcal_DateTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_AddLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_EditLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_SubmitLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_DelLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ApproveLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_RejectLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(txt_EmpNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txt_Supervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcal_DateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jcal_DateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_TimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TimeOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_HoursWorked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_Duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(dropdown_Attendancetype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dropdown_AttendanceStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    //   new frm_Payroll().setVisible(true);
    //    this.dispose();
    }//GEN-LAST:event_btn_PayrollMouseClicked

    private void btn_AddLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddLeaveActionPerformed
        if (txt_Lastname.getText().isEmpty() ||
        txt_Firstname.getText().isEmpty() ||
        txt_Status.getText().isEmpty() ||
        txt_Position.getText().isEmpty() ||
        txt_Supervisor.getText().isEmpty() ||
        txt_HoursWorked.getText().isEmpty() ||
        txt_Duration.getText().isEmpty()) {

        // Show error message
        JOptionPane.showMessageDialog(null, "Please fill out all the information", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // Set default time values
        txt_TimeIn.setText("00:00");
        txt_TimeOut.setText("00:00");
        
        // Set default values for date pickers
        Calendar calendar = Calendar.getInstance();
        calendar.set(1900, Calendar.JANUARY, 1);
        Date defaultDate = calendar.getTime();
        jcal_DateFrom.setDate(defaultDate);
        jcal_DateTo.setDate(defaultDate);
        
        // Enable text fields
        txt_TimeIn.setEditable(true);
        txt_TimeOut.setEditable(true);
        
        
        
        txt_TimeIn.setEditable(true);
        txt_TimeOut.setEditable(true);

        // Set default values for dropdowns
        dropdown_Attendancetype.setSelectedItem("Select Attendance Type");
        dropdown_AttendanceStatus.setSelectedItem("Select Attendance Status");

        // Set edit mode to false (for adding a new record)
        isEditMode = false;
    }
     

    }//GEN-LAST:event_btn_AddLeaveActionPerformed

    private void btn_EditLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditLeaveActionPerformed
        if (txt_EmpNo.getText().isEmpty() || 
        txt_Lastname.getText().isEmpty() || 
        txt_Firstname.getText().isEmpty() ||
        txt_Status.getText().isEmpty() ||
        txt_Position.getText().isEmpty() ||
        txt_Supervisor.getText().isEmpty() ||
        txt_TimeIn.getText().isEmpty() ||
        txt_TimeOut.getText().isEmpty() ||
        txt_HoursWorked.getText().isEmpty() ||
        txt_Duration.getText().isEmpty() ) {

        
        // Show error message
        JOptionPane.showMessageDialog(null, "Please fill out all the information", "Error", JOptionPane.ERROR_MESSAGE);
    } else { 
        // Enable text fields
        txt_TimeIn.setEditable(true);
        txt_TimeOut.setEditable(true);



        // Set edit mode to true (for editing an existing record)
        isEditMode = true;
    }
    }//GEN-LAST:event_btn_EditLeaveActionPerformed

    private void btn_SubmitLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SubmitLeaveActionPerformed
      if (txt_Lastname.getText().isEmpty() || 
    txt_Firstname.getText().isEmpty() ||
    txt_Status.getText().isEmpty() ||
    txt_Position.getText().isEmpty() ||
    txt_Supervisor.getText().isEmpty() ||
    jcal_DateFrom.getDate() == null ||
    jcal_DateTo.getDate() == null ||
    txt_TimeIn.getText().isEmpty() ||
    txt_TimeOut.getText().isEmpty() ||
    txt_HoursWorked.getText().isEmpty() ||
    txt_Duration.getText().isEmpty() ||
    dropdown_Attendancetype.getSelectedItem() == null ||
    dropdown_AttendanceStatus.getSelectedItem() == null) {
    
    // Show error message
    JOptionPane.showMessageDialog(null, "Please fill out all the information", "Error", JOptionPane.ERROR_MESSAGE);
} else {
    String empNo = txt_EmpNo.getText();
    String lastname = txt_Lastname.getText();
    String firstname = txt_Firstname.getText();
    String status = txt_Status.getText();
    String position = txt_Position.getText();
    String supervisor = txt_Supervisor.getText();
    
    // Format dates from JCalendar
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    String dateFrom = dateFormat.format(jcal_DateFrom.getDate());
    String dateTo = dateFormat.format(jcal_DateTo.getDate());
    
    String timeIn = txt_TimeIn.getText();
    String timeOut = txt_TimeOut.getText();
    String hoursWorked = txt_HoursWorked.getText();
    String duration = txt_Duration.getText();
    
    // Get values from dropdown menus
    String attendanceType = dropdown_Attendancetype.getSelectedItem().toString();
    String attendanceStatus = dropdown_AttendanceStatus.getSelectedItem().toString();

        if (isEditMode) {
            // Read the existing data from the CSV file
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv"))) {
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
                if (parts.length >= 14 && parts[0].equals(empNo)) {
                    // Update columns 
                parts[1] = lastname;
                parts[2] = firstname;
                parts[3] = status;
                parts[4] = position;
                parts[5] = supervisor;
                parts[6] = dateFrom;
                parts[7] = dateTo;
                parts[8] = timeIn;
                parts[9] = timeOut;
                parts[10] = hoursWorked;
                parts[11] = duration;
                parts[12] = attendanceType;
                parts[13] = attendanceStatus;
                    // Reconstruct the line
                    lines.set(i, String.join(",", parts));
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Error: Employee record not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Write the updated data back to the CSV file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv"))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(this, "Employee data updated successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error updating employee data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Call the method to update in Attendance CSV
            updateInAttendanceCSV(empNo, lastname, firstname, status, position, supervisor, dateFrom, dateTo, timeIn, timeOut, hoursWorked, duration, attendanceType, attendanceStatus);
        } else {
            // Append new record to the CSV file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv", true))) {
                // Write only columns 8 to 11
                bw.write(empNo +  "," + lastname +  "," + firstname+  "," + status+  "," + position+  "," + supervisor+  "," + dateFrom +  "," + dateTo +  "," +  timeIn + "," + timeOut + "," + hoursWorked + "," + duration +  "," + attendanceType +  "," + attendanceStatus);
                bw.newLine();
                JOptionPane.showMessageDialog(this, "Employee data saved successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving employee data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Call the method to write to Attendance CSV

    /*writeToAttendanceCSV(empNo, lastname, firstname, status, position, supervisor, timeIn, timeOut, hoursWorked, duration, dateFrom, dateTo, attendanceType, attendanceStatus);
    JOptionPane.showMessageDialog(null, "Employee data saved successfully."); */
        
    writeToAttendanceCSV(empNo, lastname, firstname, status, position, supervisor,dateFrom, dateTo, timeIn, timeOut, hoursWorked, duration, attendanceType, attendanceStatus);
    JOptionPane.showMessageDialog(null, "Employee data saved successfully.");
    
        // Disable the text fields after saving
        txt_EmpNo.setEditable(false);
        txt_Lastname.setEditable(false);
        txt_Firstname.setEditable(false);
        txt_Status.setEditable(false);
        txt_Position.setEditable(false);
        txt_Supervisor.setEditable(false);
        txt_TimeIn.setEditable(false);
        txt_TimeOut.setEditable(false);
        txt_Duration.setEditable(false);
        txt_HoursWorked.setEditable(false);
    }
    }//GEN-LAST:event_btn_SubmitLeaveActionPerformed
 }
    private void btn_DelLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DelLeaveActionPerformed
      int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (response == JOptionPane.YES_OPTION) {
        String empNo = txt_EmpNo.getText();
        String filePath = "C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Attendance Details.csv";

        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading employee data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean found = false;
        for (ListIterator<String> it = lines.listIterator(); it.hasNext();) {
            String[] parts = it.next().split(",");
            if (parts.length >= 10 && parts[0].equals(empNo)) {
                it.remove();
                found = true;
                break;
            }
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, false))) {
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
    }

    }//GEN-LAST:event_btn_DelLeaveActionPerformed

    private void btn_ApproveLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ApproveLeaveActionPerformed
     
     // Show confirmation dialog
    int response = JOptionPane.showConfirmDialog(this, "Do you want to approve the leave request?", " ", JOptionPane.YES_NO_OPTION);

    if (response == JOptionPane.YES_OPTION) {
        // Set dropdown_AttendanceStatus to "Approved"
        dropdown_AttendanceStatus.setSelectedItem("Approved");

        // Get the employee number and duration
        String empNo = txt_EmpNo.getText();
        double duration = Double.parseDouble(txt_Duration.getText());

        // Check if dropdown_Attendancetype is "SL Request"
        if ("SL Request".equals(dropdown_Attendancetype.getSelectedItem().toString())) {
            // Update CSV and notify frm_Employees2
            updateLeaveDetails(empNo, duration, "SL");
            // Notify frm_Employees2 to update the SLUsed field
            frm_Employees2 employees2 = new frm_Employees2();
            employees2.updateSLUsedField(empNo);
        } else if ("VL Request".equals(dropdown_Attendancetype.getSelectedItem().toString())) {
            // Update CSV and notify frm_Employees2
            updateLeaveDetails(empNo, duration, "VL");
            // Notify frm_Employees2 to update the VLUsed field
            frm_Employees2 employees2 = new frm_Employees2();
            employees2.updateVLUsedField(empNo);
        }
    }
}

private void updateLeaveDetails(String empNo, double duration, String leaveType) {
    String csvFilePath = "C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Employee Details.csv";
    List<String> updatedLines = new ArrayList<>();
    boolean found = false;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length >= 24 && data[0].equals(empNo)) {
                // Initialize the necessary columns
                double slCount = Double.parseDouble(data[19]);
                double vlCount = Double.parseDouble(data[20]);
                double slUsed = Double.parseDouble(data[21]);
                double vlUsed = Double.parseDouble(data[22]);
                double slBal = Double.parseDouble(data[23]);
                double vlBal = Double.parseDouble(data[24]);

                if ("SL".equals(leaveType)) {
                    slUsed += duration;
                    slBal = slCount - slUsed;
                    data[21] = String.valueOf(slUsed);
                    data[23] = String.valueOf(slBal);
                } else if ("VL".equals(leaveType)) {
                    vlUsed += duration;
                    vlBal = vlCount - vlUsed;
                    data[22] = String.valueOf(vlUsed);
                    data[24] = String.valueOf(vlBal);
                }
                found = true;
            }
            updatedLines.add(String.join(",", data));
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating leave details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (found) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            for (String updatedLine : updatedLines) {
                bw.write(updatedLine);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error writing updated leave details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Employee not found in CSV file", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }
private void updateSLDetails(String empNo, double duration) {
    String csvFilePath = "C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Employee Details.csv";
    List<String> updatedLines = new ArrayList<>();
    boolean found = false;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length >= 24 && data[0].equals(empNo)) {
                // Update SL Used and SL Bal
                double slUsed = Double.parseDouble(data[21]) + duration;
                data[21] = String.valueOf(slUsed);
                // Mark as found
                found = true;
            }
            updatedLines.add(String.join(",", data));
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating SL details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (found) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            for (String updatedLine : updatedLines) {
                bw.write(updatedLine);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error writing updated SL details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Employee not found in CSV file", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void updateVLDetails (String empNo, double duration) {
    String csvFilePath = "C:\\Users\\IT-Spare\\Documents\\NetBeansProjects\\MotorPH2_v3\\src\\motorph2_v3\\MotorPH Employee Details.csv";
    List<String> updatedLines = new ArrayList<>();
    boolean found = false;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length >= 24 && data[0].equals(empNo)) {
                // Update SL Used and SL Bal
                double slUsed = Double.parseDouble(data[22]) + duration;
                data[22] = String.valueOf(slUsed);
                // Mark as found
                found = true;
            }
            updatedLines.add(String.join(",", data));
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating SL details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (found) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            for (String updatedLine : updatedLines) {
                bw.write(updatedLine);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error writing updated SL details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Employee not found in CSV file", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    }//GEN-LAST:event_btn_ApproveLeaveActionPerformed

    private void btn_RejectLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RejectLeaveActionPerformed
         // Show confirmation dialog
    int response = JOptionPane.showConfirmDialog(this, "Do you want to reject the leave request?", " ", JOptionPane.YES_NO_OPTION);

    if (response == JOptionPane.YES_OPTION) {
        // Set dropdown_AttendanceStatus to "Approved"
        dropdown_AttendanceStatus.setSelectedItem("Rejected");
    }
        
    }//GEN-LAST:event_btn_RejectLeaveActionPerformed

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        new frm_Leave().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_BackActionPerformed

    private void dropdown_AttendancetypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropdown_AttendancetypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dropdown_AttendancetypeActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Leave2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Leave2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Leave2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Leave2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                
                new frm_Leave2().setVisible(true);
                
            }
        });
    }

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddLeave;
    private javax.swing.JButton btn_ApproveLeave;
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_DelLeave;
    private javax.swing.JButton btn_EditLeave;
    private javax.swing.JLabel btn_Employees;
    private javax.swing.JLabel btn_Home;
    private javax.swing.JLabel btn_Logout;
    private javax.swing.JLabel btn_Payroll;
    private javax.swing.JButton btn_RejectLeave;
    private javax.swing.JLabel btn_Salary;
    private javax.swing.JButton btn_SubmitLeave;
    private javax.swing.JComboBox<String> dropdown_AttendanceStatus;
    private javax.swing.JComboBox<String> dropdown_Attendancetype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jcal_DateFrom;
    private com.toedter.calendar.JDateChooser jcal_DateTo;
    private javax.swing.JTextField txt_Duration;
    private javax.swing.JTextField txt_EmpNo;
    private javax.swing.JTextField txt_Firstname;
    private javax.swing.JTextField txt_HoursWorked;
    private javax.swing.JTextField txt_Lastname;
    private javax.swing.JTextField txt_Position;
    private javax.swing.JTextField txt_Status;
    private javax.swing.JTextField txt_Supervisor;
    private javax.swing.JFormattedTextField txt_TimeIn;
    private javax.swing.JFormattedTextField txt_TimeOut;
    // End of variables declaration//GEN-END:variables
}
