/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mike
 */

public class Entity {

    /**
     * The Entity's groupName
     */
    protected String groupName;
    
    /**
     * The Entity's id within the group
     */
    protected int idNum;
    
    /**
     * The Entity's name, to be displayed to the player
     */
    protected SimpleStringProperty name;
    
    /**
     * The Entity's badge number, to distinguish it from others with the same groupName and idNum
     * The Engine should keep track of assigning unique badge numbers as it makes new Entitys
     */
    protected int badge = 0;
    
    /**
     * Whether the Entity is busy
     */
    protected SimpleBooleanProperty busy;
    
    /**
     * The Entity's location
     */
    protected SimpleStringProperty location;
    
    /**
     * The Entity's traits
     */
    protected ArrayList<Trait> traits;
    protected ArrayList<Task> tasks;
    protected ArrayList<Flag> flags;
    protected SimpleIntegerProperty taskTimer;
    protected Task currentTask;
    protected SimpleBooleanProperty taskCompleted;
    protected SimpleStringProperty idleText;
    protected GameEnums.TraitMod[] traitDisplayPriority = {GameEnums.TraitMod.ATTRIBUTE, GameEnums.TraitMod.PRODUCTION, 
        GameEnums.TraitMod.COMBAT, GameEnums.TraitMod.FLAVOR};
    
    public Entity() {
        groupName = null;
        idNum = -1;
        name = new SimpleStringProperty("blank");
        busy = new SimpleBooleanProperty(false);
        location = new SimpleStringProperty("nowhere");
        tasks = new ArrayList<Task>();
        taskTimer = new SimpleIntegerProperty(-1);
        currentTask = new Task();
        taskCompleted = new SimpleBooleanProperty(false);
        idleText = new SimpleStringProperty("doing nothing");
        traits = new ArrayList<Trait>();
        flags = new ArrayList<Flag>();
    }
    
    
    /**
     * Please don't give an empty list of tasks
     * @param id
     * @param name
     * @param location
     * @param newTasks 
     * @param idleText 
     * @param traits 
     */
    public Entity(String group, int id, String name, String location, List<Task> newTasks, String idleText, List<Trait> traits) {
        groupName = group;
        idNum = id;
        this.name = new SimpleStringProperty(name);
        this.busy = new SimpleBooleanProperty(false);
        this.location = new SimpleStringProperty(location);        
        setTasks(newTasks);
        taskTimer = new SimpleIntegerProperty(-1);
        currentTask = new Task();
        taskCompleted = new SimpleBooleanProperty(false);
        this.idleText = new SimpleStringProperty(idleText);
        setTraits(traits);
        flags = new ArrayList<Flag>();
    }
    
    public Entity(Entity e) {
        
        if(e == null)   {
            groupName = null;
            idNum = -1;
            name = new SimpleStringProperty("blank");
            busy = new SimpleBooleanProperty(false);
            location = new SimpleStringProperty("nowhere");
            tasks = new ArrayList<Task>();
            taskTimer = new SimpleIntegerProperty(-1);
            currentTask = new Task();
            taskCompleted = new SimpleBooleanProperty(false);
            idleText = new SimpleStringProperty("doing nothing");
            traits = new ArrayList<Trait>();
            flags = new ArrayList<Flag>();
        }
        else            {
            groupName = e.getGroupName();
            idNum = e.getIdNum();
            name = new SimpleStringProperty(e.getName());
            busy = new SimpleBooleanProperty(false);
            location = new SimpleStringProperty(e.getLocation());
            setTasks(e.getTasks());
            taskTimer = new SimpleIntegerProperty(-1);
            currentTask = new Task();
            taskCompleted = new SimpleBooleanProperty(false);
            idleText = new SimpleStringProperty(e.getIdleText());
            setTraits(e.getTraits());
            setFlags(e.getFlags());
        }
       
    }
    
    /**
     * Return a List of the Entity's tasks.
     * @return a List
     */
    public List<Task> getTasks() {
        return tasks;
    }
    
    /**
     * Return a List of the Entity's flags
     * @return 
     */
    public List<Flag> getFlags() {
        return flags;
    }
    
    public void setFlags(List<Flag> newFlags) {
        if(newFlags == null) {
            flags = new ArrayList<Flag>();
        }
        else {
            flags = new ArrayList<Flag>(newFlags);
        }
    }
    
    /**
     * Makes a deep copy of the list of Tasks for this to use
     * @param newTasks 
     */
    public void setTasks(List<Task> newTasks) {
        tasks = new ArrayList<Task>();
        
        if(newTasks != null) {
            for(Task t : newTasks) {
                tasks.add(new Task(t));
            }
        }
    }
    
