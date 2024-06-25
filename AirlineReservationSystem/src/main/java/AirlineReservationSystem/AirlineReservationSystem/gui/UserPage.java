package AirlineReservationSystem.AirlineReservationSystem.gui;

import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.Sehir;
import AirlineReservationSystem.AirlineReservationSystem.Helper.FlightTableModel;
import AirlineReservationSystem.AirlineReservationSystem.Helper.ReservationTableModel;
import AirlineReservationSystem.AirlineReservationSystem.Helper.helper;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.Rezervasyon;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.user;
import AirlineReservationSystem.AirlineReservationSystem.repository.absract.SeferlerRepository;
import AirlineReservationSystem.AirlineReservationSystem.service.concrates.RezervasyonService;
import AirlineReservationSystem.AirlineReservationSystem.service.concrates.SeferService;
import AirlineReservationSystem.AirlineReservationSystem.service.concrates.SehirService;
import AirlineReservationSystem.AirlineReservationSystem.service.concrates.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import java.time.LocalDateTime;

import java.util.List;

@Component
public class UserPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTable pastReservationsTable;

    private SehirService sehirService;
    private RezervasyonService rezervasyonService;
    private UserService userService;
    private SeferService seferService;
    private JComboBox<String> cbKalkisYeri;
    private JComboBox<String> cbVarisYeri;
    private JTextField txtKalkisTarihi;
    private JTextField txtVarisTarihi;
    private JTextField txtName;
    private JTextField txtTc;
    private JTextField txtDate;
    private JTable table_bilgigoster;
    private JTextField txtsurname;
    private JTextField txtPassword;
    private JTextField txtFiyat;

    @Autowired
    public UserPage(SehirService sehirService, RezervasyonService rezervasyonService, UserService userService,SeferService seferService) {
    	setResizable(false);
        this.sehirService = sehirService;
        this.rezervasyonService = rezervasyonService;
        this.userService = userService;
        this.seferService=seferService;
       
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 888, 611);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(24, 10, 840, 554);
        contentPane.add(tabbedPane);

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
        btnGuncelle.setFont(new Font("Arial", Font.BOLD, 14));
        btnGuncelle.setBounds(83, 395, 250, 50);
        panel_profilguncelle.add(btnGuncelle);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(400, 30, 425, 446);
        panel_profilguncelle.add(scrollPane_1);

        table_bilgigoster = new JTable();
        scrollPane_1.setViewportView(table_bilgigoster);

        JLabel lbsurlName = new JLabel("SoyAd :");
        lbsurlName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbsurlName.setBounds(30, 146, 100, 25);
        panel_profilguncelle.add(lbsurlName);

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
        
                JPanel panel_rezervasyon = new JPanel();
                tabbedPane.addTab("Rezervasyon İşlemleri", null, panel_rezervasyon, null);
                panel_rezervasyon.setLayout(null);
                
        JLabel lblKalkisYeri = new JLabel("Kalkış Yeri:");
        lblKalkisYeri.setFont(new Font("Arial", Font.BOLD, 13));
        lblKalkisYeri.setBounds(20, 30, 100, 25);
        panel_rezervasyon.add(lblKalkisYeri);
        
		cbKalkisYeri = new JComboBox<>();
		cbKalkisYeri.setBounds(130, 30, 211, 25);
		panel_rezervasyon.add(cbKalkisYeri);
		
		        JLabel lblVarisYeri = new JLabel("Varış Yeri:");
		        lblVarisYeri.setFont(new Font("Arial", Font.BOLD, 13));
		        lblVarisYeri.setBounds(374, 30, 120, 25);
		        panel_rezervasyon.add(lblVarisYeri);
		        
		            cbVarisYeri = new JComboBox<>();
		            cbVarisYeri.setBounds(520, 30, 259, 25);
		            panel_rezervasyon.add(cbVarisYeri);
		            
		            JLabel lblKalkisTarihi = new JLabel("Kalkış Tarihi:");
		            lblKalkisTarihi.setFont(new Font("Arial", Font.BOLD, 13));
		            lblKalkisTarihi.setBounds(20, 87, 100, 25);
		            panel_rezervasyon.add(lblKalkisTarihi);
		            
		                    txtKalkisTarihi = new JTextField();
		                    txtKalkisTarihi.setBounds(130, 87, 211, 25);
		                    panel_rezervasyon.add(txtKalkisTarihi);
		                    
		                    JLabel lblVarisTarihi = new JLabel("Varış Tarihi:");
		                    lblVarisTarihi.setFont(new Font("Arial", Font.BOLD, 13));
		                    lblVarisTarihi.setBounds(374, 87, 100, 25);
		                    panel_rezervasyon.add(lblVarisTarihi);
		                    
        txtVarisTarihi = new JTextField();
        txtVarisTarihi.setBounds(520, 87, 259, 25);
        panel_rezervasyon.add(txtVarisTarihi);
        
        JButton btnFiltrele = new JButton("Filtrele");
        btnFiltrele.setFont(new Font("Arial", Font.BOLD, 15));
        btnFiltrele.setBounds(77, 204, 250, 25);
        panel_rezervasyon.add(btnFiltrele);
        
                table = new JTable();
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setBounds(30, 250, 795, 245);
                panel_rezervasyon.add(scrollPane);
                
                        JButton btnSatinAl = new JButton("Satın Al");
                        btnSatinAl.setFont(new Font("Arial", Font.BOLD, 15));
                        btnSatinAl.setBounds(529, 204, 250, 25);
                        panel_rezervasyon.add(btnSatinAl);
                        
                        txtFiyat = new JTextField();
                        txtFiyat.setBounds(520, 149, 259, 25);
                        panel_rezervasyon.add(txtFiyat);
                        
                                JLabel lblFiyat = new JLabel(" Fiyat:");
                                lblFiyat.setFont(new Font("Arial", Font.BOLD, 13));
                                lblFiyat.setBounds(379, 149, 115, 25);
                                panel_rezervasyon.add(lblFiyat);
                                
	    btnFiltrele.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    filterFlights();
                                }
});
	    
        btnSatinAl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveReservation();
            }
        });

      

        JPanel panel_goruntule = new JPanel();
        tabbedPane.addTab("Geçmiş Rezervasyonlar", null, panel_goruntule, null);
        panel_goruntule.setLayout(null);

        pastReservationsTable = new JTable();
        JScrollPane pastReservationsScrollPane = new JScrollPane(pastReservationsTable);
        pastReservationsScrollPane.setBounds(30, 30, 772, 267);
        panel_goruntule.add(pastReservationsScrollPane);

        JButton btnIptalEt = new JButton("İptal Et");
        btnIptalEt.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnIptalEt.setBounds(552, 417, 250, 25);
        panel_goruntule.add(btnIptalEt);
        populateCityComboBox();

        btnIptalEt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelReservation();
            }
        });

        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 2) {
                loadPastReservations();
            }
        });
    
    loadUserTable();
  
    }

    private void populateCityComboBox() {
        List<Sehir> cities = sehirService.getAllSehirler();
        for (Sehir city : cities) {
            cbKalkisYeri.addItem(city.getSehir_adi());
            cbVarisYeri.addItem(city.getSehir_adi());
        }
    }

    private void filterFlights() {
    	
    	String kalkisYeri = cbKalkisYeri.getSelectedItem().toString();
        String varisYeri = cbVarisYeri.getSelectedItem().toString();
        double fiyat = Double.parseDouble(txtFiyat.getText());
        LocalDateTime kalkisTarihi = helper.convertTime(txtKalkisTarihi.getText()) ;
        LocalDateTime varisTarihi = helper.convertTime(txtVarisTarihi.getText() );
        
        List<seferler> flights = rezervasyonService.findSeferler(kalkisYeri, varisYeri, kalkisTarihi, varisTarihi,fiyat);
        table.setModel(new FlightTableModel(flights));
    }
    private void saveReservation() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
           
        	seferler selectedFlight = ((FlightTableModel) table.getModel()).getFlightAt(selectedRow);
            Rezervasyon rezervasyon = new Rezervasyon();
              
            int kapasite = selectedFlight.getKapasite();
            String BiletNo = helper.randomKoltukNoUret(kapasite);
         
            rezervasyon.setSeferler(selectedFlight);
            rezervasyon.setKullaniciId(userService.getCurrentUser().getUserId());
            rezervasyon.setKoltukNo(BiletNo); 
            rezervasyon.setRezervasyonTarihi(java.time.LocalDate.now());
            rezervasyon.setDurum("aktif"); 
         
            rezervasyonService.createRezervasyon(rezervasyon);
            
            if (!rezervasyon.getKoltukNo().isEmpty()) {
                int BosKoltuk = selectedFlight.getBosKoltuk();
                int seferId=selectedFlight.getSeferId();
                --BosKoltuk;
                
               seferService.updateBosKoltuk(seferId, BosKoltuk);
               
                JOptionPane.showMessageDialog(this, "Rezervasyon başarıyla oluşturuldu.");
            } else {
                System.out.println("Koltuk sayısı azaltılmadı.");
                JOptionPane.showMessageDialog(this, "Rezervasyon oluşturulurken bir hata oluştu.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen bir sefer seçin.");
        }   
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
      loadUserTable();
    }
    private void loadUserTable() {
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
    

    private void loadPastReservations() {
        int userId = userService.getCurrentUser().getUserId();
        List<Rezervasyon> pastReservations = rezervasyonService.getRezervasyonlarByKullaniciId(userId);
        pastReservationsTable.setModel(new ReservationTableModel(pastReservations));
    }

    private void cancelReservation() {
        int selectedRow = pastReservationsTable.getSelectedRow();
        if (selectedRow != -1) {
            Rezervasyon selectedReservation = ((ReservationTableModel) pastReservationsTable.getModel()).getReservationAt(selectedRow);
            
            if (!selectedReservation.getKoltukNo().isEmpty()) {
                int BosKoltuk = selectedReservation.getSeferler().getBosKoltuk();
                int seferId=selectedReservation.getSeferler().getSeferId();
                ++BosKoltuk;
                
               seferService.updateBosKoltuk(seferId, BosKoltuk);
               
            try {
                rezervasyonService.deleteRezervasyon(selectedReservation.getRezervasyonId());
                JOptionPane.showMessageDialog(this, "Rezervasyon başarıyla iptal edildi.");
                loadPastReservations();
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen bir rezervasyon seçin.");
        }
    }
    
}
}