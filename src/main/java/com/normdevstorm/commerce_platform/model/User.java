package com.normdevstorm.commerce_platform.model;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Account{
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
