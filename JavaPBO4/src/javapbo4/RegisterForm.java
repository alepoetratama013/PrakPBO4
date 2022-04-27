package javapbo4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class RegisterForm extends JFrame{
    JLabel userName, passWord;
    JTextField inputUname;
    JPasswordField inputPw;
    JButton btRegist, btCancel, btGologin;
    
    Connector con = new Connector();
    Statement stat;

    public RegisterForm(){
        setTitle("Register");
        setVisible(true);
        setSize(300,250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        userName = new JLabel("Username :");
        passWord = new JLabel("Password :");
        inputUname = new JTextField();
        inputPw = new JPasswordField();
        btRegist = new JButton("Register");
        btCancel = new JButton("Cancel");
        btGologin = new JButton("login here");
        
        setLayout(null);
        add(userName);
        add(passWord);
        add(inputUname);
        add(inputPw);
        add(btRegist);
        add(btCancel);
        add(btGologin);
        
        userName.setBounds(25, 25, 70, 30);
        passWord.setBounds(25, 60, 70, 30);
        
        inputUname.setBounds(100, 25, 160, 30);
        inputPw.setBounds(100, 60, 160, 30);
        
        btRegist.setBounds(50, 120, 100, 30);
        btCancel.setBounds(155, 120, 80, 30);
        btGologin.setBounds(50, 160, 185, 20);
        
        btRegist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   if(inputUname.getText().equals("") || inputPw.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Username or Password cannot be empty!");
                } else {
                    String username = inputUname.getText();
                    String password = String.valueOf(inputPw.getPassword());
                    if(!con.checkUsername(username)){
                        con.insertData(username, password);
                        JOptionPane.showMessageDialog(null, "Register success");
                    }else{
                        JOptionPane.showMessageDialog(null, "Username Sudah Terpakai");
                    }
                }
            }
        });
        
        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        
        btGologin.addActionListener(new ActionListener(){
          @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                LoginForm login = new LoginForm();
            }
        });
    }
}