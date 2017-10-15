package com.quark.cloud.receiver;

import com.quark.cloud.StreamApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


/**
 * Created by ZhenpengLu on 2017/10/13.
 */
//把自定义通道注入容器否则会报错org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type
@EnableBinding(value ={MySource.class,MySink.class})
public class MySinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(StreamApplication.class);

    @StreamListener(MySink.CHANNEL_NAME)
    public void receive(String payload){
        logger.info("stream-master-MySinkReceiver"+payload);
    }
}