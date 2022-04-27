package javapbo4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class LoginForm extends JFrame{
    JLabel userName, passWord;
    JTextField inputUname;
    JPasswordField inputPw;
    JButton btLogin, btCancel, btGoregist;
    
    Connector con = new Connector();
    Statement stat;

    public LoginForm(){
        setTitle("Login");
        setVisible(true);
        setSize(300,250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        userName = new JLabel("Username :");
        passWord = new JLabel("Password :");
        inputUname = new JTextField();
        inputPw = new JPasswordField();
        btLogin = new JButton("Login");
        btCancel = new JButton("Cancel");
        btGoregist = new JButton("register here");
        
        setLayout(null);
        add(userName);
        add(passWord);
        add(inputUname);
        add(inputPw);
        add(btLogin);
        add(btCancel);
        add(btGoregist);
        
        userName.setBounds(25, 25, 70, 30);
        passWord.setBounds(25, 60, 70, 30);
        

        inputUname.setBounds(100, 25, 160, 30);
        inputPw.setBounds(100, 60, 160, 30);
        
 
        btLogin.setBounds(50, 120, 80, 30);
        btCancel.setBounds(155, 120, 80, 30);
        btGoregist.setBounds(50, 160, 185, 20);
        
        btLogin.addActionListener((ActionListener) -> {
            if(inputUname.getText().equals("") || inputPw.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Username or Password cannot be empty!");
            } else {
                String username = inputUname.getText();
                String password = String.valueOf(inputPw.getPassword());
                if(con.checkLogin(username, password)){
                    JOptionPane.showMessageDialog(null, "Login success");
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Username or Password!");
                }
            }
        });
        
        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        
        btGoregist.addActionListener(new ActionListener(){
          @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                RegisterForm regist = new RegisterForm();
            }
        });
    }
}