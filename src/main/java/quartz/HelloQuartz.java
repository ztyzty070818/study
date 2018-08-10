package quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by zty on 18-7-20
 */
public class HelloQuartz implements Job {
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		JobDetail job = jobExecutionContext.getJobDetail();
		String name = job.getJobDataMap().getString("name");
		System.out.println("Say hello to " + name + " at " + new Date());
	}
}
