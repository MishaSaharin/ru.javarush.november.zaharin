package ru.javarush.november.zaharin.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javarush.november.zaharin.entity.Answer;

import java.util.Map;

class AnswerFactoryTest {

    private AnswerFactory answerFactory = new AnswerFactory(Map.of(2, new Answer("Принять вызов", 2, 4),
            3, new Answer("Отклонить вызов", 3, 10),
            5, new Answer("Подняться на мостик", 5, 9),
            6, new Answer("Отказаться подниматься на мостик", 6, 11),
            9, new Answer("Солгать о себе", 9, 12),
            8, new Answer("Рассказать правду о себе", 8, 13)));

    @Test
    void getAnswerByIdShouldReturnAnswer() {
        Answer expected = new Answer("Отклонить вызов", 3, 10);
        Assertions.assertEquals(expected, answerFactory.getAnswerById(3));
    }
}
