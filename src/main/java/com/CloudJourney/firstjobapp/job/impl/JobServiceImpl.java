package com.CloudJourney.firstjobapp.job.impl;

import com.CloudJourney.firstjobapp.job.Job;
import com.CloudJourney.firstjobapp.job.JobRepository;
import com.CloudJourney.firstjobapp.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
 //private long nextId = 1;
    //private List<Job> Jobs =new ArrayList<>();

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> findAll(){
    return jobRepository.findAll();
    }

    public void createJob(Job job){
     jobRepository.save(job);
    }

    @Override
    public Job findByJobId(Long id) {
        return jobRepository.findById(id).orElse(null);
        }

    @Override
    public Boolean DeleteJob(Long id) {
       try {
           jobRepository.deleteById(id);
           return true;
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public Boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> OptionalJob=jobRepository.findById(id);
            if(OptionalJob.isPresent()){
                Job job=OptionalJob.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinsalary(updatedJob.getMinsalary());
                job.setMaxsalary(updatedJob.getMaxsalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
            }

        return false;
    }
}
