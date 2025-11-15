package model;
public class FloorButton extends Button {
    public enum Direction{UP,DOWN}
    private final Direction direction;
    public FloorButton(Direction d){this.direction=d;}
    public Direction getDirection(){return direction;}
}