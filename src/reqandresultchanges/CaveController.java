/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import javafx.event.ActionEvent;

/**
 *
 * @author MLaptop
 */
interface CaveController {
    
    void addRoom(Room r);
    void removeRoom(Room r);
    void addEntity(Entity a);
    void removeEntity(Entity a);
    void removeByID(String id);
    void setEngine(Engine e);
    Engine getEngine();
    void exitFired(ActionEvent e);
    void updateFired(ActionEvent e);
}
