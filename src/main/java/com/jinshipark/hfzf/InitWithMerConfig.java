package com.jinshipark.hfzf;

import com.huifu.adapay.Adapay;
import com.huifu.adapay.model.MerConfig;
import com.jinshipark.hfzf.config.ADAPayPropertyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 汇付天下-初始化商户配置
 */
@Component
public class InitWithMerConfig implements ApplicationRunner {

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

        /**
         * 初始化商户配置，服务器启动前，必须通过该方式初始化商户配置完成
         * apiKey为prod模式的API KEY
         * mockApiKey为mock模式的API KEY
         * rsaPrivateKey为商户发起请求时，用于请求参数加签所需要的RSA私钥
         */
        String apiKey = ADAPayPropertyConfig.getStrValueByKey("api_key_live");
        String mockApiKey = ADAPayPropertyConfig.getStrValueByKey("api_key_test");
        String rsaPrivateKey = ADAPayPropertyConfig.getStrValueByKey("rsa_private_key");
        MerConfig merConfig = new MerConfig();
        merConfig.setApiKey(apiKey);
        merConfig.setApiMockKey(mockApiKey);
        merConfig.setRSAPrivateKey(rsaPrivateKey);
        Adapay.initWithMerConfig(merConfig);
    }
}
