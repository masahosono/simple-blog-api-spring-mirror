package jp.gr.java_conf.simpleblogapi.domain.datetime;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RequestedDateTime {

    private final LocalDateTime value;

    public static RequestedDateTime nowWith(Clock clock) {
        return new RequestedDateTime(LocalDateTime.now(clock));
    }

    public String format() {
        return value.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

}
