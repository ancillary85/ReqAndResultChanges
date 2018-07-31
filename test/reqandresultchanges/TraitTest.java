/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqandresultchanges;

import java.util.EnumSet;
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
public class TraitTest {
    
    public TraitTest() {
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
     * Test of setName method, of class Trait.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newName = "";
        Trait instance = new Trait();
        instance.setName(newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Trait.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int setValue = 0;
        Trait instance = new Trait();
        instance.setValue(setValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValueMin method, of class Trait.
     */
    @Test
    public void testSetValueMin() {
        System.out.println("setValueMin");
        int newValueMin = 0;
        Trait instance = new Trait();
        instance.setValueMin(newValueMin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValueMax method, of class Trait.
     */
    @Test
    public void testSetValueMax() {
        System.out.println("setValueMax");
        int newValueMax = 0;
        Trait instance = new Trait();
        instance.setValueMax(newValueMax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMinMax method, of class Trait.
     */
    @Test
    public void testSetMinMax() {
        System.out.println("setMinMax");
        int newMin = 0;
        int newMax = 0;
        Trait instance = new Trait();
        instance.setMinMax(newMin, newMax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToValue method, of class Trait.
     */
    @Test
    public void testAddToValue() {
        System.out.println("addToValue");
        int add = 0;
        Trait instance = new Trait();
        instance.addToValue(add);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDesc method, of class Trait.
     */
    @Test
    public void testSetDesc() {
        System.out.println("setDesc");
        String newDescription = "";
        Trait instance = new Trait();
        instance.setDesc(newDescription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSortingPriority method, of class Trait.
     */
    @Test
    public void testSetSortingPriority() {
        System.out.println("setSortingPriority");
        int sortingPriority = 0;
        Trait instance = new Trait();
        instance.setSortingPriority(sortingPriority);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setShowValue method, of class Trait.
     */
    @Test
    public void testSetShowValue() {
        System.out.println("setShowValue");
        boolean newValue = false;
        Trait instance = new Trait();
        instance.setShowValue(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTypes method, of class Trait.
     */
    @Test
    public void testSetTypes() {
        System.out.println("setTypes");
        EnumSet<GameEnums.TraitMod> multiTypes = null;
        Trait instance = new Trait();
        instance.setTypes(multiTypes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Trait.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Trait instance = new Trait();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStringVerbose method, of class Trait.
     */
    @Test
    public void testToStringVerbose() {
        System.out.println("toStringVerbose");
        Trait instance = new Trait();
        String expResult = "";
        String result = instance.toStringVerbose();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equalShallow method, of class Trait.
     */
    @Test
    public void testEqualShallow() {
        System.out.println("equalShallow");
        Trait t = null;
        Trait instance = new Trait();
        boolean expResult = false;
        boolean result = instance.equalShallow(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Trait.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object t = null;
        Trait instance = new Trait();
        boolean expResult = false;
        boolean result = instance.equals(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Trait.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Trait instance = new Trait();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
