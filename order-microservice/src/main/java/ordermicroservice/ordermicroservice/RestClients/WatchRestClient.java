package ordermicroservice.ordermicroservice.RestClients;

import ordermicroservice.ordermicroservice.Model.Watch.Watch;
import ordermicroservice.ordermicroservice.Model.WatchModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "rolex-watch-microservice",url = "http://rolexwebsite.com:8082")
public interface WatchRestClient {
    @RequestMapping(value="/public/getWatchModelAndPrice", method = RequestMethod.GET)
    List<WatchModel> getWatchModelAndPrice(@RequestParam List<String> watchModel);

    @RequestMapping(value="/public/getWholeWatchDetails", method = RequestMethod.GET)
    List<Watch> getWholeWatchDetails(@RequestParam List<String> watchModel);

}