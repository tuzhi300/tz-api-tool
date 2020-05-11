package net.kuper.tz.apitool;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.kuper.tz.apitool.service.BMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class Services {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public BMapService callApi() {
        String url = "http://api.map.baidu.com/";
        return ApiTool.createService(BMapService.class, url, objectMapper);
    }

}
