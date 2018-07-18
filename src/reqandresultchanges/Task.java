/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mike
 */
public class Task {
    
    private SimpleStringProperty name;
    private SimpleIntegerProperty duration;
    private SimpleStringProperty gerund;
    private SimpleListProperty<Cost> costs;
    private SimpleListProperty<Requirement> requirements;
    private SimpleListProperty<Result> results;
    private SimpleStringProperty flavor;
    private int idNum = -1;
    private EnumSet<GameEnums.TaskMod> modifiers = EnumSet.noneOf(GameEnums.TaskMod.class);
    
    public Task() {
        name = new SimpleStringProperty("no task");
        duration = new SimpleIntegerProperty(0);
        gerund = new SimpleStringProperty("");
        setUpCosts(null);
        setUpRequirements(null);
        setUpResults(null);
        setUpFlavor(null);
    }
    
    public Task(String initName, int initDuration, Cost[] initCosts , 
        Requirement[] initRequirements, Result[] initResults, String initFlavor) {
        name = new SimpleStringProperty(initName);
        duration = new SimpleIntegerProperty(initDuration);
        gerund = new SimpleStringProperty(initName + "ing");
        setUpCosts(initCosts);
        setUpRequirements(initRequirements);
        setUpResults(initResults);        
        setUpFlavor(initFlavor);        
    }
    
    public Task(String initName, int initDuration, String initGerund, Cost[] initCosts , 
        Requirement[] initRequirements, Result[] initResults, String initFlavor, EnumSet mods) {
        name = new SimpleStringProperty(initName);
        duration = new SimpleIntegerProperty(initDuration);
        gerund = new SimpleStringProperty(initGerund);
        setUpCosts(initCosts);
        setUpRequirements(initRequirements);
        setUpResults(initResults);        
        setUpFlavor(initFlavor);        
        modifiers = EnumSet.copyOf(mods);
    }
    
    public Task(Task t) {
        name = new SimpleStringProperty(t.getName());
        duration = new SimpleIntegerProperty(t.getDuration());
        gerund = new SimpleStringProperty(t.getGerund());
        setUpCosts(t.getCosts().toArray(new Cost[0]));
        setUpRequirements(t.getRequirements().toArray(new Requirement[0]));
        setUpResults(t.getResults().toArray(new Result[0]));
        setUpFlavor(t.getFlavor());
        modifiers = t.getModifiers();
    }
    
    private void setUpCosts(Cost[] initCosts) {
        if(initCosts == null) {
            costs = new SimpleListProperty<Cost>(FXCollections.observableArrayList());
        }
        else {
            costs = new SimpleListProperty(FXCollections.observableList(Arrays.asList(initCosts)));
        }
    }
    
    private void setUpRequirements(Requirement[] initRequirements) {
        if(initRequirements == null) {
            requirements = new SimpleListProperty<Requirement>(FXCollections.observableArrayList());
        }
        else {
            requirements = new SimpleListProperty(FXCollections.observableList(Arrays.asList(initRequirements)));
        }
    }
    
    private void setUpResults(Result[] initResults) {
        if(initResults == null) {
            results = new SimpleListProperty<Result>(FXCollections.observableArrayList());
        }
        else {
            results = new SimpleListProperty(FXCollections.observableList(Arrays.asList(initResults)));
        }
    }

    private void setUpFlavor(String initFlavor) {
        if(initFlavor == null) {
            flavor = new SimpleStringProperty("Idle");
        }
        else {
            flavor = new SimpleStringProperty(initFlavor);
        }
    }
    
    public boolean isNoTask() {
        return name.get().equals("no task") && duration.get() < 1;
    }
    
    public void setLinkTask(Task t, Entity e) {
        name.set("Link");
        duration.set(t.getDuration());
        gerund.set(t.getGerund() + " with " + ((Entity)e).getName());
        
        flavor.set(t.getFlavor());
        costs.set(FXCollections.observableList(new ArrayList()));
        requirements.set(FXCollections.observableList(new ArrayList()));
        results.set(FXCollections.observableList(new ArrayList()));
    }
    
    public void setNoTask() {
        name.set("no task");
        duration.set(0);
        flavor.set("Doing nothing");
        gerund.set("");
        costs.set(FXCollections.observableList(new ArrayList()));
        requirements.set(FXCollections.observableList(new ArrayList()));
        results.set(FXCollections.observableList(new ArrayList()));
    }
    
    @Override
    public String toString() {
        String s = name.get() + ": " + duration.get() + " turns";
        s += ", ";
        
        String[] costArray = new String[costs.size()];
        for(int i = 0; i < costs.size(); i++) {
            costArray[i] = costs.get(i).toString();
        }
        
        s += String.join(", ", costArray);
        s += "; Requires: ";
        
        String[] requirementArray = new String[requirements.size()];
        for(int i = 0; i < requirements.size(); i++) {
            requirementArray[i] = requirements.get(i).toString();
        }
        
        s += String.join(", ", requirementArray);
        s += "; Results: ";
        
        String[] resultArray = new String[results.size()];
        for(int i = 0; i < results.size(); i++) {
            resultArray[i] = results.get(i).toString();
        }
        
        s += String.join(", ", resultArray);
        s += "\n";
        s += "\"" + flavor.get() + "\"";
        return s;
    }
    
    /**
     * Sets all the Task's properties to the ones in the given Task
     *
     * NEEDS TO BE UPDATED AS THE PROPERTIES ARE CHANGED
     * 
     * @param t the Task to match
     */
    public void setToNewTask(Task t) {
        this.setName(t.getName());
        this.setDuration(t.getDuration());
        this.setGerund(t.getGerund());
        this.setCostsProp(t.getCostsProp());
        this.setRequirementsProp(t.getRequirementsProp());
        this.setResultsList(t.getResults());
        this.setFlavor(t.getFlavor());
    }
    
