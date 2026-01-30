@SpringBootApplication
@EnableConfigurationProperties(DemoConfig.class)
public class HotReloadApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotReloadApplication.class, args);
    }
}
