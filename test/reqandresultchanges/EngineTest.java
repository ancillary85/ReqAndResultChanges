/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MMLaptop
 */
public class EngineTest {
    
    public EngineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getGlobalResources method, of class Engine.
     */
    @Test
    public void testGetGlobalResources() {
        System.out.println("getGlobalResources");
        Engine instance = new Engine();
        SimpleListProperty<Trait> expResult = null;
        SimpleListProperty<Trait> result = instance.getGlobalResources();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGlobalFlags method, of class Engine.
     */
    @Test
    public void testGetGlobalFlags() {
        System.out.println("getGlobalFlags");
        Engine instance = new Engine();
        SimpleListProperty<Flag> expResult = null;
        SimpleListProperty<Flag> result = instance.getGlobalFlags();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGlobalFlag method, of class Engine.
     */
    @Test
    public void testGetGlobalFlag() {
        System.out.println("getGlobalFlag");
        Flag f = null;
        Engine instance = new Engine();
        Flag expResult = null;
        Flag result = instance.getGlobalFlag(f);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasGlobalResourceName method, of class Engine.
     */
    @Test
    public void testHasGlobalResourceName() {
        System.out.println("hasGlobalResourceName");
        String name = "";
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.hasGlobalResourceName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasGlobalResource method, of class Engine.
     */
    @Test
    public void testHasGlobalResource() {
        System.out.println("hasGlobalResource");
        Trait t = null;
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.hasGlobalResource(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGlobalResource method, of class Engine.
     */
    @Test
    public void testGetGlobalResource() {
        System.out.println("getGlobalResource");
        Trait t = null;
        Engine instance = new Engine();
        Trait expResult = null;
        Trait result = instance.getGlobalResource(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addResource method, of class Engine.
     */
    @Test
    public void testAddResource_3args() {
        System.out.println("addResource");
        String name = "";
        int value = 0;
        String desc = "";
        Engine instance = new Engine();
        instance.addResource(name, value, desc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addResource method, of class Engine.
     */
    @Test
    public void testAddResource_Trait() {
        System.out.println("addResource");
        Trait t = null;
        Engine instance = new Engine();
        instance.addResource(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addResourceById method, of class Engine.
     */
    @Test
    public void testAddResourceById() {
        System.out.println("addResourceById");
        String group = "";
        int id = 0;
        int value = 0;
        Engine instance = new Engine();
        instance.addResourceById(group, id, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToEntityById method, of class Engine.
     */
    @Test
    public void testAddToEntityById() {
        System.out.println("addToEntityById");
        Entity target = null;
        String group = "";
        int id = 0;
        int value = 0;
        Engine instance = new Engine();
        instance.addToEntityById(target, group, id, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resourcesReport method, of class Engine.
     */
    @Test
    public void testResourcesReport() {
        System.out.println("resourcesReport");
        Engine instance = new Engine();
        String expResult = "";
        String result = instance.resourcesReport();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resourcesReportDesc method, of class Engine.
     */
    @Test
    public void testResourcesReportDesc() {
        System.out.println("resourcesReportDesc");
        Engine instance = new Engine();
        String expResult = "";
        String result = instance.resourcesReportDesc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getController method, of class Engine.
     */
    @Test
    public void testGetController() {
        System.out.println("getController");
        Engine instance = new Engine();
        CaveController expResult = null;
        CaveController result = instance.getController();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setController method, of class Engine.
     */
    @Test
    public void testSetController() {
        System.out.println("setController");
        CaveController controller = null;
        Engine instance = new Engine();
        instance.setController(controller);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurnCount method, of class Engine.
     */
    @Test
    public void testGetTurnCount() {
        System.out.println("getTurnCount");
        Engine instance = new Engine();
        int expResult = 0;
        int result = instance.getTurnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurnCount method, of class Engine.
     */
    @Test
    public void testSetTurnCount() {
        System.out.println("setTurnCount");
        int newTurnCount = 0;
        Engine instance = new Engine();
        instance.setTurnCount(newTurnCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementTurnCount method, of class Engine.
     */
    @Test
    public void testIncrementTurnCount() {
        System.out.println("incrementTurnCount");
        Engine instance = new Engine();
        instance.incrementTurnCount();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurnCountProp method, of class Engine.
     */
    @Test
    public void testGetTurnCountProp() {
        System.out.println("getTurnCountProp");
        Engine instance = new Engine();
        SimpleIntegerProperty expResult = null;
        SimpleIntegerProperty result = instance.getTurnCountProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPendingEvents method, of class Engine.
     */
    @Test
    public void testGetPendingEvents() {
        System.out.println("getPendingEvents");
        Engine instance = new Engine();
        SimpleListProperty<GameEvent> expResult = null;
        SimpleListProperty<GameEvent> result = instance.getPendingEvents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPendingEvents method, of class Engine.
     */
    @Test
    public void testSetPendingEvents() {
        System.out.println("setPendingEvents");
        ArrayList<GameEvent> newPending = null;
        Engine instance = new Engine();
        instance.setPendingEvents(newPending);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUpdateWarnings method, of class Engine.
     */
    @Test
    public void testGetUpdateWarnings() {
        System.out.println("getUpdateWarnings");
        Engine instance = new Engine();
        SimpleListProperty<GameEvent> expResult = null;
        SimpleListProperty<GameEvent> result = instance.getUpdateWarnings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUpdateWarnings method, of class Engine.
     */
    @Test
    public void testSetUpdateWarnings() {
        System.out.println("setUpdateWarnings");
        ArrayList<GameEvent> newWarnings = null;
        Engine instance = new Engine();
        instance.setUpdateWarnings(newWarnings);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnresolvedUpdateWarnings method, of class Engine.
     */
    @Test
    public void testGetUnresolvedUpdateWarnings() {
        System.out.println("getUnresolvedUpdateWarnings");
        Engine instance = new Engine();
        ArrayList<GameEvent> expResult = null;
        ArrayList<GameEvent> result = instance.getUnresolvedUpdateWarnings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Engine.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Engine instance = new Engine();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEventReady method, of class Engine.
     */
    @Test
    public void testIsEventReady() {
        System.out.println("isEventReady");
        GameEvent e = null;
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.isEventReady(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processEventResults method, of class Engine.
     */
    @Test
    public void testProcessEventResults() {
        System.out.println("processEventResults");
        GameEvent e = null;
        Engine instance = new Engine();
        instance.processEventResults(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUpdateWarnings method, of class Engine.
     */
    @Test
    public void testCheckUpdateWarnings() {
        System.out.println("checkUpdateWarnings");
        Engine instance = new Engine();
        instance.checkUpdateWarnings();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUnskippableWarnings method, of class Engine.
     */
    @Test
    public void testCheckUnskippableWarnings() {
        System.out.println("checkUnskippableWarnings");
        Engine instance = new Engine();
        instance.checkUnskippableWarnings();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAutoTask method, of class Engine.
     */
    @Test
    public void testGetAutoTask() {
        System.out.println("getAutoTask");
        Entity e = null;
        Engine instance = new Engine();
        Task expResult = null;
        Task result = instance.getAutoTask(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of currentUncancelableTask method, of class Engine.
     */
    @Test
    public void testCurrentUncancelableTask() {
        System.out.println("currentUncancelableTask");
        Entity e = null;
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.currentUncancelableTask(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelTaskRefundCosts method, of class Engine.
     */
    @Test
    public void testCancelTaskRefundCosts() {
        System.out.println("cancelTaskRefundCosts");
        Entity e = null;
        Engine instance = new Engine();
        instance.cancelTaskRefundCosts(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaskPayCosts method, of class Engine.
     */
    @Test
    public void testSetTaskPayCosts() {
        System.out.println("setTaskPayCosts");
        Task t = null;
        Entity e = null;
        Engine instance = new Engine();
        instance.setTaskPayCosts(t, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResourceValue method, of class Engine.
     */
    @Test
    public void testGetResourceValue() {
        System.out.println("getResourceValue");
        String name = "";
        Engine instance = new Engine();
        int expResult = 0;
        int result = instance.getResourceValue(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntityCount method, of class Engine.
     */
    @Test
    public void testGetEntityCount() {
        System.out.println("getEntityCount");
        String group = "";
        int id = 0;
        Engine instance = new Engine();
        int expResult = 0;
        int result = instance.getEntityCount(group, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFreeEntityCount method, of class Engine.
     */
    @Test
    public void testGetFreeEntityCount() {
        System.out.println("getFreeEntityCount");
        String group = "";
        int id = 0;
        Engine instance = new Engine();
        int expResult = 0;
        int result = instance.getFreeEntityCount(group, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntityCountByName method, of class Engine.
     */
    @Test
    public void testGetEntityCountByName() {
        System.out.println("getEntityCountByName");
        String name = "";
        Engine instance = new Engine();
        int expResult = 0;
        int result = instance.getEntityCountByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFreeEntityCountByName method, of class Engine.
     */
    @Test
    public void testGetFreeEntityCountByName() {
        System.out.println("getFreeEntityCountByName");
        String name = "";
        Engine instance = new Engine();
        int expResult = 0;
        int result = instance.getFreeEntityCountByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomCount method, of class Engine.
     */
    @Test
    public void testGetRoomCount() {
        System.out.println("getRoomCount");
        String group = "";
        int id = 0;
        Engine instance = new Engine();
        int expResult = 0;
        int result = instance.getRoomCount(group, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomCountByName method, of class Engine.
     */
    @Test
    public void testGetRoomCountByName() {
        System.out.println("getRoomCountByName");
        String name = "";
        Engine instance = new Engine();
        int expResult = 0;
        int result = instance.getRoomCountByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of requirementMet method, of class Engine.
     */
    @Test
    public void testRequirementMet() {
        System.out.println("requirementMet");
        Engine instance = new Engine();
        Requirement req = new Requirement("Test", 0, GameEnums.Type.TRAIT, GameEnums.RelOp.EQUAL, 4, "Foobar");
        ArrayList<Trait> traitList = new ArrayList();
        Trait t = new Trait("Cuteness", 0, "uguu", EnumSet.of(GameEnums.TraitMod.FLAVOR), "Test", 0);
        traitList.add(t);
        
        Entity e = new Entity();
        instance.getPredefinedData().addDefaultTraits("Test", traitList);
       
        assertNotNull(instance.getPredefinedData().getTraitByNum("Test", 0));
        instance.addResource(t);
        assertTrue(instance.getResourceValue("Cuteness") == 0);
        
//        boolean expResult = false;
//        boolean result = instance.requirementMet(req, e);
//        assertEquals(expResult, result);
        
    }
//public Trait(String name, int value, String description, EnumSet<GameEnums.TraitMod> initTypes, String group, int id) {
    /**
     * Test of requirementsAllMet method, of class Engine.
     */
    @Test
    public void testRequirementsAllMet() {
        System.out.println("requirementsAllMet");
        List<Requirement> reqs = null;
        Entity e = null;
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.requirementsAllMet(reqs, e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equalToReqMet method, of class Engine.
     */
    @Test
    public void testEqualToReqMet() {
        System.out.println("equalToReqMet");
        Requirement req = null;
        Entity e = null;
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.equalToReqMet(req, e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notEqualReqMet method, of class Engine.
     */
    @Test
    public void testNotEqualReqMet() {
        System.out.println("notEqualReqMet");
        Requirement req = null;
        Entity e = null;
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.notEqualReqMet(req, e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lessThanReqMet method, of class Engine.
     */
    @Test
    public void testLessThanReqMet() {
        System.out.println("lessThanReqMet");
        Requirement req = null;
        Entity e = null;
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.lessThanReqMet(req, e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of greaterThanReqMet method, of class Engine.
     */
    @Test
    public void testGreaterThanReqMet() {
        System.out.println("greaterThanReqMet");
        Requirement req = null;
        Entity e = null;
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.greaterThanReqMet(req, e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPredefinedData method, of class Engine.
     */
    @Test
    public void testGetPredefinedData() {
        System.out.println("getPredefinedData");
        Engine instance = new Engine();
        PredefinedData expResult = null;
        PredefinedData result = instance.getPredefinedData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRoom method, of class Engine.
     */
    @Test
    public void testAddRoom() {
        System.out.println("addRoom");
        Room r = null;
        Engine instance = new Engine();
        instance.addRoom(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRooms method, of class Engine.
     */
    @Test
    public void testGetRooms() {
        System.out.println("getRooms");
        Engine instance = new Engine();
        List<Room> expResult = null;
        List<Room> result = instance.getRooms();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReachableRooms method, of class Engine.
     */
    @Test
    public void testGetReachableRooms() {
        System.out.println("getReachableRooms");
        Engine instance = new Engine();
        List<Room> expResult = null;
        List<Room> result = instance.getReachableRooms();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReachable method, of class Engine.
     */
    @Test
    public void testSetReachable() {
        System.out.println("setReachable");
        int pos = 0;
        boolean reachable = false;
        Engine instance = new Engine();
        instance.setReachable(pos, reachable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRooms method, of class Engine.
     */
    @Test
    public void testSetRooms() {
        System.out.println("setRooms");
        List<Room> newRooms = null;
        Engine instance = new Engine();
        instance.setRooms(newRooms);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoom method, of class Engine.
     */
    @Test
    public void testSetRoom() {
        System.out.println("setRoom");
        Room r = null;
        int pos = 0;
        Engine instance = new Engine();
        instance.setRoom(r, pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomEmpty method, of class Engine.
     */
    @Test
    public void testSetRoomEmpty() {
        System.out.println("setRoomEmpty");
        Room r = null;
        Engine instance = new Engine();
        instance.setRoomEmpty(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeRoom method, of class Engine.
     */
    @Test
    public void testRemoveRoom() {
        System.out.println("removeRoom");
        Room r = null;
        Engine instance = new Engine();
        instance.removeRoom(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeRoom method, of class Engine.
     */
    @Test
    public void testChangeRoom() {
        System.out.println("changeRoom");
        Room r = null;
        Task t = null;
        Engine instance = new Engine();
        instance.changeRoom(r, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeEntity method, of class Engine.
     */
    @Test
    public void testChangeEntity() {
        System.out.println("changeEntity");
        Entity e = null;
        Task t = null;
        Engine instance = new Engine();
        instance.changeEntity(e, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEntity method, of class Engine.
     */
    @Test
    public void testAddEntity() {
        System.out.println("addEntity");
        Entity e = null;
        Engine instance = new Engine();
        instance.addEntity(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntities method, of class Engine.
     */
    @Test
    public void testGetEntities() {
        System.out.println("getEntities");
        Engine instance = new Engine();
        List<Entity> expResult = null;
        List<Entity> result = instance.getEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEntities method, of class Engine.
     */
    @Test
    public void testSetEntities() {
        System.out.println("setEntities");
        List<Entity> newEntities = null;
        Engine instance = new Engine();
        instance.setEntities(newEntities);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEntity method, of class Engine.
     */
    @Test
    public void testRemoveEntity() {
        System.out.println("removeEntity");
        Entity e = null;
        Engine instance = new Engine();
        instance.removeEntity(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of linkEntities method, of class Engine.
     */
    @Test
    public void testLinkEntities() {
        System.out.println("linkEntities");
        Entity e1 = null;
        Entity e2 = null;
        Engine instance = new Engine();
        instance.linkEntities(e1, e2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of areLinked method, of class Engine.
     */
    @Test
    public void testAreLinked() {
        System.out.println("areLinked");
        Entity e1 = null;
        Entity e2 = null;
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.areLinked(e1, e2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unlinkActives method, of class Engine.
     */
    @Test
    public void testUnlinkActives() {
        System.out.println("unlinkActives");
        Entity e1 = null;
        Entity e2 = null;
        Engine instance = new Engine();
        instance.unlinkActives(e1, e2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unlinkAllEntities method, of class Engine.
     */
    @Test
    public void testUnlinkAllEntities() {
        System.out.println("unlinkAllEntities");
        Entity e1 = null;
        Engine instance = new Engine();
        HashSet<Entity> expResult = null;
        HashSet<Entity> result = instance.unlinkAllEntities(e1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLinkedEntity method, of class Engine.
     */
    @Test
    public void testGetLinkedEntity() {
        System.out.println("getLinkedEntity");
        Entity e = null;
        Engine instance = new Engine();
        HashSet<Entity> expResult = null;
        HashSet<Entity> result = instance.getLinkedEntity(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLinked method, of class Engine.
     */
    @Test
    public void testIsLinked() {
        System.out.println("isLinked");
        Entity e = null;
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.isLinked(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
