package AirlineReservationSystem.AirlineReservationSystem.repository.absract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.Rezervasyon;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RezervasyonRepository extends JpaRepository<Rezervasyon, Integer> {
    List<Rezervasyon> findByKullaniciId(Integer KullaniciId);
    
    List<Rezervasyon> findByseferlerSeferId(Integer seferId);
    
    @Query("SELECT s FROM seferler s WHERE " +
    	       "(:kalkisYeri IS NULL OR s.kalkisYeri = :kalkisYeri) AND " +
    	       "(:varisYeri IS NULL OR s.varisYeri = :varisYeri) AND " +
    	       "(:kalkisTarihi IS NULL OR s.kalkisTarihi = :kalkisTarihi) AND " +
    	       "(:varisTarihi IS NULL OR s.varisTarihi = :varisTarihi) AND " +
    	       "(:fiyat IS NULL OR s.fiyat = :fiyat)")
    	List<seferler> findSeferler(@Param("kalkisYeri") String kalkisYeri,
    	                            @Param("varisYeri") String varisYeri,
    	                            @Param("kalkisTarihi") LocalDateTime kalkisTarihi,
    	                            @Param("varisTarihi") LocalDateTime varisTarihi,
    	                            @Param("fiyat") Double fiyat);

}