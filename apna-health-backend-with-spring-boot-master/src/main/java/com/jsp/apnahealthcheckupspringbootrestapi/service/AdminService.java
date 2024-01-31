package com.jsp.apnahealthcheckupspringbootrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.apnahealthcheckupspringbootrestapi.dao.AdminDao;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Admin;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;
import com.jsp.apnahealthcheckupspringbootrestapi.verification.EmailPasswardVerification;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {

	@Autowired
	private AdminDao dao;

	@Autowired
	private ResponseStructure<Admin> responseStructure;

	@Autowired
	private ResponseStructure<String> logout;

	@Autowired
	private HttpSession httpSession;

	public ResponseStructure<Admin> saveAdminService(Admin admin) {
		String Email = EmailPasswardVerification.verifyEmail(admin.getAdminEmail());
		String Passward = EmailPasswardVerification.verifyPassward(admin.getAdminPassword());

		if (Email != null) {
			if (Passward != null) {
				dao.saveAdminDao(admin);
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setStatusMessage("admin got register successfully");
				responseStructure.setStatusData(admin);
			} else {
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setStatusMessage("passward should be less than 9 character");
				responseStructure.setStatusData(admin);
			}
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("Email should be less than 9 character");
			responseStructure.setStatusData(admin);
		}
		return responseStructure;
	}

	public ResponseStructure<Admin> loginAdminService(String adminEmail, String adminPassward) {
		Admin admin = dao.loginAdminDao(adminEmail);

		if (admin != null) {
			if (admin.getAdminPassword().equals(adminPassward)) {
				httpSession.setAttribute("adminEmail", adminEmail);
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setStatusMessage("admin login successfully");
				responseStructure.setStatusData(admin);
			} else {
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setStatusMessage("please enter correct passward");
				responseStructure.setStatusData(admin);
			}
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("please enter correct email");
			responseStructure.setStatusData(admin);
		}
		return responseStructure;
	}

	public ResponseStructure<String> adminLogoutService() {
		if (httpSession.getAttribute("adminEmail") != null) {
			httpSession.invalidate();
			logout.setStatusCode(HttpStatus.OK.value());
			logout.setStatusMessage("Admin  logout successfully");
			logout.setStatusData("session------is-----expired------now");
		}
		return logout;
	}

	public List<Admin> getAllAdminDataService() {

		return dao.getAllAdminDataDao();
	}
}
