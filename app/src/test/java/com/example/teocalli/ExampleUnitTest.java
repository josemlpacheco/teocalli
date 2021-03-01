package com.example.teocalli;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void password_idValid() {
        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*(?<=.{8,})$");
        Matcher matcher = passwordPattern.matcher("bVFh#IF%p%pw");
        assertSame(true, matcher.matches());
    }
}