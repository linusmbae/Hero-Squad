package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class SquadTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Squad.clearEntireSquad();
    }

    @Test
    public void squadIsCreatedCorrectly_true() throws Exception
    {
        Squad squad=createNewSquad();
        assertEquals(true,squad instanceof Squad);
    }

    @Test
    public void squadInstantiatesCorrectly_true() throws Exception {
        Squad squad= createNewSquad();
        assertEquals(1,squad.getId());
        assertEquals(5,squad.getMaxSize());
        assertEquals("Hero Squad",squad.getName());
        assertEquals("computer illiteracy",squad.getCause());
    }

    public Squad createNewSquad()
    {return new Squad(1, 5,"Hero Squad","computer illiteracy");}
}