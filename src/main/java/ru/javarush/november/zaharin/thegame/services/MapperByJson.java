package ru.javarush.november.zaharin.thegame.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.november.zaharin.thegame.entity.Answer;
import ru.javarush.november.zaharin.thegame.entity.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MapperByJson {

    public Map<Integer, Question> parseQuestionMap(InputStream inputStream, ObjectMapper mapper) {
        try {
            return new HashMap<>(mapper.readValue(inputStream,
                    new TypeReference<Map<Integer, Question>>() {
                    }));
        } catch (IOException | IllegalArgumentException e) {
            throw new IllegalStateException("It doesn't work like that! Pay attention!");
        }
    }

    public Map<Integer, Answer> parseAnswerMap(InputStream inputStream, ObjectMapper mapper) {
        try {
            return new HashMap<>(mapper.readValue(inputStream,
                    new TypeReference<Map<Integer, Answer>>() {
                    }));
        } catch (IOException | IllegalArgumentException e) {
            throw new IllegalStateException("It doesn't work like that! Pay attention!");
        }
    }
}
