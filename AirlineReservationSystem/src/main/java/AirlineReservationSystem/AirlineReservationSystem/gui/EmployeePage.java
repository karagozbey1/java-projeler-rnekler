package AirlineReservationSystem.AirlineReservationSystem.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import AirlineReservationSystem.AirlineReservationSystem.Helper.helper;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.user;

import AirlineReservationSystem.AirlineReservationSystem.service.concrates.UserService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

@Component
public class EmployeePage extends JFrame {
    private static final long serialVersionUID = 1L;

    private UserService userService;
  
    private List<seferler> flights;
    private JTextField txtPassword;
    private JTextField txtsurname;
    private JTextField txtName;
    private JTextField txtTc;
    private JTextField txtDate;
    private JTable table_bilgigoster;

	private Container contentPane;

    @Autowired
    public EmployeePage(UserService userService, List<seferler> flights) {
    	getContentPane().setBackground(new Color(255, 0, 0));
        this.userService = userService;
        
        this.flights = flights;

        initialize();
    }

    private void initialize() {
        setTitle("Personel Sayfası");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = getContentPane();
        contentPane.setLayout(null);

        String[] columnNames = {"Sefer ID", "Kalkış Yeri", "Varış Yeri", "Kalkış Tarihi", "Varış Tarihi", "Uçak Modeli", "Kapasite", "Boş Koltuk", "Fiyat"};
        Object[][] data = new Object[flights.size()][9];
        for (int i = 0; i < flights.size(); i++) {
            seferler flight = flights.get(i);
            data[i][0] = flight.getSeferId();
            data[i][1] = flight.getKalkisYeri();
            data[i][2] = flight.getVarisYeri();
            data[i][3] = flight.getKalkisTarihi();
            data[i][4] = flight.getVarisTarihi();
            data[i][5] = flight.getUcakModeli();
            data[i][6] = flight.getKapasite();
            data[i][7] = flight.getBosKoltuk();
            data[i][8] = flight.getFiyat();
        }

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 745, 517);
        contentPane.add(tabbedPane);

        JPanel panel_goster = new JPanel();
        tabbedPane.addTab("Seferleri_Goster", null, panel_goster, null);
        panel_goster.setLayout(null);

        JTable flightsTable = new JTable();
        flightsTable.setModel(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(flightsTable);
        scrollPane.setBounds(0, 0, 753, 497);
        panel_goster.add(scrollPane);

        JPanel panel_profilguncelle = new JPanel();
        tabbedPane.addTab("Profilini Güncelle", null, panel_profilguncelle, null);
        panel_profilguncelle.setLayout(null);

        JLabel lblName = new JLabel("Ad:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblName.setBounds(30, 90, 100, 25);
        panel_profilguncelle.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(162, 89, 192, 31);
        panel_profilguncelle.add(txtName);

        JLabel lblTc = new JLabel("TC:");
        lblTc.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTc.setBounds(30, 249, 100, 25);
        panel_profilguncelle.add(lblTc);

        txtTc = new JTextField();
        txtTc.setBounds(162, 249, 192, 31);
        panel_profilguncelle.add(txtTc);

        JLabel lbldate = new JLabel("Doğum Tarihi:");
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbldate.setBounds(30, 193, 100, 25);
        panel_profilguncelle.add(lbldate);

        txtDate = new JTextField();
        txtDate.setBounds(162, 192, 192, 31);
        panel_profilguncelle.add(txtDate);

        JButton btnGuncelle = new JButton("Güncelle");
        btnGuncelle.setBounds(68, 353, 250, 50);
        panel_profilguncelle.add(btnGuncelle);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(383, 30, 347, 436);
        panel_profilguncelle.add(scrollPane_1);

        table_bilgigoster = new JTable();
        scrollPane_1.setViewportView(table_bilgigoster);

        JLabel lblsurname = new JLabel("SoyAd :");
        lblsurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblsurname.setBounds(30, 146, 100, 25);
        panel_profilguncelle.add(lblsurname);

        txtsurname = new JTextField();
        txtsurname.setBounds(162, 145, 192, 31);
        panel_profilguncelle.add(txtsurname);

        JLabel lblpassword = new JLabel("Şifre :");
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblpassword.setBounds(30, 299, 100, 25);
        panel_profilguncelle.add(lblpassword);

        txtPassword = new JTextField();
        txtPassword.setBounds(162, 299, 192, 31);
        panel_profilguncelle.add(txtPassword);

        btnGuncelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUserProfile();
            }
        });
   
    
    loadPersonelTable();
    }

    private void updateUserProfile() {
        String name = txtName.getText();
        String tc = txtTc.getText();
        String surname = txtsurname.getText();
        String password = txtPassword.getText();
        Date date = helper.convert(txtDate.getText());

        user currentUser = userService.getCurrentUser();
   
        currentUser.setName(name);
        currentUser.setTc(tc);
        currentUser.setDate(date);
        currentUser.setPassword(password);
        currentUser.setSurname(surname);
      
        userService.updateUser(currentUser);
        JOptionPane.showMessageDialog(this, "Profil başarıyla güncellendi.");
        loadPersonelTable();

    }
    private void loadPersonelTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"İsim", "Soyisim", "Doğum Tarihi", "TC", "Şifre"});

        try {
            user currentUser = userService.getCurrentUser();

            if (currentUser != null) {
                model.addRow(new Object[]{
                    currentUser.getName(), 
                    currentUser.getSurname(), 
                    currentUser.getDate(), 
                    currentUser.getTc(), 
                    currentUser.getPassword()
                });
            } else {
                System.out.println("Current user is null");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while loading the user information: " + e.getMessage());
            e.printStackTrace();
        }

        table_bilgigoster.setModel(model);
    }


}
