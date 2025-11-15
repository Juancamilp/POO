package modelo;
public class BotonPiso extends Boton{
    public enum Direccion{SUBIR,BAJAR}
    private final Direccion direccion;
    public BotonPiso(Direccion d){this.direccion=d;}
    public Direccion getDireccion(){return direccion;}
}