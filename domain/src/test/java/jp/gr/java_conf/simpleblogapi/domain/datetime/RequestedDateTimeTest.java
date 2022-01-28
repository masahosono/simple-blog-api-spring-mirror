package jp.gr.java_conf.simpleblogapi.domain.datetime;

import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.mockStatic;

class RequestedDateTimeTest {

    MockedStatic<LocalDateTime> localDateTimeStaticMock;

    @BeforeEach
    void setUp() {
        localDateTimeStaticMock = mockStatic(LocalDateTime.class);
    }

    @AfterEach
    void tearDown() {
        localDateTimeStaticMock.close();
    }

    @Test
    void nowWith() {
        // TODO: ユニットテストを作成
    }

}