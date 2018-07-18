/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author MM
 */

public class Room extends Entity{

    /* room sizes */
    public static enum roomSize{SMALL, LARGE, HUGE}
    
    /* room types */
    public static enum roomType{WALL, ENTRANCE, CORRIDOR, SHAFT, HOARD, NEST, STORAGE, QUARTERS, EXTERIOR}
    
    // doors are numbered 0,1,etc, clockwise from top
    // current maximum number of doors is 4    
    public final int MAXDOORS = 4;
    //contents
    //occupants
    protected roomSize size;
    protected roomType type;
    protected SimpleStringProperty description;
    protected Room[] neighbors;
    protected int roomNumber = -1;
    protected int xPos = -1;
    protected int yPos = -1;
    protected SimpleBooleanProperty reachable = new SimpleBooleanProperty(true);
    
    public Room() {
        super();
        size = roomSize.SMALL;
        type = roomType.WALL;
        description = new SimpleStringProperty("Unworked");
        neighbors = new Room[MAXDOORS];
    }
    
    public Room(Room r) {
        super(r);
        size = r.getSize();
        type = r.getType();
        description = new SimpleStringProperty(r.getDescription());
        if(r.getNeighbors() == null || r.getNeighbors().length > MAXDOORS) {
            neighbors = new Room[MAXDOORS];
        }
        else {
            neighbors = r.getNeighbors();
        }
    }
    
    public Room(roomSize initSize, roomType initType, String desc, Room[] neighborhood, String group, int id, String name, 
                String location, ArrayList<Task> initTasks, String idle, ArrayList<Trait> initTraits) {
        
        super(group, id, name, location, initTasks, idle, initTraits);
        size = initSize;
        type = initType;
        description = new SimpleStringProperty(desc);
        if(neighborhood == null || neighborhood.length > MAXDOORS) {
            neighbors = new Room[MAXDOORS];
        }
        else {
            neighbors = neighborhood;
        }
    }

    /**
     * @return the size
     */
    public roomSize getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(roomSize size) {
        this.size = size;
    }

    /**
     * @return the type
     */
    public roomType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(roomType type) {
        this.type = type;
    }

    /**
     * @return the description property
     */
    public SimpleStringProperty getDescriptionProp() {
        return description;
    }

    /**
     * @return the description 
     */
    public String getDescription() {
        return description.get();
    }
    
    /**
     * @param newDesc the description to set
     */
    public void setDescription(String newDesc) {
        description.set(newDesc);
    }

    /**
     * @return the neighbors
     */
    public Room[] getNeighbors() {
        return neighbors;
    }

    /**
     * @param neighbors the neighbors to set
     */
    public void setNeighbors(Room[] neighbors) {
        this.neighbors = neighbors;
    }

    public Room getNorthNeighbor() {
        return neighbors[0];
    }
    
    public void setNorthNeighbor(Room r) {
        neighbors[0] = r;
    }
    
    public Room getEastNeighbor() {
        return neighbors[1];
    }
    
    public void setEastNeighbor(Room r) {
        neighbors[1] = r;
    }
    
    public Room getSouthNeighbor() {
        return neighbors[2];
    }
    
    public void setSouthNeighbor(Room r) {
        neighbors[2] = r;
    }
    
    public Room getWestNeighbor() {
        return neighbors[3];
    }
    
    public void setWestNeighbor(Room r) {
        neighbors[3] = r;
    }
    
    public void matchActive(Entity toMatch) {
        this.busy.set(toMatch.isBusy());
        this.currentTask.setToNewTask(toMatch.getCurrentTask());
        this.taskCompleted.set(toMatch.getTaskCompleted());
        this.taskTimer.set(toMatch.getTaskTimer());
        this.tasks = new ArrayList(toMatch.getTasks());
        this.traits = new ArrayList(toMatch.getTraits());
    }
    
    
    public void matchRoom(Room r) {
        this.matchActive(r);
        this.setRoomNumber(r.getRoomNumber());
        this.setType(r.getType());
        this.setSize(r.getSize());
        this.setDescription(r.getDescription());
        this.setNeighbors(r.getNeighbors());
        this.setxPos(r.getxPos());
        this.setyPos(r.getyPos());
        this.setReachable(r.isReachable());
    }
    
    /**
     * Doesn't copy over neighbors, room number, reachable, or positions
     * @param r 
     */
    public void matchRoomShallow(Room r) {
        this.matchActive(r);
        this.setType(r.getType());
        this.setSize(r.getSize());
        this.setDescription(r.getDescription());        
    }
    
    /**
     * @return the roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    /**
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    
    /**
     * @return the reachable status
     */
    public boolean isReachable() {
        return reachable.get();
    }

    /**
     * @param newReach the reachable status to set
     */
    public void setReachable(boolean newReach) {
        reachable.set(newReach);
    }
    
    /**
     * @return the reachable property
     */
    public SimpleBooleanProperty getReachableProp() {
        return reachable;
    }

}
