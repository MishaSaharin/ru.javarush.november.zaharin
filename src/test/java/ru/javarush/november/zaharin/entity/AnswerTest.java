package ru.javarush.november.zaharin.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

class AnswerTest {
    Answer answerMock = Mockito.mock(Answer.class);
    Answer answer = new Answer("Принять вызов",
            2,
            4);

    @Test
    //
    void getAnswerTextShouldReturnString() {
        String answerText = answer.getAnswerText();
        Assertions.assertEquals("Принять вызов", answerText);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "adssd", "12313 qwerjgwe", "zxzxczc", ".,m,.m bmnb iouoi %$%^&&^%%%", "OP[TYUOTYY TY[UOTYUTYU"})
    void setAnswerTextShouldReturnString(String answerText) {
        answer.setAnswerText(answerText);
        Assertions.assertEquals(answerText, answer.getAnswerText());
    }

    @Test
    void getIdShouldReturnInteger() {
        Integer id = answer.getId();
        Assertions.assertEquals(2, id);
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -123123123, -1, 0, 12735123, Integer.MAX_VALUE})
    void setIdShouldReturnInteger(Integer id) {
        answer.setId(id);
        Assertions.assertEquals(id, answer.getId());
    }

    @Test
    void getNextQuestionIdShouldReturnInteger() {
        Integer id = answer.getNextQuestionId();
        Assertions.assertEquals(4, id);
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -123123123, -1, 0, 12735123, Integer.MAX_VALUE})
    void setNextQuestionIdShouldReturnInteger(Integer id) {
        answer.setNextQuestionId(id);
        Assertions.assertEquals(id, answer.getNextQuestionId());
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "adssd", "12313 qwerjgwe", "zxzxczc", ".,m,.m bmnb iouoi %$%^&&^%%%", "OP[TYUOTYY TY[UOTYUTYU"})
    void testEqualsShouldReturnString(String test) {
        Answer answerTest = new Answer("Принять вызов",
                4,
                2);
        Assertions.assertEquals(answerTest.equals(test), answer.equals(test));
    }
}
