package AirlineReservationSystem.AirlineReservationSystem.entity.concrates;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="sefer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class seferler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sefer_id")
    private Integer seferId ;

    @Column(name="kalkis_sehir" )
    private String kalkisYeri;

    @Column(name="varis_sehir")
    private String varisYeri;

    @Column(name="kalkis_tarihi")
    private LocalDateTime kalkisTarihi;

    @Column(name="varis_tarihi")
    private LocalDateTime varisTarihi;

    @Column(name="ucak_modeli")
    private String ucakModeli;

    @Column( name="kapasite")
    private Integer kapasite;

    @Column(name ="koltuk_sayisi" )
    private int BosKoltuk;

    @Column(name="fiyat")
    private Double fiyat;
    			
    @Column(name ="user_id")
    private int persID;

    @OneToMany(mappedBy = "seferler", cascade = CascadeType.ALL)
    private Set<Rezervasyon> rezervasyonlar;
}
