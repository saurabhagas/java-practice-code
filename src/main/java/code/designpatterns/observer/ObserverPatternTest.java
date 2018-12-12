package code.designpatterns.observer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ObserverPatternTest {
  @Test
  public void testSynchronousUpdate() {
    Subject subject = new EveryUpdateSendingSubject();
    Observer concreteObserver1 = new DefaultObserver(subject);
    Observer concreteObserver2 = new DefaultObserver(subject);

    // Verify initial states
    assertThat(concreteObserver1.getCurrentValue(), is(0));
    assertThat(concreteObserver2.getCurrentValue(), is(0));

    // Publish event to Subject
    subject.generateEvent();

    // Verify that observers got the update
    assertThat(concreteObserver1.getCurrentValue(), is(1));
    assertThat(concreteObserver2.getCurrentValue(), is(1));
  }

  @Test
  public void testManualNotify() {
    Subject subject = new OnDemandUpdateSendingSubject();
    Observer concreteObserver1 = new DefaultObserver(subject);
    Observer concreteObserver2 = new DefaultObserver(subject);

    // Verify initial states
    assertThat(concreteObserver1.getCurrentValue(), is(0));
    assertThat(concreteObserver2.getCurrentValue(), is(0));

    // Publish event to Subject
    subject.generateEvent();

    // Verify that observers didn't get the update
    assertThat(concreteObserver1.getCurrentValue(), is(0));
    assertThat(concreteObserver2.getCurrentValue(), is(0));

    subject.notifyObservers();

    // Verify that observers got the update
    assertThat(concreteObserver1.getCurrentValue(), is(1));
    assertThat(concreteObserver2.getCurrentValue(), is(1));
  }

  @Test
  public void testManualSyncFromObserver() {
    Subject subject = new OnDemandUpdateSendingSubject();
    Observer concreteObserver1 = new SyncWithSubjectObserver(subject);
    Observer concreteObserver2 = new SyncWithSubjectObserver(subject);

    // Verify initial states
    assertThat(concreteObserver1.getCurrentValue(), is(0));
    assertThat(concreteObserver2.getCurrentValue(), is(0));

    // Publish event to Subject
    subject.generateEvent();

    // Verify that observers didn't get the update
    assertThat(concreteObserver1.getCurrentValue(), is(0));
    assertThat(concreteObserver2.getCurrentValue(), is(0));

    ((SyncWithSubjectObserver) concreteObserver1).syncWithSubject();
    ((SyncWithSubjectObserver) concreteObserver2).syncWithSubject();

    // Verify that observers got the update
    assertThat(concreteObserver1.getCurrentValue(), is(1));
    assertThat(concreteObserver2.getCurrentValue(), is(1));
  }

  @Test
  public void testBatchedUpdates() {
    Subject subject = new BatchedUpdateSendingSubject(2);
    Observer concreteObserver1 = new DefaultObserver(subject);
    Observer concreteObserver2 = new DefaultObserver(subject);

    // Verify initial states
    assertThat(concreteObserver1.getCurrentValue(), is(0));
    assertThat(concreteObserver2.getCurrentValue(), is(0));

    // Publish first event to Subject
    subject.generateEvent();

    // Verify that first update got batched and didn't reach the observers
    assertThat(concreteObserver1.getCurrentValue(), is(0));
    assertThat(concreteObserver2.getCurrentValue(), is(0));

    // Publish second to Subject
    subject.generateEvent();

    // Verify that first update got batched and didn't reach the observers
    assertThat(concreteObserver1.getCurrentValue(), is(2));
    assertThat(concreteObserver2.getCurrentValue(), is(2));
  }

  @Test
  public void testUnsubscribe() {
    Subject subject = new EveryUpdateSendingSubject();
    Observer concreteObserver1 = new DefaultObserver(subject);
    Observer concreteObserver2 = new DefaultObserver(subject);

    // Publish first event to Subject
    subject.generateEvent();

    // Verify that first update reached the observers
    assertThat(concreteObserver1.getCurrentValue(), is(1));
    assertThat(concreteObserver2.getCurrentValue(), is(1));

    // Unsubscribe observer 1
    subject.unsubscribe(concreteObserver1);

    // Publish second to Subject
    subject.generateEvent();

    // Verify that first update didn't
    assertThat(concreteObserver1.getCurrentValue(), is(1));
    assertThat(concreteObserver2.getCurrentValue(), is(2));
  }
}
