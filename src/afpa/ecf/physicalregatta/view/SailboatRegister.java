/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.view;

import afpa.ecf.algo.Algo;
import afpa.ecf.physicalregatta.Utils;
import afpa.ecf.physicalregatta.model.Club;
import afpa.ecf.physicalregatta.model.Owner;
import afpa.ecf.physicalregatta.model.Person;
import afpa.ecf.physicalregatta.model.Sailboat;
import afpa.ecf.physicalregatta.model.Sbclass;
import afpa.ecf.physicalregatta.model.Serie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author gwenole
 */
public class SailboatRegister extends javax.swing.JFrame implements TxtUpdate.Listener {

    // Objet d'information et de saisie
    Owner newOwner;
    Owner selectOwner;
    Serie selectSerie;
    Sbclass selectSbclass;
    Club selectClub;

    // Model des ComboBox
    private ComboBoxModel<Owner> cboOwnerModel;
    private final ComboBoxModel<Serie> cboSerieModel;
    private ComboBoxModel<Sbclass> cboClassModel;
    private final ComboBoxModel<Club> cboClubModel;

    // Liste des classes complète
    List<Sbclass> sailboatClass;

    /**
     * Creates new form SailboatRegister
     */
    public SailboatRegister() {

        // Initialisation de la persistance
        EntityManager em = Utils.getEntityManager();

        // Peuplement des données
        Query qOwner = em.createNamedQuery("Owner.findAll");
        Query qSerie = em.createNamedQuery("Serie.findAll");
        Query qSbclass = em.createNamedQuery("Sbclass.findAll");
        Query qClub = em.createNamedQuery("Club.findAll");

        List<Owner> owners = qOwner.getResultList();
        List<Serie> series = qSerie.getResultList();
        List<Club> clubs = qClub.getResultList();
        sailboatClass = qSbclass.getResultList();

        newOwner = new Owner(-2);
        Person emptyPers = new Person(-1, "Saisir un nouveau", "propriétaire", null, null);
        newOwner.setPersonId(emptyPers);
        
        selectOwner = new Owner(-1);
        emptyPers = new Person(-1, "Sélectionner un", "propriétaire", null, null);
        selectOwner.setPersonId(emptyPers);
        
        owners.add(0, selectOwner);
        owners.add(newOwner);
        
        selectSerie = new Serie(-1, "Sélectionner une série");
        series.add(0, selectSerie);
        
        selectSbclass = new Sbclass(-1, "Sélectionner une classe");
        sailboatClass.add(0, selectSbclass);
        
        selectClub = new Club(-1, "Sélectionner un club");
        clubs.add(0, selectClub);
                
        cboOwnerModel = new DefaultComboBoxModel(owners.toArray());
        cboSerieModel = new DefaultComboBoxModel(series.toArray());
        cboClassModel = new DefaultComboBoxModel(filterClassBy(sailboatClass, series.get(0)));
        cboClubModel = new DefaultComboBoxModel(clubs.toArray());

        initComponents();

        panOwner.setVisible(false);
        super.setLocationRelativeTo(null);

        // Vérifications des données
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
        panOwner = new javax.swing.JPanel();
        lblFirstname = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        lblLastname = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblClub = new javax.swing.JLabel();
        cboClub = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        btnAddOwner = new javax.swing.JButton();
        panSail = new javax.swing.JPanel();
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
        setMaximumSize(new java.awt.Dimension(600, 550));
        setMinimumSize(new java.awt.Dimension(540, 230));
        setPreferredSize(new java.awt.Dimension(600, 320));
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        panFooter.setLayout(new java.awt.BorderLayout(10, 10));

        btnClose.setText("Fermer");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
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
        panContent.setPreferredSize(new java.awt.Dimension(1045, 250));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        panContent.setLayout(flowLayout1);

        panOwner.setMinimumSize(new java.awt.Dimension(200, 200));
        panOwner.setPreferredSize(new java.awt.Dimension(510, 175));

        lblFirstname.setText("Prénom");
        lblFirstname.setPreferredSize(new java.awt.Dimension(150, 15));
        panOwner.add(lblFirstname);

        txtFirstname.setPreferredSize(new java.awt.Dimension(350, 23));
        txtFirstname.getDocument().addDocumentListener(new TxtUpdate(this));
        panOwner.add(txtFirstname);

        lblLastname.setText("Nom");
        lblLastname.setPreferredSize(new java.awt.Dimension(150, 15));
        panOwner.add(lblLastname);

        txtLastname.setPreferredSize(new java.awt.Dimension(350, 23));
        txtLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastnameActionPerformed(evt);
            }
        });
        txtLastname.getDocument().addDocumentListener(new TxtUpdate(this));
        panOwner.add(txtLastname);

        lblEmail.setText("Email");
        lblEmail.setPreferredSize(new java.awt.Dimension(150, 15));
        panOwner.add(lblEmail);

        txtEmail.setPreferredSize(new java.awt.Dimension(350, 23));
        txtEmail.getDocument().addDocumentListener(new TxtUpdate(this));
        panOwner.add(txtEmail);

        lblPassword.setText("Mot de passe");
        lblPassword.setPreferredSize(new java.awt.Dimension(150, 15));
        panOwner.add(lblPassword);

        txtPassword.setPreferredSize(new java.awt.Dimension(350, 21));
        txtPassword.getDocument().addDocumentListener(new TxtUpdate(this));
        panOwner.add(txtPassword);

        lblClub.setText("Club");
        lblClub.setMaximumSize(new java.awt.Dimension(150, 15));
        lblClub.setMinimumSize(new java.awt.Dimension(150, 15));
        lblClub.setPreferredSize(new java.awt.Dimension(150, 15));
        panOwner.add(lblClub);

        cboClub.setModel(cboClubModel);
        cboClub.setToolTipText("Veuillez sélectionner une classe");
        cboClub.setPreferredSize(new java.awt.Dimension(350, 25));
        cboClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClubActionPerformed(evt);
            }
        });
        panOwner.add(cboClub);

        btnCancel.setText("Annuler");
        btnCancel.setPreferredSize(new java.awt.Dimension(100, 31));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        panOwner.add(btnCancel);

        btnAddOwner.setText("Ajouter le propriétaire");
        btnAddOwner.setEnabled(false);
        btnAddOwner.setPreferredSize(new java.awt.Dimension(400, 31));
        btnAddOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOwnerActionPerformed(evt);
            }
        });
        panOwner.add(btnAddOwner);

        panContent.add(panOwner);

        panSail.setPreferredSize(new java.awt.Dimension(510, 125));

        lblSail.setText("Numéro de voile");
        lblSail.setMaximumSize(new java.awt.Dimension(150, 15));
        lblSail.setMinimumSize(new java.awt.Dimension(150, 15));
        lblSail.setPreferredSize(new java.awt.Dimension(150, 15));
        panSail.add(lblSail);

        txtSail.setToolTipText("Veuillez saisir un numéro de voile");
        txtSail.setPreferredSize(new java.awt.Dimension(350, 23));
        txtSail.getDocument().addDocumentListener(new TxtUpdate(this));
        panSail.add(txtSail);

        lblOwner.setText("Propriétaire");
        lblOwner.setMaximumSize(new java.awt.Dimension(150, 15));
        lblOwner.setMinimumSize(new java.awt.Dimension(150, 15));
        lblOwner.setPreferredSize(new java.awt.Dimension(150, 15));
        panSail.add(lblOwner);

        cboOwner.setModel(cboOwnerModel);
        cboOwner.setToolTipText("Veuillez sélectionner un propriétaire");
        cboOwner.setPreferredSize(new java.awt.Dimension(350, 25));
        cboOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboOwnerActionPerformed(evt);
            }
        });
        panSail.add(cboOwner);

        lblSerie.setText("Série");
        lblSerie.setMaximumSize(new java.awt.Dimension(150, 15));
        lblSerie.setMinimumSize(new java.awt.Dimension(150, 15));
        lblSerie.setPreferredSize(new java.awt.Dimension(150, 15));
        panSail.add(lblSerie);

        cboSerie.setModel(cboSerieModel);
        cboSerie.setToolTipText("Veuillez sélectionner une série");
        cboSerie.setPreferredSize(new java.awt.Dimension(350, 25));
        cboSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSerieActionPerformed(evt);
            }
        });
        panSail.add(cboSerie);

        lblClass.setText("Classe");
        lblClass.setMaximumSize(new java.awt.Dimension(150, 15));
        lblClass.setMinimumSize(new java.awt.Dimension(150, 15));
        lblClass.setPreferredSize(new java.awt.Dimension(150, 15));
        panSail.add(lblClass);

        cboClass.setModel(cboClassModel);
        cboClass.setToolTipText("Veuillez sélectionner une classe");
        cboClass.setPreferredSize(new java.awt.Dimension(350, 25));
        cboClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClassActionPerformed(evt);
            }
        });
        panSail.add(cboClass);

        panContent.add(panSail);

        getContentPane().add(panContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Fermer la fenêtre
     *
     * @param evt
     */
    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        setVisible(false);
        dispose();
        System.out.println("btnCloseMouseClicked");
    }//GEN-LAST:event_btnCloseMouseClicked

    /**
     * *
     * Ajouter un voilier dans la base de donnée
     *
     * @param evt
     */
    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if (!checkDatas()) {
            return;
        }

        Sailboat s = new Sailboat(null, Integer.parseInt(txtSail.getText()));
        s.setOwnerId((Owner) cboOwnerModel.getSelectedItem());
        s.setClassId((Sbclass) cboClassModel.getSelectedItem());

        EntityManager em = Utils.getEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        
        setVisible(false);
        dispose();

        JOptionPane.showMessageDialog(this, "Le voilier a bien été ajouté.");
        System.out.println("btnAddMouseClicked");
    }//GEN-LAST:event_btnAddMouseClicked

    /**
     * *
     *
     * Sélection d'un propriétaire
     *
     * @param evt
     */
    private void cboOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOwnerActionPerformed
        checkDatas();
        if (cboOwnerModel.getSelectedItem() != null && ((Owner) cboOwnerModel.getSelectedItem()).getId().equals(newOwner.getId())) {
            setVisibleOwner(true);
        } else {
            setVisibleOwner(false);
        }
        System.out.println("cboOwnerActionPerformed");
    }//GEN-LAST:event_cboOwnerActionPerformed

    private void setVisibleOwner(boolean value) {
        panOwner.setVisible(value);
        panSail.setVisible(!value);
        checkDatas();
    }

    /**
     * *
     *
     * Sélection d'une série
     *
     * @param evt
     */
    private void cboSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSerieActionPerformed
        checkDatas();
        if (cboSerieModel.getSelectedItem() != null) {
            cboClassModel = new DefaultComboBoxModel(filterClassBy(sailboatClass, (Serie) cboSerieModel.getSelectedItem()));
            cboClass.setModel(cboClassModel);
        }
        System.out.println("cboSerieActionPerformed");
    }//GEN-LAST:event_cboSerieActionPerformed

    /**
     * *
     *
     * Sélection d'une classe
     *
     * @param evt
     */
    private void cboClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClassActionPerformed
        checkDatas();
        System.out.println("cboClassActionPerformed");
    }//GEN-LAST:event_cboClassActionPerformed

    private void txtLastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastnameActionPerformed

    private void cboClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClubActionPerformed
        checkDatas();
        System.out.println("cboClubActionPerformed");
    }//GEN-LAST:event_cboClubActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisibleOwner(false);
        cboOwner.setSelectedIndex(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOwnerActionPerformed
        if (!checkDatas()) {
            return;
        }

        Owner o = new Owner();
        Person p = new Person(0, txtFirstname.getText(), txtLastname.getText(), txtEmail.getText(), txtPassword.getPassword().toString());

        o.setPersonId(p);
        o.setClubId((Club)cboClubModel.getSelectedItem());

        EntityManager em = Utils.getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.persist(o);
        em.getTransaction().commit();
        em.refresh(p);
        em.refresh(o);
        
        // Repeuplement des données
        Query qOwner = em.createNamedQuery("Owner.findAll");
        List<Owner> owners = qOwner.getResultList();
        owners.add(0, selectOwner);
        owners.add(newOwner);
        cboOwnerModel = new DefaultComboBoxModel(owners.toArray());
        cboOwner.setModel(cboOwnerModel);
        
        cboOwnerModel.setSelectedItem(o);
        
        txtFirstname.setText("");
        txtLastname.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        
        setVisibleOwner(false);
        System.out.println("btnAddOwnerClicked");
    }//GEN-LAST:event_btnAddOwnerActionPerformed

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
    private javax.swing.JButton btnAddOwner;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox<Sbclass> cboClass;
    private javax.swing.JComboBox<Club> cboClub;
    private javax.swing.JComboBox<Owner> cboOwner;
    private javax.swing.JComboBox<Serie> cboSerie;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblClub;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblOwner;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSail;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JPanel panContent;
    private javax.swing.JPanel panFooter;
    private javax.swing.JPanel panOwner;
    private javax.swing.JPanel panSail;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtInfo;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSail;
    // End of variables declaration//GEN-END:variables

    /**
     * *
     *
     * Filtrer les classes en fonction de la série
     *
     * @param sailboatClass liste des classes de voilier
     * @param serie la série de voilier sélectionnée
     * @return
     */
    private Sbclass[] filterClassBy(List<Sbclass> sailboatClass, Serie serie) {
        List<Sbclass> sbclass = new ArrayList<>();
        for (Sbclass c : sailboatClass) {
            if (c.getId().equals(-1) || c.getSerieId().getId().equals(serie.getId())) {
                sbclass.add(c);
            }
        }
        return Arrays.copyOf(sbclass.toArray(), sbclass.size(), Sbclass[].class);
    }

    /**
     * *
     *
     * Evènement appelé lors d'une modification d'un champ texte
     *
     */
    @Override
    public void txtEdited() {
        checkDatas();
        System.out.println("txtEdited");
    }

    /**
     * *
     *
     * Vérification des données
     *
     * @return true si les données sont valides
     */
    private boolean checkDatas() {
        if (panSail.isVisible()) {
            String txt = txtSail.getText();
            if (txt.isEmpty()) {
                updateInfo("Veuillez saisir un numéro de voile");
                return false;
            }
            Integer sail = 0;
            try {
                sail = Integer.parseInt(txt);
            } catch (Exception e) {
                
            }
            if (sail.equals(0)) {
                updateInfo("Veuillez saisir un numéro de voile supérieur à 0");
                return false;
            }
            if (cboOwner.getItemCount() == 0 || cboOwner.getSelectedIndex() == -1 || (cboOwnerModel.getSelectedItem() != null && ((Owner)cboOwnerModel.getSelectedItem()).getId().equals(-1))) {
                updateInfo("Veuillez sélectionner un propriétaire");
                return false;
            }
            if (cboSerie.getItemCount() == 0 || cboSerie.getSelectedIndex() == -1 || (cboSerieModel.getSelectedItem() != null && ((Serie)cboSerieModel.getSelectedItem()).getId().equals(-1))) {
                updateInfo("Veuillez sélectionner une série");
                return false;
            }
            if (cboClass.getItemCount() == 0 || cboClass.getSelectedIndex() == -1 || (cboClassModel.getSelectedItem() != null && ((Sbclass)cboClassModel.getSelectedItem()).getId().equals(-1))) {
                updateInfo("Veuillez sélectionner une classe");
                return false;
            }
        } else {
            if (txtFirstname.getText().isEmpty()) {
                updateInfo("Veuillez saisir le prénom");
                return false;
            }
            if (txtLastname.getText().isEmpty()) {
                updateInfo("Veuillez saisir le nom");
                return false;
            }
            if (txtEmail.getText().isEmpty()) {
                updateInfo("Veuillez saisir l'email");
                return false;
            }
            if (!Algo.isEmail(txtEmail.getText())) {
                updateInfo("Veuillez saisir un email valide, exemple : jeanpascal@orange.fr");
                return false;
            }
            if (txtPassword.getPassword().length == 0) {
                updateInfo("Veuillez saisir le mot de passe");
                return false;
            }
            if (cboClass.getItemCount() == 0 || cboClub.getSelectedIndex() == -1 || (cboClubModel.getSelectedItem() != null && ((Club)cboClubModel.getSelectedItem()).getId().equals(-1))) {
                updateInfo("Veuillez sélectionner le club");
                return false;
            }
        }
        updateInfo("");
        return true;
    }

    /**
     * *
     *
     * Mettre à jour les informations d'erreur de saisie
     *
     * @param s
     */
    private void updateInfo(String s) {
        if (s.isEmpty()) {
            if (panSail.isVisible()) {
                btnAdd.setEnabled(true);
                btnAddOwner.setEnabled(false);
            } else {
                btnAdd.setEnabled(false);
                btnAddOwner.setEnabled(true);
            }
        } else {
            btnAdd.setEnabled(false);
            btnAddOwner.setEnabled(false);
        }
        txtInfo.setText(s);
        if (panSail.isVisible()) {
            btnAdd.setToolTipText(s);   
        } else {
            btnAddOwner.setToolTipText(s);
            btnAdd.setToolTipText("Veuillez saisir le propriétaire");
        }
    }

}
