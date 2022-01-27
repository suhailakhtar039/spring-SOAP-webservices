package com.soap.webservices.suhail.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;
import com.soap.webservices.suhail.soap.bean.Course;
import com.soap.webservices.suhail.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService service;
//	method
//	input-getCourseDetailsRequest
//	output-getCourseDetailsResponse
	@PayloadRoot(namespace = "http://in28minutes.com/courses",localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest
	(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response=new GetCourseDetailsResponse();
		Course course= service.findById(request.getId());
		
		CourseDetails courseDetails=new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		response.setCourseDetails(courseDetails);
		return response;
	}

}
