package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.AdministratorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorProfileRepo extends JpaRepository<AdministratorProfile, Integer> {
}
