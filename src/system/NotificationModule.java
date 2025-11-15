package system;
public class NotificationModule{
    public void notify(String msg){System.out.println("[NOTIFY] "+msg);}
    public void reportFault(String msg){System.err.println("[FAULT] "+msg);}
}