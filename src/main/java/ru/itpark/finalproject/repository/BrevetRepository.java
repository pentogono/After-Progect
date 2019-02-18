package ru.itpark.finalproject.repository;


import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.finalproject.domain.Brevet;


import java.util.List;
import java.util.Map;

@Repository
public class BrevetRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public BrevetRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Brevet> findAll() {
        return jdbcTemplate.query("SELECT id, name, link_map, data_year, start_time, start_place, cp1_time, cp1_place, cp2_time, cp2_place, cp3_time, cp3_place, cp4_time, cp4_place, cp5_time, cp5_place, cp6_time, cp6_place, cp7_time, cp7_place, cp8_time, cp8_place, finish_time, finish_place FROM brevets",
                (rs, i) -> new Brevet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("link_map"),
                        rs.getInt("data_year"),
                        rs.getString("start_time"),
                        rs.getString("start_place"),
                        rs.getString("cp1_time"),
                        rs.getString("cp1_place"),
                        rs.getString("cp2_time"),
                        rs.getString("cp2_place"),
                        rs.getString("cp3_time"),
                        rs.getString("cp3_place"),
                        rs.getString("cp4_time"),
                        rs.getString("cp4_place"),
                        rs.getString("cp5_time"),
                        rs.getString("cp5_place"),
                        rs.getString("cp6_time"),
                        rs.getString("cp6_place"),
                        rs.getString("cp7_time"),
                        rs.getString("cp7_place"),
                        rs.getString("cp8_time"),
                        rs.getString("cp8_place"),
                        rs.getString("finish_time"),
                        rs.getString("finish_place")
                ));
    }

    public Brevet findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, name, link_map, data_year, start_time, start_place, cp1_time, cp1_place, cp2_time, cp2_place, cp3_time, cp3_place, cp4_time, cp4_place, cp5_time, cp5_place, cp6_time, cp6_place, cp7_time, cp7_place, cp8_time, cp8_place, finish_time, finish_place FROM brevets WHERE id=:id",
                Map.of("id", id),
                (rs, i) -> new Brevet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("link_map"),
                        rs.getInt("data_year"),
                        rs.getString("start_time"),
                        rs.getString("start_place"),
                        rs.getString("cp1_time"),
                        rs.getString("cp1_place"),
                        rs.getString("cp2_time"),
                        rs.getString("cp2_place"),
                        rs.getString("cp3_time"),
                        rs.getString("cp3_place"),
                        rs.getString("cp4_time"),
                        rs.getString("cp4_place"),
                        rs.getString("cp5_time"),
                        rs.getString("cp5_place"),
                        rs.getString("cp6_time"),
                        rs.getString("cp6_place"),
                        rs.getString("cp7_time"),
                        rs.getString("cp7_place"),
                        rs.getString("cp8_time"),
                        rs.getString("cp8_place"),
                        rs.getString("finish_time"),
                        rs.getString("finish_place")
                )
        );
    }

//    public List<Brevet> findAllByName(String name){
//        return jdbcTemplate.query(
//                "SELECT id,name, link_map, data_year, start_time, start_place, cp1_time, cp1_place, cp2_time, cp2_place, cp3_time, cp3_place, cp4_time, cp4_place, cp5_time, cp5_place, cp6_time, cp6_place, cp7_time, cp7_place, cp8_time, cp8_place, finish_time, finish_place FROM brevets WHERE name=?",
//                Map.of("name", name),
//                (rs, i) -> new Brevet(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getString("link_map"),
//                        rs.getInt("data_year"),
//                        rs.getString("start_time"),
//                        rs.getString("start_place"),
//                        rs.getString("cp1_time"),
//                        rs.getString("cp1_place"),
//                        rs.getString("cp2_time"),
//                        rs.getString("cp2_place"),
//                        rs.getString("cp3_time"),
//                        rs.getString("cp3_place"),
//                        rs.getString("cp4_time"),
//                        rs.getString("cp4_place"),
//                        rs.getString("cp5_time"),
//                        rs.getString("cp5_place"),
//                        rs.getString("cp6_time"),
//                        rs.getString("cp6_place"),
//                        rs.getString("cp7_time"),
//                        rs.getString("cp7_place"),
//                        rs.getString("cp8_time"),
//                        rs.getString("cp8_place"),
//                        rs.getString("finish_time"),
//                        rs.getString("finish_place")
//                )
//        );
//
//
//    }

//    public List<Randonneur> listAll() {
//        return jdbcTemplate.query(
//                "SELECT id, name, year, time_200, time_300, time_400, time_600 FROM randonneurs_time_2017",
//                (rs, i) -> new Randonneur(
//                        rs.getInt("id"),
//                        rs.getString( "name"),
//                        rs.getInt("year"),
//                        rs.getString("time_200"),
//                        rs.getString("time_300"),
//                        rs.getString("time_400"),
//                        rs.getString("time_600")
//                )
//        );
//    }


}
