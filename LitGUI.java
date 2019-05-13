package Han.Fire;

import Han.Fire.data.Locations;
import Han.Fire.data.Logs;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LitGUI extends JFrame {
    private JComboBox<Logs> logComboBox;
    private JComboBox<Locations> locationComboBox;
    private JButton initiate;
    public LitGUI() {

        super("Lit Configuration");

        setLayout(new FlowLayout());
        initiate = new JButton("Lit");

        logComboBox = new JComboBox<>(Logs.values());
        locationComboBox = new JComboBox<>(Locations.values());
        add(logComboBox);
        add(locationComboBox);
        add(initiate);
        setLocationRelativeTo(null);
        initiate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lit.SELECTED_LOCATION = (Locations) locationComboBox.getSelectedItem();
                Lit.SELECTED_LOG_ID = (Logs) logComboBox.getSelectedItem();
                setVisible(false);
            }
        });
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        pack();
    }
}
