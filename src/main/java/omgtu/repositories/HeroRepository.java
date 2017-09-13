package omgtu.repositories;

import omgtu.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author DIvanets
 * @version 1.0 13.09.2017.
 */
public interface HeroRepository extends JpaRepository<Hero, Long> {
}
