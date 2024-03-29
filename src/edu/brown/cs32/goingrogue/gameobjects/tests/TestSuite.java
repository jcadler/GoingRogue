package edu.brown.cs32.goingrogue.gameobjects.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    edu.brown.cs32.goingrogue.gameobjects.creatures.CloneTest.class,
    edu.brown.cs32.bweedon.random.BweedonRandomTest.class,
    edu.brown.cs32.goingrogue.gameobjects.actions.ArcAttackRangeTest.class,
    edu.brown.cs32.bweedon.geometry.Point2DUtilTest.class})
/**
 * @author Ben Weedon (bweedon)
 */
public class TestSuite {
    // empty
}