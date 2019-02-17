package ru.itpark.finalproject.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.finalproject.domain.Brevet;

import ru.itpark.finalproject.domain.R2017randonneur;

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

    public List<Brevet> findAllByName(String name){
        return jdbcTemplate.query(
                "SELECT id,name, link_map FROM brevets WHERE name=:name",
                Map.of("name", name),
                (rs, i) -> new Brevet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("link_map")
                )
        );


    }

//    public List<R2017randonneur> listAll() {
//        return jdbcTemplate.query(
//                "SELECT id, name, year, time_200, time_300, time_400, time_600 FROM randonneurs_time_2017",
//                new RowMapper<R2017randonneur>() {
//                    @Override
//                    public R2017randonneur mapRow(ResultSet resultSet, int i) throws SQLException {
//                        return new R2017randonneur(
//                                resultSet.getInt("id"),
//                                resultSet.getString( "name"),
//                                resultSet.getInt("year"),
//                                resultSet.getString("time_200"),
//                                resultSet.getString("time_300"),
//                                resultSet.getString("time_400"),
//                                resultSet.getString("time_600")
//                        );
//                    }
//                }
//        );
//    }


}
