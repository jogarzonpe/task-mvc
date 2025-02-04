package co.edu.uniminuto.mvc.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * JPA Entity for <code>PEOPLE</code> data table.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PEOPLE")
public class Person implements Serializable {

    /**
     * Person's primary key.
     */
    @Id
    @Column(name = "PERS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Person's name.
     */
    @NotEmpty
    @Size(max = 255)
    @Column(name = "PERS_NAME", nullable = false)
    private String name;

    /**
     * Person's lastname.
     */
    @NotEmpty
    @Size(max = 255)
    @Column(name = "PERS_LASTNAME", nullable = false)
    private String lastname;

    /**
     * Person's age.
     */
    @NotNull
    @Column(name = "PERS_AGE", nullable = false)
    private Integer age;

}
