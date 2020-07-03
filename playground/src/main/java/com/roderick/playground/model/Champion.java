package com.roderick.playground.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(exclude = "id")
@Getter
public class Champion {
    @Id private String id;
    private String champName;
    private String role;
    private String type;
    private String phrase;
    private List<String> counterTo;
    private List<String> counteredBy;

    //Still have to use this all args constructor even though Lombok creates one with @AllArgsConstructor
    public Champion(String champName, String role, String type, String phrase, List<String> counterTo, List<String> counteredBy) {
        this.champName = champName;
        this.role = role;
        this.type = type;
        this.phrase = phrase;
        this.counterTo = counterTo;
        this.counteredBy = counteredBy;
    }
    public String getPhrase(){
        return this.phrase;
    }

}
