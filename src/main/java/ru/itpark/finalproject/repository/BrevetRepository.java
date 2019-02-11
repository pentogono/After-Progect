package ru.itpark.finalproject.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.finalproject.domain.Brevet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class BrevetRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public BrevetRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Brevet> findAll() {
        return jdbcTemplate.query("SELECT id, name, link_map FROM brevets",
                (rs, i) -> new Brevet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("link_map")
                ));
    }

    public Brevet findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, name, link_map FROM brevets WHERE id=:id",
                Map.of("id", id),
                (rs, i) -> new Brevet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("link_map")
                )
        );
    }
}
