package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
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
        assertEquals(3, Hero.getAll().size());
    }

public Hero createNewHero()
{
    return new Hero("Super Girl",35,"Flying", "stones",1);
}
}