package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * Created by zty on 18-7-20
 */
public class QuartzTest {
	public static void main(String[] args) throws SchedulerException, InterruptedException {

		// 创建一个 scheduler
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		// 定义一个 trigger
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1") //定义name/group
				.startNow()//一旦加入scheduler，立即生效
				.withSchedule(simpleSchedule() //使用SimpleTrigger
				.withIntervalInSeconds(1) //每隔一秒执行一次
				.repeatForever()) //一直执行，奔腾到老不停歇
				.build();

		JobDetail job = JobBuilder.newJob(HelloQuartz.class) //定义Job类为HelloQuartz类，这是真正的执行逻辑所在
				.withIdentity("job1", "group1") //定义name/group
				.usingJobData("name", "quartz") //定义属性
				.build();


		scheduler.scheduleJob(job, trigger);
		scheduler.start();

		Thread.sleep(10000);
		scheduler.shutdown();
	}
}
