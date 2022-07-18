package com.dani.apimarvel.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dani.apimarvel.R
import com.dani.apimarvel.utils.DataBindingIdlingResource
import com.dani.apimarvel.utils.monitorActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class CharactersListActivityTest {

    @Before
    fun setUp() {
        /*
        mockWebServerRule.server.enqueue(
            MockResponse().fromJson(
                ApplicationProvider.getApplicationContext(),
                "popularcharacters.json"
            )
        )
        //val resource = OkHttp3IdlingResource.create("OkHttp", APIServiceManager.okHttpClient)
        //IdlingRegistry.getInstance().register(resource)

         */
    }

    @After
    fun tearDown() {
    }

    private val dataBindingIdlingResource = DataBindingIdlingResource()
    @Test
    fun testing_test()  = runTest {
        val activityScenario = ActivityScenario.launch(NavHostActivity::class.java)
        dataBindingIdlingResource.monitorActivity(activityScenario)

        runBlocking {
            delay(4000)

            onView(withId(R.id.rvItems))
                .perform(
                    actionOnItemAtPosition<RecyclerView.ViewHolder>( 2,
                        click()
                    )
                )

            onView(withId(R.id.ivImage))
                .check(
                    matches(
                        isDisplayed()
                )
            )

        }
    }

    @Test
    fun clickAMycharacterNavigatesToDetail() = runTest {
        val activityScenario = ActivityScenario.launch(NavHostActivity::class.java)
        Espresso.onView(withId(R.id.rvItems)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )


        Espresso.onView(withId(R.id.ivImage)).check(
            ViewAssertions.matches(
                CoreMatchers.not(
                    ViewMatchers.isDisplayed()
                )
            )
        )


        // When using ActivityScenario.launch, always call close()
        activityScenario.close()
    }
}