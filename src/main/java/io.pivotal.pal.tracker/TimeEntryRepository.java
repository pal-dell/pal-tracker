package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface TimeEntryRepository extends Repository {

    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry find(Long timeEntryId);
    public List<TimeEntry> list();
    public TimeEntry update(Long timeEntryId,TimeEntry timeEntry);
    public TimeEntry delete(Long timeEntryId);

}
