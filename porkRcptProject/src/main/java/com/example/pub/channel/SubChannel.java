package com.example.pub.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SubChannel {
	
    //채널이름
    String INPUT = "sub1";

    
    @Input(SubChannel.INPUT)
    SubscribableChannel input();
}
