package be.vdab.bierhuis.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;

@JdbcTest
@Import(JdbcBrouwerRepository.class)
class JdbcBrouwerRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final JdbcBrouwerRepository repository;
    private static final String BROUWERS = "brouwers";

    public JdbcBrouwerRepositoryTest(JdbcBrouwerRepository repository) {
        this.repository = repository;
    }

    @Test
    void findAllBrouwersGeefsAlleBrewers() {
        assertThat(repository.findAllBrouwers())
                .hasSize(super.countRowsInTable(BROUWERS));
    }

    @Test
    void findBrewerByItsId() {
    }
}