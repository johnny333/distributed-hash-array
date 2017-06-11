package pl.gbzl.kolecki.simplycassandra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.gbzl.kolecki.simplycassandra.config.DiscoveryConfig;
import pl.gbzl.kolecki.simplycassandra.config.NodeConfig;
import pl.gbzl.kolecki.simplycassandra.config.SessionConfig;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication(scanBasePackages = {"client"})
@EnableScheduling
@EnableAutoConfiguration
@Import({DiscoveryConfig.class, NodeConfig.class, SessionConfig.class})
public class NodeApplication {

	public static void main(String[] args) throws UnknownHostException {

		SpringApplication pApp = new SpringApplication(NodeApplication.class);
		Environment pEnv = pApp.run(args).getEnvironment();
		final String pPort = pEnv.getProperty("server.port");
		final String pHost = InetAddress.getLocalHost().getHostAddress();
		log.info("Access URLs:\n----------------------------------------------------------\n\t" +
						"Local: \t\thttp://{}:{}\n\t" +
						"External: \thttp://{}:{}\n\t---------------------------------------------------------",
				pHost, pPort,
				pHost, pPort);
	}
}
