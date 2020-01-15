package korbas.runs;

import korbas.runs.entity.Run;
import korbas.runs.repository.RunRepository;
import korbas.runs.service.RunService;

import java.util.List;

public class App {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<Run> allRuns = new RunService().getAllRuns();
        System.out.println(        allRuns.toString()
        );
    }
}
