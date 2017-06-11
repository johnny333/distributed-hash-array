package pl.gbzl.kolecki.simplycassandra.api;

import io.jsonwebtoken.Jwts;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.gbzl.kolecki.simplycassandra.config.NodeConfig;

/**
 * Created by jakub on 11.06.17.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Setter(onMethod = @__(@Autowired))
    private NodeConfig nodeConfig;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public String a(Long a){
        return nodeConfig.getNodeAddress();
    }
}
