package com.yahya.challenge4.scheduler;

import com.yahya.challenge4.service.UsersService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class AnyJob extends QuartzJobBean {

    private static final Logger LOG = LoggerFactory.getLogger(AnyJob.class);

    @Autowired
    private UsersService usersService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LOG.info(usersService.getUser(1).get().getUsername());
    }
}
