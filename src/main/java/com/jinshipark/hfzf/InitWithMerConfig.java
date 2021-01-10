package com.jinshipark.hfzf;

import com.huifu.adapay.Adapay;
import com.huifu.adapay.model.MerConfig;
import com.jinshipark.hfzf.config.ADAPayPropertyConfig;
import com.jinshipark.hfzf.mapper2.JinshiparkApakeyMapper;
import com.jinshipark.hfzf.model.JinshiparkApakey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 汇付天下-初始化商户配置
 */
@Component
public class InitWithMerConfig implements ApplicationRunner {

    @Autowired
    private JinshiparkApakeyMapper jinshiparkApakeyMapper;

    private static final Logger log = LoggerFactory.getLogger(InitWithMerConfig.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initWithMerConfig();
    }

    public void initWithMerConfig() throws Exception {
        /**
         * debug 模式，开启后有详细的日志
         */
        Adapay.debug = true;

        /**
         * prodMode 模式，默认为生产模式，false可以使用mock模式
         */
        Adapay.prodMode = true;

        Map<String, MerConfig> configPathMap = new HashMap<>();
        List<JinshiparkApakey> jinshiparkApakeyList = jinshiparkApakeyMapper.selectAll();
        for (JinshiparkApakey jinshiparkApakey : jinshiparkApakeyList) {
            if (jinshiparkApakey.getParkid() == null || jinshiparkApakey.getParkid().equals("")
                    || jinshiparkApakey.getAppid() == null || jinshiparkApakey.getAppid().equals("")
                    || jinshiparkApakey.getRsaprivatekey() == null || jinshiparkApakey.getRsaprivatekey().equals("")
                    || jinshiparkApakey.getApikeylive() == null || jinshiparkApakey.getApikeylive().equals("")
                    || jinshiparkApakey.getApikeytest() == null || jinshiparkApakey.getApikeytest().equals("")) {
                continue;
            }
            MerConfig merConfig = new MerConfig();
            merConfig.setApiKey(jinshiparkApakey.getApikeylive());
            merConfig.setApiMockKey(jinshiparkApakey.getApikeytest());
            merConfig.setRSAPrivateKey(jinshiparkApakey.getRsaprivatekey());
            configPathMap.put(jinshiparkApakey.getParkid(), merConfig);
        }
        Adapay.initWithMerConfigs(configPathMap);

//        String apiKey1 = "api_live_9c14f264-e390-41df-984d-df15a6952031";
//        String mockApiKey1 = "api_test_e640fa26-bbe6-458f-ac44-a71723ee2176";
//        String rsaPrivateKey1 = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMQhsygJ2pp4nCiDAXiqnZm6AzKSVAh+C0BgGR6QaeXzt0TdSi9VR0OQ7Qqgm92NREB3ofobXvxxT+wImrDNk6R6lnHPMTuJ/bYpm+sx397rPboRAXpV3kalQmbZ3P7oxtEWOQch0zV5B1bgQnTvxcG3REAsdaUjGs9Xvg0iDS2tAgMBAAECgYAqGFmNdF/4234Yq9V7ApOE1Qmupv1mPTdI/9ckWjaAZkilfSFY+2KqO8bEiygo6xMFCyg2t/0xDVjr/gTFgbn4KRPmYucGG+FzTRLH0nVIqnliG5Ekla6a4gwh9syHfstbOpIvJR4DfldicZ5n7MmcrdEwSmMwXrdinFbIS/P1+QJBAOr6NpFtlxVSGzr6haH5FvBWkAsF7BM0CTAUx6UNHb+RCYYQJbk8g3DLp7/vyio5uiusgCc04gehNHX4laqIdl8CQQDVrckvnYy+NLz+K/RfXEJlqayb0WblrZ1upOdoFyUhu4xqK0BswOh61xjZeS+38R8bOpnYRbLf7eoqb7vGpZ9zAkEAobhdsA99yRW+WgQrzsNxry3Ua1HDHaBVpnrWwNjbHYpDxLn+TJPCXvI7XNU7DX63i/FoLhOucNPZGExjLYBH/wJATHNZQAgGiycjV20yicvgla8XasiJIDP119h4Uu21A1Su8G15J2/9vbWn1mddg1pp3rwgvxhw312oInbHoFMxsQJBAJlyDDu6x05MeZ2nMor8gIokxq2c3+cnm4GYWZgboNgq/BknbIbOMBMoe8dJFj+ji3YNTvi1MSTDdSDqJuN/qS0=";
//
//
//        MerConfig merConfig1 = new MerConfig();
//        merConfig1.setApiKey(apiKey1);
//        merConfig1.setApiMockKey(mockApiKey1);
//        merConfig1.setRSAPrivateKey(rsaPrivateKey1);
//
//        String apiKey2 = "api_live_9c14f264-e390-41df-984d-df15a6952031";
//        String mockApiKey2 = "api_test_e640fa26-bbe6-458f-ac44-a71723ee2176";
//        String rsaPrivateKey2 = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMQhsygJ2pp4nCiDAXiqnZm6AzKSVAh+C0BgGR6QaeXzt0TdSi9VR0OQ7Qqgm92NREB3ofobXvxxT+wImrDNk6R6lnHPMTuJ/bYpm+sx397rPboRAXpV3kalQmbZ3P7oxtEWOQch0zV5B1bgQnTvxcG3REAsdaUjGs9Xvg0iDS2tAgMBAAECgYAqGFmNdF/4234Yq9V7ApOE1Qmupv1mPTdI/9ckWjaAZkilfSFY+2KqO8bEiygo6xMFCyg2t/0xDVjr/gTFgbn4KRPmYucGG+FzTRLH0nVIqnliG5Ekla6a4gwh9syHfstbOpIvJR4DfldicZ5n7MmcrdEwSmMwXrdinFbIS/P1+QJBAOr6NpFtlxVSGzr6haH5FvBWkAsF7BM0CTAUx6UNHb+RCYYQJbk8g3DLp7/vyio5uiusgCc04gehNHX4laqIdl8CQQDVrckvnYy+NLz+K/RfXEJlqayb0WblrZ1upOdoFyUhu4xqK0BswOh61xjZeS+38R8bOpnYRbLf7eoqb7vGpZ9zAkEAobhdsA99yRW+WgQrzsNxry3Ua1HDHaBVpnrWwNjbHYpDxLn+TJPCXvI7XNU7DX63i/FoLhOucNPZGExjLYBH/wJATHNZQAgGiycjV20yicvgla8XasiJIDP119h4Uu21A1Su8G15J2/9vbWn1mddg1pp3rwgvxhw312oInbHoFMxsQJBAJlyDDu6x05MeZ2nMor8gIokxq2c3+cnm4GYWZgboNgq/BknbIbOMBMoe8dJFj+ji3YNTvi1MSTDdSDqJuN/qS0=";
//
//
//        MerConfig merConfig2 = new MerConfig();
//        merConfig2.setApiKey(apiKey2);
//        merConfig2.setApiMockKey(mockApiKey2);
//        merConfig2.setRSAPrivateKey(rsaPrivateKey2);
//
//        Map<String, MerConfig>configPathMap = new HashMap<>();
////参数1为merchantKey,是商户的唯一标识，商户自定义即可
//        configPathMap.put("yifuyun", merConfig1);
//        configPathMap.put("yidian", merConfig2);
//
//        Adapay.initWithMerConfigs(configPathMap);
//
//        /**
//         * 初始化商户配置，服务器启动前，必须通过该方式初始化商户配置完成
//         * apiKey为prod模式的API KEY
//         * mockApiKey为mock模式的API KEY
//         * rsaPrivateKey为商户发起请求时，用于请求参数加签所需要的RSA私钥
//         */
//        String apiKey = ADAPayPropertyConfig.getStrValueByKey("api_key_live");
//        String mockApiKey = ADAPayPropertyConfig.getStrValueByKey("api_key_test");
//        String rsaPrivateKey = ADAPayPropertyConfig.getStrValueByKey("rsa_private_key");
//        MerConfig merConfig = new MerConfig();
//        merConfig.setApiKey(apiKey);
//        merConfig.setApiMockKey(mockApiKey);
//        merConfig.setRSAPrivateKey(rsaPrivateKey);
//        Adapay.initWithMerConfig(merConfig);
    }
}
