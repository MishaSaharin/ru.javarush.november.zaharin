package ru.javarush.november.zaharin.factory;

import ru.javarush.november.zaharin.entity.Answer;

import java.util.Optional;

public interface CreatorAnswerFactory extends CreatorFactory<Answer> {
    @Override
    Optional<Answer> findId();
}
