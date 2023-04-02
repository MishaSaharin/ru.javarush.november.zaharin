package ru.javarush.november.zaharin.factory;

import java.util.Optional;

public interface CreatorFactory<E>{
    Optional<E> findId();
}
