package AirlineReservationSystem.AirlineReservationSystem.service.concrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.Sehir;
import AirlineReservationSystem.AirlineReservationSystem.repository.absract.SehirRepository;
import java.util.List;
@Service
public class SehirService {

    private final SehirRepository sehirRepository;

    @Autowired
    public SehirService(SehirRepository sehirRepository) {
        this.sehirRepository = sehirRepository;
    }

    public String getCityNameById(int sehirID) {
        return sehirRepository.findCityNameById(sehirID);
    }

    public List<Sehir> getAllSehirler() {
        return sehirRepository.getAllSehirler();
    }
}