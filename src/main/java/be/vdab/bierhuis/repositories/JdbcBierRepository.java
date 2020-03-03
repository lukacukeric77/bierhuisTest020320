package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bier;
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
                            result.getLong("brouwerId"), result.getLong("soortId"), result.getDouble("alcohool"),
                            result.getBigDecimal("prijs"), result.getLong("besteld"));

    public JdbcBierRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public long findAantalBieren() {
        return template.queryForObject("select count(*) from bieren", Long.class);
    }

    @Override
    public Optional<Bier> findById(long id) {
        try {
            String sql = "select naam, alcohol, prijs from bieren where id=?";
            return Optional.of(template.queryForObject(sql, bierRowMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex){
            return Optional.empty();
        }
    }

    @Override
    public void update(Bier bier) {
        String sql = "update bieren set besteld=? where id=?";
        if (template.update(sql, bier.getBesteld(), bier.getId())==0){
            throw new BierNietGevondenException();
        }

    }

    @Override
    public List<Bier> findByIds(Set<Long> ids) {
        if (ids.isEmpty()){
            return Collections.emptyList();
        }
        String sql = "select id, naam, alcohol from bieren  where id in (";
        StringBuilder builder = new StringBuilder(sql);
        ids.forEach(id -> builder.append("?,"));
        builder.setCharAt(builder.length()-1, ')');
        builder.append(" order by id");
        return template.query(builder.toString(), ids.toArray(), bierRowMapper);
    }

    @Override
    public List<Bier> findByNaam(String naam) {
        String sql = "select bieren.naam from bieren inner join brouwers on brouwerid=brouwers.id where brouwers.naam=?";
        return template.query(sql, bierRowMapper, naam);
    }
}
