package com.example.demoApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Visit {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    public Visit(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Visit [name=%s, description='%s']",
                name, description);
    }
}
