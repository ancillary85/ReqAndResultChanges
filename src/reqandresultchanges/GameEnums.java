/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

/**
 *
 * @author MLaptop
 */
public class GameEnums {
    
    public static enum RelOp {
        EQUAL, NOTEQUAL, LESS, GREATER
    }
    
    /**
     * EVENT and ANNOUNCEMENT are both GameEvents, but ANNOUNCEMENT is meant only to display some text 
     * as part of a Result, like "Alice grew 3 inches" after she completes her Grow Task.
     */
    public static enum Type {
        EVENT, ANNOUNCEMENT, ENTITY, GLOBAL_TRAIT, TRAIT, TASK, FLAG, GLOBAL_FLAG
    }
    
    public static enum TaskMod {
        AUTOTASK, UNCANCELABLE
    }
    
    public static enum Outcome {
        SELF_CHANGE, LINKED_CHANGE, CREATE, UNCREATE, 
        ADD_TRAIT_SELF, REMOVE_TRAIT_SELF, ADD_TRAIT_LINKED, REMOVE_TRAIT_LINKED,
        ADD_TASK_SELF, REMOVE_TASK_SELF, ADD_TASK_LINKED, REMOVE_TASK_LINKED,
        SET_FLAG_SELF, UNSET_FLAG_SELF, SET_FLAG_LINK, UNSET_FLAG_LINKED,
        ADD_TRAIT_GLOBAL, REMOVE_TRAIT_GLOBAL,
        SET_FLAG_GLOBAL, UNSET_FLAG_GLOBAL
        //Something about GameEvents being started and stopped
    }
}