    /**
     * Makes a deep copy of the list of Traits for this to use
     * @param newTraits 
     */
    public void setTraits(List<Trait> newTraits) {
        traits = new ArrayList<Trait>();
        
        if(newTraits != null) {
            for(Trait t : newTraits) {
                traits.add(new Trait(t));
            }
        }
    }
    
    public void addTask(Task newTask){
        if(newTask != null) {
            tasks.add(newTask);
        }
    }
    
    public void addTasks(List<Task> newTasks) {
        if(newTasks == null) {
            addTask(null);
        }
        else {
            for(Task t : newTasks) {
                addTask(t);
            }
        }
    }
    
    /**
     * Removes a Task. If that Task is the current Task, then the 
     * current Task is set to "no task," and the Entity is marked not busy.
     * @param oldTask 
     */
    public void removeTask(Task oldTask) {
        tasks.remove(oldTask);
        if(currentTask.equals(oldTask)) {
            currentTask.setNoTask();
            this.setNotBusy();
        }       
    }
    
    public SimpleIntegerProperty getTaskTimerProp() {
        return taskTimer;
    }
    
    public int getTaskTimer() {
        return taskTimer.get();
    }
    
    public void setTaskTimer(int newTime) {
        taskTimer.set(newTime);
    }
    
    /**
     * Sets the taskTimer by looking up the duration of the current Task
     */  
    public void setTaskTimerFromCurrentTask() {
        taskTimer.set(currentTask.getDuration());
    }
    
    public Task getCurrentTask() {
        return currentTask;
    }
    
    /**
     * Sets the Entity's current Task, sets its taskTimer from the current Task, marks it as busy, 
     * and taskCompleted to false. If the provided Task is null or is not in the Entity's List of Tasks, no changes are made.
     * 
     * The Entity's taskTimer IS set by this method. 
     * @param t the Task to use
     */
    public void setTaskAndTimer(Task t) {
        
        if(t == null || !tasks.contains(t)) {return;}
        
        currentTask.setToNewTask(t);
        setNotBusy();
        setBusy();
        taskCompleted.set(false);
        setTaskTimerFromCurrentTask();
    }
    
    /**
     * Sets the Entity's current Task, marks it as busy, and taskCompleted to false.
     * The parameter is used as the index of the Entity's List of Tasks.
     * If the given index is outside of the range, no changes are made.
     * 
     * The Entity's taskTimer is NOT set by this method. 
     * Calling setTaskTimerFromCurrentTask() afterwards is recommended.
     * Alternatively, use setTaskAndTimer()
     * @param taskNumber the index of the Entity's Task List
     */
    public void setCurrentTask(int taskNumber) {
        if(taskNumber >= tasks.size() || taskNumber < 0) {return;}
        
        currentTask.setToNewTask(tasks.get(taskNumber));
        setNotBusy();
        setBusy();
        taskCompleted.set(false);
    }
    
    /**
     * Sets the Entity's current Task, marks it as busy, and taskCompleted to false.
     * If the provided Task is null or is not in the Entity's List of Tasks, no changes are made.
     * 
     * The Entity's taskTimer is NOT set by this method. 
     * Calling setTaskTimerFromCurrentTask() afterwards is recommended.
     * Alternatively, use setTaskAndTimer()
     * @param newTask the Task to use
     */
    public void setCurrentTask(Task newTask) {
        
        if(newTask == null || !tasks.contains(newTask)) {return;}
        
        currentTask.setToNewTask(newTask);
        setNotBusy();
        setBusy();
        taskCompleted.set(false);
    }
    
    /**
     * Sets the Entity's current Task, marks it as busy, and taskCompleted to false.
     * If the provided Task is not in the Entity's List of Tasks, it is added to the List beforehand.
     * If the provided Task is null, no changes are made.
     * 
     * The Entity's taskTimer is NOT set by this method. 
     * Calling setTaskTimerFromCurrentTask() afterwards is recommended.
     * Alternatively, use setTaskAndTimer()
     * 
     * @param newTask the Task to use
     */
    public void addAndSetCurrentTask(Task newTask) {
        if(newTask == null) {return;}
        if(!tasks.contains(newTask)) {tasks.add(newTask);}
        
        currentTask.setToNewTask(newTask);
        setNotBusy();
        setBusy();
        taskCompleted.set(false);
    }

    public void matchEntity(Entity toMatch) {
        setGroupName(toMatch.getGroupName());
        setId(toMatch.getIdNum());
        setName(toMatch.getName());
        idleText.set(toMatch.getIdleText());
        busy.set(toMatch.isBusy());
        location.set(toMatch.getLocation());
        currentTask.setToNewTask(toMatch.getCurrentTask());
        taskCompleted.set(toMatch.getTaskCompleted());
        taskTimer.set(toMatch.getTaskTimer());
        setTasks(toMatch.getTasks());
        setTraits(toMatch.getTraits());
        setFlags(toMatch.getFlags());
        traitDisplayPriority = toMatch.getTraitDisplayPriority();
    }
    
