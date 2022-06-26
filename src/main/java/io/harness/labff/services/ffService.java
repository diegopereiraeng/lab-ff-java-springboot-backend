package io.harness.labff.services;

import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;
import io.harness.cf.client.api.CfClient;
import io.harness.cf.client.api.Event;
import io.harness.cf.client.dto.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ffService {
    private static final Logger log = LoggerFactory.getLogger(ffService.class);

    public static CfClient featureFlagService = new CfClient(Dotenv.configure().directory("./").ignoreIfMalformed().ignoreIfMissing().load().get("FF_SDK_KEY"));;


    public ffService() {
//        CfClient ffClient = new CfClient(this.sdkDefault);
//        final FileMapStore fileStore = new FileMapStore(dotenv.get("FF_ENV"));
//        CfClient ffClient = new CfClient(this.sdkDefault, BaseConfig.builder().store(fileStore).build());
//        this.featureFlagService = ffClient;
        Target target = Target.builder().name("Diego Pereira").identifier("diego.pereira@harness.io").build();
        String result = this.featureFlagService.stringVariation("API_TUTORIALS_ENABLED", target, "v5");
        System.out.println("API_TUTORIALS_ENABLED Flag Value: "+result);
    }


}
