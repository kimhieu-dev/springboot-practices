package com.nkh.usermanagement.controller;

import com.nkh.usermanagement.dto.request.TeamReq;
import com.nkh.usermanagement.entity.Team;
import com.nkh.usermanagement.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeam(){
        List<Team> response = teamService.getAllTeam();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id){
        Team response = teamService.getTeamById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamReq request){
        Team response = teamService.createTeam(request);
        return ResponseEntity.ok(response);
    }


}
