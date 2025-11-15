package sistema;
public class ModuloNotificaciones{
    public void notificar(String m){System.out.println("[INFO] "+m);}
    public void reportarFalla(String m){System.err.println("[ERROR] "+m);}
}