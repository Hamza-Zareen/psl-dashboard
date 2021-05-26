package io.hamzaprojs.psldashboard.Controllers;

import io.hamzaprojs.psldashboard.Model.Match;
import io.hamzaprojs.psldashboard.Model.Team;
import io.hamzaprojs.psldashboard.repository.MatchRepository;
import io.hamzaprojs.psldashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
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

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year){
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year+1, 1, 1);
        return this.matchRepository.getMatchesByTeamBetweenDates(
                teamName,
                startDate,
                endDate);
    }

    @GetMapping("/team")
    public Iterable<Team> getAllTeam(){
        return this.teamRepository.findAll();
    }



}
