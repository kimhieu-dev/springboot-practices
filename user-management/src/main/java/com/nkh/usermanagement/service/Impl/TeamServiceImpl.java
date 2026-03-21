package com.nkh.usermanagement.service.Impl;

import com.nkh.usermanagement.dto.request.TeamReq;
import com.nkh.usermanagement.entity.Team;
import com.nkh.usermanagement.repository.TeamRepo;
import com.nkh.usermanagement.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepo teamRepo;


    @Override
    public List<Team> getAllTeam() {
        List<Team> teamList = teamRepo.findAll();
        return teamList;
    }

    @Override
    public Team getTeamById(Long id) {
        Optional<Team> teamOptional = teamRepo.findById(id);
        if(teamOptional.isEmpty()){
            throw new RuntimeException("Khong co team co id nay");
        }
        return teamOptional.get();
    }

    @Override
    public Team createTeam(TeamReq request) {
        //validate
        if(request.getName() == null || request.getName().isEmpty()){
            throw new RuntimeException("Name must not be null");
        }
        if(request.getDescription() == null || request.getDescription().isEmpty()){
            throw new RuntimeException("Description must not be null");
        }
        Optional<Team> teamOptional = teamRepo.findByName(request.getName());
        if(teamOptional.isPresent()){
            throw new RuntimeException("Da ton tai team nay");
        }
        Team team = new Team();
        team.setName(request.getName());
        team.setDescription(request.getDescription());
        teamRepo.save(team);
        return team;
    }

    @Override
    public Team updateTeam(Long id, TeamReq request) {
        //validate
        Optional<Team> teamOptional = teamRepo.findById(id);
        if(teamOptional.isEmpty()){
            throw new RuntimeException("Khong co team co id nay");
        }
        if(request.getName() == null || request.getName().isEmpty()){
            throw new RuntimeException("Name must not be null");
        }
        if(request.getDescription() == null || request.getDescription().isEmpty()){
            throw new RuntimeException("Description must not be null");
        }
        Optional<Team> isExistByName = teamRepo.findByName(request.getName());
        if(isExistByName.isPresent()){
            throw new RuntimeException("Da ton tai name team nay");
        }
        Team team = teamOptional.get();
        team.setName(request.getName());
        team.setDescription(request.getDescription());
        teamRepo.save(team);
        return team;
    }

    @Override
    public void deleteTeam(Long id) {
        //validate
        Optional<Team> teamOptional = teamRepo.findById(id);
        if(teamOptional.isEmpty()){
            throw new RuntimeException("Khong co team co id nay");
        }
        teamRepo.delete(teamOptional.get());
    }


}
