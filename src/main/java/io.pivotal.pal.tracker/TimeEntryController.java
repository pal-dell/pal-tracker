package io.pivotal.pal.tracker;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry){
        timeEntry = timeEntryRepository.create(timeEntry);
        return new ResponseEntity<>(timeEntry, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public   ResponseEntity<TimeEntry> read(@PathVariable Long id){
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if(timeEntry != null){
            return new ResponseEntity<>(timeEntry,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(timeEntry,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public   ResponseEntity<List<TimeEntry>> list(){
        List<TimeEntry> timeEntry = timeEntryRepository.list();
        if(timeEntry != null){
            return new ResponseEntity<>(timeEntry,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(timeEntry,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public   ResponseEntity<TimeEntry> delete(@PathVariable Long id){
        TimeEntry timeEntry = timeEntryRepository.delete(id);
        if(timeEntry != null){
            return new ResponseEntity<>(timeEntry,HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(timeEntry,HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("{id}")
    public   ResponseEntity<TimeEntry> update(@PathVariable Long id,@RequestBody TimeEntry timeEntry){
        timeEntry = timeEntryRepository.update(id,timeEntry);
        if(timeEntry != null){
            return new ResponseEntity<>(timeEntry,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(timeEntry,HttpStatus.NOT_FOUND);
        }
    }

}
