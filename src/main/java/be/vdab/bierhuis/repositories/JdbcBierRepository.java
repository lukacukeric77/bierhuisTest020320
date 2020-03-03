package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.domain.BierBrouwerAmalgam;
import be.vdab.bierhuis.exceptions.BierNietGevondenException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class JdbcBierRepository implements BierRepository{

    private final JdbcTemplate template;
    private final RowMapper<Bier> bierRowMapper =
            (result, rowNum)->
                    new Bier(result.getLong("id"), result.getString("naam"),
                            result.getLong("brouwerId"), result.getLong("soortId"), result.getBigDecimal("alcohol"),
                            result.getBigDecimal("prijs"), result.getLong("besteld"));
    private final RowMapper<BierBrouwerAmalgam> bierBrouwerAmalgamRowMapper =
            ((result, rowNum) ->
                    new BierBrouwerAmalgam(result.getLong("id"), result.getString("naam"),
                            result.getLong("brouwerId"), result.getLong("soortId"), result.getBigDecimal("alcohol"),
                            result.getBigDecimal("prijs"), result.getLong("besteld"),
                            result.getLong("id"), result.getString("naam"), result.getString("straat"), result.getString("huisNr"),
                            result.getInt("postcode"), result.getString("gemeente"), result.getBigDecimal("omzet")));

    public JdbcBierRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public long findAantalBieren() {
        return template.queryForObject("select count(*) from bieren", Long.class);
    }

    @Override
    public Optional<BierBrouwerAmalgam> findAllBierenByIdOfBrouwer(long id) {
        try {
            String sql = "select * from bieren inner join brouwers on bieren.brouwerid = brouwers.id where brouwers.id=?";
            return Optional.of(template.queryForObject(sql, bierBrouwerAmalgamRowMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex){
            return Optional.empty();
        }
    }
}
