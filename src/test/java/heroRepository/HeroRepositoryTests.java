package heroRepository;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTests {
    private HeroRepository heroRepository;

    public HeroRepositoryTests() {
        this.heroRepository = new HeroRepository();
    }

    @Test (expected = NullPointerException.class)
    public void testCreateShouldThrowWhenHeroIsNull(){
        this.heroRepository.create(null);

    }
    @Test (expected = IllegalArgumentException.class)
    public void testCreateShouldThrowWhenHeroIsAlreadyCreated(){
        this.heroRepository.create(new Hero("Pesho",5));
        this.heroRepository.create(new Hero("Pesho",6));
    }
    @Test
    public void testCreateShouldAddNewHero(){
        this.heroRepository.create(new Hero("Pesho",8));
        Hero expected = this.heroRepository.getHero("Pesho");
        assertEquals(expected,this.heroRepository.getHero("Pesho"));
    }
    @Test (expected = NullPointerException.class)
    public void testRemoveShouldThrowWhenNameIsNull(){
        this.heroRepository.remove(null);
    }
    @Test (expected = NullPointerException.class)
    public void testRemoveShouldThrowWhenNameIsEmpty(){
        this.heroRepository.remove("");
    }
    @Test
    public void testRemoveShouldRemoveHeroByName(){
        this.heroRepository.create(new Hero("Pesho",5));

        assertTrue(this.heroRepository.remove("Pesho"));
    }
    @Test
    public void testGetHeroWithHighestLevelShouldReturnNullWhenCollectionIsEmpty(){
        assertNull(this.heroRepository.getHeroWithHighestLevel());
    }
    @Test
    public void testGetHeroWithHighestLevelShouldReturnHero(){
        this.heroRepository.create(new Hero("Pesho",6));
        this.heroRepository.create(new Hero("Gosho",7));
        assertEquals(this.heroRepository.getHero("Gosho"),
                this.heroRepository.getHeroWithHighestLevel());
    }

}
