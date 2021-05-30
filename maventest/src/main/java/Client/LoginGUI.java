package Client;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import java.awt.Container;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LoginGUI {
    static JTextField usernameTextField;
    static JPasswordField passwordField;
    static JButton logiButton;
    static JFrame aFrame;
    public LoginGUI(){
        aFrame = new JFrame("Login/register");
        Container aContainer = aFrame.getContentPane();
        JPanel aJPanel = new JPanel();

        aJPanel.add(new JLabel("Username"));

        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new DimensionUIResource(100, 20));
        aJPanel.add(usernameTextField);

        aJPanel.add(new JLabel("Password"));

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new DimensionUIResource(100, 20));
        aJPanel.add(passwordField);
        
        logiButton = new JButton("Login");
        logiButton.setPreferredSize(new DimensionUIResource(80, 40));
        logiButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String username = (usernameTextField.getText());
                String password = (String.valueOf(passwordField.getPassword()));

                if(username.equals("") || password.equals("")){
                }else{
                    try{
                        CCommunicator.LoginSentUsernameAndPasswordFromGUItoSocket(username,password);
                        }catch(IOException exception){
                    }
                }
            }
        });
        aJPanel.add(logiButton);
        aContainer.add(aJPanel);
        aFrame.setSize(700,300);
        aFrame.setDefaultCloseOperation(3);
        aFrame.setVisible(true);
        aFrame.setAlwaysOnTop(true);
    }
    // public static void main(String[] args) {
    //     new LoginGUI();
    // }
}