package ru.javarush.november.zaharin.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javarush.november.zaharin.entity.Answer;
import ru.javarush.november.zaharin.entity.Question;

import java.util.List;
import java.util.Map;

class AppFactoryTest {

    private AppFactory appFactory = new AppFactory();

    private QuestionFactory questionFactory = new QuestionFactory(Map.of(1, new Question(1, "Ты потерял память. Принять вызов НЛО?", List.of(2, 3), false),
            4, new Question(4, "Ты принял вызов! Поднимаешься на мостик к капитану?", List.of(5, 6), false),
            9, new Question(9, "Ты поднялся на мостик. Кто ты?", List.of(8, 9), false),
            10, new Question(10, "Ты отклонил вызов! Поражение!", List.of(), true),
            11, new Question(11, "Ты не пошел на переговоры! Поражение", List.of(), true),
            12, new Question(12, "Твою ложь разоблачили! Поражение", List.of(), true),
            13, new Question(13, "Ты рассказал правду о себе! Тебя вернули домой", List.of(), true)));

    private AnswerFactory answerFactory = new AnswerFactory(Map.of(2, new Answer("Принять вызов", 2, 4),
            3, new Answer("Отклонить вызов", 3, 10),
            5, new Answer("Подняться на мостик", 5, 9),
            6, new Answer("Отказаться подниматься на мостик", 6, 11),
            9, new Answer("Солгать о себе", 9, 12),
            8, new Answer("Рассказать правду о себе", 8, 13)));

    @Test
    void getQuestionRepositoryShouldReturnQuestion(){
        QuestionFactory expected = appFactory.getQuestion("questions.json");
        Assertions.assertAll(() -> Assertions.assertEquals(expected.getQuestionById(4), questionFactory.getQuestionById(4)),
                () -> Assertions.assertEquals(expected.getQuestionById(9), questionFactory.getQuestionById(9)),
                () -> Assertions.assertEquals(expected.getQuestionById(10), questionFactory.getQuestionById(10)),
                () -> Assertions.assertEquals(expected.getQuestionById(11), questionFactory.getQuestionById(11)),
                () -> Assertions.assertEquals(expected.getQuestionById(12), questionFactory.getQuestionById(12)),
                () -> Assertions.assertEquals(expected.getQuestionById(13), questionFactory.getQuestionById(13)));
    }

    @Test
    void getAnswerRepositoryShouldReturnAnswer(){
        AnswerFactory expected = appFactory.getAnswer("answers.json");
        Assertions.assertAll(() -> Assertions.assertEquals(expected.getAnswerById(2), answerFactory.getAnswerById(2)),
                () -> Assertions.assertEquals(expected.getAnswerById(3), answerFactory.getAnswerById(3)),
                () -> Assertions.assertEquals(expected.getAnswerById(5), answerFactory.getAnswerById(5)),
                () -> Assertions.assertEquals(expected.getAnswerById(6), answerFactory.getAnswerById(6)),
                () -> Assertions.assertEquals(expected.getAnswerById(8), answerFactory.getAnswerById(8)),
                () -> Assertions.assertEquals(expected.getAnswerById(9), answerFactory.getAnswerById(9)));
    }
}
