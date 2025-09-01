import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//------------Task 1-------------
/*
a) Without generating a new arrival event, the system would only ever process the very first customer, and the simulation wouldn’t correctly model continuous arrivals.
b) start of service event should generate a departure event, scheduled to occur after the service time has elapsed.
 */
//------------Task 2-------------
class Event implements Comparable<Event>{
    private long eventTime;
    private String description;
    EventType type;

    public Event(long eventTime, String description, EventType type) {
        this.eventTime = eventTime;
        this.description = description;
        this.type = type;
    }

    public long getEventTime() {
        return eventTime;
    }

    @Override
    public int compareTo(Event other) {
        return Long.compare(this.eventTime, other.eventTime);
    }
    @Override
    public String toString() {
        return "Event{" +
                "time=" + eventTime +
                ", type=" + type +
                ", desc='" + description + '\'' +
                '}';
    }

}
class EventList{
    private PriorityQueue<Event> queue;
    public EventList() {
        queue = new PriorityQueue<>();
    }
    public void addEvent(Event e) {
        queue.add(e);
    }

    public Event getNextEvent() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public List<Event> getOrderedEvents() {
        List<Event> ordered = new ArrayList<>(queue);
        Collections.sort(ordered);
        return ordered;
    }
}
//------------Task 3-------------

enum EventType{
    arrived,
    exit
}

class TestEvent{
    public static void main(String[] args) {
        EventList eventList = new EventList();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            long time = System.nanoTime(); // Random time 0–100
            EventType type = (rand.nextBoolean()) ? EventType.arrived : EventType.exit;
            eventList.addEvent(new Event(time, "Event " + i, type));
        }
        System.out.println("All events (ordered):");
        for (Event e : eventList.getOrderedEvents()) {
            System.out.println(e);
        }
        Event next = eventList.getNextEvent();
        System.out.println("\nNext event to process: " + next);
        System.out.println("\nRemaining events (ordered):");
        for (Event e : eventList.getOrderedEvents()) {
            System.out.println(e);
        }
    }

}