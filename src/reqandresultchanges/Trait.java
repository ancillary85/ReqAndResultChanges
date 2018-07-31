/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author MMLaptop
 */
public class Trait {

//    public static enum trait_type{FLAVOR, COMBAT, PRODUCTION,  ATTRIBUTE, GENERAL,                                                    
//    /*permanents*/                       CREATION, ROOM, PERSONAL_RESOURCE, OTHERS_RESOURCE, RESOURCE,
//    /*events*/                              EVENT, CONDITIONAL, TIMED, 
//    /*modifiers*/                           HIDDEN_RESOURCE, EACHTURN, UNCANCELABLE,
//    /*requirement conditions*/       EQUALTO, LESSTHAN, GREATERTHAN, NOTEQUAL, EXISTS, NOTEXISTS,
//    /*requirements only*/              CREATION_LINK, ROOM_LINK,
//    /*results only*/                       AUTOTASK, ACTIVE_CHANGE, ROOM_CHANGE, UNCREATE, ACTIVE_CHANGE_OTHER,
//                                                ADD_TRAIT, REMOVE_TRAIT, ADD_TASK, REMOVE_TASK,
//    /*unused?*/                           REQUIREMENT, MULTI, RESULT,
//                                                }    
    
    private String groupName;
    private int idNum;
    private SimpleStringProperty name;
    private SimpleIntegerProperty value;
    private SimpleIntegerProperty valueMin = new SimpleIntegerProperty(Integer.MIN_VALUE);
    private SimpleIntegerProperty valueMax = new SimpleIntegerProperty(Integer.MAX_VALUE);
    private SimpleStringProperty description;
    private EnumSet<GameEnums.TraitMod> types;
    private int sortingPriority = -1;
    private SimpleBooleanProperty showValue = new SimpleBooleanProperty(true);
    
    public Trait() {
        this.name = new SimpleStringProperty("No name");
        this.value = new SimpleIntegerProperty(0);
        this.description = new SimpleStringProperty("");        
        this.types = EnumSet.noneOf(GameEnums.TraitMod.class);
        this.groupName = null;
        this.idNum = -1;
    }
    
    public Trait(String name, int value, EnumSet<GameEnums.TraitMod> initTypes) {
        this.name = new SimpleStringProperty(name);
        this.value = new SimpleIntegerProperty(value);    
        this.description = new SimpleStringProperty("");
        this.types = initTypes;
        this.groupName = null;
        this.idNum = -1;
    }
    
    public Trait(String name, int value, String description, EnumSet<GameEnums.TraitMod> initTypes) {
        this.name = new SimpleStringProperty(name);
        this.value = new SimpleIntegerProperty(value);    
        this.description = new SimpleStringProperty(description);
        this.types = initTypes;
        this.groupName = null;
        this.idNum = -1;
    }

    public Trait(String name, int value, String description, EnumSet<GameEnums.TraitMod> initTypes, String group, int id) {
        this.name = new SimpleStringProperty(name);
        this.value = new SimpleIntegerProperty(value);    
        this.description = new SimpleStringProperty(description);
        this.types = initTypes;
        this.groupName = group;
        this.idNum = id;
    }
    
    public Trait(Trait t) {
        this.name = new SimpleStringProperty(t.getName());
        this.value = new SimpleIntegerProperty(t.getValue());
        this.description = new SimpleStringProperty(t.getDesc());
        this.types = EnumSet.copyOf(t.getTypes());
        this.valueMin = new SimpleIntegerProperty(t.getValueMin());
        this.valueMax = new SimpleIntegerProperty(t.getValueMax());
        this.idNum = t.idNum;
        this.sortingPriority = t.getSortingPriority();
        this.showValue = new SimpleBooleanProperty(t.getShowValue());
        this.groupName = t.getGroupName();
        this.idNum = t.getIdNum();
    }
    
