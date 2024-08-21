package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.entity.Address;
import com.normdevstorm.commerce_platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(@NonNull String username);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    public User findByResetPasswordToken(String token);

    @Transactional
    @Modifying
    @Query("""
            update User u set u.username = ?1, u.phoneNumber = ?2, u.firstName = ?3, u.lastName = ?4, u.address = ?5, u.password = ?6
            where u.username = ?7""")
    int updateUsernameAndPhoneNumberAndFirstNameAndLastNameAndAddressAndPasswordByUsername(@Nullable String username, @Nullable String phoneNumber, @Nullable String firstName, @Nullable String lastName, @Nullable Address address, @Nullable String password, @NonNull String username1);

    @Transactional
    @Modifying
    @Query("update User u set u.password = ?1 where u.userId = ?2")
    int updatePasswordByUserId(@NonNull String password, @NonNull UUID userId);
}