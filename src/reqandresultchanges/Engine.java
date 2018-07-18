/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

/**
 *
 * @author Mike
 */
public class Engine {

    protected SimpleListProperty<Trait> global_resources;
    protected CaveController controller;
    protected SimpleListProperty<GameEvent> pendingEvents = new SimpleListProperty();
    protected SimpleListProperty<GameEvent> updateWarnings = new SimpleListProperty();
    protected ArrayList<GameEvent> unresolvedUpdateWarnings = new ArrayList();
    protected PredefinedData defaultData = new PredefinedData();
    protected SimpleIntegerProperty turnCount = new SimpleIntegerProperty(0);
    
    public Engine() {
        this.global_resources = new SimpleListProperty<>(FXCollections.observableArrayList());
        
        //SimpleListProperty will be an empty wrapper if we don't initialize it with something
        ObservableList<GameEvent> pendingEventList = FXCollections.observableArrayList(new ArrayList<GameEvent>());
        this.pendingEvents = new SimpleListProperty<GameEvent>(pendingEventList);
        
        ObservableList<GameEvent> warningsList = FXCollections.observableArrayList(new ArrayList<GameEvent>());
        this.updateWarnings = new SimpleListProperty<GameEvent>(warningsList);
    }
    
    /**
     * @return the global resource pool
     */
    public SimpleListProperty<Trait> getGlobalResources() {
        return global_resources;
    }
    
    /**
     * Adds the given resource to the global pool. If the global resource pool already contains a resource Trait with the 
     * same name, it adds their values. If it does not have one, it makes a new resource Trait with the value and description. 
     * Negative values are allowed.
     * 
     * @param name the name of the resource
     * @param value the value of the resource
     * @param desc the description of the resource
     */
    public void addResource(String name, int value, String desc) {
        
        for(Trait res : global_resources) {
            if(res.getName().equals(name)) {
                res.addToValue(value);
                return; //return if we found the resource in the pool
            }
        }
        
        EnumSet<Trait.trait_type> traitTypes = EnumSet.of(Trait.trait_type.RESOURCE);
        global_resources.get().add(new Trait(name, value, desc, traitTypes));
    }
    
    /**
     * Adds the given resource to the global pool. If the global resource pool already contains a resource Trait with the 
     * same name, it adds their values. If it does not have one, it adds the Trait to the pool.
     * Negative values are allowed.
     * 
     * @param t the resource
     */
    public void addResource(Trait t) {
        addResource(t.getName(), t.getValue(), t.getDesc());
    }
    
    /**
     * @return a String representation of the global resources' names and values
     */
    public String resourcesReport() {
        String[] result = new String[global_resources.size()];
        
        for(int i = 0; i < result.length; i++) {
            result[i] = global_resources.get(i).getName() + ": " + global_resources.get(i).getValue();
        }
        
        return String.join("\n", result);
    }
    
    /**
     * @return a String representation of the global resources' names, values, and descriptions
     */
    public String resourcesReportDesc() {
        String[] result = new String[global_resources.size()];
        
        for(int i = 0; i < result.length; i++) {
            result[i] = global_resources.get(i).getName() + ": " + global_resources.get(i).getValue() + " --- " + global_resources.get(i).getDesc();
        }
        
        return String.join("\n", result);
    }

    /**
     * @return the controller
     */
    public CaveController getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(CaveController controller) {
        this.controller = controller;
    }
    
    public int getTurnCount() {
        return turnCount.get();
    }
    
    public void setTurnCount(int newTurnCount) {
        turnCount.set(newTurnCount);
    }
    
    public void incrementTurnCount() {
        turnCount.set(turnCount.get() + 1);
    }
    
    public SimpleIntegerProperty getTurnCountProp() {
        return turnCount;
    }
    
    public SimpleListProperty<GameEvent> getPendingEvents() {
        return pendingEvents;
    }
    
    public void setPendingEvents(ArrayList<GameEvent> newPending) {
        pendingEvents.set(FXCollections.observableArrayList(newPending));
    }
    
    public SimpleListProperty<GameEvent> getUpdateWarnings() {
        return updateWarnings;
    }
    
