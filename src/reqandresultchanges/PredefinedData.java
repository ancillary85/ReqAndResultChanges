/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MMLaptop
 */
public class PredefinedData {
    private HashMap<String, ArrayList<Trait>> defaultTraits;
    private HashMap<String, ArrayList<Task>> defaultTasks;
    private HashMap<String, ArrayList<GameEvent>> defaultEvents;
    private HashMap<String, ArrayList<Entity>> defaultEntities;
    private HashMap<String, ArrayList<Flag>> defaultFlags;
    
    public PredefinedData() {
        defaultTraits = new HashMap();
        defaultTasks = new HashMap();
        defaultEvents = new HashMap();
        defaultEntities = new HashMap();
        defaultFlags = new HashMap();
    }
    
    /**
     * @return the defaultTraits
     */
    public HashMap<String, ArrayList<Trait>> getDefaultTraits() {
        return defaultTraits;
    }
    
    /**
     * Asks the defaultTraits HashMap to return the ArrayList of Traits that matches the key traitListName
     * @param traitListName
     * @return null if nothing in the map
     */
    public ArrayList<Trait> getThisTraitList(String traitListName) {
        return defaultTraits.get(traitListName);
    }

    /**
     * Gets an ArrayList from the HashMap, and then returns the given index
     * @param traitListName
     * @param idnum
     * @return null if nothing in the map
     */
    public Trait getTraitByNum(String traitListName, int idnum) {
        ArrayList<Trait> temp = defaultTraits.get(traitListName);
        if(temp == null || idnum < 0 || idnum >= temp.size()) {
            return null;
        }
        
        return new Trait(temp.get(idnum));
    }
    
    public void addDefaultTraits(String listName, ArrayList<Trait> traitsList) {
        defaultTraits.put(listName, traitsList);
    }
    
    /**
     * @param defaultTraits the defaultTraits to set
     */
    public void setDefaultTraits(HashMap<String, ArrayList<Trait>> defaultTraits) {
        this.defaultTraits = defaultTraits;
    }

    /**
     * @return the defaultTasks
     */
    public HashMap<String, ArrayList<Task>> getDefaultTasks() {
        return defaultTasks;
    }

    /**
     * Asks the defaultTasks HashMap to return the ArrayList of Tasks that matches the key taskListName
     * @param taskListName
     * @return null if nothing in the map
     */
    public ArrayList<Task> getThisTaskList(String taskListName) {
        return defaultTasks.get(taskListName);
    }

    /**
     * Gets an ArrayList from the HashMap, and then returns the given index
     * @param taskListName
     * @param idnum
     * @return null if nothing in the map
     */
    public Task getTaskByNum(String taskListName, int idnum) {
        ArrayList<Task> temp = defaultTasks.get(taskListName);
        if(temp == null) {
            return null;
        }
        
        return temp.get(idnum);
    }
    
    public void addDefaultTasks(String listName, ArrayList<Task> tasksList) {
        defaultTasks.put(listName, tasksList);
    }
    
    /**
     * @param defaultTasks the defaultTasks to set
     */
    public void setDefaultTasks(HashMap<String, ArrayList<Task>> defaultTasks) {
        this.defaultTasks = defaultTasks;
    }
    
    /**
     * @return the defaultEvents
     */
    public HashMap<String, ArrayList<GameEvent>> getDefaultEvents() {
        return defaultEvents;
    }
    
    /**
     * Asks the defaultEvents HashMap to return the ArrayList of GameEvents that matches the key eventListName
     * @param eventListName
     * @return null if nothing in the map
     */
    public ArrayList<GameEvent> getThisEventList(String eventListName) {
        return defaultEvents.get(eventListName);
    }

    /**
     * Gets an ArrayList from the HashMap, and then returns the given index
     * @param eventListName
     * @param idnum
     * @return null if nothing in the map
     */
    public GameEvent getEventByNum(String eventListName, int idnum) {
        ArrayList<GameEvent> temp = defaultEvents.get(eventListName);
        if(temp == null || idnum < 0 || idnum >= temp.size()) {
            return null;
        }
        
        return temp.get(idnum);
    }
    
    public void addDefaultEvents(String listName, ArrayList<GameEvent> eventsList) {
        defaultEvents.put(listName, eventsList);
    }
    
    /**
     * @param defaultEvents the defaultEvents to set
     */
    public void setDefaultEvents(HashMap<String, ArrayList<GameEvent>> defaultEvents) {
        this.defaultEvents = defaultEvents;
    }

    public void addDefaultEntities(String listName, ArrayList<Entity> entityList) {
        defaultEntities.put(listName, entityList);
    }
    
    /**
     * @return the defaultEntities
     */
    public HashMap<String, ArrayList<Entity>> getDefaultEntities() {
        return defaultEntities;
    }

    /**
     * @param newDefaultEntities the defaultEntities to set
     */
    public void setDefaultEntities(HashMap<String, ArrayList<Entity>> newDefaultEntities) {
        this.defaultEntities = newDefaultEntities;
    }
    
    /**
     * Gets an ArrayList from the HashMap, and then returns the given index
     * @param entityListName
     * @param idnum
     * @return null if nothing in the map
     */
    public Entity getEntityByNum(String entityListName, int idnum) {
        ArrayList<Entity> temp = defaultEntities.get(entityListName);
        if(temp == null || idnum < 0 || idnum >= temp.size()) {
            return null;
        }
        
        return new Entity(temp.get(idnum));
    }
    
    /**
     * @return the defaultFlags
     */
    public HashMap<String, ArrayList<Flag>> getDefaultFlags() {
        return defaultFlags;
    }
    
    /**
     * Asks the defaultFlags HashMap to return the ArrayList of Flags that matches the key flagListName
     * @param flagListName
     * @return null if nothing in the map
     */
    public ArrayList<Flag> getThisFlagList(String flagListName) {
        return defaultFlags.get(flagListName);
    }

    /**
     * Gets an ArrayList from the HashMap, and then returns the given index
     * @param flagListName
     * @param idnum
     * @return null if nothing in the map
     */
    public Flag getFlagByNum(String flagListName, int idnum) {
        ArrayList<Flag> temp = defaultFlags.get(flagListName);
        if(temp == null || idnum < 0 || idnum >= temp.size()) {
            return null;
        }
        
        return temp.get(idnum);
    }
    
    public void addDefaultFlags(String listName, ArrayList<Flag> flagsList) {
        defaultFlags.put(listName, flagsList);
    }
    
    /**
     * @param defaultFlags the defaultFlags to set
     */
    public void setDefaultFlags(HashMap<String, ArrayList<Flag>> defaultFlags) {
        this.defaultFlags = defaultFlags;
    }
}
