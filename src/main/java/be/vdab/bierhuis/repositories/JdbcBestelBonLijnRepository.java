package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bestelbonlijn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcBestelBonLijnRepository implements BestelBonLijnenRepository{

    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;


    public JdbcBestelBonLijnRepository(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(this.template);
        insert.withTableName("bestelbonlijnen");
    }

    @Override
    public void create(Bestelbonlijn bestelbonlijn) {
        Map<String, Object> kolomWarden = new HashMap<>();
        kolomWarden.put("bestelbonid", bestelbonlijn.getBestelbonid());
        kolomWarden.put("bierid", bestelbonlijn.getBierid());
        kolomWarden.put("aantal", bestelbonlijn.getAantal());
        kolomWarden.put("prijs", bestelbonlijn.getPrijs());
        insert.execute(kolomWarden);
    }


}
