/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

/**
 * Used to define requirements for Tasks. 
 * 
 * Example: Want at least 3 Kobolds with Cuteness at least 2
 * Requirement(KoboldGN, KoboldIN, ENTITY, GREATER, 2, additionalReq ---->
 *      Requirement(CuteGN, CuteIN, PERSONAL,GREATER, 1, null) 
 * 
 * The additionalReqs should only be used to ask for Traits, Flags, and Tasks of an Entity
 * 
 * 
 * @author MLaptop
 */
public class Requirement {

    private final String groupName;
    private final int idNum;
    private final GameEnums.Type gameElement;
    private final GameEnums.RelOp operator;
    private final int value;
    private final Requirement[] additionalReqs;
    private final String text;
    
    public Requirement(String GN, int IN, GameEnums.Type GE, GameEnums.RelOp OP, int V, String T) {
        this.groupName = GN;
        this.idNum = IN;
        this.gameElement = GE;
        this.operator = OP;
        this.value = V;
        this.additionalReqs = null;
        this.text = T;
    }
    
    public Requirement(String GN, int IN, GameEnums.Type GE, GameEnums.RelOp OP, int V, Requirement[] REQ, String T) {
        this.groupName = GN;
        this.idNum = IN;
        this.gameElement = GE;
        this.operator = OP;
        this.value = V;
        this.additionalReqs = REQ;
        this.text = T;
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
     * @return the operator
     */
    public GameEnums.RelOp getOperator() {
        return operator;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the additionalReqs
     */
    public Requirement[] getAdditionalReq() {
        return additionalReqs;
    }
}
