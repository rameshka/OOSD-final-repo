/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import model.Booking;
import model.CreateBookings;
import model.DateCreator;
import model.OldRoomBookings;
import model.RoomBooking;
import model.SubBooking;

/**
 *
 * @author Malsha
 */
public class Receptionist extends javax.swing.JFrame implements ActionListener {

    private ArrayList<SubBooking> subBooking = new ArrayList<>();
    private ArrayList<RoomBooking> bookings = new ArrayList<>();
    private ArrayList<JButton> buttonlist = new ArrayList<>();
    private ArrayList<Date> week = new ArrayList<>();
    private ArrayList<String> daysOfWeek = new ArrayList<>();
    private DateFormat df = new SimpleDateFormat("MMM d");
    private DateFormat dinyr = new SimpleDateFormat("D");
    private int weekNumber = 0;
    private ArrayList<JLabel> dates = new ArrayList<>();
    private ArrayList<String> roomNumbers = new ArrayList<>();
    private DateCreator dc = new DateCreator();
    private Date today = dc.getDate(0);
    private ImageIcon iconOpen = new ImageIcon("images\\open.jpg");
    private ImageIcon iconLock = new ImageIcon("images\\lock.png");
    private ImageIcon oldIconLock = new ImageIcon("images\\old_lock.png");
    private OldRoomBookings old = new OldRoomBookings();

    Date dateobj = new Date();
    private static Receptionist instance;

