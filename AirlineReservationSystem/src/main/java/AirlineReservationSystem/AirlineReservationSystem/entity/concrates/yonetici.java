// Yonetici.java
package AirlineReservationSystem.AirlineReservationSystem.entity.concrates;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
 @Component
@DiscriminatorValue("yonetici")
public class yonetici extends user {
    // Yönetici sınıfının diğer alanları ve metotları
}
