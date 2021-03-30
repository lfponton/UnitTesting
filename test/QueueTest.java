import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest
{
  @Test
  public void addedElementIsInQueue() {
    // arrange
    QueueADT<String> q = new BoundedArrayQueue<>(5);
    // act
    q.enqueue("A");
    // assert
    assertTrue(q.contains("A"));
  }
}