package pl.gbzl.kolecki.simplycassandra.services.heartBeat.impl;

import api.IHeartBeatApi;
import client.HeartBeatClientBuilder;
import dto.HeartBeatDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.gbzl.kolecki.simplycassandra.config.DiscoveryConfig;
import pl.gbzl.kolecki.simplycassandra.config.NodeConfig;
import pl.gbzl.kolecki.simplycassandra.config.SessionConfig;
import pl.gbzl.kolecki.simplycassandra.services.heartBeat.IRegistryInDiscoveryService;

import java.net.UnknownHostException;

/**
 * Created by jakub on 02.06.17.
 */
@Service
public class IRegistryInDiscoveryServiceImpl implements IRegistryInDiscoveryService {

    @Setter(onMethod = @__(@Autowired))
    private NodeConfig nodeConfig;
    @Setter(onMethod = @__(@Autowired))
    private SessionConfig sessionConfig;
    @Setter(onMethod = @__(@Autowired))
    private DiscoveryConfig discoveryConfig;

    private IHeartBeatApi beatApi = HeartBeatClientBuilder.heartBeatFactory(IHeartBeatApi.class, this.discoveryConfig.getAddress());

    @Override
    @Scheduled(cron = "*/2 * * * * *")
    public void registerInDiscovery() {
        System.out.println("now");
        try {
            this.sessionConfig.setNodes(this.beatApi.registryNode(new HeartBeatDTO(this.nodeConfig.getNodeAddress(), this.nodeConfig.getHashKey())));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
