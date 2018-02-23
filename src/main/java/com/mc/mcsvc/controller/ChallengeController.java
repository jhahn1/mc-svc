package com.mc.mcsvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jhahn on 2/23/18.
 */
@Controller
@Component
public class ChallengeController {

	@RequestMapping(value="/nonsecure")
	@ResponseBody
	public String getInfo() {
		return "No need for auth with /getInfo";
	}

	@RequestMapping(value="/create", method = RequestMethod.POST)
	@ResponseBody
	public String createChallenge() {
		return "Challenge can be created!";
	}
}
