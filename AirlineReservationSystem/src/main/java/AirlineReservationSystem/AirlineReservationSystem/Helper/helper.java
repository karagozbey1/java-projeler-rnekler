package AirlineReservationSystem.AirlineReservationSystem.Helper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import javax.swing.JOptionPane;



public class helper {
	
//hata mesajı için kullanılır	
public void massege(String str ) {
	String massege;
	switch (str) {
	case "fill": {
		massege="lütfen tüm alanları doldurunuz";
		break;
	}
	default:
		massege=str;
	}
 JOptionPane.showMessageDialog(null, massege,"mesaj",JOptionPane.INFORMATION_MESSAGE);
}



//tarih dönüşümü için kullanılır
public static Date convert(String str) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date utilDate = null;
    try {
        utilDate = dateFormat.parse(str);
    } catch (ParseException e) {
        e.printStackTrace();
        return null; // Eğer ayrıştırma başarısız olursa null döndür
    }

    if (utilDate != null) {
        return new Date(utilDate.getTime());
    } else {
        return null;
    }

}



public static LocalDateTime convertTime(String str) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss");
    try {
        return LocalDateTime.parse(str, formatter);
    } catch (DateTimeParseException e) {
        e.printStackTrace();
        return null;
    }


}


public static String randomKoltukNoUret(int ucakKapasitesi) {
    Random random = new Random();
  
    int koltukNoIndex = random.nextInt(ucakKapasitesi);
    // Koltuk numarasını oluştur
    char koltukHarf = (char) ('A' + koltukNoIndex / 6);
    int koltukNoNumara = (koltukNoIndex % 6) + 1; 
    return String.valueOf(koltukHarf) + koltukNoNumara;
}

}