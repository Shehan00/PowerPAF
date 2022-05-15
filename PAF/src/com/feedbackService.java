package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Feedback;

@Path("/Feedback")
public class feedbackService {
	Feedback FeedbacktObj = new Feedback();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFeedback() {
		return feedbackObj.readFeedback();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertFeedback(@FormParam("Name") String FeedbackName,
			@FormParam("Email") String FeedbackEmail, @FormParam("Feedback_Subject") String FeedbackSubject,
			@FormParam("FeedbackSubject") String FeedbackMessage) {
		String output = feedbackObj.insertfeedback(FeedbackName, FeedbackEmail, FeedbackSubject, FeedbackMessage);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateFeedback(String FeedbacktData) {
		// Convert the input string to a JSON object
		JsonObject productObject = new JsonParser().parse(FeedbacktData).getAsJsonObject();
		// Read the values from the JSON object
		String FeedbackId = productObject.get("Id").getAsString();
		String FeedbackName = productObject.get("Name").getAsString();
		String FeedbackEmai = productObject.get("Email").getAsString();
		String FeedbackSubject = productObject.get("Feedback_Subject").getAsString();
		String FeedbackMessage = productObject.get("Feedback_Message").getAsString();
		String output = feedbackObj.updatefeedback(FeedbackId, FeedbackName, FeedbackEmai, FeedbackSubject,
				FeedbackMessage);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteFeedback(String FeedbackData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(FeedbackData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String FeedbackId = doc.select("FeedbackId").text();
		String output = feedbackObj.deleteFeedback(FeedbackId);
		return output;
	}
}
