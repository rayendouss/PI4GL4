package com.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "ACbabdb75e8ba1d154d1d92291ac51cabf";
    public static final String AUTH_TOKEN =
            "bb15bc66862f2bf1f6913e610e569900";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+21693157330"), // to
                        new PhoneNumber("+12345420560"), // from
                        "evaluation done")
                .create();//

       System.out.println(message.getSid());//
    }
}
