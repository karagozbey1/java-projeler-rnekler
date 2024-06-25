package AirlineReservationSystem.AirlineReservationSystem.service.concrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;
import AirlineReservationSystem.AirlineReservationSystem.repository.absract.SeferlerRepository;



import java.util.List;

@Service
public class SeferService {
	@Autowired
    private  final SeferlerRepository seferRepository;

     @Autowired
	public SeferService(SeferlerRepository  SeferlerRepository) {
		this.seferRepository = SeferlerRepository;
	  
     }
     


	public void saveSefer(seferler sefer) {
         seferRepository.save(sefer);
    }

    public List<seferler> getAllSeferler() {
        return seferRepository.findAll();
    }

    public List<seferler> getSeferlerByUserId(int userId) {
        return seferRepository.findByPersID (userId);
    }

    public void updateSefer(seferler sefer) {
         seferRepository.save(sefer);
    }


    public List<seferler> getFlightsByEmployeeId(int employeeId) {
        return seferRepository.findByPersID(employeeId);
  
    }

	public void updateSeferUserId(int newUserId, int userId) {
		 seferRepository.updateSeferUserId(newUserId, userId);
		
	}
	public void updateBosKoltuk(int seferId, int BosKoltuk) {
        seferRepository.updateBosKoltuk(seferId, BosKoltuk);
    }

   

}
