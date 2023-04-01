package ru.javarush.november.zaharin.repositories;

import ru.javarush.november.zaharin.entities.Answer;

import java.util.Map;

public class AnswerRepository {

    private final Map<Integer, Answer> idToAnswer;

    public AnswerRepository(Map<Integer, Answer> idToAnswer) {
        this.idToAnswer = idToAnswer;
    }

    public Answer getAnswerById(Integer id) {
        if (id != null && id > 0 && id < Integer.MAX_VALUE) {
            return idToAnswer.get(id);
        } else {
            throw new NullPointerException("Error!");
        }
    }
}
