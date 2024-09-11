package com.cisco.funfit;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addparticipant")
public class ParticipantServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/participant.jsp";
    private static String LIST_PARTICIPANT = "/listParticipant.jsp";
    
    private ParticipantDao dao;
    
    public ParticipantServlet()
    {
    	super();
    	dao = new ParticipantDao();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		String forward = " ";
		String action = req.getParameter("action");
		
		if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(req.getParameter("id"));
            dao.deleteParticipant(id);
            forward = LIST_PARTICIPANT;
            req.setAttribute("participant", dao.getAllParticipant());    
        } 
		else if (action.equalsIgnoreCase("edit"))
		{
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(req.getParameter("id"));
            Participant participant = dao.getParticipantById(id);
            req.setAttribute("partici", participant);
        } 
		else if (action.equalsIgnoreCase("listParticipant"))
		{
            forward = LIST_PARTICIPANT;
            req.setAttribute("users", dao.getAllParticipant());
        } 
		else 
		{
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
	}
        
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    Participant participant = new Participant();

	    participant.setName(req.getParameter("participantname"));
	    participant.setAge(Integer.parseInt(req.getParameter("participantage"))); 
	    participant.setHeight(Integer.parseInt(req.getParameter("participantHeight"))); 
	    participant.setWeight(Integer.parseInt(req.getParameter("participantweight"))); 
	    participant.setPhonenumber(Integer.parseInt(req.getParameter("participantnumber"))); 
	    participant.setEmail(req.getParameter("participantemail"));
	    participant.setTime(Time.valueOf(req.getParameter("participanttime"))); 
	    participant.setJdate(req.getParameter("participantDate"));

	   
	    String id = req.getParameter("id");
	    if (id == null || id.isEmpty()) 
	    {
	        dao.addParticipant(participant);
	    } 
	    else 
	    {
	        participant.setId(Integer.parseInt(id));
	        dao.updateParticipant(participant);
	    }

	    // Assuming the following block is for forwarding to a page, so I've kept it as it is
	    RequestDispatcher view = req.getRequestDispatcher(LIST_PARTICIPANT);
	    req.setAttribute("users", dao.getAllParticipant());
	    view.forward(req, resp);
	}

    
    
}