    public void setUpdateWarnings(ArrayList<GameEvent> newWarnings) {
        updateWarnings.set(FXCollections.observableArrayList(newWarnings));
    }
    
    public ArrayList<GameEvent> getUnresolvedUpdateWarnings() {
        return unresolvedUpdateWarnings;
    }
    
    /**
     * Calls TraitEvaluator.resourcesFromGroup(this.getGlobalResources(), this.getActiveEntities()) and
     * then loops through the ActiveEntities and updates them and checks for a completed task. The results
     * of completed tasks are added to the global resources using addResource(name, value) if they are not personal resources.
     * If they are personal resources, it uses addResource(trait.getName(), trait.getValue()).
     * If any of the completed Tasks have trait_type.CREATION results, they are processed.
     * If any of the completed Tasks have trait_type.ROOM_CHANGE results, they are processed.
     * Then it does all this for Rooms. 
     * Then it checks all the GameEvents in timedEvents and untimedEvents.
     * Finally, it increments the turnCount.
     * 
     * Engines that want more or different behavior should override this. Most Engines can begin their
     * version of update() with super() or just copy the previous line of code.
     */
    public void update() {
//        traitEval.resourcesFromGroup(this.getGlobalResources(), this.getActiveEntities());
        
        ArrayList<Entity> entitiesToAdd = new ArrayList();
        ArrayList<String> IDsToRemove = new ArrayList();
        HashMap<Entity,Task> activesToChange = new HashMap();
        ArrayList<Room> roomsToChange = new ArrayList();
        
        for(Entity e : this.getEntities()) {
            e.activeUpdate(null);
            /*
            if(e.getTaskCompleted()) {
                boolean changeSelf = false;
                
                for(Trait result : e.getCurrentTask().getResults()) {
                    // Check for personal resources
                    if(TraitEvaluator.isPResourceTrait(result)) {
                        e.addTrait(result);
                    }
                    // Check for creating new ActiveEntities
                    else if(TraitEvaluator.isCreationTrait(result)) {
                        for(int i = 0; i < result.getValue(); i++) {
                            ActiveEntity newlyMade;
                            newlyMade = builder.makeEntity(result.getName(), null);
                            
                            entitiesToAdd.add(newlyMade);
                        }
                    }
                    // Check for changing self
                    else if(TraitEvaluator.isActiveChangeTrait(result)) {
                        changeSelf = true;
                    }
                    // Check for changing others
                    else if(TraitEvaluator.isActiveChangeOther(result)) {
                        for(Active a : getLinkedActives(e)) {
                            if(a instanceof ActiveEntity) {
                                activesToChange.put((ActiveEntity)a, e.getCurrentTask());
                            }
                        }
                    }                                        
                    // Check for changing Rooms
                    else if(TraitEvaluator.isRoomChangeTrait(result)) {
                        System.out.println("Looks like we're making a room!");
                    }
                    // Check for resources
                    else if(TraitEvaluator.isResourceTrait(result)) {
                        this.addResource(result.getName(), result.getValue(), result.getDesc());
                    }
                    // Check for removing things
                    else if(TraitEvaluator.isUncreateTrait(result)) {
                        IDsToRemove.add(result.getName());
                    }     
                } // end of looping through the Task's results
                
                unlinkAllActives(e);
                
                if(changeSelf) {
                    changeActiveEntity(e, e.getCurrentTask());
                }
                else {
                    e.clearTask();
                }
            }// End of if taskcompleted
            */
        }// End of for each ActiveEntity loop
        
        // Add any created things
        for(Entity justCreated : entitiesToAdd) {
            Task autoTask = this.getAutoTask(justCreated);
                
            if(autoTask != null) {
                justCreated.setTaskAndTimer(autoTask);
            }
            
            controller.addEntity(justCreated);
        }
        
        // Remove any removed things
        for(String id : IDsToRemove) {
            controller.removeByID(id);
        }
        
        // Change others
        for(Entity toChange : activesToChange.keySet()) {
            changeEntity(toChange, activesToChange.get(toChange));
        }
        
        entitiesToAdd.clear();
        IDsToRemove.clear();
        activesToChange.clear();
        roomsToChange.clear();
        //InactiveEntities ?
        
        //Rooms
        for(Room r : this.getRooms()) {
  /*          r.activeUpdate(null);
            
            if(r.getTaskCompleted()) {
                boolean changeRoom = false;
                
                for(Trait result : r.getCurrentTask().getResults()) {
                    // Check for personal resources
                    if(TraitEvaluator.isPResourceTrait(result)) {
                        r.addTrait(result);
                    }
                    // Check for creating new ActiveEntities
                    else if(TraitEvaluator.isCreationTrait(result)) {
                        ActiveEntity newlyMade;
                        newlyMade = builder.makeEntity(result.getName(), null);
                            
                            
                        entitiesToAdd.add(newlyMade);
                    }
                    // Check for changing Rooms
                    else if(TraitEvaluator.isRoomChangeTrait(result)) {
                        roomsToChange.add(r);
                        changeRoom = true;
                    }
                    // Check for resources
                    else if(TraitEvaluator.isResourceTrait(result)) {
                        this.addResource(result.getName(), result.getValue(), result.getDesc());
                    }
                    else if(TraitEvaluator.isUncreateTrait(result)) {
                        IDsToRemove.add(result.getName());
                    }     
                }
                
                unlinkAllActives(r);
                if(changeRoom)
                {
                    changeRoom(r, r.getCurrentTask());
                }
            }// End of if taskcompleted
            */
        }// End of for each Room loop
        
        
        // Add any created things
        for(Entity justCreated : entitiesToAdd) {
            Task autoTask = this.getAutoTask(justCreated);
                System.out.println("Engine thinks " + justCreated.getName() + " has # tasks " + justCreated.getTasks().size());
            if(autoTask != null) {
                
                System.out.println("Engine thinks " + justCreated.getName() + " has auto task " + autoTask.getName());
                justCreated.setTaskAndTimer(autoTask);
            }
            controller.addEntity(justCreated);
        }
        
        // Remove any removed things
        for(String id : IDsToRemove) {
            controller.removeByID(id);
        }
        
        incrementTurnCount();
    }
    
