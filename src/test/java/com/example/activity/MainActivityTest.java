package com.example.activity;

import android.app.Activity;
import com.whiteboard.activities.LoginActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest{

    @Test
    public void testSomething() {
        Activity activity = Robolectric.buildActivity(LoginActivity.class).create().get();
        assertTrue(activity != null);
    }
}