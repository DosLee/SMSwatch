package com.wei.smswatch;

import java.io.Serializable;
import java.util.Objects;

public class SmsContent implements Serializable {

    private static final long serialVersionUID = 4549180489446166767L;

    private String content;
    private String address;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsContent sms = (SmsContent) o;
        return Objects.equals(content, sms.content) &&
                Objects.equals(address, sms.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, address);
    }

    @Override
    public String toString() {
        return "Sms{" +
                "content='" + content + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
