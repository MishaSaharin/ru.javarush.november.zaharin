package ru.javarush.november.zaharin.controller;

import ru.javarush.november.zaharin.entity.Question;
import ru.javarush.november.zaharin.entity.Answer;
import ru.javarush.november.zaharin.factory.AnswerFactory;
import ru.javarush.november.zaharin.factory.AppFactory;
import ru.javarush.november.zaharin.factory.QuestionFactory;

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

@WebServlet(name = "appServlet", value = "/app")
public class AppServlet extends HttpServlet {
    QuestionFactory questionFactory;
    AnswerFactory answerFactory;
    AppFactory appFactory;

    @Override
    public void init() {
        appFactory = new AppFactory();
        questionFactory = appFactory.getQuestionRepository("questionsList.json");
        answerFactory = appFactory.getAnswerRepository("answersList.json");

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

        Question question = questionFactory.getQuestionById(nextQuestionId);
        Integer questionId = question.getId();
        String questionText = question.getQuestionText();
        boolean isLast = question.isLast();
        List<Integer> answersId = question.getAnswersIdList();
        List<Answer> answers = new ArrayList<>();
        for (Integer answerId : answersId) {
            answers.add(answerFactory.getAnswerById(answerId));
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
