package com.CloudJourney.firstjobapp.job;

import java.util.List;

public interface JobService {

  List<Job> findAll();
  void createJob(Job job);
  Job findByJobId(Long id);
  Boolean DeleteJob(Long id);
  Boolean updateJob(Long id,Job updatedJob);
}
