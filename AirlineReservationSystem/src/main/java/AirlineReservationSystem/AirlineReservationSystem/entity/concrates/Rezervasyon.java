package AirlineReservationSystem.AirlineReservationSystem.entity.concrates;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rezervasyon")
public class Rezervasyon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rezervasyon_id")
    private Integer rezervasyonId;
    
    @Column(name = "KullaniciId")
    private Integer kullaniciId;
   
    @ManyToOne
    @JoinColumn(name = "sefer_id")
    private seferler seferler;
  
    
    
    @Column(name = "koltuk_no")
    private String koltukNo;
    
    @Column(name = "rezervasyon_tarihi")
    private LocalDate rezervasyonTarihi; 
     
    @Column(name = "durum")
    private String durum;
}
