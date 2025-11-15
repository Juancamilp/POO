package modelo;
import java.util.*;
public class Ascensor{
    public enum Direccion{SUBIR,BAJAR,QUIETO}
    private final int id;
    private int pisoActual;
    private Direccion direccion=Direccion.QUIETO;
    private final NavigableSet<Integer> destinos=new TreeSet<>();
    private final Puerta puerta=new Puerta();
    public Ascensor(int id,int inicial){this.id=id; this.pisoActual=inicial;}
    public int getPisoActual(){return pisoActual;}
    public Direccion getDireccion(){return direccion;}
    public Puerta getPuerta(){return puerta;}
    public void solicitarPiso(int piso){
        if(piso==pisoActual)return;
        destinos.add(piso);
        if(direccion==Direccion.QUIETO)
            direccion= piso>pisoActual? Direccion.SUBIR: Direccion.BAJAR;
    }
    public void paso(){
        if(destinos.isEmpty()){direccion=Direccion.QUIETO; return;}
        if(direccion==Direccion.SUBIR)pisoActual++;
        else if(direccion==Direccion.BAJAR)pisoActual--;
        if(destinos.contains(pisoActual)){
            puerta.abrir();
            destinos.remove(pisoActual);
            puerta.cerrar();
        }
        if(direccion==Direccion.SUBIR){
            if(destinos.tailSet(pisoActual+1).isEmpty())
                direccion= destinos.isEmpty()? Direccion.QUIETO: Direccion.BAJAR;
        }else if(direccion==Direccion.BAJAR){
            if(destinos.headSet(pisoActual).isEmpty())
                direccion= destinos.isEmpty()? Direccion.QUIETO: Direccion.SUBIR;
        }
    }
}