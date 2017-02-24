/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.view;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author malah
 */
public class TxtUpdate implements DocumentListener {

    SailboatRegister frame;

    public interface Listener {

        public void txtEdited();
    }

    public TxtUpdate(SailboatRegister frame) {
        this.frame = frame;
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        frame.txtEdited();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        frame.txtEdited();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        frame.txtEdited();
    }

}