    public boolean isEventReady(GameEvent e) {
        if(e == null || turnCount.get() < e.getTargetTurn() || e.getRequirements() == null) {
            return false;
        }
        
        for(Requirement r : e.getRequirements()) {
            if(!requirementMet(r, null)) {
                return false;
            }
        }
        
        //check for randomness
        if(e.getTurnsMissed() < e.getOddsTail() && Math.random() > e.getOddsToOccur()) {
            return false;
        }
        
        return true;
    }
    
    public void processEventResults(GameEvent e) {
        ArrayList<Entity> entitiesToAdd = new ArrayList();
        ArrayList<String> IDsToRemove = new ArrayList();
        HashMap<Entity,Task> activesToChange = new HashMap();
        ArrayList<Room> roomsToChange = new ArrayList();
        /*
        for(Trait result : e.getResults()) {
            if(TraitEvaluator.isCreationTrait(result)) {
                for(int i = 0; i < result.getValue(); i++) {
                    ActiveEntity newlyMade;
                    newlyMade = builder.makeEntity(result.getName(), null);

                    entitiesToAdd.add(newlyMade);
                }
            }                                        
            // Check for changing Rooms
            else if(TraitEvaluator.isRoomChangeTrait(result)) {
                System.out.println("Looks like we're making a room!");
            }
            // Check for resources
            else if(TraitEvaluator.isResourceTrait(result)) {
                this.addResource(result.getName(), result.getValue(), result.getDesc());
            }
            // Check for removing things
            else if(TraitEvaluator.isUncreateTrait(result)) {
                IDsToRemove.add(result.getName());
            }     
        } // end of looping through the Task's results
                
        // Add any created things
        for(ActiveEntity justCreated : entitiesToAdd) {
            Task autoTask = this.getAutoTask(justCreated);
                
            if(autoTask != null) {
                justCreated.setTaskAndTimer(autoTask);
            }
            
            controller.addActive(justCreated);
        }
        
        // Remove any removed things
        for(String id : IDsToRemove) {
            controller.removeByID(id);
        }
        
        // Change others, not currently used
        for(ActiveEntity toChange : activesToChange.keySet()) {
            changeActiveEntity(toChange, activesToChange.get(toChange));
        }
        */
    }
    
