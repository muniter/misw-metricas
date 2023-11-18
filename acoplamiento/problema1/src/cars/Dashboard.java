package cars;

import java.util.Map;

public class Dashboard {

	public void printDashboard(Map<String, Object> metrics) {
		System.out.println("--------------------------------");
		System.out.println("DASHBOARD:");
		System.out.println("\t RPM: " + metrics.get("rpm"));
		System.out.println("\t Speed: " + metrics.get("speed"));
		System.out.println("\t Oil level: " + metrics.get("oilLevel"));
		System.out.println("\t Gas level: " + metrics.get("gasLevel"));
	}
}
