package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.exceptions.BierNietGevondenException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcBierRepository implements BierRepository {

    private final JdbcTemplate template;
    private final RowMapper<Bier> bierRowMapper =
            (result, rowNum) ->
                    new Bier(result.getLong("id"), result.getString("naam"),
                            result.getLong("brouwerId"), result.getLong("soortId"), result.getBigDecimal("alcohol"),
                            result.getBigDecimal("prijs"), result.getLong("besteld"));

    public JdbcBierRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public long findAantalBieren() {
        return template.queryForObject("select count(*) from bieren", Long.class);
    }

    @Override
    public List<Bier> findAllBierenByIdOfBrouwer(long id) {
        String sql = "select id, naam, brouwerid, soortid, alcohol, prijs, besteld from bieren where brouwerid=?";
        return template.query(sql, bierRowMapper, id);
    }

    @Override
    public Optional<Bier> findBierById(long id) {
        try {
            String sql = "select id, naam, brouwerid, soortid, alcohol, prijs, besteld from bieren where id=?";
            return Optional.of(template.queryForObject(sql, bierRowMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    @Override
    public void updateBesteldInBier(long ammount, long id) {
        String sql = "update bieren set besteld=besteld+? where id=?";
        if (template.update(sql, ammount, id)==0) {
            throw new BierNietGevondenException();
        }
    }
}
