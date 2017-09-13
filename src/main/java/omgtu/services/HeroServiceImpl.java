package omgtu.services;

import omgtu.entities.Hero;
import omgtu.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DIvanets
 * @version 1.0 13.09.2017.
 */

@Service
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;

    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @Override
    public Hero getHeroById(final Long id) {
        return heroRepository.findOne(id);
    }

    @Override
    public Hero addHero(final Hero hero) {
        heroRepository.saveAndFlush(hero);
        return heroRepository.findOne(hero.getId());
    }

    @Override
    public void deleteHero(final Long id) {
        heroRepository.delete(id);
    }
}
