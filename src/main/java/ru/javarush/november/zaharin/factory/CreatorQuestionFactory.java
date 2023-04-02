package ru.javarush.november.zaharin.factory;

import ru.javarush.november.zaharin.entity.Question;

import java.util.Optional;

public interface CreatorQuestionFactory extends CreatorFactory<Question>{
    @Override
    Optional<Question> findId();
}
