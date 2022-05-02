package Code;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;


import static Code.Foo.HELLO_WORLD;
import static org.testng.Assert.assertEquals;

public class MockitoHelloWorldExample {
    private Foo foo;

    @BeforeMethod
    public void setupMock() {
        foo = mock(Foo.class);
        when(foo.greet()).thenReturn(HELLO_WORLD);
    }

    @Test
    public void fooGreets() {
        System.out.println("Foo greets: " + foo.greet());
        assertEquals(HELLO_WORLD, foo.greet());
    }

    @Test
    public void barGreets() {
        Bar bar = new Bar();
        assertEquals(HELLO_WORLD, bar.greet(foo));
    }

    @Test(expectedExceptions=FooNotAvailable.class)
    public void fooNotAvailable() {
        Bar bar = new Bar();
        System.out.println("Foo is down so will not respond");
        when(foo.greet()).thenReturn(null);
        System.out.println("Bar sends a question to Foo but since Foo is not avilable will throw FooNotAvailable");
        bar.question(foo, "Hello Foo");
    }

    @Test
    public void barQuestionsFoo() {
        Bar bar = new Bar();
        System.out.println("Bar asks Foo 'Any new topics?', it should get a response");
        bar.question(foo, Foo.ANY_NEW_TOPICS);
        System.out.println("Verify that Foo has been asked the question");
        verify(foo, times(1)).question(Foo.ANY_NEW_TOPICS);
    }

    @Test
    public void filterInvalidQuestions() {
        Bar bar = new Bar();
        String invalidQuestion = "Invalid question";
        bar.question(foo, invalidQuestion);
        System.out.println("Verify that question was never requested as Foo is un-available");
        verify(foo, never()).question(invalidQuestion);
    }
}
