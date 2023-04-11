package ru.javarush.november.zaharin.factory;

public interface FinderId<E> {
    E findId(Integer id);
}
