/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.report;

import afpa.ecf.physicalregatta.Utils;
import afpa.ecf.physicalregatta.dao.ConnectDAO;
import afpa.ecf.physicalregatta.model.Regatta;
import afpa.ecf.physicalregatta.view.SailboatRegister;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author gwenole
 */
public class StartList {

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
                
                Query qRegatta = Utils.getEntityManager().createNamedQuery("Regatta.findAll");
                List<Regatta> regattas = qRegatta.getResultList();
                Regatta regatta = regattas.size() > 0 ? regattas.get(0) : null;
                
                Regatta r = (Regatta) JOptionPane.showInputDialog(
                        null,
                        "Sélectionner la régate :\n",
                        "Génération de rapport",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        regattas.toArray(),
                        regatta);
                
                if (r != null) {
                    view(r.getId());
                }
            }
        });
    }

    private static JasperPrint generate(int regatta_id) {
        try {
            HashMap<String, Object> param = new HashMap<>();
            param.put("regatta_id", regatta_id);
            JasperReport report = (JasperReport) JRLoader.loadObject(StartList.class.getResource("start_list.jasper"));
            report.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "false");
            report.setProperty("net.sf.jasperreports.default.font.name=SansSerif", "true");
            JasperPrint jPrint = JasperFillManager.fillReport(report, param, ConnectDAO.Instance().get());
            return jPrint;
        } catch (JRException ex) {
            Logger.getLogger(StartList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void view(int regatta_id) {
        JasperPrint jPrint = generate(regatta_id);
        JFrame pdfFrame = new JFrame("Rapport");
        pdfFrame.getContentPane().add(new JRViewer(jPrint));
        pdfFrame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pdfFrame.setSize((int) (screenSize.getWidth() / 3), (int) (screenSize.getHeight() - 100));
        pdfFrame.setLocationRelativeTo(null);
        pdfFrame.setVisible(true);
    }
}
