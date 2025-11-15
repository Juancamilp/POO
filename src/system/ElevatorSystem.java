package system;
import model.*;
import java.util.*;
public class ElevatorSystem{
    private final List<Floor> floors=new ArrayList<>();
    private final Elevator elevator;
    private final NotificationModule notifier;
    public ElevatorSystem(int numFloors,int initial){
        for(int i=0;i<numFloors;i++){
            boolean hasUp=i<numFloors-1;
            boolean hasDown=i>0;
            floors.add(new Floor(i,hasUp,hasDown));
        }
        elevator=new Elevator(1,initial);
        notifier=new NotificationModule();
    }
    public void pressFloorButton(int f, FloorButton.Direction dir){
        if(f<0||f>=floors.size()){ notifier.reportFault("Floor out: "+f); return;}
        Floor fl=floors.get(f);
        if(dir==FloorButton.Direction.UP){
            if(fl.getUpButton()==null){ notifier.reportFault("No UP"); return;}
            fl.getUpButton().press();
        }else{
            if(fl.getDownButton()==null){ notifier.reportFault("No DOWN"); return;}
            fl.getDownButton().press();
        }
        elevator.requestFloor(f);
        notifier.notify("Call at floor "+f+" dir "+dir);
    }
    public void pressCabinButton(int f){
        elevator.requestFloor(f);
        notifier.notify("Cabin dest: "+f);
    }
    public void step(){
        elevator.step();
        System.out.println("Elevator at floor "+elevator.getCurrentFloor()+" direction "+elevator.getDirection());
    }
}