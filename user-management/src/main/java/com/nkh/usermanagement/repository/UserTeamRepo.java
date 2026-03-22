package com.nkh.usermanagement.repository;

import com.nkh.usermanagement.entity.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTeamRepo extends JpaRepository<UserTeam,Long> {
}
