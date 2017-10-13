package be.steformations.sivananda.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.steformations.java_xml.shakespeare.MonologueSearcher;
import be.steformations.pc.xml.shakespeare.MonologueSearcherDom;
import be.steformations.sivananda.client.event.search.SearchParams;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/json/service")
public class ShakespeareService extends HttpServlet {

	private MonologueSearcher searcher;
	private ObjectMapper mapper;

	@Override
	public void init() throws ServletException {
		System.out.println("ShakespeareService.init()");
		super.init();
		this.searcher = new MonologueSearcherDom();
		this.mapper = new ObjectMapper();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ShakespeareService.doPost()");
		
		SearchParams params = this.mapper.readerFor(SearchParams.class).readValue(req.getInputStream());
		String monologue = this.searcher.getMonologue(params.getPlay(), params.getSpeaker(), params.getStart());
		
		System.out.println(monologue);
		resp.setContentType("text/plain");
		
		if (monologue != null) {
			resp.getWriter().write(monologue);
		} else {
			resp.getWriter().write("pas de monologue correspondant");
		}
		
	}
	
	
	
	
	
}
