package AirlineReservationSystem.AirlineReservationSystem;

import java.awt.EventQueue;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


import AirlineReservationSystem.AirlineReservationSystem.gui.LoginSystem;

@SpringBootApplication

public class AirlineReservationSystemApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(AirlineReservationSystemApplication.class).headless(false).run(args);
        EventQueue.invokeLater(() -> {
            try {
                LoginSystem frame = context.getBean(LoginSystem.class);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
