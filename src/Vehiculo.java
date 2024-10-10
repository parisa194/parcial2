public abstract class Vehiculo {
    protected String idVehiculo;
    protected String marca;
    protected String modelo;
    protected int año;
    protected double costoDiario;
    protected boolean disponibilidad;

    public Vehiculo(String idVehiculo, String marca, String modelo, int año, double costoDiario) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.costoDiario = costoDiario;
        this.disponibilidad = true;
    }

    public abstract double calculatorPrecious(int dias, boolean seguro, boolean gps);

    public void reservar() {
        this.disponibilidad = false;
    }

    public void liberar() {
        this.disponibilidad = true;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "idVehiculo='" + idVehiculo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", costoDiario=" + costoDiario +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
}