package AirlineReservationSystem.AirlineReservationSystem.repository.absract;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;

@Repository
public interface SeferlerRepository extends JpaRepository<seferler, Integer> {
    // Tüm seferleri getiren metod
    List<seferler> findAll();
    
    List<seferler> findByPersID(int personel_id);

    // Sefer kaydı yapan metod
    seferler save(seferler sefer);

    // Seferi güncelleyen metod
    seferler saveAndFlush(seferler sefer);

   
    
    @Modifying
    @Transactional
    @Query("UPDATE seferler s SET s.persID = :newUserId WHERE s.persID = :userId")
    void updateSeferUserId(@Param("newUserId") int newUserId, @Param("userId") int userId);



    
    @Transactional
    @Modifying
    @Query("UPDATE seferler s SET s.BosKoltuk = :BosKoltuk WHERE s.id = :seferId")
    void updateBosKoltuk(@Param("seferId")int seferId,@Param("BosKoltuk") int BosKoltuk);

}
    

