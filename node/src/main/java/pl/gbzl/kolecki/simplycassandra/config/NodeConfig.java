package pl.gbzl.kolecki.simplycassandra.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by jakub on 10.06.17.
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("node")
public class NodeConfig {
    private String hashKey;
    @Autowired
    Environment environment;

    public String getHashKey() throws UnknownHostException {
        final String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String port = environment.getProperty("server.port");
        String compact = Jwts.builder()
                .setSubject(hostAddress + port)
                .signWith(SignatureAlgorithm.HS512, hashKey)
                .compact();
        return compact;
    }

    public String getNodeAddress() {
        try {
            String port = environment.getProperty("server.port");
            final String hostAddress = InetAddress.getLocalHost().getHostAddress();
            return hostAddress + ":" + port;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
