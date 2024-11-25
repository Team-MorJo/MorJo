package com.morjo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class UserScore {
    double correctRate;
    double commonSenseScore;
}
