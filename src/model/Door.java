package model;
public class Door{
    private boolean open=false;
    private boolean sensorBlocked=false;
    public boolean isOpen(){return open;}
    public boolean isSensorBlocked(){return sensorBlocked;}
    public void setSensorBlocked(boolean b){sensorBlocked=b;}
    public void open(){open=true;}
    public void close(){ if(!sensorBlocked) open=false; }
}