public class Camioneta extends Vehiculo {
    private double capacidadCarga;

    public Camioneta(String idVehiculo, String marca, String modelo, int año, double costoDiario, double capacidadCarga) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadCarga = capacidadCarga;
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