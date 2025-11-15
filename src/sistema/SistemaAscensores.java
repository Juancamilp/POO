package sistema;
import modelo.*;
import java.util.*;
public class SistemaAscensores{
    private final List<Piso> pisos=new ArrayList<>();
    private final Ascensor ascensor;
    private final ModuloNotificaciones notificador;
    public SistemaAscensores(int cantidad,int inicial){
        for(int i=0;i<cantidad;i++){
            boolean subir=i<cantidad-1;
            boolean bajar=i>0;
            pisos.add(new Piso(i,subir,bajar));
        }
        ascensor=new Ascensor(1,inicial);
        notificador=new ModuloNotificaciones();
    }
    public void presionarBotonPiso(int piso,BotonPiso.Direccion d){
        if(piso<0||piso>=pisos.size()){notificador.reportarFalla("Piso inválido "+piso);return;}
        Piso p=pisos.get(piso);
        if(d==BotonPiso.Direccion.SUBIR){
            if(p.getBotonSubir()==null){notificador.reportarFalla("No subir en "+piso);return;}
            p.getBotonSubir().presionar();
        }else{
            if(p.getBotonBajar()==null){notificador.reportarFalla("No bajar en "+piso);return;}
            p.getBotonBajar().presionar();
        }
        ascensor.solicitarPiso(piso);
        notificador.notificar("Solicitud en piso "+piso+" dir "+d);
    }
    public void presionarBotonCabina(int piso){
        ascensor.solicitarPiso(piso);
        notificador.notificar("Destino cabina "+piso);
    }
    public void paso(){
        ascensor.paso();
        System.out.println("Ascensor en piso "+ascensor.getPisoActual()+" dir "+ascensor.getDireccion());
    }
}