import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.finalapplication.DashboardActivity
import com.example.finalapplication.LoginActivity
import com.example.finalapplication.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityValidInputTest {

    @get:Rule
    var activityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun testValidUsernameAndPassword() {
        // Initialize Intents for intent verification
        Intents.init()

        // Type valid username
        onView(withId(R.id.username)).perform(typeText("Sanya"))

        // Type valid password
        onView(withId(R.id.password)).perform(typeText("s4678129"))

        // Perform click on login button
        onView(withId(R.id.loginButton)).perform(click())

        // Check that DashboardActivity was opened
        Intents.intended(hasComponent(DashboardActivity::class.java.name))

        // Release Intents
        Intents.release()
    }
}
