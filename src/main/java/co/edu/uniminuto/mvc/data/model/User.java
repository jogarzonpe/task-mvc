package co.edu.uniminuto.mvc.data.model;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * JPS entity for <code>USERS</code> data table.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User implements Serializable {

    /**
     * User's Primary Key.
     */
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User's unique login, defined as email.
     */
    @Email
    @NotEmpty
    @Size(max = 100)
    @Column(name = "USER_EMAIL", length = 100, nullable = false, unique = true)
    private String email;

    /**
     * User's password hash, cyphered.
     */
    @NotEmpty
    @Size(max = 200)
    @Column(name = "USER_PASSWORD_HASH", length = 200, nullable = false)
    private String password;

    /**
     * User's person information.
     */
    @MapsId
    @OneToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "USER_ID", referencedColumnName = "PERS_ID", unique = true, nullable = false)
    private Person data;

    /**
     * User's role relationship.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;

}
