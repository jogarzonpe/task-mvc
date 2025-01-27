package co.edu.uniminuto.mvc.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * JPA Entity for <code>ROLES</code> data table.
 */
@Data
@Entity
@Table(name = "ROLES")
public class Role implements Serializable {

    /**
     * Role's primary key.
     */
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Role's name.
     */
    @NotEmpty
    @Size(max = 25)
    @Column(name = "ROLE_NAME")
    private String name;

}
