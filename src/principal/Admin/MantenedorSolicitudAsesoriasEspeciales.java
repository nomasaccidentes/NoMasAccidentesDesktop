/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.Admin;

import api.AsesoriaEspecialService;
import api.AsesoriaService;
import api.NoMasAccidentesService;
import api.ProfesionalService;
import api.SolicitudAsesoriaEspecialService;
import api.SolicitudAsesoriaService;
import api.TipoAsesoriaEspecialService;
import api.TipoAsesoriaService;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author AlexF
 */
public class MantenedorSolicitudAsesoriasEspeciales extends javax.swing.JFrame {

    
    String contrato_id;
    String idAsesoriaEspecial;
    String nombreTipoAsesoria;
    /**
     * Creates new form MantenedorAsesoriasEspeciales
     */
    public MantenedorSolicitudAsesoriasEspeciales() {
        initComponents();
        cmbProfesional.setVisible(false);
        JtableSolicitudAsesoriaEspecial.setModel(this.showData());
        lblProfesionalCmb.setVisible(false);
        NoMasAccidentesService nmas = new NoMasAccidentesService();
        JSONArray array = nmas.getEstadoSolicitud();
        for (int i = 0; i < array.length(); i++) {
                JSONObject row = array.getJSONObject(i);
                cmdSolcitudEstadoAsesoria.addItem(
                        new EstadoSolicitudCombobox(row.getInt("ESTADO_SOLICITUD_ID"), row.getString("ESTADO_SOLICITUD_NOMBRE"))
                );
        }
        
        this.JtableSolicitudAsesoriaEspecial.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
               public void valueChanged(ListSelectionEvent event) {             
                idAsesoriaEspecial = JtableSolicitudAsesoriaEspecial.getValueAt(JtableSolicitudAsesoriaEspecial.getSelectedRow(), 0).toString();
                contrato_id = JtableSolicitudAsesoriaEspecial.getValueAt(JtableSolicitudAsesoriaEspecial.getSelectedRow(), 2).toString();
                String sol_estado = JtableSolicitudAsesoriaEspecial.getValueAt(JtableSolicitudAsesoriaEspecial.getSelectedRow(), 3).toString();
                nombreTipoAsesoria = JtableSolicitudAsesoriaEspecial.getValueAt(JtableSolicitudAsesoriaEspecial.getSelectedRow(), 7).toString();
                
                
                for (int i=0; i < cmdSolcitudEstadoAsesoria.getModel().getSize(); i++)
                {
                    if (cmdSolcitudEstadoAsesoria.getItemAt(i).toString().equals(sol_estado))
                    {
                        cmdSolcitudEstadoAsesoria.setSelectedIndex(i);
                        break;
                    }
                }
               }
           });  
         
            ProfesionalService ps = new ProfesionalService();
        
            JSONArray dataPro = ps.getProfesional();

            for (int j = 0; j < dataPro.length(); j++) {
                    JSONObject row = dataPro.getJSONObject(j);
                     cmbProfesional.addItem(
                            new ProfesionalCombobox(row.getInt("PROFESIONAL_ID"), row.getString("PROFESIONAL_NOMBRE"), row.getString("PROFESIONAL_APELLIDO"))
                    );
            }
        
            cmdSolcitudEstadoAsesoria.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent arg0) {
                    //Do Something

                    if(arg0.getItem().toString().equalsIgnoreCase("Aprobado")){
                        lblProfesionalCmb.setVisible(true);
                        cmbProfesional.setVisible(true);
                    }else{
                        lblProfesionalCmb.setVisible(false);
                        cmbProfesional.setVisible(false);
                    }
                }
            });
    }
    
      
      public DefaultTableModel showData(){
        SolicitudAsesoriaEspecialService asesoriaService = new SolicitudAsesoriaEspecialService();
        DefaultTableModel dtm = new DefaultTableModel();        
        
         dtm.addColumn("Solicitud Id");
        dtm.addColumn("Descripcion");
        dtm.addColumn("Contrato");
        dtm.addColumn("Estado Solicitud");
        dtm.addColumn("Fecha Tentativa");
        dtm.addColumn("Resolución");
        dtm.addColumn("Resolución Fecha");
        dtm.addColumn("Tipo Asesoria");
        
        String array = asesoriaService.getSolicitudAsesoriaEspecial();        
        JSONObject obj = new JSONObject(array);        
        Usuario u = new Usuario();
        JSONArray data = obj.getJSONArray("data");               
        for (int i = 0; i < data.length(); i++) {
                JSONObject row = data.getJSONObject(i);
                 dtm.addRow(new Object[]{
                    row.getInt("SOLICITUD_ASESORIA_ESP_ID"),
                    row.get("SOLICITUD_ASESORIA_ESP_DESC"),
                    row.getInt("CONTRATO_ID"),
                    row.get("ESTADO_SOLICITUD_NOMBRE"),
                    row.get("SOLICITUD_FECHA_ASESORIA"),
                    row.get("SOLICITUD_RESOLUCION"),
                    row.get("SOLICITUD_RESOLUCION_FECHA"),
                    row.get("TIPO_ASESORIA_ESPECIAL_NOMBRE")
                
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
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtableSolicitudAsesoriaEspecial = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaResolucionAsesoriaEspecial = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        dtpFechaAsesoriaEspecial = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmdSolcitudEstadoAsesoria = new javax.swing.JComboBox<EstadoSolicitudCombobox>();
        cmbProfesional = new javax.swing.JComboBox<ProfesionalCombobox>();
        lblProfesionalCmb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Asesorias Especiales");

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(465, 465, 465)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        JtableSolicitudAsesoriaEspecial.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JtableSolicitudAsesoriaEspecial);

        txaResolucionAsesoriaEspecial.setColumns(20);
        txaResolucionAsesoriaEspecial.setRows(5);
        jScrollPane2.setViewportView(txaResolucionAsesoriaEspecial);

        jLabel2.setText("Resolucion");

        jLabel3.setText("Fecha Asesoria");

        jLabel4.setText("Estado Asesoria");

        lblProfesionalCmb.setText("Profesional");

        jButton1.setText("Editar Solicitud");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(lblProfesionalCmb))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dtpFechaAsesoriaEspecial, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(cmdSolcitudEstadoAsesoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbProfesional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jButton1))))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dtpFechaAsesoriaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdSolcitudEstadoAsesoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProfesionalCmb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        SolicitudAsesoriaEspecial asesoria = new SolicitudAsesoriaEspecial();
        
        asesoria.solicitudResolucion = txaResolucionAsesoriaEspecial.getText();
        
        asesoria.estadoSolicitudId = cmdSolcitudEstadoAsesoria.getItemAt(cmdSolcitudEstadoAsesoria.getSelectedIndex()).getESTADO_SOLICITUD_ID();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateString = dateFormat.format(dtpFechaAsesoriaEspecial.getDate());
        
        
        asesoria.solicitudResolucionFecha = startDateString;
        
        int id = Integer.parseInt(idAsesoriaEspecial);
        
        SolicitudAsesoriaEspecialService asesoriaService =new SolicitudAsesoriaEspecialService();
        
        
        try {
            
            
            if(asesoria.estadoSolicitudId == 2){
                 AsesoriaEspecialService as = new AsesoriaEspecialService();
                
                
                AsesoriaEspecial a  = new AsesoriaEspecial();
                
                a.asesoriaEspecialNombre = txaResolucionAsesoriaEspecial.getText();
                a.asesoriaEspecialFecha = startDateString;
                a.contratoId = Integer.parseInt(contrato_id);
                a.profesionalId =  cmbProfesional.getItemAt(cmbProfesional.getSelectedIndex()).profesional_id;
                TipoAsesoriaEspecialService asesoriaEspecialService =  new TipoAsesoriaEspecialService();
                
                TipoAsesoriaEspecial  ta  = new TipoAsesoriaEspecial();
                ta.tipoAsesoriaEspecialNombre = nombreTipoAsesoria;
                String datos = asesoriaEspecialService.getTipoAsesoriaByNombre(ta);
                System.out.println(nombreTipoAsesoria);
                System.out.println(datos);
                JSONObject jsono = new JSONObject(datos);
                a.tipoAsesoriaEspecialId = jsono.getJSONObject("data").getInt("TIPO_ASESORIA_ESPECIAL_ID");
                
                 try {
                    as.postAsesoria(a);    
                    JOptionPane.showMessageDialog(null, "Asesoria Ingresada Correctamente");
                } catch (Exception e) {
                    Logger.getLogger(MantenedorSolicitudAsesoria.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            asesoriaService.putSolicitudAsesoria(asesoria, id);
            JOptionPane.showMessageDialog(null, "Solicitud Asesoria Especial Modificada");
            this.setVisible(false);
            MantenedorSolicitudAsesoriasEspeciales msae = new MantenedorSolicitudAsesoriasEspeciales();
            
            msae.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(MantenedorSolicitudAsesoriasEspeciales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MantenedorSolicitudAsesoriasEspeciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorSolicitudAsesoriasEspeciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorSolicitudAsesoriasEspeciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorSolicitudAsesoriasEspeciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorSolicitudAsesoriasEspeciales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtableSolicitudAsesoriaEspecial;
    private javax.swing.JComboBox<ProfesionalCombobox> cmbProfesional;
    private javax.swing.JComboBox<EstadoSolicitudCombobox> cmdSolcitudEstadoAsesoria;
    private com.toedter.calendar.JDateChooser dtpFechaAsesoriaEspecial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblProfesionalCmb;
    private javax.swing.JTextArea txaResolucionAsesoriaEspecial;
    // End of variables declaration//GEN-END:variables
}
