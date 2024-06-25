	package AirlineReservationSystem.AirlineReservationSystem.service.concrates;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.user;
	import AirlineReservationSystem.AirlineReservationSystem.repository.absract.UserRepository;

import java.util.List;
	import java.util.Optional;

import javax.transaction.Transactional;
	
	@Service
	public class UserService {
	
	    private final UserRepository userRepository;
	    @Autowired
	    private static user currentUser;
	    
	    @Autowired
	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	
	    public Optional<user> validateUser(String Tc, String password) {
	        return userRepository.findByTcAndPassword(Tc, password);
	    }
	
	    public List<user> getAllUsers() {
	        return userRepository.findAll();
	    }
	

	    public Optional<user> getUsersById(int Id) {
	        return userRepository.findById(Id);
	    }
	    public List<user> getKullanicilar() {
	        return userRepository.findByTypeCustom("kullanici");
	    }
	
	    public List<user> getYoneticiler() {
	        return userRepository.findByTypeCustom("yonetici");
	    }
	
	    public List<user> getPersoneller() {
	        return userRepository.findByTypeCustom("personel");
	    }
	    public void addUser(user newUser) {
	        userRepository.save(newUser);
	    }
	   
	    
	    @Transactional
	    public void deleteUser(Integer userId) {
	        userRepository.deleteById(userId);
	    }
	   
	    public user updateUser(user updatedUser) {
	        // Veritabanından güncellenecek kullanıcıyı al
	        user existingUser = userRepository.findById(updatedUser.getUserId()).orElse(null);
	        
	  
	        if (existingUser != null) {
	            existingUser.setName(updatedUser.getName());
	            existingUser.setTc(updatedUser.getTc());
	            existingUser.setDate(updatedUser.getDate());
	            existingUser.setPassword(updatedUser.getPassword());
	            existingUser.setSurname(updatedUser.getSurname());
	            
	          
	            return userRepository.save(existingUser);
	        }
	        
	        return null; 
	    }


		public user getCurrentUser() {
			return currentUser;
		}

		public void setCurrentUser(user currentUser) {
			UserService.currentUser = currentUser;
		}

	    
	}
