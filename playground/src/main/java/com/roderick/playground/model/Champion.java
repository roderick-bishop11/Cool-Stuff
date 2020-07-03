package com.roderick.playground.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class Champion {
    @Id
    private String champName;
    private String role;
    private List<String> type;
    private String phrase;
    private List<String> counterTo;
    private List<String> counteredBy;

    public Champion(String champName, String role, List<String> type, String phrase, List<String> counterTo, List<String> counteredBy) {
        this.champName = champName;
        this.role = role;
        this.type = type;
        this.phrase = phrase;
        this.counterTo = counterTo;
        this.counteredBy = counteredBy;
    }

}
