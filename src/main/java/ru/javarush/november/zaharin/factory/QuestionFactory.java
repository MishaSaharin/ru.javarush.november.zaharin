package ru.javarush.november.zaharin.factory;

import ru.javarush.november.zaharin.entity.Question;

import java.util.Map;
import java.util.Optional;

public class QuestionFactory implements FinderId<Question> {
    private final Map<Integer, Question> idToQuestion;

    public QuestionFactory(Map<Integer, Question> idToQuestion) {
        this.idToQuestion = idToQuestion;
    }

    @Override
    public Question findId(Integer id) {
        Optional<Question> questionOptional = Optional.of(idToQuestion.get(id));
        return questionOptional.get();
    }
}
