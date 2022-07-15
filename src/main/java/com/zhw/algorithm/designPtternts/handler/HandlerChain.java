package com.zhw.algorithm.designPtternts.handler;

/**
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public abstract class HandlerChain {

    private EventHandler eventHandler;

    public HandlerChain(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    protected HandlerChain() {
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler){
        this.eventHandler=eventHandler;
    }

    public static class Builder{
        private EventHandler hearder;
        private EventHandler tail;

        public Builder addEventHandler(EventHandler eventHandler){
            if(hearder==null){
                this.hearder = this.tail = eventHandler;
                return this;
            }
            this.tail.setEventHandler(eventHandler);
            this.tail=eventHandler;
            return this;
        }

        public EventHandler build(){
            return this.hearder;
        }
    }
}
