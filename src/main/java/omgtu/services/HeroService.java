package omgtu.services;

import omgtu.entities.Hero;

import java.util.List;

/**
 * @author DIvanets
 * @version 1.0 13.09.2017.
 */
public interface HeroService {
    /**
     * Allow to find all heroes.
     * @return list of found heroes.
     */
    List<Hero> getAllHeroes();

    /**
     * Allow to find one hero by id.
     * @param id id of hero.
     * @return found hero.
     */
    Hero getHeroById(final Long id);

    /**
     * Add hero.
     * @param hero hero
     * @return added hero.
     */
    Hero addHero(final Hero hero);

    /**
     * Delete hero.
     * @param id id.
     */
    void deleteHero(final Long id);
}
