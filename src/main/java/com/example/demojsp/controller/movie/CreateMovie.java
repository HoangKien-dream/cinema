package com.example.demojsp.controller.movie;

import com.example.demojsp.dao.CategoryDao;
import com.example.demojsp.dao.MovieDao;
import com.example.demojsp.model.Category;
import com.example.demojsp.model.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CreateMovie", value = "/CreateMovie")
public class CreateMovie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("create-movie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Movie movie = new Movie();
        movie.setName(request.getParameter("name"));
        movie.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
        movie.setThumbnail(request.getParameter("thumbnail"));
        movie.setDescription(request.getParameter("description"));
        movie.setStatus(1);
        MovieDao movieDao = new MovieDao();
        movieDao.save(movie);
    }
}
