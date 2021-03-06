import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest
{

  private QueueADT<String> q;

  @BeforeEach
  public void createQueue() {
    // arrange
    q = new BoundedArrayQueue<>(5);
  }
  @Test
  public void addedElementIsInQueue() {
    // act
    q.enqueue("A");
    // assert
    assertTrue(q.contains("A"));
  }

  @Test
  public void addMultipleElementsToQueue() {
    // act
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    // assert
    assertTrue(q.contains("A"));
    assertTrue(q.contains("B"));
    assertTrue(q.contains("C"));
    assertTrue(q.contains("D"));
  }

  @Test
  public void sizeIs4AfterAdding4Elements() {
    // act
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    // assert
    assertEquals(4, q.size());
  }

  @Test
  public void nullArgumentResultsInIllegalArgumentException() {
    // act & assert
    assertThrows(IllegalArgumentException.class, () -> q.enqueue(null));
  }

  @Test
  public void fullQueueResultsInIllegalStateException() {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    assertThrows(IllegalStateException.class, ()-> q.enqueue("X"));
}

@Test void illegalStateExceptionFailedManually() {
  q.enqueue("A");
  q.enqueue("B");
  q.enqueue("C");
  q.enqueue("D");
  q.enqueue("E");
  try {
    q.enqueue("X");
    fail("Should not be able to enqueue 6th element");
  } catch (IllegalStateException e)
  {}
}
}