/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

/**
 *
 * @author MLaptop
 */
public class ReqAndResultChanges {

    private static ArrayList<Entity> ants = new ArrayList();
    private static ArrayList<Room> rooms;
    private static HashMap<Entity, HashSet<Entity>> entityLinks;
    protected static SimpleListProperty<Trait> global_resources;
    protected static PredefinedData defaultData = new PredefinedData();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        setUp();
        entityTest();
        //resourceTest();
    }
    
    private static void setUp() {
        global_resources = new SimpleListProperty<>(FXCollections.observableArrayList());
        
        ArrayList<Trait> resourceList = new ArrayList();
        Trait apples = new Trait();
        apples.setName("Apples");
        apples.setValue(1);
        
        Trait oranges = new Trait();
        oranges.setName("Oranges");
        oranges.setValue(1);
        
        resourceList.add(apples);
        resourceList.add(oranges);      
        
        defaultData.addDefaultTraits("resources", resourceList);
        
        ArrayList<Trait> dudeTraits = new ArrayList();
        Trait height = new Trait();
        height.setName("Height");
        height.setValue(5);
        
        Trait weight = new Trait();
        weight.setName("Weight");
        weight.setValue(120);
        
        dudeTraits.add(height);
        dudeTraits.add(weight);
        
        defaultData.addDefaultTraits("dudes", dudeTraits);
        //////////////////////////////////////////
        // Set up ActiveEntities
        /////////////////////////////////////////
        ArrayList<Entity> dudes = new ArrayList();
        Entity Alice = new Entity("testGroup", 0, "Alice", null, null, null, defaultData.getThisTraitList("dudes"));        
        
        dudes.add(Alice);
        defaultData.addDefaultEntities("dudes", dudes);
    }
    
    private static void resourceTest() {
        Result growApples = new Result("resources", 0, GameEnums.Type.GLOBAL_TRAIT, 5, GameEnums.Outcome.ADD_TRAIT_GLOBAL);
        processResult(growApples, null);
        printResources();
        
        Result moreApples = new Result("resources", 0, GameEnums.Type.GLOBAL_TRAIT, 15, GameEnums.Outcome.ADD_TRAIT_GLOBAL);
        processResult(moreApples, null);
        Result growOranges = new Result("resources", 1, GameEnums.Type.GLOBAL_TRAIT, 10, GameEnums.Outcome.ADD_TRAIT_GLOBAL);
        processResult(growOranges, null);
        printResources();
        
        Result noApples = new Result("resources", 0, GameEnums.Type.GLOBAL_TRAIT, 0, GameEnums.Outcome.REMOVE_TRAIT_GLOBAL);
        processResult(noApples, null);
        printResources();
    }
    
    private static void printResources() {
        System.out.print("We have");
        
        if(global_resources.isEmpty()) {
            System.out.print(" no resources");
        }
        else {
            for(Trait res : global_resources) {
                System.out.print(" " + res.getValue() + " " + res.getName());
            }
        }
        
        System.out.println();
    }
    
    private static void entityTest() {
        System.out.println("Default height is " + defaultData.getTraitByNum("dudes", 0));
        Entity alice1 = defaultData.getEntityByNum("dudes", 0);
        ants.add(alice1);
        Entity alice2 = defaultData.getEntityByNum("dudes", 0);
        alice2.setName("Alice 2");
        ants.add(alice2);
        
        Result growHeight = new Result("dudes", 0, GameEnums.Type.TRAIT, 10, GameEnums.Outcome.ADD_TRAIT_SELF);
        processResult(growHeight, alice2);
        
        System.out.println("Default height is " + defaultData.getTraitByNum("dudes", 0));
        System.out.println("There are " + ants.size() + " people to meet");
        for(Entity e : ants) {
            if(e != null) {
                System.out.println("My name is " + e.getName() + ", and I have a height of " + e.getTraitValue("height"));
            }
        }
        
        System.out.println("Does Alice2 have a Height Trait? " + alice2.hasTraitName("Height"));
        Result noHeight = new Result("dudes", 0, GameEnums.Type.TRAIT, 0, GameEnums.Outcome.REMOVE_TRAIT_SELF);
        processResult(noHeight, alice2);
        System.out.println("Does Alice2 have a Height Trait? " + alice2.hasTraitName("Height"));
    }
    
    /**
     * Calls TraitEvaluator.resourcesFromGroup(this.getGlobalResources(),
     * this.getActiveEntities()) and then loops through the ActiveEntities and
     * updates them and checks for a completed task. The results of completed
     * tasks are added to the global resources using addResource(name, value) if
     * they are not personal resources. If they are personal resources, it uses
     * addResource(trait.getName(), trait.getValue()). If any of the completed
     * Tasks have trait_type.CREATION results, they are processed. If any of the
     * completed Tasks have trait_type.ROOM_CHANGE results, they are processed.
     * Then it does all this for Rooms. Then it checks all the GameEvents in
     * timedEvents and untimedEvents. Finally, it increments the turnCount.
     *
     * Engines that want more or different behavior should override this. Most
     * Engines can begin their version of update() with super() or just copy the
     * previous line of code.
     */
    public void update() {
        //traitEval.resourcesFromGroup(this.getGlobalResources(), this.getActiveEntities());

        ArrayList<Entity> entitiesToAdd = new ArrayList();
        ArrayList<String> IDsToRemove = new ArrayList();
        HashMap<Entity, Task> activesToChange = new HashMap();
        ArrayList<Room> roomsToChange = new ArrayList();
        
        for(Entity e : this.getEntities()) {
            e.activeUpdate(null);
            
            if (e.getTaskCompleted()) {
                boolean changeSelf = false;
                
            }

        }
/*
        for (ActiveEntity e : this.getActiveEntities()) {
            e.activeUpdate(null);

            if (e.getTaskCompleted()) {
                boolean changeSelf = false;

                for (Trait result : e.getCurrentTask().getResults()) {
                    // Check for personal resources
                    if (TraitEvaluator.isPResourceTrait(result)) {
                        e.addTrait(result);
                    } // Check for creating new ActiveEntities
                    else if (TraitEvaluator.isCreationTrait(result)) {
                        for (int i = 0; i < result.getValue(); i++) {
                            ActiveEntity newlyMade;
                            newlyMade = builder.makeEntity(result.getName(), null);

                            entitiesToAdd.add(newlyMade);
                        }
                    } // Check for changing self
                    else if (TraitEvaluator.isActiveChangeTrait(result)) {
                        changeSelf = true;
                    } // Check for changing others
                    else if (TraitEvaluator.isActiveChangeOther(result)) {
                        for (Active a : getLinkedActives(e)) {
                            if (a instanceof ActiveEntity) {
                                activesToChange.put((ActiveEntity) a, e.getCurrentTask());
                            }
                        }
                    } // Check for changing Rooms
                    else if (TraitEvaluator.isRoomChangeTrait(result)) {
                        System.out.println("Looks like we're making a room!");
                    } // Check for resources
                    else if (TraitEvaluator.isResourceTrait(result)) {
                        this.addResource(result.getName(), result.getValue(), result.getDesc());
                    } // Check for removing things
                    else if (TraitEvaluator.isUncreateTrait(result)) {
                        IDsToRemove.add(result.getName());
                    }
                } // end of looping through the Task's results

                unlinkAllActives(e);

                if (changeSelf) {
                    changeActiveEntity(e, e.getCurrentTask());
                } else {
                    e.clearTask();
                }
            }// End of if taskcompleted
        }// End of for each ActiveEntity loop

        // Add any created things
        for (ActiveEntity justCreated : entitiesToAdd) {
            Task autoTask = this.getAutoTask(justCreated);

            if (autoTask != null) {
                justCreated.setTaskAndTimer(autoTask);
            }

            controller.addActive(justCreated);
        }

        // Remove any removed things
        for (String id : IDsToRemove) {
            controller.removeByID(id);
        }

        // Change others
        for (ActiveEntity toChange : activesToChange.keySet()) {
            changeActiveEntity(toChange, activesToChange.get(toChange));
        }

        entitiesToAdd.clear();
        IDsToRemove.clear();
        activesToChange.clear();
        roomsToChange.clear();
        //InactiveEntities ?

        //Rooms
        for (Room r : this.getRooms()) {
            r.activeUpdate(null);

            if (r.getTaskCompleted()) {
                boolean changeRoom = false;

                for (Trait result : r.getCurrentTask().getResults()) {
                    // Check for personal resources
                    if (TraitEvaluator.isPResourceTrait(result)) {
                        r.addTrait(result);
                    } // Check for creating new ActiveEntities
                    else if (TraitEvaluator.isCreationTrait(result)) {
                        ActiveEntity newlyMade;
                        newlyMade = builder.makeEntity(result.getName(), null);

                        entitiesToAdd.add(newlyMade);
                    } // Check for changing Rooms
                    else if (TraitEvaluator.isRoomChangeTrait(result)) {
                        roomsToChange.add(r);
                        changeRoom = true;
                    } // Check for resources
                    else if (TraitEvaluator.isResourceTrait(result)) {
                        this.addResource(result.getName(), result.getValue(), result.getDesc());
                    } else if (TraitEvaluator.isUncreateTrait(result)) {
                        IDsToRemove.add(result.getName());
                    }
                }

                unlinkAllActives(r);
                if (changeRoom) {
                    changeRoom(r, r.getCurrentTask());
                }
            }// End of if taskcompleted
        }// End of for each Room loop

        // Add any created things
        for (ActiveEntity justCreated : entitiesToAdd) {
            Task autoTask = this.getAutoTask(justCreated);
            System.out.println("Engine thinks " + justCreated.getName() + " has # tasks " + justCreated.getTasks().size());
            if (autoTask != null) {

                System.out.println("Engine thinks " + justCreated.getName() + " has auto task " + autoTask.getName());
                justCreated.setTaskAndTimer(autoTask);
            }
        //    controller.addActive(justCreated);
        }

        // Remove any removed things
        for (String id : IDsToRemove) {
      //      controller.removeByID(id);
        }

    //    incrementTurnCount();

*/
    }
    
    public static void processResult(Result givenResult, Entity source) {
        switch(givenResult.getEffect()) {
            case SELF_CHANGE:
                break;
            case LINKED_CHANGE:
                break;
            case CREATE:
                break;
            case UNCREATE:
                break;
            case ADD_TRAIT_SELF:
                    if(givenResult.getGameElement() == GameEnums.Type.TRAIT) {
                        Trait traitToAdd = defaultData.getTraitByNum(givenResult.getGroupName(), givenResult.getIdNum());
                        traitToAdd.setValue(givenResult.getValue());
                        source.addTrait(traitToAdd);
                    }
                break;
            case REMOVE_TRAIT_SELF:
                    if(givenResult.getGameElement() == GameEnums.Type.TRAIT) {
                        Trait traitToRemove = defaultData.getTraitByNum(givenResult.getGroupName(), givenResult.getIdNum());
                        source.removeTrait(traitToRemove);
                    }
                break;
            case ADD_TRAIT_LINKED:
                break;
            case REMOVE_TRAIT_LINKED:
                break;
            case ADD_TRAIT_GLOBAL: 
                    //This better be a global trait you want to work with
                    if(givenResult.getGameElement() == GameEnums.Type.GLOBAL_TRAIT) {
                        Trait resourceToAdd = defaultData.getTraitByNum(givenResult.getGroupName(), givenResult.getIdNum());
                        resourceToAdd.setValue(givenResult.getValue());
                        addResource(resourceToAdd);
                    }
                break;
            case REMOVE_TRAIT_GLOBAL:
                    //This better be a global trait you want to work with
                    if(givenResult.getGameElement() == GameEnums.Type.GLOBAL_TRAIT) {
                        removeResource(defaultData.getTraitByNum(givenResult.getGroupName(), givenResult.getIdNum()));
                    }
                break;
            case ADD_TASK_SELF:
                    if(givenResult.getGameElement() == GameEnums.Type.TASK) {
                        Task taskToAdd = defaultData.getTaskByNum(givenResult.getGroupName(), givenResult.getIdNum());
                        source.addTask(taskToAdd);
                    }
                break;
            case REMOVE_TASK_SELF:
                    if(givenResult.getGameElement() == GameEnums.Type.TASK) {
                        Task taskToRemove = defaultData.getTaskByNum(givenResult.getGroupName(), givenResult.getIdNum());
                        source.removeTask(taskToRemove);
                    }
                break;
            case ADD_TASK_LINKED:
                break;
            case REMOVE_TASK_LINKED:
                break;
            case SET_FLAG_SELF:
                break;
            case UNSET_FLAG_SELF:
                break;
            case SET_FLAG_LINK:
                break;
            case UNSET_FLAG_LINKED:
                break;
            case SET_FLAG_GLOBAL:
                break;
            case UNSET_FLAG_GLOBAL:
                break;
            default: System.out.println("I don't understand");
                break;
       }
   }
    
    public static List<Entity> getEntities() {
        return ants;
    }
    
    /**
     * Adds the given resource to the global pool. If the global resource pool already contains a resource Trait with the 
     * same name, it adds their values. If it does not have one, it adds the Trait to the pool.
     * Negative values are allowed.
     * 
     * @param t the resource
     */
    public static void addResource(Trait t) {
        for(Trait res : global_resources) {
            if(res.getName().equals(t.getName())) {
                res.addToValue(t.getValue());
                return; //return if we found the resource in the pool
            }
        }
        
        //if we did not find it, add it
        global_resources.add(new Trait(t));
    }

    /**
     * Removes the given resource from the global pool, if it already exists there.
     * This removes a resource if the names match.
     * @param t the resource
     */
    public static void removeResource(Trait t) {
        Trait toRemove = null;
        for(Trait res : global_resources) {
            if(res.getName().equals(t.getName())) {
                toRemove = res;
                break; //stop if we found the resource in the pool
            }
        }
        
        if(toRemove != null) {
            global_resources.remove(toRemove);
        }
    }
    
}
