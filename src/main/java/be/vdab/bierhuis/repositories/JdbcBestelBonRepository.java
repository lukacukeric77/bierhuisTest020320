package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bestelbon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcBestelBonRepository implements BestelBonRepository{

    private final SimpleJdbcInsert insert;
    private final JdbcTemplate template;

    public JdbcBestelBonRepository(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(this.template);
        insert.withTableName("bestelbonnen");
        insert.usingGeneratedKeyColumns("id");
    }

    @Override
    public long createBestelBon(Bestelbon bestelbon) {
        Map<String, Object> kolomWarden = new HashMap<>();
        kolomWarden.put("id", bestelbon.getId());
        kolomWarden.put("naam", bestelbon.getNaam());
        kolomWarden.put("straat", bestelbon.getStraat());
        kolomWarden.put("huisNr", bestelbon.getHuisNr());
        kolomWarden.put("postcode", bestelbon.getPostcode());
        kolomWarden.put("gemeente", bestelbon.getGemeente());
        Number id = insert.executeAndReturnKey(kolomWarden);
        return id.longValue();
    }
}
