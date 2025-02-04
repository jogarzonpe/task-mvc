package co.edu.uniminuto.mvc.data.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * JPS entity for <code>EMPLOYEES</code> data table.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

    /**
     * Employee's Primary Key.
     */
    @Id
    @Column(name = "EMPL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Employee's started date.
     */
    @Column(name = "EMPL_STARTED_DATE", nullable = false)
    private LocalDate startedDate;

    /**
     * Employee's password hash, cyphered.
     */
    @Column(name = "EMPL_FINISHED_DATE", nullable = false)
    private LocalDate finishedDate;

    /**
     * Employee's person information.
     */
    @MapsId
    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "PERS_ID", unique = true, nullable = false)
    private Person data;

    /**
     * Employee's job title relationship.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "JOB_ID", nullable = false)
    private JobTitle jobTitle;

    /**
     * Employee's dependency relationship.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "DEPE_ID", nullable = false)
    private Dependency dependency;

}
