package com.nkh.usermanagement.controller;

import com.nkh.usermanagement.dto.request.AssignUserToTeamReq;
import com.nkh.usermanagement.entity.Team;
import com.nkh.usermanagement.entity.UserTeam;
import com.nkh.usermanagement.service.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user-team")
public class UserTeamController {
    @Autowired
    private UserTeamService userTeamService;

    @GetMapping
    public ResponseEntity<List<UserTeam>> getAllUserTeam(){
        List<UserTeam> response = userTeamService.getAllUserTeam();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Team> addUserToTeam(@RequestBody AssignUserToTeamReq request){
        Team response = userTeamService.assignUserToTeam(request);
        return ResponseEntity.ok(response);
    }
}
