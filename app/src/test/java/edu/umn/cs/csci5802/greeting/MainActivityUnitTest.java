package edu.umn.cs.csci5802.greeting;

import android.content.Intent;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class MainActivityUnitTest {

    @Test
    public void processNameToLowerCase(){
        MainActivity activity = new MainActivity();
        EditText nameViewStub = mock(EditText.class);
        Editable editableStub = mock(Editable.class);
        when(nameViewStub.getText()).thenReturn(editableStub);
        when(editableStub.toString()).thenReturn("GOLDY");
        String actual = activity.processName(MainActivity.LOWER, nameViewStub);
        assertEquals("goldy", actual);
    }

    @Test
    public void displayMethodShouldStartDisplayActivityWithSpecificValueForExtra(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        EditText nameEditText = activity.findViewById(R.id.name);
        nameEditText.setText("GOLDY");
        Button displayLowerButton = activity.findViewById(R.id.displayLower);
        activity.display(displayLowerButton);
        Intent intent = Shadows.shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        String actualExtra = intent.getStringExtra("message");
        assertEquals("goldy", actualExtra);
    }

}
