package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void testFound() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 9, 10));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4,11,21,15,5));
        ArrayList<Integer> result= new App().calculateCommonElements(array1,array2, 2, 4);
        ArrayList<Integer> myresult= new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        for(int i=0;i<result.size();i++){
            if(result.get(i)==myresult.get(i)){
                assertTrue(isEqual(result.get(i),myresult.get(i)));
            }
        }
    }
    private boolean isEqual(int a, int b){
        if(a==b) return true;
        else return false;
    }
    /*
    public void testNotFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().search(array, 5));
    }

    public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        assertFalse(new App().search(array, 1));
    }

    public void testNull() {
      assertFalse(new App().search(null, 1));
    }
    */
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
