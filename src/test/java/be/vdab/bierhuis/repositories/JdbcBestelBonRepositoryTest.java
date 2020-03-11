package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bestelbon;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import static org.assertj.core.api.Assertions.*;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(JdbcBestelBonRepository.class)
@Sql("/insertBestelbon.sql")
class JdbcBestelBonRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final JdbcBestelBonRepository jdbcBestelBonRepository;

    public JdbcBestelBonRepositoryTest(JdbcBestelBonRepository jdbcBestelBonRepository) {
        this.jdbcBestelBonRepository = jdbcBestelBonRepository;
    }

    private long idVanTestBestelbon(){
        return super.jdbcTemplate.queryForObject("select id from bestelbonnen where naam='bestelTest'", Long.class);
    }

    @Test
    void createBestelBon() {
        jdbcBestelBonRepository.createBestelBon(new Bestelbon(idVanTestBestelbon(), "test", "straat", "huisNr", 2000, "gemeente"));
       assertThat(super.countRowsInTableWhere("bestelbonnen", "id=" + idVanTestBestelbon())).isOne();
    }
}