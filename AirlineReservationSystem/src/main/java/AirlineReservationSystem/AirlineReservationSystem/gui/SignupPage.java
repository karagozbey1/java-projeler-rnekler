package AirlineReservationSystem.AirlineReservationSystem.gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import AirlineReservationSystem.AirlineReservationSystem.Helper.helper;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.kullanici;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.user;
import AirlineReservationSystem.AirlineReservationSystem.service.concrates.UserService;

@Component
public class SignupPage extends JFrame {
    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtBirthDate;
    private JTextField txtTC;
    private JPasswordField passwordField;
    private JButton btnSignup;
    private static final long serialVersionUID = 1L;
   
    private UserService userService ;
    private user  kullanici =new user();
    private JPanel panel;
    private JLabel lbl_logo;
    private JLabel lblNewLabel;
    
    
    
    @Autowired
    public SignupPage(UserService userService) {
    	this.userService=userService;
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 733, 468);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("İsim:");
        lblName.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblName.setBounds(335, 48, 80, 20);
        contentPane.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(477, 51, 200, 20);
        contentPane.add(txtName);
        txtName.setColumns(10);

        JLabel lblSurname = new JLabel("Soy isim:");
        lblSurname.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblSurname.setBounds(335, 96, 80, 20);
        contentPane.add(lblSurname);

        txtSurname = new JTextField();
        txtSurname.setBounds(477, 96, 200, 20);
        contentPane.add(txtSurname);
        txtSurname.setColumns(10);

        JLabel lblBirthDate = new JLabel("Doğum Traihi");
        lblBirthDate.setFont(new Font("Arial Black", Font.PLAIN, 11));
        lblBirthDate.setBounds(335, 145, 104, 20);
        contentPane.add(lblBirthDate);

        txtBirthDate = new JTextField();
        txtBirthDate.setBounds(477, 145, 200, 20);
        contentPane.add(txtBirthDate);
        txtBirthDate.setColumns(10);

        JLabel lblTC = new JLabel("TC:");
        lblTC.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblTC.setBounds(342, 186, 137, 20);
        contentPane.add(lblTC);

        txtTC = new JTextField();
        txtTC.setBounds(477, 186, 200, 20);
        contentPane.add(txtTC);
        txtTC.setColumns(10);

        JLabel lblPassword = new JLabel("Şifre:");
        lblPassword.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblPassword.setBounds(342, 240, 125, 19);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(477, 240, 200, 20);
        contentPane.add(passwordField);

        btnSignup = new JButton("Kayıt Ol");
        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = txtName.getText();
                    String surname = txtSurname.getText();
                    String birthDateStr = txtBirthDate.getText();
                    String tc = txtTC.getText();
                    String password = new String(passwordField.getPassword());
                    
                    // Eğer herhangi bir alan boşsa, kullanıcıya uyarı ver
                    if (name.isEmpty() || surname.isEmpty() || birthDateStr.isEmpty() || tc.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(SignupPage.this, "Lütfen tüm alanları doldurun", "Hata", JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    
                    // Tarih dönüşümü yapmadan önce kontrol et
                    Date birthDate = helper.convert(birthDateStr);
                    
                    kullanici.setUserId(null);
                    kullanici.setName(name);
                    kullanici.setSurname(surname);
                    kullanici.setTc(tc);
                    kullanici.setType("kullanici");
                    kullanici.setDate(birthDate);
                    kullanici.setPassword(password);
                    userService.addUser(kullanici);
                    JOptionPane.showMessageDialog(SignupPage.this, "Kayıt işlemi başarılıyla gerçekleşti", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    // Tarih dönüşüm hatası
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(SignupPage.this, "lütfen tarihi 'gg/aa/yy' şeklinde girin ", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSignup.setBounds(393, 327, 213, 30);
        contentPane.add(btnSignup);
        
        panel = new JPanel();
        panel.setBounds(0, 0, 234, 431);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("airplane.png")));
        lbl_logo.setBounds(22, 97, 189, 210);
        panel.add(lbl_logo);
        JLabel lblNewLabel_2 = new JLabel("        ©2012 TürkHavaYolları ");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(10, 380, 201, 41);
        panel.add(lblNewLabel_2);
        
        lblNewLabel = new JLabel("       Kayıt SistemnineHoş Geldiniz");
        lblNewLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
        lblNewLabel.setBounds(0, 10, 224, 41);
        panel.add(lblNewLabel);
    }
}
