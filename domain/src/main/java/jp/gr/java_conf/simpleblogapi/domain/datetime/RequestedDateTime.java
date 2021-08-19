package jp.gr.java_conf.simpleblogapi.domain.datetime;

import java.time.Clock;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestedDateTime {

    private final LocalDateTime value;

    public static RequestedDateTime nowWith(Clock clock) {
        return new RequestedDateTime(LocalDateTime.now(clock));
    }

    public LocalDateTime value() {
        return value;
    }

}
