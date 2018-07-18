/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

/**
 * Could add constructors for more options, like creating something that starts already working on a 
 * given Task
 * 
 * @author MLaptop
 */
public class Result {
    private final String groupName;
    private final int idNum;
    private final GameEnums.Type gameElement;
    private final int value;
    private final GameEnums.Outcome effect;
    
    public Result(String GN, int IN, GameEnums.Type GE, int V, GameEnums.Outcome E) {
        this.groupName = GN;
        this.idNum = IN;
        this.gameElement = GE;
        this.value = V;
        this.effect = E;
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
    
    /**
     * @return the effect
     */
    public GameEnums.Outcome getEffect() {
        return effect;
    }
}
