package ru.javarush.november.zaharin.repositories;

import ru.javarush.november.zaharin.entities.Question;

import java.util.Map;

public class QuestionRepository {
    private final Map<Integer, Question> idToQuestion;

    public QuestionRepository(Map<Integer, Question> idToQuestion) {
        this.idToQuestion = idToQuestion;
    }

    public Question getQuestionById(Integer id) {
        if (id != null && id > 0 && id < Integer.MAX_VALUE) {
            return idToQuestion.get(id);
        } else {
            throw new NullPointerException("Error!");
        }
    }
}