    /**
     * Links this entity with another for a task. It's task timer is set to match the task's duration.
     * @param t
     * @param e 
     */
    public void setLinked(Task t, Entity e) {
        currentTask.setLinkTask(t, e);
        setNotBusy();
        setBusy();
        taskCompleted.set(false);
        setTaskTimerFromCurrentTask();
    }
    
    /**
     * @return taskCompleted as a boolean 
     */
    public boolean getTaskCompleted() {
        return taskCompleted.get();
    }
    
    /**
     * @return the Entity's "taskCompleted" property
     */
    public SimpleBooleanProperty getTaskCompletedProp() {
        return taskCompleted;
    }

    /**
     * Sets the Entity's taskCompleted property
     * @param taskStatus 
     */
    public void setTaskCompleted(boolean taskStatus) {
        taskCompleted.set(taskStatus);
    }
    
    /**
     * Presently does nothing!
     */
    public void idle() {
        
    }
    
    /**
     *  Calls idle() and clearTask() if the entity is not busy, or it has a taskTimer < 0. Otherwise, the 
    * taskTimer is decremented. If it reaches zero, completeTask() is called.
     * @param args 
     */
    public void activeUpdate(String[] args) {
        //If it isn't doing anything, move on
        if(!isBusy() || taskTimer.get() < 0) {
            idle();
            clearTask();
            return;
        }
        
        if(taskTimer.get() > 0) {            
            taskTimer.set(taskTimer.get() - 1);
       
            if(taskTimer.get() == 0 && !taskCompleted.get()) {
               completeTask();
               return;
            }
        }       
    }
    
    /**
     * Sets the Entity's taskTimer to zero, leaves currentTask alone, taskCompleted to true, and marks it not busy
     */
    public void completeTask() {
        taskTimer.set(0);
        this.setNotBusy();
        taskCompleted.set(true);
    }
    
    /**
     * Sets the Entity's taskTimer to zero, currentTask to "no task," taskCompleted to false, and marks it not busy
     */
    public void clearTask() {
        taskTimer.set(0);
        currentTask.setNoTask();
        this.setNotBusy();
        taskCompleted.set(false);
    }
     
    /**
     * 
     * @return  the Entity's idle text
     */
    public String getIdleText(){
        return idleText.get();
    }
    
    /**
     * 
     * @return the Entity's idle text SimpleStringProperty
     */
    public SimpleStringProperty getIdleTextProp() {
        return idleText;
    }
    
    public void setIdleText(String newIdle) {
        idleText.set(newIdle);
    }
    
    /**
     * @return the Entity's name as a String
     */
    public String getName() {
        return name.get();
    }
    
    /**
     * @return the Entity's name SimpleStringProperty
     */
    public SimpleStringProperty getNameProp() {
        return name;
    }
    
    public void setName(String newName) {
        name.set(newName);
    }

    /**
     * @return the idNum
     */
    public int getIdNum() {
        return idNum;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.idNum = id;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String group) {
        this.groupName = group;
    }
    
    public int getBadge() {
        return badge;
    }
    
    public void setBadge(int newBadge) {
        badge = newBadge;
    }
    
    /**
     * @return the Entity's "busy" SimpleBooleanProperty
     */
    public SimpleBooleanProperty getBusyProp() {
        return busy;
    }
    
    /**
     * Used to check if the Entity is busy
     * @return true if the Entity is busy
     */
    public boolean isBusy() {
        return busy.get();
    }
    
    /**
     * Set the Entity's status to busy
     */
    public void setBusy() {
        busy.set(true);
    }
    
    /**
     * Set the Entity's status to not busy.
     */
    public void setNotBusy() {
        busy.set(false);
    }
    
    /**
     * @return the Entity's location as a String
     */
    public String getLocation() {
        return location.get();
    }
    
    /**
     * Set the Entity's location to newLocation
     * @param newLocation 
     */
    public void setLocation(String newLocation) {
        location.set(newLocation);
    }
    
    /**
     * @return the Entity's "location" SimpleStringProperty
     */
    public SimpleStringProperty getLocationProp() {
        return location;
    }
    
    /**
     * @return the traits as a List
     */
    public List<Trait> getTraits() {
        return traits;
    }

    /**
     * @return the traitDisplayPriority
     */
    public GameEnums.TraitMod[] getTraitDisplayPriority() {
        return traitDisplayPriority;
    }

    /**
     * @param traitDisplayPriority the traitDisplayPriority to set
     */
    public void setTraitDisplayPriority(GameEnums.TraitMod[] traitDisplayPriority) {
        this.traitDisplayPriority = traitDisplayPriority;
    }
    
