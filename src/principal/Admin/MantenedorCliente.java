/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.Admin;

import api.ClienteService;
import api.RubroService;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.Cliente;
import models.Rubro;

import models.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author AlexF
 */
public class MantenedorCliente extends javax.swing.JFrame {

    /**
     * Creates new form MantenedorCliente
     */
    public MantenedorCliente() {
        initComponents();
        
        this.jTableClientes.setModel(showData());
        labelPrueba.setVisible(false);
        RubroService rs = new RubroService();
        
        JSONArray array = rs.getRubro();
        ArrayList arr = new ArrayList();
        for (int i = 0; i < array.length(); i++) {
                JSONObject row = array.getJSONObject(i);
                
                if(row.getInt("RUBRO_ACTIVO") != 0){
                    cmbRubroClienteEdit.addItem(
                        new Rubro(row.getInt("RUBRO_ID"), row.getString("RUBRO_NOMBRE"), row.getInt("RUBRO_ACTIVO"))
                    );
                }
                
                if(row.getInt("RUBRO_ACTIVO") != 0){
                    cmbSelectorRubroCliente.addItem(
                     new Rubro(row.getInt("RUBRO_ID"), row.getString("RUBRO_NOMBRE"), row.getInt("RUBRO_ACTIVO"))
                    );
                }
        }
        
        this.jTableClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                String clienteId = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0).toString();
                String clienteNombre = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 1).toString();
                String clienteDireccion = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 2).toString();
                String clienteCorreo = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 3).toString();
                String clienteRut = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 4).toString();
                String clienteEstado = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 5).toString();
                String clienteRubro = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 6).toString();
                
                
                labelPrueba.setText(clienteId);
                labelPrueba.setVisible(false);
                txtNombreClienteEdit.setText(clienteNombre);
                txtDireccionClienteEdit.setText(clienteDireccion);
                
                txtRutClienteEdit.setText(clienteRut);
                txtCorreoClienteEdit.setText(clienteCorreo);
                
                if(clienteEstado.equalsIgnoreCase("1")){
                    radioActivoClienteEdit.setSelected(true);
                }else if(clienteEstado.equalsIgnoreCase("0")){
                    radioInactivoClienteEdit.setSelected(true);
                }
                
