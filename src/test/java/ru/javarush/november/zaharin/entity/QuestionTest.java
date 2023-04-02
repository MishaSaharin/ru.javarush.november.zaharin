package ru.javarush.november.zaharin.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class QuestionTest {
    Question questionTest = new Question(1,
            "Ты потерял память. Принять вызов НЛО?",
            List.of(2, 3),
            false);

    @Test
    void setQuestionTextShouldReturnString() {
        questionTest.setQuestionText("test text");
        Assertions.assertEquals("test text", questionTest.getQuestionText());
    }

    @Test
    void getQuestionTextShouldReturnString() {
        Assertions.assertEquals("Ты потерял память. Принять вызов НЛО?", questionTest.getQuestionText());
    }

    @Test
    void getIdShouldReturnInteger() {
        Assertions.assertEquals(1, questionTest.getId());
    }

    @Test
    void setIdShouldReturnInteger() {
        questionTest.setId(11);
        Assertions.assertEquals(11, questionTest.getId());
    }

    @Test
    void getAnswersIdListShouldReturnInteger() {
        Assertions.assertEquals(List.of(2, 3), (questionTest.getAnswersIdList()));
    }

    @Test
    void setAnswersIdListShouldReturnInteger() {
        questionTest.setAnswersIdList(List.of(4, 5));
        Assertions.assertEquals(List.of(4, 5), (questionTest.getAnswersIdList()));
    }

    @Test
    void isLastShouldReturnBoolean() {
        Assertions.assertFalse(questionTest.isLast());
    }

    @Test
    void setLastShouldReturnBoolean() {
        questionTest.setLast(true);
        Assertions.assertTrue(questionTest.isLast());
    }

    @Test
    void ifQuestionIsLastShouldReturnBoolean() {
        boolean originalValue = questionTest.isLast();
        questionTest.setLast(true);
        Assertions.assertTrue(questionTest.isLast());
        questionTest.setLast(originalValue);
    }
}
