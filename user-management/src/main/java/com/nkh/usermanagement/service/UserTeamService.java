package com.nkh.usermanagement.service;

import com.nkh.usermanagement.dto.request.AssignUserToTeamReq;
import com.nkh.usermanagement.entity.Team;
import com.nkh.usermanagement.entity.UserTeam;

import java.util.List;

public interface UserTeamService {
    List<UserTeam> getAllUserTeam();

    Team assignUserTeam(AssignUserToTeamReq request);
}
