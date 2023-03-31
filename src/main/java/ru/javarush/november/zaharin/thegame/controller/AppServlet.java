package ru.javarush.november.zaharin.thegame.controller;

import ru.javarush.november.zaharin.thegame.entity.Answer;
import ru.javarush.november.zaharin.thegame.entity.Question;
import ru.javarush.november.zaharin.thegame.repositories.AnswerRepository;
import ru.javarush.november.zaharin.thegame.repositories.AppRepository;
import ru.javarush.november.zaharin.thegame.repositories.QuestionRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "appServlet", value = "/appServlet")
public class AppServlet extends HttpServlet {
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;
    AppRepository appRepository;

    @Override
    public void init() {
        appRepository = new AppRepository();
        questionRepository = appRepository.getQuestionRepository("questionsList.json");
        answerRepository = appRepository.getAnswerRepository("answersList.json");

        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        Integer nextQuestionId = 1;

        if ((request.getParameter("nextQuestionId") != null)) {
            try {
                nextQuestionId = Integer.parseInt(request.getParameter("nextQuestionId"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else nextQuestionId = 1;

        Question question = questionRepository.getQuestionById(nextQuestionId);
        Integer questionId = question.getId();
        String questionText = question.getQuestionText();
        boolean isLast = question.isLast();
        List<Integer> answersId = question.getAnswersIdList();
        List<Answer> answers = new ArrayList<>();
        for (Integer answerId : answersId) {
            answers.add(answerRepository.getAnswerById(answerId));
        }

        request.setAttribute("questionId", questionId);
        request.setAttribute("questionText", questionText);
        request.setAttribute("answers", answers);
        request.setAttribute("isLast", isLast);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/quest.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        String name = request.getParameter("name");

        if (name != null) {
            session.setAttribute("name", name);
        } else {
            try {
                response.sendRedirect("quest.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        doGet(request, response);
    }
}
