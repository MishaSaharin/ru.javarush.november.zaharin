package ru.javarush.november.zaharin.factory;

import ru.javarush.november.zaharin.entity.Question;

import java.util.Map;

public class QuestionFactory {
    private final Map<Integer, Question> idToQuestion;

    public QuestionFactory(Map<Integer, Question> idToQuestion) {
        this.idToQuestion = idToQuestion;
    }

    public Question getQuestionById(Integer id) {
        if (id != null && id > 0 && id < Integer.MAX_VALUE) {
            return idToQuestion.get(id);
        } else {
            throw new RuntimeException("Error!");
        }
    }
}
