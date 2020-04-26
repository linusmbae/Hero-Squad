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
        assertEquals("Hero Squad",squad.getName());
        assertEquals("computer illiteracy",squad.getCause());
    }

    @Test
    public void allSquadsAreReturnedCorrectly_true() throws Exception {
        Squad squad= createNewSquad();
        Squad anotherSquad= new Squad(2,"Team Super Girl", "Fight Criminals");
        assertEquals(2,Squad.getAll().size());
    }

    @Test
    public void allSquadsContainsAllSquads() throws Exception {
        Squad squad= createNewSquad();
        Squad anotherSquad= new Squad(2,"Team Super Girl", "Fight Criminals");
        assertTrue(Squad.getAll().contains(squad));
        assertTrue(Squad.getAll().contains(anotherSquad));
    }

    @Test
    public void findByIdReturnsCorrectSquad() throws Exception {
        Squad squad= createNewSquad();
        assertEquals(1, Squad.findById(squad.getId()).getId());
    }

    @Test
    public void findReturnsMoreThanOneSquad() throws Exception {
        Squad squad= createNewSquad();
        Squad anotherSquad= new Squad(2,"Team Super Girl", "Fight Criminals");
        assertEquals(2,Squad.findById(anotherSquad.getId()).getId());
    }

    @Test
    public void findReturnsMoreThanFiveSquad_false() throws Exception {
        Squad squad1= createNewSquad();
        Squad squad2= new Squad(2,"Team Super Girl", "Fight Criminals");
        Squad squad3= new Squad(3,"Team Super Girl", "Fight Criminals");
        Squad squad4= new Squad(4,"Team Super Girl", "Fight Criminals");
        Squad squad5= new Squad(5,"Team Super Girl", "Fight Criminals");
        Squad squad6= new Squad(6,"Team Super Girl", "Fight Criminals");
        assertEquals(1,Squad.findById(squad1.getId()).getId());
        assertEquals(2,Squad.findById(squad2.getId()).getId());
        assertEquals(3,Squad.findById(squad3.getId()).getId());
        assertEquals(4,Squad.findById(squad4.getId()).getId());
        assertEquals(5,Squad.findById(squad5.getId()).getId());
        assertNotEquals(5,Squad.findById(squad6.getId()).getId());
    }

    @Test
    public void updateSquadDetails() {
        Squad squad= createNewSquad();
        int previousId=squad.getId();
        String previousName=squad.getName();
        String previousCause = squad.getCause();

        squad.update("Team Super Girl","Fight Criminals");

        assertEquals(previousId,squad.getId());
        assertNotEquals(previousName,squad.getName());
        assertNotEquals(previousCause,squad.getCause());
    }

    public Squad createNewSquad()
    {return new Squad(1, "Hero Squad","computer illiteracy");}
}