package com.levent.javabasedconf.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.levent.javabasedconf.dao.TeamDAO;
import com.levent.javabasedconf.dao.TeamDAOImpl;
import com.levent.javabasedconf.model.Team;
import com.levent.javabasedconf.service.TeamServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.levent.javabasedconf")//context-component 
@PropertySource(value = { "classpath:team.properties" })
public class SpringBeanConfig {

	@Value("${team.name}")
    private String name;

    @Value("${team.nickName}")
    private String nickName;

    @Value("${team.shirtColor}")
    private String shirtColor;
    
    @Value("#{new Integer('${team.championshipsWon}')}")
    private int championshipsWon;
    
    @Autowired
    private Environment env;
    
	@Bean
	public Team team1() {
		
		Team mcity = new Team("Manchester City", "The Sky Blues", "Blue and White", 6);
		
		return mcity;
	}
	@Bean
	public Team team2() {
		
		Team lvp = new Team("Liverpool", "The Reds", "Red", 19);
		
		return lvp;
	}
	@Bean
	public Team team3() {
		
		Team manu = new Team("Manchester United", "The Red Devils ", "Red and White", 20);
		
		return manu;
	}
	@Bean
	public Team team4() {
		
		Team cls = new Team(env.getProperty("team.name"), nickName, shirtColor,championshipsWon);
		
		return cls;
	}
	
	@Bean
	public TeamServiceImpl teamService() {
		
		TeamServiceImpl teamServiceImpl = new TeamServiceImpl();
		
		return teamServiceImpl;
	}
	
	@Bean
	public TeamDAO teamDAO() {
		
		TeamDAO teamDAO = new TeamDAOImpl();
		
		return teamDAO;
	}
}
