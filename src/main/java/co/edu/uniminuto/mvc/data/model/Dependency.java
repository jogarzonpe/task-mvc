package co.edu.uniminuto.mvc.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * JPA Entity for <code>DEPENDENCIES</code> data table.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPENDENCIES")
public class Dependency implements Serializable {

    /**
     * Dependency's primary key.
     */
    @Id
    @Column(name = "DEPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Dependency's name.
     */
    @NotEmpty
    @Size(max = 100)
    @Column(name = "DEPE_NAME", nullable = false, length = 100)
    private String name;


}
