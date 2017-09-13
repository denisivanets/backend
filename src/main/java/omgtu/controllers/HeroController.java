package omgtu.controllers;

import omgtu.entities.Hero;
import omgtu.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author DIvanets
 * @version 1.0 13.09.2017.
 */
@RestController
public class HeroController {
    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping(value = "/api/heroes", produces = "application/json")
    public List<Hero> provideAllHeroes(final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        return heroService.getAllHeroes();
    }

    @GetMapping(value = "api/heroes/{id}", produces = "application/json")
    public Hero getHeroById(@PathVariable("id") final long id, final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        return heroService.getHeroById(id);
    }

    @PostMapping(value = "/api/heroes", produces="application/json", consumes = "application/json")
    public Hero addHero(@RequestBody final Hero hero, final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        return heroService.addHero(hero);
    }

    @DeleteMapping(value = "/api/heroes/{id}")
    public void deleteHero(@PathVariable final long id) {
        heroService.deleteHero(id);
    }

    //TEST METHOD
    @PostConstruct
    public void testAddHeroes() {
        Hero spider = new Hero("Spider-Man");
        Hero batman = new Hero("Batman");
        Hero wolverine = new Hero("Wolverine");
        Hero flash = new Hero("Flash");
        Hero arrow = new Hero("Arrow");
        Hero superman = new Hero("Superman");
        heroService.addHero(spider);
        heroService.addHero(batman);
        heroService.addHero(wolverine);
        heroService.addHero(flash);
        heroService.addHero(arrow);
        heroService.addHero(superman);
    }

}
