package korbas.runs.domain;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TableData {
    private final List<String> labels;
    private final List<List<String>> rows;

    public TableData(List<String> labels, List<List<String>> rows) {
        this.labels =  new ArrayList<>(labels);
        this.rows = new ArrayList<>(rows);
    }

    public List<String> getLabels() {
        return new ArrayList<>(labels);
    }

    public List<List<String>> getRows() {
        return new ArrayList<>(rows);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("TableData").append("\n");
        labels.forEach(label -> sb.append(label).append("\t"));
        sb.append("\n");
        rows.forEach(row -> {
            row.forEach( data -> sb.append(data).append("\t"));
            sb.append("\n");
        }
        );
        return sb.toString();
    }
}
