	package AirlineReservationSystem.AirlineReservationSystem.gui;
	import javax.swing.ImageIcon;
	
	import java.awt.EventQueue;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import javax.swing.JTabbedPane;
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import javax.swing.JButton;
	import javax.swing.JOptionPane;
	import java.awt.Color;
	import java.awt.Font;
	
	import java.awt.event.ActionListener;
	import java.awt.event.WindowAdapter;
	import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Optional;
	import java.awt.event.ActionEvent;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.builder.SpringApplicationBuilder;
	import org.springframework.context.ConfigurableApplicationContext;
	
	import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.kullanici;
	import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.personel;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.user;
	import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.yonetici;
import AirlineReservationSystem.AirlineReservationSystem.service.concrates.RezervasyonService;
import AirlineReservationSystem.AirlineReservationSystem.service.concrates.SeferService;
	import AirlineReservationSystem.AirlineReservationSystem.service.concrates.SehirService;
	import AirlineReservationSystem.AirlineReservationSystem.service.concrates.UserService;
	
	import org.springframework.stereotype.Component;
	
	@Component
	public class LoginSystem extends JFrame {
	
	    private static final long serialVersionUID = 1L;
	
	    private JPanel w_Pane;
	
	   
		private JTextField fld_kullanici;
		private JPasswordField fld_passwordK;
		private JTextField Fld_per;
		private JPasswordField fld_perPassword;
		private JTextField fld_ynt;
		private JPasswordField fld_passwordynt;
	
		@Autowired
	    private UserService userService;
	    @Autowired
	   private SeferService SeferService;
		@Autowired
	    private SehirService SehirService;
		@Autowired
		private yonetici yonetici;
		@Autowired
		private RezervasyonService rezervasyonService;
		
	    public static void main(String[] args) {
	        ConfigurableApplicationContext context = new SpringApplicationBuilder(LoginSystem.class).headless(false).run(args);
	        EventQueue.invokeLater(() -> {
	            try {
	                LoginSystem frame = context.getBean(LoginSystem.class);
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }
	    public LoginSystem() {
	        setResizable(false);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 724, 438);
	        w_Pane = new JPanel();
	        w_Pane.setBackground(new Color(255, 255, 255));
	        w_Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
	        setContentPane(w_Pane);
	        w_Pane.setLayout(null);
	
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(new Color(255, 0, 0));
	        panel_1.setBounds(0, 0, 227, 401);
	        w_Pane.add(panel_1);
	        panel_1.setLayout(null);
	
	        JLabel lblNewLabel = new JLabel();
	        lblNewLabel.setBackground(new Color(255, 0, 0));
	        lblNewLabel.setBounds(20, 10, 207, 51);
	        panel_1.add(lblNewLabel);
	        lblNewLabel.setForeground(new Color(0, 0, 0));
	        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
	
		        JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("airplane.png")));
		        lbl_logo.setBounds(10, 71, 206, 223);
	        panel_1.add(lbl_logo);
	
	        JLabel lblNewLabel_2 = new JLabel("©2012 TürkHavaYolları ");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_2.setBounds(47, 350, 139, 41);
	        panel_1.add(lblNewLabel_2);
	
	        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	        tabbedPane.setBackground(new Color(255, 255, 255));
	        tabbedPane.setForeground(new Color(255, 0, 0));
	        tabbedPane.setBounds(226, 88, 484, 313);
	        w_Pane.add(tabbedPane);
	
	        JPanel Kgrs_panel = new JPanel();
	        Kgrs_panel.setBorder(null);
	        Kgrs_panel.setForeground(new Color(255, 0, 0));
	        Kgrs_panel.setBackground(new Color(255, 255, 255));
	        tabbedPane.addTab("Kullanıcı Girişi", null, Kgrs_panel, null);
	        Kgrs_panel.setLayout(null);
	
	        JLabel lblKullancAd = new JLabel("Kullanıcı Adı");
	        lblKullancAd.setForeground(Color.BLACK);
	        lblKullancAd.setFont(new Font("Arial", Font.BOLD, 16));
	        lblKullancAd.setBackground(Color.RED);
	        lblKullancAd.setBounds(26, 49, 207, 41);
	        Kgrs_panel.add(lblKullancAd);
	
	        JLabel lblifre = new JLabel("Şifre");
	        lblifre.setForeground(Color.BLACK);
	        lblifre.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
	        lblifre.setBackground(Color.RED);
	        lblifre.setBounds(26, 120, 207, 41);
	        Kgrs_panel.add(lblifre);
	
	        fld_kullanici = new JTextField();
	        fld_kullanici.setBounds(238, 49, 231, 41);
	        Kgrs_panel.add(fld_kullanici);
	        fld_kullanici.setColumns(10);
	
	        fld_passwordK = new JPasswordField();
	        fld_passwordK.setBounds(238, 120, 231, 41);
	        Kgrs_panel.add(fld_passwordK);
	
	        JButton btn_kayitol = new JButton("kayıt ol");
	        btn_kayitol.setForeground(new Color(255, 0, 0));
	        btn_kayitol.setBackground(new Color(28, 41, 68));
	        btn_kayitol.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
	        btn_kayitol.setBounds(37, 191, 189, 41);
	        Kgrs_panel.add(btn_kayitol);
	
	        JButton KullaniciGbtn = new JButton("Giriş");
	        KullaniciGbtn.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		  loginUser(fld_kullanici,fld_passwordK);
	        	}
	        });
	        KullaniciGbtn.setForeground(new Color(255, 0, 0));
	        KullaniciGbtn.setBackground(new Color(28, 41, 68));
	        KullaniciGbtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
	        KullaniciGbtn.setBounds(238, 190, 215, 41);
	        Kgrs_panel.add(KullaniciGbtn);
	
	        JPanel yntGrs_panel = new JPanel();
	        yntGrs_panel.setBackground(new Color(255, 255, 255));
	        tabbedPane.addTab("Yönetici girişi", null, yntGrs_panel, null);
	        yntGrs_panel.setLayout(null);
	        JPanel perGrs_panel = new JPanel();
	        perGrs_panel.setBackground(new Color(255, 255, 255));
	        yntGrs_panel.setBackground(new Color(255, 255, 255));
	        tabbedPane.addTab("personel girişi", null, perGrs_panel, null);
	        perGrs_panel.setLayout(null);
	
	        JLabel Klbl_per = new JLabel("Kullanıcı Adı");
	        Klbl_per.setForeground(Color.BLACK);
	        Klbl_per.setFont(new Font("Arial", Font.BOLD, 16));
	        Klbl_per.setBackground(Color.RED);
	        Klbl_per.setBounds(27, 60, 146, 41);
	        perGrs_panel.add(Klbl_per);
	
	        JLabel Plbl_per = new JLabel("şifre");
	        Plbl_per.setForeground(Color.BLACK);
	        Plbl_per.setFont(new Font("Arial", Font.BOLD, 16));
	        Plbl_per.setBackground(Color.RED);
	        Plbl_per.setBounds(27, 146, 146, 41);
	        perGrs_panel.add(Plbl_per);
	
	        Fld_per = new JTextField();
	        Fld_per.setColumns(10);
	        Fld_per.setBounds(181, 62, 271, 41);
	        perGrs_panel.add(Fld_per);
	
	        fld_perPassword = new JPasswordField();
	        fld_perPassword.setBounds(183, 147, 271, 43);
	        perGrs_panel.add(fld_perPassword);
	
	        JButton Pgrs_btn = new JButton("Giriş");
	        Pgrs_btn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Optional<user> userOptional = loginUser(Fld_per, fld_perPassword);

	                if (userOptional.isPresent()) {
	                    user user = userOptional.get();
	                    if (user != null) {
	                        personel personel = new personel();
	                        personel.setUserId(user.getUserId());
	                        personel.setDate(user.getDate());
	                        personel.setName(user.getName());
	                        personel.setPassword(user.getPassword());
	                        personel.setSurname(user.getSurname());
	                        personel.setType(user.getType());
	                        userService.setCurrentUser(personel);
	                        
	                        List<seferler> assignedFlights = SeferService.getFlightsByEmployeeId(user.getUserId());

	                        // Seferleri personel sayfasına geçir
	                        EmployeePage personelPage = new EmployeePage(userService, assignedFlights);
	                        personelPage.setVisible(true);
	                        dispose();
	                    } else {
	                        System.out.println("Kullanıcı bilgileri boş.");
	                        JOptionPane.showMessageDialog(null, "Kullanıcı bilgileri boş", "Hata", JOptionPane.ERROR_MESSAGE);
	                    }
	                } else {
	                    System.out.println("Kullanıcı bulunamadı.");
	                    JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre hatalı", "Hata", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        Pgrs_btn.setForeground(Color.RED);
	        Pgrs_btn.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
	        Pgrs_btn.setBackground(new Color(28, 41, 68));
	        Pgrs_btn.setBounds(55, 212, 365, 41);
	        perGrs_panel.add(Pgrs_btn);
	        yntGrs_panel.setLayout(null);
	
	        JLabel lblKullancAd_1 = new JLabel("Kullanıcı Adı");
	        lblKullancAd_1.setForeground(Color.BLACK);
	        lblKullancAd_1.setFont(new Font("Arial", Font.BOLD, 16));
	        lblKullancAd_1.setBackground(Color.RED);
	        lblKullancAd_1.setBounds(22, 51, 146, 41);
	        yntGrs_panel.add(lblKullancAd_1);
	
	        JLabel lblKullancAd_1_1 = new JLabel("Şifre");
	        lblKullancAd_1_1.setForeground(Color.BLACK);
	        lblKullancAd_1_1.setFont(new Font("Arial", Font.BOLD, 16));
	        lblKullancAd_1_1.setBackground(Color.RED);
	        lblKullancAd_1_1.setBounds(22, 133, 146, 41);
	        yntGrs_panel.add(lblKullancAd_1_1);
	
	        fld_ynt = new JTextField();
	        fld_ynt.setBounds(178, 51, 271, 41);
	        yntGrs_panel.add(fld_ynt);
	        fld_ynt.setColumns(10);
	
	        fld_passwordynt = new JPasswordField();
	        fld_passwordynt.setBounds(178, 133, 271, 43);
	        yntGrs_panel.add(fld_passwordynt);
	        JButton Ygrs_btn = new JButton("Giriş");
	        Ygrs_btn.addActionListener(new ActionListener() {
	    
	
				
	
				public void actionPerformed(ActionEvent e) {
	                Optional<user> useroptional = loginUser(fld_ynt, fld_passwordynt);
	
	                if (useroptional.isPresent()) {
	                    user user = useroptional.get();
	
	                    yonetici ynt = new yonetici();
	                    ynt.setUserId(user.getUserId());
	                    ynt.setDate(user.getDate());
	                    ynt.setName(user.getName());
	                    ynt.setPassword(user.getPassword());
	                    ynt.setSurname(user.getSurname());
	                    ynt.setType(user.getType());
	                    System.out.println(ynt.getName());
	
	                    AdminPage admin = new AdminPage(userService, SeferService,SehirService ,yonetici,rezervasyonService );
	                    admin.setVisible(true);
	                    dispose();
	                } else {
	                    
	                  
	                    JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre hatalı", "Hata", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        btn_kayitol.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	      
	                setVisible(false);
	                
	                SignupPage signupPage = new SignupPage(userService);
	                signupPage.addWindowListener(new WindowAdapter() {
	                    @Override
	                    public void windowClosed(WindowEvent e) {
	                        setVisible(true);
	                    }
	                });
	                signupPage.setVisible(true);
	            }
	        });
	
	
	        KullaniciGbtn.addActionListener(new ActionListener() {
	            
	
				

				public void actionPerformed(ActionEvent e) {
	                Optional<user> useroptional = loginUser(fld_kullanici, fld_passwordK);
	
	                if (useroptional.isPresent()) {
	                    user user = useroptional.get();
	
	                    kullanici kullanici=new kullanici();
	                    kullanici.setUserId(user.getUserId());
	                    kullanici.setDate(user.getDate());
	                    kullanici.setName(user.getName());
	                    kullanici.setPassword(user.getPassword());
	                    kullanici.setSurname(user.getSurname());
	                    kullanici.setType(user.getType());
	                    System.out.println(kullanici.getName());
	                     userService.setCurrentUser(kullanici);
	                   UserPage userP= new UserPage(SehirService,rezervasyonService, userService, SeferService);
	                    userP.setVisible(true);
	                    dispose();
	                } else {
	                
	                    JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre hatalı", "Hata", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        Ygrs_btn.setForeground(Color.RED);
	        Ygrs_btn.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
	        Ygrs_btn.setBackground(new Color(28, 41, 68));
	        Ygrs_btn.setBounds(56, 205, 365, 41);
	        yntGrs_panel.add(Ygrs_btn);
	    }
	
	    private Optional<user> loginUser(JTextField User_Tc, JPasswordField fld_pass) {
	        String username = User_Tc.getText();
	        String password = new String(fld_pass.getPassword());
	        return userService.validateUser(username, password);
	    }
	
	    
	
	}
