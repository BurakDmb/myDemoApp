package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList( 2, 11, 21, 15, 5, 3, 4));
        ArrayList<Integer> result= new App().calculateCommonElements(array1,array2, 2, 4);
        ArrayList<Integer> myresult= new ArrayList<>(Arrays.asList(2, 3, 4));
        for(int i=0;i<result.size();i++){
            if(result.get(i)==myresult.get(i)){
                if(!isEqual(result.get(i),myresult.get(i))){
                    assertTrue(false);
                    return;
                }
            }
        }
        assertTrue(true);
    }
    public void testDuplicate(){
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 5,1));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList( 2, 3, 5, 6));
        ArrayList<Integer> result= new App().calculateCommonElements(array1, array2, 2, 4);
        ArrayList<Integer> myresult= new ArrayList<>(Arrays.asList(2, 3));
        for(int i=0;i<result.size();i++){
            if(result.get(i)==myresult.get(i)){
                if(!isEqual(result.get(i),myresult.get(i))) assertTrue(false);
            }
        }
        assertTrue(true);
    }
    public void testFirstOneIsEmpty() {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 11, 21, 15, 5));
        ArrayList<Integer> result= new App().calculateCommonElements(array1, array2, 2, 4);
        assertTrue(result.size()==0);
    }

    public void testSecondOneIsEmpty() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 11, 21, 15, 5));
        ArrayList<Integer> array2 = new ArrayList<>();
        ArrayList<Integer> result= new App().calculateCommonElements(array1, array2, 2, 4);
        assertTrue(result.size()==0);
    }
    public void testNull(){
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 11, 21, 15, 5));
        ArrayList<Integer> result= new App().calculateCommonElements(array1,null, 2, 4);
        assertTrue(result.size()==0);
    }
    public void testWrongRange() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 9, 10));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList( 2, 11, 21, 15, 5, 3, 4));
        ArrayList<Integer> result= new App().calculateCommonElements(array1, array2, 5, 1);
        assertTrue(result.size()==0);
    }
    private boolean isEqual(int a, int b){
        if(a==b) return true;
        else return false;
    }

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
