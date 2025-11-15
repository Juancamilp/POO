import system.ElevatorSystem;
import model.FloorButton;
public class Main{
    public static void main(String[] a)throws Exception{
        ElevatorSystem sys=new ElevatorSystem(6,0);
        sys.pressFloorButton(3, FloorButton.Direction.DOWN);
        sys.pressFloorButton(5, FloorButton.Direction.DOWN);
        for(int i=0;i<10;i++) sys.step();
        ElevatorSystem sys2=new ElevatorSystem(8,4);
        sys2.pressFloorButton(6, FloorButton.Direction.DOWN);
        sys2.pressCabinButton(2);
        for(int i=0;i<12;i++) sys2.step();
    }
}