/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.Profesional;

import principal.Admin.*;
import api.CapacitacionService;
import api.ContratoService;
import api.NoMasAccidentesService;
import api.ProfesionalService;
import api.SolicitudAsesoriaService;
import api.SolicitudCapacitacionService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.Capacitacion;
import models.EstadoSolicitudCombobox;
import models.ProfesionalCombobox;
import models.SolicitudCapacitacion;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author AlexF
 */
public class MantenedorSolicitudCapacitacion extends javax.swing.JFrame {

    /**
     * Creates new form MantenedorSolicitudCapacitacion
     */
    public MantenedorSolicitudCapacitacion() {
        initComponents();
        
        cmbProfesional.setVisible(false);
        lblProfesional.setVisible(false);
        
        lblContratoId.setVisible(false);
        lblIdSolicitudCapacitacion.setVisible(false);
        jtableSolicitudCapacitacion.setModel(showData());
           NoMasAccidentesService nmas = new NoMasAccidentesService();
        
        JSONArray array = nmas.getEstadoSolicitud();
         ArrayList arr = new ArrayList();
          cmbEstadoSolicitudCapacitacion.addItem(
                        new EstadoSolicitudCombobox(0, "Seleccione")
                );
        for (int i = 0; i < array.length(); i++) {
                JSONObject row = array.getJSONObject(i);
                cmbEstadoSolicitudCapacitacion.addItem(
                        new EstadoSolicitudCombobox(row.getInt("ESTADO_SOLICITUD_ID"), row.getString("ESTADO_SOLICITUD_NOMBRE"))
                );
        }
        
         ProfesionalService ps = new ProfesionalService();
        
        JSONArray dataPro = ps.getProfesional();
        
        for (int j = 0; j < dataPro.length(); j++) {
                JSONObject row = dataPro.getJSONObject(j);
                 cmbProfesional.addItem(
                        new ProfesionalCombobox(row.getInt("PROFESIONAL_ID"), row.getString("PROFESIONAL_NOMBRE"), row.getString("PROFESIONAL_APELLIDO"))
                );
        }
        
          System.out.println(cmbEstadoSolicitudCapacitacion.getItemAt(cmbEstadoSolicitudCapacitacion.getSelectedIndex()).ESTADO_SOLICITUD_ID);
          
//          cmbEstadoSolicitudCapacitacion.getItemListeners(new ListSelectionEvent(ps, WIDTH, WIDTH, rootPaneCheckingEnabled))
          
          cmbEstadoSolicitudCapacitacion.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            //Do Something
            
            if(arg0.getItem().toString().equalsIgnoreCase("Aprobado")){
                lblProfesional.setVisible(true);
                cmbProfesional.setVisible(true);
            }else{
                lblProfesional.setVisible(false);
                cmbProfesional.setVisible(false);
            }
        }
    });
      
         this.jtableSolicitudCapacitacion.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
               public void valueChanged(ListSelectionEvent event) {             
                String p_id = jtableSolicitudCapacitacion.getValueAt(jtableSolicitudCapacitacion.getSelectedRow(), 0).toString();
                String contrato_id = jtableSolicitudCapacitacion.getValueAt(jtableSolicitudCapacitacion.getSelectedRow(), 2).toString();
                String sol_estado = jtableSolicitudCapacitacion.getValueAt(jtableSolicitudCapacitacion.getSelectedRow(), 3).toString();
                
                lblIdSolicitudCapacitacion.setText(p_id);
                lblContratoId.setText(contrato_id);
                for (int i=0; i < cmbEstadoSolicitudCapacitacion.getModel().getSize(); i++)
                {
                    if (cmbEstadoSolicitudCapacitacion.getItemAt(i).toString().equals(sol_estado))
                    {
                        
                        if(i == 2){
                            lblProfesional.setVisible(true);
                            cmbProfesional.setVisible(true);
                        }else{
                            lblProfesional.setVisible(false);
                            cmbProfesional.setVisible(false);
                        }
                        cmbEstadoSolicitudCapacitacion.setSelectedIndex(i);
                        break;
                    }
                }
               }
           });      
    }
    
    
    public DefaultTableModel showData(){
        SolicitudCapacitacionService capacitacionService = new SolicitudCapacitacionService();
        DefaultTableModel dtm = new DefaultTableModel();        
        JSONArray array = capacitacionService.getSolicitudAsesoria();
        
          
        dtm.addColumn("Solicitud Id");
        dtm.addColumn("Descripcion");
        dtm.addColumn("Contrato");
        dtm.addColumn("Estado Solicitud");
        dtm.addColumn("Fecha Tentativa");
        dtm.addColumn("Resolución");
        dtm.addColumn("Resolución Fecha");
        
        for (int i = 0; i < array.length(); i++) {
                JSONObject row = array.getJSONObject(i);
                
                dtm.addRow(new Object[]{
                    row.getInt("SOLICITUD_CAPACITACION_ID"),
                    row.get("SOLICITUD_CAPACITACION_DESC"),
                    row.getInt("CONTRATO_ID"),
                    row.get("ESTADO_SOLICITUD_NOMBRE"),
                    row.get("SOLICITUD_FECHA_CAPACITACION"),
                    row.get("SOLICITUD_RESOLUCION"),
                    row.get("SOLICITUD_RESOLUCION_FECHA")
                
                });
                
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableSolicitudCapacitacion = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaResolucionDescripcion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dtpFechaCapacitacion = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cmbEstadoSolicitudCapacitacion = new javax.swing.JComboBox<EstadoSolicitudCombobox>();
        jButton2 = new javax.swing.JButton();
        lblIdSolicitudCapacitacion = new javax.swing.JLabel();
        lblProfesional = new javax.swing.JLabel();
        cmbProfesional = new javax.swing.JComboBox<ProfesionalCombobox>();
        lblContratoId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setText("Solicitudes Capacitacion");

        jButton1.setText("Cerrar Ventana");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(473, 473, 473)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jtableSolicitudCapacitacion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtableSolicitudCapacitacion);

        txaResolucionDescripcion.setColumns(20);
        txaResolucionDescripcion.setRows(5);
        jScrollPane2.setViewportView(txaResolucionDescripcion);

        jLabel2.setText("Resolucion");

        jLabel3.setText("Fecha Capacitación");

        jLabel4.setText("Estado Solicitud");

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblIdSolicitudCapacitacion.setText("jLabel5");

        lblProfesional.setText("Profesional Asignado");

        lblContratoId.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(431, 431, 431)
                                .addComponent(lblContratoId))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(lblProfesional))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2)
                                    .addComponent(dtpFechaCapacitacion, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(cmbEstadoSolicitudCapacitacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbProfesional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 198, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblIdSolicitudCapacitacion)
                                .addGap(131, 131, 131)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dtpFechaCapacitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(lblIdSolicitudCapacitacion))
                                .addGap(27, 27, 27))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblContratoId)
                                .addGap(39, 39, 39)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cmbEstadoSolicitudCapacitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblProfesional)
                                    .addComponent(cmbProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(120, 120, 120))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        
        SolicitudCapacitacion sc = new SolicitudCapacitacion();
        
        sc.estadoSolicitudId = cmbEstadoSolicitudCapacitacion.getItemAt(cmbEstadoSolicitudCapacitacion.getSelectedIndex()).getESTADO_SOLICITUD_ID();
        
        sc.solicitudResolucion = txaResolucionDescripcion.getText();
        
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateString = dateFormat.format(dtpFechaCapacitacion.getDate());
        sc.solicitudResolucionFecha = startDateString;
        
        
        
        
        SolicitudCapacitacionService scs = new SolicitudCapacitacionService();
        
        try {
            
            if(sc.estadoSolicitudId == 2){
                Capacitacion c = new Capacitacion();

                c.capacitacionFecha = startDateString;

                c.capacitacionDetalle = txaResolucionDescripcion.getText();

                c.contrato_id = Integer.parseInt(lblContratoId.getText());

                c.profesionalId = cmbProfesional.getItemAt(cmbProfesional.getSelectedIndex()).profesional_id;
                
                System.out.println(c.toString());
                CapacitacionService cs = new CapacitacionService();
                try {
                    cs.postCapacitacion(c);
                    JOptionPane.showMessageDialog(null, "Capacitación Agregada Correctamente");
                } catch (Exception ex) {
                    Logger.getLogger(MantenedorSolicitudCapacitacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            scs.putSolicitudAsesoria(sc, Integer.parseInt(lblIdSolicitudCapacitacion.getText()));
            
            JOptionPane.showMessageDialog(null, "Solicitud Modificada Con Éxito");
            
            this.setVisible(false);
            
            MantenedorSolicitudCapacitacion capacitacion = new MantenedorSolicitudCapacitacion();
            capacitacion.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(MantenedorSolicitudCapacitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MantenedorSolicitudCapacitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorSolicitudCapacitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorSolicitudCapacitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorSolicitudCapacitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorSolicitudCapacitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<EstadoSolicitudCombobox> cmbEstadoSolicitudCapacitacion;
    private javax.swing.JComboBox<ProfesionalCombobox> cmbProfesional;
    private com.toedter.calendar.JDateChooser dtpFechaCapacitacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtableSolicitudCapacitacion;
    private javax.swing.JLabel lblContratoId;
    private javax.swing.JLabel lblIdSolicitudCapacitacion;
    private javax.swing.JLabel lblProfesional;
    private javax.swing.JTextArea txaResolucionDescripcion;
    // End of variables declaration//GEN-END:variables
}
