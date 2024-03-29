package io.hamzaprojs.psldashboard.repository;

import io.hamzaprojs.psldashboard.Model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);
}
