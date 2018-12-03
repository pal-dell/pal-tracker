package io.pivotal.pal.tracker;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long,TimeEntry> timeEntryMap  = new HashMap<>();
    private Long uniqueId = 0L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++uniqueId);
        timeEntryMap.put(timeEntry.getId(),timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long timeEntryId) {
        return timeEntryMap.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList(timeEntryMap.values());
    }

    @Override
    public TimeEntry update(Long timeEntryId, TimeEntry timeEntry) {
        timeEntry.setId(timeEntryId);
        timeEntryMap.put(timeEntryId,timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry delete(Long timeEntryId) {
        return timeEntryMap.remove(timeEntryId);
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
