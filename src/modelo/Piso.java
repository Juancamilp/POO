package modelo;
public class Piso{
    private final int numero;
    private final BotonPiso botonSubir;
    private final BotonPiso botonBajar;
    public Piso(int numero,boolean tieneSubir,boolean tieneBajar){
        this.numero=numero;
        botonSubir= tieneSubir? new BotonPiso(BotonPiso.Direccion.SUBIR): null;
        botonBajar= tieneBajar? new BotonPiso(BotonPiso.Direccion.BAJAR): null;
    }
    public int getNumero(){return numero;}
    public BotonPiso getBotonSubir(){return botonSubir;}
    public BotonPiso getBotonBajar(){return botonBajar;}
}