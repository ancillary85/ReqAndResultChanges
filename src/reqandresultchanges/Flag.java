/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author MMLaptop
 */
public class Flag {
    private final SimpleStringProperty name;
    private final SimpleBooleanProperty state;
    private final SimpleStringProperty text;
    private final String groupName;
    private final int idNum;
    
    public Flag(String initName, boolean initState, String initGroup, int initNum) {
        name = new SimpleStringProperty(initName);
        state = new SimpleBooleanProperty(initState);
        text = new SimpleStringProperty();
        groupName = initGroup;
        idNum = initNum;
    }
    
    public Flag(String initName, boolean initState, String body, String initGroup, int initNum) {
        name = new SimpleStringProperty(initName);
        state = new SimpleBooleanProperty(initState);
        text = new SimpleStringProperty(body);
        groupName = initGroup;
        idNum = initNum;
    }
    
    public String getFlagName() {
        return name.get();
    }
    
    public SimpleStringProperty getFlagNameProp() {
        return name;
    }
    
    public boolean getFlagState() {
        return state.get();
    }
    
    public SimpleBooleanProperty getFlagStateProp() {
        return state;
    }
    
    public void setFlagTrue() {
        state.set(true);
    }
    
    public void setFlagFalse() {
        state.set(false);
    }
    
    public String getFlagText() {
        return text.get();
    }
    
    public SimpleStringProperty getFlagTextProp() {
        return text;
    }
    
    public void setFlagText(String newText) {
        text.set(newText);
    }
    
    public String getFlagGroupName() {
        return groupName;
    }
    
    public int getFlagIdNum() {
        return idNum;
    }
}
