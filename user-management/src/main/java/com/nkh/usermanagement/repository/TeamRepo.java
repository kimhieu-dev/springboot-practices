package com.nkh.usermanagement.repository;

import com.nkh.usermanagement.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface TeamRepo extends JpaRepository<Team,Long> {
    Optional<Team> findByName(String name);
}
