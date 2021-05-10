package io.hamzaprojs.psldashboard.Controllers;

import io.hamzaprojs.psldashboard.Model.Team;
import io.hamzaprojs.psldashboard.repository.MatchRepository;
import io.hamzaprojs.psldashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TeamController {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team = this.teamRepository.findByTeamName(teamName);
        team.setMatches(this.matchRepository.findLatestMatchesbyTeamName(teamName, 4));
        return  team;
    }
}
