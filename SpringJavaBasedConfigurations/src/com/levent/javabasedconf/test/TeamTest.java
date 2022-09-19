package com.levent.javabasedconf.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.levent.javabasedconf.configuration.SpringBeanConfig;
import com.levent.javabasedconf.model.Team;
import com.levent.javabasedconf.service.TeamService;
import com.levent.javabasedconf.service.TeamServiceImpl;

public class TeamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
			
		TeamService service = context.getBean(TeamServiceImpl.class);
		
		Team t1 = context.getBean("team1", Team.class);
		Team t2 = context.getBean("team2", Team.class);
		Team t3 = context.getBean("team3", Team.class);
		Team t4 = context.getBean("team4", Team.class);		
		
		service.insertTeam(t1);
		service.insertTeam(t2);
		service.insertTeam(t3);
		service.insertTeam(t4);
		service.displayTeams();
	}
}
