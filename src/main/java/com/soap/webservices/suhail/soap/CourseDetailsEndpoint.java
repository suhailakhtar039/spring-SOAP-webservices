package com.soap.webservices.suhail.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {
//	method
//	input-getCourseDetailsRequest
//	output-getCourseDetailsResponse
	@PayloadRoot(namespace = "http://in28minutes.com/courses",localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest
	(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response=new GetCourseDetailsResponse();
		CourseDetails courseDetails=new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("SOAP course");
		courseDetails.setDescription("This coming from courseDetailsEndpoint");
		response.setCourseDetails(courseDetails);
		return response;
	}

}
