	package AirlineReservationSystem.AirlineReservationSystem.gui;
	
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Date;
	import java.time.LocalDateTime;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;
	
	import javax.swing.*;
	import javax.swing.border.EmptyBorder;
	import javax.swing.table.DefaultTableModel;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	
	import AirlineReservationSystem.AirlineReservationSystem.Helper.ReservationTableModel;
	import AirlineReservationSystem.AirlineReservationSystem.Helper.helper;
	import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.user;
	import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.yonetici;
	import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;
	import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.Rezervasyon;
	import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.Sehir;
	import AirlineReservationSystem.AirlineReservationSystem.service.concrates.UserService;
	import AirlineReservationSystem.AirlineReservationSystem.service.concrates.SehirService;
	import AirlineReservationSystem.AirlineReservationSystem.service.concrates.RezervasyonService;
	import AirlineReservationSystem.AirlineReservationSystem.service.concrates.SeferService;
	import java.awt.Font;
	import java.awt.Color;
	
	@Component
	public class AdminPage extends JFrame {
	
	    private static final long serialVersionUID = 1L;
	    private JPanel AdminW_Pane;
	    private JTable tablePers;
	    private JTable tableSefer;
	    private final UserService userService;
	    private final SeferService seferService;
	    private final SehirService sehirService;
	    private final yonetici yonetici;
	    private final RezervasyonService rezervasyonService;
	    private JTextField txtName;
	    private JTextField txtSurname;
	    private JTextField txtDate;
	    private JTextField txtTc;
	    private JTextField txtPassword;
	    private JTextField txtID;
	    private JTextField txtKalkisTarihi;
	    private JTextField txtVarisTarihi;
	    private JTextField txtUcakModeli;
	    private JTextField txtKapasite;
	    private JTextField txtFiyat;
	    private JComboBox<String> comboBoxVarisYeri;
	    private JComboBox<String> comboBoxKalkisYeri;
	    private JTable table_SfrGoster;
	    private JTextField fld_Pers;
		private JTextField text_yeniPersId;
	   
	    @Autowired
	    public AdminPage(UserService userService, SeferService seferService, SehirService sehirService ,yonetici yonetici,RezervasyonService rezervasyonService ) {
	    	this.rezervasyonService=rezervasyonService;
	    	this.yonetici = yonetici;
	        this.userService = userService;
	        this.seferService = seferService;
	        this.sehirService = sehirService;
	        initUI();
	    }
	
	    private void initUI() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 903, 563);
	        AdminW_Pane = new JPanel();
	        AdminW_Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(AdminW_Pane);
	        AdminW_Pane.setLayout(null);
	
	        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	        tabbedPane.setBounds(10, 63, 889, 463);
	        AdminW_Pane.add(tabbedPane);
	
	        // Personel Yönetimi Paneli
	        JPanel personelEklePanel = new JPanel();
	        personelEklePanel.setBackground(new Color(255, 0, 0));
	        tabbedPane.addTab("Personel Yönetimi", null, personelEklePanel, null);
	        personelEklePanel.setLayout(null);
	
	        JLabel lblName = new JLabel("İsim:");
	        lblName.setFont(new Font("Arial Black", Font.ITALIC, 13));
	        lblName.setBounds(27, 4, 100, 25);
	        personelEklePanel.add(lblName);
	
	        txtName = new JTextField();
	        txtName.setBounds(10, 40, 100, 25);
	        personelEklePanel.add(txtName);
	        txtName.setColumns(10);
	
	        JLabel lblSurname = new JLabel("Soyisim:");
	        lblSurname.setFont(new Font("Arial Black", Font.BOLD, 13));
	        lblSurname.setBounds(137, 4, 100, 25);
	        personelEklePanel.add(lblSurname);
	
	        txtSurname = new JTextField();
	        txtSurname.setBounds(137, 40, 100, 25);
	        personelEklePanel.add(txtSurname);
	        txtSurname.setColumns(10);
	
	        JLabel lblDate = new JLabel("Doğum Tarihi:");
	        lblDate.setFont(new Font("Arial Black", Font.ITALIC, 13));
	        lblDate.setBounds(260, 4, 100, 25);
	        personelEklePanel.add(lblDate);
	
	        txtDate = new JTextField();
	        txtDate.setBounds(260, 40, 100, 25);
	        personelEklePanel.add(txtDate);
	        txtDate.setColumns(10);
	
	        JLabel lblTc = new JLabel("TC:");
	        lblTc.setFont(new Font("Arial Black", Font.ITALIC, 13));
	        lblTc.setBounds(380, 4, 100, 25);
	        personelEklePanel.add(lblTc);
	
	        txtTc = new JTextField();
	        txtTc.setBounds(380, 40, 100, 25);
	        personelEklePanel.add(txtTc);
	        txtTc.setColumns(10);
	
	        JLabel lblPassword = new JLabel("Şifre:");
	        lblPassword.setFont(new Font("Arial Black", Font.ITALIC, 13));
	        lblPassword.setBounds(500, 4, 100, 25);
	        personelEklePanel.add(lblPassword);
	
	        txtPassword = new JTextField();
	        txtPassword.setBounds(500, 40, 100, 25);
	        personelEklePanel.add(txtPassword);
	        txtPassword.setColumns(10);
	
	        JButton btnPersonelEkle = new JButton("Personel Ekle");
	        btnPersonelEkle.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        btnPersonelEkle.setBounds(620, 40, 120, 25);
	        personelEklePanel.add(btnPersonelEkle);
	
	        JLabel lblPersonelSil = new JLabel("eskiPersonel");
	        lblPersonelSil.setFont(new Font("Arial Black", Font.BOLD, 14));
	        lblPersonelSil.setBounds(47, 75, 133, 25);
	        personelEklePanel.add(lblPersonelSil);
	
	        txtID = new JTextField();
	        txtID.setBounds(190, 77, 120, 25);
	        personelEklePanel.add(txtID);
	        txtID.setColumns(10);
	
	        JButton btnPersonelSil = new JButton("Sil");
	        btnPersonelSil.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        btnPersonelSil.setBounds(620, 75, 120, 25);
	        personelEklePanel.add(btnPersonelSil);
	
	        JScrollPane scrollPanePers = new JScrollPane();
	        scrollPanePers.setBounds(10, 115, 830, 295);
	        personelEklePanel.add(scrollPanePers);
	
	        tablePers = new JTable();
	        scrollPanePers.setViewportView(tablePers);
	        
	        JLabel lblYenipersonel = new JLabel("yeniPersonel");
	        lblYenipersonel.setFont(new Font("Arial Black", Font.BOLD, 14));
	        lblYenipersonel.setBounds(339, 75, 133, 25);
	        personelEklePanel.add(lblYenipersonel);
	        
	        text_yeniPersId = new JTextField();
	        text_yeniPersId.setColumns(10);
	        text_yeniPersId.setBounds(467, 77, 133, 25);
	        personelEklePanel.add(text_yeniPersId);
	        
	        // Sefer Yönetimi Paneli
	        JPanel seferEklePanel = new JPanel();
	        seferEklePanel.setBackground(new Color(255, 0, 0));
	        tabbedPane.addTab("Sefer Yönetimi", null, seferEklePanel, null);
	        seferEklePanel.setLayout(null);
	        
            JLabel lblKalkisYeri = new JLabel("Kalkış Yeri:");
            lblKalkisYeri.setFont(new Font("Arial Black", Font.ITALIC, 13));
            lblKalkisYeri.setBounds(10, 24, 100, 25);
            seferEklePanel.add(lblKalkisYeri);
            
            comboBoxKalkisYeri = new JComboBox<>();
            comboBoxKalkisYeri.setBounds(120, 24, 200, 25);
            seferEklePanel.add(comboBoxKalkisYeri);
            
	        JLabel lblVarisYeri = new JLabel("Varış Yeri:");
	        lblVarisYeri.setFont(new Font("Arial Black", Font.ITALIC, 13));
	        lblVarisYeri.setBounds(10, 70, 100, 25);
	        seferEklePanel.add(lblVarisYeri);
	        
	        comboBoxVarisYeri = new JComboBox<>();
	        comboBoxVarisYeri.setBounds(120, 70, 200, 25);
	        seferEklePanel.add(comboBoxVarisYeri);
	        
            JLabel lblKalkisTarihi = new JLabel("Kalkış Tarihi:");
            lblKalkisTarihi.setFont(new Font("Arial Black", Font.ITALIC, 13));
            lblKalkisTarihi.setBounds(10, 117, 100, 25);
            seferEklePanel.add(lblKalkisTarihi);
                                            
            txtKalkisTarihi = new JTextField();
            txtKalkisTarihi.setBounds(120, 117, 200, 25);
            seferEklePanel.add(txtKalkisTarihi);
            txtKalkisTarihi.setColumns(10);
            
            JLabel lblVarisTarihi = new JLabel("Varış Tarihi:");
            lblVarisTarihi.setFont(new Font("Arial Black", Font.ITALIC, 13));
            lblVarisTarihi.setBounds(10, 156, 100, 25);
            seferEklePanel.add(lblVarisTarihi);
            
            txtVarisTarihi = new JTextField();
            txtVarisTarihi.setBounds(120, 156, 200, 25);
            seferEklePanel.add(txtVarisTarihi);
            txtVarisTarihi.setColumns(10);
    
            JLabel lblUcakModeli = new JLabel("Uçak Modeli:");
            lblUcakModeli.setFont(new Font("Arial Black", Font.ITALIC, 13));
            lblUcakModeli.setBounds(10, 202, 100, 25);
            seferEklePanel.add(lblUcakModeli);
            
            txtUcakModeli = new JTextField();
            txtUcakModeli.setBounds(120, 202, 200, 25);
            seferEklePanel.add(txtUcakModeli);
            txtUcakModeli.setColumns(10);
            
            JLabel lblKapasite = new JLabel("Kapasite:");
            lblKapasite.setFont(new Font("Arial Black", Font.ITALIC, 13));
            lblKapasite.setBounds(10, 246, 100, 25);
            seferEklePanel.add(lblKapasite);
                                            
            txtKapasite = new JTextField();
            txtKapasite.setBounds(120, 246, 200, 25);
            seferEklePanel.add(txtKapasite);
            txtKapasite.setColumns(10);
                    
            JLabel lblFiyat = new JLabel("Fiyat:");
            lblFiyat.setFont(new Font("Arial Black", Font.ITALIC, 13));
            lblFiyat.setBounds(10, 294, 100, 25);
            seferEklePanel.add(lblFiyat);
            
            txtFiyat = new JTextField();
            txtFiyat.setBounds(120, 296, 200, 25);
            seferEklePanel.add(txtFiyat);
            txtFiyat.setColumns(10);
            
            JButton btnSeferEkle = new JButton("Sefer Ekle");
            btnSeferEkle.setFont(new Font("Tahoma", Font.PLAIN, 15));
            btnSeferEkle.setBounds(10, 392, 310, 25);
            seferEklePanel.add(btnSeferEkle);

            JScrollPane scrollPaneSefer = new JScrollPane();
            scrollPaneSefer.setBounds(330, 10, 544, 407);
            seferEklePanel.add(scrollPaneSefer);
            
            tableSefer = new JTable();
            scrollPaneSefer.setViewportView(tableSefer);
            
            JLabel lblpersID = new JLabel("personelID");
            lblpersID.setFont(new Font("Arial Black", Font.ITALIC, 13));
            lblpersID.setBounds(10, 344, 100, 25);
            seferEklePanel.add(lblpersID);
            
            fld_Pers = new JTextField();
            fld_Pers.setColumns(10);
            fld_Pers.setBounds(120, 346, 200, 25);
            seferEklePanel.add(fld_Pers);

      
	                btnSeferEkle.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                       
	                    	SeferEkle();
	                                }
	                            });
	            
	
	                
	                
	        JPanel panel_Kgoster = new JPanel();
	        panel_Kgoster.setBackground(new Color(255, 0, 0));
	        tabbedPane.addTab("Rezervasyonları  Görüntüle", null, panel_Kgoster, null);
	        panel_Kgoster.setLayout(null);
	        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(10, 38, 846, 388);
	        panel_Kgoster.add(scrollPane);
	        
	        table_SfrGoster = new JTable();
	        scrollPane.setViewportView(table_SfrGoster); 
	        
	        JLabel lblHosgeldin = new JLabel("Hoşgeldiniz"  );
	        lblHosgeldin.setFont(new Font("Arial Black", Font.BOLD, 16));
	        lblHosgeldin.setBounds(364, 22, 198, 14);
	        AdminW_Pane.add(lblHosgeldin);
	
	      
	        
	        btnPersonelEkle.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                PersonelEkle();
	            }
	        });
	
	        
	        
	        btnPersonelSil.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	deletePersonnel();
	            }
	        });
	
	      
	
	        // Sehir bilgilerini comboBoxlara yükle
	        List<Sehir> sehirler = sehirService.getAllSehirler();
	        for (Sehir sehir : sehirler) {
	            comboBoxKalkisYeri.addItem(sehir.getSehir_adi());
	            comboBoxVarisYeri.addItem(sehir.getSehir_adi());
	        }
	
	      
	        loadPersonelTable();
	        loadSeferTable();
	        loadPastReservations(); 
	
	    
	    }
	
	
	    private void PersonelEkle() {
	        String name = txtName.getText();
	        String surname = txtSurname.getText();
	        Date date = helper.convert(txtDate.getText());
	        String tc = txtTc.getText();
	        String password = txtPassword.getText();
	
	        user personel = new user();
	        personel.setName(name);
	        personel.setSurname(surname);
	        personel.setDate(date);
	        personel.setTc(tc);
	        personel.setPassword(password);
	        personel.setType("personel");
	        userService.addUser(personel);
	
	        loadPersonelTable();
	        clearPersonelForm();
	    }
	
	    public void deletePersonnel() {
	        int userId = Integer.parseInt(txtID.getText());
	        int newUserıd=Integer.parseInt(text_yeniPersId.getText());
	
	        try {
	          
	           Optional<user> NewUserOpt = userService.getUsersById(newUserıd);
	            if (!NewUserOpt.isPresent()) {
	                JOptionPane.showMessageDialog(this, "No replacement user found.", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	
	            int newUserId = NewUserOpt.get().getUserId();
	             seferService.updateSeferUserId(newUserId, userId);
	           
	            
	            userService.deleteUser(userId);
	
	
	            JOptionPane.showMessageDialog(this, "Personnel silme ve sefer güncelleme işlemi başarılı.", "Success", JOptionPane.INFORMATION_MESSAGE);
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        loadPersonelTable();
	        clearPersonelForm();
	    
	 }
	       
	


	    private void SeferEkle() {
	       
	    	String kalkisYeri = (String) comboBoxKalkisYeri.getSelectedItem();
	        String varisYeri = (String) comboBoxVarisYeri.getSelectedItem();
	         LocalDateTime  kalkisTarihi = helper.convertTime(txtKalkisTarihi.getText());
	         LocalDateTime  varisTarihi = helper.convertTime(txtVarisTarihi.getText());
	        String ucakModeli = txtUcakModeli.getText();
	        int kapasite = Integer.parseInt(txtKapasite.getText());
	        int persID  =Integer.parseInt(fld_Pers.getText());
	        double fiyat = Double.parseDouble(txtFiyat.getText());
	       
	        seferler sefer = new seferler();
	        sefer.setSeferId(null);
	        sefer.setKalkisYeri(kalkisYeri);
	        sefer.setVarisYeri(varisYeri);
	        sefer.setKalkisTarihi(kalkisTarihi);
	        sefer.setVarisTarihi(varisTarihi);
	        sefer.setUcakModeli(ucakModeli);
	        sefer.setKapasite(kapasite);
	        sefer.setBosKoltuk(kapasite);
	        sefer.setFiyat(fiyat);
	        sefer.setPersID(persID);
	       
	        seferService.saveSefer(sefer);
	        loadSeferTable();
	        clearSeferForm();
	    }
	
	
	
	    private void loadPersonelTable() {
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(new Object[]{"ID", "İsim", "Soyisim", "Doğum Tarihi", "TC", "Şifre"});
	
	        List<user> personelList = userService.getPersoneller();
	        for (user personel : personelList) {
	            model.addRow(new Object[]{personel.getUserId(), personel.getName(), personel.getSurname(), personel.getDate(), personel.getTc(), personel.getPassword()});
	        }
	
	        tablePers.setModel(model);
	    }
	
	
	    private void loadSeferTable() {
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(new Object[]{"ID","personelID", "Kalkış Yeri", "Varış Yeri", "Kalkış Tarihi", "Varış Tarihi", "Uçak Modeli", "Kapasite", "Fiyat"});
	
	        List<seferler> seferList = seferService.getAllSeferler();
	        for (seferler sefer : seferList) {
	            model.addRow(new Object[]{sefer.getSeferId(),sefer.getPersID(), sefer.getKalkisYeri(), sefer.getVarisYeri(), sefer.getKalkisTarihi(), sefer.getVarisTarihi(), sefer.getUcakModeli(), sefer.getKapasite(), sefer.getFiyat()});
	        }
	
	        tableSefer.setModel(model);
	    }
	
	    private void clearPersonelForm() {
	        txtName.setText("");
	        txtSurname.setText("");
	        txtDate.setText("");
	        txtTc.setText("");
	        txtPassword.setText("");
	        txtID.setText("");
	    }
	
	  
	    private void clearSeferForm() {
	        txtKalkisTarihi.setText("");
	        txtVarisTarihi.setText("");
	        txtUcakModeli.setText("");
	        txtKapasite.setText("");
	        txtFiyat.setText("");
	       
	    }
	    
		    
		    private void loadPastReservations() {
		        
		        List<user> allUsers = userService.getAllUsers();
		        
	
		        ArrayList<Rezervasyon> allReservations = new ArrayList<>();
		        
		 
		        for (user user : allUsers) {
		            List<Rezervasyon> userReservations = rezervasyonService.getRezervasyonlarByKullaniciId(user.getUserId());
		            allReservations.addAll(userReservations);
		        }
		        
		        // Oluşturulan listeyi tabloya ekle
		      table_SfrGoster.setModel(new ReservationTableModel(allReservations));
		    }
	}