    /**
     * Creates new form Receptionist
     */
    private Receptionist() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        //generate buttons to room booking
        jPanel8.setLayout(new GridLayout(8, 17));
        if (weekNumber == 0) {
            // date list for labels
            week = dc.getWeek(0);
            for (int day = 0; day < 7; day++) {
                daysOfWeek.add(df.format(week.get(day)));
            }
            // room numbers list for labels
            for (int room = 1; room <= 16; room++) {
                roomNumbers.add("R" + room);
            }
            //create button list, with button name tha should be displayed
            for (int button = 0; button < 7 * 16; button++) {
                JButton b = new JButton(iconOpen);
                b.setMaximumSize(new Dimension(10, 10));
                b.setMinimumSize(new Dimension(10, 10));
                b.addActionListener(this);
                buttonlist.add(b);
            }
            int k = 0;
            int j = 0;
            for (int i = 0; i < 8 * 17; i++) {
                if (i == 0) {
                    jPanel8.add(new JLabel(""));
                } else if (i % 17 == 0) {
                    JLabel l = new JLabel(daysOfWeek.get(i / 17 - 1));
                    dates.add(l);
                    jPanel8.add(dates.get(j));
                    j += 1;
                } else if (i < 17) {
                    jPanel8.add(new JLabel(roomNumbers.get(i - 1)));
                } else {
                    jPanel8.add(buttonlist.get(k));
                    k += 1;
                }
            }
        }
        lockOldBookings(weekNumber);
    }
    
    public static Receptionist getInstance(){
        if(instance==null){
            instance = new Receptionist();
        }
        return instance;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\TKGreenGardens\\images\\Settings.png")); // NOI18N

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\TKGreenGardens\\images\\previous.jpg")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\TKGreenGardens\\images\\next.jpg")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Book");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("view details");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(54, 54, 54)
                .addComponent(jButton1)
                .addGap(327, 327, 327))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Room Booking", new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\TKGreenGardens\\images\\Room.jpg"), jPanel1); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gain                  ", new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\TKGreenGardens\\images\\Income.png"), jPanel4); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewDetails vd = new ViewDetails();
        vd.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        for(int index=0; index<buttonlist.size();index++){
            if(buttonlist.get(index).isSelected()==true){
                buttonlist.get(index).setIcon(oldIconLock);
                buttonlist.get(index).setSelected(false);
            }
        }
        CreateBookings cb = new CreateBookings();
        bookings = cb.getBookingList(subBooking);
        BookUI book = new BookUI(bookings);
       // book.jtex.sett();
        book.setWeekNo(weekNumber);
        subBooking.clear();
        book.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        weekNumber += 1;
        ButtonClick(weekNumber);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        weekNumber -= 1;
        ButtonClick(weekNumber);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void lockOldBookings(int weekNumber) {
        int dateToday = Integer.parseInt(dinyr.format(today));
        ArrayList<SubBooking> oldSubBookings = new ArrayList<>();
        oldSubBookings = old.getSubBookingList(weekNumber);
        for (int k = 0; k < oldSubBookings.size(); k++) {
            int r = oldSubBookings.get(k).getRoomNumber();
            int dateDiff = Math.abs(Integer.parseInt(dinyr.format(oldSubBookings.get(k).getDate())) - dateToday);
            int dayOfWeek = (dateDiff % 7) + 1;
            if (dateDiff / 7 == weekNumber) {
                int buttonIndex = 16 * (dayOfWeek - 1) + r - 1;
                buttonlist.get(buttonIndex).setIcon(oldIconLock);
            }
        }
    }

    public void ButtonClick(int weekNumber) {
        int dateToday = Integer.parseInt(dinyr.format(today));
        for (JButton buttonlist1 : buttonlist) {
            buttonlist1.setSelected(false);
            buttonlist1.setIcon(iconOpen);
        }
        lockOldBookings(weekNumber);

        for (SubBooking subBooking1 : subBooking) {
            int r = subBooking1.getRoomNumber();
            int dateDiff = Math.abs(Integer.parseInt(dinyr.format(subBooking1.getDate())) - dateToday);
            int dayOfWeek = (dateDiff % 7) + 1;
            if (dateDiff / 7 == weekNumber) {
                int buttonIndex = 16 * (dayOfWeek - 1) + r - 1;
                buttonlist.get(buttonIndex).setSelected(true);
                buttonlist.get(buttonIndex).setIcon(iconLock);
            }
        }
        if (weekNumber != 0) {
            week = dc.getWeek(weekNumber * 7);
            daysOfWeek.clear();
            for (int day = 0; day < 7; day++) {
                daysOfWeek.add(df.format(week.get(day)));
            }
            int j = 0;
            int k = 0;
            for (int i = 0; i < 8 * 17; i++) {
                if (i == 0) {
                } else if (i % 17 == 0) {
                    dates.get(j).setText(daysOfWeek.get(j));
                    j += 1;
                } else if (i < 17) {

                } else {
                    if (weekNumber > 0) {
                        buttonlist.get(k).setEnabled(true);
                    } else if (weekNumber < 0) {
                        //if(buttonlist.get(k).getIcon()==oldIconLock){
                          //  buttonlist.get(k).setEnabled(true);
                        //}else{
                        buttonlist.get(k).setEnabled(false);
                        //}
                    }
                    k += 1;
                }
            }
        } else {
           createPanel();
        }
    }
    
    public void createPanel() {
        week = dc.getWeek(0);
        daysOfWeek.clear();
        for (int day = 0; day < 7; day++) {
            daysOfWeek.add(df.format(week.get(day)));
        }
        int j = 0;
        int k = 0;
        for (int i = 0; i < 8 * 17; i++) {
            if ((i != 0) & (i % 17 == 0)) {
                dates.get(j).setText(daysOfWeek.get(j));
                j += 1;
            } else if ((i != 0) & (i > 17)) {
                buttonlist.get(k).setEnabled(true);
                if (weekNumber < 0) {
                    buttonlist.get(k).setEnabled(false);
                }
                k += 1;
            }
        }
    }

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
            java.util.logging.Logger.getLogger(Receptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receptionist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton b = (JButton) ae.getSource();
        for (int i = 0; i < buttonlist.size(); i++) {
            if (b.equals(buttonlist.get(i))) {
                if (buttonlist.get(i).isSelected() == false) {
                    if (buttonlist.get(i).getIcon() == oldIconLock) {
                        jButton1.setEnabled(true);
                    } else {
                        jButton1.setEnabled(false);
                        buttonlist.get(i).setIcon(iconLock);
                        buttonlist.get(i).setSelected(true);
                        int roomNo = (i % 16) + 1;
                        Date daate = week.get(i / 16);
                        subBooking.add(new SubBooking(roomNo, daate));
                    }
                } else {
                    jButton1.setEnabled(false);
                    for (int j = 0; j < subBooking.size(); j++) {
                        if ((subBooking.get(j).getRoomNumber() == ((i % 16) + 1)) & (Integer.parseInt(dinyr.format(subBooking.get(j).getDate())) == Integer.parseInt(dinyr.format(week.get(i / 16))))) {
                            subBooking.remove(j);
                        }
                    }
                    buttonlist.get(i).setIcon(iconOpen);
                    buttonlist.get(i).setSelected(false);
                }
            }
        }
    }
}