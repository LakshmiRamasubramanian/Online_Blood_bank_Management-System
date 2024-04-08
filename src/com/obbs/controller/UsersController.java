package com.obbs.controller;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.obbs.service.UsersService;
import com.obbs.exception.ApplicationException;
import com.obbs.model.BloodGroupPojo;

import com.obbs.model.PostBloodRequirementPojo;

import com.obbs.model.SlotBookingPojo;
import com.obbs.model.StatesPojo;
import com.obbs.model.UsersPojo;

@Controller // Used to Specify the Controller
public class UsersController {
	@Autowired
	UsersService usersService;
	public static final Logger LOGGER = Logger.getLogger("OBBS");

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	// This mehtod is used to register the User
	public ModelAndView register(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		try {

			List<StatesPojo> allStates = usersService.getAllStates();
			List<BloodGroupPojo> allBloodGroups = usersService.getAllBloodGroups();
			mav = new ModelAndView("Register");

			map.addAttribute("registerUsers", new UsersPojo());
			mav.addObject("allStates", allStates);// add all the states in allstates variable using addObject method
			mav.addObject("allBloodGroups", allBloodGroups);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
			mav.addObject("message", e.getMessage());
		}
		return mav;
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	// Used for Returning the User Login Page
	public ModelAndView loginUser(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("LoginUser");
	}

	@RequestMapping(value = "/inbox", method = RequestMethod.GET)
	// Used for Returning the User Inbox Page
	public ModelAndView inbox(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession(false);
		List<SlotBookingPojo> details = new ArrayList<SlotBookingPojo>();

		try {
			if (session.getAttribute("username") != null) {
				String userMailId = (String) session.getAttribute("username");
				details = usersService.inboxCheck(userMailId);
				if (!details.isEmpty()) {
					mav = new ModelAndView("Inbox");
					mav.addObject("details", details);
				} else {
					mav = new ModelAndView("NoInbox");

				}
			} else {
				mav = new ModelAndView("Home");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
			mav.addObject("message", e.getMessage());
		}
		return mav;
	}

	@RequestMapping(value = "/searchDonor", method = RequestMethod.GET)
	// Used to diplay the Search Donor Page for Users.
	public ModelAndView searchDonor(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		ModelAndView mav = null;

		try

		{
			if (session.getAttribute("username") != null) {
				List<StatesPojo> allStates = usersService.getAllStates();
				List<BloodGroupPojo> allBloodGroups = usersService.getAllBloodGroups();
				mav = new ModelAndView("SearchDonor");
				mav.addObject("allStates", allStates);
				mav.addObject("allBloodGroups", allBloodGroups);
			} else {
				mav = new ModelAndView("Home");
			}
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
			mav.addObject("message", e.getMessage());
		}

		return mav;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	// Used to Register the User with his/her Details.
	public ModelAndView addUsers(@Valid @ModelAttribute("registerUsers") UsersPojo usersPojo, BindingResult br)
			throws ApplicationException {

		int id;
		int mailCheck;
		int check = 1;
		int checkMail = 3;
		ModelAndView mav = null;
		if (!br.hasErrors()) {
			try {
				mailCheck = usersService.mailCheckUser(usersPojo);
				if (mailCheck != checkMail)// This Condition is Used for validate the mail Id ...
				{
					id = usersService.registerUser(usersPojo);

					if (id == check) {
						mav = new ModelAndView("LoginUser");// If the User Registered successfully then he/she can Login
															// through the Login Page.
						mav.addObject("message", "Successfully Registered  you can login now ");

					}

				} else// Incase user registered with already existed mail Id in database then the page
						// is highlighted with message.
				{
					List<StatesPojo> allStates = usersService.getAllStates();
					List<BloodGroupPojo> allBloodGroups = usersService.getAllBloodGroups();
					mav = new ModelAndView("RegisterWithNewMailId");
					mav.addObject("allStates", allStates);
					mav.addObject("allBloodGroups", allBloodGroups);
					mav.addObject("usersPojo", usersPojo);
				}
			} catch (ApplicationException e) {
				LOGGER.error(e.getMessage());
				mav = new ModelAndView("Error");
				mav.addObject("message", e.getMessage());

			}
		} else {
			List<StatesPojo> allStates = usersService.getAllStates();
			List<BloodGroupPojo> allBloodGroups = usersService.getAllBloodGroups();
			mav = new ModelAndView("Register");
			mav.addObject("allStates", allStates);
			mav.addObject("allBloodGroups", allBloodGroups);
		}
		return mav;
	}

	@RequestMapping(value = "/recipientLogin", method = RequestMethod.GET)
	// This Method is used to Validate the Users Login
	public String login(@ModelAttribute("command") UsersPojo usersPojo, BindingResult result, Map model,
			HttpServletRequest request, HttpServletResponse response) {
		int login;
		int check = 1;
		String redirect = null;
		try {
			login = usersService.loginUser(usersPojo);
			if (login == check) {
				HttpSession session = request.getSession();
				session.setAttribute("username", usersPojo.getEmail());

				redirect = "redirect:/userSessionCheck";
			} else {
				redirect = "redirect:/wrongLogin";
			}
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			model.put("message", e.getMessage());
			redirect = "Error";

		}

		return redirect;
	}

	@RequestMapping(value = "/wrongLogin", method = RequestMethod.GET)
	// In case user Failed to Provide the valid Credential then the Page is
	// displayed with alert message.
	public ModelAndView wrongLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		mav = new ModelAndView("LoginUser");
		mav.addObject("message", "Invalid credentials,Try again !");
		return mav;
	}

	@RequestMapping(value = "/userSessionCheck", method = RequestMethod.GET)

	public ModelAndView sessionCheck(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		HttpSession session = request.getSession(false);

		if (session.getAttribute("username") != null) {
			try {
				List<StatesPojo> allStates = usersService.getAllStates();
				List<BloodGroupPojo> allBloodGroups;
				allBloodGroups = usersService.getAllBloodGroups();
				mav = new ModelAndView("SearchDonor");
				mav.addObject("allStates", allStates);
				mav.addObject("allBloodGroups", allBloodGroups);
			} catch (ApplicationException e) {
				LOGGER.error(e.getMessage());
				mav = new ModelAndView("Error");
				mav.addObject("message", e.getMessage());
			}
		} else {
			mav = new ModelAndView("Home");
		}
		return mav;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	// This method is Used to Close the session by the User a Logout and Display the
	// Home page after Login.
	public ModelAndView logoutPage(@RequestParam(value = "logout", required = false) String logout,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		if (logout != null) {
			HttpSession session = request.getSession(false);
			session.invalidate();
			model.addObject("message", "Logged out successfully.");
		}
		return new ModelAndView("Home");
	}

	@RequestMapping("/requirementFetch")
	// This is used to Display the Recipient details in home Page.
	public ModelAndView displayBloodRequirements(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		List<PostBloodRequirementPojo> requirementList = new ArrayList<PostBloodRequirementPojo>();
		try {
			requirementList = usersService.displayRequirements();
			mav = new ModelAndView("BloodRequired");
			if (!requirementList.isEmpty()) {
				mav.addObject("requirementList", requirementList);
			} else {
				mav = new ModelAndView("NoRecipient");
				mav.addObject("message", "No record found ");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
			mav.addObject("message", e.getMessage());
		}
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	// This method is used to Display the Home Page after invalidate the Sessionss
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("Home");
	}
}
