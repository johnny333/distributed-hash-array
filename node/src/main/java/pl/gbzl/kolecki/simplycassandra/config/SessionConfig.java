package pl.gbzl.kolecki.simplycassandra.config;

import dto.HeartBeatDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jakub on 11.06.17.
 */
@Builder
@Scope(value = WebApplicationContext.SCOPE_GLOBAL_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Configuration
public class SessionConfig {
    @Getter @Setter
    private Map<String,HeartBeatDTO> nodes = new HashMap<>();

}
