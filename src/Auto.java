public class Auto extends Vehiculo {
    private String tipoCombustible;

    public Auto(String idVehiculo, String marca, String modelo, int año, double costoDiario, String tipoCombustible) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.tipoCombustible = tipoCombustible;
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