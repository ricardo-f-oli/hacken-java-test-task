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
        private String name;
        private String content;

        // Getters e Setters
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }
}
