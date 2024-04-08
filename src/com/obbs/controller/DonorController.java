package com.obbs.controller;

import java.util.ArrayList;

import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.obbs.exception.ApplicationException;
import com.obbs.model.BloodGroupPojo;

import com.obbs.model.DonorPojo;
import com.obbs.model.FeedbackPojo;
import com.obbs.model.HospitalPojo;
import com.obbs.model.PostBloodRequirementPojo;
import com.obbs.model.SlotBookingPojo;
import com.obbs.model.StatesPojo;
import com.obbs.service.DonorService;
import com.obbs.service.RecipientService;
import com.obbs.service.UsersService;

@Controller // This annotation is used to define the Controller
public class DonorController {
	@Autowired
	DonorService donorService;// Creating Object for a service class using Auto Wired Annotation
	@Autowired
	UsersService usersService;
	@Autowired // Creating Object for a service class using Auto Wired Annotation
	RecipientService recipientService;
	public static final Logger LOGGER = Logger.getLogger("OBBS");

	@RequestMapping(value = "/donorLogin", method = RequestMethod.GET) // In this Line We map the Html Page to this
																		// Controller

	// This class is used for Donor Login Validation

	public String donorLogin(@ModelAttribute("command") DonorPojo donorPojo, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		int donorId;
		ModelAndView mav = new ModelAndView();// Creating Object For ModelAndViewClass
		String url = null;

		try {
			donorId = donorService.donorLogin(donorPojo);

			if (donorId != 0) {
				HttpSession session = request.getSession();
				session.setAttribute("donorId", donorId);
				session.setAttribute("donorName", donorPojo.getDonorName());
				session.setAttribute("donorBloodGroup", donorPojo.getBloodGroup());
				session.setAttribute("contactNumber", donorPojo.getContactNumber());
				url = "redirect:/donorSessionCheck";
			} else {
				url = "redirect:/wrongDonorLogin";
			}
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
		}
		return url;
	}

