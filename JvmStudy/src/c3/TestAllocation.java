package c3;
class TestAllocation {
	private static final int _1MB = 1024 * 1024;

	/**
	 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
	 */
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];  // 出现一次Minor GC
	}

	/** VM 参数：- verbose: gc- Xms20M- Xmx20M- Xmn10M- XX:+ PrintGCDetails- XX: SurvivorRatio= 8 -XX:+UseSerialGC
	 * -XX: PretenureSizeThreshold= 3145728 */
	public static void testPretenureSizeThreshold(){
		byte[] allocation;
		allocation= new byte[ 4*_1MB];// 直接 分配 在 老 年代 中 }
	}

	/** *VM 参数：- verbose: gc- Xms20M- Xmx20M- Xmn10M- XX:+ PrintGCDetails- XX: SurvivorRatio= 8- XX:MaxTenuringThreshold=1
	 * -XX:+ PrintTenuringDistribution */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold(){
		byte[] allocation1, allocation2, allocation3;
		allocation1= new byte[_1MB/ 4]; //什么时候 进入 老 年代 取决于 XX: MaxTenuringThreshold 设置
		allocation2= new byte[ 4*_1MB];
		allocation3= new byte[ 4*_1MB];
		allocation3= null;
		allocation3= new byte[ 4*_1MB];
	}

	public static void main(String[] args) {
		testTenuringThreshold();
	}
}