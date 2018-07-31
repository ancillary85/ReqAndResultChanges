/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;

/**
 *
 * @author Mike
 */
public class Engine {
    
    protected LinkedHashSet<Entity> entities;
    protected ArrayList<Room> rooms;
    protected HashMap<Entity, HashSet<Entity>> entityLinks;
    protected HashMap<Pair<String, Integer>, Integer> badgeCounts;
    protected SimpleListProperty<Trait> global_resources;
    protected SimpleListProperty<Flag> global_flags;
    protected SimpleListProperty<GameEvent> pendingEvents = new SimpleListProperty();
    protected SimpleListProperty<GameEvent> updateWarnings = new SimpleListProperty();
    protected ArrayList<GameEvent> unresolvedUpdateWarnings = new ArrayList();
    protected PredefinedData defaultData = new PredefinedData();
    protected SimpleIntegerProperty turnCount = new SimpleIntegerProperty(0);
    
    protected ArrayList<Entity> entitiesToRemove = new ArrayList();
    protected ArrayList<Entity> entitiesToChange = new ArrayList();
    
    public Engine() {
        setUpEntities(null);
        setUpRooms(null);
        setUpLinks();
        
        //////////////////////Fix this mess
        
        this.global_resources = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.global_flags = new SimpleListProperty<>(FXCollections.observableArrayList());
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
     * @return the global flags
     */
    public SimpleListProperty<Flag> getGlobalFlags() {
        return global_flags;
    }
    
    /**
     * Returns the Flag from global Flags that matches the given Flag by equalShallow.
     * Returns null otherwise.
     * @param f
     * @return 
     */
    public Flag getGlobalFlag(Flag f) {
        if(f == null) {
            return null;
        }
        
        for(Flag current : global_flags) {
            if(current.equalShallow(f)) {
                return current;
            }
        }
        
        return null;
    }
    
    public boolean hasGlobalResourceName(String name) {
        if(name == null) {
            return false;
        }
        
        for(Trait t : global_resources) {
            if(t.getName().equals(name)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean hasGlobalResource(Trait t) {
        if(t == null) {
            return false;
        }
        
        for(Trait current : global_resources) {
            if(current.equalShallow(t)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Returns the Trait from global resources that matches the given Trait by equalShallow.
     * Returns null otherwise.
     * @param t
     * @return 
     */
    public Trait getGlobalResource(Trait t) {
        if(t == null) {
            return null;
        }
        
        for(Trait current : global_resources) {
            if(current.equalShallow(t)) {
                return current;
            }
        }
        
        return null;
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
        
        EnumSet<GameEnums.TraitMod> traitTypes = EnumSet.noneOf(GameEnums.TraitMod.class);
        global_resources.get().add(new Trait(name, value, desc, traitTypes));
    }
    
    /**
     * Adds the given resource to the global pool. If the global resource pool already contains the Trait
     * it adds their values. If it does not have one, it adds the Trait to the pool.
     * Negative values are allowed.
     * 
     * @param t the resource Trait
     */
    public void addResource(Trait t) {
        for(Trait current : getGlobalResources()) {
            if(current.equalShallow(t)) {
                current.addToValue(t.getValue());
                return;
            }
        }
        
        getGlobalResources().get().add(t);
    }
    
    /**
     * Looks up a Trait by the given group name and id, then adds it to the global pool.
     * If the global resource pool already contains the Trait, it adds their values. Otherwise, it is added to the pool.
     * If there is no Trait with the given information, nothing happens.
     * @param group
     * @param id
     * @param value 
     */
    public void addResourceById(String group, int id, int value) {
        Trait temp = getPredefinedData().getTraitByNum(group, id);
        if(temp == null) {
            return;
        }
        temp.setValue(value);
        
        addResource(temp);
    }
    
    /**
     * Looks up a Trait by the given group name and id, and then adds it to the Entity.
     * If the Entity already has the Trait, their values are added. If the Entity does not have the Trait, it is 
     * given that Trait with the given value. If there is no Trait with the given information, nothing happens
     * @param group
     * @param id
     * @param value
     */
    public void addToEntityById(Entity target, String group, int id, int value) {
        if(target == null) {
            return;
        }
        
        Trait temp = getPredefinedData().getTraitByNum(group, id);
        if(temp == null) {
            return;
        }
        temp.setValue(value);
        
        target.addTrait(temp);
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
            
            //controller.addEntity(justCreated);
        }
        
        // Remove any removed things
        for(String id : IDsToRemove) {
            //controller.removeByID(id);
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
            //controller.addEntity(justCreated);
        }
        
        // Remove any removed things
        for(String id : IDsToRemove) {
            //controller.removeByID(id);
        }
        
        incrementTurnCount();
    }
    
    public void updateAcknowledged() {
        entitiesToRemove.clear();
        entitiesToChange.clear();
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
        
        for(Cost price : t.getCosts()) {
            if(price.getGameElement() == GameEnums.Type.TRAIT) {
                e.addCostValue(price);
            }
            else {
                addResourceById(price.getGroupName(), price.getIdNum(), price.getValue());
            }
        }
        
        e.clearTask();
        HashSet<Entity> removed = unlinkAllEntities(e);
        for(Entity link : removed) {
            link.clearTask();
        }
    }
    
    
    /**
     * Calls e.setTaskAndTimer(t), then evaluates the costs of t. Resource costs are subtracted from the global
     * resource pool, and personal resources from Active e.
     * @param t the chosen Task
     * @param e the Entity to do the Task
     */
    public void setTaskPayCosts(Task t, Entity e) {
        e.setTaskAndTimer(t);
        
        for(Cost price : t.getCosts()) {
            if(price.getGameElement() == GameEnums.Type.TRAIT) {
                e.subtractCostValue(price);
            }
            else {
                addResourceById(price.getGroupName(), price.getIdNum(), price.getValue() * -1);
            }
        }
    }
    
    
    public int getResourceValue(String name) {
        for(Trait resource : global_resources) {
            if(resource.getName().equals(name)) {
                return resource.getValue();
            }
        }
        return 0;
    }
    
    public int getEntityCount(String group, int id) {
        int count = 0;
        
        for(Entity entity : getEntities()) {
            
            if(entity.getGroupName().equals(group) && entity.getIdNum() == id) {
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
    
    public boolean requirementsAllMet(List<Requirement> reqs, Entity e) {
    //if there are no requirements, then true
        if(reqs == null || reqs.isEmpty()) {
            return true;
        }
            
        for(Requirement r : reqs) {
            if(!requirementMet(r, e)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean equalToReqMet(Requirement req, Entity e) {
        switch(req.getGameElement()) {
            case ENTITY:
                if(req.getAdditionalReq() == null) {
                    return getEntityCount(req.getGroupName(), req.getIdNum()) == req.getValue();
                }
                else {
                    int count = 0;
                    Entity tempEntity = getPredefinedData().getEntityByNum(req.getGroupName(), req.getIdNum());
                    for(Entity possible : getEntities()) {
                        if(possible.equalShallow(tempEntity) && requirementsAllMet(Arrays.asList(req.getAdditionalReq()), possible)) {
                            count++;
                        }
                    }
                    
                    return count == req.getValue();
                }
            case TRAIT:
                Trait tempTrait = e.getTrait(getPredefinedData().getTraitByNum(req.getGroupName(), req.getIdNum()));
                if(tempTrait != null) {
                    return tempTrait.getValue() == req.getValue();
                }
                else {
                    return false;
                }
            case GLOBAL_TRAIT:  
                Trait globalTempTrait = getGlobalResource(getPredefinedData().getTraitByNum(req.getGroupName(), req.getIdNum()));
                if(globalTempTrait != null) {
                    return globalTempTrait.getValue() == req.getValue();
                }
                else {
                    return false;
                }
            case FLAG: //Flags have boolean values, so we check differently: req.getValue() must return a nonzero number to be considered false
                Flag tempFlag = e.getFlag(getPredefinedData().getFlagByNum(req.getGroupName(), req.getIdNum()));
                if(tempFlag != null) {
                    return tempFlag.getFlagState() == (req.getValue() == 0);
                }
                else {
                    return false;
                }
            case GLOBAL_FLAG:
                Flag globalTempFlag = getGlobalFlag(getPredefinedData().getFlagByNum(req.getGroupName(), req.getIdNum()));
                if(globalTempFlag != null) {
                    return globalTempFlag.getFlagState() == (req.getValue() == 0);
                }
                else {
                    return false;
                }
            default: return false;
        }
    }
    
    public boolean notEqualReqMet(Requirement req, Entity e) {
        switch(req.getGameElement()) {
            case ENTITY:
                if(req.getAdditionalReq() == null) {
                    return getEntityCount(req.getGroupName(), req.getIdNum()) != req.getValue();
                }
                else {
                    int count = 0;
                    Entity tempEntity = getPredefinedData().getEntityByNum(req.getGroupName(), req.getIdNum());
                    for(Entity possible : getEntities()) {
                        if(possible.equalShallow(tempEntity) && requirementsAllMet(Arrays.asList(req.getAdditionalReq()), possible)) {
                            count++;
                        }
                    }
                    
                    return count != req.getValue();
                }
            case TRAIT:
                Trait tempTrait = e.getTrait(getPredefinedData().getTraitByNum(req.getGroupName(), req.getIdNum()));
                if(tempTrait != null) {
                    return tempTrait.getValue() != req.getValue();
                }
                else {
                    return false;
                }
            case GLOBAL_TRAIT:  
                Trait globalTempTrait = getGlobalResource(getPredefinedData().getTraitByNum(req.getGroupName(), req.getIdNum()));
                if(globalTempTrait != null) {
                    return globalTempTrait.getValue() != req.getValue();
                }
                else {
                    return false;
                }
            case FLAG: //Flags have boolean values, so we check differently: req.getValue() must return a nonzero number to be considered false
                Flag tempFlag = e.getFlag(getPredefinedData().getFlagByNum(req.getGroupName(), req.getIdNum()));
                if(tempFlag != null) {
                    return tempFlag.getFlagState() != (req.getValue() == 0);
                }
                else {
                    return false;
                }
            case GLOBAL_FLAG:
                Flag globalTempFlag = getGlobalFlag(getPredefinedData().getFlagByNum(req.getGroupName(), req.getIdNum()));
                if(globalTempFlag != null) {
                    return globalTempFlag.getFlagState() != (req.getValue() == 0);
                }
                else {
                    return false;
                }
            default: return false;
        }
    }
    
    public boolean lessThanReqMet(Requirement req, Entity e) {
        switch(req.getGameElement()) {
            case ENTITY:
                if(req.getAdditionalReq() == null) {
                    return getEntityCount(req.getGroupName(), req.getIdNum()) < req.getValue();
                }
                else {
                    int count = 0;
                    Entity tempEntity = getPredefinedData().getEntityByNum(req.getGroupName(), req.getIdNum());
                    for(Entity possible : getEntities()) {
                        if(possible.equalShallow(tempEntity) && requirementsAllMet(Arrays.asList(req.getAdditionalReq()), possible)) {
                            count++;
                        }
                    }
                    
                    return count < req.getValue();
                }
            case TRAIT:
                Trait tempTrait = e.getTrait(getPredefinedData().getTraitByNum(req.getGroupName(), req.getIdNum()));
                if(tempTrait != null) {
                    return tempTrait.getValue() == req.getValue();
                }
                else {
                    return false;
                }
            case GLOBAL_TRAIT:  
                Trait globalTempTrait = getGlobalResource(getPredefinedData().getTraitByNum(req.getGroupName(), req.getIdNum()));
                if(globalTempTrait != null) {
                    return globalTempTrait.getValue() < req.getValue();
                }
                else {
                    return false;
                }
            case FLAG: //Flags have boolean values, so we check differently: req.getValue() must return a nonzero number to be considered false
                Flag tempFlag = e.getFlag(getPredefinedData().getFlagByNum(req.getGroupName(), req.getIdNum()));
                if(tempFlag != null) {
                    return tempFlag.getFlagState() == (req.getValue() == 0);
                }
                else {
                    return false;
                }
            case GLOBAL_FLAG:
                Flag globalTempFlag = getGlobalFlag(getPredefinedData().getFlagByNum(req.getGroupName(), req.getIdNum()));
                if(globalTempFlag != null) {
                    return globalTempFlag.getFlagState() == (req.getValue() == 0);
                }
                else {
                    return false;
                }
            default: return false;
        }
    }
    
    public boolean greaterThanReqMet(Requirement req, Entity e) {
        switch(req.getGameElement()) {
            case ENTITY:
                if(req.getAdditionalReq() == null) {
                    return getEntityCount(req.getGroupName(), req.getIdNum()) > req.getValue();
                }
                else {
                    int count = 0;
                    Entity tempEntity = getPredefinedData().getEntityByNum(req.getGroupName(), req.getIdNum());
                    for(Entity possible : getEntities()) {
                        if(possible.equalShallow(tempEntity) && requirementsAllMet(Arrays.asList(req.getAdditionalReq()), possible)) {
                            count++;
                        }
                    }
                    
                    return count > req.getValue();
                }
            case TRAIT:
                Trait tempTrait = e.getTrait(getPredefinedData().getTraitByNum(req.getGroupName(), req.getIdNum()));
                if(tempTrait != null) {
                    return tempTrait.getValue() > req.getValue();
                }
                else {
                    return false;
                }
            case GLOBAL_TRAIT:  
                Trait globalTempTrait = getGlobalResource(getPredefinedData().getTraitByNum(req.getGroupName(), req.getIdNum()));
                if(globalTempTrait != null) {
                    return globalTempTrait.getValue() > req.getValue();
                }
                else {
                    return false;
                }
            case FLAG: //Flags have boolean values, so we check differently: req.getValue() must return a nonzero number to be considered false
                Flag tempFlag = e.getFlag(getPredefinedData().getFlagByNum(req.getGroupName(), req.getIdNum()));
                if(tempFlag != null) {
                    return tempFlag.getFlagState() == (req.getValue() == 0);
                }
                else {
                    return false;
                }
            case GLOBAL_FLAG:
                Flag globalTempFlag = getGlobalFlag(getPredefinedData().getFlagByNum(req.getGroupName(), req.getIdNum()));
                if(globalTempFlag != null) {
                    return globalTempFlag.getFlagState() == (req.getValue() == 0);
                }
                else {
                    return false;
                }
            default: return false;
        }
    }
    
    public PredefinedData getPredefinedData() {
        return defaultData;
    }
       
    public void addRoom(Room r) {
        rooms.add(r);
        
        // If it doens't have a valid position, don't worry about it
        if(r.getxPos() < 0 || r.getyPos() < 0) {
            return;
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }
    
    public void setRoom(Room r, int pos) {
        if(pos < 0 || pos >= rooms.size()) {
            return;
        }
        
        if(rooms.get(pos) == null) {
            rooms.set(pos, r);
        }
        else {
            rooms.get(pos).matchRoom(r);
        }
    }
    
    public void setRoomEmpty(Room r) {
        r.setName("Empty");
        r.setId("empty");
        r.setType(Room.roomType.WALL);
        r.setDescription("Unworked");
        r.setTraits(new ArrayList<Trait>());
        r.setTasks(new ArrayList<Task>());
    }
    
    public List<Room> getReachableRooms() {
        ArrayList<Room> reachableRooms = new ArrayList();
        
        for(Room r : rooms) {
            if(r.isReachable()) {
                reachableRooms.add(r);
            }
        }
        
        return reachableRooms;
    }

    public void setReachable(int pos, boolean reachable) {
        rooms.get(pos).setReachable(reachable);
    }
    
    public void changeRoom(Room r, Task t) {
        try {
            Class c = AntRoomBuilder.class;
            Method m = null;
            
            for(Trait result : t.getResults()) {
                if(TraitEvaluator.isRoomChangeTrait(result)) {
                    m = c.getMethod(result.getDesc());
                    break;
                }
            }
            
            if(m == null) {
                return;
            }
            
            r.matchRoomShallow((Room)m.invoke(c, new Object[0]));
            r.setReachable(false);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
    }
    
    public void changeEntity(Entity e, Task t) {
        String s = null;
        for(Result result : t.getResults()) {
            if(TraitEvaluator.isActiveChangeTrait(result)) {
                s = result.getDesc();
                break;
            }
        }

        if(s == null) {
            return;
        }

        ActiveEntity toMatch = builder.makeEntity(s, null);

        e.matchEntity(toMatch);
        Task autoTask = super.getAutoTask(e);
        
        if(autoTask != null) {
            e.setTaskAndTimer(autoTask);
        }
        
    }
    
    public void removeRoom(Room r) {
        rooms.remove(r);
    }

    public void setRooms(List<Room> newRooms) {
        rooms = new ArrayList<Room>(newRooms);
    }    

    private void setUpRooms(List<Room> initRooms) {
        rooms = new ArrayList<Room>();
        
        if(initRooms != null) {
            for(Room r : initRooms) {
                if(r == null) {
                    rooms.add(new Room());
                }
                else {
                    rooms.add(new Room(r));
                }
            }
        }
    }
    
    private void setUpEntities(List<Entity> initEntities) {
        entities = new LinkedHashSet();
        
        if(initEntities != null) {
            for(Entity e : initEntities) {
                addEntity(e);
            }
        }
    }
    
    private void setUpLinks() {
        entityLinks = new HashMap();
    }
    
    /**
     * Adds the given Entity e if it is not null, and e does not already exist 
     * @param e The Entity to add
     */
    public void addEntity(Entity e) {
        if(e != null && !entities.contains(e)) {
            entities.add(e);
        }
    }

    public Set<Entity> getActiveEntities() {
        return entities;
    }

    public void setEntities(List<Entity> newEntities) {
        entities = null;
        setUpEntities(newEntities);
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }

    public void linkEntities(Entity e1, Entity e2) {
        HashSet<Entity> links1 = entityLinks.get(e1);
        HashSet<Entity> links2 = entityLinks.get(e2);
        if(links1 == null) {
            links1 = new HashSet();
        }
        
        if(links2 == null) {
            links2 = new HashSet();
        }
        
        links1.add(e2);
        entityLinks.put(e1, links1);
        links2.add(e1);
        entityLinks.put(e2, links2);
    }

    public boolean areLinked(Entity e1, Entity e2) {
        if(entityLinks.get(e1) == null) {
            return false;
        }
        
        if(entityLinks.get(e2) == null) {
            return false;
        }
        
        return entityLinks.get(e1).contains(e2) && entityLinks.get(e2).contains(e1);
    }

    public void unlinkEntities(Entity e1, Entity e2) {
        HashSet<Entity> links1 = entityLinks.get(e1);
        HashSet<Entity> links2 = entityLinks.get(e2);
        if(links1 != null) {
            links1.remove(e2);
        }
        
        if(links2 != null) {
            links2.remove(e1);
        }
        
    }
    
    public HashSet<Entity> unlinkAllEntities(Entity e1) {
        HashSet<Entity> removed = new HashSet();
        
        if(entityLinks.get(e1) == null) {
            return removed;
        }
        
        for(Entity linked : getLinkedEntities(e1)) {
            removed.add(linked);
            HashSet<Entity> links = entityLinks.get(linked);
            if(links != null) {
                links.remove(e1);
            }
        }
        
        entityLinks.get(e1).clear();
        return removed;
    }

    public HashSet<Entity> getLinkedEntities(Entity e) {
        if(entityLinks.get(e) == null) {
            HashSet<Entity> links = new HashSet();
            entityLinks.put(e, links);
        }
        
        return entityLinks.get(e);
    }
    
    public boolean isLinked(Entity e) {
        if(entityLinks.get(e) == null) {
            return false;
        }
        
        return !entityLinks.get(e).isEmpty();
    }
    
    public LinkedHashSet<Entity> getEntities() {
        return entities;
    }
    
    public List getToRemove() {
        return entitiesToRemove;
    }
    
    public List getToChange() {
        return entitiesToChange;
    }
}
