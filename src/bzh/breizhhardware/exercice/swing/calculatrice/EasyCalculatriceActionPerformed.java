package bzh.breizhhardware.exercice.swing.calculatrice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EasyCalculatriceActionPerformed extends JFrame implements ActionListener{

    private JTextField textField;
    private JLabel label;
    private JButton btnCopier;
    private JButton btnEffacer;

    public EasyCalculatriceActionPerformed(){
        setTitle("Exercice copier/effacer");

        setLayout(new BorderLayout());

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        JPanel panelBoutons = new JPanel();
        btnCopier = new JButton("Copier");
        btnEffacer = new JButton("Effacer");
        panelBoutons.add(btnCopier);
        panelBoutons.add(btnEffacer);
        add(panelBoutons, BorderLayout.CENTER);

        label = new JLabel("Texte saisi : ");
        add(label, BorderLayout.SOUTH);

        btnCopier.addActionListener(this);
        btnEffacer.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String texte = "";
        if(e.getSource() == btnCopier){
            texte = textField.getText();
            label.setText("Texte saisi : " + texte);
        }else if(e.getSource() == btnEffacer){
            textField.setText("");
            label.setText("Texte saisi : ");
        }
    }

    public static void main(String[] args) {
        new EasyCalculatriceActionPerformed();
    }
}