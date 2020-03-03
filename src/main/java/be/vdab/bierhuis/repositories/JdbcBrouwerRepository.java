package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Brouwer;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcBrouwerRepository implements BrouwerRepository{

    private final JdbcTemplate template;
    private RowMapper<Brouwer> brouwerRowMapper =
            ((result, rowNum) -> new Brouwer(result.getLong("id"), result.getString("naam"), result.getString("straat"), result.getString("huisNr"),
                    result.getInt("postcode"), result.getString("gemeente"), result.getBigDecimal("omzet")));

    public JdbcBrouwerRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Brouwer> findAllBrouwers() {
        String sql = "select id,naam,straat,huisNr,postcode,gemeente,omzet from brouwers order by naam";
        return template.query(sql, brouwerRowMapper);
    }

    @Override
    public Optional<Brouwer> findBrewerByItsId(long id) {
        try {
            String sql = "select id,naam,straat,huisNr,postcode,gemeente,omzet from brouwers where id = ?";
            return Optional.of(template.queryForObject(sql, brouwerRowMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex){
            return Optional.empty();
        }
    }

}