    public void checkUpdateWarnings() {
        unresolvedUpdateWarnings.clear();
        
        for(GameEvent warning : updateWarnings) {
            if(warning.isSuppressed()) {
                continue;
            }
            
            for(Requirement req : warning.getRequirements()) {
                if(!requirementMet(req, null)) {
                    unresolvedUpdateWarnings.add(warning);
                    break; // move to next warning
                }
            }
        }
    }
    
    public void checkUnskippableWarnings() {
        unresolvedUpdateWarnings.clear();
        
        for(GameEvent warning : updateWarnings) {
            if(warning.isSkippable()) {
                continue;
            }
            
            for(Requirement req : warning.getRequirements()) {
                if(!requirementMet(req, null)) {
                    unresolvedUpdateWarnings.add(warning);
                    break; // move to next warning
                }
            }
        }
    }
    
    /**
     * Returns the first Task found that has the AUTOTASK modifier
     * Returns null if it doesn't have an auto task
     * @param e
     * @return 
     */
    public Task getAutoTask(Entity e) {
        // Check for auto task
        for(Task t : e.getTasks()) {
            if(t.getModifiers().contains(GameEnums.TaskMod.AUTOTASK)) {
                return t;
            }
        }
        return null;
    }
    
    /**
     * Returns true if the current Task of e is UNCANCELABLE
     * @param e
     * @return 
     */
    public boolean currentUncancelableTask(Entity e) {
        return e.getCurrentTask().getModifiers().contains(GameEnums.TaskMod.UNCANCELABLE);
    }
    
    /**
     * Cancels the current Task of the given Active, refunds any costs it had, and unlinks the 
     * Active to any others it had been linked too. It calls clearTask() for each of them.
     * @param e 
     */
    public void cancelTaskRefundCosts(Entity e) {
        Task t = e.getCurrentTask();
        
        for(Trait cost : t.getCosts()) {
            if(TraitEvaluator.isPResourceTrait(cost)) {
                e.addTraitValue(cost.getName(), cost.getValue() * -1);
            }
            else {
                this.addResource(cost.getName(), cost.getValue() * -1, cost.getDesc());
            }
        }
        
        e.clearTask();
        HashSet<Entity> removed = unlinkAllEntities(e);
        for(Entity link : removed) {
            link.clearTask();
        }
    }
    
    
    /**
     * Calls e.setTaskAndTimer(t), then evaluates the costs of t. Resource costs are added to the global
     * resource pool, and personal resources to Active e.
     * @param t the chosen Task
     * @param e the Active to do the Task
     */
    public void setTaskPayCosts(Task t, Entity e) {
        e.setTaskAndTimer(t);
        
        for(Trait cost : t.getCosts()) {
            if(TraitEvaluator.isPResourceTrait(cost)) {
                e.addTrait(cost);
            }
            else {
                this.addResource(cost);
            }
        }
    }
    
    public int getResourceValue(String name) {
        for(Trait resource : global_resources) {
            if(resource.getName().equalsIgnoreCase(name)) {
                return resource.getValue();
            }
        }
        return 0;
    }
    
    public int getEntityCount(String group, int id) {
        int count = 0;
        
        for(Entity entity : getEntities()) {
            
            if(entity.getGroupName().equalsIgnoreCase(group) && entity.getIdNum() == id) {
                count++;
            }
            
        }
        
        return count;
    }
    
    public int getFreeEntityCount(String group, int id) {
        int count = 0;
        
        for(Entity entity : getEntities()) {
            if(entity.isBusy()) {
                continue;
            }
            
            if(entity.getGroupName().equalsIgnoreCase(group) && entity.getIdNum() == id) {
                count++;
            }
            
        }
        
        return count;
    }
    
