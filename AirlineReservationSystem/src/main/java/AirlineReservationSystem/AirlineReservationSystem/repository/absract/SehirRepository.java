	package AirlineReservationSystem.AirlineReservationSystem.repository.absract;
	
	import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.Sehir; 
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;
	
	import java.util.List;

@Repository
public interface SehirRepository extends JpaRepository<Sehir, Integer> {

    @Query("SELECT c.sehir_adi FROM Sehir c WHERE c.sehirID = :sehirID")
    String findCityNameById(@Param("sehirID") Integer sehirID);

    @Query("SELECT c FROM Sehir c")
    List<Sehir> getAllSehirler();
}