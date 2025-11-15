package modelo;
public class Puerta{
    private boolean abierta=false;
    private boolean sensorBloqueado=false;
    public boolean estaAbierta(){return abierta;}
    public boolean sensorBloqueado(){return sensorBloqueado;}
    public void bloquearSensor(boolean b){sensorBloqueado=b;}
    public void abrir(){abierta=true;}
    public void cerrar(){ if(!sensorBloqueado) abierta=false; }
}