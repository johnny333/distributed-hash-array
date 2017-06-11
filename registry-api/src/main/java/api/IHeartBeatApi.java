package api;

import dto.HeartBeatDTO;
import feign.Headers;
import feign.RequestLine;

import java.util.Map;

/**
 * Created by jakub on 02.06.17.
 */
public interface IHeartBeatApi {

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    Map<String, HeartBeatDTO> registryNode(HeartBeatDTO beat);
}
