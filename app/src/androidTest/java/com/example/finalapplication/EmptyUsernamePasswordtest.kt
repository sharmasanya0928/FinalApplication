import androidx.test.espresso.Espresso.onView
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
class LoginActivityEmptyFieldsTest {

    @get:Rule
    var activityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun testEmptyUsernameAndPassword() {
        // Perform click on login button without entering username or password
        onView(withId(R.id.loginButton)).perform(click())

        // Check for expected behavior (Toast message requires a custom matcher)
        // Use a ToastMatcher to check if the Toast message is shown.
    }
}
