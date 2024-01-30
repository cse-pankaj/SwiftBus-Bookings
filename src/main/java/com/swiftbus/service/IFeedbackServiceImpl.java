package com.swiftbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiftbus.exception.BusException;
import com.swiftbus.exception.FeedbackException;
import com.swiftbus.exception.UserException;
import com.swiftbus.model.Bus;
import com.swiftbus.model.CurrentUserSession;
import com.swiftbus.model.Feedback;
import com.swiftbus.model.User;
import com.swiftbus.repository.BusDao;
import com.swiftbus.repository.FeedbackDao;
import com.swiftbus.repository.SessionRepo;
import com.swiftbus.repository.UserRepo;

@Service
public class IFeedbackServiceImpl implements IFeedbackService{

	@Autowired
	private FeedbackDao fdao;
	
	@Autowired
	private UserRepo udao;
	
	@Autowired
	private BusDao bdao;
	
	@Autowired
	private SessionRepo srepo;
	
	@Override
	public Feedback addFeedback( Integer busId, Feedback feedback,String key) throws FeedbackException, UserException, BusException {
		CurrentUserSession loggedInUser=srepo.findByUuid(key);
		if(loggedInUser==null) {
			throw new UserException("Please provide a valid key to update user");
		}
		User user = udao.findById(loggedInUser.getUserId()).orElseThrow(() -> new UserException("User with Id " + loggedInUser.getUserId() + " not found"));
		if(user.getUserLoginId()==loggedInUser.getUserId()) {
			Bus b = bdao.findById(busId).orElseThrow(() -> new BusException("Bus with Id " + busId + " not found"));
			
			feedback.setBus(b);
			feedback.setUser(user);
			
			Feedback f = fdao.save(feedback);
			
			return f;
		}else throw new UserException("Invalid User Id");
		
		
		
	}

	@Override
	public Feedback updateFeedback( Feedback feedback,String key) throws FeedbackException, UserException {
		
		CurrentUserSession loggedInUser=srepo.findByUuid(key);
		if(loggedInUser==null) {
			throw new UserException("Please provide a valid key to update user");
		}
		User user = udao.findById(loggedInUser.getUserId()).orElseThrow(() -> new UserException("User with Id " + loggedInUser.getUserId() + " not found"));
		if(user.getUserLoginId()==loggedInUser.getUserId()) {
			Feedback f = fdao.findById(feedback.getFeedbackId()).orElseThrow(() -> new FeedbackException("Feedback with Id " + feedback.getFeedbackId() + " does not exist"));
			
			if (feedback.getComments() != null) f.setComments(feedback.getComments());
			if (feedback.getDriverRating() != null) f.setDriverRating(feedback.getDriverRating());
			if (feedback.getServiceRating() != null) f.setServiceRating(feedback.getServiceRating());
			if (feedback.getOverallRating() != null) f.setOverallRating(feedback.getOverallRating());
			
			Feedback updated = fdao.save(f);
			
			return updated;
		}else throw new UserException("Invalid User Id");
		
	}

	@Override
	public Feedback viewFeedback(Integer feedbackId,String key) throws FeedbackException, UserException {
		CurrentUserSession loggedInUser=srepo.findByUuid(key);
		if(loggedInUser==null) {
			throw new UserException("Please provide a valid key to update user");
		}
		User user = udao.findById(loggedInUser.getUserId()).orElseThrow(() -> new UserException("User with Id " + loggedInUser.getUserId() + " not found"));
		if(user.getUserLoginId()==loggedInUser.getUserId()) {
			Feedback f = fdao.findById(feedbackId).orElseThrow(() -> new FeedbackException("Feedback with Id " + feedbackId + " does not exist"));
			return f;
		}else throw new UserException("Invalid User Id");
		
	}

	@Override
	public List<Feedback> viewAllFeedback(String key) throws FeedbackException, UserException {
		CurrentUserSession loggedInUser=srepo.findByUuid(key);
		if(loggedInUser==null) {
			throw new UserException("Please provide a valid key to update user");
		}
		User user = udao.findById(loggedInUser.getUserId()).orElseThrow(() -> new UserException("User with Id " + loggedInUser.getUserId() + " not found"));
		if(user.getUserLoginId()==loggedInUser.getUserId()) {
			List<Feedback> f= fdao.findAll();
			
			if (!f.isEmpty()) return f;
			else throw new FeedbackException("Feedback not found");
		}else throw new UserException("Invalid User Id");
		
	}

	
	
	
}
