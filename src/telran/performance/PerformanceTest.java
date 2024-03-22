package telran.performance;

public abstract class PerformanceTest {
	int nRuns;
	String displayName;

	protected PerformanceTest(String displayName, int nRuns) {
		this.nRuns = nRuns;
		this.displayName = displayName;
	}

	protected abstract void runTest();

	public void run() {
		long timestampStart = System.currentTimeMillis();
		for(int i = 0; i < nRuns; i++) {
			runTest();
		}
		long timestampFinish = System.currentTimeMillis();
		long runningTime = timestampFinish - timestampStart;
		System.out.printf("%s; number of runs: %d; running time: %d\n", displayName, nRuns, runningTime);
	}

}
