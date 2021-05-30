package com.jigowatts.faq.domain.model.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderNumberTest {

    OrderNumber target;

    @Nested
    @DisplayName("正常系テスト")
    class NormalTest {
        @Test
        @DisplayName("OrderNumberの値フォーマット(yyyyMMdd + 半角英数字8桁)")
        void orderNumberValue() {
            LocalDate today = LocalDate.of(2021, 2, 3);
            String uniqueId = "A1b2c3D4";

            target = new OrderNumber(today, uniqueId);
            assertEquals("20210203A1b2c3D4", target.toString());
        }

        @Test
        @DisplayName("OrderNumberの文字列長が16")
        void orderNumberLength() {
            LocalDate today = LocalDate.of(2021, 2, 3);
            String uniqueId = "A1b2c3D4";

            target = new OrderNumber(today, uniqueId);
            assertEquals(16, target.toString().length());
        }
    }

    @Nested
    @DisplayName("異常系テスト")
    class AbnormalTest {
        @Test
        @DisplayName("引数todayがnull")
        void todayIsNull_throwsException() throws IllegalArgumentException {
            LocalDate today = null;
            String uniqueId = null;

            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
                target = new OrderNumber(today, uniqueId);
            });
            assertEquals("today is null.", e.getMessage());
        }

        @DisplayName("引数uniqueIdが空の場合は例外を返す")
        @ParameterizedTest(name = "引数uniqueIdが{1}の場合")
        @CsvSource({ "2021-02-03, ", "2021-02-03, ''" })
        void uniqueIdIsEmpty_throwsException(LocalDate today, String uniqueId) {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
                target = new OrderNumber(today, uniqueId);
            });
            assertEquals("uniqueId has not text.", e.getMessage());
        }

        @DisplayName("引数uniqueIdが規定の桁数ではない場合は例外を返す")
        @ParameterizedTest(name = "引数uniqueIdが{1}の場合")
        @CsvSource({ "2021-02-03, 1234567", "2021-02-03, 123456789" })
        void uniqueIdIsIllegalSpecifiedLength_throwsException(LocalDate today, String uniqueId) {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
                target = new OrderNumber(today, uniqueId);
            });
            assertEquals("uniqueId is not a 8-digit string.", e.getMessage());
        }

        @DisplayName("引数uniqueIdが半角英数字ではない場合は例外を返す")
        @ParameterizedTest(name = "引数uniqueIdが{1}の場合")
        @CsvSource({ "2021-02-03, あいうえおかきく", "2021-02-03, アイウエオカキク", "2021-02-03, 一二三四五六七八", "2021-02-03, !@#$%^&*", })
        void uniqueIdIsIllegalHalfAlphaNumericCharacters_throwsException(LocalDate today, String uniqueId) {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
                target = new OrderNumber(today, uniqueId);
            });
            assertEquals("uniqueId is not half width alphanumeric characters.", e.getMessage());
        }
    }
}
