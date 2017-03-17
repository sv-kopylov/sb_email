package sb_email;

/**
 * Created by Сергей on 03.03.2017.
 */
public class ViewSettings {
//NAMES ///////
    public static final String grandTytle = "SB_EMAIL v.0.0 2017";
    public static final String loginInput = "LOGIN";
    public static final String passwordInput = "PASSWORD";
    public static final String nameInput = "NAME";
    public static final String createBoxButtonName = "CREATE";
    public static final String loginButtonName = "ENTER";
    public static final String fromLetterMark = "FROM:";
    public static final String toLetterMark = "TO:";
    public static final String subjectLetterMark = "SUBJECT:";
    public static final String noLettersFound = "No letters found";



/////////  LINKS
    public static final String viewSentLettersLink = "Sent letters";
    public static final String viewReceivedLettersLink = "Received letters";
    public static final String createPostBoxLink = "Create new postbox";
    public static final String deleteLetterLink = "Delete";


//ACTIONS/////
    public static final String loginFormAction = "/welcome/login";
    public static final String logoutFormAction ="/postbox/logout";
    public static final String createBoxFormAction ="/create";
    public static final String linkToCreate ="/create";
    public static final String viewSentLettersAction = "/postbox/sent";
    public static final String viewReceivedLettersAction = "/postbox/received";
    public static final String viewLetterAction = "/postbox/view";
    public static final String deleteLetterAction = "/letter/delete";
}
