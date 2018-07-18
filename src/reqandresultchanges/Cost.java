/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

/**
 *
 * @author MMLaptop
 */
public class Cost {
    private final String groupName;
    private final int idNum;
    private final GameEnums.Type gameElement;
    private final int value;
    private final String text;
    
    public Cost(String group, int id, GameEnums.Type type, int amount, String body) {
        this.groupName = group;
        this.idNum = id;
        this.gameElement = type;
        this.value = amount;
        this.text = body;
    }
    
    @Override
    public String toString() {
        return text;
    }
    
    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @return the idNum
     */
    public int getIdNum() {
        return idNum;
    }

    /**
     * @return the gameElement
     */
    public GameEnums.Type getGameElement() {
        return gameElement;
    }
    
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
}
