package ru.javarush.november.zaharin.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.november.zaharin.service.MapperByJson;

public class AppFactory {

    private final ObjectMapper mapper = new ObjectMapper();
    private final MapperByJson mapperByJson = new MapperByJson();

    public QuestionFactory getQuestionRepository(String file) {
        return new QuestionFactory(mapperByJson.parseQuestionMap
                (AppFactory.class.getClassLoader().getResourceAsStream(file), mapper));
    }

    public AnswerFactory getAnswerRepository(String file) {
        return new AnswerFactory(mapperByJson.parseAnswerMap
                (AppFactory.class.getClassLoader().getResourceAsStream(file), mapper));
    }
}