    /**
     * If the Trait List already contains the Trait, 
     * it adds their values. If it does not have one, it does nothing. 
     * Negative values are allowed.
     * 
     * @param t
     */
    public void addTraitValue(Trait t) {
        if(t == null) {
            return;
        }
        
        for(Trait current : traits) {
            if(current.equalShallow(t)) {
                current.addToValue(t.getValue());
                return;
            }
        }
    }
    
    /**
     * If the Trait List already contains the Trait, 
     * it subtracts the value of the given Trait. If it does not have one, it does nothing. 
     * Negative values are allowed.
     * 
     * @param t
     */
    public void subtractTraitValue(Trait t) {
        if(t == null) {
            return;
        }
        
        for(Trait current : traits) {
            if(current.equalShallow(t)) {
                current.addToValue(t.getValue() * -1);
                return;
            }
        }
    }
    
    /**
     * If the Trait list already contains the Trait that the given Cost refers to, 
     * it subtracts the Cost's value from that Trait. Otherwise, nothing happens.
     * @param c 
     */
    public void subtractCostValue(Cost c) {
        if(c == null) {
            return;
        }
        
        for(Trait current : traits) {
            if(current.getGroupName().equals(c.getGroupName()) && current.getIdNum() == c.getIdNum()) {
                current.addToValue(c.getValue() * -1);
            }
        }
    }
    
    /**
     * If the Trait list already contains the Trait that the given Cost refers to, 
     * it adds the Cost's value to that Trait. Otherwise, nothing happens.
     * @param c 
     */
    public void addCostValue(Cost c) {
        if(c == null) {
            return;
        }
        
        for(Trait current : traits) {
            if(current.getGroupName().equals(c.getGroupName()) && current.getIdNum() == c.getIdNum()) {
                current.addToValue(c.getValue());
            }
        }
    }
    
    /**
     * Compares Trait t to its list of Traits using Trait.equalShallow
     * @param t
     * @return 
     */
    public boolean hasTrait(Trait t) {
        if(t == null) {
            return false;
        }
        
        for(Trait current : traits) {
            if(current.equalShallow(t)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasTraitName(String traitName) {
        if(traitName == null) {
            return false;
        }
        
        for(Trait current : traits) {
            if(current.getName().equals(traitName)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns a Trait from its Trait list that matches the given one by Trait.equalShallow.
     * Returns null if nothing matches
     * @param t
     * @return 
     */
    public Trait getTrait(Trait t) {
        if(t == null) {
            return null;
        }
        
        for(Trait current : traits) {
            if(current.equalShallow(t)) {
                return current;
            }
        }
        
        return null;
    }
    
    public int getTraitValue(String name) {
        for(Trait t : traits) {
            if(t.getName().equals(name)) {
                return t.getValue();
            }
        }
        return 0;
    }
    
    /**
     * Adds the given trait to the entity. If the Trait List already contains the Trait,
     * it adds their values. If it does not have one, it adds the Trait to the pool.
     * Negative values are allowed.
     * 
     * @param t the Trait
     */
    public void addTrait(Trait t) {
       
        for(Trait current : traits) {
            if(current.equalShallow(t)) {
                current.addToValue(t.getValue());
                return;
            }
        }
        
        traits.add(new Trait(t));
    }
    
    /**
     * Removes the given trait from the Entity, if the Entity has one that has the same name
     * 
     * @param toRemove
     */
    public void removeTrait(Trait toRemove) {
        Trait target = null;
        
        for(Trait t : traits) {
            if(t.getName().equals(toRemove.getName())) {
                target = t;
                break;
            }
        }
        
        if(target != null) {
            traits.remove(target);
        }
    }

    /**
     * Compares Flag f to its list of Flags using Flag.equalShallow
     * @param f
     * @return 
     */
    public boolean hasFlag(Flag f) {
        if(f == null) {
            return false;
        }
        
        for(Flag current : flags) {
            if(current.equalShallow(f)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a Flag from its Flag list that matches the given one by Flag.equalShallow.
     * Returns null if nothing matches
     * @param f
     * @return 
     */
    public Flag getFlag(Flag f) {
        if(f == null) {
            return null;
        }
        
        for(Flag current : flags) {
            if(current.equalShallow(f)) {
                return current;
            }
        }
        
        return null;
    }
    
    /**
     * @return the entity's idle text if it is not busy, and returns it's current task's flavor if it is busy
     */
    public String status() {
        if(isBusy()) {
            return currentTask.getFlavor();
        }
        else {
            return idleText.get();
        }
    }
    
    
    public boolean equalShallow(Entity e) {
        if(e == null)                                           {return false;}
        if(this == e)                                           {return true;}
        
        if(this.getGroupName() == null && e.getGroupName() == null) {
            return this.getIdNum() == e.getIdNum();
        }
        
        return this.getGroupName().equals(e.getGroupName()) && (this.getIdNum() == e.getIdNum());
    }
}
