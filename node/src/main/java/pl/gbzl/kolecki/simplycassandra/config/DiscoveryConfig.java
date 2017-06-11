package pl.gbzl.kolecki.simplycassandra.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by jakub on 04.06.17.
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ConfigurationProperties("discovery")
public class DiscoveryConfig {
    private String port;
    private String api;
    private String address;
    private String server;
}
