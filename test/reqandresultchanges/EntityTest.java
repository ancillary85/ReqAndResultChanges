/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
public class EntityTest {
    
    public EntityTest() {
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
     * Test of getTasks method, of class Entity.
     */
    @Test
    public void testGetTasks() {
        System.out.println("getTasks");
        Entity instance = new Entity();
        List<Task> expResult = null;
        List<Task> result = instance.getTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTasks method, of class Entity.
     */
    @Test
    public void testSetTasks() {
        System.out.println("setTasks");
        List<Task> newTasks = null;
        Entity instance = new Entity();
        instance.setTasks(newTasks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlags method, of class Entity.
     */
    @Test
    public void testGetFlags() {
        System.out.println("getFlags");
        Entity instance = new Entity();
        List<Flag> expResult = null;
        List<Flag> result = instance.getFlags();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFlags method, of class Entity.
     */
    @Test
    public void testSetFlags() {
        System.out.println("setFlags");
        List<Flag> newFlags = null;
        Entity instance = new Entity();
        instance.setFlags(newFlags);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class Entity.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Task newTask = null;
        Entity instance = new Entity();
        instance.addTask(newTask);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTasks method, of class Entity.
     */
    @Test
    public void testAddTasks() {
        System.out.println("addTasks");
        List<Task> newTasks = null;
        Entity instance = new Entity();
        instance.addTasks(newTasks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTask method, of class Entity.
     */
    @Test
    public void testRemoveTask() {
        System.out.println("removeTask");
        Task oldTask = null;
        Entity instance = new Entity();
        instance.removeTask(oldTask);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskTimerProp method, of class Entity.
     */
    @Test
    public void testGetTaskTimerProp() {
        System.out.println("getTaskTimerProp");
        Entity instance = new Entity();
        SimpleIntegerProperty expResult = null;
        SimpleIntegerProperty result = instance.getTaskTimerProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskTimer method, of class Entity.
     */
    @Test
    public void testGetTaskTimer() {
        System.out.println("getTaskTimer");
        Entity instance = new Entity();
        int expResult = 0;
        int result = instance.getTaskTimer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaskTimer method, of class Entity.
     */
    @Test
    public void testSetTaskTimer() {
        System.out.println("setTaskTimer");
        int newTime = 0;
        Entity instance = new Entity();
        instance.setTaskTimer(newTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaskTimerFromCurrentTask method, of class Entity.
     */
    @Test
    public void testSetTaskTimerFromCurrentTask() {
        System.out.println("setTaskTimerFromCurrentTask");
        Entity instance = new Entity();
        instance.setTaskTimerFromCurrentTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentTask method, of class Entity.
     */
    @Test
    public void testGetCurrentTask() {
        System.out.println("getCurrentTask");
        Entity instance = new Entity();
        Task expResult = null;
        Task result = instance.getCurrentTask();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaskAndTimer method, of class Entity.
     */
    @Test
    public void testSetTaskAndTimer() {
        System.out.println("setTaskAndTimer");
        Task t = null;
        Entity instance = new Entity();
        instance.setTaskAndTimer(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentTask method, of class Entity.
     */
    @Test
    public void testSetCurrentTask_int() {
        System.out.println("setCurrentTask");
        int taskNumber = 0;
        Entity instance = new Entity();
        instance.setCurrentTask(taskNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentTask method, of class Entity.
     */
    @Test
    public void testSetCurrentTask_Task() {
        System.out.println("setCurrentTask");
        Task newTask = null;
        Entity instance = new Entity();
        instance.setCurrentTask(newTask);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAndSetCurrentTask method, of class Entity.
     */
    @Test
    public void testAddAndSetCurrentTask() {
        System.out.println("addAndSetCurrentTask");
        Task newTask = null;
        Entity instance = new Entity();
        instance.addAndSetCurrentTask(newTask);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matchEntity method, of class Entity.
     */
    @Test
    public void testMatchEntity() {
        System.out.println("matchEntity");
        Entity toMatch = null;
        Entity instance = new Entity();
        instance.matchEntity(toMatch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLinked method, of class Entity.
     */
    @Test
    public void testSetLinked() {
        System.out.println("setLinked");
        Task t = null;
        Entity e = null;
        Entity instance = new Entity();
        instance.setLinked(t, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskCompleted method, of class Entity.
     */
    @Test
    public void testGetTaskCompleted() {
        System.out.println("getTaskCompleted");
        Entity instance = new Entity();
        boolean expResult = false;
        boolean result = instance.getTaskCompleted();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskCompletedProp method, of class Entity.
     */
    @Test
    public void testGetTaskCompletedProp() {
        System.out.println("getTaskCompletedProp");
        Entity instance = new Entity();
        SimpleBooleanProperty expResult = null;
        SimpleBooleanProperty result = instance.getTaskCompletedProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaskCompleted method, of class Entity.
     */
    @Test
    public void testSetTaskCompleted() {
        System.out.println("setTaskCompleted");
        boolean taskStatus = false;
        Entity instance = new Entity();
        instance.setTaskCompleted(taskStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of idle method, of class Entity.
     */
    @Test
    public void testIdle() {
        System.out.println("idle");
        Entity instance = new Entity();
        instance.idle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of activeUpdate method, of class Entity.
     */
    @Test
    public void testActiveUpdate() {
        System.out.println("activeUpdate");
        String[] args = null;
        Entity instance = new Entity();
        instance.activeUpdate(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of completeTask method, of class Entity.
     */
    @Test
    public void testCompleteTask() {
        System.out.println("completeTask");
        Entity instance = new Entity();
        instance.completeTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearTask method, of class Entity.
     */
    @Test
    public void testClearTask() {
        System.out.println("clearTask");
        Entity instance = new Entity();
        instance.clearTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdleText method, of class Entity.
     */
    @Test
    public void testGetIdleText() {
        System.out.println("getIdleText");
        Entity instance = new Entity();
        String expResult = "";
        String result = instance.getIdleText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdleTextProp method, of class Entity.
     */
    @Test
    public void testGetIdleTextProp() {
        System.out.println("getIdleTextProp");
        Entity instance = new Entity();
        SimpleStringProperty expResult = null;
        SimpleStringProperty result = instance.getIdleTextProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdleText method, of class Entity.
     */
    @Test
    public void testSetIdleText() {
        System.out.println("setIdleText");
        String newIdle = "";
        Entity instance = new Entity();
        instance.setIdleText(newIdle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Entity.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Entity instance = new Entity();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNameProp method, of class Entity.
     */
    @Test
    public void testGetNameProp() {
        System.out.println("getNameProp");
        Entity instance = new Entity();
        SimpleStringProperty expResult = null;
        SimpleStringProperty result = instance.getNameProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Entity.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newName = "";
        Entity instance = new Entity();
        instance.setName(newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdNum method, of class Entity.
     */
    @Test
    public void testGetIdNum() {
        System.out.println("getIdNum");
        Entity instance = new Entity();
        int expResult = 0;
        int result = instance.getIdNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Entity.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Entity instance = new Entity();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupName method, of class Entity.
     */
    @Test
    public void testGetGroupName() {
        System.out.println("getGroupName");
        Entity instance = new Entity();
        String expResult = "";
        String result = instance.getGroupName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupName method, of class Entity.
     */
    @Test
    public void testSetGroupName() {
        System.out.println("setGroupName");
        String group = "";
        Entity instance = new Entity();
        instance.setGroupName(group);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBusyProp method, of class Entity.
     */
    @Test
    public void testGetBusyProp() {
        System.out.println("getBusyProp");
        Entity instance = new Entity();
        SimpleBooleanProperty expResult = null;
        SimpleBooleanProperty result = instance.getBusyProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBusy method, of class Entity.
     */
    @Test
    public void testIsBusy() {
        System.out.println("isBusy");
        Entity instance = new Entity();
        boolean expResult = false;
        boolean result = instance.isBusy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBusy method, of class Entity.
     */
    @Test
    public void testSetBusy() {
        System.out.println("setBusy");
        Entity instance = new Entity();
        instance.setBusy();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotBusy method, of class Entity.
     */
    @Test
    public void testSetNotBusy() {
        System.out.println("setNotBusy");
        Entity instance = new Entity();
        instance.setNotBusy();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Entity.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Entity instance = new Entity();
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Entity.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String newLocation = "";
        Entity instance = new Entity();
        instance.setLocation(newLocation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocationProp method, of class Entity.
     */
    @Test
    public void testGetLocationProp() {
        System.out.println("getLocationProp");
        Entity instance = new Entity();
        SimpleStringProperty expResult = null;
        SimpleStringProperty result = instance.getLocationProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTraits method, of class Entity.
     */
    @Test
    public void testGetTraits() {
        System.out.println("getTraits");
        Entity instance = new Entity();
        List<Trait> expResult = null;
        List<Trait> result = instance.getTraits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTraits method, of class Entity.
     */
    @Test
    public void testSetTraits() {
        System.out.println("setTraits");
        List<Trait> newTraits = null;
        Entity instance = new Entity();
        instance.setTraits(newTraits);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTraitDisplayPriority method, of class Entity.
     */
    @Test
    public void testGetTraitDisplayPriority() {
        System.out.println("getTraitDisplayPriority");
        Entity instance = new Entity();
        GameEnums.TraitMod[] expResult = null;
        GameEnums.TraitMod[] result = instance.getTraitDisplayPriority();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTraitDisplayPriority method, of class Entity.
     */
    @Test
    public void testSetTraitDisplayPriority() {
        System.out.println("setTraitDisplayPriority");
        GameEnums.TraitMod[] traitDisplayPriority = null;
        Entity instance = new Entity();
        instance.setTraitDisplayPriority(traitDisplayPriority);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTraitValue method, of class Entity.
     */
    @Test
    public void testAddTraitValue() {
        System.out.println("addTraitValue");
        Trait t = null;
        Entity instance = new Entity();
        instance.addTraitValue(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtractTraitValue method, of class Entity.
     */
    @Test
    public void testSubtractTraitValue() {
        System.out.println("subtractTraitValue");
        Trait t = null;
        Entity instance = new Entity();
        instance.subtractTraitValue(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtractCostValue method, of class Entity.
     */
    @Test
    public void testSubtractCostValue() {
        System.out.println("subtractCostValue");
        Cost c = null;
        Entity instance = new Entity();
        instance.subtractCostValue(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCostValue method, of class Entity.
     */
    @Test
    public void testAddCostValue() {
        System.out.println("addCostValue");
        Cost c = null;
        Entity instance = new Entity();
        instance.addCostValue(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasTrait method, of class Entity.
     */
    @Test
    public void testHasTrait() {
        System.out.println("hasTrait");
        Trait t = null;
        Entity instance = new Entity();
        boolean expResult = false;
        boolean result = instance.hasTrait(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasTraitName method, of class Entity.
     */
    @Test
    public void testHasTraitName() {
        System.out.println("hasTraitName");
        String traitName = "";
        Entity instance = new Entity();
        boolean expResult = false;
        boolean result = instance.hasTraitName(traitName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTraitValue method, of class Entity.
     */
    @Test
    public void testGetTraitValue() {
        System.out.println("getTraitValue");
        String name = "";
        Entity instance = new Entity();
        int expResult = 0;
        int result = instance.getTraitValue(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTrait method, of class Entity.
     */
    @Test
    public void testAddTrait() {
        System.out.println("addTrait");
        Trait t = null;
        Entity instance = new Entity();
        instance.addTrait(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTrait method, of class Entity.
     */
    @Test
    public void testRemoveTrait() {
        System.out.println("removeTrait");
        Trait toRemove = null;
        Entity instance = new Entity();
        instance.removeTrait(toRemove);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of status method, of class Entity.
     */
    @Test
    public void testStatus() {
        System.out.println("status");
        Entity instance = new Entity();
        String expResult = "";
        String result = instance.status();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
