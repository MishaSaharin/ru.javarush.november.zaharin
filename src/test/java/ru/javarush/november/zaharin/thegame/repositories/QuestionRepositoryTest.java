package ru.javarush.november.zaharin.thegame.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javarush.november.zaharin.thegame.entity.Question;

import java.util.List;
import java.util.Map;
import java.util.Optional;

class QuestionRepositoryTest {

    private QuestionRepository questionRepository = new QuestionRepository(Map.of(1, new Question(1, "Ты потерял память. Принять вызов НЛО?", List.of(2, 3), false),
            4, new Question(4, "Ты принял вызов! Поднимаешься на мостик к капитану?", List.of(5, 6), false),
            9, new Question(9, "Ты поднялся на мостик. Кто ты?", List.of(8, 9), false),
            10, new Question(10, "Ты отклонил вызов! Поражение!", List.of(), true),
            11, new Question(11, "Ты не пошел на переговоры! Поражение", List.of(), true),
            12, new Question(12, "Твою ложь разоблачили! Поражение", List.of(), true),
            13, new Question(13, "Ты рассказал правду о себе! Тебя вернули домой", List.of(), true)));

    @Test
    void getQuestionById() {
        Question expected = new Question(1, "Ты потерял память. Принять вызов НЛО?", List.of(2, 3), false);
        Assertions.assertEquals(expected, questionRepository.getQuestionById(1));
    }

    @Test
    void getQuestionForId() {
        Question expected = new Question(1, "Ты потерял память. Принять вызов НЛО?", List.of(2, 3), false);
        Assertions.assertEquals(Optional.of(expected), questionRepository.getQuestionForId(1));
    }
}
