import sistema.SistemaAscensores;
import modelo.BotonPiso;
public class Principal{
    public static void main(String[]a){
        SistemaAscensores s1=new SistemaAscensores(6,0);
        s1.presionarBotonPiso(3,BotonPiso.Direccion.BAJAR);
        s1.presionarBotonPiso(5,BotonPiso.Direccion.BAJAR);
        for(int i=0;i<10;i++)s1.paso();
        SistemaAscensores s2=new SistemaAscensores(8,4);
        s2.presionarBotonPiso(6,BotonPiso.Direccion.BAJAR);
        s2.presionarBotonCabina(2);
        for(int i=0;i<12;i++)s2.paso();
    }
}