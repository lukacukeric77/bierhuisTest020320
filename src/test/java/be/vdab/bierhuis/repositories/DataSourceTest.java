package be.vdab.bierhuis.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@JdbcTest
class DataSourceTest {

    private final DataSource source;

    public DataSourceTest(DataSource source) {
        this.source = source;
    }

    @Test
    void getConnection() throws SQLException {
        try (Connection connection = source.getConnection()){

        }
    }

}
