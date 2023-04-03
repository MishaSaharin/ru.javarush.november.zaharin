package ru.javarush.november.zaharin.factory;

import ru.javarush.november.zaharin.entity.Question;

import java.util.Map;
import java.util.Optional;

public class QuestionFactory {
    private final Map<Integer, Question> idToQuestion;

    public QuestionFactory(Map<Integer, Question> idToQuestion) {
        this.idToQuestion = idToQuestion;
    }

    public Question getQuestionById(Integer id) {
        Optional<Question> questionOptional = Optional.ofNullable(idToQuestion.get(id));
        return questionOptional.get();
    }
}
