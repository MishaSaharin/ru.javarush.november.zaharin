package ru.javarush.november.zaharin.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class QuestionTest {
    Question questionTest = new Question(1,
            "Ты потерял память. Принять вызов НЛО?",
            List.of(2, 3),
            false);

    @Test
    void setQuestionText() {
        questionTest.setQuestionText("test text");
        Assertions.assertEquals("test text", questionTest.getQuestionText());
    }

    @Test
    void getQuestionText() {
        Assertions.assertEquals("Ты потерял память. Принять вызов НЛО?", questionTest.getQuestionText());
    }

    @Test
    void getId() {
        Assertions.assertEquals(1, questionTest.getId());
    }

    @Test
    void setId() {
        questionTest.setId(11);
        Assertions.assertEquals(11, questionTest.getId());
    }

    @Test
    void getAnswersIdList() {
        Assertions.assertEquals(List.of(2, 3), (questionTest.getAnswersIdList()));
    }

    @Test
    void setAnswersIdList() {
        questionTest.setAnswersIdList(List.of(4, 5));
        Assertions.assertEquals(List.of(4, 5), (questionTest.getAnswersIdList()));
    }

    @Test
    void isLast() {
        Assertions.assertFalse(questionTest.isLast());
    }

    @Test
    void setLast() {
        questionTest.setLast(true);
        Assertions.assertTrue(questionTest.isLast());
    }

    @Test
    void ifQuestionIsLast() {
        boolean originalValue = questionTest.isLast();
        questionTest.setLast(true);
        Assertions.assertTrue(questionTest.isLast());
        questionTest.setLast(originalValue);
    }
}
