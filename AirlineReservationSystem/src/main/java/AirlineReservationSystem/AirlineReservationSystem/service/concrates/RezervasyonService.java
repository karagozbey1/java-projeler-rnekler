package AirlineReservationSystem.AirlineReservationSystem.service.concrates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.Rezervasyon;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;
import AirlineReservationSystem.AirlineReservationSystem.repository.absract.RezervasyonRepository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RezervasyonService {
private RezervasyonRepository rezervasyonRepository;
	  
    @Autowired
    public RezervasyonService(RezervasyonRepository rezervasyonRepository) {
		super();
		this.rezervasyonRepository = rezervasyonRepository;
	}

	
  
    public List<Rezervasyon> getAllRezervasyonlar() {
        return rezervasyonRepository.findAll();
    }

    public Optional<Rezervasyon> getRezervasyonById(Integer id) {
        return rezervasyonRepository.findById(id);
    }

    public Rezervasyon createRezervasyon(Rezervasyon rezervasyon) {
        return rezervasyonRepository.save(rezervasyon);
    }

    public Rezervasyon updateRezervasyon( Rezervasyon rezervasyon) {
      
       

    	 return  rezervasyonRepository.save(rezervasyon);
       
    }

    public void deleteRezervasyon(Integer id) {
        Optional<Rezervasyon> rezervasyonOptional = rezervasyonRepository.findById(id);
                 
        if (rezervasyonOptional.isPresent()) {
            Rezervasyon rezervasyon = rezervasyonOptional.get();
            rezervasyonRepository.delete(rezervasyon);
        } else {
            throw new RuntimeException("Bu id ile yapılan rezervasyon bulunamadı: " + id);
        }
    }

    public List<Rezervasyon> getRezervasyonlarByKullaniciId(Integer kullaniciId) {
        return rezervasyonRepository.findByKullaniciId(kullaniciId);
    }

    public List<Rezervasyon> getRezervasyonlarBySeferId(Integer seferId) {
        return rezervasyonRepository.findByseferlerSeferId(seferId);
    }
    public List<seferler> findSeferler(String kalkisYeri, String varisYeri, LocalDateTime kalkisTarihi, LocalDateTime varisTarihi, Double fiyat) {
        return rezervasyonRepository.findSeferler(kalkisYeri, varisYeri, kalkisTarihi, varisTarihi, fiyat);
    }
}
