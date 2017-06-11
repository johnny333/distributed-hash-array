package dto;

import java.io.Serializable;

/**
 * Created by jakub on 02.06.17.
 */

public class HeartBeatDTO implements Serializable {
    private String nodeAddress;

    private String hash;

    public HeartBeatDTO() {
    }

    public HeartBeatDTO(String nodeAddress, String hash) {
        this.nodeAddress = nodeAddress;
        this.hash = hash;
    }

    public String getNodeAddress() {
        return nodeAddress;
    }

    public void setNodeAddress(String nodeAddress) {
        this.nodeAddress = nodeAddress;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
