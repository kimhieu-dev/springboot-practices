package com.nkh.usermanagement.service;

import com.nkh.usermanagement.dto.request.TeamReq;
import com.nkh.usermanagement.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeam();

    Team getTeamById(Long id);

    Team createTeam(TeamReq request);

    Team updateTeam(Long id, TeamReq request);

    void deleteTeam(Long id);
}
