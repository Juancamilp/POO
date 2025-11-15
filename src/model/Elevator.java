package model;
import java.util.*;
public class Elevator{
    public enum Direction{UP,DOWN,IDLE}
    private final int id;
    private int currentFloor;
    private Direction direction=Direction.IDLE;
    private final NavigableSet<Integer> destinations=new TreeSet<>();
    private final Door door=new Door();
    public Elevator(int id,int initial){this.id=id; this.currentFloor=initial;}
    public int getCurrentFloor(){return currentFloor;}
    public Direction getDirection(){return direction;}
    public Door getDoor(){return door;}
    public void requestFloor(int floor){
        if(floor==currentFloor)return;
        destinations.add(floor);
        if(direction==Direction.IDLE)
            direction= floor>currentFloor? Direction.UP: Direction.DOWN;
    }
    public void step(){
        if(destinations.isEmpty()){direction=Direction.IDLE; return;}
        if(direction==Direction.UP) currentFloor++;
        else if(direction==Direction.DOWN) currentFloor--;
        if(destinations.contains(currentFloor)){
            door.open(); destinations.remove(currentFloor); door.close();
        }
        if(direction==Direction.UP){
            if(destinations.tailSet(currentFloor+1).isEmpty())
                direction= destinations.isEmpty()? Direction.IDLE: Direction.DOWN;
        }else if(direction==Direction.DOWN){
            if(destinations.headSet(currentFloor).isEmpty())
                direction= destinations.isEmpty()? Direction.IDLE: Direction.UP;
        }
    }
}