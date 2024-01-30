package com.swiftbus.service;

import java.util.List;

import com.swiftbus.exception.BusException;
import com.swiftbus.exception.FeedbackException;
import com.swiftbus.exception.UserException;
import com.swiftbus.model.Feedback;

public interface IFeedbackService {

	public Feedback addFeedback( Integer busId, Feedback feedback,String key) throws FeedbackException, UserException, BusException;
	
	public Feedback updateFeedback(Feedback feedback,String key) throws FeedbackException,UserException;
	
	public Feedback viewFeedback(Integer feedbackId,String key) throws FeedbackException,UserException;
	
	public List<Feedback> viewAllFeedback(String key) throws FeedbackException,UserException;
}
