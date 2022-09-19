package com.levent.javabasedconf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levent.javabasedconf.dao.TeamDAO;
import com.levent.javabasedconf.model.Team;



public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamDAO teamDAO;

	public void insertTeam(Team team) {
		// TODO Auto-generated method stub
		teamDAO.insertTeam(team);
	//	System.out.println("TeamService inserted Team ");
	}

	@Override
	public void displayTeams() {
		
		teamDAO.displayTeams();	
	}

	
}
