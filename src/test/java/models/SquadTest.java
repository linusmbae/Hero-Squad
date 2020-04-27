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
        Squad anotherSquad= new Squad("Team Super Girl", "Fight Criminals");
        assertEquals(2,Squad.getAll().size());
    }

    @Test
    public void allSquadsContainsAllSquads() throws Exception {
        Squad squad= createNewSquad();
        Squad anotherSquad= new Squad("Team Super Girl", "Fight Criminals");
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
        Squad anotherSquad= new Squad("Team Super Girl", "Fight Criminals");
        assertEquals(2,Squad.findById(anotherSquad.getId()).getId());
    }

    @Test
    public void findReturnsMoreThanFiveSquad_false() throws Exception {
        Squad squad1= createNewSquad();
        Squad squad2= new Squad("Team Super Girl", "Fight Criminals");
        Squad squad3= new Squad("Team Super Girl", "Fight Criminals");
        Squad squad4= new Squad("Team Super Girl", "Fight Criminals");
        Squad squad5= new Squad("Team Super Girl", "Fight Criminals");
        Squad squad6= new Squad("Team Super Girl", "Fight Criminals");
        assertEquals(1,Squad.findById(squad1.getId()).getId());
        assertEquals(2,Squad.findById(squad2.getId()).getId());
        assertEquals(3,Squad.findById(squad3.getId()).getId());
        assertEquals(4,Squad.findById(squad4.getId()).getId());
        assertEquals(5,Squad.findById(squad5.getId()).getId());
        assertNotEquals(5,Squad.findById(squad6.getId()).getId());
    }

    @Test
    public void updateSquadDetails() throws Exception {
        Squad squad= createNewSquad();
        int previousId=squad.getId();
        String previousName=squad.getName();
        String previousCause = squad.getCause();

        squad.update("Team Super Girl","Fight Criminals");

        assertEquals(previousId,squad.getId());
        assertNotEquals(previousName,squad.getName());
        assertNotEquals(previousCause,squad.getCause());
    }

    @Test
    public void deleteByIdRemovesSquadById_true() throws Exception {
        Squad squad=createNewSquad();
        Squad anotherSquad= new Squad("Team Super Girl", "Fight Criminals");
        squad.deleteSquad();
        assertEquals(1,squad.getAll().size());
        assertEquals(squad.getAll().get(0).getId(),2);
    }

    @Test
    public void clearAllClearsSquadList_true() throws Exception {
        Squad squad=createNewSquad();
        Squad anotherSquad=createNewSquad();
        Squad.clearEntireSquad();
        assertEquals(0,Squad.getAll().size());
    }

    public Squad createNewSquad()
    {return new Squad( "Hero Squad","computer illiteracy");}
}