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
 * JPS entity for <code>CUSTOMERS</code> data table.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {

    /**
     * Customer's Primary Key.
     */
    @Id
    @Column(name = "CUST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Customer's since date.
     */
    @Builder.Default
    @Column(name = "CUST_SINCE_DATE", nullable = false)
    private LocalDate sinceDate = LocalDate.now();

    /**
     * Customer's person information.
     */
    @MapsId
    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUST_ID", referencedColumnName = "PERS_ID", unique = true, nullable = false)
    private Person data;

    /**
     * Customer's employee responsible relationship.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "EMPL_ID_RESPONSIBLE", nullable = false)
    private Employee responsible;

}
