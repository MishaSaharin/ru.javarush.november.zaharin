package ru.javarush.november.zaharin.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javarush.november.zaharin.entities.Answer;
import ru.javarush.november.zaharin.entities.Question;

import java.io.IOException;
import java.util.List;
import java.util.Map;

class AppRepositoryTest {

    private AppRepository appRepository = new AppRepository();

    private QuestionRepository questionRepository = new QuestionRepository(Map.of(1, new Question(1, "Ты потерял память. Принять вызов НЛО?", List.of(2, 3), false),
            4, new Question(4, "Ты принял вызов! Поднимаешься на мостик к капитану?", List.of(5, 6), false),
            9, new Question(9, "Ты поднялся на мостик. Кто ты?", List.of(8, 9), false),
            10, new Question(10, "Ты отклонил вызов! Поражение!", List.of(), true),
            11, new Question(11, "Ты не пошел на переговоры! Поражение", List.of(), true),
            12, new Question(12, "Твою ложь разоблачили! Поражение", List.of(), true),
            13, new Question(13, "Ты рассказал правду о себе! Тебя вернули домой", List.of(), true)));

    private AnswerRepository answerRepository = new AnswerRepository(Map.of(2, new Answer("Принять вызов", 2, 4),
            3, new Answer("Отклонить вызов", 3, 10),
            5, new Answer("Подняться на мостик", 5, 9),
            6, new Answer("Отказаться подниматься на мостик", 6, 11),
            9, new Answer("Солгать о себе", 9, 12),
            8, new Answer("Рассказать правду о себе", 8, 13)));

    @Test
    void getQuestionRepositoryTest() throws IOException {
        QuestionRepository expected = appRepository.getQuestionRepository("questionsList.json");
        Assertions.assertAll(() -> Assertions.assertEquals(expected.getQuestionById(4), questionRepository.getQuestionById(4)),
                () -> Assertions.assertEquals(expected.getQuestionById(9), questionRepository.getQuestionById(9)),
                () -> Assertions.assertEquals(expected.getQuestionById(10), questionRepository.getQuestionById(10)),
                () -> Assertions.assertEquals(expected.getQuestionById(11), questionRepository.getQuestionById(11)),
                () -> Assertions.assertEquals(expected.getQuestionById(12), questionRepository.getQuestionById(12)),
                () -> Assertions.assertEquals(expected.getQuestionById(13), questionRepository.getQuestionById(13)));
    }

    @Test
    void getAnswerRepository() throws IOException {
        AnswerRepository expected = appRepository.getAnswerRepository("answersList.json");
        Assertions.assertAll(() -> Assertions.assertEquals(expected.getAnswerById(2), answerRepository.getAnswerById(2)),
                () -> Assertions.assertEquals(expected.getAnswerById(3), answerRepository.getAnswerById(3)),
                () -> Assertions.assertEquals(expected.getAnswerById(5), answerRepository.getAnswerById(5)),
                () -> Assertions.assertEquals(expected.getAnswerById(6), answerRepository.getAnswerById(6)),
                () -> Assertions.assertEquals(expected.getAnswerById(8), answerRepository.getAnswerById(8)),
                () -> Assertions.assertEquals(expected.getAnswerById(9), answerRepository.getAnswerById(9)));
    }
}
