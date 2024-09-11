package com.cisco.funfit;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addbatch")
public class BatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/batch.jsp";
    private static final String LIST_BATCH = "/listBatch.jsp";

    private BatchDao dao;

    public BatchServlet() {
        super();
        dao = new BatchDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = " ";
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.deleteBatch(id);
            forward = LIST_BATCH;
            req.setAttribute("batches", dao.getAllBatches());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(req.getParameter("id"));
            Batch batch = dao.getBatchById(id);
            req.setAttribute("batch", batch);
        } else if (action.equalsIgnoreCase("listBatch")) {
            forward = LIST_BATCH;
            req.setAttribute("batches", dao.getAllBatches());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Batch batch = new Batch();

        batch.setName(req.getParameter("batchname"));
        batch.setTime(Time.valueOf(req.getParameter("batchtime")));

        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            dao.addBatch(batch);
        } else {
            batch.setId(Integer.parseInt(id));
            dao.updateBatch(batch);
        }

        RequestDispatcher view = req.getRequestDispatcher(LIST_BATCH);
        req.setAttribute("batches", dao.getAllBatches());
        view.forward(req, resp);
    }
}

