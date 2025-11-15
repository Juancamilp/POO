package model;
public class Floor{
    private final int number;
    private final FloorButton upButton;
    private final FloorButton downButton;
    public Floor(int number, boolean hasUp, boolean hasDown){
        this.number=number;
        this.upButton= hasUp? new FloorButton(FloorButton.Direction.UP): null;
        this.downButton= hasDown? new FloorButton(FloorButton.Direction.DOWN): null;
    }
    public int getNumber(){return number;}
    public FloorButton getUpButton(){return upButton;}
    public FloorButton getDownButton(){return downButton;}
}