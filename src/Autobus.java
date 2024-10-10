public class Autobus extends Vehiculo {
    private int capacidadPasajeros;

    public Autobus(String idVehiculo, String marca, String modelo, int año, double costoDiario, int capacidadPasajeros) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @Override
    public double calculatorPrecious(int dias, boolean seguro, boolean gps) {
        double precio = costoDiario * dias;
        if (seguro) {
            precio += precio * 0.10; // 10% adicional
        }
        if (gps) {
            precio += 5 * dias; // $5 por día
        }
        return precio;
    }
}