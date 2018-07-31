/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstTests;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.*;
import reqandresultchanges.*;

/**
 *
 * @author MMLaptop
 */
public class PredefinedDataTester {
    
    static PredefinedData subject;
    static ArrayList initTraits;
    static ArrayList initTasks;
    static ArrayList initEvents;
    static ArrayList initEntities;
    static ArrayList initFlags;
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @Before
    public void setUp() {
        subject = new PredefinedData();
        //(String initName, boolean initState, String initGroup, int initNum) {
        Flag[] flags = new Flag[]{new Flag("Kissed", true, "Mouth", 0), new Flag("Brushed", false, "Mouth", 1)};
        initFlags = new ArrayList(Arrays.asList(flags));
        
        subject.addDefaultFlags("Mouth", initFlags);
    }
    
    @Test
    public void basicFlagTests() {
        Assert.assertNull(subject.getFlagByNum("mouth", 0));
        Assert.assertNotNull(subject.getFlagByNum("Mouth", 0));
        Assert.assertNull(subject.getFlagByNum("Mouth", 5));
        Assert.assertTrue(subject.getThisFlagList("Mouth").size() == 2);
        Assert.assertNull(subject.getThisFlagList("mouth"));
        
        Assert.assertNull(subject.getFlagByNum("Eyes", 0));
        
        Flag[] moreFlags = new Flag[]{new Flag("Curled", true, "Eyes", 0), new Flag("Open", true, "Eyes", 1)};
        ArrayList<Flag> moreF = new ArrayList(Arrays.asList(moreFlags));
        subject.addDefaultFlags("Eyes", moreF);
        
        Assert.assertNull(subject.getFlagByNum("eyes", 0));
        Assert.assertNotNull(subject.getFlagByNum("Eyes", 0));
        Assert.assertNull(subject.getFlagByNum("Eyes", 5));
        Assert.assertTrue(subject.getThisFlagList("Eyes").size() == 2);
        Assert.assertNull(subject.getThisFlagList("eyes"));
    }
    
    @Test
    public void basicTraitTests() {
        
    }
    
    @Test
    public void basicTaskTests() {
        
    }
    
    @Test
    public void basicEventTests() {
        
    }
    
    @Test
    public void basicEntityTests() {
        
    }
    
    @After
    public void tearDown() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
}
