# JavaBasedConfiguration and @PropertySource Annotation

@PropertySource annotation is used to provide properties file to Spring Environment. 

## team.properties File
```
team.name=Chelsea
team.nickName=The Blues
team.shirtColor=White and Blue
team.championshipsWon=6
```
## Configuration Class

```
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
```
## Test Class
```
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
