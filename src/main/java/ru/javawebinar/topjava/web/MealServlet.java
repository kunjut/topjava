package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.service.MealServiceHardCodedImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(MealServlet.class);
    private final MealServiceHardCodedImpl mealService;

    public MealServlet() {
        mealService = new MealServiceHardCodedImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        request.setAttribute("mealsTo", mealService.findAll());
        log.info("Список значений установлен в аттрибуты");

        request
                .getRequestDispatcher("/meals.jsp")
                .forward(request, response);
    }
}
