package com.zhw.algorithm.designPtternts.okhttp.vo;

/**
 * Request类时通过构造者模式创建，如下所示，Request类会传递请求的url、请求类型、请求头和请求体，会在拦截器中校验和设置这些值
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class Request {

    private String url;

    private String mediaType;

    private String body;

    private String header;

    public Request() {
    }

    public Request(Builder builder) {
        this.url = builder.url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public static class Builder{
        private String url;

        public Builder url(String url){
            this.url=url;
            return this;
        }

        public Request build(){
            return new Request(this);
        }

    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", body='" + body + '\'' +
                ", header='" + header + '\'' +
                '}';
    }
}
