package AirlineReservationSystem.AirlineReservationSystem.Helper;

import AirlineReservationSystem.AirlineReservationSystem.entity.concrates.seferler;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class FlightTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<seferler> flights;
    private String[] columnNames = {"Sefer ID","kullaniciID", "Kalkış Yeri", "Varış Yeri", "Kalkış Tarihi", "Varış Tarihi"};

    public FlightTableModel(List<seferler> flights) {
        this.flights = flights;
    }

    @Override
    public int getRowCount() {
        return flights.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        seferler flight = flights.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return flight.getSeferId();
            case 1:
                return flight.getKalkisYeri();
            case 2:
                return flight.getVarisYeri();
            case 3:
                return flight.getKalkisTarihi();
            case 4:
                return flight.getVarisTarihi();
            case 5:
            	return flight.getFiyat();
            	default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public seferler getFlightAt(int rowIndex) {
        return flights.get(rowIndex);
    }
}
