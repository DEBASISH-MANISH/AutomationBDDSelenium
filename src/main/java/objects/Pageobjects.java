package objects;

public class Pageobjects {
	
	public static final String button_JoinMeeting = "//button[contains(@class,'join-meeting')]";
	public static final String text_username = "//input[@aria-label='Enter Name']";
	public static final String text_meetingid = "//input[@aria-label='Enter Meeting ID']";
	public static final String text_meetingtoken = "//input[@aria-label='Enter Token ID']";
	public static final String button_settingsicon = "//div[@class='v-toolbar__content']//button/*[@class='v-btn__content']";
	public static final String combobox_list = "//div[@class=\"v-dialog v-dialog--active\"]//div[@class='v-select__slot']//div[@class='v-input__append-inner']//i";
	public static final String combobox_value = "//div[text()='texttoreplace']";
	public static final String link_update = "//button//*[text()='Update']";

}
