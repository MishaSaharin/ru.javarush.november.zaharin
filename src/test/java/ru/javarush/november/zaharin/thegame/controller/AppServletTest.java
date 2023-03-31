package ru.javarush.november.zaharin.thegame.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

class AppServletTest {
    private AppServlet appServletMock = Mockito.mock(AppServlet.class);
    private HttpServletRequest requestMock = Mockito.mock(HttpServletRequest.class);
    private HttpServletResponse responseMock = Mockito.mock(HttpServletResponse.class);
    private ServletConfig servletConfigMock = Mockito.mock(ServletConfig.class);
    private ServletContext servletContextMock = Mockito.mock(ServletContext.class);
    private RequestDispatcher requestDispatcherMock = Mockito.mock(RequestDispatcher.class);
    private HttpSession sessionMock = Mockito.mock(HttpSession.class);

    @Test
    void init() {
        Mockito
                .when(appServletMock.getInitParameter("isLast"))
                .thenReturn("true");
        Mockito
                .doNothing()
                .when(appServletMock)
                .init();
        Mockito
                .doThrow(new ServletException())
                .when(appServletMock)
                .init();
    }

    @Test
    void doGet() throws ServletException, IOException {
        Mockito
                .when(servletConfigMock.getServletContext())
                .thenReturn(servletContextMock);

        Mockito
                .when(requestMock.getParameter("nextQuestionId"))
                .thenReturn("true");
        Mockito
                .doNothing()
                .when(appServletMock)
                .doGet(requestMock, responseMock);

        Mockito
                .when(appServletMock.getServletContext())
                .thenReturn(servletContextMock);

        Mockito
                .when(servletContextMock.getRequestDispatcher(Mockito.anyString()))
                .thenReturn(requestDispatcherMock);

        Mockito.doNothing()
                .when(requestDispatcherMock)
                .forward(requestMock, responseMock);
        Mockito
                .when(servletContextMock.getRealPath("/WEB-INF/quest.jsp"))
                .thenReturn("/WEB-INF/quest.jsp");
    }

    @Test
    void doPost() {
        Mockito
                .when(requestMock.getSession())
                .thenReturn(sessionMock);

        Mockito
                .when(requestMock.getParameter("name"))
                .thenReturn("name");

        Mockito
                .when(sessionMock.getAttribute("currentStep"))
                .thenReturn(true);
        Mockito
                .when(responseMock.containsHeader("name"))
                .thenReturn(true);

        Mockito
                .doNothing()
                .when(this.appServletMock)
                .doPost(requestMock, responseMock);
    }
}