	@RequestMapping(value = "/wrongDonorLogin", method = RequestMethod.GET)
	// In case User fail to Provide the Valid credential this method is used for
	// further action.
	public ModelAndView wrongDonorLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		mav = new ModelAndView("DonorLogin");
		mav.addObject("invalid", "Invalid credentials,Try again!");
		return mav;
	}

	@RequestMapping(value = "/donorSessionCheck", method = RequestMethod.GET)

	public ModelAndView donorSessionCheck(HttpServletRequest request, HttpServletResponse response) {
		// String donorName;
		int donorId;
		String donorBloodGroup = null;
		ModelAndView mav = null;
		HttpSession session = request.getSession(false);
		try {

			donorId = (int) session.getAttribute("donorId");

			if (session.getAttribute("donorName") != null) {

				request.setAttribute("donorId", donorId);
				donorBloodGroup = (String) session.getAttribute("donorBloodGroup");
				
				try
				{
					List<PostBloodRequirementPojo> requirementList = new ArrayList<PostBloodRequirementPojo>();
					requirementList = donorService.displayRequirements(donorBloodGroup);
					List<PostBloodRequirementPojo> compatibilityList = new ArrayList<PostBloodRequirementPojo>();
					compatibilityList = donorService.displayBloodCompatibility(donorBloodGroup);
					System.out.print("compList" + compatibilityList);
				if (!requirementList.isEmpty() || !compatibilityList.isEmpty())
				// if (requirementList!=null || compatibilityList!=null)
				{
					mav = new ModelAndView("DonorBooking");
					request.setAttribute("donorId", donorId);
					request.setAttribute("donorBloodGroup", donorBloodGroup);
					if (!requirementList.isEmpty()) {
						mav.addObject("requirementList", requirementList);

					} else {
						mav.addObject("message",
								"No recipients with same blood group available.Other compatible blood recipients are available");
					}
					if (!compatibilityList.isEmpty()) {
						mav.addObject("compatibilityList", compatibilityList);
					}

				}
				}
				catch (NullPointerException ne)
				{
					LOGGER.error(ne.getMessage());
					mav = new ModelAndView("NoRecipient");
				}
			}

			else {
				mav = new ModelAndView("Home");
			}

		} catch (NullPointerException ne) {
			LOGGER.error(ne.getMessage());
			mav = new ModelAndView("Home");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");

		}

		return mav;
	}

	@RequestMapping(value = "/donorRequests", method = RequestMethod.POST)
	// This method is used to register the donor Details in the database.
	public ModelAndView donorRequests(@Valid @ModelAttribute("donor") DonorPojo donorPojo, BindingResult result)
			throws ApplicationException {
		int id;
		int mailCheck;
		int check = 1;
		ModelAndView mav = null;
		if (!result.hasErrors()) {
			try {
				mailCheck = donorService.mailCheckDonor(donorPojo);
				if (mailCheck != check) {
					id = donorService.registerDonor(donorPojo);
					if (id == check) {
						mav = new ModelAndView("DonorLogin");
						mav.addObject("d_msg", "Successfully registered as a donor");
					} else {
						mav = new ModelAndView("DonorRegister");
						mav.addObject("d_msg", "Fill the missed fields");
					}
				} else {
					List<StatesPojo> allStates = usersService.getAllStates();// Fetching the States Values from the
																				// Database.
					List<BloodGroupPojo> allBloodGroups = usersService.getAllBloodGroups();
					mav = new ModelAndView("DonorRegisterWithNewMailId");
					mav.addObject("donorPojo", donorPojo);// setting PojoObject through the method add Object.
					mav.addObject("allStates", allStates);
					mav.addObject("allBloodGroups", allBloodGroups);
				}
			} catch (ApplicationException e) {
				LOGGER.error(e.getMessage());
				mav = new ModelAndView("Error");
			}
		} else {
			List<StatesPojo> allStates = usersService.getAllStates();// Fetching the States Values from the Database.
			List<BloodGroupPojo> allBloodGroups = usersService.getAllBloodGroups();
			mav = new ModelAndView("Donor");
			mav.addObject("donorPojo", donorPojo);// setting PojoObject through the method add Object.
			mav.addObject("allStates", allStates);
			mav.addObject("allBloodGroups", allBloodGroups);
		}

		return mav;
	}

	@RequestMapping(value = "/slotBooking", method = RequestMethod.GET)
	// this method is used for Booking the Slot to Recipient for Donating Blood by
	// the Donor.
	public ModelAndView slotBooking(@ModelAttribute("command") SlotBookingPojo slotBookingPojo,
			BindingResult mapping1BindingResult, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		// String message = null;
		HttpSession session = request.getSession(false);

		String donorBloodGroup = slotBookingPojo.getDonorBloodGroup();

		try {
			if ((int) session.getAttribute("donorId") != 0) {

				List<PostBloodRequirementPojo> requirementList = new ArrayList<PostBloodRequirementPojo>();
				try {
					requirementList = donorService.displayRequirements(donorBloodGroup);

					mav = new ModelAndView("BookingForm");
					mav.addObject("slotBookingPojo", slotBookingPojo);
				} catch (ApplicationException e) {
					LOGGER.error(e.getMessage());
					mav = new ModelAndView("Error");
				}
			} else {
				mav = new ModelAndView("Home");
			}
		} catch (NullPointerException ne) {
			LOGGER.error(ne.getMessage());
			mav = new ModelAndView("Home");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");

		}
		return mav;
	}

	@RequestMapping(value = "/confirmSlot", method = RequestMethod.GET)
	public ModelAndView confirmSlot(@ModelAttribute("command") SlotBookingPojo slotBookingPojo, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		int recipientId, delete, check;
		ModelAndView mav = null;
		HttpSession session = request.getSession(false);
		session.setAttribute("hospitalName", slotBookingPojo.getHospitalName());
		session.setAttribute("area", slotBookingPojo.getArea());
		slotBookingPojo.setContactNumber((long) (session.getAttribute("contactNumber")));
		try {

			if ((int) session.getAttribute("donorId") != 0) {

				check = donorService.dateCheck(slotBookingPojo.getRequiredDate(), slotBookingPojo.getDate());

				if (check <= 0) {

					recipientId = donorService.confirmSlot(slotBookingPojo);
					if (recipientId != 0) {
						delete = donorService.deleteRequirement(recipientId);// Deleting the Recipient Requirement
																				// Details from database..because if a
																				// donor book a recipient then the
																				// recipient details need not to be
																				// displayed in the home page.
						if (delete != 0) {
							mav = new ModelAndView("SlotConfirmation");
						} else {
							mav = new ModelAndView("Error");
						}
					} else {
						mav = new ModelAndView("Error");
					}
				} else {
					mav = new ModelAndView("BookingForm");
					mav.addObject("message", "Please choose the date before the required date");
					mav.addObject("slotBookingPojo", slotBookingPojo);
				}
			} else {
				mav = new ModelAndView("Home");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
			mav.addObject("message", e.toString());
		}
		return mav;

	}

	@RequestMapping("/feedback")
	// This is used for Donor feedback regarding Blood Donations
	public ModelAndView feedback(@ModelAttribute("command") FeedbackPojo feedbackPojo, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) throws ApplicationException {
		int id;
		int check = 1;
		ModelAndView mav = null;
		HttpSession session = request.getSession(false);
		id = donorService.feedbackEntry(feedbackPojo);
		try {
			if ((int) session.getAttribute("donorId") != 0) {
				if (id == check) {
					mav = new ModelAndView("FeedbackSubmission");
				} else {
					mav = new ModelAndView("Error");
				}
			} else {
				mav = new ModelAndView("Home");
			}
		} catch (NullPointerException ne) {
			LOGGER.error(ne.getMessage());
			mav = new ModelAndView("Home");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
			mav.addObject("message", e.getMessage());
		}
		return mav;

	}

	@RequestMapping("/feedbackFetch")
	// this Method is used for Fetching the Feedback List from the database and
	// Displayed through home page
	public ModelAndView feedbackFetch(@ModelAttribute("feedback") FeedbackPojo feedbackPojo, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) throws ApplicationException {
		ModelAndView mav = null;
		List<FeedbackPojo> details = new ArrayList<FeedbackPojo>();
		details = donorService.feedbackFetch(feedbackPojo);
		mav = new ModelAndView("FeedbackDetails");
		if (!details.isEmpty()) {
			mav.addObject("details", details);
		} else {
			mav.addObject("message", "No feedback");
		}
		return mav;
	}

	@RequestMapping(value = "/donorSignIn", method = RequestMethod.GET)

	public ModelAndView donorSignIn(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("DonorLogin");
	}

	@RequestMapping(value = "/donorRegister", method = RequestMethod.GET)

	public ModelAndView donorRegister(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		try {
			List<StatesPojo> allStates = usersService.getAllStates();
			List<BloodGroupPojo> allBloodGroups = usersService.getAllBloodGroups();
			mav = new ModelAndView("Donor");
			mav.addObject("allStates", allStates);
			mav.addObject("allBloodGroups", allBloodGroups);
			map.addAttribute("donor", new DonorPojo());
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
			mav.addObject("message", e.getMessage());
		}

		return mav;
	}

	@RequestMapping(value = "/donorLogout", method = RequestMethod.GET)

	public ModelAndView donorLogout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();
		model.addObject("message", "Logged out successfully.");
		return new ModelAndView("Home");
	}

	@RequestMapping(value = "/donorFeedback", method = RequestMethod.GET)

	public ModelAndView feedbackPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		List<HospitalPojo> allHospitals;
		HttpSession session = request.getSession(false);
		try {
			if ((int) session.getAttribute("donorId") != 0) {

				allHospitals = recipientService.getAllHospitals();
				mav = new ModelAndView("Feedback");
				mav.addObject("allHospitals", allHospitals);
			} else {
				mav = new ModelAndView("Home");
			}
		} catch (NullPointerException ne) {
			LOGGER.error(ne.getMessage());
			mav = new ModelAndView("Home");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
			mav.addObject("message", e.getMessage());
		}
		return mav;
	}

}
