package modelo;
public abstract class Boton{
    protected boolean presionado=false;
    protected boolean luzEncendida=false;
    public void presionar(){presionado=true; luzEncendida=true;}
    public void reiniciar(){presionado=false; luzEncendida=false;}
    public boolean estaPresionado(){return presionado;}
    public boolean luzEncendida(){return luzEncendida;}
}