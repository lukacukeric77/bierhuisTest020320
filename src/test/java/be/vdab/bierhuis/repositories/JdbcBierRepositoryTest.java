package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.exceptions.BierNietGevondenException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import static org.assertj.core.api.Assertions.*;


@JdbcTest
@Import(JdbcBierRepository.class)
@Sql("/insertBrouwer.sql")
@Sql("/insertSoort.sql")
@Sql("/insertBier.sql")
class JdbcBierRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final JdbcBierRepository repository;
    private static final String BIEREN = "bieren";

    public JdbcBierRepositoryTest(JdbcBierRepository repository) {
        this.repository = repository;
    }

    private long idVanTestBrouwer(){
        return super.jdbcTemplate.queryForObject("select id from brouwers where naam = 'brouwerTest'", Long.class);
    }

    private long idVanTestBier(){
        return super.jdbcTemplate.queryForObject("select id from bieren where naam='test'", Long.class);
    }

    private long idVanTestSoort(){
        return super.jdbcTemplate.queryForObject("select id from soorten where naam='soortTest'", Long.class);
    }

    @Test
    void findAantalBieren() {
        assertThat(repository.findAantalBieren()).isEqualTo(super.countRowsInTable(BIEREN));
    }

    @Test
    void findAllBierenByIdOfBrouwer() {
        assertThat(repository.findAllBierenByIdOfBrouwer(idVanTestBrouwer()).get(0).getNaam()).isEqualTo("test");
    }


    @Test
    void findBierById() {
        assertThat(repository.findBierById(idVanTestBier()).get().getNaam()).isEqualTo("test");

    }

    @Test
    void findBierByIdThrowsException() {
        assertThat(repository.findBierById(-1)).isEmpty();
    }

    @Test
    void updateBesteldInBier() {
        repository.updateBesteldInBier(10, idVanTestBier());
        assertThat(super.jdbcTemplate.queryForObject("select besteld from bieren where id=?", Long.class, idVanTestBier())).isEqualTo(15);
    }

    @Test
    void updateUnexistingBierGivesAFout() {
        assertThatExceptionOfType(BierNietGevondenException.class).isThrownBy(
                () -> repository.updateBesteldInBier(0, -1)
        );
    }
}