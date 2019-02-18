package ru.itpark.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brevet {
    private int id;
    private String name;
    private String link_map;
    private int data_year;
    private String start_time;
    private String start_place;
    private String cp1_time;
    private String cp1_place;
    private String cp2_time;
    private String cp2_place;
    private String cp3_time;
    private String cp3_place;
    private String cp4_time;
    private String cp4_place;
    private String cp5_time;
    private String cp5_place;
    private String cp6_time;
    private String cp6_place;
    private String cp7_time;
    private String cp7_place;
    private String cp8_time;
    private String cp8_place;
    private String finish_time;
    private String finish_place;
}
