package com.nkh.usermanagement.service.Impl;

import com.nkh.usermanagement.dto.request.AssignUserToTeamReq;
import com.nkh.usermanagement.entity.Team;
import com.nkh.usermanagement.entity.User;
import com.nkh.usermanagement.entity.UserTeam;
import com.nkh.usermanagement.repository.TeamRepo;
import com.nkh.usermanagement.repository.UserRepo;
import com.nkh.usermanagement.repository.UserTeamRepo;
import com.nkh.usermanagement.service.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserTeamServiceImpl implements UserTeamService {
    @Autowired
    private UserTeamRepo userTeamRepo;
    @Autowired
    private TeamRepo teamRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<UserTeam> getAllUserTeam() {
        return userTeamRepo.findAll();
    }

    @Override
    public Team assignUserTeam(AssignUserToTeamReq request) {
        //validate
        if (request.getTeamId() == null) {
            throw new RuntimeException("ko duoc de trong team id");
        }
        if (request.getUserId().isEmpty()) {
            throw new RuntimeException("ko duoc de trong user id");
        }
        Optional<Team> teamOptional = teamRepo.findById(request.getTeamId());
        if (teamOptional.isEmpty()) {
            throw new RuntimeException("team id nay ko ton tai");
        }
        List<User> userList = userRepo.findAllById(request.getUserId());
        if (userRepo.findAllById(request.getUserId()).isEmpty()) {
            throw new RuntimeException("cac user id nay ko ton tai");
        }
        List<UserTeam> userTeamList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            UserTeam userTeam = new UserTeam();
            userTeam.setTeam(teamOptional.get());
            userTeam.setUser(userList.get(i));
            userTeamList.add(userTeam);
        }
        userTeamRepo.saveAll(userTeamList);
        return teamOptional.get();
    }
}
