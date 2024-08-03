package com.github.eljaiek.issues;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ToString
@Table(name = "users")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "user_email")
    private String email;

    @Basic(optional = false)
    @Column(name = "user_password")
    private String password;

    @Basic(optional = false)
    @Column(name = "user_enabled")
    private boolean enabled;

    public void update(User user) {

        if(!this.equals(user)) {
            throw new IllegalArgumentException("Source entity must be equals to destiny entity.");
        }

        email = user.email;
        password = user.password;
        enabled = user.enabled;
    }
}
