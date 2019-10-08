package com.atovk.execise.monitor;

import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.*;

import java.util.ArrayList;
import java.util.List;

public class MonitorTest {


    public static void main(String[] args) {

        SystemInfo systemInfo = new SystemInfo();

        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();

        ComputerSystem computerSystem = hardware.getComputerSystem();
        Firmware firmware = computerSystem.getFirmware();
        String name = firmware.getName();
        String description = firmware.getDescription();
        String firmwareManufacturer = firmware.getManufacturer();
        String releaseDate = firmware.getReleaseDate();
        String firmwareVersion = firmware.getVersion();



        Sensors sensors = hardware.getSensors();
        int[] sensorsFanSpeeds = sensors.getFanSpeeds();
        double sensorsCpuVoltage = sensors.getCpuVoltage();
        double sensorsCpuTemperature = sensors.getCpuTemperature();


        GlobalMemory memory = hardware.getMemory();
        long memoryTotal = memory.getTotal();
        long memoryAvailable = memory.getAvailable();
        long memoryPageSize = memory.getPageSize();
        VirtualMemory memoryVirtualMemory = memory.getVirtualMemory();


        CentralProcessor processor = hardware.getProcessor();
        long processorContextSwitches = processor.getContextSwitches();
        long[] processorCurrentFreq = processor.getCurrentFreq();
        String processorFamily = processor.getFamily();
        String processorIdentifier = processor.getIdentifier();
        long processorInterrupts = processor.getInterrupts();
        int processorLogicalProcessorCount = processor.getLogicalProcessorCount();
        CentralProcessor.LogicalProcessor[] processorLogicalProcessors = processor.getLogicalProcessors();
        long processorMaxFreq = processor.getMaxFreq();
        String processorModel = processor.getModel();
        String processorName = processor.getName();
        int processorPhysicalPackageCount = processor.getPhysicalPackageCount();
        int physicalProcessorCount = processor.getPhysicalProcessorCount();
        double[] processorCpuLoadBetweenTicks = processor.getProcessorCpuLoadBetweenTicks(null);
        long[] systemCpuLoadTicks = processor.getSystemCpuLoadTicks();
        double[] systemLoadAverage = processor.getSystemLoadAverage(20);
        String processorVendor = processor.getVendor();
        Class<? extends CentralProcessor> processorClass = processor.getClass();


        Display[] displays = hardware.getDisplays();
        byte[] edid = displays[0].getEdid();


        HWDiskStore[] diskStores = hardware.getDiskStores();


        NetworkIF[] networkIFs = hardware.getNetworkIFs();



        PowerSource[] powerSources = hardware.getPowerSources();
        String powerName = powerSources[0].getName();
        double remainingCapacity = powerSources[0].getRemainingCapacity();
        double timeRemaining = powerSources[0].getTimeRemaining();


        SoundCard[] soundCards = hardware.getSoundCards();


        UsbDevice[] usbDevices = hardware.getUsbDevices(true);



        int bitness = operatingSystem.getBitness();
        OSProcess[] childProcesses = operatingSystem.getChildProcesses(1, 2, OperatingSystem.ProcessSort.CPU);
        String family = operatingSystem.getFamily();

        FileSystem fileSystem = operatingSystem.getFileSystem();
        OSFileStore[] fileStores = fileSystem.getFileStores();


        String manufacturer = operatingSystem.getManufacturer();



        NetworkParams networkParams = operatingSystem.getNetworkParams();
        String[] dnsServers = networkParams.getDnsServers();
        String domainName = networkParams.getDomainName();
        String hostName = networkParams.getHostName();
        String ipv4DefaultGateway = networkParams.getIpv4DefaultGateway();
        String ipv6DefaultGateway = networkParams.getIpv6DefaultGateway();


        OSProcess process = operatingSystem.getProcess(1121);



        int processCount = operatingSystem.getProcessCount();

        OSProcess[] processes = operatingSystem.getProcesses(10, OperatingSystem.ProcessSort.CPU);


        List<OSProcess> processList = operatingSystem.getProcesses(new ArrayList<>());



        int threadCount = operatingSystem.getThreadCount();
        long systemBootTime = operatingSystem.getSystemBootTime();

        OperatingSystemVersion version = operatingSystem.getVersion();




    }


}
