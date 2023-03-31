package ru.javarush.november.zaharin.thegame.repositories;

import ru.javarush.november.zaharin.thegame.entity.Answer;

import java.util.Map;
import java.util.Optional;

public class AnswerRepository {

    private final Map<Integer, Answer> idToAnswer;

    public AnswerRepository(Map<Integer, Answer> idToAnswer) {
        this.idToAnswer = idToAnswer;
    }

    public Answer getAnswerById(Integer id) {
        if (id != null && id > 0 && id < Byte.MAX_VALUE) {
            return idToAnswer.get(id);
        } else {
            throw new NumberFormatException("you are missing the object");
        }
    }

    public Optional<Answer> getAnswerForId(Integer integer) {
        return Optional.ofNullable(idToAnswer.get(integer));
    }
}
