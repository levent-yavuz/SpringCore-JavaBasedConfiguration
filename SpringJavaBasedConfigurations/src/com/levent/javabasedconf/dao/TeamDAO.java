package com.levent.javabasedconf.dao;

import java.util.ArrayList;
import java.util.List;

import com.levent.javabasedconf.model.Team;

public interface TeamDAO {

	List<Team> teams = new ArrayList<Team>();
	
	void insertTeam(Team team);
	
	void displayTeams();
	
}
