import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class CourseCalendar {
	static int daysToNextMonday(int dayOfWeek) {
		switch (dayOfWeek) {
		case Calendar.SUNDAY:
			return 1;
		case Calendar.SATURDAY:
			return 2;
		case Calendar.FRIDAY:
			return 3;
		case Calendar.THURSDAY:
			return 4;
		case Calendar.WEDNESDAY:
			return 5;
		case Calendar.TUESDAY:
			return 6;
		case Calendar.MONDAY:
			return 0;
		}
		return -1;
	}

	static long[] getUpcomingSessions(long launch_date, int repeat_frequency, long enrollment_date) {
		long[] outputDays = new long[3];

		Calendar utcCalendar = Calendar.getInstance();
		Calendar launchCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		Calendar sessionCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		Calendar enrollmentCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

		utcCalendar.clear();
		launchCalendar.clear();
		long timediff = utcCalendar.getTimeInMillis() - launchCalendar.getTimeInMillis();
		System.out.println(timediff/(1000*3600));
		enrollmentCalendar.setTimeInMillis(enrollment_date + timediff);
		launchCalendar.setTimeInMillis(launch_date + timediff);
		sessionCalendar.setTimeInMillis(launch_date + timediff);
//		System.out.println(sessionCalendar.getTime());
		
		sessionCalendar.add(Calendar.DATE, daysToNextMonday(sessionCalendar.get(Calendar.DAY_OF_WEEK)));
		System.out.println(sessionCalendar.getTime());
		System.out.println(enrollmentCalendar.getTime());

		long sessionDate = sessionCalendar.getTimeInMillis() - timediff;
		if (enrollment_date <= sessionDate) {
			outputDays[0] = sessionCalendar.getTimeInMillis();
			sessionCalendar.add(Calendar.DATE, repeat_frequency * 7);
			outputDays[1] = sessionCalendar.getTimeInMillis();
			sessionCalendar.add(Calendar.DATE, repeat_frequency * 7);
			outputDays[2] = sessionCalendar.getTimeInMillis();
		} else {
			int diff = (int) ((enrollment_date - sessionDate) / (1000*3600*24));
			System.out.println(diff);
			int daysToNextSession = (repeat_frequency * 7) - (diff % (repeat_frequency * 7));
			System.out.println(daysToNextSession);
			enrollmentCalendar.add(Calendar.DATE, daysToNextSession);
			outputDays[0] = enrollmentCalendar.getTimeInMillis() - timediff;
			enrollmentCalendar.add(Calendar.DATE, repeat_frequency * 7);
			outputDays[1] = enrollmentCalendar.getTimeInMillis() - timediff;
			enrollmentCalendar.add(Calendar.DATE, repeat_frequency * 7);
			outputDays[2] = enrollmentCalendar.getTimeInMillis() - timediff;
		}

		return outputDays;
	}

	public static void main(String[] args) {
		long[] days = getUpcomingSessions(1470096000000L, 2, 1470787200000L);
//		long[] days = getUpcomingSessions(1470700800000L, 1, 1470096000000L);
		System.out.println(days[0]);
		System.out.println(days[1]);
		System.out.println(days[2]);
	}
}