    @Override
    public boolean equals(Object t) {
        if(t == null) {return false;} //is the other null?
        if(this == t) {return true;} //is the other me?
        if(!(t instanceof Task)) {return false;} //is it a Task?
        
        Task temp = (Task) t;
        if(!this.getName().equals(temp.getName())) {return false;} //same name?
        if(this.getDuration() != temp.getDuration()) {return false;} //same duration?
        if(!this.getCosts().equals(temp.getCosts())) {return false;} //same costs?
        if(!this.getRequirements().equals(temp.getRequirements())) {return false;} //same requirements?
        if(!this.getResults().equals(temp.getResults())) {return false;} //same results?
        return this.getFlavor().equals(temp.getFlavor()); //same flavor?
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.getName());
        hash = 53 * hash + Objects.hashCode(this.getDuration());
        hash = 53 * hash + this.getCosts().hashCode();
        hash = 53 * hash + this.getRequirements().hashCode();
        hash = 53 * hash + this.getResults().hashCode();
        hash = 53 * hash + Objects.hashCode(this.getFlavor());
        return hash;
    }
    
        
    /**
     * @return the name as a String
     */
    public String getName() {
        return name.get();
    }

    public void setName(String newName) {
        name.set(newName);
    }
    
    /**
     * @return the name property
     */
    public SimpleStringProperty getNameProp() {
        return name;
    }
    
    /**
     * @return the idNum
     */
    public int getIdNum() {
        return idNum;
    }

    /**
     * @param idNum the idNum to set
     */
    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    /**
     * @return the duration as an int
     */
    public int getDuration() {
        return duration.get();
    }
    
    public void setDuration(int newDuration) {
        duration.set(newDuration);
    }
    
    /**
     * @return the duration
     */
    public SimpleIntegerProperty getDurationProp() {
        return duration;
    }
    
    /**
     * @param duration the duration to set
     */
    public void setDurationProp(SimpleIntegerProperty duration) {
        this.duration = duration;
    }
    
    /**
     * @return the gerund of the Task
     */
    public String getGerund() {
        return gerund.get();
    }
    
    /**
     * @param newGerund the gerund to set
     */
    public void setGerund(String newGerund) {
        gerund.set(newGerund);
    }
    
    /**
     * @return the gerund property
     */
    public SimpleStringProperty getGerundProp() {
        return gerund;
    }
    
    /**
     * @return the costs as an ObservableList
     */
    public ObservableList<Cost> getCosts() {
        return costs.get();
    }
    
    /**
     * @return the requirements as an ObservableList of Traits
     */
    public ObservableList<Requirement> getRequirements() {
        return requirements.get();    
    }
    
    /**
     * @return the results as an ObservableList of Results
     */
    public ObservableList<Result> getResults() {
        return results.get();
    }
    
    /**
     * @param newResults the results to set
     */
    public void setResults(Result[] newResults) {
        results.set(FXCollections.observableList(Arrays.asList(newResults)));
    }
    
    public void setResultsList(List<Result> newResults) {
        results.set(FXCollections.observableList(newResults));
    }
    
    public SimpleListProperty<Result> getResultsProp() {
        return results;
    }
    

    
    /**
     * @param name the name to set
     */
    public void setNameProp(SimpleStringProperty name) {
        this.name = name;
    }

    /**
     * @return the costs
     */
    public SimpleListProperty<Cost> getCostsProp() {
        return costs;
    }

    public void setCosts(Cost[] newCosts) {
        costs.set(FXCollections.observableList(Arrays.asList(newCosts)));

    }
            
    public void setCostsList(List<Trait> newCosts) {
        costs.set(FXCollections.observableList(newCosts));
    }
    
    /**
     * @param newCosts the costs to set
     */
    public void setCostsProp(SimpleListProperty<Cost> newCosts) {
        costs.set(newCosts);
    }

    /**
     * @return the requirements
     */
    public SimpleListProperty<Requirement> getRequirementsProp() {
        return requirements;
    }

    public void setRequirements(Requirement[] newRequirements) {
        requirements.set(FXCollections.observableList(Arrays.asList(newRequirements)));
    }
            
    public void setRequirementsList(List<Requirement> newRequirements) {
        requirements.set(FXCollections.observableList(newRequirements));
    }
    
    /**
     * @param newRequirements the requirements to set
     */
    public void setRequirementsProp(SimpleListProperty<Requirement> newRequirements) {
        this.requirements.set(newRequirements);
    }

    /**
     * @return the flavor property
     */
    public SimpleStringProperty getFlavorProp() {
        return flavor;
    }
    
    /**
     * @return the flavor as a String
     */
    public String getFlavor() {
        return flavor.get();
    }

    /**
     * @param newFlavor the flavor to set
     */
    public void setFlavor(String newFlavor) {
        this.flavor.set(newFlavor);
    }
    
    /**
     * @param flavor the flavor to set
     */
    public void setFlavorProp(SimpleStringProperty flavor) {
        this.flavor = flavor;
    }

    /**
     * Returns an EnumSet of the modifiers of this Task
     * @return 
     */
    public EnumSet<GameEnums.TaskMod> getModifiers() {
        return modifiers;
    }
    
    /**
     * Sets the Tasks modifiers to EnumSet.copyOf(newMods). Does not do any sanity checking
     * @param newMods 
     */
    public void setModifiers(EnumSet<GameEnums.TaskMod> newMods) {
        modifiers = EnumSet.copyOf(newMods);
    }

}
