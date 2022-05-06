import exceptions.InvalidValueException;
import logics.NotationConverter;
import org.junit.Assert;
import org.junit.Test;

public class NotationConverterTest {
    NotationConverter testConverter = new NotationConverter();
    @Test
    public void resShouldBe10() {
        Assert.assertEquals(10, testConverter.toArabic("X"));
    }
    @Test
    public void resShouldBe40() {
        Assert.assertEquals(40, testConverter.toArabic("XL"));
    }
    @Test
    public void resShouldBe3() {
        Assert.assertEquals(3, testConverter.toArabic("III"));
    }
    @Test
    public void resShouldBe12() {
        Assert.assertEquals(12, testConverter.toArabic("XII"));
    }
    @Test
    public void resShouldBe59() {
        Assert.assertEquals(59, testConverter.toArabic("LIX"));
    }
    @Test
    public void resShouldBe1990() {
        Assert.assertEquals(1990, testConverter.toArabic("MCMXC"));
    }
    @Test
    public void resShouldBe437() {
        Assert.assertEquals(437, testConverter.toArabic("CDXXXVII"));
    }
    @Test
    public void resShouldBe846() {
        Assert.assertEquals(846, testConverter.toArabic("DCCCXLVI"));
    }
    @Test
    public void resShouldBe3456() {
        Assert.assertEquals(3456, testConverter.toArabic("MMMCDLVI"));
    }
    @Test
    public void resShouldBe3987() {
        Assert.assertEquals(3987, testConverter.toArabic("MMMCMLXXXVII"));
    }


    @Test(expected = InvalidValueException.class)
    public void russianLayoutShouldThrowException() {
        testConverter.toArabic("ХС");
    }
    @Test(expected = InvalidValueException.class)
    public void russianLayoutShouldThrowException1() {
        testConverter.toArabic("СХ");
    }
    @Test(expected = InvalidValueException.class)
    public void russianLayoutShouldThrowException2() {
        testConverter.toArabic("МХ");
    }


    @Test(expected = InvalidValueException.class)
    public void shouldThrowException1() {
        testConverter.toArabic("VI1");
    }
    @Test(expected = InvalidValueException.class)
    public void shouldThrowException2() {
        testConverter.toArabic("A");
    }
    @Test(expected = InvalidValueException.class)
    public void shouldThrowException3() {
        testConverter.toArabic("");
    }
    @Test(expected = InvalidValueException.class)
    public void shouldThrowException4() {
        testConverter.toArabic("  !");
    }
    @Test(expected = InvalidValueException.class)
    public void shouldThrowException5() {
        testConverter.toArabic("X_");
    }
    @Test(expected = InvalidValueException.class)
    public void shouldThrowException6() {
        testConverter.toArabic("J");
    }
    @Test(expected = InvalidValueException.class)
    public void shouldThrowException7() {
        testConverter.toArabic("XL ");
    }
    @Test(expected = InvalidValueException.class)
    public void shouldThrowException8() {
        testConverter.toArabic(" IX");
    }
    @Test(expected = InvalidValueException.class)
    public void shouldThrowException9() {
        testConverter.toArabic("!X");
    }
    @Test(expected = InvalidValueException.class)
    public void shouldThrowException10() {
        testConverter.toArabic("L!");
    }
    @Test(expected = InvalidValueException.class)
    public void shouldThrowException11() {
        testConverter.toArabic("C X");
    }
}
