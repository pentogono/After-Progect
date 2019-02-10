package ru.itpark.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.domain.Brevet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BrevetRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public BrevetRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static List<Brevet> findAll() {
        return jdbcTemplate.query("SELECT id_brevet, name FROM brevets",
                new RowMapper<Brevet>() {
                    @Override
                    public Brevet mapRow(ResultSet resultSet, int i) throws SQLException {
                        return new Brevet(
                                resultSet.getInt("id_brevet"),
                                resultSet.getString("name")
                        );
                    }
                });
    }
}
