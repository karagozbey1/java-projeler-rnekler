package AirlineReservationSystem.AirlineReservationSystem.Helper;

import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.Rezervasyon;
import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ReservationTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<Rezervasyon> reservations;
    private String[] columnNames = {
         "Kullanıcı ID", "Koltuk No", "Rezervasyon Tarihi", "Durum",
        "Kalkış Şehir", "Varış Şehir", "Kalkış Tarihi", "Varış Tarihi", 
        "Uçak Modeli", "Kapasite", "Koltuk Sayısı", "Fiyat"
    };

    public ReservationTableModel(List<Rezervasyon> reservations) {
        this.reservations = reservations;
    }

    @Override
    public int getRowCount() {
        return reservations.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervasyon reservation = reservations.get(rowIndex);
        seferler sefer = reservation.getSeferler(); // Sefer nesnesine ulaşmak için Rezervasyon nesnesinde bir getter olmalı

        switch (columnIndex) {
          
            case 0:
                return reservation.getKullaniciId();
            case 1:
                return reservation.getKoltukNo();
            case 2:
                return reservation.getRezervasyonTarihi();
            case 3:
                return reservation.getDurum();
            case 4:
                return sefer.getKalkisYeri();
            case 5:
                return sefer.getVarisYeri();
            case 6:
                return sefer.getKalkisTarihi();
            case 7:
                return sefer.getVarisTarihi();
            case 8:
                return sefer.getUcakModeli();
            case 9:
                return sefer.getKapasite();
            case 10:
                return sefer.getBosKoltuk();
            case 11:
                return sefer.getFiyat();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Rezervasyon getReservationAt(int rowIndex) {
        return reservations.get(rowIndex);
    }
}
