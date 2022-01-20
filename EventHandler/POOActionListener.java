package EventHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class POOActionListener implements ActionListener //à la base y'avait pas le implements ActionListener si jamais
{

    private static JTextField text;
    private static JButton btn;
    private static JButton btn2;


    public static void main(String[] args)

    {

        JFrame frame = new JFrame("");

        text = new JTextField();

        text.setBounds(15,50,200,20);

        btn = new JButton("1");

        btn.setBounds(70,100,100,30);

        btn2 = new JButton("2");

        btn2.setBounds(70,150,100,30);


        frame.add(btn);

        frame.add(btn2);

        frame.add(text);

        frame.setSize(270,250);

        frame.setLayout(null);

        frame.setVisible(true);

//

// TODO: enregistrer l'action listener au boutton 'bnt'

// pour que lorsqu'on clique, le text suivant soit

// affiché: "Welcome to the POO class of 2021"

//
        POOActionListener instance = new POOActionListener();
        btn.addActionListener(instance);

        POOActionListener instance2 = new POOActionListener();
        btn2.addActionListener(instance2);
    }

    public void actionPerformed(ActionEvent e){
        JButton button = (JButton)e.getSource();
        String label = button.getText();

        if(label.equals(btn.getText())){
            setText();
        }
        if(label.equals(btn2.getText())){
            setText2();
        }
    }

    public void setText(){
        text.setText("Bouton 1 pressé");
    }

    public void setText2(){
        text.setText("Bouton 2 pressé");
    }


}