package ru.javarush.november.zaharin.factory;

import ru.javarush.november.zaharin.entity.Answer;

import java.util.Map;
import java.util.Optional;

public class AnswerFactory {

    private final Map<Integer, Answer> idToAnswer;

    public AnswerFactory(Map<Integer, Answer> idToAnswer) {
        this.idToAnswer = idToAnswer;
    }

    public Answer getAnswerById(Integer id) {
        Optional<Answer> answerOptional = Optional.ofNullable(idToAnswer.get(id));
        return answerOptional.get();
    }
}
