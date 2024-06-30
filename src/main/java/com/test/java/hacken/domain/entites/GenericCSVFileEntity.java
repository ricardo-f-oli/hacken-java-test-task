package com.test.java.hacken.domain.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericCSVFileEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ElementCollection
        @MapKeyColumn(name = "field_name")
        @Column(name = "field_value")
        @CollectionTable(name = "generic_record_fields", joinColumns = @JoinColumn(name = "record_id"))
        private Map<String, String> fields;

}
