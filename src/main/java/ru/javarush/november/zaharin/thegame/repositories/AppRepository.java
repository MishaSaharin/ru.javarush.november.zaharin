package ru.javarush.november.zaharin.thegame.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.november.zaharin.thegame.services.MapperByJson;

public class AppRepository {

    private final ObjectMapper mapper = new ObjectMapper();
    private final MapperByJson mapperByJson = new MapperByJson();

    public QuestionRepository getQuestionRepository(String file) {
        return new QuestionRepository(mapperByJson.parseQuestionMap
                (AppRepository.class.getClassLoader().getResourceAsStream(file), mapper));
    }

    public AnswerRepository getAnswerRepository(String file) {
        return new AnswerRepository(mapperByJson.parseAnswerMap
                (AppRepository.class.getClassLoader().getResourceAsStream(file), mapper));
    }
}
