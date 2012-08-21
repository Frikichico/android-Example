package com.example.androidhive.abc;

public class API {

	public static interface cheerfoolz {
		String NID = "nid";
		String TYPE = "type";
		String LANGUAGE = "language";
		String UID = "uid";

		String NODEWORDS = "nodewords";
		String KEYWORDS = "keywords";
		String VALUE = "value";

		String FILES = "files";
	}

	public static interface cheerfoolz_activities {
		String NODES = "nodes";
		String NODE = "node";
		String TITLE = "title";
		String FIELD_ACTIVITY_IMAGE_FID = "field_activity_image_fid";
		String TID = "tid";
		String GOAL = "Goal";
		String WHO_CAN_PLAY_IT = "Who can play it?";
		String FIELD_ACITIVITY_PLAYER_NO_VALUE = "field_acitivity_player_no_value";
		String DURATION = "Duration (hrs)";
		String THINGS_REQUIRED = "Things Required";
		String RULES = "Rules";
		String HOW_TO_PLAY = "How To Play";
	}

	public static interface cheerfoolz_contests {
		String NODES = "nodes";
		String NODE = "node";
		String TITLE = "title";
		String FIELD_CONTEST_IMAGE_FID = "field_contest_image_fid";
		String FIELD_CONTEST_START_DATE_VALUE = "field_contest_start_date_value";
		String FIELD_CONTEST_END_DATE_VALUE = "field_contest_end_date_value";
		String PRIZE = "Prize";
		String OTHER_PRIZES = "Other Prizes";
		String ELIGIBILITY = "Eligibility";
		String DETAILS_OF_CONTEST = "Details of Contest";

	}

	public static interface cheerfoolz_inventor {
		String NODES = "nodes";
		String NODE = "node";
		String TITLE = "title";
		String FIELD_FOUNDER_IMAGE_FID = "field_founder_image_fid";
		String FOUNDER_PROFILE_BEING_CREATED_FOR = "Founder Profile Being Created For";
		String FIELD_FOUNDER_CITY_VALUE = "field_founder_city_value";
		String STATE = "State";
		String FIELD_FOUNDER_COUNTRY_VALUE = "field_founder_country_value";
		String DATE_OF_BIRTH = "Date Of Birth";
		String SCHOOL_NAME = "School Name";
		String ABOUT_FOUNDER = "About Founder";
		String FATHER_NAME = "Father Name";
		String FATHER_OCCUPATION = "Father Occupation";
		String MOTHER_NAME = "Mother Name";
		String MOTHER_OCCUPATION = "Mother Occupation";

	}

	public static interface cheerfoolz_popularIdea {
		String NODES = "nodes";
		String NODE = "node";
		String TITLE = "Title";
		String FIELD_IDEA_IMAGE_FID = "field_idea_image_fid";
		String IDEABY = "field_founder_profile_refrence_nid";
		String STORY_BEHIND_IDEA = "Story Behind Idea";
	}

	public static interface cheerfoolz_events {
		String NODES = "nodes";
		String NODE = "node";
		String TITLE = "title";
		String EVENT_START = "Event Start";
		String EVENT_END = "Event End";
		String TIMEZONE_NAME = "Timezone Name";
		String DESCRIPTION = "Description";
	}

	public static interface cheerfoolz_about_us {
		String NODES = "nodes";
		String NODE = "node";
		String TITLE = "title";
		String BODY = "body";
	}
	public static interface cheerfoolz_myprofile {
		String NODES = "nodes";
		String NODE = "node";
		String NAME = "Name";
		String USERNAME = "Username";
		String ADDRESS = "Address";
		String DATE_OF_BIRTH = "Date of Birth";
		String OCCUPATION = "Occupation";
		String MEMBER_SINCE = "Member Since";
	}

}
