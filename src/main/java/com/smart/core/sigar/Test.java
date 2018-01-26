package com.smart.core.sigar;

import java.io.File;

import org.hyperic.sigar.SigarException;

public class Test {

	/**
	 * @param args
	 * @throws SigarException 
	 */
	public static void main(String[] args) throws SigarException {
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.dir") + File.separator + "ini" + File.separator + "lib" + File.separator + "ext" + File.separator);
		// TODO Auto-generated method stub
		CpuData cpuData = CpuData.getCpuData();
		System.out.println(cpuData.getInfo().getModel());
		System.out.println(cpuData.getPerc().getIdle());
		System.out.println(cpuData.getTimer().getTotal());
		
		MemoryData memData = MemoryData.getMemoryData();
		System.out.println(memData.getMemory().getTotal());
		System.out.println(memData.getMemory().getFree());
		System.out.println(memData.getMemory().getUsed());
		
		OsData osData = new OsData();
		System.out.println(osData.getOs().getDescription());
		cpuData.getPerc().getUser();
	}

}
