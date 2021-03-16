package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WorkHours {
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
        String[] pieces = line.split(",");
        String name = pieces[0];
        int workHours = Integer.parseInt(pieces[1]);
        String workDate = pieces[2];
        Worker worker = new Worker(name, workHours, workDate);
        return worker;
    }

    private int workHours(String line) {
        String[] pieces = line.split(",");
        int workHours = Integer.parseInt(pieces[1]);
        return workHours;
    }
}
