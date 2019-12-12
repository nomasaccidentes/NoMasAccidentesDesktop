/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.Admin;

import api.AsesoriaService;
import api.ClienteService;
import api.NoMasAccidentesService;
import api.ProfesionalService;
import api.RubroService;
import api.SolicitudAsesoriaService;
import api.TipoAsesoriaService;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.Asesoria;
import models.EstadoSolicitudCombobox;
import models.ProfesionalCombobox;
import models.Rubro;
import models.SolicitudAsesoria;
import models.TipoAsesoria;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author AlexF
 */
public class MantenedorSolicitudAsesoria extends javax.swing.JFrame {

    String nombreTipoAsesoria;
    
    String contratoIdEnvio;
    String descripcion ; 
    /**
     * Creates new form MantenedorSolicitudAsesoria
     */
    public MantenedorSolicitudAsesoria() {
        initComponents();
        lblContratoIdAsesoria.setVisible(false);
        lblEditaSolicitudAsesoria.setVisible(false);
        jTableSolicitudAsesoria.setModel(showData());
        NoMasAccidentesService nmas = new NoMasAccidentesService();
        cmbProfesional.setVisible(false);
        lblNombreProfesional.setVisible(false);
        JSONArray array = nmas.getEstadoSolicitud();
        ArrayList arr = new ArrayList();
          cmbEstadoSolicitud.addItem(
                        new EstadoSolicitudCombobox(0, "Seleccione")
                );
        for (int i = 0; i < array.length(); i++) {
                JSONObject row = array.getJSONObject(i);
                cmbEstadoSolicitud.addItem(
                        new EstadoSolicitudCombobox(row.getInt("ESTADO_SOLICITUD_ID"), row.getString("ESTADO_SOLICITUD_NOMBRE"))
                );
        }
        
      
         this.jTableSolicitudAsesoria.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
               public void valueChanged(ListSelectionEvent event) {             
                String p_id = jTableSolicitudAsesoria.getValueAt(jTableSolicitudAsesoria.getSelectedRow(), 0).toString();
                descripcion = jTableSolicitudAsesoria.getValueAt(jTableSolicitudAsesoria.getSelectedRow(), 1).toString();
                String contrato_id = jTableSolicitudAsesoria.getValueAt(jTableSolicitudAsesoria.getSelectedRow(), 2).toString();
                String sol_estado = jTableSolicitudAsesoria.getValueAt(jTableSolicitudAsesoria.getSelectedRow(), 3).toString();
                nombreTipoAsesoria = jTableSolicitudAsesoria.getValueAt(jTableSolicitudAsesoria.getSelectedRow(), 7).toString();
                contratoIdEnvio = contrato_id;
                lblContratoIdAsesoria.setText(contrato_id);
                lblEditaSolicitudAsesoria.setText(p_id);
                for (int i=0; i < cmbEstadoSolicitud.getModel().getSize(); i++)
                {
                    if (cmbEstadoSolicitud.getItemAt(i).toString().equals(sol_estado))
                    {
                        cmbEstadoSolicitud.setSelectedIndex(i);
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
        
            cmbEstadoSolicitud.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent arg0) {
                    //Do Something

                    if(arg0.getItem().toString().equalsIgnoreCase("Aprobado")){
                        lblNombreProfesional.setVisible(true);
                        cmbProfesional.setVisible(true);
                    }else{
                        lblNombreProfesional.setVisible(false);
                        cmbProfesional.setVisible(false);
                    }
                }
            });
    }
    
    
    public DefaultTableModel showData(){
        SolicitudAsesoriaService asesoriaService = new SolicitudAsesoriaService();
        DefaultTableModel dtm = new DefaultTableModel();        
        JSONArray array = asesoriaService.getSolicitudAsesoria();
        
          
        dtm.addColumn("Solicitud Id");
        dtm.addColumn("Descripcion");
        dtm.addColumn("Contrato");
        dtm.addColumn("Estado Solicitud");
        dtm.addColumn("Fecha Tentativa");
        dtm.addColumn("Resolución");
        dtm.addColumn("Resolución Fecha");
        dtm.addColumn("Tipo Asesoria");
        
        for (int i = 0; i < array.length(); i++) {
                JSONObject row = array.getJSONObject(i);
                
                dtm.addRow(new Object[]{
                    row.getInt("SOLICITUD_ASESORIA_ID"),
                    row.get("SOLICITUD_ASESORIA_DESCRIPCION"),
                    row.getInt("CONTRATO_ID"),
                    row.get("ESTADO_SOLICITUD_NOMBRE"),
                    row.get("SOLICITUD_FECHA_ASESORIA"),
                    row.get("SOLICITUD_RESOLUCION"),
                    row.get("SOLICITUD_RESOLUCION_FECHA"),
                    row.get("TIPO_ASESORIA_NOMBRE")
                
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSolicitudAsesoria = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionResolucion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dtpFechaAsesoria = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cmbEstadoSolicitud = new javax.swing.JComboBox<EstadoSolicitudCombobox>();
        jButton2 = new javax.swing.JButton();
        lblEditaSolicitudAsesoria = new javax.swing.JLabel();
        lblContratoIdAsesoria = new javax.swing.JLabel();
        cmbProfesional = new javax.swing.JComboBox<ProfesionalCombobox>();
        lblNombreProfesional = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableSolicitudAsesoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Solicitud ID", "Descripción", "Estado", "Fecha Solicitada", "Resolución", "Contrato id"
            }
        ));
        jScrollPane1.setViewportView(jTableSolicitudAsesoria);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.setToolTipText("");

        jLabel1.setText("Solicitud Asesorias");

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
                .addGap(477, 477, 477)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        txtDescripcionResolucion.setColumns(20);
        txtDescripcionResolucion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionResolucion);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Resolución");