    public int getEntityCountByName(String name) {
        int count = 0;
        
        for(Entity entity : getEntities()) {
            if(entity.getName().equalsIgnoreCase(name)) {
                count++;
            }
        }
        
        return count;
    }
    
    public int getFreeEntityCountByName(String name) {
        int count = 0;
        
        for(Entity entity : getEntities()) {
            if(entity.isBusy()) {
                continue;
            }
            
            if(entity.getName().equalsIgnoreCase(name)) {
                    count++;
            }
        }
        
        return count;
    }
    
    public int getRoomCount(String group, int id) {
        int count = 0;
        
        for(Room r : getRooms()) {
            if(r.getGroupName().equalsIgnoreCase(group) && r.getIdNum() == id) {
                count++;
            }
        }
        
        return count;
    }
    
    public int getRoomCountByName(String name) {
        int count = 0;
        
        for(Room r : getRooms()) {
            if(r.getName().equalsIgnoreCase(name)) {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Returns true if given a null or an invalid requirement
     * @param req
     * @param e
     * @return 
     */
    public boolean requirementMet(Requirement req, Entity e) {
        if(req == null) {
            return true;
        }
        
        GameEnums.RelOp condition = req.getOperator();
        if(condition == null) {

            return false;
        }
    
        switch(condition) {
            case EQUAL:         return equalToReqMet(req, e);

            case NOTEQUAL:  return notEqualReqMet(req, e);
            
            case LESS:           return lessThanReqMet(req, e);
            
            case GREATER:    return greaterThanReqMet(req, e);
        }
        
        //Shouldn't happen, but who knows
        return true;
    }
    
    public boolean requirementsAllMet(Task t, Entity e) {
    //if there are no requirements, then true
        if(t.getRequirements().isEmpty()) {
            return true;
        }
            
        for(Requirement req : t.getRequirements()) {
            if(!requirementMet(req, e)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean equalToReqMet(Requirement req, Entity e) {
        switch(req.getGameElement()) {
            case ENTITY:
            case TRAIT:  
            case GLOBAL_TRAIT:  
            case FLAG:
            case GLOBAL_FLAG:
            default: return false;
        }
    }
    
    public boolean notEqualReqMet(Requirement req, Entity e) {
        switch(req.getGameElement()) {
            default: return false;
        }
    }
    
    public boolean lessThanReqMet(Requirement req, Entity e) {
        switch(req.getGameElement()) {
            default: return false;
        }
    }
    
    public boolean greaterThanReqMet(Requirement req, Entity e) {
        switch(req.getGameElement()) {
            default: return false;
        }
    }
    
    public PredefinedData getPredefinedData() {
        return defaultData;
    }
    
    public void addRoom(Room r) {
        return;
    }
    
    public List<Room> getRooms() {
        return null;
    }
    
    public List<Room> getReachableRooms() {
        return null;
    }
    
    public void setReachable(int pos, boolean reachable) {
        return;
    }
    
    public void setRooms(List<Room> newRooms) {
        return;
    }
    
    public void setRoom(Room r, int pos) {
        return;
    }
    
    public void setRoomEmpty(Room r) {
        return;
    }
    
    public void removeRoom(Room r) {
        return;
    }
    
    public void changeRoom(Room r, Task t) {
        return;
    }
    
    public void changeEntity(Entity e, Task t) {
        return;
    }
    
    public void addEntity(Entity e) {
        return;
    }
    
    public List<Entity> getEntities() {
        return null;
    }
    
    public void setEntities(List<Entity> newEntities) {
        return;
    }
    
    public void removeEntity(Entity e) {
        return;
    }
    
    public void linkEntities(Entity e1, Entity e2) {
        return;
    }
    
    public boolean areLinked(Entity e1, Entity e2) {
        return false;
    }
    
    public void unlinkActives(Entity e1, Entity e2) {
        return;
    }
    
    public HashSet<Entity> unlinkAllEntities(Entity e1) {
        return null;
    }
    
    public HashSet<Entity> getLinkedEntity(Entity e) {
        return null;
    }
    
    public boolean isLinked(Entity e) {
        return false;
    }
}
