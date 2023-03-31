package ru.javarush.november.zaharin.thegame.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javarush.november.zaharin.thegame.entity.Answer;

import java.util.Map;
import java.util.Optional;

class AnswerRepositoryTest {

    private AnswerRepository answerRepository = new AnswerRepository(Map.of(2, new Answer("Принять вызов", 2, 4),
            3, new Answer("Отклонить вызов", 3, 10),
            5, new Answer("Подняться на мостик", 5, 9),
            6, new Answer("Отказаться подниматься на мостик", 6, 11),
            9, new Answer("Солгать о себе", 9, 12),
            8, new Answer("Рассказать правду о себе", 8, 13)));

    @Test
    void getAnswerById() {
        Answer expected = new Answer("Отклонить вызов", 3, 10);
        Assertions.assertEquals(expected, answerRepository.getAnswerById(3));
    }

    @Test
    void getAnswerForId() {
        Answer expected = new Answer("Отклонить вызов", 3, 10);
        Assertions.assertEquals(Optional.of(expected), answerRepository.getAnswerForId(3));
    }
}
