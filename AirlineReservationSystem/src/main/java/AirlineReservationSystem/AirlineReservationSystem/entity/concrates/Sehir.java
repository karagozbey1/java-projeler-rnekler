package AirlineReservationSystem.AirlineReservationSystem.entity.concrates;
	
	
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	

@Entity
@Table(name = "sehir")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sehir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sehirID")
    private Integer sehirID;

    @Column(name = "sehir_adi")
    private String sehir_adi;
}