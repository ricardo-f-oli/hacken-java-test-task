package com.test.java.hacken.domain.entites;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import java.util.Map;

@Setter
@Getter
@Entity
public class GenericCSVFileEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ElementCollection
        @MapKeyColumn(name = "field_name")
        @Column(name = "field_value")
        @CollectionTable(name = "generic_record_fields", joinColumns = @JoinColumn(name = "record_id"))
        @FullTextField(analyzer = "standard")
        private Map<String, String> fields;

}
