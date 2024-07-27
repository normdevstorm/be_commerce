package com.normdevstorm.commerce_platform.model;
import com.normdevstorm.commerce_platform.config.validate.CustomValidation;
import com.normdevstorm.commerce_platform.enums.Role;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;
    @NotBlank(message = "Username is mandatory")
    private String username;
    @CustomValidation(message = "Password should be valid!!!")
    @NotBlank(message = "Password is mandatory")
    private String password;
    @Column(columnDefinition = "role default 'user'")
    @Enumerated(EnumType.STRING)
    private Role role;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    //todo: add validator later on
    @NonNull
    private String phoneNumber;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_address", joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private Set<Address> address;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Nullable
    private Set<Payment> payments;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Nullable
    private Set<Transaction> transactions;
}
