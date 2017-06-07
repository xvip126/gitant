package com.gitant.gitant.common.eventbus;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 18:35.
 */

public class DelayMsg {
    private long delayTime;

    public DelayMsg(long delayTime) {
        this.delayTime = delayTime;
    }

    public long getDelayTime() {
        return delayTime;
    }
}
