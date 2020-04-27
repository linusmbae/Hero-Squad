package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.http.HttpRequest;

import static org.junit.Assert.*;

public class HeroTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Hero.clearAllHeroes();
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
        assertEquals(1,hero.getId());
    }
    @Test
    public void HeroesAreCorrectlyReturned_true() throws Exception {
        Hero hero = createNewHero();
        Hero otherHero = new Hero("Super Man",45,"super Speed", "stones");
        assertEquals(2, Hero.getAll().size());
    }

    @Test
    public void AllHeroesContainsAllHeroes_true() throws Exception {
        Hero hero = createNewHero();
        Hero otherHero = new Hero("Super Man",45,"super Speed", "stones");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

    @Test
    public void findReturnsCorrectHero() throws Exception {
        Hero hero = createNewHero();
        assertEquals(1, Hero.findById(hero.getId()).getId());
    }

    @Test
    public void findReturnsCorrectIfMoreThanOneHeroExists() throws Exception {
        Hero hero = createNewHero();
        Hero anotherHero = new Hero("Super Man",45,"super Speed", "stones");
        assertEquals(2,Hero.findById(anotherHero.getId()).getId());
    }

    @Test
    public void updateHeroDetails() throws Exception {
        Hero hero = createNewHero();
        String previousName=hero.getName();
        int previousAge=hero.getAge();
        String previousSpecialPowers=hero.getSpecialPowers();
        String previousWeakness=hero.getWeakness();
        int previousId=hero.getId();

        hero.update("Super Man",45,"super Speed", "Stones");

        assertEquals(previousId,hero.getId());
        assertNotEquals(previousName,hero.getName());
        assertNotEquals(previousAge, hero.getAge());
        assertNotEquals(previousSpecialPowers,hero.getSpecialPowers());
        assertNotEquals(previousWeakness,hero.getWeakness());

    }

    @Test
    public void deleteHeroById() throws Exception {
        Hero hero= createNewHero();
        Hero anotherHero = new Hero("Super Man",45,"super Speed", "stones");
        hero.deleteHero();
        assertEquals(1,hero.getAll().size());
        assertEquals(hero.getAll().get(0).getId(),2);
    }

    @Test
    public void deleteAll() throws Exception {
        Hero hero = createNewHero();
        Hero anotherHero = createNewHero();
        Hero.clearAllHeroes();
        assertEquals(0,Hero.getAll().size());
    }

    public Hero createNewHero()
    {
        return new Hero("Super Girl",35,"Flying", "stones");
    }
}