    /**
     * @return the id number, with -1 being used for custom Traits
     */
    public int getIdNum() {
        return idNum;
    }
    
    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name.get();
    }
    
    /**
     * @param newName the new name to set 
     */
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
     * @return the value
     */
    public int getValue() {
        return value.get();
    }

    /**
     * @param setValue the value to set
     */
    public void setValue(int setValue) {
        int newValue = setValue;
        
        if(newValue <= valueMin.get()) {
            newValue = valueMin.get();
        }
        
        if(newValue >= valueMax.get()) {
            newValue = valueMax.get();
        }
        
        value.set(newValue);
    }

    /**
     * @return the value property
     */
    public SimpleIntegerProperty getValueProp() {
        return value;
    }

    /**
     * @return the valueMin
     */
    public int getValueMin() {
        return valueMin.get();
    }
    
    /**
     * @return the valueMin property
     */
    public SimpleIntegerProperty getValueMinProp() {
        return valueMin;
    }

    /**
     * @param newValueMin the valueMin to set
     */
    public void setValueMin(int newValueMin) {
        valueMin.set(newValueMin);
    }

    /**
     * @return the valueMax
     */
    public int getValueMax() {
        return valueMax.get();
    }
    
    /**
     * @return the valueMax property
     */
    public SimpleIntegerProperty getValueMaxProp() {
        return valueMax;
    }

    /**
     * @param newValueMax the valueMax to set
     */
    public void setValueMax(int newValueMax) {
        valueMax.set(newValueMax);
    }
    
    /**
     * Sets both the valueMin and valueMax
     * @param newMin
     * @param newMax 
     */
    public void setMinMax(int newMin, int newMax) {
        valueMin.set(newMin);
        valueMax.set(newMax);
    }
    
    /**
     * The Trait's value will not be allowed to exceed valueMin and valueMax, and will instead be set to 
     * whichever is appropriate. If overflow happens, it will be before the value is adjusted back within the min and max 
     * range. So, if addition of two large positive numbers causes the value to overflow into the negatives, it will probably 
     * then be set to valueMin.
     * @param add 
     */
    public void addToValue(int add) {
        
        //int newValue = Math.addExact(value.get(), add);
        int newValue = value.get() + add;
        if(newValue <= valueMin.get()) {
            newValue = valueMin.get();
        }
        
        if(newValue >= valueMax.get()) {
            newValue = valueMax.get();
        }
        
        value.set(newValue);
        
    }
    
    /**
     * @return the description
     */
    public String getDesc() {
        return description.get();
    }

    /**
     * @param newDescription the description to set
     */
    public void setDesc(String newDescription) {
        description.set(newDescription);
    }
    
    /**
     * @return the description property
     */
    public SimpleStringProperty getDescProp() {
        return description;
    }
    
    /**
     * @return the sortingPriority
     */
    public int getSortingPriority() {
        return sortingPriority;
    }

    /**
     * @param sortingPriority the sortingPriority to set
     */
    public void setSortingPriority(int sortingPriority) {
        this.sortingPriority = sortingPriority;
    }

    /**
     * @return the showValue
     */
    public boolean getShowValue() {
        return showValue.get();
    }
    
    /**
     * @return the showValue property
     */
    public SimpleBooleanProperty getShowValueProp() {
        return showValue;
    }

    /**
     * @param showValue the showValue to set
     */
    public void setShowValue(boolean newValue) {
        this.showValue.set(newValue);
    }

    /**
     * @return the types as an EnumSet
     */
    public EnumSet<GameEnums.TraitMod> getTypes() {
        return types;
    }
    
    /**
     * @param multiTypes the type to set
     */
    public void setTypes(EnumSet<GameEnums.TraitMod> multiTypes) {
        this.types = multiTypes;
    }
    
//    private boolean validateTypeArray(trait_type[] multiTypes) {
//        if(multiTypes == null) {return false;} //is the array null?
//        //are any of the array elements null?
//        for(trait_type temp : multiTypes) {
//            if(temp == null) {return false;}
//        }
//        
//        return true;
//    }
    
    @Override
    public String toString() {
        return name.get() + ": " + value.get();
    }
    
    public String toStringVerbose() {
        String stringTypes = "";
        for(GameEnums.TraitMod t : types) {
            stringTypes += t.name() + " ";
        }
        
        return name.get() + ": " + value.get() + "\n" + stringTypes + "\n" + description.get();
    }
    
    /**
     * Tests for equality based on name, groupName, and id only
     * @param t
     * @return 
     */
    public boolean equalShallow(Trait t) {
        if(t == null)                                            {return false;} //is the other null?
        if(this == t)                                            {return true;} //is the other me?
        if(!this.getName().equals(t.getName()))     {return false;} //do they have the same name? 
        
        //do they have the same group name and id?
        if(this.getGroupName() == null && t.getGroupName() == null) {
            return this.getIdNum() == t.getIdNum();
        }
        
        return this.getGroupName().equals(t.getGroupName()) && (this.getIdNum() == t.getIdNum());
    }
    
    /**
     * Tests for equality based on name, groupName, id, value, types, and description
     * @param t
     * @return 
     */
    @Override
    public boolean equals(Object t) {
        if(t == null) {return false;} //is the other null?
        if(this == t) {return true;} //is the other me?
        if(!(t instanceof Trait)) {return false;} //is it a Trait?
        
        Trait temp = (Trait) t;
        if(!this.getGroupName().equals(temp.getGroupName()))      {return false;} //same group?
        if(this.getIdNum() != temp.getIdNum())                              {return false;} //same id within group?
        if(!this.getName().equals(temp.getName()))                       {return false;} //same name?
        if(this.getValue() != temp.getValue())                                {return false;} //same value?
        if(!this.getTypes().equals(temp.getTypes()))                      {return false;} //same types?
        return this.getDesc().equals(temp.getDesc());                                       //same description?;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.value);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.types);
        return hash;
    }
    
    
}
