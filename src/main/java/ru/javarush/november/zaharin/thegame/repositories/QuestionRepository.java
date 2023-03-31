package ru.javarush.november.zaharin.thegame.repositories;

import ru.javarush.november.zaharin.thegame.entity.Question;

import java.util.Map;
import java.util.Optional;

public class QuestionRepository {
    private final Map<Integer, Question> idToQuestion;

    public QuestionRepository(Map<Integer, Question> idToQuestion) {
        this.idToQuestion = idToQuestion;
    }

    public Question getQuestionById(Integer id) {
        if (id != null && id > 0 && id < Byte.MAX_VALUE) {
            return idToQuestion.get(id);
        } else {
            throw new NullPointerException("you are missing the object");
        }
    }

    public Optional<Question> getQuestionForId(Integer integer) {
        return Optional.ofNullable(idToQuestion.get(integer));
    }
}
