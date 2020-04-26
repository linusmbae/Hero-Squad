package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Hero.clearAllTasks(); // clear out all the tasks before each test
    }
    @Test
    public void heroIsCreatedCorrectly_true() throws Exception
    {
        Hero hero=createNewHero();
        assertEquals(true,hero instanceof Hero);
    }
    @Test
    public void heroInstantiatesCorrectly() throws Exception {
        Hero hero=createNewHero();
        assertEquals("Super Girl",hero.getName());
        assertEquals(35,hero.getAge());
        assertEquals("Flying",hero.getSpecialPowers());
        assertEquals("stones",hero.getWeakness());
    }
    @Test
    public void HeroesAreCorrectlyReturned_true() throws Exception {
        Hero hero = createNewHero();
        Hero otherHero = new Hero("Super Man",45,"super Speed", "stones",2);
        assertEquals(2, Hero.getAll().size());
    }

    @Test
    public void AllHeroesContainsAllHeroes_true() throws Exception {
        Hero hero = createNewHero();
        Hero otherHero = new Hero("Super Man",45,"super Speed", "stones",2);
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

public Hero createNewHero()
{
    return new Hero("Super Girl",35,"Flying", "stones",1);
}
}