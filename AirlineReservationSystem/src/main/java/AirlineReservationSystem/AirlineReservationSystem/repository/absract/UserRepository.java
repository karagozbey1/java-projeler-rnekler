package AirlineReservationSystem.AirlineReservationSystem.repository.absract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.user;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<user, Integer> {

    Optional<user> findByTcAndPassword(String Tc, String password);
   
    @Query("SELECT u FROM user u WHERE u.Type = :type")
    List<user> findByTypeCustom(@Param("type") String type);
   
    Optional<user> findById(int id);
    user save(user newUser);
    void deleteById(Integer id);
}
