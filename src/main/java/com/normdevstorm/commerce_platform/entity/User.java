package com.normdevstorm.commerce_platform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.normdevstorm.commerce_platform.config.validate.CustomPasswordValidation;
import com.normdevstorm.commerce_platform.config.validate.CustomPhoneNumValidation;
import com.normdevstorm.commerce_platform.enums.Role;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
//    @JsonIgnore(value = true)
    private UUID userId;
    @NotBlank(message = "Username is mandatory")
    @Column(unique = true)
    private String username;
    @CustomPasswordValidation(message = "Password should be valid!!!")
    @NotBlank(message = "Password is mandatory")
    private String password;
//    @Column(columnDefinition = "default 'admin'")
    @Enumerated(EnumType.STRING)
    @ColumnDefault(value = "USER")
    private Role role;
    @NonNull
    @Size(max = 50, message = "Name should not exceed 50 character length")
    private String firstName;
    @NonNull
    @Size(max = 50, message = "Name should not exceed 50 character length")
    private String lastName;
    @NonNull
    @CustomPhoneNumValidation
    private String phoneNumber;
    @Nullable
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_address", joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "addressId")})
    private Set<Address> address;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Nullable
    private Set<Payment> payments;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Nullable
    private Set<Transaction> transactions;
    @Builder
    public User(final String username, final String password, final Role role, final @NonNull String firstName, final @NonNull String lastName, final @NonNull String phoneNumber, @jakarta.annotation.Nullable final Set<Address> address, @jakarta.annotation.Nullable final Set<Payment> payments) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.payments = payments;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
