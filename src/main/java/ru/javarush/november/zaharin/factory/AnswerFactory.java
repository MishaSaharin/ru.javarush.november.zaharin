package ru.javarush.november.zaharin.factory;

import ru.javarush.november.zaharin.entity.Answer;

import java.util.Map;

public class AnswerFactory {

    private final Map<Integer, Answer> idToAnswer;

    public AnswerFactory(Map<Integer, Answer> idToAnswer) {
        this.idToAnswer = idToAnswer;
    }

    public Answer getAnswerById(Integer id) {
        if (id != null && id > 0 && id < Integer.MAX_VALUE) {
            return idToAnswer.get(id);
        } else {
            throw new RuntimeException("Error!");
        }
    }
}
