package be.vdab.bierhuis.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.*;

@JdbcTest
@Sql("/insertBrouwer.sql")
@Import(JdbcBrouwerRepository.class)
class JdbcBrouwerRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final JdbcBrouwerRepository repository;
    private static final String BROUWERS = "brouwers";

    public JdbcBrouwerRepositoryTest(JdbcBrouwerRepository repository) {
        this.repository = repository;
    }

    @Test
    void findAllBrouwersGivesAllBrewers() {
        assertThat(repository.findAllBrouwers())
                .hasSize(super.countRowsInTable(BROUWERS));
    }

    private long idVanTestPizza() {
        long id = super.jdbcTemplate.queryForObject("select id from brouwers where naam='test'", Long.class);
        return id;
    }

    @Test
    void findBrewerByItsId() {
        assertThat(repository.findBrewerByItsId(idVanTestPizza()).get().getNaam()).isEqualTo("test");
    }
}