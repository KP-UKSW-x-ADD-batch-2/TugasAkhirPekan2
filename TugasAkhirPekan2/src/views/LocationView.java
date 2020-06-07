/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.LocationController;
import controllers.icontrollers.ILocationController;
import daos.LocationDAO;
import daos.idaos.ILocationDAO;
import javax.swing.DefaultButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.Country;
import models.Location;
import tools.HibernateUtil;

/**
 *
 * @author Yosef Febrianes
 */
public class LocationView extends javax.swing.JFrame {

    /**
     * Creates new form LocationView
     */
    public LocationView() {
        initComponents();
        getById();
    }

    void getById() {
        HibernateUtil sessionFactory = new HibernateUtil();
        ILocationController ilc = new LocationController(sessionFactory.getSessionFactory());
//        ILocationDAO ildao = new LocationDAO(sessionFactory.getSessionFactory());

//        Region r = new Region();
        DefaultTableModel dt;
        DefaultButtonModel db;
        Object[] baris = {"No", "Location ID", "Street Address", "Postal Code", "City", "State Province", "Country ID"};
        dt = new DefaultTableModel(null, baris);
        locationTable.setModel(dt);
        locationIdField.setEditable(true);

        locationIdField.setText("");
        streetAddressField.setText("");
        postalCodeField.setText("");
        cityField.setText("");
        stateProvinceField.setText("");
        countryIdBox.setSelectedItem(null);

        try {
            int i = 1;
            for (Location regiong : ilc.getAll()) {
//                System.out.println(regiong.getRegionId() + " || " + regiong.getRegionName());

                String NO = Integer.toString(i);
                String ID = regiong.getId();
                String SA = regiong.getStreetAddress();
                String PC = regiong.getPostalCode();
                String C = regiong.getCity();
                String SP = regiong.getStateProvince();
                String CI = regiong.getCountry().getId();
                String bt = refreshButton + "";

                String[] data = {NO, ID, SA, PC, C, SP, CI, bt};
                dt.addRow(data);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void search() {
        HibernateUtil sessionFactory = new HibernateUtil();
        ILocationController ilc = new LocationController(sessionFactory.getSessionFactory());
        Location location = new Location(searchButton.getText());

//        Region r = new Region();
        DefaultTableModel dt;
        DefaultButtonModel db;

        Object[] baris = {"No", "Location ID", "Street Address", "Postal Code", "City", "State Province", "Country ID"};
        dt = new DefaultTableModel(null, baris);
        locationTable.setModel(dt);

        try {
            for (Location locationg : ilc.search(searchField.getText())) {
//                System.out.println(regiong.getRegionId() + " || " + regiong.getRegionName());

                String ID = locationg.getId();
                String SA = locationg.getStreetAddress();
                String PC = locationg.getPostalCode();
                String C = locationg.getCity();
                String SP = locationg.getStateProvince();
                String CI = locationg.getCountry().getId();
                String bt = refreshButton + "";

                String[] data = {ID, SA, PC, C, SP, CI, bt};
                dt.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        locationIdField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        streetAddressField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        locationTable = new javax.swing.JTable();
        postalCodeField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        stateProvinceField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        countryIdBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(252, 198, 3));

        jPanel2.setBackground(new java.awt.Color(249, 255, 255));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        jLabel5.setText("Location Table");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        locationIdField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        locationIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationIdFieldActionPerformed(evt);
            }
        });
        locationIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                locationIdFieldKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Location ID : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Street Address : ");

        streetAddressField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        streetAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetAddressFieldActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        insertButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        insertButton.setText("INSERT");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yosef Febrianes\\Downloads\\icons8-search-15.png")); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        refreshButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yosef Febrianes\\Downloads\\icons8-refresh-15.png")); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        locationTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        locationTable.setColumnSelectionAllowed(true);
        locationTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        locationTable.setRequestFocusEnabled(false);
        locationTable.setRowMargin(2);
        locationTable.setVerifyInputWhenFocusTarget(false);
        locationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locationTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(locationTable);

        postalCodeField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        postalCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postalCodeFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Postal Code : ");

        cityField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("City :");

