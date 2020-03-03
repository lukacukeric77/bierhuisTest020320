package be.vdab.bierhuis.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import static org.assertj.core.api.Assertions.*;


@JdbcTest
@Import(JdbcBierRepository.class)
@Sql("/insertBier.sql")
class JdbcBierRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final JdbcBierRepository repository;
    private static final String BIEREN = "bieren";

    public JdbcBierRepositoryTest(JdbcBierRepository repository) {
        this.repository = repository;
    }

//    private long idVanTestBieren(){
////        return super.jdbcTemplate.queryForObject("select id from bieren where brouwerid=0", Long.class);
//    }

    @Test
    void findAantalBieren() {
    }

    @Test
    void findAllBierenByIdOfBrouwer() {
//        assertThat(repository.findAllBierenByIdOfBrouwer(idVanTestBieren()).get(0).getNaam()).isEqualTo("test");

    }


}