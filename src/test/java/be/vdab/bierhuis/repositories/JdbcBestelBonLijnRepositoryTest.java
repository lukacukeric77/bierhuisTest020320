package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bestelbonlijn;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(JdbcBestelBonLijnRepository.class)
@Sql("/insertSoort.sql")
@Sql("/insertBrouwer.sql")
@Sql("/insertBier.sql")
@Sql("/insertBestelbon.sql")
class JdbcBestelBonLijnRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final JdbcBestelBonLijnRepository repository;

    public JdbcBestelBonLijnRepositoryTest(JdbcBestelBonLijnRepository repository) {
        this.repository = repository;
    }

    private long idVanTestBier(){
        return super.jdbcTemplate.queryForObject("select id from bieren where naam='test'", Long.class);
    }

    private long idVanTestBestelbon(){
        return super.jdbcTemplate.queryForObject("select id from bestelbonnen where naam='bestelTest'", Long.class);
    }

    @Test
    void create() {
        repository.create(new Bestelbonlijn(idVanTestBestelbon(), idVanTestBier(), BigInteger.ZERO, BigDecimal.ZERO));
        assertThat(super.countRowsInTableWhere("bestelbonlijnen", "bestelbonid=" + idVanTestBestelbon())).isOne();
    }
}