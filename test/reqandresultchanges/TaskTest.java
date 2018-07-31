/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.EnumSet;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
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
public class TaskTest {
    
    public TaskTest() {
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
     * Test of isNoTask method, of class Task.
     */
    @Test
    public void testIsNoTask() {
        System.out.println("isNoTask");
        Task instance = new Task();
        boolean expResult = false;
        boolean result = instance.isNoTask();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLinkTask method, of class Task.
     */
    @Test
    public void testSetLinkTask() {
        System.out.println("setLinkTask");
        Task t = null;
        Entity e = null;
        Task instance = new Task();
        instance.setLinkTask(t, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNoTask method, of class Task.
     */
    @Test
    public void testSetNoTask() {
        System.out.println("setNoTask");
        Task instance = new Task();
        instance.setNoTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Task.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Task instance = new Task();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setToNewTask method, of class Task.
     */
    @Test
    public void testSetToNewTask() {
        System.out.println("setToNewTask");
        Task t = null;
        Task instance = new Task();
        instance.setToNewTask(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Task.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object t = null;
        Task instance = new Task();
        boolean expResult = false;
        boolean result = instance.equals(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Task.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Task instance = new Task();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Task.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Task instance = new Task();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Task.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newName = "";
        Task instance = new Task();
        instance.setName(newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNameProp method, of class Task.
     */
    @Test
    public void testGetNameProp() {
        System.out.println("getNameProp");
        Task instance = new Task();
        SimpleStringProperty expResult = null;
        SimpleStringProperty result = instance.getNameProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdNum method, of class Task.
     */
    @Test
    public void testGetIdNum() {
        System.out.println("getIdNum");
        Task instance = new Task();
        int expResult = 0;
        int result = instance.getIdNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdNum method, of class Task.
     */
    @Test
    public void testSetIdNum() {
        System.out.println("setIdNum");
        int idNum = 0;
        Task instance = new Task();
        instance.setIdNum(idNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDuration method, of class Task.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        Task instance = new Task();
        int expResult = 0;
        int result = instance.getDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDuration method, of class Task.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        int newDuration = 0;
        Task instance = new Task();
        instance.setDuration(newDuration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDurationProp method, of class Task.
     */
    @Test
    public void testGetDurationProp() {
        System.out.println("getDurationProp");
        Task instance = new Task();
        SimpleIntegerProperty expResult = null;
        SimpleIntegerProperty result = instance.getDurationProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDurationProp method, of class Task.
     */
    @Test
    public void testSetDurationProp() {
        System.out.println("setDurationProp");
        SimpleIntegerProperty duration = null;
        Task instance = new Task();
        instance.setDurationProp(duration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGerund method, of class Task.
     */
    @Test
    public void testGetGerund() {
        System.out.println("getGerund");
        Task instance = new Task();
        String expResult = "";
        String result = instance.getGerund();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGerund method, of class Task.
     */
    @Test
    public void testSetGerund() {
        System.out.println("setGerund");
        String newGerund = "";
        Task instance = new Task();
        instance.setGerund(newGerund);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGerundProp method, of class Task.
     */
    @Test
    public void testGetGerundProp() {
        System.out.println("getGerundProp");
        Task instance = new Task();
        SimpleStringProperty expResult = null;
        SimpleStringProperty result = instance.getGerundProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCosts method, of class Task.
     */
    @Test
    public void testGetCosts() {
        System.out.println("getCosts");
        Task instance = new Task();
        ObservableList<Cost> expResult = null;
        ObservableList<Cost> result = instance.getCosts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequirements method, of class Task.
     */
    @Test
    public void testGetRequirements() {
        System.out.println("getRequirements");
        Task instance = new Task();
        ObservableList<Requirement> expResult = null;
        ObservableList<Requirement> result = instance.getRequirements();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResults method, of class Task.
     */
    @Test
    public void testGetResults() {
        System.out.println("getResults");
        Task instance = new Task();
        ObservableList<Result> expResult = null;
        ObservableList<Result> result = instance.getResults();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResults method, of class Task.
     */
    @Test
    public void testSetResults() {
        System.out.println("setResults");
        Result[] newResults = null;
        Task instance = new Task();
        instance.setResults(newResults);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResultsList method, of class Task.
     */
    @Test
    public void testSetResultsList() {
        System.out.println("setResultsList");
        List<Result> newResults = null;
        Task instance = new Task();
        instance.setResultsList(newResults);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultsProp method, of class Task.
     */
    @Test
    public void testGetResultsProp() {
        System.out.println("getResultsProp");
        Task instance = new Task();
        SimpleListProperty<Result> expResult = null;
        SimpleListProperty<Result> result = instance.getResultsProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNameProp method, of class Task.
     */
    @Test
    public void testSetNameProp() {
        System.out.println("setNameProp");
        SimpleStringProperty name = null;
        Task instance = new Task();
        instance.setNameProp(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCostsProp method, of class Task.
     */
    @Test
    public void testGetCostsProp() {
        System.out.println("getCostsProp");
        Task instance = new Task();
        SimpleListProperty<Cost> expResult = null;
        SimpleListProperty<Cost> result = instance.getCostsProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCosts method, of class Task.
     */
    @Test
    public void testSetCosts() {
        System.out.println("setCosts");
        Cost[] newCosts = null;
        Task instance = new Task();
        instance.setCosts(newCosts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCostsList method, of class Task.
     */
    @Test
    public void testSetCostsList() {
        System.out.println("setCostsList");
        List<Cost> newCosts = null;
        Task instance = new Task();
        instance.setCostsList(newCosts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCostsProp method, of class Task.
     */
    @Test
    public void testSetCostsProp() {
        System.out.println("setCostsProp");
        SimpleListProperty<Cost> newCosts = null;
        Task instance = new Task();
        instance.setCostsProp(newCosts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequirementsProp method, of class Task.
     */
    @Test
    public void testGetRequirementsProp() {
        System.out.println("getRequirementsProp");
        Task instance = new Task();
        SimpleListProperty<Requirement> expResult = null;
        SimpleListProperty<Requirement> result = instance.getRequirementsProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRequirements method, of class Task.
     */
    @Test
    public void testSetRequirements() {
        System.out.println("setRequirements");
        Requirement[] newRequirements = null;
        Task instance = new Task();
        instance.setRequirements(newRequirements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRequirementsList method, of class Task.
     */
    @Test
    public void testSetRequirementsList() {
        System.out.println("setRequirementsList");
        List<Requirement> newRequirements = null;
        Task instance = new Task();
        instance.setRequirementsList(newRequirements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRequirementsProp method, of class Task.
     */
    @Test
    public void testSetRequirementsProp() {
        System.out.println("setRequirementsProp");
        SimpleListProperty<Requirement> newRequirements = null;
        Task instance = new Task();
        instance.setRequirementsProp(newRequirements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlavorProp method, of class Task.
     */
    @Test
    public void testGetFlavorProp() {
        System.out.println("getFlavorProp");
        Task instance = new Task();
        SimpleStringProperty expResult = null;
        SimpleStringProperty result = instance.getFlavorProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlavor method, of class Task.
     */
    @Test
    public void testGetFlavor() {
        System.out.println("getFlavor");
        Task instance = new Task();
        String expResult = "";
        String result = instance.getFlavor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFlavor method, of class Task.
     */
    @Test
    public void testSetFlavor() {
        System.out.println("setFlavor");
        String newFlavor = "";
        Task instance = new Task();
        instance.setFlavor(newFlavor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFlavorProp method, of class Task.
     */
    @Test
    public void testSetFlavorProp() {
        System.out.println("setFlavorProp");
        SimpleStringProperty flavor = null;
        Task instance = new Task();
        instance.setFlavorProp(flavor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModifiers method, of class Task.
     */
    @Test
    public void testGetModifiers() {
        System.out.println("getModifiers");
        Task instance = new Task();
        EnumSet<GameEnums.TaskMod> expResult = null;
        EnumSet<GameEnums.TaskMod> result = instance.getModifiers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModifiers method, of class Task.
     */
    @Test
    public void testSetModifiers() {
        System.out.println("setModifiers");
        EnumSet<GameEnums.TaskMod> newMods = null;
        Task instance = new Task();
        instance.setModifiers(newMods);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