        jLabel3.setText("Descripción Resolución");

        jLabel4.setText("Fecha Asesoría");

        jLabel5.setText("Estado");

        cmbEstadoSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoSolicitudActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblEditaSolicitudAsesoria.setText("jLabel6");

        lblContratoIdAsesoria.setText("jLabel6");

        lblNombreProfesional.setText("Profesional");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(116, 116, 116)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(lblNombreProfesional))
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dtpFechaAsesoria, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                            .addComponent(cmbEstadoSolicitud, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbProfesional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEditaSolicitudAsesoria)
                                .addGap(101, 101, 101))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblContratoIdAsesoria)
                                .addGap(460, 460, 460)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(263, 263, 263))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblEditaSolicitudAsesoria))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cmbEstadoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombreProfesional)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblContratoIdAsesoria)
                        .addGap(32, 32, 32)
                        .addComponent(dtpFechaAsesoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(79, 79, 79))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEstadoSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoSolicitudActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        SolicitudAsesoria asesoria = new SolicitudAsesoria();
        
        asesoria.solicitudResolucion = txtDescripcionResolucion.getText();
        
        asesoria.estadoSolicitudId = cmbEstadoSolicitud.getItemAt(cmbEstadoSolicitud.getSelectedIndex()).getESTADO_SOLICITUD_ID();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateString = dateFormat.format(dtpFechaAsesoria.getDate());
        
        
        asesoria.solicitudResolucionFecha = startDateString;
        
        int id = Integer.parseInt(lblEditaSolicitudAsesoria.getText());
        
        SolicitudAsesoriaService asesoriaService =new SolicitudAsesoriaService();
        
        try {
            
            
            if(asesoria.estadoSolicitudId == 2){
                AsesoriaService as = new AsesoriaService();
                
                
                Asesoria a  = new Asesoria();
                
                a.asesoriaDetalle = txtDescripcionResolucion.getText();
                a.asesoriaFecha = startDateString;
                a.contratoId = Integer.parseInt(lblContratoIdAsesoria.getText());
                a.profesionalId =  cmbProfesional.getItemAt(cmbProfesional.getSelectedIndex()).profesional_id;
                TipoAsesoriaService tipoAsesoriaService =  new TipoAsesoriaService();
                
                TipoAsesoria  ta  = new TipoAsesoria();
                ta.tipoAsesoriaNombre = nombreTipoAsesoria;
                String datos = tipoAsesoriaService.getTipoAsesoriaByNombre(ta);
                System.out.println(nombreTipoAsesoria);
                System.out.println(datos);
                JSONObject jsono = new JSONObject(datos);
                a.tipoAsesoriaId = jsono.getJSONObject("data").getInt("TIPO_ASESORIA_ID");
                
                
                try {
                    as.postAsesoria(a);    
                    JOptionPane.showMessageDialog(null, "Asesoria Ingresada Correctamente");
                } catch (Exception e) {
                    Logger.getLogger(MantenedorSolicitudAsesoria.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            asesoriaService.putSolicitudAsesoria(asesoria, id);
            enviaCorreoConAdjunto(Integer.parseInt(contratoIdEnvio), descripcion);
            JOptionPane.showMessageDialog(null, "Solicitud Aprobada");
            
            this.setVisible(false);
            
            MantenedorSolicitudAsesoria  msa = new MantenedorSolicitudAsesoria();
            
            msa.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(MantenedorSolicitudAsesoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
     public void enviaCorreoConAdjunto(int contratoId, String nombre) throws MessagingException{
        
        
        
        ClienteService clienteService = new ClienteService();
        
        String correo = clienteService.getClientebyContratoId(contratoId);
        JSONObject objTipoAsesoria = new JSONObject(correo);        
       
        String clienteCorreo = objTipoAsesoria.getJSONObject("data").getString("CLIENTE_CORREO");     
        
         System.out.println(clienteCorreo);
         
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "nomasaccidentess@gmail.com");
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);
         // Se compone la parte del texto
        BodyPart texto = new MimeBodyPart();
        texto.setText("Felicidades Tu Asesoria llamada: " + nombre + " ha sido aprobada exitosamente!!");

        // Se compone el adjunto con la imagen
//        BodyPart adjunto = new MimeBodyPart();
//        adjunto.setDataHandler(
//            new DataHandler(new FileDataSource(ruta)));
//        adjunto.setFileName(nombre+".pdf");

        // Una MultiParte para agrupar texto e imagen.
        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);
//        multiParte.addBodyPart(adjunto);

        // Se compone el correo, dando to, from, subject y el
        // contenido.
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(clienteCorreo));
        message.addRecipient(
            Message.RecipientType.TO,
            new InternetAddress(clienteCorreo));
        message.setSubject("Solicitud Asesoria Aprobada");
        message.setContent(multiParte);

        // Se envia el correo.
        Transport t = session.getTransport("smtp");
        t.connect("nomasaccidentess@gmail.com", "fwhbskbqvucomxzb");
        t.sendMessage(message, message.getAllRecipients());
        t.close();
        JOptionPane.showMessageDialog(null, "Correo enviado a cliente");
    }
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
            java.util.logging.Logger.getLogger(MantenedorSolicitudAsesoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorSolicitudAsesoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorSolicitudAsesoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorSolicitudAsesoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorSolicitudAsesoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<EstadoSolicitudCombobox> cmbEstadoSolicitud;
    private javax.swing.JComboBox<ProfesionalCombobox> cmbProfesional;
    private com.toedter.calendar.JDateChooser dtpFechaAsesoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSolicitudAsesoria;
    private javax.swing.JLabel lblContratoIdAsesoria;
    private javax.swing.JLabel lblEditaSolicitudAsesoria;
    private javax.swing.JLabel lblNombreProfesional;
    private javax.swing.JTextArea txtDescripcionResolucion;
    // End of variables declaration//GEN-END:variables
}
