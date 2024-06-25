// Kullanici.java
package AirlineReservationSystem.AirlineReservationSystem.entity.concrates;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("kullanici")
public class kullanici extends user {


}
