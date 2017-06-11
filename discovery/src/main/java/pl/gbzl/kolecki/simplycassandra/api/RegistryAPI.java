package pl.gbzl.kolecki.simplycassandra.api;

import api.IHeartBeatApi;
import dto.HeartBeatDTO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.gbzl.kolecki.simplycassandra.config.SessionConfig;

import java.util.Map;

import static pl.gbzl.kolecki.simplycassandra.utils.Constants.URI_API_PREFIX;
import static pl.gbzl.kolecki.simplycassandra.utils.Constants.URI_REGISTRY;

/**
 * Created by jakub on 02.06.17.
 */
@RestController
@RequestMapping(value = URI_API_PREFIX + URI_REGISTRY)
@Slf4j
public class RegistryAPI implements IHeartBeatApi {
    @Setter(onMethod = @__(@Autowired))
    private SessionConfig sessionConfig;

    @Override
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public Map<String, HeartBeatDTO> registryNode(@RequestBody HeartBeatDTO beat) {
        return this.sessionConfig.registerNewNode(beat);
    }
}
