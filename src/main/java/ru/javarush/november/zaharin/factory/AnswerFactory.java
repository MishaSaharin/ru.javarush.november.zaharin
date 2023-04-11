package ru.javarush.november.zaharin.factory;

import ru.javarush.november.zaharin.entity.Answer;

import java.util.Map;
import java.util.Optional;

public class AnswerFactory implements FinderId<Answer> {

    private final Map<Integer, Answer> idToAnswer;

    public AnswerFactory(Map<Integer, Answer> idToAnswer) {
        this.idToAnswer = idToAnswer;
    }

    @Override
    public Answer findId(Integer id) {
        Optional<Answer> answerOptional = Optional.of(idToAnswer.get(id));
        return answerOptional.get();
    }
}
