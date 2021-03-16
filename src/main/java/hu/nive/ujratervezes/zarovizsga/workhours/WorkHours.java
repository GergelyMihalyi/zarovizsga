package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public static final String SEPARATION_SIGN = ",";
    public static final int NAME_INDEX = 0;
    public static final int HOURS_INDEX = 1;
    public static final int DATE_INDEX = 2;

    public String minWork(String file) {
        System.out.println(file);
        Path workerFile = Path.of(file);
        Worker worker;
        try (BufferedReader reader = Files.newBufferedReader(workerFile)) {
            String line = reader.readLine();
            worker = addWorker(line);
            while ((line = reader.readLine()) != null) {
                if (workHours(line) < worker.getWorkHours()) {
                    worker = addWorker(line);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return worker.toString();
    }

    private Worker addWorker(String line) {
        String[] pieces = line.split(SEPARATION_SIGN);
        String name = pieces[NAME_INDEX];
        int workHours = Integer.parseInt(pieces[HOURS_INDEX]);
        String workDate = pieces[DATE_INDEX];
        Worker worker = new Worker(name, workHours, workDate);
        return worker;
    }

    private int workHours(String line) {
        String[] pieces = line.split(SEPARATION_SIGN);
        int workHours = Integer.parseInt(pieces[HOURS_INDEX]);
        return workHours;
    }
}
