import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.finalapplication.LoginActivity
import com.example.finalapplication.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityInvalidInputTest {

    @get:Rule
    var activityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun testInvalidUsernameOrPassword() {
        // Type invalid username
        onView(withId(R.id.username)).perform(typeText("invalidUsername"))

        // Type invalid password
        onView(withId(R.id.password)).perform(typeText("invalidPassword"))

        // Perform click on login button
        onView(withId(R.id.loginButton)).perform(click())

        // Check for the expected Toast message for invalid credentials
        // Use a ToastMatcher to check if the Toast message is shown.
        // e.g., "Login failed: Invalid credentials"
    }
}
