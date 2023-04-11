package ru.javarush.november.zaharin.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.november.zaharin.service.MapperByJson;

public class AppFactory {

    private ObjectMapper mapper;
    private MapperByJson mapperByJson;

    public AppFactory() {
        this.mapper = new ObjectMapper();
        this.mapperByJson = new MapperByJson();
    }

    public QuestionFactory getQuestion(String file) {
        return new QuestionFactory(mapperByJson.parseQuestionMap
                (AppFactory.class.getClassLoader().getResourceAsStream(file), mapper));
    }

    public AnswerFactory getAnswer(String file) {
        return new AnswerFactory(mapperByJson.parseAnswerMap
                (AppFactory.class.getClassLoader().getResourceAsStream(file), mapper));
    }
}
