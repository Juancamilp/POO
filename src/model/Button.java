package model;
public abstract class Button {
    protected boolean pressed = false;
    protected boolean led = false;
    public void press(){ pressed=true; led=true; }
    public void reset(){ pressed=false; led=false; }
    public boolean isPressed(){ return pressed; }
    public boolean isLedOn(){ return led; }
}