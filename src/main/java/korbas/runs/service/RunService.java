package korbas.runs.service;

import korbas.runs.entity.Run;
import korbas.runs.repository.RunRepository;

import java.util.List;

public class RunService {

    public List<Run> getAllRuns(){
        return new RunRepository().getAllRuns();
    }
}
