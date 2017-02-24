/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.view;

import afpa.ecf.physicalregatta.model.Owner;
import afpa.ecf.physicalregatta.model.Sailboat;
import afpa.ecf.physicalregatta.model.Sbclass;
import afpa.ecf.physicalregatta.model.Serie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author gwenole
 */
public class SailboatRegister extends javax.swing.JFrame implements TxtUpdate.Listener {

    private static final String PERSISTENCE_UNIT_NAME = "PhysicalRegattaPU";
    private static EntityManagerFactory factory;

    private final ComboBoxModel<Owner> cboOwnerModel;
    private final ComboBoxModel<Serie> cboSerieModel;
    private final ComboBoxModel<Sbclass> cboClassModel;

    /**
     * Creates new form SailboatRegister
     */
    public SailboatRegister() {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query qOwner = em.createNamedQuery("Owner.findAll");
        Query qSerie = em.createNamedQuery("Serie.findAll");
        Query qSbclass = em.createNamedQuery("Sbclass.findAll");

        List<Owner> owners = qOwner.getResultList();
        List<Serie> series = qSerie.getResultList();
        List<Sbclass> sailboatClass = qSbclass.getResultList();

        cboOwnerModel = new DefaultComboBoxModel(owners.toArray());
        cboSerieModel = new DefaultComboBoxModel(series.toArray());
        cboClassModel = new DefaultComboBoxModel(filterClassBy(sailboatClass, series.get(0)));

        initComponents();

        super.setLocationRelativeTo(null);

        checkDatas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panFooter = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtInfo = new javax.swing.JTextField();
        panContent = new javax.swing.JPanel();
        lblSail = new javax.swing.JLabel();
        txtSail = new javax.swing.JTextField();
        lblOwner = new javax.swing.JLabel();
        cboOwner = new javax.swing.JComboBox<>();
        lblSerie = new javax.swing.JLabel();
        cboSerie = new javax.swing.JComboBox<>();
        lblClass = new javax.swing.JLabel();
        cboClass = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter un voilier");
        setAutoRequestFocus(false);
        setMaximumSize(new java.awt.Dimension(540, 230));
        setMinimumSize(new java.awt.Dimension(540, 230));
        setPreferredSize(new java.awt.Dimension(540, 230));
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        panFooter.setLayout(new java.awt.BorderLayout(10, 10));

        btnClose.setText("Fermer");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        panFooter.add(btnClose, java.awt.BorderLayout.CENTER);

        btnAdd.setText("Ajouter");
        btnAdd.setToolTipText("Veuillez saisir un numéro de voile");
        btnAdd.setEnabled(false);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        panFooter.add(btnAdd, java.awt.BorderLayout.LINE_END);

        txtInfo.setEditable(false);
        txtInfo.setToolTipText("");
        txtInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtInfo.setPreferredSize(new java.awt.Dimension(505, 23));
        panFooter.add(txtInfo, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panFooter, java.awt.BorderLayout.PAGE_END);

        panContent.setBorder(javax.swing.BorderFactory.createTitledBorder("Saisissez les informations ci-dessous"));
        panContent.setMinimumSize(new java.awt.Dimension(536, 62));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        panContent.setLayout(flowLayout1);

        lblSail.setText("Numéro de voile");
        lblSail.setMaximumSize(new java.awt.Dimension(150, 15));
        lblSail.setMinimumSize(new java.awt.Dimension(150, 15));
        lblSail.setPreferredSize(new java.awt.Dimension(150, 15));
        panContent.add(lblSail);

        txtSail.setToolTipText("Veuillez saisir un numéro de voile");
        txtSail.setPreferredSize(new java.awt.Dimension(350, 23));
        txtSail.getDocument().addDocumentListener(new TxtUpdate(this));
        panContent.add(txtSail);

        lblOwner.setText("Propriétaire");
        lblOwner.setMaximumSize(new java.awt.Dimension(150, 15));
        lblOwner.setMinimumSize(new java.awt.Dimension(150, 15));
        lblOwner.setPreferredSize(new java.awt.Dimension(150, 15));
        panContent.add(lblOwner);

        cboOwner.setModel(cboOwnerModel);
        cboOwner.setToolTipText("Veuillez sélectionner un propriétaire");
        cboOwner.setPreferredSize(new java.awt.Dimension(350, 25));
        cboOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboOwnerActionPerformed(evt);
            }
        });
        panContent.add(cboOwner);

        lblSerie.setText("Série");
        lblSerie.setMaximumSize(new java.awt.Dimension(150, 15));
        lblSerie.setMinimumSize(new java.awt.Dimension(150, 15));
        lblSerie.setPreferredSize(new java.awt.Dimension(150, 15));
        panContent.add(lblSerie);

        cboSerie.setModel(cboSerieModel);
        cboSerie.setToolTipText("Veuillez sélectionner une série");
        cboSerie.setPreferredSize(new java.awt.Dimension(350, 25));
        cboSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSerieActionPerformed(evt);
            }
        });
        panContent.add(cboSerie);

        lblClass.setText("Classe");
        lblClass.setMaximumSize(new java.awt.Dimension(150, 15));
        lblClass.setMinimumSize(new java.awt.Dimension(150, 15));
        lblClass.setPreferredSize(new java.awt.Dimension(150, 15));
        panContent.add(lblClass);

        cboClass.setModel(cboClassModel);
        cboClass.setToolTipText("Veuillez sélectionner une classe");
        cboClass.setPreferredSize(new java.awt.Dimension(350, 25));
        cboClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClassActionPerformed(evt);
            }
        });
        panContent.add(cboClass);

        getContentPane().add(panContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if (!checkDatas()) {
            return;
        }
        
        Sailboat s = new Sailboat(null, Integer.parseInt(txtSail.getText()));
        s.setOwnerId((Owner) cboOwnerModel.getSelectedItem());
        s.setClassId((Sbclass) cboClassModel.getSelectedItem());
        
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();   
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnAddMouseClicked

    private void cboOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOwnerActionPerformed
        checkDatas();
    }//GEN-LAST:event_cboOwnerActionPerformed

    private void cboSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSerieActionPerformed
        checkDatas();
    }//GEN-LAST:event_cboSerieActionPerformed

    private void cboClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClassActionPerformed
        checkDatas();
    }//GEN-LAST:event_cboClassActionPerformed

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
            java.util.logging.Logger.getLogger(SailboatRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SailboatRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SailboatRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SailboatRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SailboatRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox<Sbclass> cboClass;
    private javax.swing.JComboBox<Owner> cboOwner;
    private javax.swing.JComboBox<Serie> cboSerie;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblOwner;
    private javax.swing.JLabel lblSail;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JPanel panContent;
    private javax.swing.JPanel panFooter;
    private javax.swing.JTextField txtInfo;
    private javax.swing.JTextField txtSail;
    // End of variables declaration//GEN-END:variables

    private Sbclass[] filterClassBy(List<Sbclass> sailboatClass, Serie serie) {
        List<Sbclass> sbclass = new ArrayList<>();
        for (Sbclass c : sailboatClass) {
            if (c.getSerieId().getId().equals(serie.getId())) {
                sbclass.add(c);
            }
        }
        return Arrays.copyOf(sbclass.toArray(), sbclass.size(), Sbclass[].class);
    }

    @Override
    public void txtEdited() {
        checkDatas();
    }

    private boolean checkDatas() {
        String txt = txtSail.getText();
        if (txt.isEmpty()) {
            updateInfo("Veuillez saisir un numéro de voile");
            return false;
        }
        Integer sail = Integer.parseInt(txt);
        if (sail.equals(0)) {
            updateInfo("Veuillez saisir un numéro de voile supérieur à 0");
            return false;
        }
        if (cboOwner.getItemCount() == 0) {
            updateInfo("/!\\ Aucun propriétaire, pensez à en ajouter un sur la page prévue à cet effet !");
            return false;
        }
        if (cboSerie.getItemCount() == 0) {
            updateInfo("/!\\ Aucune série, pensez à en ajouter une sur la page prévue à cet effet !");
            return false;
        }
        if (cboClass.getItemCount() == 0) {
            updateInfo("/!\\ Aucune classe, pensez à en ajouter une sur la page prévue à cet effet !");
            return false;
        }
        if (cboOwner.getSelectedIndex() == -1) {
            updateInfo("Veuillez sélectionner un propriétaire");
            return false;
        }
        if (cboSerie.getSelectedIndex() == -1) {
            updateInfo("Veuillez sélectionner une série");
            return false;
        }
        if (cboClass.getSelectedIndex() == -1) {
            updateInfo("Veuillez sélectionner une classe");
            return false;
        }
        updateInfo("");
        return true;
    }

    private void updateInfo(String s) {
        if (s.isEmpty()) {
            btnAdd.setEnabled(true);
        } else {
            btnAdd.setEnabled(false);
        }
        txtInfo.setText(s);
        btnAdd.setToolTipText(s);
    }

}
