package main.basics_1.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by saurabhagrawal on 27/12/18.
 */
public class OptionBasics {

    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        Assert.assertFalse(empty.isPresent());

        String name = "Saurabh";
        Optional<String> opt = Optional.ofNullable(name);
        //Assert.assertTrue("Optional[Saurabh]", opt.toString());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.of(name);  //value passed to .of (should not be null)
    }
}

