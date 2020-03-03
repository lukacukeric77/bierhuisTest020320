package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Brouwer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcBrouwerRepository implements BrouwerRepository{

    private final JdbcTemplate template;

    public JdbcBrouwerRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Brouwer> findAll() {
        return null;
    }

    @Override
    public Optional<Brouwer> findById() {
        return Optional.empty();
    }
}