//                System.out.println(cmbRubroClienteEdit.getItemAt(cmbRubroClienteEdit.getSelectedIndex()).getRubro_nombre());
                
                
                for (int i=0; i<cmbRubroClienteEdit.getModel().getSize(); i++)
                {
                    if (cmbRubroClienteEdit.getItemAt(i).toString().equals(clienteRubro))
                    {
                        cmbRubroClienteEdit.setSelectedIndex(i);
                        break;
                    }
                }
            }
        });      
    }
    
    
    
     public DefaultTableModel showData(){
        ClienteService clienteService = new ClienteService();
        DefaultTableModel dtm = new DefaultTableModel();
        
        dtm.addColumn("Id");
        dtm.addColumn("Nombre");
        dtm.addColumn("Dirección");
        dtm.addColumn("Correo");
        dtm.addColumn("Rut");
        dtm.addColumn("Estado");
        dtm.addColumn("Rubro");
        
        String array = clienteService.getCliente();        
        JSONObject obj = new JSONObject(array);        
        Usuario u = new Usuario();
        JSONArray data = obj.getJSONArray("data");               
        for (int i = 0; i < data.length(); i++) {
                JSONObject row = data.getJSONObject(i);
                dtm.addRow(new Object[]{row.getInt("cliente_id"),row.getString("cliente_nombre"), row.get("cliente_direccion"), row.get("clienteCorreo"), row.get("cliente_rut"), row.getInt("cliente_activo"), row.getJSONObject("rubro").getString("rubro_nombre")});
        }
        
        return dtm;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroupEstadoInsert = new javax.swing.ButtonGroup();
        buttonGroupEstadoClienteEdit = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbSelectorRubroCliente = new javax.swing.JComboBox<Rubro>();
        txtNombreClienteInsert = new javax.swing.JTextField();
        txtRutClienteInsert = new javax.swing.JTextField();
        txtDireccionClienteInsert = new javax.swing.JTextField();
        radioActivoClienteInsert = new javax.swing.JRadioButton();
        radioInactivoInsertCliente = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtCorreoCliente = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombreClienteEdit = new javax.swing.JTextField();
        txtRutClienteEdit = new javax.swing.JTextField();
        txtDireccionClienteEdit = new javax.swing.JTextField();
        radioActivoClienteEdit = new javax.swing.JRadioButton();
        radioInactivoClienteEdit = new javax.swing.JRadioButton();
        cmbRubroClienteEdit = new javax.swing.JComboBox<Rubro>();
        jButton2 = new javax.swing.JButton();
        labelPrueba = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCorreoClienteEdit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setText("Mantendor Cliente");

        jButton3.setText("Cerrar Ventana");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(407, 407, 407)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableClientes);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Cliente"));

        jLabel2.setText("Nombre Cliente");

        jLabel3.setText("Rut Cliente");

        jLabel4.setText("Dirección Cliente");

        jLabel5.setText("Estado Cliente");

        jLabel6.setText("Rubro Cliente");

        cmbSelectorRubroCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cmbSelectorRubroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectorRubroClienteActionPerformed(evt);
            }
        });

        txtDireccionClienteInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionClienteInsertActionPerformed(evt);
            }
        });

        buttonGroupEstadoInsert.add(radioActivoClienteInsert);
        radioActivoClienteInsert.setText("Activo");

        buttonGroupEstadoInsert.add(radioInactivoInsertCliente);
        radioInactivoInsertCliente.setText("Inactivo");

        jButton1.setText("Guardar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Correo Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDireccionClienteInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel12))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombreClienteInsert)
                                        .addComponent(txtRutClienteInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(radioInactivoInsertCliente)
                                            .addComponent(cmbSelectorRubroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtCorreoCliente))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(radioActivoClienteInsert))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jButton1)))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreClienteInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRutClienteInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccionClienteInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(radioActivoClienteInsert)
                    .addComponent(radioInactivoInsertCliente))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbSelectorRubroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Cliente"));

        jLabel7.setText("Nombre Cliente");

        jLabel8.setText("Rut Cliente");

        jLabel9.setText("Dirección Cliente");

        jLabel10.setText("Estado Cliente");

        jLabel11.setText("Rubro Cliente");

        buttonGroupEstadoClienteEdit.add(radioActivoClienteEdit);
        radioActivoClienteEdit.setText("Activo");

        buttonGroupEstadoClienteEdit.add(radioInactivoClienteEdit);
        radioInactivoClienteEdit.setText("Inactivo");

        jButton2.setText("Editar Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        labelPrueba.setText("jLabel12");

        jLabel13.setText("Correo Cliente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(txtRutClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtDireccionClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel13))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCorreoClienteEdit)
                                            .addComponent(txtNombreClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(61, 61, 61)
                                .addComponent(labelPrueba))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(radioActivoClienteEdit)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioInactivoClienteEdit))
                                    .addComponent(cmbRubroClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jButton2)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNombreClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(labelPrueba)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCorreoClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRutClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDireccionClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(radioActivoClienteEdit)
                    .addComponent(radioInactivoClienteEdit))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbRubroClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionClienteInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionClienteInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionClienteInsertActionPerformed

    private void cmbSelectorRubroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectorRubroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSelectorRubroClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
        
        
        
        ClienteService cs = new ClienteService();
        
        String nombreCliente = txtNombreClienteInsert.getText();
        String direccionCliente = txtDireccionClienteInsert.getText();
        int activo = 0;
        if(radioActivoClienteInsert.isSelected()){
            activo = 1;
        }
        
        /**
         * Validaciones para los distintos campos
         */
        
        if(nombreCliente.trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Nombre de cliente no peude ser vacio");
            return;
        }else if(direccionCliente.trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Dirección de cliente no peude ser vacio");
            return;
        }else if(txtRutClienteInsert.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Rut de cliente no peude ser vacio");
            return;
        }else if(cmbSelectorRubroCliente.getSelectedIndex() == 0){
             JOptionPane.showMessageDialog(null, "Debe seleccionar un rubro para el cliente.");
            return;
        }
        
        
        Cliente cliente =  new Cliente();
        
        cliente.cliente_direccion = txtDireccionClienteInsert.getText();
        cliente.cliente_nombre = txtNombreClienteInsert.getText();
        cliente.cliente_activo = activo;
        cliente.rubro_id = cmbSelectorRubroCliente.getItemAt(cmbSelectorRubroCliente.getSelectedIndex()).getRubro_id();
        cliente.cliente_rut = txtRutClienteInsert.getText();
        cliente.clienteCorreo = txtCorreoCliente.getText();
        
        try {
            cs.postCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente insertado correctamente");    
            this.setVisible(false);
            MantenedorCliente m = new MantenedorCliente();
            
            m.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(MantenedorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        if(txtNombreClienteEdit.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Nombre de cliente no peude ser vacio");
            return;
        }
        
        if(txtDireccionClienteEdit.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Dirección de cliente no peude ser vacio");
            return;
        }
        if(txtRutClienteEdit.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Rut de cliente no peude ser vacio");
            return;
        }
        
        if(cmbRubroClienteEdit.getSelectedIndex() == 0){
             JOptionPane.showMessageDialog(null, "Debe seleccionar un rubro para el cliente.");
            return;
        }
        
        
        
        Cliente c = new Cliente();
        
        c.cliente_nombre = txtNombreClienteEdit.getText();
        c.cliente_rut = txtRutClienteEdit.getText();
        c.cliente_direccion = txtDireccionClienteEdit.getText();
        c.rubro_id  = cmbRubroClienteEdit.getItemAt(cmbRubroClienteEdit.getSelectedIndex()).getRubro_id();
        c.clienteCorreo = txtCorreoClienteEdit.getText();
        int activo = 0;
        if(radioActivoClienteEdit.isSelected()){
            activo = 1;
        }
        
        c.cliente_activo = activo;
        int cliente_id = Integer.parseInt(labelPrueba.getText());
        ClienteService cs = new ClienteService();
        try {
            cs.putCliente(c, cliente_id);            
            JOptionPane.showMessageDialog(null, "Cliente editado correctamente");   
            
            /*REFRESCA LA PAGINA*/
            this.setVisible(false);
            MantenedorCliente m = new MantenedorCliente();
            m.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(MantenedorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MantenedorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroupEstadoClienteEdit;
    private javax.swing.ButtonGroup buttonGroupEstadoInsert;
    private javax.swing.JComboBox<Rubro> cmbRubroClienteEdit;
    private javax.swing.JComboBox<Rubro> cmbSelectorRubroCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JLabel labelPrueba;
    private javax.swing.JRadioButton radioActivoClienteEdit;
    private javax.swing.JRadioButton radioActivoClienteInsert;
    private javax.swing.JRadioButton radioInactivoClienteEdit;
    private javax.swing.JRadioButton radioInactivoInsertCliente;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtCorreoClienteEdit;
    private javax.swing.JTextField txtDireccionClienteEdit;
    private javax.swing.JTextField txtDireccionClienteInsert;
    private javax.swing.JTextField txtNombreClienteEdit;
    private javax.swing.JTextField txtNombreClienteInsert;
    private javax.swing.JTextField txtRutClienteEdit;
    private javax.swing.JTextField txtRutClienteInsert;
    // End of variables declaration//GEN-END:variables
}