        stateProvinceField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        stateProvinceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateProvinceFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("State Province :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Country ID :");

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yosef Febrianes\\Downloads\\icons8-exit-sign-46.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        countryIdBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C001", "C002", "C003", "C004", "C005" }));
        countryIdBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryIdBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stateProvinceField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(postalCodeField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(locationIdField)
                    .addComponent(streetAddressField)
                    .addComponent(cityField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(countryIdBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationIdField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(streetAddressField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(postalCodeField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cityField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(stateProvinceField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countryIdBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(insertButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchField)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(3, 3, 3)))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void locationIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationIdFieldActionPerformed

    }//GEN-LAST:event_locationIdFieldActionPerformed

    private void locationIdFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_locationIdFieldKeyReleased
        // TODO add your handling code here:
        int position = locationIdField.getCaretPosition();
        locationIdField.setText(locationIdField.getText().toUpperCase());
        locationIdField.setCaretPosition(position);
    }//GEN-LAST:event_locationIdFieldKeyReleased

    private void streetAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetAddressFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        HibernateUtil sessionFactory = new HibernateUtil();
        ILocationController ilc = new LocationController(sessionFactory.getSessionFactory());
        
        JOptionPane.showMessageDialog(null, ilc.update(locationIdField.getText(), streetAddressField.getText(), postalCodeField.getText(), cityField.getText(), stateProvinceField.getText(), countryIdBox.getSelectedItem().toString()));

        locationIdField.setText("");
        streetAddressField.setText("");
        postalCodeField.setText("");
        cityField.setText("");
        stateProvinceField.setText("");
        countryIdBox.setSelectedItem(null);

        getById();

    }//GEN-LAST:event_updateButtonActionPerformed


    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed

        HibernateUtil sessionFactory = new HibernateUtil();
        ILocationController ilc = new LocationController(sessionFactory.getSessionFactory());
//        Location location = new Location(locationIdField.getText(), streetAddressField.getText(), postalCodeField.getText(), cityField.getText(), stateProvinceField.getText(),(Country) countryIdBox.getSelectedItem());

        JOptionPane.showMessageDialog(null, ilc.insert(locationIdField.getText(), streetAddressField.getText(), postalCodeField.getText(), cityField.getText(), stateProvinceField.getText(), countryIdBox.getSelectedItem().toString()));
        SwingUtilities.updateComponentTreeUI(insertButton);

        locationIdField.setText("");
        streetAddressField.setText("");
        postalCodeField.setText("");
        cityField.setText("");
        stateProvinceField.setText("");
        countryIdBox.setSelectedItem(null);

        getById();
    }//GEN-LAST:event_insertButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        HibernateUtil sessionFactory = new HibernateUtil();
        ILocationController ilc = new LocationController(sessionFactory.getSessionFactory());
        //setText(source.getModel().getValueAt(row, column));
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Delete", "Title on Box", dialogButton);
        if (dialogResult == 0) {

            JOptionPane.showMessageDialog(null, ilc.delete(locationIdField.getText()));

            locationIdField.setText("");
            streetAddressField.setText("");
            postalCodeField.setText("");
            cityField.setText("");
            stateProvinceField.setText("");
            countryIdBox.setSelectedItem(null);

            getById();
        } else {
            getById();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        search();
        searchField.setText("");
    }//GEN-LAST:event_searchButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        getById();
        //        revalidate();
        //        repaint();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void locationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationTableMouseClicked
        HibernateUtil sessionFactory = new HibernateUtil();
        ILocationController ilc = new LocationController(sessionFactory.getSessionFactory());
        JTable source = (JTable) evt.getSource();
        int i = locationTable.getSelectedRow();
        TableModel model = locationTable.getModel();
        locationIdField.setEditable(false);

        locationIdField.setText(source.getModel().getValueAt(i, 1) + "");
        streetAddressField.setText(source.getModel().getValueAt(i, 2) + "");
        postalCodeField.setText(source.getModel().getValueAt(i, 3) + "");
        cityField.setText(source.getModel().getValueAt(i, 4) + "");
        stateProvinceField.setText(source.getModel().getValueAt(i, 5) + "");

        String sub1 = model.getValueAt(i, 6) + "";
        switch (sub1) {
            case "C001":
                countryIdBox.setSelectedIndex(0);
                break;
            case "C002":
                countryIdBox.setSelectedIndex(1);
                break;
            case "C003":
                countryIdBox.setSelectedIndex(2);
                break;
            case "C004":
                countryIdBox.setSelectedIndex(3);
                break;
            case "C005":
                countryIdBox.setSelectedIndex(4);
                break;
        }
    }//GEN-LAST:event_locationTableMouseClicked

    private void postalCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postalCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postalCodeFieldActionPerformed

    private void cityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityFieldActionPerformed

    private void stateProvinceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateProvinceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateProvinceFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void countryIdBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryIdBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryIdBoxActionPerformed

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
            java.util.logging.Logger.getLogger(LocationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocationView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cityField;
    private javax.swing.JComboBox<String> countryIdBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField locationIdField;
    private javax.swing.JTable locationTable;
    private javax.swing.JTextField postalCodeField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField stateProvinceField;
    private javax.swing.JTextField streetAddressField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
